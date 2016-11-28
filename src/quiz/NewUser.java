/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import static quiz.Quiz.frame;

/**
 *
 * @author mallikarjuna
 */
public class NewUser extends Quiz implements ActionListener {
   Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    static boolean newUser;
    static boolean loginCorrect = false;
    static JPasswordField passEntry;
    static JTextField nameEntry;
    Container contentPane;
    JPanel myPanel;
    JFrame newUserFrame;
    
    NewUser () {
        NewUserGUI ();
        } 

public void NewUserGUI (){
    newUserFrame = new JFrame ();
        
        newUserFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
       newUserFrame.setTitle ("Login");
        newUserFrame.setSize (500,500);
        newUserFrame.setVisible(true);
       newUserFrame.setLocationRelativeTo(null);
       
       contentPane = newUserFrame.getContentPane();
       
       myPanel = new JPanel();
         myPanel.setLayout(new BorderLayout());
       JPanel bottom = new JPanel();
       JPanel info = new JPanel ();
       info.setLayout (new GridBagLayout());
       GridBagConstraints gbc = new GridBagConstraints();
       /*
       gbc.gridy = 0;
       gbc.gridx = 1;
       gbc.insets = new Insets(1,1,1,1);
       JButton studentReg = new JButton ("Student Registration");
       studentReg.addActionListener (this);
       info.add(studentReg, gbc);
       */
       gbc.gridy = 5;
       gbc.gridx = 1;
       //gbc.insets = new Insets(1,1,1,1);
       JButton teacherReg = new JButton ("User Registration");
       teacherReg.addActionListener (this);
       info.add(teacherReg, gbc);
       
       bottom.setLayout(new BorderLayout ()); 
       JButton newUserLogin = new JButton ("Back");
       newUserLogin.addActionListener (this);
       bottom.add(newUserLogin, BorderLayout.CENTER);
       
       myPanel .add (bottom, BorderLayout.SOUTH);
       myPanel .add (info, BorderLayout.CENTER);
      
       contentPane.add(myPanel);
       newUserFrame.validate();
       
       
       
       
       
}

 @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        /*
        * If the new user button is pressed
        * The GuiNewUser object is created
        */
        if (event.equals ("User Registration")){
            try {
               new NewTeacher ();
               newUserFrame.dispose();
            } catch (Exception f) {
                System.out.println(" Sorry, Error Occured");
            }
        }
         /*
        * If the login button is pressed
        * The login method is called
        */
       if (event.equals ("Student Registration")){
            try {
               new newstudent ();
            } catch (Exception f) {
                System.out.println(" Sorry, Error Occured");
            }
        }
       if (event.equals ("Back")){
            try {
               new login();
               newUserFrame.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING));
            } catch (Exception f) {
                System.out.println(" Sorry, Error Occured");
            }
        }
    }

}

