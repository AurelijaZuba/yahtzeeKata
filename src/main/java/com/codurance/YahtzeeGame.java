package com.codurance;

public class YahtzeeGame {

    private final Chance chance = new Chance();

    public int score(int[] rolls, String category) {
        switch (category) {
            case "ones":
                return new SumOfOnes().score(rolls);
            case "twos":
                return new SumOfTwos().score(rolls);
            case "threes":
                return new SumOfThrees().score(rolls);
            case "fours":
                return new SumOfFours().score(rolls);
            case "fives":
                return new SumOfFives().score(rolls);
            case "sixes":
                return new SumOfSixes().score(rolls);
            case "pairs":
                return new Pairs().score(rolls);
            case "two pairs":
                return new TwoPairs().score(rolls);
            case "three of a kind":
                return new ThreeOfAKind().score(rolls);
            case "four of a kind":
                return new FourOfAKind().score(rolls);
            case "full house":
                return new FullHouse().score(rolls);
            default:
                return chance.score(rolls);
        }
    }
}
