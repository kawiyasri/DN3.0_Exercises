public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        // Add employees
        ems.addEmployee(new Employee(1, "John Doe", "Developer", 80000));
        ems.addEmployee(new Employee(2, "Jane Smith", "Manager", 90000));
        ems.addEmployee(new Employee(3, "Emily Davis", "Analyst", 70000));

        // Display all employees
        System.out.println("All employees:");
        ems.traverseEmployees();

        // Search for an employee
        Employee e = ems.searchEmployee(2);
        if (e != null) {
            System.out.println("\nFound employee: " + e);
        } else {
            System.out.println("\nEmployee not found.");
        }

        // Delete an employee
        ems.deleteEmployee(2);
        System.out.println("\nEmployees after deletion:");
        ems.traverseEmployees();
    }
}
