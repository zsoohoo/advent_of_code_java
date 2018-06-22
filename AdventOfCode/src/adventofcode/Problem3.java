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
public class Problem3 {
    private Integer input;
    private Integer sideLength;
    private Integer highCorner;
    private Integer midCorner;
    private Integer lowCorner;
    private Integer rings;
    ArrayList<Integer> values;
    
    Problem3(Integer input){
        setAnchors(input);
        values = new ArrayList();
        values.add(1);
        values.add(1);
    }
    
    private void setAnchors(Integer position){
        input = position;
        sideLength = (int) Math.ceil(Math.sqrt(input));
        highCorner = sideLength * sideLength;
        rings = sideLength/2;
        lowCorner = (sideLength-1) * (sideLength-1)+1;
        midCorner = lowCorner + (highCorner - lowCorner)/2;
    }
    
    Integer getDistance(){
        if(input < 2){
            return 0;
        }
        Integer center;
        Boolean even = true;
        if(sideLength%2 == 1){
            even = false;
        }
        if(input.equals(midCorner)){
            return rings*2;
        } else if(input.equals(highCorner) || input.equals(lowCorner)){
            return sideLength -1;
        }
        if(input > midCorner){
           center = midCorner + sideLength/2;
        }else{
            if(even){
                center = lowCorner + sideLength/2 -1;
            } else{
                center = lowCorner +sideLength/2;
            }
        }
        Integer offset = Math.abs((center-input));
        return rings + offset;           
    }
    
    Integer findHigherValue(Integer limit){
        if(input < 2){
            return 3;
        }
        Integer currSquare = 2;
        ArrayList<CoordPair> pairs = new ArrayList();
        int xChange = 0;
        int yChange = 1;
        pairs.add(new CoordPair(0,0));
        pairs.add(new CoordPair(1,0));
        while(values.get(currSquare-1) < limit ){ 
            currSquare++;
            setAnchors(currSquare);
            CoordPair coords = new CoordPair(pairs.get(pairs.size()-1).getX(), pairs.get(pairs.size()-1).getY());
            coords.addCoords(xChange, yChange);
            pairs.add(coords);
            Integer runningTotal = 0;
            for(int i = -1; i < 2; i++){
                for(int j = -1; j<2; j++){
                    if(!(i==0 && j ==0)){
                        CoordPair toCheck = new CoordPair(coords.getX()+i, coords.getY()+j);
                        Boolean containCheck = pairs.contains(toCheck);
                        if(containCheck){
                            runningTotal += values.get(pairs.indexOf(toCheck));
                        } 
                    }
                }
            }
            values.add(runningTotal);
            if(currSquare.equals(midCorner)){
                if(sideLength%2 == 0){
                    xChange = -1;
                    yChange = 0;
                } else{
                    xChange = 1;
                    yChange = 0;
                }
            } else if(currSquare.equals(lowCorner)){
                if(sideLength%2 == 0){
                    xChange = 0;
                    yChange = 1;
                } else{
                    xChange = 0;
                    yChange = -1;
                }
            }
        }
        return values.get(values.size()-1);
    }
    
}

