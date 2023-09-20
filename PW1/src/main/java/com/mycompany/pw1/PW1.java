/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pw1;

/**
 *
 * @author Admin
 */
public class PW1 {

    public static void main(String[] args) {
        Employee emp1 = new Employee();
        try{
            emp1.AddNameSurname( "Jack", "Black");
            emp1.AddSalary(-14000);
            emp1.PrintInfo();
        }catch(FieldLengthLimitException | IncorrectSalaryException ex){
            System.out.println(ex.getMessage());
        }
        Employee emp2 = new Employee();
        try{
            emp2.AddNameSurname( "Jack", "Black");
            emp2.AddSalary(14000);
            emp2.PrintInfo();
        }catch(FieldLengthLimitException | IncorrectSalaryException ex){
            System.out.println(ex.getMessage());
        }
    }
}
