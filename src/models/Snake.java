/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import utils.CardinalPoint;
import utils.GameOver;

/**
 *
 * @author sombiniaina
 */
public class Snake {
    // Constructor
    public Snake(){
        this.head = new Tail(0, 0);
        this.initialize();
    }
    
    // Fields
    protected CardinalPoint orientation;
    protected Tail head;
  
    public void incrementTail(Dimension dim){
        Tail tail = new Tail(this.getNextPosition(dim));
        this.head.setPrevious(tail);
        this.head = tail;
    }
    
    public Tail getHead(){
        return this.head;
    }
    
    public int getLenght(){
        return this.head.getChildCount() - 2;
    }
    
    public Point getNextPosition(Dimension dim){
        int x = this.getHead().x + ((this.orientation == CardinalPoint.EAST || this.orientation == CardinalPoint.WEST ) ? 10 * this.orientation.getSense2D() : 0);
        int y = this.getHead().y + ((this.orientation == CardinalPoint.NORTH || this.orientation == CardinalPoint.SOUTH ) ? 10 * this.orientation.getSense2D() : 0);
        x = (x > dim.getWidth() - 10) ? 0 : x;
        y = (y > dim.getHeight() - 10) ? 0 : y;
        x = (x < 0) ? (int)dim.getWidth() - 10 : x;
        y = (y < 0) ? (int)dim.getHeight() - 10 : y;
        return new Point(x, y);
    }
    
    public void moveForward (Dimension dim) throws GameOver{
        Rectangle nextPlace = new Rectangle(this.getNextPosition(dim), this.head.getSize());
        this.getHead().move(nextPlace.getLocation());
    }
    
    public void changeOriantationTo(CardinalPoint orientation){
        if(this.orientation.getOpposite() != orientation)
            this.orientation = orientation;
    }
    
    public boolean eat(Food food, Dimension dim){
        if(this.getHead().contains(food)){
            this.incrementTail(dim);
            do{
                food.changePosition(dim);
            } while(this.getHead().intersects(food));
            return true;
        }
        return false;
    }
    
    public void initialize(){
        this.orientation = CardinalPoint.EAST;
        this.head.purge();
        this.incrementTail(new Dimension(100, 0));
        this.incrementTail(new Dimension(100, 0));
    }
    
    public void draw(Graphics g){
        this.getHead().draw(g);
    }
}
