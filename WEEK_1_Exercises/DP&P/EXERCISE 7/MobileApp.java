public class MobileApp implements Observer {
    @Override
    public void update(String stockName, float price) {
        System.out.println("Mobile App: Stock " + stockName + " has new price: $" + price);
    }
}
