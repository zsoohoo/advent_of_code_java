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
//            executeProblem1("resources/P1Input.txt");
//            executeProblem2("resources/P2Input.txt");
//            executeProblem3("resources/P3Input.txt");
//            executeProblem4("resources/P4Input.txt");
//            executeProblem5("resources/P5Input.txt");
//            executeProblem6("resources/P6Input.txt");
//            executeProblem7("resources/P7Input.txt");
//            executeProblem8("resources/P8Input.txt");
//            executeProblem9("resources/P9Input.txt");
            executeProblem10("resources/P10Input.txt");
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
    
    static void executeProblem3(String fileName) throws IOException{
        FileReader f = new FileReader(fileName);
        BufferedReader b = new BufferedReader(f);
        String line = b.readLine();
        Integer input = Integer.valueOf(line);
        Problem3 p3 = new Problem3(input);
        System.out.println("Distance for P3 Part 1: " + p3.getDistance());
        System.out.println("Square value for P3 Part 2: " + p3.findHigherValue(input));        
    }
    
    static void executeProblem4(String fileName) throws IOException{
        FileReader f = new FileReader(fileName);
        BufferedReader b = new BufferedReader(f);
        Problem4 p4 = new Problem4(b);
        p4.countValidPasses();
        System.out.println("Valid Passphrases for P4 Part 1 is: " + p4.getValidPassCount() );
        System.out.println("Non-anagram valid passphrases for P4 Part 2 is: " + p4.getValidAnagramCount());
    }
    
        static void executeProblem5(String fileName) throws IOException{
        FileReader f = new FileReader(fileName);
        BufferedReader b = new BufferedReader(f);
        Problem5 p5 = new Problem5(b);
        System.out.println("Step count to complete for P5 Part 1 is: " + p5.getStepCount(0));
        System.out.println("Step count to complete for P5 Part 2 is: " + p5.getStepCount(1));
    }
        
        static void executeProblem6(String fileName) throws IOException{
        FileReader f = new FileReader(fileName);
        BufferedReader b = new BufferedReader(f);
        String initialDistribution = b.readLine();
        Problem6 p6 = new Problem6(initialDistribution);
        p6.redistribute();
        System.out.println("Number of Cycles to loop for P6 Part 1 is: " + p6.getNumberOfCycles());
        System.out.println("Loop size for P6 Part 2 is: " + p6.getCyclesToRepeat());
    }
        
        static void executeProblem7(String fileName) throws IOException{
        FileReader f = new FileReader(fileName);
        BufferedReader b = new BufferedReader(f);
        Problem7 p7 = new Problem7(b);
        System.out.println("Tree root for P7 Part 1 is: " + p7.getRoot());
        System.out.println("Correct weight for P7 Part 2 is: " + p7.getCorrectWeight());
    }
        
        static void executeProblem8(String fileName) throws IOException{
        FileReader f = new FileReader(fileName);
        BufferedReader b = new BufferedReader(f);
        Problem8 p8 = new Problem8(b);
        System.out.println("Highest register value at end for P8 Part 1 is: " + p8.getLargestRegister());
        System.out.println("Highest register value ever for P8 Part 2 is: " + p8.getHighestEver());
    }
        
        static void executeProblem9(String fileName) throws IOException{
        FileReader f = new FileReader(fileName);
        BufferedReader b = new BufferedReader(f);
        Problem9 p9 = new Problem9(b);
        System.out.println("Total score for P9 Part 1 is: " + p9.getTotal());
        System.out.println("Non-canceled characters within garbage for P9 Part 2 is: " + p9.getTrashCount());
    }
        
        static void executeProblem10(String fileName) throws IOException{
        FileReader f = new FileReader(fileName);
        BufferedReader b = new BufferedReader(f);
        Problem10 p10 = new Problem10(b);
        p10.processLengths(Boolean.FALSE);
        System.out.println("Product of first two values for P10 Part 1 is: " + p10.productOfElements(0, 1) );
        p10.resetValueList();
        p10.processLengths(Boolean.TRUE);
        System.out.println("Hash for P10 Part 2 is: " + p10.findDenseHashHex());
    }
//        static void executeProblem//(String fileName) throws IOException{
//        FileReader f = new FileReader(fileName);
//        BufferedReader b = new BufferedReader(f);
//        Problem// p// = new Problem//(b);
//        System.out.println("Answer for P// Part 1 is: ");
//        System.out.println("Answer for P// Part 2 is: ");
//    }
}
