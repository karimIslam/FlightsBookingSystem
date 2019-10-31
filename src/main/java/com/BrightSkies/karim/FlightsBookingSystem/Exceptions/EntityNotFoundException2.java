package com.BrightSkies.karim.FlightsBookingSystem.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Entity not found in DB")
public class EntityNotFoundException2 {
    public EntityNotFoundException2(String exception){

    }
}
