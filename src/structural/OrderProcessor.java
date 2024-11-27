package structural;

/* 
 Ne Zaman Decorator Kullanmalı:
- Cross-cutting concerns için (loglama, güvenlik, performans ölçümü)
- Opsiyonel özellikler için
- Runtime'da değişebilen davranışlar için
Ne Zaman Normal Metot Kullanmalı:
- Core business logic için
- Her zaman çalışması gereken işlemler için
- Basit ve değişmeyen işlemler için


Ne Zaman Hangisi Kullanılmalı: Decorator Kullanın:
- Nesne davranışını dinamik olarak değiştirmeniz gerekiyorsa
- Framework bağımsız olmak istiyorsanız
- Sıralı işlemler önemliyse
- Küçük ölçekli, özel çözümler için
AOP Kullanın:
- Tüm uygulama genelinde tekrar eden işlemler varsa
- Transaction yönetimi, güvenlik gibi cross-cutting concerns için
- Mevcut kodu değiştirme gerektiriyorsa
- Spring gibi bir framework kullanıyorsanız
*/

// Base interface
public interface OrderProcessor {
    void processOrder(Order order);
}

// Concrete component - Basic order processor
class BasicOrderProcessor implements OrderProcessor {
    @Override
    public void processOrder(Order order) {
        // Basic order processing logic
        System.out.println("Processing basic order: " + order.getId());
    }
}

// Abstract decorator
abstract class OrderProcessorDecorator implements OrderProcessor {
    protected final OrderProcessor processor;

    public OrderProcessorDecorator(OrderProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void processOrder(Order order) {
        processor.processOrder(order);
    }
}

// Security decorator
class SecurityDecorator extends OrderProcessorDecorator {
    private final SecurityService securityService;

    public SecurityDecorator(OrderProcessor processor, SecurityService securityService) {
        super(processor);
        this.securityService = securityService;
    }

    @Override
    public void processOrder(Order order) {
        if (securityService.validateSecurity(order)) {
            super.processOrder(order);
        } else {
            throw new SecurityException("Security validation failed for order: " + order.getId());
        }
    }
}

// Notification decorator
class NotificationDecorator extends OrderProcessorDecorator {
    private final NotificationService notificationService;

    public NotificationDecorator(OrderProcessor processor, NotificationService notificationService) {
        super(processor);
        this.notificationService = notificationService;
    }

    @Override
    public void processOrder(Order order) {
        super.processOrder(order);
        notificationService.notify("Order processed: " + order.getId());
    }
}

// Monitoring decorator
class MonitoringDecorator extends OrderProcessorDecorator {
    private final MetricService metricService;
    private final LogService logService;

    public MonitoringDecorator(OrderProcessor processor, MetricService metricService, LogService logService) {
        super(processor);
        this.metricService = metricService;
        this.logService = logService;
    }

    @Override
    public void processOrder(Order order) {
        long startTime = System.currentTimeMillis();
        logService.log("Starting order processing: " + order.getId());
        
        try {
            super.processOrder(order);
            logService.log("Successfully processed order: " + order.getId());
        } catch (Exception e) {
            logService.log("Error processing order: " + order.getId() + ", Error: " + e.getMessage());
            throw e;
        } finally {
            long duration = System.currentTimeMillis() - startTime;
            metricService.recordTiming("order_processing_time", duration);
        }
    }
}

// Usage example
class DecoratorPattern {
    public static void main(String[] args) {
        // Services initialization
        SecurityService securityService = new SecurityService();
        NotificationService notificationService = new NotificationService();
        MetricService metricService = new MetricService();
        LogService logService = new LogService();

        // Create the processor with decorators
        // Note: Security checks first, then notifications, and monitoring wraps everything
        OrderProcessor processor = new MonitoringDecorator(
            new NotificationDecorator(
                new SecurityDecorator(
                    new BasicOrderProcessor(),
                    securityService
                ),
                notificationService
            ),
            metricService,
            logService
        );

        // Process an order
        Order order = new Order("12345");
        processor.processOrder(order);
    }
}

// Supporting classes (would typically be in separate files)
class Order {
    private final String id;

    public Order(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

class SecurityService {
    public boolean validateSecurity(Order order) {
        // Security validation logic
        return true;
    }
}

class NotificationService {
    public void notify(String message) {
        System.out.println("Notification: " + message);
    }
}

class MetricService {
    public void recordTiming(String metric, long duration) {
        System.out.println("Metric - " + metric + ": " + duration + "ms");
    }
}

class LogService {
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}