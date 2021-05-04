/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import utils.GameOver;
import utils.GraphicsChart;

/**
 *
 * @author sombiniaina
 */
public class Tail extends GraphicsChart{
    public Tail(Point p){
        super(p, new Dimension(10, 10));
        this.setColor(Color.WHITE);
    }
    
    public Tail(int x, int y){
        super(x, y, 10, 10);
    }
    
    // Fields
    protected Tail previous;
    protected Tail next;
    
    // Getters & Setters
    public Tail getNext() {
        return next;
    }

    public void setNext(Tail next) {
        this.next = next;
    }
    
    public void setPrevious(Tail previous){
        previous.setNext(this);
        this.previous = previous;
    }
    
    public boolean isHead(){
       return this.previous == null;
    }
    
    public boolean isTheLast(){
        return this.next == null;
    }
    
    private boolean isIntersectWithChilds(Rectangle rectngl){
        return (this.isTheLast()) ? false : super.intersects(rectngl) || this.next.isIntersectWithChilds(rectngl);
    } 
            
    public int getChildCount(){
        return (this.isTheLast()) ? 0 : 1 + this.next.getChildCount();
    }
    
    public void purge(){
        this.next = null;
    }
    
    public void move(Point p) throws GameOver{
        if(this.isHead() && isIntersectWithChilds(new Rectangle(p, this.getSize())))
            throw new GameOver("");
        Point location = this.getLocation();
        if(!this.isTheLast())
            this.next.move(location);
        this.move(p.x, p.y);
    }
    
    @Override
    public boolean intersects(Rectangle rec){
        if(!this.isTheLast())
            return this.next.intersects(rec) || super.intersects(rec);
        return super.intersects(rec);
    }
    
    public void draw(Graphics g){
        g.setColor(this.color);
        g.fillOval(this.x, this.y, this.width, this.height);
        if(!this.isTheLast())
            this.next.draw(g);
    }
    
    @Override
    public String toString(){
        return String.format("[x:%s, y:%s]", this.x, this.y);
    }
}
