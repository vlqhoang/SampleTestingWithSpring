package com.practice.utesting.unittesting.controllers;

import com.practice.utesting.unittesting.models.Item;
import com.practice.utesting.unittesting.services.BasicBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private BasicBusinessService businessService;

    @GetMapping("/getHardcodedItem")
    public Item getDataFromService() {
        return this.businessService.getHardcodedData();
    }

    @GetMapping("/getAllItems")
    public List<Item> getAllItemsFromDB() {
        return this.businessService.retrieveAllItems();
    }
}
