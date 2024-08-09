public class Main {
    public static void main(String[] args) {
        // Create an array of orders
        Order[] orders = {
            new Order(1, "Alice", 150.00),
            new Order(2, "Bob", 200.00),
            new Order(3, "Charlie", 100.00),
            new Order(4, "Diana", 250.00),
            new Order(5, "Eve", 50.00)
        };

        // Display orders before sorting
        System.out.println("Orders before sorting:");
        displayOrders(orders);

        // Sort using Bubble Sort
        BubbleSort.bubbleSort(orders);
        System.out.println("\nOrders after Bubble Sort:");
        displayOrders(orders);

        // Reinitialize the orders array
        orders = new Order[] {
            new Order(1, "Alice", 150.00),
            new Order(2, "Bob", 200.00),
            new Order(3, "Charlie", 100.00),
            new Order(4, "Diana", 250.00),
            new Order(5, "Eve", 50.00)
        };

        // Sort using Quick Sort
        QuickSort.quickSort(orders, 0, orders.length - 1);
        System.out.println("\nOrders after Quick Sort:");
        displayOrders(orders);
    }

    // Method to display orders
    private static void displayOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
