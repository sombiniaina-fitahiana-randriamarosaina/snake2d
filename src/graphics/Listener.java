/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import utils.CardinalPoint;
import utils.GameOver;

/**
 *
 * @author sombiniaina
 */
public class Listener extends KeyAdapter implements ActionListener{

    public Listener(GameFrame frame) {
        frame.addKeyListener(this);
        this.frame = frame;
        this.key = KeyEvent.VK_RIGHT;
    }
  
    // Fields
    protected GameFrame frame;
    protected int key;
    
    @Override
    public void actionPerformed(ActionEvent a) {
        try {
            this.changeDirection();
            if(this.frame.getGame().getPlayer().getSnake().eat(this.frame.getGame().getFood(), this.frame.getMainPanel().getSize())){
                if(this.frame.getGame().getPlayer().getScore()%5 == 0 && this.frame.getGame().getPlayer().getScore() != 0)
                    this.frame.accelerate();
                return;
            }
            this.frame.getGame().getPlayer().getSnake().moveForward(this.frame.getMainPanel().getSize());
        } catch (GameOver ex) {
            this.frame.gameOver();
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        this.key = ke.getKeyCode();
    }    
    
    private void changeDirection(){
        switch(key){
            case KeyEvent.VK_UP :
                this.frame.getGame().getPlayer().getSnake().changeOriantationTo(CardinalPoint.NORTH);
                break;
            case KeyEvent.VK_DOWN :
                this.frame.getGame().getPlayer().getSnake().changeOriantationTo(CardinalPoint.SOUTH);
                break;
            case KeyEvent.VK_LEFT :
                this.frame.getGame().getPlayer().getSnake().changeOriantationTo(CardinalPoint.WEST);
                break;
            case KeyEvent.VK_RIGHT :
                this.frame.getGame().getPlayer().getSnake().changeOriantationTo(CardinalPoint.EAST);
                break;
        }
    }
}
