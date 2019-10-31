package com.BrightSkies.karim.FlightsBookingSystem.ServiceLayer;

import com.BrightSkies.karim.FlightsBookingSystem.DataLayer.UsersRepo;
import com.BrightSkies.karim.FlightsBookingSystem.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service

public class UsersService {
    @Autowired
//    @Qualifier("1")
    private UsersRepo urepo;

    public UsersService(UsersRepo urepo) {
        this.urepo = urepo;
    }

    public List<Users> getAllUsers(){
        return urepo.findAll();
    }
    public Users userByID(int id){
        if(!urepo.findById(id).isPresent()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        return urepo.getOne(id);
    }

    public void deleteByID(int id){
        urepo.deleteById(id);
    }

    public void createUser(Users u){
        urepo.save(u);
    }

    public void modifyUser(Users modU){
        if(!urepo.findById(modU.getUserID()).isPresent()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        Users x = urepo.getOne(modU.getUserID());
        x.setName(modU.getName());
        x.setType(modU.isType());
        urepo.save(x);

    }


}
