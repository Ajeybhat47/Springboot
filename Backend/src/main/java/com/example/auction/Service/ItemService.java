package com.example.auction.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.auction.Models.Item;
import com.example.auction.Models.Farmer;
import com.example.auction.Repository.FarmerRepository;
import com.example.auction.Repository.ItemRepository;

import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private FarmerRepository farmerRepository;

    public void createItem(Item item, Long farmerId) {
        try {
            if (item == null) {
                throw new IllegalArgumentException("Item cannot be null");
            }

            if (farmerId == null) {
                throw new IllegalArgumentException("Farmer ID cannot be null");
            }

            Farmer farmer = farmerRepository.findById(farmerId)
                    .orElseThrow(() -> new NoSuchElementException("Farmer not found"));

            item.setSeller(farmer);
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
