package structural;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

// Dosya okuma/yazma için ana interface
public interface FileService {
    String readFile(String userId, String filePath);
    void writeFile(String userId, String filePath, String content);
}

// Gerçek dosya servisi implementasyonu
public class RealFileService implements FileService {
    private static final Logger logger = Logger.getLogger(RealFileService.class.getName());

    @Override
    public String readFile(String userId, String filePath) {
        // Gerçek dosya okuma işlemi
        logger.info("Dosya okunuyor: " + filePath);
        return "Dosya içeriği: " + filePath;
    }

    @Override
    public void writeFile(String userId, String filePath, String content) {
        // Gerçek dosya yazma işlemi
        logger.info("Dosyaya yazılıyor: " + filePath);
        System.out.println("Dosya başarıyla yazıldı: " + filePath);
    }
}

// Proxy sınıfı
public class SecureFileServiceProxy implements FileService {
    private final RealFileService realFileService;
    private final Map<String, UserRole> userRoles;
    private static final Logger logger = Logger.getLogger(SecureFileServiceProxy.class.getName());

    // Kullanıcı rolleri enum'u
    public enum UserRole {
        ADMIN,       // Tüm dosyalara tam erişim
        DEVELOPER,   // Belirli dizinlere yazma/okuma
        VIEWER       // Sadece okuma erişimi
    }

    // Kullanıcı ve rol tanımlamaları
    public SecureFileServiceProxy() {
        this.realFileService = new RealFileService();
        this.userRoles = new HashMap<>();
        
        // Örnek kullanıcı rolleri
        userRoles.put("admin_user", UserRole.ADMIN);
        userRoles.put("dev_user", UserRole.DEVELOPER);
        userRoles.put("view_user", UserRole.VIEWER);
    }

    // Kullanıcı erişim kontrolü metodu
    private boolean hasReadAccess(String userId, String filePath) {
        UserRole userRole = userRoles.get(userId);
        if (userRole == null) {
            logger.warning("Yetkisiz kullanıcı erişim girişimi: " + userId);
            return false;
        }

        // Güvenlik kontrolleri
        boolean isSystemFile = filePath.contains("system");
        return userRole == UserRole.ADMIN || 
               (userRole == UserRole.DEVELOPER && !isSystemFile) || 
               (userRole == UserRole.VIEWER && !filePath.contains("sensitive"));
    }

    // Kullanıcı yazma erişim kontrolü
    private boolean hasWriteAccess(String userId, String filePath) {
        UserRole userRole = userRoles.get(userId);
        if (userRole == null) {
            logger.warning("Yetkisiz kullanıcı yazma girişimi: " + userId);
            return false;
        }

        return userRole == UserRole.ADMIN || 
               (userRole == UserRole.DEVELOPER && !filePath.contains("system"));
    }

    @Override
    public String readFile(String userId, String filePath) {
        // Okuma erişim kontrolü
        if (!hasReadAccess(userId, filePath)) {
            logger.severe("Dosya okuma yetkisi reddedildi - Kullanıcı: " + userId);
            throw new SecurityException("Dosya okuma yetkisi yok");
        }

        // Performans ve güvenlik loglaması
        long startTime = System.currentTimeMillis();
        String content = realFileService.readFile(userId, filePath);
        long endTime = System.currentTimeMillis();

        logger.info(String.format(
            "Dosya Okuma - Kullanıcı: %s, Dosya: %s, Süre: %d ms", 
            userId, filePath, (endTime - startTime)
        ));

        return content;
    }

    @Override
    public void writeFile(String userId, String filePath, String content) {
        // Yazma erişim kontrolü
        if (!hasWriteAccess(userId, filePath)) {
            logger.severe("Dosya yazma yetkisi reddedildi - Kullanıcı: " + userId);
            throw new SecurityException("Dosya yazma yetkisi yok");
        }

        // Performans ve güvenlik loglaması
        long startTime = System.currentTimeMillis();
        realFileService.writeFile(userId, filePath, content);
        long endTime = System.currentTimeMillis();

        logger.info(String.format(
            "Dosya Yazma - Kullanıcı: %s, Dosya: %s, Süre: %d ms", 
            userId, filePath, (endTime - startTime)
        ));
    }
}

// Kullanım Örneği
public class ProxyPattern {
    public static void main(String[] args) {
        SecureFileServiceProxy fileService = new SecureFileServiceProxy();

        try {
            // Admin kullanıcı tüm dosyalara erişebilir
            String adminContent = fileService.readFile("admin_user", "/system/config.xml");
            System.out.println("Admin Erişimi: " + adminContent);

            // Geliştirici kullanıcı sistem dosyaları dışındaki dosyalara erişebilir
            String devContent = fileService.readFile("dev_user", "/projects/source.java");
            System.out.println("Geliştirici Erişimi: " + devContent);

            // Görüntüleyici kullanıcı sadece sınırlı dosyalara erişebilir
            String viewContent = fileService.readFile("view_user", "/public/readme.txt");
            System.out.println("Görüntüleyici Erişimi: " + viewContent);

        } catch (SecurityException e) {
            System.err.println("Güvenlik hatası: " + e.getMessage());
        }
    }
}