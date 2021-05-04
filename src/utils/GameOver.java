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
public class GameOver extends Exception{
    public GameOver(String reason){
        super(reason);
    }
}
