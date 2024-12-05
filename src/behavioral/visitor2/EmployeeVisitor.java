package behavioral.visitor2;

public interface EmployeeVisitor {
    void visit(Developer developer);
    void visit(Manager manager);
}
