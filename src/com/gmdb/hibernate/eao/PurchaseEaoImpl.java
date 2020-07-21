/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmdb.hibernate.eao;

import com.gmdb.hibernate.entity.BaseEntity;
import com.gmdb.hibernate.entity.Purchase;
import com.gmdb.hibernate.entity.User;

import com.gmdb.hibernate.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author pc
 */
public class PurchaseEaoImpl implements PurchaseEao {

    SessionFactory sessionFactory;

    public PurchaseEaoImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();

    }

    @Override
    public void create(Purchase purchase) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(purchase);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void seveOrUpdate(Purchase purchase) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(purchase);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Purchase> getPurchasebyUser(int userId) {

        String hql = "FROM Purchase p Where p.user.userId = :user_Id";
        Session session = sessionFactory.openSession();

        Query query = session.createQuery(hql);
        query.setParameter("user_Id", userId);

        List<Purchase> purchases = query.list();
        session.close();
        return purchases;

    }

    @Override
    public Purchase getPurchase(int purchaseId) {
        
        Session session = sessionFactory.openSession();
        Purchase purchase = (Purchase) session.get(Purchase.class, purchaseId);
        session.close();
        return purchase;
    }

    @Override
    public List<Purchase> getPurchasebyMovie(int movieId) {
         String hql = "FROM Purchase p Where p.movie.movieId = :movie_Id";
        Session session = sessionFactory.openSession();

        Query query = session.createQuery(hql);
        query.setParameter("movie_Id", movieId);

        List<Purchase> purchases = query.list();
        session.close();
        return purchases;
    }

}
