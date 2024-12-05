package creational.factoryPattern;

public abstract class CoffeeFactory {
    // Template method - kahve siparişinin genel akışını tanımlar
    public final Coffee orderCoffee() {
        Coffee coffee = createCoffee();
        prepareCoffee(coffee);
        return coffee;
    }

    // Factory method - alt sınıflar tarafından implement edilecek
    protected abstract Coffee createCoffee();

    // Hook method - alt sınıflar override edebilir
    protected void prepareCoffee(Coffee coffee) {
        coffee.prepare();
        coffee.brew();
        coffee.addCondiments();
    }
}

// Concrete Factory sınıfları
class EspressoFactory extends CoffeeFactory {
    @Override
    protected Coffee createCoffee() {
        return new Espresso();
    }
}

class LatteFactory extends CoffeeFactory {
    @Override
    protected Coffee createCoffee() {
        return new Latte();
    }
}

class CappuccinoFactory extends CoffeeFactory {
    @Override
    protected Coffee createCoffee() {
        return new Cappuccino();
    }
}
