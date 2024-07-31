public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        // Using Credit Card Payment
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        paymentContext.setPaymentStrategy(creditCardPayment);
        System.out.println("Paying with Credit Card:");
        paymentContext.executePayment(100);
        System.out.println();

        // Using PayPal Payment
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com");
        paymentContext.setPaymentStrategy(payPalPayment);
        System.out.println("Paying with PayPal:");
        paymentContext.executePayment(200);
    }
}

