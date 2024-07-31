public class Logger {
    // Step 1: Create a private static instance of Logger
    private static Logger instance;
    
    // Step 2: Private constructor to prevent instantiation
    private Logger() {
        // Private constructor to prevent instantiation from other classes
    }

    // Step 3: Provide a public static method to get the instance
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Sample method for demonstration
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
