/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmdb.hibernate.eao;

import com.gmdb.hibernate.entity.Purchase;
import com.gmdb.hibernate.entity.User;
import java.util.List;



/**
 *
 * @author pc
 */
public interface PurchaseEao {
     void create(Purchase user);
     void seveOrUpdate(Purchase purchase);
     List<Purchase> getPurchasebyUser(int userId);
     List<Purchase> getPurchasebyMovie(int movieId);
     Purchase getPurchase(int purchaseId);
}
