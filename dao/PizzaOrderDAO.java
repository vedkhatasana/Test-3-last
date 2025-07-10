package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.PizzaOrder;

public class PizzaOrderDAO {
    private Connection conn;

    public PizzaOrderDAO() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza_app", "root", "");
        createTable();
    }

    private void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS pizza_orders (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "customerName VARCHAR(100), " +
                "mobileNumber VARCHAR(20), " +
                "pizzaSize VARCHAR(10), " +
                "numberOfToppings INT, " +
                "totalBill DOUBLE)";
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
        stmt.close();
    }

    public void addOrder(PizzaOrder order) throws SQLException {
        String sql = "INSERT INTO pizza_orders (customerName, mobileNumber, pizzaSize, numberOfToppings, totalBill) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, order.getCustomerName());
        pstmt.setString(2, order.getMobileNumber());
        pstmt.setString(3, order.getPizzaSize());
        pstmt.setInt(4, order.getNumberOfToppings());
        pstmt.setDouble(5, order.getTotalBill());
        pstmt.executeUpdate();
        pstmt.close();
    }

    public List<PizzaOrder> getAllOrders() throws SQLException {
        List<PizzaOrder> list = new ArrayList<>();
        String sql = "SELECT * FROM pizza_orders";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            list.add(new PizzaOrder(
                rs.getInt("id"),
                rs.getString("customerName"),
                rs.getString("mobileNumber"),
                rs.getString("pizzaSize"),
                rs.getInt("numberOfToppings"),
                rs.getDouble("totalBill")
            ));
        }
        rs.close();
        stmt.close();
        return list;
    }

    public void updateOrder(PizzaOrder order) throws SQLException {
        String sql = "UPDATE pizza_orders SET customerName=?, mobileNumber=?, pizzaSize=?, numberOfToppings=?, totalBill=? WHERE id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, order.getCustomerName());
        pstmt.setString(2, order.getMobileNumber());
        pstmt.setString(3, order.getPizzaSize());
        pstmt.setInt(4, order.getNumberOfToppings());
        pstmt.setDouble(5, order.getTotalBill());
        pstmt.setInt(6, order.getId());
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void deleteOrder(int id) throws SQLException {
        String sql = "DELETE FROM pizza_orders WHERE id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        pstmt.close();
    }
}
