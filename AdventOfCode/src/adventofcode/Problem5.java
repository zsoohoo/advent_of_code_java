package adventofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zsoohoo
 */
public class Problem5 {

    private ArrayList<Integer> offsets;
    private int[]  timesUsed;
    private int steps;
    
    public Problem5(BufferedReader b) throws IOException{
        String nextLine;
        offsets = new ArrayList<Integer>();
        while((nextLine = b.readLine()) != null){
            offsets.add(Integer.parseInt(nextLine));
        }
        timesUsed = new int[offsets.size()];
        steps = 0;
    }
    
    int getStepCount(int type){
        int currentStep = 0;
        int stepCount = 0;
        timesUsed = new int[offsets.size()];
        while(currentStep < offsets.size()){
            int toMove = 0;
            toMove +=  offsets.get(currentStep) +  timesUsed[currentStep];
            if(type == 1){
                if(toMove > 2){
                    timesUsed[currentStep]--;
                } else {
                    timesUsed[currentStep]++;
                }
            }else {
                timesUsed[currentStep]++;
            }
            currentStep += toMove;
            stepCount++;
        }
        return stepCount;
    }
    
    
}
