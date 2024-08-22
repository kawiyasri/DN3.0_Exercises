public class WebApp implements Observer {
    @Override
    public void update(String stockName, float price) {
        System.out.println("Web App: Stock " + stockName + " has new price: $" + price);
    }
}
