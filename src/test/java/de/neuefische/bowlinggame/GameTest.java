package de.neuefische.bowlinggame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {


    @Test
    void expectTotalScoreof133(){
        Game game = new Game();

        game.addRoll(1);
        game.addRoll(4);
        game.addRoll(4);
        game.addRoll(5);
        game.addRoll(6);
        game.addRoll(4);
        game.addRoll(5);
        game.addRoll(5);
        game.addRoll(10);
        game.addRoll(0);
        game.addRoll(1);
        game.addRoll(7);
        game.addRoll(3);
        game.addRoll(6);
        game.addRoll(4);
        game.addRoll(10);
        game.addRoll(2);
        game.addRoll(8);
        game.addRoll(6);

        int score = game.totalScore();

        System.out.println(game.frames());
        assertEquals(133, score);

    }


}