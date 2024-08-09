import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create an array of products
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Tablet", "Electronics"),
            new Product(4, "Headphones", "Accessories"),
            new Product(5, "Charger", "Accessories")
        };

        // Test linear search
        Product foundProduct = LinearSearch.linearSearch(products, 3);
        if (foundProduct != null) {
            System.out.println("Linear Search: " + foundProduct);
        } else {
            System.out.println("Linear Search: Product not found.");
        }

        // Sort products array by productId for binary search
        Arrays.sort(products, (p1, p2) -> Integer.compare(p1.getProductId(), p2.getProductId()));

        // Test binary search
        foundProduct = BinarySearch.binarySearch(products, 3);
        if (foundProduct != null) {
            System.out.println("Binary Search: " + foundProduct);
        } else {
            System.out.println("Binary Search: Product not found.");
        }
    }
}
