public class PaypalAdapter implements PaymentProcessor {
    private PaypalPaymentGateway paypalPaymentGateway;

    public PaypalAdapter(PaypalPaymentGateway paypalPaymentGateway) {
        this.paypalPaymentGateway = paypalPaymentGateway;
    }

    @Override
    public void processPayment(double amount) {
        // Delegate to the PayPal specific method
        paypalPaymentGateway.makePayment(amount);
    }
}
