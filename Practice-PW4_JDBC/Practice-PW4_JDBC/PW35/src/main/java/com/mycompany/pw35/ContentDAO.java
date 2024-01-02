/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pw35;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Admin
 */
@Repository("ContentDAO")
@EnableTransactionManagement
public class ContentDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    public List<Content> getScores(int st_id){
        Session session = sessionFactory.getCurrentSession();
        List <Content> cntn = session.createQuery("FROM Content where stud_id = :stid").setParameter("stid", st_id).list();
        return cntn;
    }
}
