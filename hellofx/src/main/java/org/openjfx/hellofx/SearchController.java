/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.hellofx;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;

/**
 *
 * @author enni.s
 */
public class SearchController implements Initializable {

    @FXML
    private Label email_id;
    @FXML
    private Label product;
    
    @FXML 
    private Label product_category;
    
    @FXML
    private Label membership;
    
    @FXML 
    private Label payment_method;
    
    @FXML
    private TextField search_bar;
    
    @FXML
    private Button searchButton;
    
    @FXML
    private Button delete_button;
    
    
    @FXML public List<Item> getPlans(String emailid) throws SQLException, IOException {
        
        List<Item> plans = new ArrayList<>();
        JdbcDao jdbcDao = new JdbcDao();
        UserSession user = UserSession.getInstance();
        plans = jdbcDao.searchRecord(emailid);
        return plans;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        return;
    }
    
    @FXML
    public void searchfun(ActionEvent event) throws SQLException, IOException {

        Window owner = searchButton.getScene().getWindow();

        List<Item> plans = new ArrayList<>();
        
        if (search_bar.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Search 404",
                "Enter a username email to search");
            return;
        }
        System.out.println(search_bar.getText());
        
        if (search_bar.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Search 404",
                "Enter a username email to search");
            return;
        }

        String searchid = search_bar.getText();
        
        try {
            plans = getPlans(searchid);
        } catch (SQLException | IOException ex) {
            Logger.getLogger(AddplanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator it = plans.iterator();
        if(it.hasNext())
        {
            Item plan = new Item();
            plan = plans.get(0);
            product_category.setText(plan.product_category);
            product.setText(plan.product);
            membership.setText(plan.membership+"");
            payment_method.setText(plan.payment_method+"");
            email_id.setText(plan.email_id);
        }
        else
        {
        	product_category.setText("There is no customer with active items and given email id");
        	product.setText("");
            membership.setText("");
            email_id.setText("");
            payment_method.setText("");
        }
    }

    @FXML
    public void deletefun(ActionEvent event) throws SQLException, IOException {

        Window owner = delete_button.getScene().getWindow();
        
        String email = email_id.getText();
        JdbcDao jdbcdao = new JdbcDao();
        jdbcdao.deleteRecord(email);
        ReloadSearch();
    }
    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    
    @FXML
    private void ReloadSearch() throws IOException {
        App.setRoot("Search");
    }
    
    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("Login");
    }
}
