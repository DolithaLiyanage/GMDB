/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmdb.hibernate.eao;

import com.gmdb.hibernate.entity.User;

/**
 *
 * @author pc
 */
public interface UserEao {
    
    void create(User user);
    
    User getUser(int userId);
    
}
