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
public class Problem2 {

    private BufferedReader reader;
    private String nextLine;
    private Integer checksum;
    
    public Problem2(BufferedReader b) {
        reader = b;
        checksum = 0;
    }
    
    public void setBufferedReader(BufferedReader b){
        reader = b;
        checksum = 0;
    }
    
    void processLine(String currLine){
        String[] row = currLine.split("\\s+");
        Integer high = 0;
        Integer low = Integer.MAX_VALUE;
        Integer current = 0;
        for(String s: row){
            current = Integer.parseInt(s);
            if(current > high){
                high = current;
            } else if(current < low){
                low = current;
            }
        }
        checksum += high-low;
    }
    
    void processLineType2(String currLine){
        String[] row = currLine.split("\\s+");
        Integer current = 0;
        for(String s: row){
            current = Integer.parseInt(s);
            for(String t: row){
                Integer div = Integer.parseInt(t);
                if(current%div == 0 && !current.equals(div)){                          
                    checksum += current/div;
                }
            }
        }
    }
    
    Integer getChecksum(int type) throws IOException {
        while((nextLine = reader.readLine()) != null){
            if(type == 1){
                processLine(nextLine);
            } else if(type ==2){
                processLineType2(nextLine);
            }
        }
        return checksum;
    }
    
    
    
}
