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

}
