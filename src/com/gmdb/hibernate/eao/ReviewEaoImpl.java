/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmdb.hibernate.eao;

import com.gmdb.hibernate.entity.Movie;
import com.gmdb.hibernate.entity.Purchase;
import com.gmdb.hibernate.entity.Review;
import com.gmdb.hibernate.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author pc
 */
public class ReviewEaoImpl implements ReviewEao{

    SessionFactory sessionFactory;
    
    public ReviewEaoImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    
    

    @Override
    public void create(Review review) {
Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(review);

        session.getTransaction().commit();
        session.close();    }

    @Override
    public void seveOrUpdate(Review review) {
Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(review);

        session.getTransaction().commit();
        session.close();     }

    @Override
    public List<Review> getReviewbyPurchase(int purchaseId) {
String hql = "FROM Review r Where r.purchase.purchaseId = :purchase_Id";
        Session session = sessionFactory.openSession();

        Query query = session.createQuery(hql);
        query.setParameter("purchase_Id", purchaseId);

        List<Review> reviews = query.list();
        session.close();
        return reviews;    }

    @Override
    public List<Review> getReviewbyMovie(int movieId) {
String hql = "FROM Review r Where r.movie.movieId = :movie_Id";
        Session session = sessionFactory.openSession();

        Query query = session.createQuery(hql);
        query.setParameter("movie_Id", movieId);

        List<Review> reviews = query.list();
        session.close();
        return reviews;      }

    @Override
    public Purchase getPurchase(int purchaseId) {
 Session session = sessionFactory.openSession();
        Purchase purchase = (Purchase) session.get(Purchase.class, purchaseId);
        session.close();
        return purchase;    }

    @Override
    public Movie getMovie(int movieId) {
 Session session = sessionFactory.openSession();
        Movie movie = (Movie) session.get(Movie.class, movieId);
        session.close();
        return movie;    }
    
    
}
