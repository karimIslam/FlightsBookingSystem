package com.BrightSkies.karim.FlightsBookingSystem.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="UserFlights")
public class UserFlights {
    @EmbeddedId
        private UserFlightsCompositeKey ufID;
        @ManyToOne(targetEntity = Users.class)
        @MapsId("uid")
        @JoinColumn(name = "uID")
        @JsonManagedReference
        private Users userr;
        @ManyToOne(targetEntity = Flights.class)
        @MapsId("fid")
        @JoinColumn(name = "fID")
        @JsonManagedReference
        private Flights flight;
        @Column(name ="TicketType")
        private boolean TicketType;
        // type = 0 = Economy, type = 1 = firstclass

    public UserFlights(Users user, Flights flight, boolean ticketType) {
        this.userr = user;
        this.flight = flight;
        this.TicketType = ticketType;
        this.ufID = new UserFlightsCompositeKey(user.getUserID(),flight.getFlightID());
    }

    @Override
    public String toString() {
        return "UserFlight{" +
                "user=" + userr.toString() +
                ", flight=" + flight.toString() +
                ", TicketType=" + TicketType +
                '}';
    }

    public UserFlights() {

    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        UserFlights that = (UserFlights) o;
        return Objects.equals(userr, that.userr) &&
                Objects.equals(flight, that.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userr, flight);
    }

    public Users getUserr() {
        return userr;
    }

    public void setUserr(Users userr) {
        this.userr = userr;
    }

    public Flights getFlight() {
        return flight;
    }

    public void setFlight(Flights flight) {
        this.flight = flight;
    }

    public boolean isTicketType() {
        return TicketType;
    }

    public void setTicketType(boolean ticketType) {
        TicketType = ticketType;
    }
}
