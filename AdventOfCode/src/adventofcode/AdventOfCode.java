/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Z
 */
public class AdventOfCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            executeProblem1("resources/P1Input.txt");
            executeProblem2("resources/P2Input.txt");
        }
        catch(FileNotFoundException e){
            System.out.println("File not Found");
        }
        catch(IOException io){
            System.out.println("IOException");
        }
    }
    
    static void executeProblem1(String fileName) throws IOException{
        FileReader f = new FileReader(fileName);
        BufferedReader b = new BufferedReader(f); 
        String input = b.readLine();
        if(input != null){
            Problem1 p1 = new Problem1(input);
            int a1 = p1.getSum();
            System.out.println("Puzzle 1 part 1 solution is: " + a1);
            p1.resetTotal();
            int a2 = p1.getP2Sum();
            System.out.println("Puzzle 1 part 2 solution is: " + a2);
        }
    }
    
    static void executeProblem2(String fileName) throws IOException{
        FileReader f = new FileReader(fileName);
        BufferedReader b = new BufferedReader(f);
        Problem2 p2 = new Problem2(b);
        System.out.println("Checksum for P2 Part 1 is: " + p2.getChecksum(1));
        BufferedReader c = new BufferedReader( new FileReader(fileName));
        p2.setBufferedReader(c);
        System.out.println("Checksum for P2 Part 2 is: " + p2.getChecksum(2));
    }
    
}
