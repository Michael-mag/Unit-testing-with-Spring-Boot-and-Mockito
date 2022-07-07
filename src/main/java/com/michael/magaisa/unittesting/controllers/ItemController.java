package com.michael.magaisa.unittesting.controllers;


import com.michael.magaisa.unittesting.model.Item;
import com.michael.magaisa.unittesting.services.ItemBusinessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemBusinessServiceImpl itemBusinessServiceImpl;

    @GetMapping("/dummy-item")
    public Item dummyItem(){
        return new Item(1, "MacBook", 1239, 1);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService(){
        return itemBusinessServiceImpl.retrieveHardCodedItem();
    }

    @GetMapping("/all-items")
    public List<Item> retrieveAllItems(){
        return itemBusinessServiceImpl.getAllItems();
    }
}
