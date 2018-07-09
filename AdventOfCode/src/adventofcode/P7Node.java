/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

import java.util.ArrayList;

/**
 *
 * @author zsoohoo
 */
public class P7Node {

    private String name;
    private ArrayList<String> children;
    private Integer weight;
    private boolean hasChildren;
    
    public P7Node(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
        children = new ArrayList<>();
        hasChildren = false;
    }
    
    void addChild(String name){
        children.add(name);
    }

    public boolean getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }
    
    public boolean inChildren(String node){
        return children.contains(node);
    }

    public ArrayList<String> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public Integer getWeight() {
        return weight;
    }
    
}
