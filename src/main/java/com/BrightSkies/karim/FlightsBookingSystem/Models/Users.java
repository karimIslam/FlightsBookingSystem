package com.BrightSkies.karim.FlightsBookingSystem.Models;



import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="UserID",nullable = false,unique = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private int UserID;
    @Column(name ="name")
    private String name;
    @Column(name ="type")
    private boolean type = false;
    // type = 1 = admin, type = 0 = normal user

    @OneToMany(mappedBy = "userr",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonBackReference
    List<UserFlights> ufs = new ArrayList<>();
    public void addUF(Flights flight,boolean tickettype) {

        UserFlights newuf = new UserFlights(this, flight,tickettype);
        ufs.add(newuf);
    }


    public void changeUFTicket(int FID,boolean tickettype){
        for (Iterator<UserFlights> iterator = ufs.iterator();
             iterator.hasNext(); ) {
            UserFlights uf = iterator.next();

            if (uf.getUserr().getUserID() == this.getUserID() &&
                    uf.getFlight().getFlightID() == FID) {
//                uf.getUserr().getUfs().remove(uf);
                uf.setTicketType(tickettype);
//                uf.getUserr().getUfs().add(uf);
            }
        }




//        for (UserFlights f:ufs) {
//            if(f.getUserr().getUserID()==UID&&f.getFlight().getFlightID()==FID){
//
//            }
//        }
    }
    public Users(String name, boolean type) {

        this.name = name;
        this.type = type;
    }

    public Users(int id, String name, boolean type) {
        this.UserID = id;
        this.name = name;
        this.type = type;
    }



    public void removeUF(Flights f) {

        for (Iterator<UserFlights> iterator = ufs.iterator();
             iterator.hasNext(); ) {
            UserFlights uf = iterator.next();

            if (uf.getUserr().getUserID() == this.getUserID() &&
                    uf.getFlight().getFlightID() == f.getFlightID()) {
                iterator.remove();
                uf.getUserr().getUfs().remove(uf);
                uf.setUserr(null);
                uf.setFlight(null);
            }
        }

    }


    public List<UserFlights> getUfs() {
        return ufs;
    }

    public void setUfs(List<UserFlights> ufs) {
        this.ufs = ufs;
    }

    public Users(){

    }

    @Override
    public String toString() {
        return "User{" +
                "UserID=" + UserID +
                ", name='" + name + '\'' +
                ", type=" + type +

                '}';
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public void removeALLUF() {
        ufs.clear();

    }
}
