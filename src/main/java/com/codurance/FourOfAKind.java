package com.codurance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FourOfAKind implements Rule{
    public FourOfAKind() {
    }

    List<Integer> selectFours(Map<Integer, Integer> rollCount) {
        return rollCount.entrySet().stream()
                .filter(entry -> hasFour(entry))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    boolean hasFour(Map.Entry<Integer, Integer> entry) {
        return entry.getValue() == 4;
    }

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
        Map<Integer, Integer> rollCount = getRollCount(rolls);

        List<Integer> pairs = selectFours(rollCount);

        return pairs.stream().reduce(0, (a, b) -> a + b * 4);
    }
}
