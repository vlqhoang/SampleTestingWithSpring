package com.practice.utesting.unittesting.integrationTestWithSpring;

import com.practice.utesting.unittesting.models.Item;
import com.practice.utesting.unittesting.repos.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


import java.util.Collections;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    ItemRepository itemRepository;

    @Test
    public void getAllItems_IntegrateTest() {

        Item mockData = new Item(1, "laptop", 100, 2);
        when(itemRepository.findAll()).thenReturn(Collections.singletonList(mockData));

        // CASE 1. Without any worries of mock data - the return value returned from real APIs
        ResponseEntity<List<Item>> response = testRestTemplate
                .exchange("http://localhost:8080/getAllItems",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Item>>() {});
        List<Item> actualResData1 = response.getBody();

        // CASE 2. With mock data, sometimes, running integration tests does not need real data -> mock it, others components works normally
        Item[] actualResData2 = testRestTemplate.getForObject("/getAllItems", Item[].class);


        assertEquals(200L, actualResData2[0].getTotalValue());
        assertEquals(200L, actualResData1.get(0).getTotalValue());
    }
}
