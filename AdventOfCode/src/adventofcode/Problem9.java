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
public class Problem9 {
    private int groupCounter;
    private int total;
    private boolean isGroup;
    private boolean isGarbage;
    private boolean negate;
    private int trashCount;
    
    
    public Problem9(BufferedReader b) throws IOException {
        int curChar;
        while((curChar = b.read())!= -1){
            char current = (char) curChar;
            processCharacter(current);
        }       
    }
    
    private void processCharacter(char c){
        if((c == '<') && !isGarbage){
            isGarbage = true;
        } else if(isGarbage){
            if(negate){
                negate = false;
            } else if(c == '!'){
                negate = true;
            } else if(c == '>'){
                isGarbage = false;
            } else {
                trashCount++;
            }
        } else {
            if(c == '{'){
                groupCounter++;
            } 
            if(c == '}'){
                total += groupCounter;
                groupCounter--;
            }
        }
    }

    public int getTotal() {
        return total;
    }

    public int getTrashCount() {
        return trashCount;
    }
       
}
