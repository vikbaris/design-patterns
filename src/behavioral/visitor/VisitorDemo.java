package behavioral.visitor;

public class VisitorDemo {
    public static void main(String[] args) {
        Item[] items = new Item[]{
            new Book(20, "1234"),
            new Book(100, "5678"),
            new Fruit(10, 2, "Banana"),
            new Fruit(5, 5, "Apple")
        };

        int total = calculatePrice(items);
        System.out.println("Total Cost = " + total);
    }

    private static int calculatePrice(Item[] items) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum = 0;
        for (Item item : items) {
            sum += item.accept(visitor);
        }
        return sum;
    }
}
