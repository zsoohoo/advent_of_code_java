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
public class CoordPair {

    private int x;
    private int y;
    
    public CoordPair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    void addCoords(int xChange, int yChange){
        x += xChange;
        y += yChange;
    }
    
    
    @Override
    public boolean equals(Object o){
        CoordPair toTest = (CoordPair) o;
        if(toTest.x == this.x && toTest.y == this.y){
            return true;
        }
        return false;
    }
}
