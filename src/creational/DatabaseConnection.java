package creational;

// Product Interface
public interface DatabaseConnection {
    void connect();
    void disconnect();
}

// Concrete Products
public class MySQLConnection implements DatabaseConnection {
    @Override
    public void connect() {
        System.out.println("Connecting to MySQL Database...");
        // MySQL bağlantı kodları (JDBC kullanarak)
        // Örnek:
        // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnecting from MySQL Database...");
        // Bağlantıyı kapatma kodları
        // Örnek:
        // conn.close();
    }
}

public class PostgreSQLConnection implements DatabaseConnection {
    @Override
    public void connect() {
        System.out.println("Connecting to PostgreSQL Database...");
        // PostgreSQL bağlantı kodları (JDBC kullanarak)
        // Örnek:
        // Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db", "user", "password");
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnecting from PostgreSQL Database...");
        // Bağlantıyı kapatma kodları
        // Örnek:
        // conn.close();
    }
}

// Creator
public abstract class DatabaseFactory {
    public abstract DatabaseConnection createConnection();

    public void manageConnection() {
        DatabaseConnection connection = createConnection();
        connection.connect();
        // Veritabanı işlemleri burada yapılır
        connection.disconnect();
    }
}

// Concrete Creators
public class MySQLFactory extends DatabaseFactory {
    @Override
    public DatabaseConnection createConnection() {
        return new MySQLConnection();
    }
}

public class PostgreSQLFactory extends DatabaseFactory {
    @Override
    public DatabaseConnection createConnection() {
        return new PostgreSQLConnection();
    }
}

// Client Code
public class FactoryPatternDemo {
    public static void main(String[] args) {
        DatabaseFactory factory;

        // MySQL veritabanına bağlanma
        factory = new MySQLFactory();
        factory.manageConnection();
        // Çıktı:
        // Connecting to MySQL Database...
        // Disconnecting from MySQL Database...

        // PostgreSQL veritabanına bağlanma
        factory = new PostgreSQLFactory();
        factory.manageConnection();
        // Çıktı:
        // Connecting to PostgreSQL Database...
        // Disconnecting from PostgreSQL Database...
    }
}
