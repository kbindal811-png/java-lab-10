import java.util.Vector;

public class q7 {
    static class Customer {
        private int id;
        private String name;
        private String email;

        public Customer(int id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }

    static class CustomerManager {
        private final Vector<Customer> customers = new Vector<>();

        public void addCustomer(Customer c) { customers.add(c); }

        public void displayAll() {
            System.out.println("--- Customers ---");
            for (Customer c : customers) {
                System.out.println("ID: " + c.getId() + ", Name: " + c.getName() + ", Email: " + c.getEmail());
            }
        }
    }

    public static void main(String[] args) {
        CustomerManager manager = new CustomerManager();
        Customer c1 = new Customer(1, "Meera", "meera@example.com");
        manager.addCustomer(c1);
        manager.addCustomer(new Customer(2, "Sameer", "sameer@example.com"));
        manager.addCustomer(new Customer(3, "Tanya", "tanya@example.com"));
        manager.displayAll();

        c1.setEmail("meera.new@example.com");   // updating through a setter
        System.out.println("\nAfter updating Meera's email:");
        manager.displayAll();
    }
}
