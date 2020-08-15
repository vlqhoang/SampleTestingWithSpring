package com.practice.utesting.unittesting.simpleMockTestExample;

import com.practice.utesting.unittesting.businessClasses.DataService;
import com.practice.utesting.unittesting.businessClasses.SimpleSum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SimpleSumMockTest_Enhanced {

    @InjectMocks
    SimpleSum simpleSum;

    @Mock
    DataService dataServiceMock; // specifying mocked data obj - automatically get injected to '@InjectMocks'

    @Test
    public void testSum_scenario1_UsingMock() {
        // specifying new behaviour of dataServiceMock
        when(dataServiceMock.getAllNumber()).thenReturn(Arrays.asList(1, 2, 3));

        int actualResult = simpleSum.calculateSum_DataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSum_scenario2_UsingMock() {
        // specifying new behaviour of dataServiceMock
        when(dataServiceMock.getAllNumber()).thenReturn(new ArrayList<>());

        int actualResult = simpleSum.calculateSum_DataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    /***********************/
    @Mock
    List mockedList;

    @Test
    public void testingList_UsingMock() {
        when(mockedList.get(0)).thenReturn("Hello");
        assertEquals("Hello", mockedList.get(0));
        // assertEquals("Hello", mockedList.get(1)); // failed when trying to get any other indexes

        // with 'anyInt()', indexes can be fully covered
        when(mockedList.get(anyInt())).thenReturn("Hello");
        assertEquals("Hello", mockedList.get(10));
    }

}
