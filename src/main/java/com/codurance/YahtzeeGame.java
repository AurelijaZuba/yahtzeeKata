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
        if(category.equals("threes")){
            return multiplesOfN(rolls, 3);
        }
        if(category.equals("fours")){
            return multiplesOfN(rolls, 4);
        }
        if(category.equals("fives")){
            return multiplesOfN(rolls, 5);
        }
        if(category.equals("sixes")){
            return multiplesOfN(rolls, 6);
        }
        return chance(rolls);
    }

    public int chance(int[] rolls) {
        return Arrays.stream(rolls).reduce(0, (a, b) -> a + b);
    }

    private int multiplesOfN(int[] rolls, int i) {
        return Arrays.stream(rolls).filter(roll -> roll == i)
                .reduce(0, (a, b) -> a + b);
    }

}
