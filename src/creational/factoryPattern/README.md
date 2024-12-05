# Coffee Shop Factory Pattern Implementation

This project demonstrates the Factory Pattern implementation in a coffee shop context. The Factory Pattern is a creational design pattern that provides an interface for creating objects but allows subclasses to alter the type of objects that will be created.

## Project Structure

- `Coffee.java`: Interface defining the contract for all coffee types
- `CoffeeFactory.java`: Abstract factory class implementing the template method pattern
- `EspressoFactory.java`, `LatteFactory.java`, `CappuccinoFactory.java`: Concrete factory classes
- `Espresso.java`, `Latte.java`, `Cappuccino.java`: Concrete coffee classes
- `CoffeeShop.java`: Client class demonstrating the usage

## Design Pattern Features

### Template Method Pattern
The `CoffeeFactory` class implements the template method pattern with:
- Template method: `orderCoffee()`
- Factory method: `createCoffee()`
- Hook method: `prepareCoffee()`

### Factory Method Pattern
Each concrete factory (`EspressoFactory`, `LatteFactory`, `CappuccinoFactory`) implements the `createCoffee()` method to create specific coffee types.

## How It Works

1. The client (`CoffeeShop`) creates a specific coffee factory
2. The factory's `orderCoffee()` method is called
3. The factory creates the appropriate coffee type
4. The coffee is prepared following the template method pattern
5. The prepared coffee is returned to the client

## Usage Example

```java
CoffeeFactory espressoFactory = new EspressoFactory();
Coffee espresso = espressoFactory.orderCoffee();
System.out.println("Price: " + espresso.getPrice() + " TL");
System.out.println("Description: " + espresso.getDescription());
```

## Benefits

- Encapsulates object creation logic
- Provides flexibility to add new coffee types without modifying existing code
- Ensures consistent coffee preparation process through template method pattern
- Promotes loose coupling between coffee creation and coffee usage
