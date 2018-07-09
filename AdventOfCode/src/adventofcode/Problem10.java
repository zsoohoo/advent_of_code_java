/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author zsoohoo
 */
public class Problem10 {

    private int currPos;
    private int skip;
    private int[] lengths;
    private int[] valueList;
    private int[] fullLengths;
    
    
    public Problem10(BufferedReader b) throws IOException {
        valueList = new int[256];
        for(int i = 0; i< 256; i++){
            valueList[i] = i;
        }
        String input = b.readLine();
        fullLengths = new int[input.length()+5];
        for(int i = 0; i < input.length(); i++){
            fullLengths[i] = input.charAt(i);
        }
        fullLengths[fullLengths.length-1-4] = 17;
        fullLengths[fullLengths.length-1-3] = 31;
        fullLengths[fullLengths.length-1-2] = 73;
        fullLengths[fullLengths.length-1-1] = 47;
        fullLengths[fullLengths.length-1] = 23;
        String[] splitInput = input.split(",");
        lengths = new int[splitInput.length];
        for(int i = 0; i < lengths.length; i++){
            lengths[i] = Integer.parseInt(splitInput[i]);
        }
    }
    
    void resetValueList(){
        for(int i = 0; i< 256; i++){
            valueList[i] = i;
        }
        currPos = 0;
        skip = 0;
    }
    
    void processLengths(Boolean extendedLengths){
        int[] whichLengths;
        int iterations = 1;
        if(extendedLengths){
            whichLengths = fullLengths;
            iterations = 64;
        } else {
            whichLengths = lengths;
        }
        for(int reps = 0; reps < iterations; reps++){
            for(int length : whichLengths){
                if(length <= 256){
                    if(length > 1){
                        int[] tempList = new int[length];
                        int tempA, tempB;
                        for(int i = 0; i < length/2; i++){
                            tempA = valueList[(i+currPos)%256];
                            tempB = valueList[(length-1-i+currPos)%256];
                            valueList[(i+currPos)%256] = tempB;
                            valueList[(length-1-i+currPos)%256] = tempA;
                        }
                    }
                    currPos += length + skip;
                    skip++;
                }
            }
        }
    }
    
    int productOfElements(int a, int b){
        if(a<256 && a>=0 && b<256 && b>=0){
            return valueList[a]*valueList[b];
        }
        return 0;
    }
    
    String findDenseHashHex(){
        int[] denseHash = new int[16];
        int runningVal = 0;
        for(int i = 0; i < 16; i++){
            runningVal = 0;
            for(int j = 0; j < 16; j++){
                runningVal = runningVal ^ valueList[i*16+j];
            }
            denseHash[i] = runningVal;
        }

        String hash = "";
        for(int i = 0; i < denseHash.length; i++){
            hash += String.format("%02x", denseHash[i]);
        }
        return hash;
    }
    
}
