package com.codurance;

import java.util.*;
import java.util.stream.Collectors;

public class YahtzeeGame {

    public int score(int[] rolls, String category) {
        switch (category) {
            case "ones":
                return multiplesOfN(rolls, 1);
            case "twos":
                return multiplesOfN(rolls, 2);
            case "threes":
                return multiplesOfN(rolls, 3);
            case "fours":
                return multiplesOfN(rolls, 4);
            case "fives":
                return multiplesOfN(rolls, 5);
            case "sixes":
                return multiplesOfN(rolls, 6);
            case "pairs":
                return pairs(rolls);
            case "two pairs":
                return twoPairs(rolls);
            case "three of a kind":
                return threeOfAKind(rolls);
            default:
                return chance(rolls);
        }
    }

    private int threeOfAKind(int[] rolls) {
        Map<Integer, Integer> rollCount = getRollCount(rolls);

        List<Integer> pairs = selectThrees(rollCount);

        return pairs.stream().reduce(0, (a, b) -> a + b * 3);
    }

    private int twoPairs(int[] rolls) {
        Map<Integer, Integer> rollCount = getRollCount(rolls);

        final List<Integer> pairs = selectPairs(rollCount);

        if(pairs.size() < 2){
            return 0;
        }
        return pairs.stream().reduce(0, (a, b) -> a + b * 2);
    }

    private int pairs(int[] rolls) {
        Map<Integer, Integer> rollCount = getRollCount(rolls);

        List<Integer> pairs = selectPairs(rollCount);

        Optional<Integer> largest = pairs.stream().max(Integer::compareTo);
        if (largest.isPresent())
            return largest.get() * 2;
        return 0;
    }

    public int chance(int[] rolls) {
        return Arrays.stream(rolls).reduce(0, (a, b) -> a + b);
    }

    private List<Integer> selectThrees(Map<Integer, Integer> rollCount) {
        return rollCount.entrySet().stream()
                .filter(entry -> hasThree(entry))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    private boolean hasThree(Map.Entry<Integer, Integer> entry) {
        return entry.getValue() >= 3;
    }

    private List<Integer> selectPairs(Map<Integer, Integer> rollCount) {
        return rollCount.entrySet().stream()
                    .filter(entry -> hasAtLeast2(entry))
                    .map(entry -> entry.getKey())
                    .collect(Collectors.toList());
    }

    private boolean hasAtLeast2(Map.Entry<Integer, Integer> entry) {
        return entry.getValue() >= 2;
    }

    private Map<Integer, Integer> getRollCount(int[] rolls) {
        Map<Integer, Integer> rollCount = new HashMap<>();
        for (int roll : rolls) {
            if (rollCount.containsKey(roll))
                rollCount.replace(roll, rollCount.get(roll) + 1);
            else
                rollCount.put(roll, 1);
        }
        return rollCount;
    }

    private int multiplesOfN(int[] rolls, int i) {
        return Arrays.stream(rolls).filter(roll -> roll == i)
                .reduce(0, (a, b) -> a + b);
    }

}
