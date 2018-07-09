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
public class Problem7 {

    private ArrayList<P7Node> tree;
    private String root;
    private String incorrect;
    private boolean incSet;
    private Integer correctWeight;
    
    public Problem7(BufferedReader b) throws IOException{
        tree = new ArrayList<>();
        correctWeight = 0;
        String nextLine;
        while((nextLine = b.readLine()) != null){
            createNode(nextLine);
        }
        root = findRoot();
        incSet = false;
        Integer w = findWeights(root);
        findCorrectWeight();
    }
    
    private void createNode(String s){
        String[] split = s.split("\\s+");
        String nodeName = split[0];
        split[1] = split[1].replaceAll("[^\\d.]", "");
        Integer weight = Integer.parseInt(split[1]);
        P7Node node = new P7Node(nodeName, weight);
        if(split.length > 3){
            for(int i = 3; i < split.length; i++){
                node.addChild(split[i].replaceAll("[^A-z]", ""));
            }  
            node.setHasChildren(true);
        }
        tree.add(node);
    }
    
    String findRoot(){
        for(P7Node toCheck : tree){
            if(toCheck.getHasChildren()){
                boolean isRoot = true;
                for(P7Node node : tree){
                    if(node.getHasChildren()){
                        if(node.inChildren(toCheck.getName())){
                            isRoot = false;
                            break;
                        }
                    }
                }
                if(isRoot){
                    return toCheck.getName();
                }
            }
        }
        return "None";
    }

    public String getRoot() {
        return root;
    }
    
    public Integer findWeights(String name){
        Integer total =0;
        P7Node curr = null;
        for(P7Node node : tree){
            if(node.getName().equals(name)){
                curr = node;
                total += node.getWeight();
                break;
            }
        }
        if(curr!= null && curr.getHasChildren()){
            Integer[] childWeights = new Integer[curr.getChildren().size()];
            for(int i = 0; i < curr.getChildren().size(); i++){
                childWeights[i] = findWeights(curr.getChildren().get(i));
                total += childWeights[i];
            }
            if(childWeights.length >2){
                if(!childWeights[0].equals(childWeights[1])){
                    if(!childWeights[0].equals(childWeights[2]) && childWeights[1].equals(childWeights[2])){
                        if(!incSet){
                            incorrect = curr.getChildren().get(0);
                            incSet = true;
                        }
                    }else{
                        if(!incSet){
                            incorrect = curr.getChildren().get(1);
                            incSet = true;
                        }
                    }
                } else {
                    for(int i = 2; i< childWeights.length; i++){
                        if(!childWeights[0].equals(childWeights[i])){
                            if(!incSet){
                                incorrect = curr.getChildren().get(i);
                            incSet = true;
                            }
                        }
                    }
                }
            }
        }
        return total;
    }
    
    private void findCorrectWeight(){
        P7Node parent = null;
        P7Node incorrectNode = null;
        for(P7Node node : tree){
            if(node.inChildren(incorrect)){
                parent = node;
            }
            if(node.getName().equals(incorrect)){
                incorrectNode = node;
            }
        }
        if(parent != null && incorrectNode != null){
            System.out.println(parent.getName());
            int incorrectWeight = findWeights(incorrect);
            int otherWeight;
            if(parent.getChildren().get(0).equals(incorrect)){
                otherWeight = findWeights(parent.getChildren().get(1));
            } else {
                otherWeight = findWeights(parent.getChildren().get(0));
            }
            int offset = otherWeight - incorrectWeight;
            correctWeight = incorrectNode.getWeight() +offset;
        }
    }

    public Integer getCorrectWeight() {
        return correctWeight;
    }
    
    
}
