package behavioral.visitor2;

import java.util.ArrayList;
import java.util.List;

public class VisitorDemo2 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        
        // Çalışanları oluştur
        employees.add(new Developer("John Doe", 5000, 220, 30));  // 30 saat fazla mesai
        employees.add(new Developer("Jane Smith", 6000, 220, 20)); // 20 saat fazla mesai
        employees.add(new Manager("Mike Johnson", 8000, 220, 5));  // 5 kişilik takım
        employees.add(new Manager("Sarah Wilson", 9000, 220, 8));  // 8 kişilik takım

        // Maaş hesaplama ziyaretçisi
        System.out.println("Calculating Salaries:");
        EmployeeVisitor salaryCalculator = new SalaryCalculatorVisitor();
        for (Employee employee : employees) {
            employee.accept(salaryCalculator);
        }

        System.out.println("\nCalculating Vacation Days:");
        // İzin hesaplama ziyaretçisi
        EmployeeVisitor vacationCalculator = new VacationCalculatorVisitor();
        for (Employee employee : employees) {
            employee.accept(vacationCalculator);
        }
    }
}
