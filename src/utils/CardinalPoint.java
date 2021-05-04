/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author sombiniaina
 */
public enum CardinalPoint {
    NORTH(-1),
    SOUTH(1),
    EAST(1),
    WEST(-1)
    ;
    
    private CardinalPoint(int sense2D){
        this.sens2D = sense2D;
    }
    
    private final int sens2D;
    
    
    public int getSense2D(){
        return this.sens2D;
    }
    
    public CardinalPoint getOpposite(){
        CardinalPoint opposite = null;
        switch(this){
            case NORTH :
                opposite = CardinalPoint.SOUTH;
                break;
            case SOUTH :
                opposite = CardinalPoint.NORTH;
                break;
            case EAST :
                opposite = CardinalPoint.WEST;
                break;
            case WEST :
                opposite = CardinalPoint.EAST;
                break;
        }
        return opposite;
    }
}
