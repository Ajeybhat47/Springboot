package com.example.auction.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.auction.DTOModels.UserDTO;
import com.example.auction.Models.User;
import com.example.auction.Service.UserService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/")

public class LoginController{

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        try {
            User user = userService.getUserByUsername(username);
            if (user != null && user.getPassword().equals(password)) {
                model.addAttribute("user", user);
                return "home";
            } else {
                model.addAttribute("error", "Invalid username or password");
                return "login";
            }
        } catch (RuntimeException e) {
            model.addAttribute("error",e.getMessage());
            return "login";
        }
    }
}