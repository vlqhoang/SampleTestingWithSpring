package com.practice.utesting.unittesting.businessClasses;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class SimpleSum {

    @Getter @Setter
    private DataService dataService;

    /**
     * A simple method adding numbers
     */
    public int calculateSum(int[] data) {
        int sum = 0;
        for (int val: data) sum += val;
        return sum;
    }

    /**
     * A simple method adding numbers from dataset
     */
    public int calculateSum_DataService() {
        List<Integer> numbers = dataService.getAllNumber();
        if (numbers.isEmpty()) return 0;
        return numbers.stream().reduce(0, Integer::sum);
    }
}
