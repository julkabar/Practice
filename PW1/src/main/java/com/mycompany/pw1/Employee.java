/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pw1;

/**
 *
 * @author Admin
 */
public class Employee {
    private int id;
    private static int nextid=0;
    private String name;
    private String surname;
    private double salary;
    
    public Employee(){
        this.id = nextid++;
        this.name = "noname";
        this.surname = "nosurname";
        this.salary = 0;
    }
        
    public void AddNameSurname(String name, String surname) throws FieldLengthLimitException{
        if(name.length() > 20){throw new FieldLengthLimitException("ID: " + this.id + " Too much symbols in name!");}
        else this.name = name;
        if(surname.length() > 20){throw new FieldLengthLimitException("ID: " + this.id + " Too much symbols in surname!");}
        else this.surname = surname;
    }
    
    public void AddSalary(double salary) throws IncorrectSalaryException{
        if(salary < 0){throw new IncorrectSalaryException("ID: " + this.id + " Salary is less than 0!");}
        else this.salary = salary;
    }
    
    public void PrintInfo(){
        System.out.println("ID: " + id + "\nName: " + name + "\nSurname: " + surname + "\nSalary: " + salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }
    
}
