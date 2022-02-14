package de.neuefische.bowlinggame;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Frame> frames = new ArrayList<>();
    private int count;

    void addRoll(int pin){
        Frame frame;
        int index = count % 2;
        if (index == 0 && !isOver() ) {
            frame = new Frame(2);
            frames.add(frame);
        }else if(frames.get(frames.size() - 1).getPinsRolled()[0] == 10 && !isOver()){
            frame = new Frame(2);
            frames.add(frame);
            count++;
            index = 0;
        }
        else {
            frame = frames.get(frames.size() - 1);
        }

        setFrames(frame, index, pin);
        count++;
    }

    private void setFrames(Frame frame, int index, int pin){
        frame.setPinsRolled(index, pin);
        frame.makeScore(frame, index);

        if(frames.size() > 1 ){
            if(frames.get(frames.size() - 2).isStrike()){
                frames.get(frames.size() - 2).makeScore(frame, index);
            }else if (frames.get(frames.size() - 2).isSpare() && index == 0){
                frames.get(frames.size() - 2).makeScore(frame, 0);
            }
        }
    }



    public int totalScore(){
        int sum = 0;
        for(Frame frame : frames){
            sum +=  frame.getScore();
        }
        return sum;
    };


    List<Frame> frames(){
        return frames;
    }

    private boolean isOver(){
        return frames.size() == 10;
    };



}
