import java.util.*;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 1;
    }

    public Product(String name) {
        this.name = name;
        this.price = 0;
        this.quantity = 1;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}

class Order {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public double getTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice() * p.getQuantity();
        }
        return total;
    }

    public double getGrandTotal() {
        double total = getTotal();
        if (total >= 50000) {
            total -= total * 0.5;
        } else if (total > 10000) {
            total -= total * 0.1;
        }
        return total;
    }
}

public class ecomerse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Order order = new Order();

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter product name: ");
            String name = sc.nextLine();
            System.out.print("Enter product price: ");
            double price = sc.nextDouble();
            System.out.print("Enter quantity : ");
            int qty = sc.nextInt();
            sc.nextLine();

            if (qty > 0) {
                order.addProduct(new Product(name, price, qty));
            } else if (price > 0) {
                order.addProduct(new Product(name, price));
            } else {
                order.addProduct(new Product(name));
            }
        }

        System.out.println(order.getTotal());
        System.out.println(order.getGrandTotal());
    }
}
