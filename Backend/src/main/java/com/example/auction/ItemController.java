package com.example.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @PostMapping("/createItem")
    public ResponseEntity<String> createItem(@RequestBody Item item, @RequestParam("userId") Long userId) {
        // Fetch user from database using provided userId
        User seller = userService.getUserById(userId);
        
        // Associate the user with the item
        item.setSeller(seller);
        
        // Save the new item
        itemService.createItem(item);

        return ResponseEntity.ok("Item created successfully");
    }
}
