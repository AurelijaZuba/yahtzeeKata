package com.codurance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoPairs implements Rule {
    public TwoPairs() {
    }

    @Override
    public int score(int[] rolls) {
        Map<Integer, Integer> rollCount = getRollCount(rolls);

        final List<Integer> pairs = getPairs(rollCount);

        if (pairs.size() < 2) {
            return 0;
        }
        return pairs.stream().reduce(0, (a, b) -> a + b * 2);
    }

    private List<Integer> getPairs(Map<Integer, Integer> rollCount) {
        return rollCount.entrySet().stream()
                .filter(entry -> hasAtLeast2(entry))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    private boolean hasAtLeast2(Map.Entry<Integer, Integer> entry) {
        return entry.getValue() >= 2;
    }

    private Map<Integer, Integer> getRollCount(int[] rolls) {
        Map<Integer, Integer> rollCount1 = new HashMap<>();
        for (int roll : rolls) {
            if (rollCount1.containsKey(roll))
                rollCount1.replace(roll, rollCount1.get(roll) + 1);
            else
                rollCount1.put(roll, 1);
        }
        return rollCount1;
    }
}