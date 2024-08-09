public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // First time displaying image1, it should load and display
        image1.display();
        System.out.println();

        // Second time displaying image1, it should just display
        image1.display();
        System.out.println();

        // First time displaying image2, it should load and display
        image2.display();
        System.out.println();

        // Second time displaying image2, it should just display
        image2.display();
    }
