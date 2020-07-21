/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmdb.hibernate.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author pc
 */

@Entity
@Table(name = "GMDB_MOVIE_TAB")
public class Movie {
    
    private int movieId;
    private String movieName;
    private String runTime;
    private float rating;
    private BaseEntity baseEntity;
    private List<Purchase> purchases;
    private List<Genre> genres;

    public Movie() {
        
        purchases = new ArrayList<>();
        genres = new ArrayList<>();
    }
    public Movie(String movieName, String runTime) {
        this.movieName = movieName;
        this.runTime = runTime;
        purchases = new ArrayList<>();
        purchases = new ArrayList<>();
        genres = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }
    
    @Transient
    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Embedded
    public BaseEntity getBaseEntity() {
        return baseEntity;
    }
    
    public void setBaseEntity(BaseEntity baseEntity) {
        this.baseEntity = baseEntity;
    }

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "GMDB_MOVIE_PURCHASE_TAB",
            joinColumns = {@JoinColumn(name = "movieId")},
            inverseJoinColumns = {@JoinColumn(name = "purchaseId")})
    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

     
    @ManyToMany
    @JoinTable(name = "GMDB_MOVIE_GENRE_TAB",
                joinColumns = {@JoinColumn(name="movieId")},
                inverseJoinColumns = {@JoinColumn(name = "genreId")})
    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
    
    
    
}


