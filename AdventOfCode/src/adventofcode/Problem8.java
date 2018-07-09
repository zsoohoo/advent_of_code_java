/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author zsoohoo
 */
public class Problem8 {
    private final String equal = "==";
    private final String lessThan = "<";
    private final String greaterThan = ">";
    private final String lessEqual = "<=";
    private final String greaterEqual = ">=";
    private final String notEqual = "!=";
    private final String decrease = "dec";
    private ArrayList<String> registers;
    private ArrayList<Integer> values;
    private ArrayList<String> registerToChange;
    private ArrayList<Boolean> incDec;
    private ArrayList<Integer> valueToChange;
    private ArrayList<String> addressToCheck;
    private ArrayList<String> operand;
    private ArrayList<Integer> valueToCheck;
    private int highestEver;

    public Problem8(BufferedReader b) throws IOException {
        String nextLine;
        registers = new ArrayList<>();
        values = new ArrayList<>();
        registerToChange = new ArrayList<>();
        incDec = new ArrayList<>();
        valueToChange = new ArrayList<>();
        addressToCheck = new ArrayList<>();
        operand = new ArrayList<>();
        valueToCheck = new ArrayList<>();
        highestEver = 0;
        while((nextLine = b.readLine()) != null){
           String[] instructions = nextLine.split("\\s+");
           //0 to change, 1 inc/dec, 2 amount, 3 if, 4 conditional address, 5 operand, 6 value
           registerToChange.add(instructions[0]);
           incDec.add(instructions[1].equals(decrease));
           valueToChange.add(Integer.parseInt(instructions[2]));
           addressToCheck.add(instructions[4]);
           operand.add(instructions[5]);
           valueToCheck.add(Integer.parseInt(instructions[6]));
        }
        initializeRegisters();
    }
    
    private void initializeRegisters(){
        for(String register : registerToChange){
            if(!registers.contains(register)){
                registers.add(register);
                values.add(0);
            }
        }
    }
    
    int getLargestRegister(){
        for(int i = 0; i < registerToChange.size(); i++){
            int indexToCheck = registers.indexOf(addressToCheck.get(i));
            boolean adjustValues = checkConditional(i, indexToCheck);
            if(adjustValues){
                if(incDec.get(i)){
                    valueToChange.set(i, (-1*valueToChange.get(i)));
                }
                int indexToChange = registers.indexOf(registerToChange.get(i));
                values.set(indexToChange, (values.get(indexToChange)+valueToChange.get(i)));
                if(values.get(indexToChange) > highestEver){
                    highestEver = values.get(indexToChange);
                }
            }   
        }
        int biggest = 0;
        for(Integer value: values){
            if(value > biggest){
                biggest = value;
            }
        }
        return biggest;
    }
    
    boolean checkConditional(int index, int indexToCheck){
        switch(operand.get(index)){
            case equal: 
                if(values.get(indexToCheck).equals(valueToCheck.get(index))){
                    return true;
                }
                break;
            case greaterEqual: 
                if(values.get(indexToCheck) >= valueToCheck.get(index)){
                    return true;
                }
                break;
            case lessEqual: 
                if(values.get(indexToCheck) <= valueToCheck.get(index)){
                    return true;
                }
                break;
            case lessThan: 
                if(values.get(indexToCheck) < valueToCheck.get(index)){
                    return true;
                }
                break;
            case greaterThan: 
                if(values.get(indexToCheck) > valueToCheck.get(index)){
                    return true;
                }
                break;
            case notEqual: 
                if(!values.get(indexToCheck).equals(valueToCheck.get(index))){
                    return true;
                }
                break;
        }
        return false;
    }

    public int getHighestEver() {
        return highestEver;
    }
    
}
