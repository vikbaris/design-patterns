package compositePattern;

import java.util.ArrayList;
import java.util.List;

// Component Interface
interface Employee {
    String getName();
    String getPosition();
    double getSalary();
    void printDetails();
    void addSubordinate(Employee employee);
    void removeSubordinate(Employee employee);
    List<Employee> getSubordinates();
}

// Leaf Sınıfı - Bireysel Çalışan
class IndividualEmployee implements Employee {
    private String name;
    private String position;
    private double salary;

    public IndividualEmployee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void printDetails() {
        System.out.println("Çalışan: " + name + 
                           " - Pozisyon: " + position + 
                           " - Maaş: " + salary + " TL");
    }

    @Override
    public void addSubordinate(Employee employee) {
        throw new UnsupportedOperationException("Bireysel çalışanlara ast eklenemez");
    }

    @Override
    public void removeSubordinate(Employee employee) {
        throw new UnsupportedOperationException("Bireysel çalışanlardan ast çıkarılamaz");
    }

    @Override
    public List<Employee> getSubordinates() {
        return new ArrayList<>(); // Boş liste
    }
}

// Composite Sınıfı - Yönetici
class Manager implements Employee {
    private String name;
    private String position;
    private double salary;
    private List<Employee> subordinates;

    public Manager(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.subordinates = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void printDetails() {
        System.out.println("Yönetici: " + name + 
                           " - Pozisyon: " + position + 
                           " - Maaş: " + salary + " TL");
        
        // Alt çalışanları da yazdır
        if (!subordinates.isEmpty()) {
            System.out.println("Alt Çalışanlar:");
            for (Employee employee : subordinates) {
                employee.printDetails();
            }
        }
    }

    @Override
    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }

    @Override
    public void removeSubordinate(Employee employee) {
        subordinates.remove(employee);
    }

    @Override
    public List<Employee> getSubordinates() {
        return subordinates;
    }

    // Ek metot: Toplam maaş hesaplama
    public double getTotalTeamSalary() {
        double totalSalary = this.salary;
        for (Employee employee : subordinates) {
            if (employee instanceof Manager) {
                totalSalary += ((Manager) employee).getTotalTeamSalary();
            } else {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }
}

// Kullanım Örneği
public class CompositePattern1   {
    public static void main(String[] args) {
        // Üst düzey yönetim
        Manager genelMudur = new Manager("Ahmet Yılmaz", "Genel Müdür", 25000);
        
        // Departman yöneticileri
        Manager yazilimMuduru = new Manager("Mehmet Demir", "Yazılım Müdürü", 15000);
        Manager insSaymani = new Manager("Ayşe Kaya", "İnsan Kaynakları Müdürü", 12000);
        
        // Bireysel çalışanlar
        IndividualEmployee yazilimGelistirici1 = new IndividualEmployee("Emre Şahin", "Yazılım Geliştirici", 8000);
        IndividualEmployee yazilimGelistirici2 = new IndividualEmployee("Elif Yılmaz", "Kıdemli Yazılım Geliştirici", 10000);
        IndividualEmployee insKaynaklariUzman = new IndividualEmployee("Fatma Öztürk", "İK Uzmanı", 7000);
        
        // Organizasyon yapısını oluşturma
        genelMudur.addSubordinate(yazilimMuduru);
        genelMudur.addSubordinate(insSaymani);
        
        yazilimMuduru.addSubordinate(yazilimGelistirici1);
        yazilimMuduru.addSubordinate(yazilimGelistirici2);
        
        insSaymani.addSubordinate(insKaynaklariUzman);
        
        // Organizasyon detaylarını yazdırma
        System.out.println("Organizasyon Yapısı:");
        genelMudur.printDetails();
        
        // Toplam maaş hesaplama
        System.out.println("\nToplam Takım Maliyeti: " + 
                           genelMudur.getTotalTeamSalary() + " TL");
    }
}