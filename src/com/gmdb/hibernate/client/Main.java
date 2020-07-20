/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmdb.hibernate.client;

import com.gmdb.hibernate.eao.UserEao;
import com.gmdb.hibernate.eao.UserEaoImpl;
import com.gmdb.hibernate.entity.User;

/**
 *
 * @author pc
 */
public class Main {
    
    public static void main(String args[]){
    
        UserEao userEao = new UserEaoImpl();
       
        User user1 = new User("Dolitha", "gliyyanage221@gmail.com", "app");
        userEao.create(user1);
        
        
    }
    
}
