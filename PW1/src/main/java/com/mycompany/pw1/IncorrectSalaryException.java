/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pw1;

/**
 *
 * @author Admin
 */
public class IncorrectSalaryException extends Exception{
    public IncorrectSalaryException(){
        
    }
    public IncorrectSalaryException(String msg){
        super(msg);
    }
}
