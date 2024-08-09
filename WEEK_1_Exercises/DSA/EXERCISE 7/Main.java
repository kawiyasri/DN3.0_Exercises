public class Main {
    public static void main(String[] args) {
        double presentValue = 1000.0; // Example initial value
        double growthRate = 0.05; // Example growth rate (5%)
        int periods = 10; // Example number of periods (years)

        // Calculate future value using the recursive method
        double futureValue = FinanceForecast.calculateFutureValue(presentValue, growthRate, periods);

        // Output the result
        System.out.printf("The future value of the investment is: $%.2f%n", futureValue);
    }
}
