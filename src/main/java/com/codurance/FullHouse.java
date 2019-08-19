package com.codurance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FullHouse implements Rule {

    private Map<Integer, Integer> getRollCount(int[] rolls) {
        Map<Integer, Integer> rollCount1 = new HashMap<Integer, Integer>();
        for (int roll : rolls) {
            if (rollCount1.containsKey(roll))
                rollCount1.replace(roll, rollCount1.get(roll) + 1);
            else
                rollCount1.put(roll, 1);
        }
        return rollCount1;
    }
    @Override
    public int score(int[] rolls) {
        final Map<Integer, Integer> rollCount = getRollCount(rolls);
        if(hasThree(rollCount) && hasPair(rollCount))
            return Arrays.stream(rolls).reduce(0, (a, b) -> a + b);
        return 0;
    }

    private boolean hasPair(Map<Integer, Integer> rollCount) {
        return rollCount.containsValue(2);
    }

    private boolean hasThree(Map<Integer, Integer> rollCount) {
        return rollCount.containsValue(3);
    }
}
