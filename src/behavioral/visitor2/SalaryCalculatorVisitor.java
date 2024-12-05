package behavioral.visitor2;

public class SalaryCalculatorVisitor implements EmployeeVisitor {
    @Override
    public void visit(Developer developer) {
        // Maaş hesaplama: Temel maaş + (Fazla mesai saati * Saatlik ücret)
        double overtimeRate = 100.0; // Saat başı fazla mesai ücreti
        double totalSalary = developer.getSalary() + 
                           (developer.getOvertimeHours() * overtimeRate);
        
        System.out.println("Developer " + developer.getName() + 
                         "'s total salary: $" + totalSalary);
    }

    @Override
    public void visit(Manager manager) {
        // Maaş hesaplama: Temel maaş + (Takım büyüklüğü * Bonus)
        double teamBonus = 500.0; // Her takım üyesi için bonus
        double totalSalary = manager.getSalary() + 
                           (manager.getTeamSize() * teamBonus);
        
        System.out.println("Manager " + manager.getName() + 
                         "'s total salary: $" + totalSalary);
    }
}
