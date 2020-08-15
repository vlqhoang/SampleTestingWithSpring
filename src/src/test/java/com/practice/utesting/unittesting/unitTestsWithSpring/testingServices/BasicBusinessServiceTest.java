package com.practice.utesting.unittesting.unitTestsWithSpring.testingServices;

import com.practice.utesting.unittesting.models.Item;
import com.practice.utesting.unittesting.repos.ItemRepository;
import com.practice.utesting.unittesting.services.BasicBusinessService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BasicBusinessServiceTest {

    @InjectMocks
    BasicBusinessService businessService;

    @Mock
    ItemRepository itemRepository;

    @Test
    public void testGetAllItemsFunc() {

        // Assume that repository will return 1 item
        Item mockItem = new Item(1000, "Item", 10, 20);
        when(itemRepository.findAll()).thenReturn(Collections.singletonList(mockItem));

        // then expecting a totalValue of '200'
        long expectedTotalValue = 200L;
        List<Item> items = businessService.retrieveAllItems();
        assertEquals(expectedTotalValue, items.get(0).getTotalValue());
    }
}
