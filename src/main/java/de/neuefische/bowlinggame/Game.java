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

        updateFrames(frame, index, pin);
        count++;
    }

    private void updateFrames(Frame frame, int index, int pin){

        //First part creates an Array of length 3 when player reaches a spare in the very last round - the only time the player can throw three times
        if(frames.get(frames.size() - 1).isSpare() && isOver()){
            Frame lastFrame = new Frame(3);
            System.arraycopy(frame.getPinsRolled(), 0, lastFrame.getPinsRolled(), 0, 2);
            lastFrame.setPinsRolled(2 , pin);
            for (int i = 0; i < 3; i++) {
                lastFrame.makeScore(lastFrame, i);
            }
            frames.remove(frame);
            frames.add(lastFrame);
        }else {
            frame.setPinsRolled(index, pin);
            frame.makeScore(frame, index);

            //
            if (frames.size() > 1) {
                if (frames.get(frames.size() - 2).isStrike()) {
                    frames.get(frames.size() - 2).makeScore(frame, index);
                } else if (frames.get(frames.size() - 2).isSpare() && index == 0) {
                    frames.get(frames.size() - 2).makeScore(frame, 0);
                }
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


    public List<Frame> frames(){
        return frames;
    }

    private boolean isOver(){
        return frames.size() == 10;
    };



}
