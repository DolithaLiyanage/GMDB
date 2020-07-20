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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author pc
 */

@Entity
@Table(name = "GMDB_ACTOR_TAB")
public class Actor {
    
    private int actorId;
    private String actorName;
    private List<Movie> movies;

    public Actor() {
        
     movies = new ArrayList<>();
    }

    public Actor(String actorName) {
        this.actorName = actorName;
        movies = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }
    
    @ManyToMany
    @JoinTable(name = "GMDB_MOVIE_ACTOR_TAB",
                joinColumns = {@JoinColumn(name="actorId")},
                inverseJoinColumns = {@JoinColumn(name = "movieId")})
    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    
    
    
}
