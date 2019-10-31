package com.BrightSkies.karim.FlightsBookingSystem.ServiceLayer;

import com.BrightSkies.karim.FlightsBookingSystem.DataLayer.Frepo;
import com.BrightSkies.karim.FlightsBookingSystem.Exceptions.EntityNotFoundException2;
import com.BrightSkies.karim.FlightsBookingSystem.Models.Flights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightsService {
    @Autowired
//    @Qualifier("2")
    private Frepo fr;

    public FlightsService(Frepo fr) {
        this.fr = fr;
    }


    public List<Flights> getAllFlights(){
        return fr.findAll();
    }
    public Flights flightByID(int id){
        if(!fr.findById(id).isPresent()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        return fr.getOne(id);
    }
    public void deleteByID(int id){
        fr.deleteById(id);
    }
    public void createFlight(Flights f){
        fr.save(f);
    }
    public void modifyFlight(Flights fmod){
        if(!fr.findById(fmod.getFlightID()).isPresent()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        Flights x = fr.getOne(fmod.getFlightID());
        x.setArrivaltime(fmod.getArrivaltime());
        x.setDeparture(fmod.getDeparture());
        x.setDestination(fmod.getDestination());
        x.setFare(fmod.getFare());
        x.setLocation(fmod.getLocation());
        fr.save(x);
    }

    public Object[] searchLoacationDest(String loc, String Dest){
        List<Flights> all = fr.findAll();

        ArrayList<Flights> res = new ArrayList<Flights>();
        for (Flights f:all) {
            if(f.getLocation() == loc&& f.getDestination()==Dest){
                res.add(f);
            }
        }
        return  res.toArray();

    }

}
