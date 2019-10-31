package com.BrightSkies.karim.FlightsBookingSystem.DataLayer;

import com.BrightSkies.karim.FlightsBookingSystem.Models.UserFlights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFlightsRepo extends JpaRepository<UserFlights,Integer> {
}
