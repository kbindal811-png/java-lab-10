import java.util.TreeSet;

public class q4 {
    static class Product implements Comparable<Product> {
        private int id;
        private String name;
        private double price;

        public Product() { }

        public Product(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public double getPrice() { return price; }

        // Sort by price; break ties by id so equal-priced products are not dropped by the TreeSet
        @Override
        public int compareTo(Product other) {
            int result = Double.compare(this.price, other.price);
            return result != 0 ? result : Integer.compare(this.id, other.id);
        }

        public void display() {
            System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price);
        }
    }

    static class ProductCatalog {
        private final TreeSet<Product> products = new TreeSet<>();

        public void addProduct(Product p) { products.add(p); }

        public void displaySorted() {
            System.out.println("--- Products sorted by price ---");
            for (Product p : products) p.display();
        }
    }

    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(new Product(1, "Laptop", 55000));
        catalog.addProduct(new Product(2, "Mouse", 499.99));
        catalog.addProduct(new Product(3, "Keyboard", 1299));
        catalog.addProduct(new Product(4, "Monitor", 9500));
        catalog.addProduct(new Product(5, "USB Cable", 149));
        catalog.displaySorted();
    }
}
