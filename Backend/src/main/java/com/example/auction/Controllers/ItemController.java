package com.example.auction.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.auction.Models.Item;
import com.example.auction.Service.ItemService;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/create")
    public ResponseEntity<String> createItem(@RequestBody Item item, @RequestParam("farmerId") Long farmerId) {
        try {
            itemService.createItem(item, farmerId);
            return ResponseEntity.ok("Item created successfully");
        } catch (IllegalArgumentException | NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating item");
            // updated
        }
    }

    @GetMapping("/getItem")
    public ResponseEntity<?> getItemById(@RequestParam("itemId") Long itemId) {
        try {
            Item item = itemService.getItemById(itemId);
            return ResponseEntity.ok(item);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching item");
        }
    }

    @DeleteMapping("/deleteItem")
    public ResponseEntity<String> deleteItem(@RequestParam("itemId") Long itemId) {
        try {
            String result = itemService.deleteItem(itemId);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting item");
        }
    }
}
