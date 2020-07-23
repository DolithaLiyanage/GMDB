/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmdb.hibernate.eao;

import com.gmdb.hibernate.entity.Genre;
import com.gmdb.hibernate.entity.Movie;
import java.util.List;

/**
 *
 * @author pc
 */
public interface GenreEao {
    void create(Genre genre);  
    Genre getGenre(int genreId);
    void seveOrUpdate(Genre genre);
    List<Genre> getGenrebyMovie(int MovieId);
}
