package behavioral.visitor2;

public interface Employee {
    void accept(EmployeeVisitor visitor);
    String getName();
    double getSalary();
    int getWorkingDays();
}
