package com.codurance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class YahtzeeGameShould {

    @ParameterizedTest
    @MethodSource("rollAndCategoryProvider")
    public void scores_rolls(int[] rolls, String category, int expected) {
        YahtzeeGame game = new YahtzeeGame();

        int actual = game.score(rolls, category);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> rollAndCategoryProvider(){
        return Stream.of(
                Arguments.of(new int[]{1,1,3,3,6}, "chance", 14),
                Arguments.of(new int[]{1,1,2,4,4}, "ones", 2),
                Arguments.of(new int[]{6,2,2,4,4}, "ones", 0),
                Arguments.of(new int[]{6,2,2,4,4}, "twos", 4),
                Arguments.of(new int[]{6,3,3,4,4}, "twos", 0),
                Arguments.of(new int[]{6,3,3,4,4}, "threes", 6),
                Arguments.of(new int[]{6,3,3,4,4}, "fours", 8),
                Arguments.of(new int[]{6,3,3,5,5}, "fives", 10),
                Arguments.of(new int[]{6,3,3,5,5}, "sixes", 6)

        );
    }

}
