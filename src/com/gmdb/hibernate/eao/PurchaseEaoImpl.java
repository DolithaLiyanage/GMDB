/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmdb.hibernate.eao;

import com.gmdb.hibernate.entity.BaseEntity;
import com.gmdb.hibernate.entity.Purchase;

import com.gmdb.hibernate.util.HibernateUtil;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author pc
 */
public class PurchaseEaoImpl implements PurchaseEao{
    
    SessionFactory sessionFactory;
    
    public PurchaseEaoImpl(){
        sessionFactory = HibernateUtil.getSessionFactory();
    
    }

    @Override
    public void create(Purchase purchase) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        
        session.save(purchase);
        
        session.getTransaction().commit();
        session.close();
    }
    
}
