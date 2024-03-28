package com.example.auction;
// UserController.java


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    
    // @PostMapping("/login")
    // public ResponseEntity<String> loginUser(@RequestBody userLoginRequest userLoginRequest) {
    //     User user = userService.fetchByemail(userLoginRequest.getEmail());
        
    //     // Check if the user exists and the password is correct
    //     if (user != null && user.getPassword().equals(userLoginRequest.getPassword())) {
    //         return ResponseEntity.ok("Login successful"); // Return a success response
    //     } else {
    //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password"); // Return an error response
    //     }

    // }


    @PostMapping
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
