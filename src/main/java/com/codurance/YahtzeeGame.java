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
            default:
                return chance(rolls);
        }
    }

    private int twoPairs(int[] rolls) {
        Map<Integer, Integer> rollCount = new HashMap<>();
        for (int roll : rolls) {
            if (rollCount.containsKey(roll))
                rollCount.replace(roll, rollCount.get(roll) + 1);
            else
                rollCount.put(roll, 1);
        }

        List<Integer> pairs = rollCount.entrySet().stream()
                .filter(entry -> entry.getValue() == 2)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        return pairs.stream().reduce(0, (a, b) -> a + b * 2);

    }

    private int pairs(int[] rolls) {
        Map<Integer, Integer> rollCount = new HashMap<>();
        for (int roll : rolls) {
            if (rollCount.containsKey(roll))
                rollCount.replace(roll, rollCount.get(roll) + 1);
            else
                rollCount.put(roll, 1);
        }

        List<Integer> pairs = rollCount.entrySet().stream()
                .filter(entry -> entry.getValue() == 2)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        Optional<Integer> largest = pairs.stream().max(Integer::compareTo);
        if (largest.isPresent())
            return largest.get() * 2;
        return 0;
    }

    public int chance(int[] rolls) {
        return Arrays.stream(rolls).reduce(0, (a, b) -> a + b);
    }

    private int multiplesOfN(int[] rolls, int i) {
        return Arrays.stream(rolls).filter(roll -> roll == i)
                .reduce(0, (a, b) -> a + b);
    }

}
