    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.Timer;
import models.Game;
import relationalDatabase.utils.ConnectionHelper;

/**
 *
 * @author sombiniaina
 */
public class GameFrame extends JFrame implements Runnable{
    public GameFrame(Connection connection) throws SQLException, IllegalAccessException, InstantiationException{
        super("Snake 2D");
        this.game = new Game(connection);
        this.init();
        this.configure();
        this.newGame();
    }
    
    // Fields
    protected Game game;
    protected MainPanel mainPanel;
    protected Timer timer;
    protected Listener listener;
    protected KeyListener commandelistener;

    private void init() {
        this.mainPanel = new MainPanel(this.getGame());
        this.listener = new Listener(this);
        this.timer = new Timer(0, listener);
        this.commandelistener = new CommandListener(this);
    }
    
    private void configure (){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(new InfoPanel(this.game), BorderLayout.PAGE_START);
        this.getContentPane().add(this.mainPanel, BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    // Setters & Getters
    public Game getGame(){
        return this.game;
    }
    
    public void newGame(){
        this.game.newGame(this.getMainPanel().getSize());
        this.timer.setDelay(this.game.getSpeed());
        this.timer.start();
    }
    
    public MainPanel getMainPanel(){
        return this.mainPanel;
    }
    
    public void gameOver(){
        this.timer.stop();
        try(Connection connection = ConnectionHelper.SQLiteConnection("data.db")){
            this.game.gameOver(connection);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void togglePlayPause(){
        if(this.timer.isRunning()){
            this.timer.stop();
        }
        else{ 
            this.timer.start();
        }
    }
    
    public void accelerate(){
        this.timer.setDelay(this.game.accelerate());
    }   

    @Override
    public void run() {
        JFrame me = this;
        new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                me.repaint();
            }
        }).start();
    }
}
