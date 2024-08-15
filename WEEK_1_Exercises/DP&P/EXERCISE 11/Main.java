
public class Main {
    public static void main(String[] args) {
        // Create an instance of CustomerRepositoryImpl
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject CustomerRepository into CustomerService
        CustomerService customerService = new CustomerService(customerRepository);

        // Use CustomerService to find customers
        System.out.println("Customer with ID 1: " + customerService.getCustomerName(1));
        System.out.println("Customer with ID 2: " + customerService.getCustomerName(2));
        System.out.println("Customer with ID 3: " + customerService.getCustomerName(3));
    }
}
