/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UserContent", urlPatterns = {"/UserContent"})
public class UserContent extends HttpServlet {
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    try{
        ApplicationContext factory = new ClassPathXmlApplicationContext("/spring.xml");

        HttpSession session = request.getSession();
        List<Content> scores = (List<Content>)session.getAttribute("scores");
        
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
        session.setAttribute("user", student);
        
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
        
        session.setAttribute("scores", cont);
        response.sendRedirect("scores.jsp");
        
        }catch(SQLException ex){
                Logger.getLogger(StudentAdd.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
