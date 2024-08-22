public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public String findCustomerById(int id) {
        // Simulating a database lookup
        if (id == 1) {
            return "John Doe";
        } else if (id == 2) {
            return "Jane Smith";
        } else {
            return "Customer Not Found";
        }
    }
}
