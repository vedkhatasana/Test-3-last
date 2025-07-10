package view;

import dao.PizzaOrderDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.PizzaOrder;
import util.BillCalculator;



public class PizzaOrderPage {

    private ObservableList<PizzaOrder> orderList = FXCollections.observableArrayList();
    private PizzaOrderDAO dao;
    private TableView<PizzaOrder> table;

    public PizzaOrderPage(Stage stage) {
        try {
            dao = new PizzaOrderDAO();
            orderList.addAll(dao.getAllOrders());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Label title = new Label("Vedant's Pizza Ordering System");

        TextField nameField = new TextField();
        nameField.setPromptText("Customer Name");

        TextField mobileField = new TextField();
        mobileField.setPromptText("Mobile Number");

        ToggleGroup sizeGroup = new ToggleGroup();
        RadioButton xlRadio = new RadioButton("XL");
        xlRadio.setToggleGroup(sizeGroup);
        RadioButton lRadio = new RadioButton("L");
        lRadio.setToggleGroup(sizeGroup);
        RadioButton mRadio = new RadioButton("M");
        mRadio.setToggleGroup(sizeGroup);
        RadioButton sRadio = new RadioButton("S");
        sRadio.setToggleGroup(sizeGroup);

        HBox sizeBox = new HBox(10, xlRadio, lRadio, mRadio, sRadio);

        TextField toppingsField = new TextField();
        toppingsField.setPromptText("Number of Toppings");

        Button addBtn = new Button("Add");
        Button readBtn = new Button("Read");
        Button updateBtn = new Button("Update");
        Button deleteBtn = new Button("Delete");
        Button clearBtn = new Button("Clear");

        HBox btnBox = new HBox(10, addBtn, readBtn, updateBtn, deleteBtn, clearBtn);

        table = new TableView<>();

        TableColumn<PizzaOrder, String> nameCol = new TableColumn<>("Customer Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));

        TableColumn<PizzaOrder, String> mobileCol = new TableColumn<>("Mobile Number");
        mobileCol.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));

        TableColumn<PizzaOrder, String> sizeCol = new TableColumn<>("Pizza Size");
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("pizzaSize"));

        TableColumn<PizzaOrder, Integer> toppingsCol = new TableColumn<>("Toppings");
        toppingsCol.setCellValueFactory(new PropertyValueFactory<>("numberOfToppings"));

        TableColumn<PizzaOrder, Double> billCol = new TableColumn<>("Total Bill");
        billCol.setCellValueFactory(new PropertyValueFactory<>("totalBill"));

        table.getColumns().addAll(nameCol, mobileCol, sizeCol, toppingsCol, billCol);
        table.setItems(orderList);

        VBox root = new VBox(10, title, nameField, mobileField, sizeBox, toppingsField, btnBox, table);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root, 700, 500);

        stage.setScene(scene);
        stage.setTitle("Vedant's Pizza Ordering System");
        stage.show();

        // Button Actions
        addBtn.setOnAction(e -> {
            try {
                String name = nameField.getText();
                String mobile = mobileField.getText();
                String size = ((RadioButton) sizeGroup.getSelectedToggle()).getText();
                int toppings = Integer.parseInt(toppingsField.getText());
                double bill = BillCalculator.calculateTotal(size, toppings);

                PizzaOrder order = new PizzaOrder(name, mobile, size, toppings, bill);
                dao.addOrder(order);
                orderList.setAll(dao.getAllOrders());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        readBtn.setOnAction(e -> {
            try {
                orderList.setAll(dao.getAllOrders());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        updateBtn.setOnAction(e -> {
            PizzaOrder selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                try {
                    String name = nameField.getText();
                    String mobile = mobileField.getText();
                    String size = ((RadioButton) sizeGroup.getSelectedToggle()).getText();
                    int toppings = Integer.parseInt(toppingsField.getText());
                    double bill = BillCalculator.calculateTotal(size, toppings);

                    selected.setCustomerName(name);
                    selected.setMobileNumber(mobile);
                    selected.setPizzaSize(size);
                    selected.setNumberOfToppings(toppings);
                    selected.setTotalBill(bill);

                    dao.updateOrder(selected);
                    orderList.setAll(dao.getAllOrders());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        deleteBtn.setOnAction(e -> {
            PizzaOrder selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                try {
                    dao.deleteOrder(selected.getId());
                    orderList.setAll(dao.getAllOrders());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        clearBtn.setOnAction(e -> {
            nameField.clear();
            mobileField.clear();
            toppingsField.clear();
            sizeGroup.selectToggle(null);
        });

        table.setOnMouseClicked(e -> {
            PizzaOrder selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                nameField.setText(selected.getCustomerName());
                mobileField.setText(selected.getMobileNumber());
                toppingsField.setText(String.valueOf(selected.getNumberOfToppings()));

                for (Toggle t : sizeGroup.getToggles()) {
                    RadioButton rb = (RadioButton) t;
                    if (rb.getText().equals(selected.getPizzaSize())) {
                        sizeGroup.selectToggle(rb);
                        break;
                    }
                }
            }
        });
    }
}
