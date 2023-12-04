/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package org.openjfx.hellofx;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;



/**
 * FXML Controller class
 *
 * @author enni.s
 */
public class AddplanController implements Initializable {
    
    @FXML
    private Label welcome_string;
    @FXML
    private Label amount;
    @FXML
    private ComboBox productsCB;
    @FXML
    private ComboBox product_categoryCB;
    @FXML
    private ComboBox payment_methodCB;
    @FXML
    private ComboBox membershipCB;
    @FXML
    private Button plan_button;
    @FXML 
    private Button update_button;
    @FXML
    private String instype;
    @FXML
    private String insname;
    @FXML
    private String tenureval;
    @FXML
    private String payment;
    
    
    private final ObservableList<String> ins_type = FXCollections.observableArrayList("Silver","Gold","Platinum");
    private final ObservableList<String> product_category = FXCollections.observableArrayList("Electronics","Clothing","Home and Furniture","Beauty and Personal Care","Grocery","Sports and Outdoors");
    
    //private final ObservableList<String> elctronicProducts = FXCollections.observableArrayList("iPhone 15","Samsung Galaxy S21","MacBook Pro","Dell XPS 13","iPad Pro","Samsung Galaxy Tab S7","Apple Watch Series 7","Samsung Galaxy Watch 4","AirPods Pro","Sony WH-1000XM4","LG OLED C1 Series","Samsung QLED Q80A","Canon EOS R5","Sony Alpha A7 III","PlayStation 5","Xbox Series X","HP LaserJet Pro","Amazon Echo (4th Gen)");
    //private final ObservableList<String> clothingProducts = FXCollections.observableArrayList("Denim Jeans", "Leather Jacket", "Cotton T-Shirt", "Silk Blouse", "Wool Sweater", "Athletic Leggings", "Formal Suit", "Summer Dress", "Knit Cardigan", "Running Shoes", "Leopard Print Skirt", "Cashmere Scarf", "Graphic Hoodie", "Chino Pants", "Velvet Blazer");
    //private final ObservableList<String> furnitureProducts = FXCollections.observableArrayList("Sectional Sofa", "Bedside Table", "Area Rug", "Ceramic Vase", "Woven Basket", "Chandelier", "Reclining Chair", "Coffee Table", "Wall Mirror", "Bookshelf", "Table Lamp", "Dining Set", "Quilted Pillow", "Kitchen Island", "Floor Lamp");
    //private final ObservableList<String> careProducts = FXCollections.observableArrayList("Facial Cleanser", "Anti-Aging Serum", "Hydrating Moisturizer", "Shampoo and Conditioner Set", "Matte Lipstick", "Fragrance-Free Sunscreen", "Eyelash Curler", "Manicure Kit", "Exfoliating Scrub", "Aromatherapy Diffuser", "Hair Straightener", "Charcoal Face Mask", "Body Lotion", "Tea Tree Oil Shampoo", "Electric Toothbrush");
    
    private ObservableMap<String, Double> electronicProducts=FXCollections.observableMap(new HashMap<String, Double>());
    private ObservableMap<String, Double> clothingProducts=FXCollections.observableMap(new HashMap<String, Double>());
    private ObservableMap<String, Double> furnitureProducts=FXCollections.observableMap(new HashMap<String, Double>());
    private ObservableMap<String, Double> careProducts=FXCollections.observableMap(new HashMap<String, Double>());
    private ObservableMap<String, Double> groceryProducts=FXCollections.observableMap(new HashMap<String, Double>());
    private ObservableMap<String, Double> sportsAndOutdoorProducts=FXCollections.observableMap(new HashMap<String, Double>());

    private final ObservableList<String> paymentMethod = FXCollections.observableArrayList("Debit","Credit");
    private final ObservableList<String> membership = FXCollections.observableArrayList("Yes","No");

    private final ObservableList<Integer> mon = FXCollections.observableArrayList(250,350,450);
    private final ObservableList<String> ten = FXCollections.observableArrayList("36 months", "48 months", "96 months");
    
