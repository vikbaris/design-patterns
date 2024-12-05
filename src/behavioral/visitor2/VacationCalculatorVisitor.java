package behavioral.visitor2;

public class VacationCalculatorVisitor implements EmployeeVisitor {
    @Override
    public void visit(Developer developer) {
        // İzin hesaplama: Temel izin + Fazla mesai karşılığı izin
        int baseVacation = 14; // Temel izin günü
        int overtimeVacation = developer.getOvertimeHours() / 10; // Her 10 saat fazla mesai için 1 gün izin
        int totalVacation = baseVacation + overtimeVacation;
        
        System.out.println("Developer " + developer.getName() + 
                         " has " + totalVacation + " vacation days");
    }

    @Override
    public void visit(Manager manager) {
        // İzin hesaplama: Temel izin + Takım yönetimi karşılığı izin
        int baseVacation = 14; // Temel izin günü
        int teamBonus = manager.getTeamSize() / 2; // Her 2 takım üyesi için 1 gün ekstra izin
        int totalVacation = baseVacation + teamBonus;
        
        System.out.println("Manager " + manager.getName() + 
                         " has " + totalVacation + " vacation days");
    }
}
