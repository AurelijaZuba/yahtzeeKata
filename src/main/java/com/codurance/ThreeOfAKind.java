package com.codurance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ThreeOfAKind implements Rule{
    public ThreeOfAKind() {
    }


    List<Integer> selectThrees(Map<Integer, Integer> rollCount) {
        return rollCount.entrySet().stream()
                .filter(entry -> hasThree(entry))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    boolean hasThree(Map.Entry<Integer, Integer> entry) {
        return entry.getValue() >= 3;
    }

    @Override
    public int score(int[] rolls) {
        Map<Integer, Integer> rollCount1 = new HashMap<Integer, Integer>();
        for (int roll : rolls) {
            if (rollCount1.containsKey(roll))
                rollCount1.replace(roll, rollCount1.get(roll) + 1);
            else
                rollCount1.put(roll, 1);
        }
        Map<Integer, Integer> rollCount = rollCount1;

        List<Integer> pairs = selectThrees(rollCount);

        return pairs.stream().reduce(0, (a, b) -> a + b * 3);
    }
}