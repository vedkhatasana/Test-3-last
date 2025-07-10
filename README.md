Absolutely! Here’s a customized README for your **Pizza Ordering System** JavaFX project, including your name, student ID, professor, and your friends in the acknowledgments, all tailored to your current code (JavaFX + MySQL + DAO):

---

# 🍕 Pizza Ordering System – JavaFX Desktop Application

**Ved Patel – Student ID: 23094884**  
**Lab Submission Date:** July 10, 2025  
**Course:** Programming Concepts - II  
**Professor:** Stephen Perelgut

---

## 📋 Overview

This project is a simple JavaFX desktop application that simulates a Pizza Ordering System. It allows users to add, view, update, and delete pizza orders with a user-friendly interface. Orders are stored in a MySQL database using the DAO (Data Access Object) pattern.

---

## ⚙️ Technologies Used

- **Java 21** (JDK)
- **JavaFX (OpenJFX 24)**
- **MySQL** (for persistent order storage)
- **Maven** (for dependency management)
- **VS Code** (for development and testing)

---

## ✅ Features

- Add new pizza orders with customer details, pizza size, and toppings
- View all orders in a TableView
- Update existing orders
- Delete orders by selection
- Clear and user-friendly JavaFX GUI
- Real-time table refresh after each operation
- DAO pattern for clean database access
- Error handling and user feedback via alerts

---

## 📸 Screenshots

*(Add your screenshots below this section showing:)*

- Main Application Window
- Adding a New Order
- TableView with Orders
- Update/Delete in action
- Error/Alert popups

---

## 🚀 How to Run

1. **Clone or download this repository.**
2. **Set up your MySQL database:**
   - Create a database and table using the provided SQL:
     ```sql
     CREATE TABLE pizza_orders (
         id INT AUTO_INCREMENT PRIMARY KEY,
         customer_name VARCHAR(100),
         mobile_number VARCHAR(20),
         pizza_size VARCHAR(5),
         number_of_toppings INT,
         total_bill DOUBLE
     );
     ```
3. **Update your database connection details** in `PizzaOrderDAO.java`:
   ```java
   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_db", "username", "password");
   ```
4. **Build and run the project** using VS Code or Maven.

---

## 🙏 Acknowledgments & Help

Special thanks to:

- **Preet Patel** — Helped with project structure and UI layout.
- **Piyush** — Assisted with event handling and testing.
- **ChatGPT** — Used for code suggestions, bug fixes, and project guidance.
- **W3Schools & Stack Overflow** — Referenced for JavaFX controls, Java syntax, and MySQL integration.
- **cursor- i used curdor for setting.json

---

## 📚 References

- [JavaFX Documentation (OpenJFX)](https://openjfx.io/)
- [Maven Project Setup Guide](https://maven.apache.org/guides/)
- [W3Schools JavaFX Tutorials](https://www.w3schools.com/java/javafx_intro.asp)
- [Stack Overflow – JavaFX & Java discussions](https://stackoverflow.com/questions/tagged/javafx)


