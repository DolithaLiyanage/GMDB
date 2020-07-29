/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmdb.hibernate.eao;

import com.gmdb.hibernate.entity.Movie;
import com.gmdb.hibernate.entity.Purchase;
import com.gmdb.hibernate.entity.Review;
import java.util.List;

/**
 *
 * @author pc
 */
public interface ReviewEao {
    void create(Review review);
     void seveOrUpdate(Review review);
     List<Review> getReviewbyPurchase(int reviewId);
     List<Review> getReviewbyMovie(int movieId);
     Purchase getPurchase(int purchaseId);
     Movie getMovie(int movieId);
}
