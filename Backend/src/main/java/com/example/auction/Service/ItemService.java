package com.example.auction.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.auction.Models.Item;
import com.example.auction.Models.User;
import com.example.auction.Repository.ItemRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserService userService;

    public void createItem(Item item, Long userId) {
        try {
            if (item == null) {
                throw new IllegalArgumentException("Item cannot be null");
            }
            
            if (userId == null) {
                throw new IllegalArgumentException("User ID cannot be null");
            }

            User user = userService.getUserById(userId);
            if (user == null) {
                throw new NoSuchElementException("User not found");
            }

            item.setSeller(user);
            itemRepository.save(item);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while creating item: " + e.getMessage(), e);
        }
    }

    public Item getItemById(Long itemId) {
        try {
            Optional<Item> item = itemRepository.findById(itemId);
            return item.orElseThrow(() -> new NoSuchElementException("Item not found"));
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching item: " + e.getMessage(), e);
        }
    }

    public String deleteItem(Long itemId) {
        try {
            if (itemRepository.existsById(itemId)) {
                itemRepository.deleteById(itemId);
                return "Item deleted successfully";
            } else {
                return "Item not found";
            }
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while deleting item: " + e.getMessage(), e);
        }
    }
}
