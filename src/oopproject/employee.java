/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject;

/**
 *
 * @author Weezyy
 */
public abstract class employee {
    private int id;
    private String name;
    private int salary;
    private int age;
    
    public employee(int id, String name, int salary, int age)
    {
        this.id=id ;
        this.name =name;
        this.salary=salary;
        this.age=age;
    }
    public employee (int id ,String name)
    {
        this.id=id ;
        this.name =name;
    }
    public abstract void deleteuse(String username,int id);
}
