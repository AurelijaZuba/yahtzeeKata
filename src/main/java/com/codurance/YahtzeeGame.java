package com.codurance;

public class YahtzeeGame {

    private final Chance chance = new Chance();

    public int score(int[] rolls, String category) {
        switch (category) {
            case "ones":
                return new MultiplesOfOne().score(rolls);
            case "twos":
                return new MultiplesOfTwo().score(rolls);
            case "threes":
                return new MultipleOfThrees().score(rolls);
            case "fours":
                return new MultipleOfFours().score(rolls);
            case "fives":
                return new MultipleOfFives().score(rolls);
            case "sixes":
                return new MultipleOfSixes().score(rolls);
            case "pairs":
                return new Pairs().score(rolls);
            case "two pairs":
                return new TwoPairs().score(rolls);
            case "three of a kind":
                return new ThreeOfAKind().score(rolls);
            case "four of a kind":
                return new FourOfAKind().score(rolls);
            default:
                return chance.score(rolls);
        }
    }
}
