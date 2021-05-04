/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import relationalDatabase.Operation;
import relationalDatabase.annotation.Column;
import relationalDatabase.annotation.Id;
import relationalDatabase.annotation.Table;

/**
 *
 * @author sombiniaina
 */
@Table(name="Player")
public class Player {

    // Constructor
    public Player() {
        this.score = 0;
        this.bestScore = 0;
    }
    
    // Fields
    @Column(name="idPlayer") @Id protected Integer idPlayer;
    @Column(name="bestScore") protected Integer bestScore;
    protected Integer score;
    protected Snake snake;

    // Setters & Getters
    public Integer getIdPlayer() {
        return idPlayer;
    }
    
    public void setIdPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
    }

    public Integer getBestScore() {
        return bestScore;
    }

    public void setBestScore(Integer score) {
        this.bestScore = score;
    }
    
    public Integer getScore() {
        score = this.snake.getLenght();
        if(score > bestScore) bestScore = score;
        return score;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }
    
    public void insert(Connection connection) throws SQLException, IllegalArgumentException, IllegalAccessException{
        List<Player> l = new ArrayList(1);
        l.add(this);
        Operation.insert(connection, l);
    }
    
    public void update(Connection connection) throws SQLException, IllegalArgumentException, IllegalAccessException{
        List<Player> l = new ArrayList(1);
        l.add(this);
        Operation.update(connection, l);
    }

    public static Player getPlayer(Connection connection) throws SQLException, IllegalAccessException, InstantiationException {
        List<Player> list = Operation.findAll(connection, Player.class);
        if (list.size() == 0){
            Player p = new Player();
            p.insert(connection);
            return p;
        }
        return list.get(0);
    }
        
    public String toString(){
        return String.format("[idPlayer:%s, bestScore:%s]", idPlayer, bestScore);
    }
}
