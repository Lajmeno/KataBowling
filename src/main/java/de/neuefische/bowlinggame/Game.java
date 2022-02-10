package de.neuefische.bowlinggame;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Frame> frames = new ArrayList<>();
    int count;
    private boolean spare;

    void addRoll(int pin){
        if (count % 2 == 0) {
            Frame frame = new Frame();
            frame.pinsRolled[count % 2] += pin;
            int sum = 0;
            for (int i = 0; i < frame.pinsRolled.length; i++) {
                sum += frame.pinsRolled[i];
            }
            frame.score = sum;
            frames.add(frame);

        }else{
            frames.get(frames.size()).pinsRolled[count % 2] += pin;
            int sum = 0;
            for (int i = 0; i < frames.get(frames.size()).pinsRolled.length; i++) {
                sum += frames.get(frames.size()).pinsRolled[i];
            }
            frames.get(frames.size()).score = sum;
        }

    }

    List<Frame> Frames (){
        return frames;
    }

    int totalScore(){
        int sum = 0;
        int count = 0;
        for(Frame frame : frames){
            sum +=  frame.score;
            if(frame.score == 10){
                sum += frames.get(count + 1).score;

            }
            count++;
        }
        return sum;
    };

    boolean Over(){
        return false;
    };



}
