package com.codurance;

import java.util.Arrays;

public class YahtzeeGame {

    private final Chance chance = new Chance();
    private final ThreeOfAKind threeOfAKind = new ThreeOfAKind();
    private final TwoPairs twoPairs = new TwoPairs();
    private final Pairs pairs = new Pairs();
    private final MultiplesOfOne multiplesOfOne = new MultiplesOfOne();
    private final MultiplesOfTwo multiplesOfTwo = new MultiplesOfTwo();
    private final MultipleOfThrees multipleOfThrees = new MultipleOfThrees();
    private final MultipleOfFours multipleOfFours = new MultipleOfFours();
    private final MultipleOfFives multipleOfFives = new MultipleOfFives();
    private final MultipleOfSixes multipleOfSixes = new MultipleOfSixes();

    public int score(int[] rolls, String category) {
        switch (category) {
            case "ones":
                return multiplesOfOne.score(rolls);
            case "twos":
                return multiplesOfTwo.score(rolls);
            case "threes":
                return multipleOfThrees.score(rolls);
            case "fours":
                return multipleOfFours.score(rolls);
            case "fives":
                return multipleOfFives.score(rolls);
            case "sixes":
                return multipleOfSixes.score(rolls);
            case "pairs":
                return pairs.score(rolls);
            case "two pairs":
                return twoPairs.score(rolls);
            case "three of a kind":
                return threeOfAKind.score(rolls);
            default:
                return chance.score(rolls);
        }
    }
}
