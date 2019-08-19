package com.codurance;

import java.util.Arrays;

public class YahtzeeGame {

    public int score(int[] rolls, String category) {
        if(category.equals("ones")){
            return ones(rolls);
        }
        if(category.equals("twos")){
            return Arrays.stream(rolls).filter(roll -> roll == 2)
                    .reduce(0, (a, b) -> a + b);
        }
        return chance(rolls);
    }

    public int chance(int[] rolls) {
        return Arrays.stream(rolls).reduce(0, (a, b) -> a + b);
    }

    private int ones(int[] rolls) {
        return Arrays.stream(rolls).filter(roll -> roll == 1)
                .reduce(0, (a,b) -> a + b);
    }
}