    /**
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        //insurance_type.setItems(ins_type);
    	product_categoryCB.setItems(product_category);
        //tenure.setItems(ten);
        payment_methodCB.setItems(paymentMethod);
        //monthly_payment.setItems(mon);
        membershipCB.setItems(membership);
        
        electronicProducts.put("iPhone 15", 999.99); electronicProducts.put("Samsung Galaxy S21", 799.99); electronicProducts.put("MacBook Pro", 1299.99); electronicProducts.put("Dell XPS 13", 1099.99); electronicProducts.put("iPad Pro", 899.99); electronicProducts.put("Samsung Galaxy Tab S7", 649.99); electronicProducts.put("Apple Watch Series 7", 399.99); electronicProducts.put("Samsung Galaxy Watch 4", 349.99); electronicProducts.put("AirPods Pro", 249.99); electronicProducts.put("Sony WH-1000XM4", 349.99); electronicProducts.put("LG OLED C1 Series", 1799.99); electronicProducts.put("Samsung QLED Q80A", 1299.99); electronicProducts.put("Canon EOS R5", 3799.99); electronicProducts.put("Sony Alpha A7 III", 1999.99); electronicProducts.put("PlayStation 5", 499.99); electronicProducts.put("Xbox Series X", 499.99); electronicProducts.put("HP LaserJet Pro", 299.99); electronicProducts.put("Amazon Echo (4th Gen)", 99.99);
        clothingProducts.put("Denim Jeans", 59.99); clothingProducts.put("Leather Jacket", 129.99); clothingProducts.put("Cotton T-Shirt", 19.99); clothingProducts.put("Silk Blouse", 49.99); clothingProducts.put("Wool Sweater", 79.99); clothingProducts.put("Athletic Leggings", 29.99); clothingProducts.put("Formal Suit", 149.99); clothingProducts.put("Summer Dress", 89.99); clothingProducts.put("Knit Cardigan", 69.99); clothingProducts.put("Running Shoes", 99.99); clothingProducts.put("Leopard Print Skirt", 39.99); clothingProducts.put("Cashmere Scarf", 44.99); clothingProducts.put("Graphic Hoodie", 49.99); clothingProducts.put("Chino Pants", 34.99); clothingProducts.put("Velvet Blazer", 119.99);
        furnitureProducts.put("Sectional Sofa", 799.99); furnitureProducts.put("Bedside Table", 129.99); furnitureProducts.put("Area Rug", 49.99); furnitureProducts.put("Ceramic Vase", 24.99); furnitureProducts.put("Woven Basket", 19.99); furnitureProducts.put("Chandelier", 199.99); furnitureProducts.put("Reclining Chair", 299.99); furnitureProducts.put("Coffee Table", 149.99); furnitureProducts.put("Wall Mirror", 79.99); furnitureProducts.put("Bookshelf", 129.99); furnitureProducts.put("Table Lamp", 34.99); furnitureProducts.put("Dining Set", 499.99); furnitureProducts.put("Quilted Pillow", 14.99); furnitureProducts.put("Kitchen Island", 399.99); furnitureProducts.put("Floor Lamp", 89.99);
        careProducts.put("Facial Cleanser", 12.99); careProducts.put("Anti-Aging Serum", 29.99); careProducts.put("Hydrating Moisturizer", 19.99); careProducts.put("Shampoo and Conditioner Set", 14.99); careProducts.put("Matte Lipstick", 8.99); careProducts.put("Fragrance-Free Sunscreen", 15.99); careProducts.put("Eyelash Curler", 5.99); careProducts.put("Manicure Kit", 10.99); careProducts.put("Exfoliating Scrub", 16.99); careProducts.put("Aromatherapy Diffuser", 34.99); careProducts.put("Hair Straightener", 49.99); careProducts.put("Charcoal Face Mask", 7.99); careProducts.put("Body Lotion", 9.99); careProducts.put("Tea Tree Oil Shampoo", 11.99); careProducts.put("Electric Toothbrush", 39.99);
        groceryProducts.put("Bread", 2.99); groceryProducts.put("Milk", 1.99); groceryProducts.put("Eggs", 3.49); groceryProducts.put("Cheese", 4.99); groceryProducts.put("Butter", 2.49); groceryProducts.put("Chicken Breast", 6.99); groceryProducts.put("Ground Beef", 5.99); groceryProducts.put("Fresh Vegetables", 3.99); groceryProducts.put("Fresh Fruits", 4.49); groceryProducts.put("Pasta", 1.79); groceryProducts.put("Rice", 2.29); groceryProducts.put("Canned Soup", 1.49); groceryProducts.put("Cereal", 3.29); groceryProducts.put("Snack Chips", 2.99); groceryProducts.put("Soda", 1.99); groceryProducts.put("Coffee", 5.99); groceryProducts.put("Tea", 3.99); groceryProducts.put("Chocolate", 2.49);
        sportsAndOutdoorProducts.put("Running Shoes", 79.99); sportsAndOutdoorProducts.put("Basketball", 29.99); sportsAndOutdoorProducts.put("Yoga Mat", 19.99); sportsAndOutdoorProducts.put("Dumbbell Set", 49.99); sportsAndOutdoorProducts.put("Tennis Racket", 59.99); sportsAndOutdoorProducts.put("Camping Tent", 89.99); sportsAndOutdoorProducts.put("Hiking Backpack", 39.99); sportsAndOutdoorProducts.put("Bicycle", 199.99); sportsAndOutdoorProducts.put("Fitness Tracker", 69.99); sportsAndOutdoorProducts.put("Golf Clubs Set", 129.99); sportsAndOutdoorProducts.put("Fishing Rod", 49.99); sportsAndOutdoorProducts.put("Soccer Ball", 19.99); sportsAndOutdoorProducts.put("Baseball Glove", 34.99); sportsAndOutdoorProducts.put("Swimming Goggles", 14.99); sportsAndOutdoorProducts.put("Cycling Helmet", 24.99);


        product_categoryCB.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // Check the selected value and set corresponding products to insurance_name ComboBox
                switch (newValue) {
                    case "Electronics":
                        productsCB.setItems(FXCollections.observableArrayList(electronicProducts.keySet()));
                        break;
                    case "Clothing":
                    	productsCB.setItems(FXCollections.observableArrayList(clothingProducts.keySet()));
                        break;
                    case "Home and Furniture":
                    	productsCB.setItems(FXCollections.observableArrayList(furnitureProducts.keySet()));
                        break;
                    case "Beauty and Personal Care":
                    	productsCB.setItems(FXCollections.observableArrayList(careProducts.keySet()));
                        break;
                    case "Grocery":
                    	productsCB.setItems(FXCollections.observableArrayList(careProducts.keySet()));
                        break;
                    case "Sports and Outdoors":
                    	productsCB.setItems(FXCollections.observableArrayList(careProducts.keySet()));
                        break;
                    default:
                    	productsCB.setItems(FXCollections.emptyObservableList());
                        break;
                }
                
            }
        });
        
        productsCB.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            	if (electronicProducts.containsKey(productsCB.getValue())) {
                    amount.setText("" + electronicProducts.get(productsCB.getValue()));
                }else if (clothingProducts.containsKey(productsCB.getValue())) {
                	amount.setText("" + clothingProducts.get(productsCB.getValue()));
                }else if (furnitureProducts.containsKey(productsCB.getValue())) {
                	amount.setText("" + furnitureProducts.get(productsCB.getValue()));
                }else if (careProducts.containsKey(productsCB.getValue())) {
                	amount.setText("" + careProducts.get(productsCB.getValue()));
                }else if (groceryProducts.containsKey(productsCB.getValue())) {
                	amount.setText("" + groceryProducts.get(productsCB.getValue()));
                }else if (sportsAndOutdoorProducts.containsKey(productsCB.getValue())) {
                	amount.setText("" + sportsAndOutdoorProducts.get(productsCB.getValue()));
                }
            	else {
                    amount.setText("Select Product");
                }
            }
            });
        
        UserSession user = UserSession.getInstance();
        String emailId = (String) user.getUserName();
        List<Item> plans = new ArrayList<Item>();
        try {
            plans = getPlans(emailId);
            Iterator i = plans.iterator();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(AddplanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator i = plans.iterator();
        if(i.hasNext())
        {
           welcome_string.setText("Update your plan");
           Item plan = new Item();
           plan = plans.get(0);
           
           productsCB.setValue(plan.getProduct());
           product_categoryCB.setValue(plan.getProductCategory());
           payment_methodCB.setValue(plan.getMembership());
           membershipCB.setValue(plan.getPaymentMethod());
           
           update_button.setVisible(true);
           plan_button.setVisible(false);
        }
        else
        {
           welcome_string.setText("Add New plan");
           plan_button.setVisible(true);
           update_button.setVisible(false); 
        }
    }
    
    @FXML
    public void updateplan(ActionEvent event) throws SQLException, IOException {

        Window owner = update_button.getScene().getWindow();
        
        String tenval;
        String tenure_value;
        tenure_value = (String) payment_methodCB.getValue();
        //tenure_value = tenure_value.substring(0,2);
        instype = (String) productsCB.getValue();
        insname = (String) product_categoryCB.getValue();
        payment = (String) membershipCB.getValue();
        tenval = tenure_value;
        
         
            UserSession user = UserSession.getInstance();
            String emailId = (String) user.getUserName();
            List<Item> plans = new ArrayList<>();
            try {
                plans = getPlans(emailId);
            } catch (SQLException | IOException ex) {
                Logger.getLogger(AddplanController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(plans!=null)
            {
                Item plan = new Item();
                plan = plans.get(0);
                JdbcDao jdbcDao = new JdbcDao();
                jdbcDao.setRecord(plan.email_id, instype, insname,
                        payment, tenval);
                showAlert(Alert.AlertType.CONFIRMATION, owner, "Item updated Successfully!",
                     "Updated item "+insname+" with "+ instype);
            }
        switchToPostLogin();
    }
    
    
    @FXML
    public void addplan(ActionEvent event) throws SQLException, IOException {

        Window owner = plan_button.getScene().getWindow();
        
        if (product_categoryCB.getValue() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please add product category");
            return;
        }
        if(productsCB.getValue() == null)
        {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please add product");
        }
        
        if(membershipCB.getValue() == null)
        {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please add membership status");
        }
        if(payment_methodCB.getValue() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please add payment method");
            return;
        }
        
        String tenval;
        tenureval = (String) payment_methodCB.getValue();
        //tenureval = tenureval.substring(0,2);
        instype = (String) productsCB.getValue();
        insname = (String) product_categoryCB.getValue();
        payment = (String) membershipCB.getValue();
        tenval = tenureval;
        
        if (instype==null || instype.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please add product category");
            return;
        }

        if (insname==null || insname.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please add product");
            return;
        }
        if (payment==null || payment.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please add membership status");
            return;
        }
        if(tenureval==null || tenureval.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please add payment method");
            return;
        }
         
        System.out.println(instype);
        System.out.println(insname);
        System.out.println(payment);
        System.out.println(tenval);
        //System.out.println(passwordField.getText());
        
        //get emailId of User
        UserSession user = UserSession.getInstance();
        String emailId = (String) user.getUserName();
        List<Item> plans = new ArrayList<>();
        JdbcDao jdbcDao = new JdbcDao();

        jdbcDao.addRecord(emailId, instype, insname , payment, tenval);
        showAlert(Alert.AlertType.CONFIRMATION, owner, "Item added Successfully!",
                 "Added item "+insname+" with "+ instype);
        switchToPostLogin();
    }
    
    @FXML
    private void switchToPostLogin() throws IOException {
        App.setRoot("PostLogin");
    }
    
    @FXML
    private void switchToTerms() throws IOException {
        App.setRoot("terms");
    }
    
    @FXML
    private void switchtoAddPlan() throws IOException {
        App.setRoot("addplan");
    }
    
    @FXML public List<Item> getPlans(String emailid) throws SQLException, IOException {
        
        List<Item> plans = new ArrayList<>();
        JdbcDao jdbcDao = new JdbcDao();
        plans = jdbcDao.getRecord(emailid);
        return plans;
    }
    
    
    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
