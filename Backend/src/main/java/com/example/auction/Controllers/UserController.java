package com.example.auction.Controllers;
// UserController.java


import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.auction.DTOModels.UserDTO;
import com.example.auction.Models.User;
import com.example.auction.Service.UserService;

import java.util.List;


@RestController
@RequestMapping("/api/users/getAllUsers")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    

    @PostMapping("/createUser")
    public String createUser(@RequestBody User user) {
        userService.createUser(user);
        return "Saved..." ;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id)
    {
        userService.deleteUser(id);
        return "Deleted...";
    }

    


    // @GetMapping("/byid/{id}")
    // public String Custom(@PathVariable Long id){
        
        
    //     return userService.Custom(id).getUsername();
    // }

}
