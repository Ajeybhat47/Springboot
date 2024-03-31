package com.example.auction.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.auction.Models.Item;
import com.example.auction.Repository.ItemRepository;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void createItem(Item item) {
        try {
            if (item != null) {
                itemRepository.save(item);
            } else {
                throw new IllegalArgumentException("Item cannot be null");
            }
        } catch (Exception e) {
            System.err.println("Error occurred while creating item: " + e.getMessage());
        }
    }

    public Item getItemById(Long itemId) {
        try {
            Optional<Item> itemOptional = itemRepository.findById(itemId);
            return itemOptional.orElse(null);
        } catch (Exception e) {
            System.err.println("Error occurred while retrieving item: " + e.getMessage());
            return null;
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
            System.err.println("Error occurred while deleting item: " + e.getMessage());
            return "Error deleting item";
        }
    }
}
