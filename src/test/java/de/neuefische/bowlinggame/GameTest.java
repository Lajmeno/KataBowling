package de.neuefische.bowlinggame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void expectTotalScoreof1(){
        Game game = new Game();

        game.addRoll(1);
        int score = game.totalScore();

        System.out.println(score);

    }

    @Test
    void expectTotalScoreof5(){
        Game game = new Game();

        game.addRoll(1);
        game.addRoll(4);
        int score = game.totalScore();

        System.out.println(score);

    }

    @Test
    void expectTotalScoreof9(){
        Game game = new Game();

        game.addRoll(1);
        game.addRoll(4);
        game.addRoll(4);
        game.addRoll(5);
        game.addRoll(6);
        game.addRoll(4);
        game.addRoll(5);

        int score = game.totalScore();

        System.out.println(score);

    }


}