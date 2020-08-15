package com.practice.utesting.unittesting.simpleMockTestExample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Verify gives users the capability to test method related features
 */
@ExtendWith(MockitoExtension.class)
public class VerifyMockTest {

    @Mock
    List<String> mockedList;

    @Test
    public void verification_basic() {
        when(mockedList.get(anyInt())).thenReturn("Hi!.");
        mockedList.get(0);
        mockedList.get(1);

        // doing verify
        verify(mockedList).get(0); // verify to see if 'get' method is invoked.
        verify(mockedList, times(2)).get(anyInt()); // verifying the number of invocations of 'get' method to any index.
        verify(mockedList, atLeastOnce()).get(anyInt()); // verifying the 'get' method is invoked at least 1 tine for any index.
        verify(mockedList, never()).get(2); // verifying the 'get' of the second index net get queried.
    }
}
