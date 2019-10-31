package com.BrightSkies.karim.FlightsBookingSystem.ServiceLayer;

import com.BrightSkies.karim.FlightsBookingSystem.DataLayer.Frepo;
import com.BrightSkies.karim.FlightsBookingSystem.DataLayer.UserFlightsRepo;
import com.BrightSkies.karim.FlightsBookingSystem.DataLayer.UsersRepo;
import com.BrightSkies.karim.FlightsBookingSystem.Models.Flights;
import com.BrightSkies.karim.FlightsBookingSystem.Models.UserFlights;
import com.BrightSkies.karim.FlightsBookingSystem.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
@Service
public class ufService {
    @Autowired
//    @Qualifier("2")
    private UserFlightsRepo uf;
    @Autowired
    private UsersRepo ur;
    @Autowired
    private Frepo fr;

    public ufService(UserFlightsRepo uf) {
        this.uf = uf;
    }

    public void deleteAllByUID(int id) {
        if(!ur.findById(id).isPresent()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User Has no Flights Booked"
            );
        }
        Users x = ur.getOne(id);
        x.removeALLUF();
        ur.save(x);
    }

    public List<UserFlights> getallUserFlights(){
        return uf.findAll();
    }

    public List<UserFlights> getallByUID(Users u){
        return (List<UserFlights>) u.getUfs();
    }


    public void createUF(int uID,int fID, boolean tickettype){
        Users u = ur.getOne(uID);
        Flights f = fr.getOne(fID);
        u.addUF(f,tickettype);
        ur.save(u);



//        fr.save(f);

//        Users u = ur.getOne(uID);
//        Set<UserFlights> uuf = u.getUfs();
//        uuf.add(new UserFlights(uID,fID,tickettype));
//        u.setUfs(uuf);
//        for (UserFlights ufff:u.getUfs()) {
//            System.out.println(ufff.toString());
//        }
//        ur.save(u);
//        Flights f = fr.getOne(fID);
//        Set<UserFlights> fuf = f.getUfs();
//        fuf.add(new UserFlights(uID,fID,tickettype));
//        for (UserFlights ufff:fuf) {
//            System.out.println(ufff.toString());
//        }
//        f.setUfs(fuf);
//        fr.save(f);
//        for (UserFlights ufff:ur.getOne(uID).getUfs()) {
//            System.out.println(ufff.toString());
//        }
//        System.out.println(u.getUfs().toArray().toString());
    }




    public void upgradeTicketUser(int uID,int flightID , boolean b){
        if(!ur.findById(uID).isPresent()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User not found"
            );
        }
        Users u = ur.getOne(uID);
        u.changeUFTicket(flightID,b);
        ur.save(u);

    }
    public void deleteUF(int UID, int flightID){
        if(!ur.findById(UID).isPresent()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User Has no booked tickets"
            );
        }
        Users u = ur.getOne(UID);
        u.removeUF(fr.getOne(flightID));
        ur.save(u);
    }

}
