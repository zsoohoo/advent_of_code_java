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
      
    void changeInput(String newInput){
        newInput = newInput.replaceAll("\\D*", "");
        length = newInput.length();
        input = newInput;
        total = 0;
    }
    
    void resetTotal(){
        total = 0;
    }
    
    int getSum(){
        for(int i=0;i<length-1;i++){
            compareDigits(i, i+1, 1);
        }
        if(length >1){
            compareDigits(0, length-1, 1);
        }
        return total;
    }
    
    void compareDigits(int i, int j, int rep){
        int d1 = Integer.parseInt(input.substring(i, i+1));
        int d2 = Integer.parseInt(input.substring(j, j+1));
        if(d1==d2){
            total += d1;
            if(rep == 2){
                total += d1;
            }
        }
    }
    
    int getP2Sum(){
        int offset = length/2; 
        for(int i=0; i<offset;i++){
            compareDigits(i, i+offset, 2);
        }
        return total;
    }
    
}
