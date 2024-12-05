package behavioral.visitor;

public interface Item {
    int accept(ShoppingCartVisitor visitor);
}
