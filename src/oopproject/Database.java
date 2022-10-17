package oopproject;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Database 
{
    private Connection conn;
    protected Statement statement; 
    private ResultSet resultSet = null;
    
    public Connection openConnection() throws SQLException
    {
        if(conn == null)
        {
            String url = "jdbc:mysql://localhost/";
            String DBName = "oop";
            String driver = "com.mysql.jdbc.Driver";
            String username = "root";
            String password = "";
            try 
            {
                Class.forName(driver);
                this.conn=(Connection)DriverManager.getConnection(url+DBName,username,password);
                System.out.println("Connection Succesfull!");
            } 
            catch (ClassNotFoundException | SQLException sqle) 
            {
                System.out.println("Connection Failed To the Database!");
                System.exit(0);
            }
        }
        return conn;
    }
    public boolean checkadmin(String f, String s) throws SQLException {
        boolean end = false;
        try {
            statement =  (Statement) conn.createStatement();
            resultSet = statement
                    .executeQuery("select AdminName, AdminPassword from admins");

            while (resultSet.next()) {
            String staffname = resultSet.getString("AdminName");
            String password =  resultSet.getString("AdminPassword");

               if ((f.equals(staffname)) && (s.equals(password))) {

                  JOptionPane.showMessageDialog(null, "Welcome "+staffname);  
                  end = true;
                  break;
            }else {
                JOptionPane.showMessageDialog(null, "Please Check Username and Password");
            }
        } 
        resultSet.close();
        }catch (SQLException sql) {
            System.out.println("Connection Failed To the Database!");
            System.exit(0);
        }
        return end;    
    }
    public boolean checkuser(String f, int s) throws SQLException {
        boolean end = false;
        try {
            statement =  (Statement) conn.createStatement();
            resultSet = statement
                    .executeQuery("select id, Name from engineer");

            while (resultSet.next()) {
                String uName = resultSet.getString("Name");
                int id =  Integer.parseInt(resultSet.getString("id"));
                if ((f.equals(uName)) && (s==id)) { end= true;}
            }
            
            resultSet.close();
        }catch (SQLException sql) {
            System.out.println("Connection Failed To the Database!");
            System.exit(0);
        }
        return end;      
    }
    public boolean checkreguser(String f, int s) throws SQLException {
        boolean end = true;
        try {
            statement =  (Statement) conn.createStatement();
            resultSet = statement
                    .executeQuery("select id, Name from engineer");

            while (resultSet.next()) {
                String userName = resultSet.getString("Name");
                int id = Integer.parseInt(resultSet.getString("id"));
                if ((f.equals(userName)) || s==id) { end= false; }
            }
            
        resultSet.close();
        }catch (SQLException sql) {
            System.out.println("Connection Failed To the Database!");
            System.exit(0);
        }
        return end;    
    }
    // Trainee functions
    public boolean checkuser(int s, String f) throws SQLException {
        boolean end = false;
        try {
            statement =  (Statement) conn.createStatement();
            resultSet = statement
                    .executeQuery("select id, Name from trainee");
            
            while (resultSet.next()) {
                String uName = resultSet.getString("Name");
                int id =  Integer.parseInt(resultSet.getString("id"));
                if ((f.equals(uName)) && (s==id)) { end = true; }
            }
            
            resultSet.close();
        }catch (SQLException sql) {
               System.out.println("Connection Failed To the Database!");
               System.exit(0);
        }
        return end;      
    }
    
    public boolean checkreguser(int s, String f) throws SQLException {
        boolean end = true;
        try {
            statement =  (Statement) conn.createStatement();
            resultSet = statement
                    .executeQuery("select id, Name from trainee");

            while (resultSet.next()) {
            String userName = resultSet.getString("Name");
            int id = Integer.parseInt(resultSet.getString("id"));
            
               if ((f.equals(userName)) || s==id) {
                  end = false;
            }
        }
        resultSet.close();
        }catch (SQLException sql) {
            System.out.println("Connection Failed To the Database!");
            System.exit(0);
        }
        return end;    
    }
}
