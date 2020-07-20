/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmdb.hibernate.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author pc
 */

@Entity
@Table(name = "GMDB_DIRECTOR_TAB")
public class Director {
    
    private int directorId;
    private String directorName;
    private List<Movie> movies;

    public Director() {
        movies = new ArrayList<>();
        
    }

    public Director(String directorName) {
        this.directorName = directorName;
        movies = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
    

    @ManyToMany
    @JoinTable(name = "GMDB_MOVIE_DIRECTOR_TAB",
                joinColumns = {@JoinColumn(name="directorId")},
                inverseJoinColumns = {@JoinColumn(name = "movieId")})
    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    
    
    
}
