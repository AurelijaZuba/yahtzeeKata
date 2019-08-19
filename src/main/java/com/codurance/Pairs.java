package com.codurance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Pairs implements Rule{
    public Pairs() {
    }

    List<Integer> getPairs(Map<Integer, Integer> rollCount) {
        return rollCount.entrySet().stream()
                .filter(entry -> hasAtLeastTwo(entry))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    boolean hasAtLeastTwo(Map.Entry<Integer, Integer> entry) {
        return entry.getValue() >= 2;
    }

    Map<Integer, Integer> getRollCount(int[] rolls) {
        Map<Integer, Integer> rollCount = new HashMap<Integer, Integer>();
        for (int roll : rolls) {
            if (rollCount.containsKey(roll))
                rollCount.replace(roll, rollCount.get(roll) + 1);
            else
                rollCount.put(roll, 1);
        }
        return rollCount;
    }

    @Override
    public int score(int[] rolls) {
        Map<Integer, Integer> rollCount = getRollCount(rolls);

        List<Integer> pairs = getPairs(rollCount);

        Optional<Integer> largest = pairs.stream().max(Integer::compareTo);
        if (largest.isPresent())
            return largest.get() * 2;
        return 0;
    }
}