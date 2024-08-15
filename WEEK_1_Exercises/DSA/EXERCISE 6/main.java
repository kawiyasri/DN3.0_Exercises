import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create some books
        Book[] books = {
            new Book(1, "The Catcher in the Rye", "J.D. Salinger"),
            new Book(2, "To Kill a Mockingbird", "Harper Lee"),
            new Book(3, "1984", "George Orwell"),
            new Book(4, "Pride and Prejudice", "Jane Austen"),
            new Book(5, "The Great Gatsby", "F. Scott Fitzgerald")
        };

        // Test Linear Search
        Book foundBook = LinearSearch.linearSearch(books, "1984");
        if (foundBook != null) {
            System.out.println("Linear Search: " + foundBook);
        } else {
            System.out.println("Linear Search: Book not found.");
        }

        // Sort books by title for Binary Search
        Arrays.sort(books, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));

        // Test Binary Search
        foundBook = BinarySearch.binarySearch(books, "1984");
        if (foundBook != null) {
            System.out.println("Binary Search: " + foundBook);
        } else {
            System.out.println("Binary Search: Book not found.");
        }
    }
}
