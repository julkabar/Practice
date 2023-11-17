/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pw35;

/**
 *
 * @author Admin
 */
public class Student {
    int id;
    static int nextid = 0;
    private String name;
    private String surname;
    private String email;
    private String group;
    private String faculty;

    public Student() {
        this.id = nextid++;
        this.name = "unknown";
        this.surname = "unknown";
        this.email = "unknown";
        this.group = "unknown";
        this.faculty = "unknown";
    }
    
    public Student(String name, String surname, String email, String group, String faculty) {
        this.id = nextid++;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.group = group;
        this.faculty = faculty;
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
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getGroup() {
        return group;
    }
    
    public void setGroup(String group) {
        this.group = group;
    }
    
    public String getFaculty() {
        return faculty;
    }
    
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}


