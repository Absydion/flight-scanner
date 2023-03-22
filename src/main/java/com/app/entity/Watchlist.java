package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String user;
    public String getuser() {
        return user;
    }
    public void setuser(String newuser) {
        this.user = newuser;
    }
    private String name;
    public String getname() {
        return name;
    }
    public void setname(String newname) {
        this.user = newname;
    }
    private List<Flight> Flightlist;
    public List<Flight> getFlightlist() {
        return Flightlist;
    }
    public void setname(List<Flight> Flightlist) {
        this.Flightlist = Flightlist;
    }

    private LocalDateTime created_at_datetime;
    private LocalDateTime updated_at_datetime;
}
