package com.example.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void createItem(Item item) {
        if(item != null)
            itemRepository.save(item);
        else
            System.out.println("Item is null");
    }

    public Item getItemById(Long itemId) {
        
        return itemRepository.findById(itemId).orElse(null);
    }

    public String deleteItem(Long itemId) {
        if(itemRepository.existsById(itemId))
        {
            itemRepository.deleteById(itemId);
            return "Item deleted successfully";
        }
        else
            return "Item not found";
    }
}
