
import com.mycompany.pw1.Employee;
import com.mycompany.pw1.FieldLengthLimitException;
import com.mycompany.pw1.IncorrectSalaryException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class EmployeeTest {
    @Test
    
    void AddInfoEmployeeTest(){
        String name = "Alice";
        String surname = "Liddel";
        double salary = 13500;
        Employee testEmp = null;
        try {
            testEmp = new Employee();
            testEmp.AddNameSurname(name, surname);
            testEmp.AddSalary(salary);
        }catch(FieldLengthLimitException | IncorrectSalaryException ex){
            Logger.getLogger(EmployeeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        assertEquals(testEmp.getName(), name);
        assertEquals(testEmp.getSurname(), surname);
        assertEquals(testEmp.getSalary(), salary);
    }
    
    @Test
    void LenghtNameExceptionTest(){
        String name = "Aliceeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
        Employee empTest = new Employee();
        
        FieldLengthLimitException thrown = assertThrows(
            FieldLengthLimitException.class,
                () -> empTest.AddNameSurname(name, "Liddel")
        );
        System.out.print(thrown.getMessage());
        assertTrue(thrown.getMessage().contains("ID: " + empTest.getId() + " Too much symbols in name!"));
    }
    
    @Test
    void LenghtSurnameExceptionTest(){
        String surname = "Liddellllllllllllllllllllllllll";
        Employee empTest = new Employee();
        
        FieldLengthLimitException thrown = assertThrows(
            FieldLengthLimitException.class,
                () -> empTest.AddNameSurname("Alice", surname)
        );
        System.out.print(thrown.getMessage());
        assertTrue(thrown.getMessage().contains("ID: " + empTest.getId() + " Too much symbols in surname!"));
    }
    
    @Test
    void IncorrectSalaryExceptionTest(){
        double salary = -13000;
        Employee empTest = new Employee();
        
        IncorrectSalaryException thrown = assertThrows(
            IncorrectSalaryException.class,
                () -> empTest.AddSalary(salary)
        );
        System.out.print(thrown.getMessage());
        assertTrue(thrown.getMessage().contains("ID: " + empTest.getId() + " Salary is less than 0!"));
    }
}
