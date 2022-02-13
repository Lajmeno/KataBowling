package de.neuefische.bowlinggame;

import java.util.Arrays;

public class Frame {

    private int[] pinsRolled;
    private int score;
    private boolean spare;
    private boolean strike;

    Frame(int length){
        pinsRolled = new int[length];
    }

    public Frame makeScore(Frame frame, int index) {
        this.score += frame.pinsRolled[index];
        if(frame.pinsRolled[0] == 10){
            frame.strike = true;
        }else if(frame.pinsRolled[0] + frame.pinsRolled[1] == 10) {
            frame.spare = true;
        }
        return this;
    }

    public void setPinsRolled(int i, int pin) {
        this.pinsRolled[i] = pin;
    }


    public int[] getPinsRolled() {
        return pinsRolled;
    }

    public boolean isSpare() {
        return spare;
    }

    public boolean isStrike() {
        return strike;
    }

    public int getScore() {
        return score;
    }


    @Override
    public String toString() {
        return "("+ Arrays.toString(pinsRolled) +
                ", " + score + ")";
    }

}
