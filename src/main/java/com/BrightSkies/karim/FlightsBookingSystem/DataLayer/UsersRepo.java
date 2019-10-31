package com.BrightSkies.karim.FlightsBookingSystem.DataLayer;

import com.BrightSkies.karim.FlightsBookingSystem.Models.Users;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//@Qualifier(value =  "2")
public interface UsersRepo extends JpaRepository<Users,Integer> {
}
