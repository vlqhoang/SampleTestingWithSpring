package com.practice.utesting.unittesting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = {"classpath:application.properties"}) // dynamic config
class UnitTestingApplicationTests {

    @Test
    void contextLoads() {

    }

}
