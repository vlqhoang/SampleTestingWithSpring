package com.practice.utesting.unittesting.services;

import com.practice.utesting.unittesting.models.Item;
import com.practice.utesting.unittesting.repos.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasicBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    public Item getHardcodedData() {
        return new Item(1, "laptop", 1000, 100);
    }

    public List<Item> retrieveAllItems() {
        return this.itemRepository.findAll()
                .stream()
                .peek(item -> item.setTotalValue(item.getQuantity() * item.getPrice()))
                .collect(Collectors.toList());
    }
}
