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
public class Problem4 {

    private BufferedReader reader;
    private int validPassCount;
    private int validAnagramCount;

    public Problem4(BufferedReader b) {
        reader = b;
        validPassCount = 0;
        validAnagramCount = 0;
    }

    public void countValidPasses () throws IOException{
        String nextLine;
        while((nextLine = reader.readLine()) != null){
            processLine(nextLine);
        }
    }

    private void processLine(String nextLine){
        String[] line = nextLine.split("\\s+");
        boolean valid = true;
        boolean hasAnagram = true;
        for(int i = 0; i< line.length; i++){
            for(int j = i+1; j< line.length; j++){
                if(line[i].equals(line[j])){
                    valid = false;
                }
                if(checkAnagram(line[i], line[j])){
                    hasAnagram = false;
                }
            }
        }
        if(valid){
            validPassCount++;
        }
        if(hasAnagram){
            validAnagramCount++;
        }
    }

    private boolean checkAnagram(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        int[] letters = new int[26];
        for(int i = 0; i < a.length(); i++){
            letters[a.charAt(i)%26]++;
            letters[b.charAt(i)%26]--;
        }
        for(int letter : letters){
            if(letter != 0){
                return false;
            }
        }
        return true;
    }

    public int getValidPassCount() {
        return validPassCount;
    }

    public int getValidAnagramCount() {
        return validAnagramCount;
    }


}
