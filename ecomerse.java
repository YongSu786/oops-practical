import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product() {
      
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 1;
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { 
        return name; 
    }
    public double getPrice() { 
        return price; 
    }
    public int getQuantity() { 
        return quantity; 
    }

    public void setName(String name) { 
        this.name = name; 
    }
    public void setPrice(double price) { 
        this.price = price; 
    }
    public void setQuantity(int quantity) { 
        this.quantity = quantity; 
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}

class Order {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public double getTotalAmount() {
        double total = 0;
        for (Product p : products) {
            total += p.getTotalPrice();
        }
        return total;
    }

    public double getDiscount() {
        double total = getTotalAmount();
        if (total >= 50000) {
            return total * 0.50; 
        } else if (total > 10000) {
            return total * 0.10; 
        }
        return 0;
    }

    public double getGrandTotal() {
        return getTotalAmount() - getDiscount();
    }
}

public class ecom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Order order = new Order();

        System.out.print("Enter number of products to add: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            Product p = new Product();
            System.out.print("Name: ");
            p.setName(sc.nextLine());
            System.out.print("Price: ");
            p.setPrice(sc.nextDouble());
            System.out.print("Quantity: ");
            p.setQuantity(sc.nextInt());
            sc.nextLine(); 
            order.addProduct(p);
        }

        System.out.println(order.getTotalAmount());
        System.out.println(order.getDiscount());
        System.out.println(order.getGrandTotal());

        sc.close();
    }
}
