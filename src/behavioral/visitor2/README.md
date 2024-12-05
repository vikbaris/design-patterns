# Employee Management System - Visitor Pattern Example

Bu örnek, Visitor Pattern'ı kullanarak bir şirketin çalışan yönetim sistemini simüle eder. Sistem, farklı türdeki çalışanlar için maaş ve izin hesaplamalarını gerçekleştirir.

## Proje Yapısı

### 1. Element Interface ve Concrete Elements

- **Employee (Interface)**
  - Tüm çalışan türleri için temel arayüz
  - Visitor'ı kabul eden `accept()` metodunu tanımlar

- **Developer (Concrete Element)**
  - Yazılım geliştiricileri temsil eder
  - Fazla mesai saatleri özelliğine sahip

- **Manager (Concrete Element)**
  - Yöneticileri temsil eder
  - Takım büyüklüğü özelliğine sahip

### 2. Visitor Interface ve Concrete Visitors

- **EmployeeVisitor (Interface)**
  - Her çalışan türü için visit metodlarını tanımlar

- **SalaryCalculatorVisitor**
  - Farklı çalışan türleri için maaş hesaplama mantığını içerir
  - Geliştiriciler için fazla mesai ücreti hesaplar
  - Yöneticiler için takım büyüklüğüne göre bonus hesaplar

- **VacationCalculatorVisitor**
  - Farklı çalışan türleri için izin günü hesaplama mantığını içerir
  - Geliştiriciler için fazla mesaiye göre ek izin hesaplar
  - Yöneticiler için takım büyüklüğüne göre ek izin hesaplar

## Hesaplama Mantığı

### Maaş Hesaplama
1. **Geliştiriciler için:**
   - Temel Maaş + (Fazla Mesai Saati × Saatlik Ücret)
   - Saatlik fazla mesai ücreti: $100

2. **Yöneticiler için:**
   - Temel Maaş + (Takım Büyüklüğü × Takım Bonus)
   - Kişi başı takım bonus: $500

### İzin Hesaplama
1. **Geliştiriciler için:**
   - Temel İzin + Fazla Mesai İzni
   - Her 10 saat fazla mesai için 1 gün ek izin

2. **Yöneticiler için:**
   - Temel İzin + Takım Yönetimi İzni
   - Her 2 takım üyesi için 1 gün ek izin

## Kullanım Örneği

```java
List<Employee> employees = new ArrayList<>();
employees.add(new Developer("John Doe", 5000, 220, 30));
employees.add(new Manager("Mike Johnson", 8000, 220, 5));

EmployeeVisitor salaryCalculator = new SalaryCalculatorVisitor();
EmployeeVisitor vacationCalculator = new VacationCalculatorVisitor();

// Maaş hesaplama
for (Employee employee : employees) {
    employee.accept(salaryCalculator);
}

// İzin hesaplama
for (Employee employee : employees) {
    employee.accept(vacationCalculator);
}
```

## Avantajları

1. Yeni hesaplama türleri eklemek kolaydır (örn: PerformanceCalculatorVisitor)
2. Her hesaplama mantığı kendi sınıfında izole edilmiştir
3. Çalışan türleri ve hesaplama mantıkları birbirinden ayrılmıştır

## Gerçek Hayat Uygulamaları

- İnsan Kaynakları Sistemleri
- Bordro Sistemleri
- Performans Değerlendirme Sistemleri
- İzin Yönetim Sistemleri
