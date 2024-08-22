public class ObserverPatternTest {
    public static void main(String[] args) {
        // Create stock market and observers
        StockMarket stockMarket = new StockMarket("AAPL", 150.00f);
        MobileApp mobileApp = new MobileApp();
        WebApp webApp = new WebApp();

        // Register observers
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Update stock price and notify observers
        System.out.println("Updating stock price to $155.00");
        stockMarket.setPrice(155.00f);
        System.out.println();

        // Deregister mobile app and update stock price again
        stockMarket.deregisterObserver(mobileApp);
        System.out.println("Updating stock price to $160.00");
        stockMarket.setPrice(160.00f);
    }
}
