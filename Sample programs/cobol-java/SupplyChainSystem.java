import java.util.ArrayList;
import java.util.List;

public class SupplyChainSystem {
    // Product record
    static class Product {
        String productId;
        String productName;
        int productQuantity;
        double productPrice;
    }

    // Warehouse record
    static class Warehouse {
        String warehouseId;
        String warehouseName;
        String warehouseLocation;
    }

    // Order record
    static class Order {
        String orderId;
        String productId;
        int orderQuantity;
        int orderDate;
    }

    // Product table
    static List<Product> productTable = new ArrayList<>();

    // Warehouse table
    static List<Warehouse> warehouseTable = new ArrayList<>();

    // Order table
    static List<Order> orderTable = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize some sample data
        initializeData();

        // Process an order
        processOrder("ORD001", "PROD001", 50, 20230501);

        // Generate a report
        generateReport();
    }

    private static void initializeData() {
        // Add some sample products
        Product product1 = new Product();
        product1.productId = "PROD001";
        product1.productName = "Widget";
        product1.productQuantity = 100;
        product1.productPrice = 9.99;
        productTable.add(product1);

        Product product2 = new Product();
        product2.productId = "PROD002";
        product2.productName = "Gadget";
        product2.productQuantity = 200;
        product2.productPrice = 14.99;
        productTable.add(product2);

        // Add some sample warehouses
        Warehouse warehouse1 = new Warehouse();
        warehouse1.warehouseId = "WH001";
        warehouse1.warehouseName = "Main Warehouse";
        warehouse1.warehouseLocation = "New York, NY";
        warehouseTable.add(warehouse1);

        Warehouse warehouse2 = new Warehouse();
        warehouse2.warehouseId = "WH002";
        warehouse2.warehouseName = "West Coast Warehouse";
        warehouse2.warehouseLocation = "Los Angeles, CA";
        warehouseTable.add(warehouse2);
    }

    private static void processOrder(String orderId, String productId, int orderQuantity, int orderDate) {
        // Find the product in the product table
        Product product = findProductById(productId);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        // Check if there's enough quantity available
        if (product.productQuantity < orderQuantity) {
            System.out.println("Insufficient quantity available.");
            return;
        }

        // Create a new order and add it to the order table
        Order order = new Order();
        order.orderId = orderId;
        order.productId = productId;
        order.orderQuantity = orderQuantity;
        order.orderDate = orderDate;
        orderTable.add(order);

        // Update the product quantity
        product.productQuantity -= orderQuantity;

        System.out.println("Order processed successfully.");
    }

    private static Product findProductById(String productId) {
        for (Product product : productTable) {
            if (product.productId.equals(productId)) {
                return product;
            }
        }
        return null;
    }

    private static void generateReport() {
        System.out.println("Supply Chain System Report");
        System.out.println("---------------------------");

        System.out.println("\nProducts:");
        for (Product product : productTable) {
            System.out.println("Product ID: " + product.productId + ", Name: " + product.productName +
                    ", Quantity: " + product.productQuantity + ", Price: $" + product.productPrice);
        }

        System.out.println("\nWarehouses:");
        for (Warehouse warehouse : warehouseTable) {
            System.out.println("Warehouse ID: " + warehouse.warehouseId + ", Name: " + warehouse.warehouseName +
                    ", Location: " + warehouse.warehouseLocation);
        }

        System.out.println("\nOrders:");
        for (Order order : orderTable) {
            System.out.println("Order ID: " + order.orderId + ", Product ID: " + order.productId +
                    ", Quantity: " + order.orderQuantity + ", Date: " + order.orderDate);
        }
    }
}
