package com.example.auction.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.auction.DTOModels.UserDTO;
import com.example.auction.Models.User;
import com.example.auction.Service.UserService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
// import com.example.auction.Repository.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/api/users")
public class UserController {
    // @Autowired
    // private UserRepository userRepository;

    @Autowired
    private UserService userService;

    // @GetMapping("/login")
    // public String login() {
    //     return "login";
    // }

    // @PostMapping("/login")
    // public String login(@RequestParam String username, @RequestParam String password, Model model) {
    //     User user = userService.getUserByUsername(username);
    //     if (user != null && user.getPassword().equals(password)) {
    //         model.addAttribute("user", user);
    //         return "home";
    //     } else {
    //         model.addAttribute("error", "Invalid username or password");
    //         return "login";
    //     }
    // }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllUsers() {
        try {
            List<UserDTO> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/getUserById")
    public ResponseEntity<?> getUserById(@RequestParam("userId") Long id) {
        try {
            UserDTO user = userService.getUserDTOById(id);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            userService.createUser(user);
            return ResponseEntity.ok("User created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }


}
