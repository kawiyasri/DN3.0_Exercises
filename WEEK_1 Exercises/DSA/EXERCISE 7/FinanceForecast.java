public class FinanceForecast {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base case: no more periods left
        if (periods == 0) {
            return presentValue;
        }
        // Recursive case: calculate value for one period less
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }
}
