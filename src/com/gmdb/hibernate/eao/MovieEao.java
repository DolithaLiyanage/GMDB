/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmdb.hibernate.eao;

import com.gmdb.hibernate.entity.Movie;
import com.gmdb.hibernate.entity.Purchase;
import java.util.List;


/**
 *
 * @author pc
 */
public interface MovieEao {
    void create(Movie movie);  
    Movie getMovie(int movieId);
    void seveOrUpdate(Movie movie);
    List<Movie> getMoviebyPurchase(int PurchaseId);
}
