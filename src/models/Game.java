/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author sombiniaina
 */
public class Game {
    public Game(Connection connection) throws SQLException, IllegalAccessException, InstantiationException{
        this.initialSpeed = 100;
        this.player = Player.getPlayer(connection);
        this.player.setSnake(new Snake());
        this.food = new Apple();
    }
    
    // Fields
    protected int initialSpeed;
    protected boolean game;
    protected int speed;
    protected Player player;
    protected Food food;
    
    public void gameOver(Connection connection) throws SQLException, IllegalAccessException{
        this.player.update(connection);
        this.game = false;
    }
    
    public boolean isGameOver(){
        return !this.game;
    }
    
    public int getSpeed(){
        return this.speed;
    }
    
    public Player getPlayer(){
        return this.player;
    }

    public Food getFood() {
        return food;
    }
    
    public void newGame(Dimension dim){
        this.game = true;
        this.speed = this.initialSpeed;
        this.getFood().changePosition(dim);
        this.player.getSnake().initialize();
    }
    
    public int accelerate(){
        this.speed = (this.speed <= 50) ? this.speed : this.speed - 10;
        return this.speed;
    }
}
