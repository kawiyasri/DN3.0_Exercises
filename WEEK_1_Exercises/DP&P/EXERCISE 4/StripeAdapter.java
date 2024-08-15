public class StripeAdapter implements PaymentProcessor {
    private StripePaymentGateway stripePaymentGateway;

    public StripeAdapter(StripePaymentGateway stripePaymentGateway) {
        this.stripePaymentGateway = stripePaymentGateway;
    }

    @Override
    public void processPayment(double amount) {
        // Delegate to the Stripe specific method
        stripePaymentGateway.charge(amount);
    }
}
