/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import graphics.GameFrame;
import java.sql.Connection;
import relationalDatabase.utils.ConnectionHelper;

/**
 *
 * @author sombiniaina
 */
public class Snake {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try(Connection connection = ConnectionHelper.SQLiteConnection("data.db")){
            new Thread(new GameFrame(connection)).start();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
