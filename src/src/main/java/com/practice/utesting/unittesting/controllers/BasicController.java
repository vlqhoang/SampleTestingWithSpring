package com.practice.utesting.unittesting.controllers;

import com.practice.utesting.unittesting.models.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("/getSimpleMessage")
    public String getSimpleMessage() {
        return "Hello";
    }

    @GetMapping("/getSimpleJsonMessage")
    public Item getSimpleJsonMessage() {
        return new Item(1, "laptop", 1000, 100);
    }
}
