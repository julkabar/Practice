/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pw35;

import jakarta.enterprise.inject.Model;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Admin
 */
@Controller
public class ContentController {
        List<Content> scores;
        ApplicationContext factory;
        
        @RequestMapping(value = "UserContent", method=RequestMethod.GET)
        public ModelAndView formContent(@RequestParam("id2") String id2, HttpServletRequest request,HttpServletResponse response) throws IOException, SQLException{ 
            ModelAndView modelNview = new ModelAndView();
            modelNview.setViewName("scores");
            ApplicationContext factory = new ClassPathXmlApplicationContext("/spring.xml");
            PrintWriter pw=null;
            try{
                pw=response.getWriter();
                Class.forName("org.postgresql.Driver");
            }
            catch(ClassNotFoundException ex){
                ex.printStackTrace(pw);
                pw.print(ex.getMessage());
            }

            Connection conn=null;
            conn= (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","password");

            PreparedStatement ps= (PreparedStatement) conn.prepareStatement("select * from student where id = ?;");
                ps.setInt(1, Integer.parseInt(request.getParameter("id2")));
            ResultSet rs = ps.executeQuery();
            Student student =null;
            
            if(rs.next()){
                student = new Student(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3), Integer.parseInt(rs.getString(4)),rs.getString(5),rs.getString(6),rs.getString(7));
            }  
            modelNview.addObject("user",student);
            
            ps= (PreparedStatement) conn.prepareStatement("select * from smarks where stud_id = ?;");
            ps.setInt(1, Integer.parseInt(request.getParameter("id2")));
            rs=ps.executeQuery();
            List<Content> cont = new LinkedList<Content>();
            
            while(rs.next()){
                Content ctn = (Content)factory.getBean("Content");
                ctn.setId(Integer.parseInt(rs.getString(1)));
                ctn.setStud_id(Integer.parseInt(rs.getString(2)));
                ctn.setTitle(rs.getString(3));
                ctn.setScore_num(Integer.parseInt(rs.getString(5)));
                ctn.setScore_l(rs.getString(4));

                cont.add(ctn);
            }
            
            modelNview.addObject("scores",cont);
            rs.close();
            ps.close();
            return modelNview;
        }
    
}
