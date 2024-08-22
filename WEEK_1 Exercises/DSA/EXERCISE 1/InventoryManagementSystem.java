import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {
    private Map<Integer, Product> inventory;

    // Constructor
    public InventoryManagementSystem() {
        this.inventory = new HashMap<>();
    }

    // Add a new product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    // Update an existing product
    public void updateProduct(int productId, Product updatedProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, updatedProduct);
        } else {
            System.out.println("Product with ID " + productId + " does not exist.");
        }
    }

    // Delete a product
    public void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product with ID " + productId + " does not exist.");
        }
    }

    // Retrieve a product
    public Product getProduct(int productId) {
        return inventory.get(productId);
    }

    // Display all products
    public void displayAllProducts() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        // Create some products
        Product p1 = new Product(1, "Laptop", 10, 999.99);
        Product p2 = new Product(2, "Smartphone", 25, 499.99);

        // Add products to the inventory
        ims.addProduct(p1);
        ims.addProduct(p2);

        // Display all products
        System.out.println("All products:");
        ims.displayAllProducts();

        // Update a product
        Product p1Updated = new Product(1, "Laptop", 8, 949.99);
        ims.updateProduct(1, p1Updated);

        // Display all products after update
        System.out.println("\nAll products after update:");
        ims.displayAllProducts();

        // Delete a product
        ims.deleteProduct(2);

        // Display all products after deletion
        System.out.println("\nAll products after deletion:");
        ims.displayAllProducts();
    }
}
