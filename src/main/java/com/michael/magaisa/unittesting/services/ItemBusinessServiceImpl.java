package com.michael.magaisa.unittesting.services;

import com.michael.magaisa.unittesting.model.Item;
import com.michael.magaisa.unittesting.model.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessServiceImpl implements ItemBusinessService{

    @Autowired
    private ItemRepository itemRepository;
    @Override
    public Item retrieveHardCodedItem() {
        return new Item(1, "MacBook Pro 2020 M1 Chip", 1250, 11);
    }

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }
}
