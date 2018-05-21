/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

/**
 *
 * @author zsoohoo
 */


public class Problem1 {
    
    int length;
    int total;
    String input;
    
    Problem1(String input){
        input = input.replaceAll("\\D*", "");
        length = input.length();
        this.input = input;
        total = 0;
    }
    
    int getSum(){
        for(int i=0;i<length-1;i++){
            compareDigits(i, i+1);
        }
        if(length >1){
            compareDigits(0, length-1);
        }
        return total;
    }
    
    void compareDigits(int i, int j){
        int d1 = Integer.parseInt(input.substring(i, i+1));
        int d2 = Integer.parseInt(input.substring(j, j+1));
        if(d1==d2){
            total += d1;
        }
    }
    
}
