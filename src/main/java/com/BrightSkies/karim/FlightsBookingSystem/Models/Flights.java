package com.BrightSkies.karim.FlightsBookingSystem.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name= "flights")
public class Flights {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Column(name ="flightID",nullable = false,unique = true)
    private int flightID;
    @Column(name ="location")
    private String location;
    @Column(name ="destination")
    private String destination;
    @Column(name ="arrivaltime")
    private Date arrivaltime;
    @Column(name ="departure")
    private Date departure;
    @Column(name ="fare")
    private int fare;

    @OneToMany(mappedBy = "flight",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonBackReference
    private List<UserFlights> ufs = new ArrayList<>();

    public Flights(int flightID, String location, String destination, Date arrivaltime, Date departure, int fare) {
        this.flightID = flightID;
        this.location = location;
        this.destination = destination;
        this.arrivaltime = arrivaltime;
        this.departure = departure;
        this.fare = fare;
    }

    public Flights(String location, String destination, Date arrivaltime, Date departure, int fare) {
        this.location = location;
        this.destination = destination;
        this.arrivaltime = arrivaltime;
        this.departure = departure;
        this.fare = fare;
    }

    public List<UserFlights> getUfs() {
        return ufs;
    }

    public void setUfs(List<UserFlights> ufs) {
        this.ufs = ufs;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(Date arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return flightID + " " + location + " "  + destination  + " " +  arrivaltime  + " " +  departure  + " " +  fare;
    }

    public Flights(){

    }
}
