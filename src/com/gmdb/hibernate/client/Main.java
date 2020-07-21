/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmdb.hibernate.client;

import com.gmdb.hibernate.eao.MovieEao;
import com.gmdb.hibernate.eao.MovieEaoImpl;
import com.gmdb.hibernate.eao.PurchaseEao;
import com.gmdb.hibernate.eao.PurchaseEaoImpl;
import com.gmdb.hibernate.eao.UserEao;
import com.gmdb.hibernate.eao.UserEaoImpl;
import com.gmdb.hibernate.entity.Movie;
import com.gmdb.hibernate.entity.Purchase;
import com.gmdb.hibernate.entity.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pc
 */
public class Main {
    
    public static void main(String args[]){
    
        PurchaseEao purchaseEao = new PurchaseEaoImpl();
        UserEao userEao = new UserEaoImpl();
        MovieEao movieEao = new MovieEaoImpl();
        
        List<Movie> mov = new ArrayList<>();
        
        Movie movie1 = new Movie("Avengers","3 hrs 5 min");
        Movie movie2 = new Movie("Up","2 hrs 25 min");
        Movie movie3 = new Movie("Mad Max","2 hrs 5 min");
        
        User user1 = new User("Dolitha", "gliyyanage221@gmail.com", "app");
        Purchase purchase1 = new Purchase();
        purchase1.setPurchaseDate(new Date());
        
        mov.add(movie1);
        mov.add(movie2);
        
        purchase1.setMovies(mov);
        
        userEao.create(user1);
        movieEao.create(movie3);
        purchaseEao.create(purchase1);
        
        Purchase purchase2 = new Purchase();
        purchase2.setPurchaseDate(new Date()); 
        Purchase purchase3 = new Purchase();
        purchase3.setPurchaseDate(new Date());
        
        User auser = userEao.getUser(1);
        
       
        
        purchase2.setUser(auser);
        purchase3.setUser(auser);
        
        
        
        purchaseEao.seveOrUpdate(purchase2);
        purchaseEao.seveOrUpdate(purchase3);
        movieEao.seveOrUpdate(movie1);
        
        User user2 = new User("Gayan","gayan@gmail.com","gayan123");
        
        Purchase purchase4 = new Purchase();
        purchase4.setPurchaseDate(new Date()); 
        Purchase purchase5 = new Purchase();
        purchase5.setPurchaseDate(new Date());
        
        purchase4.setUser(user2);
        purchase5.setUser(user2);
        
        user2.getPurchases().add(purchase4);
        user2.getPurchases().add(purchase5);
        
        userEao.create(user2);
        
        User dispUser = userEao.getUser(1);
        System.out.println(dispUser.getUserId()+" - " +dispUser.getUser_name());
        
        List<Purchase> purchases = dispUser.getPurchases();
        
        for (Purchase p: purchases){
        
            System.out.println(p.getPurchaseId()+ " - "+p.getPurchaseDate());
        }

        
        List<Purchase> purchasesOfUsers = purchaseEao.getPurchasebyUser(2);
        for(Purchase p : purchasesOfUsers){
            System.out.println(p.getPurchaseId()+" - "+p.getPurchaseDate());
        }
    }
    
}
