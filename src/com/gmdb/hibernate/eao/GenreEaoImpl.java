/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmdb.hibernate.eao;

import com.gmdb.hibernate.entity.Genre;
import com.gmdb.hibernate.entity.Movie;
import com.gmdb.hibernate.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author pc
 */
public class GenreEaoImpl implements GenreEao{
    
    SessionFactory sessionFactory;

    public GenreEaoImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();

    }

    @Override
    public void create(Genre genre) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(genre);

        session.getTransaction().commit();
        session.close();}

    @Override
    public Genre getGenre(int genreId) {
        Session session = sessionFactory.openSession();
        Genre genre =(Genre) session.get(Movie.class, genreId);
        session.close();
        return genre;
}

    @Override
    public void seveOrUpdate(Genre genre) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(genre);

        session.getTransaction().commit();
        session.close();}

    @Override
    public List<Genre> getGenrebyMovie(int movieId) {
       String hql = "FROM Genre g Where g.movie.movieId = :movie_Id";
        Session session = sessionFactory.openSession();
        
        Query query = session.createQuery(hql);
        query.setParameter("movie_Id", movieId);
        
        List<Genre> genres = query.list();
        session.close();
        return genres;}
}

    