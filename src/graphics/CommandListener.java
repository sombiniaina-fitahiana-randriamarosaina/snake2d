/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author sombiniaina
 */
public class CommandListener extends KeyAdapter {
    public CommandListener(GameFrame game){
        this.game = game;
        this.game.addKeyListener(this);
    }
    
    // Fields
    protected GameFrame game;
    
    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();
        switch(key){
            case KeyEvent.VK_R :
                this.game.newGame();
                break;
            case KeyEvent.VK_P :
                this.game.togglePlayPause();
                break;
        }   
    } 
}
