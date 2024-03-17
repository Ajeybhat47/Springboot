package com.example.auction;

import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  

@RestController  
public class helloworld 
    {  
    @RequestMapping("/")  
    public String hello()   
    {  
        return "I am ajey";  
    }  
} 

