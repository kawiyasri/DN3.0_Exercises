public class Main {
    public static void main(String[] args) {
        // Create instances of third-party payment gateways
        PaypalPaymentGateway paypal = new PaypalPaymentGateway();
        StripePaymentGateway stripe = new StripePaymentGateway();

        // Create adapters for these payment gateways
        PaymentProcessor paypalAdapter = new PaypalAdapter(paypal);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripe);

        // Process payments using the adapters
        System.out.println("Using PayPal Adapter:");
        paypalAdapter.processPayment(150.75);

        System.out.println("Using Stripe Adapter:");
        stripeAdapter.processPayment(200.50);
    }
}
