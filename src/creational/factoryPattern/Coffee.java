package creational.factoryPattern;

public interface Coffee {
    void prepare();
    void brew();
    void addCondiments();
    double getPrice();
    String getDescription();
}
