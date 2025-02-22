package invetorymanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

class Product {

    private int id;
    private String name;
    private int stock;

    // Constructor, getters, and setters
}

class InventorySimulation {

    private Connection connect() throws SQLException {
        // Replace with your database connection details
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "user", "password");
    }

    public synchronized void updateStock(int productId, int quantitySold) {
        String sql = "UPDATE products SET stock = stock - ? WHERE id = ?";
        try  {
           Connection conn = connect(); 
           PreparedStatement pstmt = conn.prepareStatement(sql);
           pstmt.setInt(1, quantitySold);
           pstmt.setInt(2, productId);
           pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class StoreThread extends Thread {

    private final InventorySimulation inventoryManager;
    private final int productId;

    public StoreThread(InventorySimulation inventoryManager, int productId) {
        this.inventoryManager = inventoryManager;
        this.productId = productId;
    }

    @Override
    public void run() {
        Random random = new Random();
        int quantitySold = random.nextInt(5) + 1; // Selling between 1 and 5 items
        inventoryManager.updateStock(productId, quantitySold);
        System.out.println(Thread.currentThread().getName() + " sold " + quantitySold + " of product " + productId);
    }
}

public class InvetoryManager {

    public static void main(String[] args) {
        InventorySimulation inventoryManager = new InventorySimulation();
        for (int i = 0; i < 10; i++) {
            new StoreThread(inventoryManager, 1).start();// All threads updating the same product for testing
        }
    }
}
