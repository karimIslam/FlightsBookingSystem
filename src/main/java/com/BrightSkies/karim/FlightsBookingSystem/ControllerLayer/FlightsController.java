package com.BrightSkies.karim.FlightsBookingSystem.ControllerLayer;

import com.BrightSkies.karim.FlightsBookingSystem.DataLayer.Frepo;
import com.BrightSkies.karim.FlightsBookingSystem.Models.Flights;
import com.BrightSkies.karim.FlightsBookingSystem.ServiceLayer.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("/flights")
public class FlightsController {

    @Autowired
    private FlightsService fs;

//    @Qualifier(value =  "1")

    @GetMapping()
    //Lists all Flights in DB
    private Collection<Flights> getAllFlights(){
        return fs.getAllFlights();
    }

    @GetMapping(path = "{UID}")
    //Gets a flight by its ID
    public String flightByID(@PathVariable("UID") int UserID) {
        return fs.flightByID(UserID).toString();

    }

    @PostMapping()
    @ResponseBody
    //Creates a new flight
    public void newFlight(@RequestParam(name = "location") String location, @RequestParam(name = "destination")
        String destination, @RequestParam(name = "arrivaltime") Date arrivaltime,
                          @RequestParam(name = "departure") Date departure,
                          @RequestParam(name = "fare")  int fare){
        fs.createFlight(new Flights(location,destination,arrivaltime,departure,fare));
    }
    @PutMapping
    //Modifies a flight
    public void modifyFlight(@RequestParam(name = "id") int id,
            @RequestParam(name = "location") String location, @RequestParam(name = "destination")
            String destination, @RequestParam(name = "arrivaltime") Date arrivaltime,
                          @RequestParam(name = "departure") Date departure,
                          @RequestParam(name = "fare")  int fare){
        fs.modifyFlight(new Flights(id,location,destination,arrivaltime,departure,fare));
    }

    @DeleteMapping()
    @ResponseBody
    //Cancels a flight
    public void deleteFlight(@RequestParam(name = "id") int id){
        fs.deleteByID(id);
    }

    @GetMapping(path = "/search")
    @ResponseBody
    // Returns all flights with the same location and destination input in response body
    public Object[] searchLocDest(@RequestParam(name = "location") String loc,
                                   @RequestParam(name = "destination") String destination){
        return fs.searchLoacationDest(loc,destination);
    }

}
