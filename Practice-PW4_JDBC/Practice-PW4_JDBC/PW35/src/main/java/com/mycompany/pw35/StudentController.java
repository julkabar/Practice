/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pw35;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class StudentController {
    List<Student> students;
    ApplicationContext factory;
    Student student;

        @Autowired
        private StudentDAO sdao;
        
        @ModelAttribute
        public void modelData(Model m){
            if(students==null){ students = new LinkedList<Student>();}
            factory = new ClassPathXmlApplicationContext("/spring.xml");
        }
        
        @RequestMapping(value = "/")
	public String home(Model m) {
            students = sdao.getStudents();
            m.addAttribute("students", students);
		return "student";
	}
        
        @RequestMapping("StudentAdd")
        public String addStudent(HttpServletRequest request,Model m) {

            if(request.getParameter("name") != null && request.getParameter("surname") != null) {
                Student student = (Student)factory.getBean("Student");
                
                student.setName(request.getParameter("name"));
                student.setSurname(request.getParameter("surname"));
                student.setAge(Integer.parseInt(request.getParameter("age")));
                student.setEmail(request.getParameter("email"));
                student.setGroup(request.getParameter("group"));
                student.setFaculty(request.getParameter("faculty"));
                sdao.addStudent(student);
                }
                
            students = sdao.getStudents();
            
            m.addAttribute("students", students);
            return "student";
        }  
}
