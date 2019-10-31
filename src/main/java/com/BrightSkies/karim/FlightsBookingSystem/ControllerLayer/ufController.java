package com.BrightSkies.karim.FlightsBookingSystem.ControllerLayer;


import com.BrightSkies.karim.FlightsBookingSystem.Models.Flights;
import com.BrightSkies.karim.FlightsBookingSystem.Models.UserFlights;
import com.BrightSkies.karim.FlightsBookingSystem.ServiceLayer.FlightsService;
import com.BrightSkies.karim.FlightsBookingSystem.ServiceLayer.UsersService;
import com.BrightSkies.karim.FlightsBookingSystem.ServiceLayer.ufService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userflights")
public class ufController {
    @Autowired
    private UsersService uService;
    @Autowired
    private FlightsService fService;
    @Autowired
    private ufService uFService;

    @GetMapping
    //lists all flights booked by users
    public List<UserFlights> getall(){
        return uFService.getallUserFlights();

    }

    @PostMapping(path = "/bookflight")
    @ResponseBody
    //books a flight for a certain user
    public void bookFlight(@RequestParam("UID") int Uid,@RequestParam("FID") int FID,
                           @RequestParam("tickettype") boolean tickettype){
        System.out.println("imhere");
        try {
            uFService.createUF(Uid, FID, tickettype);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    @GetMapping(path = "/user")
    @ResponseBody
    // gets all flights booked by a user by his uid
    public String getallbyuid(@RequestParam("uid")int id){
        String res = "";
        for (UserFlights ff:uFService.getallByUID(uService.userByID(id))) {
                res+=ff.toString();
        }
        return res;
//        List<UserFlights> no1 = uFService.getallByUID(uService.userByID(id));
//        String res = "";
//        for (Flights f:fService.getAllFlights()) {
//            for (UserFlights u:no1){
//                if(u.getFlightID()==f.getFlightID()){
//                    res+=f.toString()+" "+ u.toString();
//                }
//            }
//        }
//        return res;

    }

    @DeleteMapping(path = "/user")
    @ResponseBody
    // Deletes all flights booked for a certain user
    public void deleteallbyuid(@RequestParam("uid")int id){
        uFService.deleteAllByUID(id);
    }

    @DeleteMapping(path = "/user/flight")
    @ResponseBody
    //cancels a flight for a certain user by his id and the flight id
    public void cancelFlight(@RequestParam("uid")int uid,@RequestParam("fid")int fid){
        uFService.deleteUF(uid,fid);
    }

    @PostMapping(path = "/user/flight")
    @ResponseBody
    // Changes ticket type , Available ticket types  = 0 = economy , 1 = first class
    public void upgradeTicket(@RequestParam("uid")int uid,@RequestParam("fid")int fid
            ,@RequestParam("tickettype")boolean tickettype){
        uFService.upgradeTicketUser(uid,fid,tickettype);
    }

}
