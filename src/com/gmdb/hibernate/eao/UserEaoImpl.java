/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmdb.hibernate.eao;

import com.gmdb.hibernate.entity.BaseEntity;
import com.gmdb.hibernate.entity.User;
import com.gmdb.hibernate.util.HibernateUtil;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author pc
 */
public class UserEaoImpl implements UserEao{
    
    SessionFactory sessionFactory;
    
    public UserEaoImpl(){
        sessionFactory = HibernateUtil.getSessionFactory();
    
    }

    @Override
    public void create(User user) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        BaseEntity baseEntity = new BaseEntity();
        baseEntity.setCreatedBy("user");
        baseEntity.setCreatedDate(new Date());
        user.setBaseEntity(baseEntity);
        
        session.save(user);
        
        session.getTransaction().commit();
        session.close();
    }
    
}
