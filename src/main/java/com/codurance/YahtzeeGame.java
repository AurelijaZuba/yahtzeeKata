package com.codurance;

import java.util.Arrays;

public class YahtzeeGame {

    public int score(int[] rolls, String category) {
        if(category.equals("ones")){
            return multiplesOfN(rolls, 1);
        }
        if(category.equals("twos")){
            return multiplesOfN(rolls, 2);
        }
        return chance(rolls);
    }

    private int multiplesOfN(int[] rolls, int i) {
        return Arrays.stream(rolls).filter(roll -> roll == i)
                .reduce(0, (a, b) -> a + b);
    }

    public int chance(int[] rolls) {
        return Arrays.stream(rolls).reduce(0, (a, b) -> a + b);
    }

}
