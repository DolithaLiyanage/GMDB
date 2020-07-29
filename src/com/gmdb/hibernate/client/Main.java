/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmdb.hibernate.client;

import com.gmdb.hibernate.eao.GenreEao;
import com.gmdb.hibernate.eao.GenreEaoImpl;
import com.gmdb.hibernate.eao.MovieEao;
import com.gmdb.hibernate.eao.MovieEaoImpl;
import com.gmdb.hibernate.eao.PurchaseEao;
import com.gmdb.hibernate.eao.PurchaseEaoImpl;
import com.gmdb.hibernate.eao.ReviewEao;
import com.gmdb.hibernate.eao.ReviewEaoImpl;
import com.gmdb.hibernate.eao.UserEao;
import com.gmdb.hibernate.eao.UserEaoImpl;
import com.gmdb.hibernate.entity.Genre;
import com.gmdb.hibernate.entity.Movie;
import com.gmdb.hibernate.entity.Purchase;
import com.gmdb.hibernate.entity.Review;
import com.gmdb.hibernate.entity.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pc
 */
public class Main {

    public static void main(String args[]) {

        PurchaseEao purchaseEao = new PurchaseEaoImpl();
        UserEao userEao = new UserEaoImpl();
        MovieEao movieEao = new MovieEaoImpl();
        GenreEao genreEao = new GenreEaoImpl();
        ReviewEao reviewEao = new ReviewEaoImpl();

        Movie movie1 = new Movie("Avengers", "3 hrs 5 min");
        Movie movie2 = new Movie("Up", "2 hrs 25 min");
        Movie movie3 = new Movie("Mad Max", "2 hrs 5 min");

        Genre genre1 = new Genre("Action");
        Genre genre2 = new Genre("Drama");
        Genre genre3 = new Genre("Animation");

        //Genres are created
        genreEao.create(genre1);
        genreEao.create(genre2);
        genreEao.create(genre3);

        movie1.getGenres().add(genre1);
        movie1.getGenres().add(genre3);

        movie2.getGenres().add(genre2);
        movie3.getGenres().add(genre2);

        //movies added with genres specified
        movieEao.seveOrUpdate(movie1);
        movieEao.seveOrUpdate(movie2);
        movieEao.seveOrUpdate(movie3);

        //user1 created
        User user1 = new User("Dolitha", "gliyyanage221@gmail.com", "app");
        userEao.create(user1);

        Purchase purchase1 = new Purchase();
        purchase1.setPurchaseDate(new Date());
        purchase1.setUser(user1);

        //user1 makes purchase1 with 2 movies and one review for each movie 
        purchase1.getMovies().add(movie1);
        Review review1 = new Review("Great movie.Loved it", 8);
        review1.setPurchase(purchase1);
        review1.setMovie(movie1);

        purchase1.getMovies().add(movie3);
        Review review2 = new Review("Best Ever", 7);
        review2.setPurchase(purchase1);
        review2.setMovie(movie3);

        //user1 makes purchase1 with one movie and a review for the movie 
        Purchase purchase2 = new Purchase();
        purchase2.setPurchaseDate(new Date());
        purchase2.setUser(user1);

        purchase2.getMovies().add(movie2);
        Review review3 = new Review("Nice Movie", 8);
        review3.setPurchase(purchase1);
        review3.setMovie(movie2);

        purchaseEao.seveOrUpdate(purchase1);
        purchaseEao.seveOrUpdate(purchase2);
        reviewEao.seveOrUpdate(review1);
        reviewEao.seveOrUpdate(review2);
        reviewEao.seveOrUpdate(review3);
        //user 2 created
        User user2 = new User("Gayan", "gayan@gmail.com", "gayan123");
        userEao.create(user2);

        //user2 makes purchase3 with one movie and a review for the movie 
        Purchase purchase3 = new Purchase();
        purchase3.setPurchaseDate(new Date());
        purchase3.setUser(user2);

        purchase3.getMovies().add(movie2);
        Review review4 = new Review("Awsome", 7);
        review4.setPurchase(purchase3);
        review4.setMovie(movie2);

        //user2 makes purchase4 with one movie and a review for the movie 
        Purchase purchase4 = new Purchase();
        purchase4.setPurchaseDate(new Date());
        purchase4.setUser(user2);

        purchase4.getMovies().add(movie3);
        Review review5 = new Review("Expected more", 5);
        review5.setPurchase(purchase4);
        review5.setMovie(movie3);

        purchaseEao.seveOrUpdate(purchase3);
        purchaseEao.seveOrUpdate(purchase4);
        reviewEao.seveOrUpdate(review4);
        reviewEao.seveOrUpdate(review5);

        //Dislay all the movies the selected user has purchased
        User dispUser = userEao.getUser(1);
        List<Purchase> purchases = dispUser.getPurchases();
        int ipd = 0;
        for (Purchase p : purchases) {
            if (ipd != p.getPurchaseId()) {

                int pid = p.getPurchaseId();
                Purchase dispPurchase = purchaseEao.getPurchase(pid);
                List<Movie> movies = dispPurchase.getMovies();
                int mid = 0;

                for (Movie m : movies) {

                    if (mid != m.getMovieId()) {

                        System.out.println(p.getUser().getUser_name() + " has purchased " + m.getMovieName());
                        mid = m.getMovieId();
                    }
                }

                ipd = p.getPurchaseId();
            }

        }

        
        //Calculate and show average rating of a selected movie
        int id_movie = 3;
        List<Review> reviewsOfMovies = reviewEao.getReviewbyMovie(id_movie);
        Movie dispMovie = movieEao.getMovie(id_movie);
        int rating = 0;
        float i = 0;
        
            for (Review r : reviewsOfMovies) {
                rating = rating + r.getRating();
                i = i + 1;
            }
            
        System.out.println(dispMovie.getMovieName() + " is rated at " + rating / i);
    }

}
