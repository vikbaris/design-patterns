package behavioral.visitor2;

public class Manager implements Employee {
    private String name;
    private double salary;
    private int workingDays;
    private int teamSize;

    public Manager(String name, double salary, int workingDays, int teamSize) {
        this.name = name;
        this.salary = salary;
        this.workingDays = workingDays;
        this.teamSize = teamSize;
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

    public int getTeamSize() {
        return teamSize;
    }
}
