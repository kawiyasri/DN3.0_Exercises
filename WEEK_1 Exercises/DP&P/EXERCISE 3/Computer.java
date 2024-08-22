public class Computer {
    // Attributes of the Computer class
    private final String CPU;
    private final String RAM;
    private final String storage;
    private final boolean hasGraphicsCard;
    private final boolean hasWiFi;
    private final boolean hasBluetooth;

    // Private constructor that is used by the Builder class
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.hasGraphicsCard = builder.hasGraphicsCard;
        this.hasWiFi = builder.hasWiFi;
        this.hasBluetooth = builder.hasBluetooth;
    }

    // Getters for the attributes
    public String getCPU() {
        return CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public String getStorage() {
        return storage;
    }

    public boolean hasGraphicsCard() {
        return hasGraphicsCard;
    }

    public boolean hasWiFi() {
        return hasWiFi;
    }

    public boolean hasBluetooth() {
        return hasBluetooth;
    }

    // Static nested Builder class
    public static class Builder {
        // Required attributes
        private final String CPU;
        private final String RAM;

        // Optional attributes
        private String storage = "256GB SSD"; // Default value
        private boolean hasGraphicsCard = false;
        private boolean hasWiFi = true; // Default value
        private boolean hasBluetooth = false;

        // Builder constructor with required attributes
        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        // Methods to set optional attributes
        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(boolean hasGraphicsCard) {
            this.hasGraphicsCard = hasGraphicsCard;
            return this;
        }

        public Builder setWiFi(boolean hasWiFi) {
            this.hasWiFi = hasWiFi;
            return this;
        }

        public Builder setBluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        // Build method to return the final Computer object
        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", storage='" + storage + '\'' +
                ", hasGraphicsCard=" + hasGraphicsCard +
                ", hasWiFi=" + hasWiFi +
                ", hasBluetooth=" + hasBluetooth +
                '}';
    }
}
