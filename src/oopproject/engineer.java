/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Weezyy
 */
public final class engineer extends employee{
    private int workingHours;
    private String grade;

    public engineer(int id, String name, int salary, int age, int workingH, String Grade) {
        super(id, name, salary, age);
        workingHours=workingH;
        grade=Grade;
    }

    /**
     *
     * @param id
     * @param name
     */
    public engineer(int id, String name){
        super(id, name);
    }

    public void adduser(int id, String name, String Grade, int age,int workingH ) throws SQLException{
        Database db = new Database();
        int usersalary= calcsalary (Grade, workingH);
        Connection conn = db.openConnection();
        if (db.checkreguser(name, id))
        {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("insert into engineer (id, Name, salary, grade, age, WorkingHours)values (?, ?, ?, ? , ?, ?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, usersalary);
            preparedStatement.setString(4, Grade);
            preparedStatement.setInt(5, age);
            preparedStatement.setInt(6, workingH);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Engineer Added");
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Engineer existed already");
        }
    }
    public void update(String username, int id, String Grade, int age,int workingH ) {
         Database db = new Database();
         int usersalary= calcsalary (Grade, workingH);
        try {
             Connection conn = db.openConnection();
            if (db.checkuser(username,id))
            {
                int opt = JOptionPane.showConfirmDialog(null, "Are you sure to update that Engineer","Update Data",JOptionPane.YES_NO_OPTION);
                if (opt==0)
                {
                    try {
                            PreparedStatement preparedStatement = conn
                                .prepareStatement("UPDATE engineer Set salary=?, grade=?, age=?, WorkingHours=? where Name= ? AND id=? ;");
                            preparedStatement.setInt(1, usersalary);
                            preparedStatement.setString(2, Grade);
                            preparedStatement.setInt(3, age);
                            preparedStatement.setInt(4, workingH);
                            preparedStatement.setString(5, username);
                            preparedStatement.setInt(6, id);
                            preparedStatement.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Engineer Updated"); 
                    } catch (SQLException ex) {
                        System.out.println("Connection Failed To the Database!");
                        System.exit(0);
                    }
                }
            }
            else {JOptionPane.showMessageDialog(null, "Engineer can not be found"); }
        } catch (SQLException ex) {
            System.out.println("Connection Failed To the Database!");
            System.exit(0);
        } 
    }
    @Override
    public void deleteuse(String username, int id) {
        Database db = new Database();
        try {
            Connection conn = db.openConnection();
            if (db.checkuser(username,id))
            {
                int opt = JOptionPane.showConfirmDialog(null, "Are you sure to delete that Engineer","Delete",JOptionPane.YES_NO_OPTION);
                if (opt==0)
                {
                    try {
                            PreparedStatement preparedStatement = conn
                                .prepareStatement("DELETE from engineer where Name= ? AND id=? ;");
                        preparedStatement.setString(1, username);
                        preparedStatement.setInt(2, id);
                        preparedStatement.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Engineer Deleted"); 
                    } catch (SQLException ex) {
                        System.out.println("Connection Failed To the Database!");
                        System.exit(0);
                    }
                }
            }
            else {JOptionPane.showMessageDialog(null, "Engineer can not be found"); }
        } catch (SQLException ex) {
            System.out.println("Connection Failed To the Database!");
            System.exit(0);
        }  
    }

    public int calcSalary(String username,int id) 
    {
        int thesalary = -1;
        int payrate;
        float taxrate;
        Database db= new Database();
      try {
                Connection conn = db.openConnection();
                PreparedStatement preparedStatement = conn.prepareStatement("select id, Name , grade, WorkingHours from engineer");
                    ResultSet Rs = preparedStatement.executeQuery();  
              String userName;
              String ugrade;
              int uid;
              int uHours;
              boolean notfound=true;
              while (Rs.next()) 
              {
                userName = Rs.getString("Name");
                uid = Integer.parseInt(Rs.getString("id"));
                if (username.equals(userName) && id==uid)
                {
                    ugrade = Rs.getString("grade");
                    uHours = Rs.getInt("WorkingHours");
                    switch (ugrade) {
                        case "Manager":
                            payrate=1000;
                            taxrate=0.8F;
                            thesalary = (int) (payrate*taxrate*uHours*20);
                            break;
                        case "Team Leader":
                            payrate=750;
                            taxrate=0.6F;
                            thesalary = (int) (payrate*taxrate*uHours*20);
                            break;
                        case "Team member":
                            payrate=500;
                            taxrate=0.4F;
                            thesalary = (int) (payrate*taxrate*uHours*20);
                            break;
                        default:
                            payrate=250;
                            taxrate=0.2F;
                            thesalary = (int) (payrate*taxrate*uHours*20);
                            break;
                    }
                        preparedStatement = conn.prepareStatement("UPDATE engineer Set salary=? where Name= ? AND id=?");
                        preparedStatement.setInt(1, thesalary);
                        preparedStatement.setString(2, username);
                        preparedStatement.setInt(3, id);
                        preparedStatement.executeUpdate();
                        notfound=false;
                        break;
                }
              }
            if (notfound){JOptionPane.showMessageDialog(null, "Engineer can not be found");}
            } catch (SQLException ex) {
                System.out.println("Connection Failed To the Database!");
                System.exit(0);
        }
        return thesalary;
    }

    public int calcsalary(String ugrade,int uHours) 
    {
        int thesalary;
        int payrate;
        float taxrate;
        switch (ugrade) {
                        case "Manager":
                            payrate=1000;
                            taxrate=0.8F;
                            thesalary = (int) (payrate*taxrate*uHours*20);
                            break;
                        case "Team Leader":
                            payrate=750;
                            taxrate=0.6F;
                            thesalary = (int) (payrate*taxrate*uHours*20);
                            break;
                        case "Team member":
                            payrate=500;
                            taxrate=0.4F;
                            thesalary = (int) (payrate*taxrate*uHours*20);
                            break;
                        default:
                            payrate=250;
                            taxrate=0.2F;
                            thesalary = (int) (payrate*taxrate*uHours*20);
                            break;
                    }
     
        return thesalary;
    }
}
            
            
