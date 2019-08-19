package com.codurance;

import java.util.HashMap;
import java.util.Map;

public class Yahtzee implements Rule {

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

    private boolean hasFiveOfTheSame(Map<Integer, Integer> rollCount) {
        return rollCount.containsValue(5);
    }

    @Override
    public int score(int[] rolls) {
        final Map<Integer, Integer> rollCount = getRollCount(rolls);
        if (hasFiveOfTheSame(rollCount)) {
            return 50;
        }
        return 0;
    }

}
