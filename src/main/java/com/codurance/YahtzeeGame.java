package com.codurance;

import java.util.Arrays;

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
            default:
                return chance(rolls);
        }
    }

    public int chance(int[] rolls) {
        return Arrays.stream(rolls).reduce(0, (a, b) -> a + b);
    }

    private int multiplesOfN(int[] rolls, int i) {
        return Arrays.stream(rolls).filter(roll -> roll == i)
                .reduce(0, (a, b) -> a + b);
    }

}
