package com.BrightSkies.karim.FlightsBookingSystem.ControllerLayer;

import com.BrightSkies.karim.FlightsBookingSystem.DataLayer.UsersRepo;
import com.BrightSkies.karim.FlightsBookingSystem.Models.Users;
import com.BrightSkies.karim.FlightsBookingSystem.ServiceLayer.FlightsService;
import com.BrightSkies.karim.FlightsBookingSystem.ServiceLayer.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {



//    @Qualifier(value =  "2")
    @Autowired
    private UsersService us;


    @GetMapping()
    //find all users
    private List<Users> getAllUsers(){
        return us.getAllUsers();
    }

    @GetMapping(path = "{UID}")
    //finds a user by his uid
    public Users userByID(@PathVariable("UID") int UserID) {
        return us.userByID(UserID);
    }

    @PostMapping()
    @ResponseBody
    //creates a new user
    public void newUser(@RequestParam(name = "name") String name, @RequestParam(name = "type") boolean type){
        us.createUser(new Users(name,type));
    }
    @PutMapping
    //modifies a user information and his role (admin, normal user)
    public void modifyUser(@RequestParam(name = "id") int id ,@RequestParam(name = "name") String name, @RequestParam(name = "type") boolean type){
        us.modifyUser(new Users(id,name,type));
    }

    @DeleteMapping()
    @ResponseBody
    //creates a new user
    public void newUser(@RequestParam(name = "id") int id){
        us.deleteByID(id);
    }




}
