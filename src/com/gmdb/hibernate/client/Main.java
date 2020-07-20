/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmdb.hibernate.client;

import com.gmdb.hibernate.eao.PurchaseEao;
import com.gmdb.hibernate.eao.PurchaseEaoImpl;
import com.gmdb.hibernate.eao.UserEao;
import com.gmdb.hibernate.eao.UserEaoImpl;
import com.gmdb.hibernate.entity.Purchase;
import com.gmdb.hibernate.entity.User;
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
        
        User user1 = new User("Dolitha", "gliyyanage221@gmail.com", "app");
        Purchase purchase1 = new Purchase();
        purchase1.setPurchaseDate(new Date());
        
        purchase1.setUser(user1);
        
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

        
        List<Purchase> purchasesOfUsers = purchaseEao.getPurchasebyUser(1);
        for(Purchase p : purchasesOfUsers){
            System.out.println(p.getPurchaseId()+" - "+p.getPurchaseDate());
        }
    }
    
}
