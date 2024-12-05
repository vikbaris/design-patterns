package behavioral.visitor2;

public class Developer implements Employee {
    private String name;
    private double salary;
    private int workingDays;
    private int overtimeHours;

    public Developer(String name, double salary, int workingDays, int overtimeHours) {
        this.name = name;
        this.salary = salary;
        this.workingDays = workingDays;
        this.overtimeHours = overtimeHours;
    }

    @Override
    public void accept(EmployeeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public int getWorkingDays() {
        return workingDays;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }
}
