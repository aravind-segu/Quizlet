/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class questionType extends Quiz implements ActionListener{
    questionType (){
        GUI();
    }
      static Container contentPane;
    JPanel myPanel;
    JTextField firstName;
    JTextField lastName;
    JTextField userName;
    JTextField password;
    JTextField age;
    JFrame frameNewUser;
    
    void GUI(){
        
        frameNewUser = new JFrame ();
        frameNewUser.setUndecorated(true);
        frameNewUser.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frameNewUser.setTitle ("Choose Question Type");
        frameNewUser.setSize (500,200);
        frameNewUser.setVisible(true);
        frameNewUser.setLocationRelativeTo(null);
        
         contentPane = frameNewUser.getContentPane();
       
        
        
        myPanel = new JPanel ();
        myPanel.setLayout(new BorderLayout());
        JPanel top = new JPanel ();
        JPanel bottom = new JPanel();
        JPanel info =new JPanel();
     
        info.setLayout(new GridBagLayout());
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 0;
        gbc3.insets = new Insets(1,1,1,1);
        JLabel welcome = new JLabel ("Select the Type of Question");
        welcome.setFont(new Font ("Arial",Font.BOLD ,20));
        info.add (welcome, gbc3);
        
        
            
       top.setLayout(new GridBagLayout());
       GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
       gbc1.gridy = 0;
       gbc1.insets = new Insets(5,5,5,5);
        JButton MCQ = new JButton ("Multiple Choice Question");
        MCQ.addActionListener(this);
        top.add(MCQ,gbc1);
       // top.add(MCQ);
        
        gbc1.gridx = 2;
        gbc1.gridy = 0;
        JButton True = new JButton ("True False");
        True.addActionListener(this);
        top.add(True, gbc1);
        //top.add(True);
        
       gbc1.gridx = 3;
       gbc1.gridy = 0;
        JButton SA = new JButton ("Short Answer");
        SA.addActionListener(this);
        top.add(SA, gbc1);
        //top.add(MCQ);
        
        bottom.setLayout(new GridBagLayout());
       GridBagConstraints gbc2 = new GridBagConstraints();
        gbc1.gridx = 0;
       gbc1.gridy = 0;
       gbc1.insets = new Insets(5,5,5,5);
        JButton finish = new JButton ("Finish");
        finish.addActionListener(this);
        bottom.add(finish,gbc2);
        
        
        
        myPanel.add (info, BorderLayout.NORTH); 
        myPanel.add (top, BorderLayout.CENTER);
         myPanel.add (bottom , BorderLayout.SOUTH);
        contentPane.add (myPanel);
        frameNewUser.validate ();
    }
    @Override
    public void actionPerformed (ActionEvent e){
        String event = e.getActionCommand();
        /*
        * If the button clicked is create Account the check method is called
        * If the button clicked is Back, a login object is created. 
        */
        if (event.equals ("Multiple Choice Question")){
            try {
               new mcq ();
               frameNewUser.dispose();
            } catch (Exception ex) {
              //  Logger.getLogger(GuiNewUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (event.equals ("Finish")){
            try {
                makeQuiz.topic = "";
                new MainWindowTeacher();
                frameNewUser.dispose();
            } catch (Exception ex) {
                System.out.println("Error");
            }
        }
          if (event.equals ("True False")){
            try {
             //   topic = topicText.getText();
                new truefalse();
                frameNewUser.dispose();
            } catch (Exception ex) {
                System.out.println("Error");
            }
          }
          if (event.equals ("Short Answer")){
            try {
             //   topic = topicText.getText();
                new shortAnswer();
                frameNewUser.dispose();
            } catch (Exception ex) {
                System.out.println("Error");
            }
          }
    }
    }


