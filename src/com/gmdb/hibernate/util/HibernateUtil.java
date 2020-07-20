/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmdb.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author pc
 */
public class HibernateUtil {
    
    private static SessionFactory sessionFactory;

    private HibernateUtil() {
    }
    
    public static synchronized SessionFactory getSessionFactory(){
    
        if (sessionFactory == null){
        
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }
    
    return sessionFactory;
    }
    
    
}
