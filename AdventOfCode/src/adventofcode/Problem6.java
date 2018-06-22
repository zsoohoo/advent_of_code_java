/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author zsoohoo
 */
public class Problem6 {
    
    private int numberOfBanks;
    private Integer[] banks;
    private int numberOfCycles;
    private int cyclesToRepeat;
    
    public Problem6(String s) {
        String[] initialString = s.split("\\s+");
        banks = new Integer[initialString.length];
        for(int i = 0; i < initialString.length; i++){
            banks[i] = Integer.parseInt(initialString[i]);
        }
        numberOfBanks = banks.length;
        numberOfCycles = 0;
    }
    
    void redistribute(){
        List<List<Integer>> previousConfigs = new ArrayList<List<Integer>>();
        previousConfigs.add(Arrays.asList(banks.clone()));
        boolean hasRepeated = false;
        int bankToRedistribute = 0;
        while(!hasRepeated){
            int currentHighest = 0;
            for(int i = 0; i < banks.length; i++){
                if(currentHighest < banks[i]){
                    bankToRedistribute = i;
                    currentHighest = banks[i];
                }
            }
            int addToAll = currentHighest/banks.length;
            int addToSome = currentHighest%banks.length;           
            banks[bankToRedistribute] = 0;
            for(int i = 0; i < banks.length; i++){
                banks[i] += addToAll;
            }
            for(int i = 1; i < addToSome +1; i++){
                banks[(i + bankToRedistribute)%16] += 1;
            }
            numberOfCycles++;
            List<Integer> currConfig = Arrays.asList(banks.clone());
            if(previousConfigs.contains(currConfig)){
                cyclesToRepeat = numberOfCycles - previousConfigs.indexOf(currConfig);
                hasRepeated = true;
            } else{
                previousConfigs.add(currConfig);
            }
        }
    }

    public int getNumberOfCycles() {
        return numberOfCycles;
    }

    public int getCyclesToRepeat() {
        return cyclesToRepeat;
    }
    
}
