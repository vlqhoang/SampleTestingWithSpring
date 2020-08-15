package com.practice.utesting.unittesting.unitTestsWithSpring.testingRepos;

import com.practice.utesting.unittesting.models.Item;
import com.practice.utesting.unittesting.repos.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * In real world application, profiles and real DBs will be applied.
 * => In testing => H2 DB will be used.
 * In this example, script under test/resources will be executed for testing purpose; After tests are fully processed, data will be deleted.
 */
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void testFindAll() {
        List<Item> items = itemRepository.findAll();
        assertEquals(5, items.size());
    }
}
