/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Weezyy
 */
public final class trainee extends employee{
    private float gpa;
    private String universityname;
    private int academicyear;

    public trainee(int id, String name, int salary, int age, float gpa , String universityname, int academicyear) {
        super(id, name, salary, age);
        this.gpa=gpa;
        this.academicyear=academicyear;
        this.universityname=universityname;
        
    }

    /**
     *
     * @param id
     * @param name
     */
    public trainee(int id, String name){
        super(id, name);
    }

    public void adduser(int id, String name, int age, float gpa , String universityname, int academicyear) throws SQLException, ClassNotFoundException {
        Database db = new Database();
        Connection conn = db.openConnection();
        if (db.checkreguser(id, name))
        {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("insert into trainee (id, Name, salary, age, UniversityName, GPA, AcademicYear)values (?, ?, ?, ? , ?, ?, ?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, 5000);
            preparedStatement.setInt(4, age);
            preparedStatement.setString(5, universityname);
            preparedStatement.setFloat(6, gpa);
            preparedStatement.setInt(7, academicyear);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Trainee Added");
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Trainee existed already");
        }
    }
    public void update(String username, int id, int age, float gpa , String universityname, int academicyear) {
         Database db = new Database();
        try {
             Connection conn = db.openConnection();
            if (db.checkuser(id,username))
            {
                int opt = JOptionPane.showConfirmDialog(null, "Are you sure to update that Trainee","Update Data",JOptionPane.YES_NO_OPTION);
                if (opt==0)
                {
                    try {
                            PreparedStatement preparedStatement = conn
                                .prepareStatement("UPDATE trainee Set age=?, UniversityName=?, GPA=?, AcademicYear=? where Name= ? AND id=? ;");
                            preparedStatement.setInt(1, age);
                            preparedStatement.setString(2, universityname);
                            preparedStatement.setFloat(3, gpa);
                            preparedStatement.setInt(4, academicyear);
                            preparedStatement.setString(5, username);
                            preparedStatement.setInt(6, id);
                            preparedStatement.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Trainee Updated"); 
                    } catch (SQLException ex) {
                        System.out.println("Connection Failed To the Database!");
                        System.exit(0);
                    }
                }
            }
            else {JOptionPane.showMessageDialog(null, "Trainee can not be found"); }
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
            if (db.checkuser(id,username))
            {
                int opt = JOptionPane.showConfirmDialog(null, "Are you sure to delete that Trainee","Delete",JOptionPane.YES_NO_OPTION);
                if (opt==0)
                {
                    try {
                            PreparedStatement preparedStatement = conn
                                .prepareStatement("DELETE from trainee where Name= ? AND id=? ;");
                        preparedStatement.setString(1, username);
                        preparedStatement.setInt(2, id);
                        preparedStatement.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Trainee Deleted"); 
                    } catch (SQLException ex) {
                        System.out.println("Connection Failed To the Database!");
                        System.exit(0);
                    }
                }
            }
            else {JOptionPane.showMessageDialog(null, "Trainee can not be found"); }
        } catch (SQLException ex) {
            System.out.println("Connection Failed To the Database!");
            System.exit(0);
        }  
    }
}
            
            
