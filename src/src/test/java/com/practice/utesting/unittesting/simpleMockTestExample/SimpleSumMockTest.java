package com.practice.utesting.unittesting.simpleMockTestExample;

import com.practice.utesting.unittesting.businessClasses.DataService;
import com.practice.utesting.unittesting.businessClasses.SimpleSum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleSumMockTest {

    SimpleSum simpleSum = new SimpleSum();
    // with mockito, mocking data can be done programmatically, no need to explicitly declaring with class
    DataService dataServiceMock = mock(DataService.class);


    /**
     * Before executing any of the tests, inject mocked dataServiceMock to simpleSum class.
     */
    @BeforeEach
    public void doConfig() {
        simpleSum.setDataService(dataServiceMock);
    }

    @Test
    public void testSum_scenario1_UsingMock() {
        // defining behaviour of dataServiceMock
        when(dataServiceMock.getAllNumber()).thenReturn(Arrays.asList(1, 2, 3));

        int actualResult = simpleSum.calculateSum_DataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSum_scenario2_UsingMock() {
        // defining behaviour of dataServiceMock
        when(dataServiceMock.getAllNumber()).thenReturn(new ArrayList<>());

        int actualResult = simpleSum.calculateSum_DataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }
}
