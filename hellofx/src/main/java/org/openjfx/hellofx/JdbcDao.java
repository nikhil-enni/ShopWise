
package org.openjfx.hellofx;
import java.io.IOException;
import org.openjfx.hellofx.Item;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import static org.openjfx.hellofx.LogController.push_log;



public class JdbcDao {

    // Replace below database url, username and password with your actual database credentials
    private static final String INSERT_QUERY = "INSERT INTO user_registration (full_name, email_id, password) VALUES (?, ?, ?)";
    private static final String SELECT_QUERY = "SELECT id, email_id, Product, Product_Category, Membership, Payment_Method FROM sold_items WHERE email_id=?";
    private static final String SEARCH_QUERY = "SELECT * FROM sold_items WHERE email_id like ? ";
    private static final String SEARCH_Q = "SELECT id FROM user_registration WHERE email_id = ? and password = ?";
    private static final String DELETE_QUERY = "DELETE FROM sold_items WHERE email_id = ?";
    @FXML public List<Item> getPlans() throws SQLException, IOException {
        
        List<Item> plans = new ArrayList<>();
        JdbcDao jdbcDao = new JdbcDao();
        UserSession user = UserSession.getInstance();
        plans = jdbcDao.getRecord(user.getUserName());
        return plans;
    }
    private static final String ADD_QUERY = "INSERT INTO sold_items (email_id, Product, Product_Category, Membership, Payment_Method)VALUES (?, ?, ?, ?, ?)";
    private static final String SET_QUERY = "UPDATE sold_items set Product = ?, Product_Category=?, Membership = ?, Payment_Method = ? WHERE email_id = ?";
    public void insertRecord(String fullName, String emailId, String password) throws SQLException {

        // Step 1: Establishing a Connection and 
        // try-with-resource statement will auto close the connection.
        try (
                
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ood_project?allowPublicKeyRetrieval=true&useSSL=false","root","password");
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY) ){
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, emailId);
            preparedStatement.setString(3, password);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }
    
    public void addRecord(String email_id, String insurance_type, String insurance_name, 
            String monthly_premium, String tenval) throws SQLException {

        // Step 1: Establishing a Connection and 
        // try-with-resource statement will auto close the connection.
        try (
                
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ood_project?allowPublicKeyRetrieval=true&useSSL=false","root","password");
         
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_QUERY) )
            {
                preparedStatement.setString(1, email_id);
                preparedStatement.setString(2, insurance_type);
                preparedStatement.setString(3, insurance_name);
                preparedStatement.setString(4, monthly_premium);
                preparedStatement.setString(5, tenval);
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                push_log("Add Item for user: "+email_id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }
    
    public void setRecord(String email_id, String insurance_type, String insurance_name, 
            String monthly_premium, String tenval ) throws SQLException
    {
        List<Item> plans = new ArrayList<>();
        try(
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ood_project?allowPublicKeyRetrieval=true&useSSL=false","root","password");
            PreparedStatement preparedStatement = connection.prepareStatement(SET_QUERY);) 
        {
            preparedStatement.setString(1,insurance_type);
            preparedStatement.setString(2,insurance_name);
            preparedStatement.setString(3, monthly_premium);
            preparedStatement.setString(4, tenval);
            preparedStatement.setString(5,email_id);
            System.out.println(preparedStatement);
            push_log("Update Item for user: "+email_id+" with "+" Membership: "+monthly_premium+" and Payment_Method: "+tenval);
            int row = preparedStatement.executeUpdate();
        }catch(SQLException e){
        
            printSQLException(e);     
        }
        return;
    }
    
    public List<Item> getRecord(String emailId) throws SQLException
    {
        List<Item> plans = new ArrayList<>();
        try(
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ood_project?allowPublicKeyRetrieval=true&useSSL=false","root","password");
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);) 
        {
            preparedStatement.setString(1,emailId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
               Item insure = new Item();
               insure.setId(rs.getInt("id"));
               System.out.println(insure.getId());
               insure.setEmail_id(rs.getString("email_id"));
               System.out.println(insure.getEmail_id());
               insure.setProduct(rs.getString("Product"));
               System.out.println(insure.getProduct());
               insure.setProductCategory(rs.getString("Product_Category"));
               System.out.println(insure.getProductCategory());
               insure.setMonthly_premium(rs.getString("Membership"));
               System.out.println(insure.getMembership());
               insure.setTenure(rs.getString("Payment_Method"));
               System.out.println(insure.getPaymentMethod());
               plans.add(insure);
            }
            push_log("Print the item for user from records: "+ emailId);
            return plans;
        }catch(SQLException e){
        
            printSQLException(e);     
        }
        return plans;
    }
    public List<Item> searchRecord(String emailId) throws SQLException
    {
        List<Item> plans = new ArrayList<>();
        try(
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ood_project?allowPublicKeyRetrieval=true&useSSL=false","root","password");
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_QUERY);) 
        {
            preparedStatement.setString(1,"%"+emailId+"%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println(rs);
            while(rs.next())
            {
               Item insure = new Item();
               insure.setId(rs.getInt("id"));
               System.out.println(insure.getId());
               insure.setEmail_id(rs.getString("email_id"));
               System.out.println(insure.getEmail_id());
               insure.setProduct(rs.getString("Product"));
               System.out.println(insure.getProduct());
               insure.setProductCategory(rs.getString("Product_Category"));
               System.out.println(insure.getProductCategory());
               insure.setMonthly_premium(rs.getString("Membership"));
               System.out.println(insure.getMembership());
               insure.setTenure(rs.getString("Payment_Method"));
               System.out.println(insure.getPaymentMethod());
               plans.add(insure);
            }
            return plans;
        }catch(SQLException e){
        
            printSQLException(e);     
        }
        return plans;
    }
        
    public boolean searchRecord(String emailId, String password) throws SQLException
    {
        List<Item> plans = new ArrayList<>();
        try(
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ood_project?allowPublicKeyRetrieval=true&useSSL=false","root","password");
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_Q);) 
        {
            preparedStatement.setString(1,emailId);
            preparedStatement.setString(2,password);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            {
                return true;
            }     
        }catch(SQLException e){
        
            printSQLException(e);     
        }
        return false;
    }
    
    public boolean searchAdminRecord(String emailId, String password) 
    {
        if(emailId.equals("sysadmin") && password.equals("abcd1234"))
        {
            return true;
        }
        return false;
    }
    public void deleteRecord(String emailid) {
        try(
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ood_project?allowPublicKeyRetrieval=true&useSSL=false","root","password");
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);) 
        {
            preparedStatement.setString(1,emailid);
            push_log("Delete the item for user: "+ emailid);
            int row = preparedStatement.executeUpdate();  
        }catch(SQLException e){
        
            printSQLException(e);     
        }
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


    
}
