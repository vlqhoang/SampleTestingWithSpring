package com.practice.utesting.unittesting.simpleMockTestExample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SpyMockTest {

    @Mock
    ArrayList<String> arrayListMock;

    @Spy
    ArrayList<String> arrayListSpy;

    /**
     * For mocking obj, mock data will always fall back to defaults unless you override its behaviours.
     */
    @Test
    public void mock() {
        arrayListMock.add("hello1");
        System.out.println(arrayListMock.get(0)); // null
        System.out.println(arrayListMock.size()); // 0

        when(arrayListMock.size()).thenReturn(5); // override behaviour.
        System.out.println(arrayListMock.size()); // => 5

        arrayListMock.add("hello2");
        System.out.println(arrayListMock.size()); // => still 5 (following indicated behaviour)
        System.out.println(arrayListMock.get(0)); // => still null (falling back to default)
        System.out.println(arrayListSpy.get(1)); // => still null (falling back to default)
    }

    /**
     * For spying, data is actually get processed until it is override
     */
    @Test
    public void spy() {
        arrayListSpy.add("hello1");
        System.out.println(arrayListSpy.get(0)); // hello1
        System.out.println(arrayListSpy.size()); // 1

        when(arrayListSpy.size()).thenReturn(5); // override behaviour.
        System.out.println(arrayListSpy.size()); // => 5

        arrayListSpy.add("hello2");
        System.out.println(arrayListSpy.size()); // => still 5 (following indicated behaviour)
        System.out.println(arrayListSpy.get(0)); // => hello 1 (using actual data, as long as it is not override)
        System.out.println(arrayListSpy.get(1)); // => hello 2 (using actual data, as long as it is not override)
    }
}
