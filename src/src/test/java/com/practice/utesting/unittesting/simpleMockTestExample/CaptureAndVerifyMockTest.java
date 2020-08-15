package com.practice.utesting.unittesting.simpleMockTestExample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * For the purpose of capturing arguments, 'ArgumentCaptor' can help with capturing arguments
 */
@ExtendWith(MockitoExtension.class)
public class CaptureAndVerifyMockTest {

    @Mock
    List<String> mockedList;

    @Test
    public void argumentCapturing() {

        mockedList.add("Something1");
        mockedList.add("Something2");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockedList, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();
        assertEquals("Something1", allValues.get(0));
        assertEquals("Something2", allValues.get(1));
    }
}
