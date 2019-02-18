/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.services;

import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;
import edu.eci.arsw.cinema.model.Movie;
import edu.eci.arsw.cinema.persistence.CinemaException;
import edu.eci.arsw.cinema.persistence.CinemaPersistenceException;
import edu.eci.arsw.cinema.persistence.CinemaPersitence;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author cristian
 */
@Configuration
public class CinemaServices {

    @Autowired
    CinemaPersitence cps;

    public void addNewCinema(Cinema c) throws CinemaPersistenceException {
        cps.saveCinema(c);
    }

    public Map<String, Cinema> getAllCinemas() {
        return cps.getCinemas();
    }
   
    public Cinema getCinemaByName(String name) throws CinemaPersistenceException {
        return cps.getCinemaByName(name);
    }

    public void buyTicket(int row, int col, String cinema, String date, String movieName) throws CinemaException {
        cps.buyTicket(row, col, cinema, date, movieName);
    }

    public List<CinemaFunction> getFunctionsbyCinemaAndDate(String cinema, String date) {
        return cps.getFunctionsbyCinemaAndDate(cinema, date);
    }
    
    public List<Movie> getFilmsFilter(String cinema, String date, String filter) throws CinemaPersistenceException {
        return cps.filterBy(cinema, date, filter);
    }
    
}
