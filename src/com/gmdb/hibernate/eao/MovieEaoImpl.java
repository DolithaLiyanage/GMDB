/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmdb.hibernate.eao;

import com.gmdb.hibernate.entity.Movie;
import com.gmdb.hibernate.entity.Purchase;
import com.gmdb.hibernate.entity.User;
import com.gmdb.hibernate.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author pc
 */
public class MovieEaoImpl implements MovieEao {

    SessionFactory sessionFactory;

    public MovieEaoImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();

    }

    @Override
    public void create(Movie movie) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(movie);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Movie getMovie(int movieId) {
        Session session = sessionFactory.openSession();
        Movie movie = (Movie) session.get(Movie.class, movieId);
        session.close();
        return movie;}

    @Override
    public void seveOrUpdate(Movie movie) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(movie);

        session.getTransaction().commit();
        session.close();}

    @Override
    public List<Movie> getMoviebyPurchase(int purchaseId) {
       String hql = "FROM Movie m Where m.purchase.purchaseId = :purchase_Id";
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery(hql);
        query.setParameter("purchase_Id", purchaseId);
        
        List<Movie> movies = query.list();
        session.close();
        return movies;}
}
