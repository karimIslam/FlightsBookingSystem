package com.BrightSkies.karim.FlightsBookingSystem.DataLayer;

import com.BrightSkies.karim.FlightsBookingSystem.Models.Flights;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//@Qualifier(value =  "1")
public interface Frepo extends JpaRepository<Flights, Integer> {
}
