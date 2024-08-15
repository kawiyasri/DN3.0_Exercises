public class Main {
    public static void main(String[] args) {
        // Create a high-end gaming computer
        Computer gamingComputer = new Computer.Builder("Intel Core i9", "32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard(true)
                .setWiFi(true)
                .setBluetooth(true)
                .build();

        // Create a basic office computer
        Computer officeComputer = new Computer.Builder("Intel Core i5", "8GB")
                .setStorage("512GB SSD")
                .setGraphicsCard(false)
                .setWiFi(true)
                .setBluetooth(false)
                .build();

        // Print details of both computers
        System.out.println("Gaming Computer: " + gamingComputer);
        System.out.println("Office Computer: " + officeComputer);
    }
}
