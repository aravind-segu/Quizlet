/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;

/**
 *
 * @author mallikarjuna
 */
public class Quiz {
static Connection connect;
    static Statement statement;
    static ResultSet result;
    static JFrame frame;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /*
        * The login object created, intiating the program.
        */
        
        new login ();
        
 
}
    }
    

