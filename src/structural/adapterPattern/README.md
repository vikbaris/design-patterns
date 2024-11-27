Adapter Tasarım Deseni, farklı arayüzlere sahip sınıfların birlikte çalışabilmesini sağlayan yapısal bir tasarım desenidir. Bu desen, mevcut bir sınıfın kodunu değiştirmeden, başka bir arayüzle uyumlu hale getirmenize olanak sağlar.

Üçüncü Parti Kütüphaneler ile Entegrasyon: Örneğimizdeki gibi PayPal, Stripe gibi farklı ödeme sistemleriyle çalışırken
Legacy Sistemlerle Entegrasyon: Eski sistemleri yeni sistemlere entegre ederken
Değişken API'ler: Sürekli değişebilen API'lerle çalışırken
Çoklu Platform Desteği: Farklı platformlar için aynı işlevselliği sağlarken


# Adapter Pattern Implementation - Payment Processing System

## Overview
This package demonstrates the Adapter Pattern through a payment processing system that integrates PayPal with an existing payment service infrastructure.

## Components

### 1. PaymentService (Target Interface)
- Defines the standard payment processing interface that our application expects
- Contains methods for processing payments and checking payment status

### 2. PaymentProcessor (Client)
- Uses the PaymentService interface to process payments
- Works with any payment service that implements the PaymentService interface

### 3. PayPalAPI (Adaptee)
- Third-party PayPal payment processing system
- Has its own interface and methods that are incompatible with our PaymentService

### 4. PayPalAdapter (Adapter)
- Adapts PayPalAPI to work with our PaymentService interface
- Translates calls from PaymentService interface to appropriate PayPalAPI calls
- Handles any necessary data conversion between the two systems

## Class Diagram
```
+----------------+     +-----------------+
|PaymentService  |     |   PayPalAPI    |
|   (Interface)  |     |   (Adaptee)    |
+----------------+     +-----------------+
        ^                      ^
        |                      |
        |                      |
+----------------+     +-----------------+
|PaymentProcessor|     | PayPalAdapter   |
|    (Client)    |---->|   (Adapter)    |
+----------------+     +-----------------+
```

## Usage
The Adapter Pattern allows our payment processing system to:
1. Use PayPal's payment system without modifying existing code
2. Keep the payment processing logic decoupled from specific payment providers
3. Easily add new payment providers by creating new adapters

## Benefits
- Enables integration of incompatible interfaces
- Promotes code reusability
- Maintains single responsibility principle
- Makes the system more flexible and maintainable

## Example Usage
```java
// Create PayPal adapter
PaymentService paypalPayment = new PayPalAdapter(new PayPalAPI());

// Process payment using the adapter
paypalPayment.processPayment(100.00, "USD", "customer@email.com");

// Check payment status
paypalPayment.checkPaymentStatus("payment123");
```



