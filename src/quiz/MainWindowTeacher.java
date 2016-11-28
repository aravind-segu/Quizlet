/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.*;

public class MainWindowTeacher extends Quiz implements ActionListener{
    static JFrame TeacherMembersFrame;
    
 MainWindowTeacher (){
     GUI();
 }   
 public void GUI (){
       
        TeacherMembersFrame = new JFrame ();
        
        TeacherMembersFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        TeacherMembersFrame.setTitle ("Teacher Main Menu");
        TeacherMembersFrame.setSize (800,800);
        TeacherMembersFrame.setVisible(true);
        TeacherMembersFrame.setLocationRelativeTo(null);
        Container contentPane = TeacherMembersFrame.getContentPane();
          /*
        * Two Panels are defined main and bottom
        */        
        JPanel myPanel = new JPanel ();
        JPanel bottom = new JPanel ();
        JPanel top = new JPanel();
        
        myPanel.setLayout(new BorderLayout());
        bottom.setLayout(new GridBagLayout());
        /*
        * Modify button is added to the bottom panel
        */
        top.setLayout(new GridBagLayout());
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.insets = new Insets(1,1,1,1);
        JLabel welcome = new JLabel ("Welcome!!");
        welcome.setFont(new Font ("Arial",Font.BOLD , 24));
        top.add (welcome, gbc2);
        
        
       gbc2.gridx = 0;
       gbc2.gridy = 1;
        JLabel inst = new JLabel ("Please Select One of the following options");
        inst.setFont(new Font ("Arial",Font.BOLD , 18));
        top.add (inst, gbc2);
        
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.insets = new Insets(5,5,5,5);
       JButton button = new JButton ("Make New Quiz");
       button.addActionListener (this);
       bottom.add(button, gbc1);
       
        /*
        * View Check Outs button is added to the bottom panel
        */
       /*
       gbc1.gridx = 1;
        gbc1.gridy = 0;
       JButton checkOuts = new JButton ("Access Results");
       checkOuts.addActionListener (this);
       bottom.add(checkOuts, gbc1);
       */
       /*
       * A button called Delete is added
       * The button is given actionListener
       * It is added to the Bottom Panel at Position East
       */
       gbc1.gridx = 2;
        gbc1.gridy = 0;
       JButton delbutton = new JButton ("View Past Quizzes");
       delbutton.addActionListener (this);
       bottom.add(delbutton, gbc1);
       /*
       gbc1.gridx = 3;
        gbc1.gridy = 0;
       JButton takebutton = new JButton ("Start a Quiz");
       delbutton.addActionListener (this);
       bottom.add(takebutton, gbc1);
*/
       /*
       * My Panel is added
       
       */
       myPanel.add(top, BorderLayout.NORTH);
       myPanel.add(bottom, BorderLayout.CENTER);
        
       contentPane.add(myPanel);
       TeacherMembersFrame.validate();
}
     @Override
    public void actionPerformed (ActionEvent e){
        String event = e.getActionCommand();
          /*
        * If the modify button is pressed the modify object is made
        */
        if (event.equals ("Make New Quiz")){
            try {
                new makeQuiz ();
                TeacherMembersFrame.dispose();
                TeacherMembersFrame.setVisible(false);
                
            } catch (Exception ex) {
                System.out.println("Error");
            }
        }
             /*
        * If the delete button is pressed the deletebooks object is made
        */
        if (event.equals ("Access Results")){
            try {
                //new Results ();
                TeacherMembersFrame.dispose();
                TeacherMembersFrame.setVisible(false);
            } catch (Exception ex) {
                System.out.println("Error");
            }
        }
                  /*
        * If the back button is pressed the mainWindow object is made
        */    
        if (event.equals ("View Past Quizzes")){
            try {
                new quizSlection();
                TeacherMembersFrame.dispose();
                TeacherMembersFrame.setVisible(false);
                
            } catch (Exception ex) {
                System.out.println("Error");
            }
        }
        if (event.equals ("Start a Quiz")){
            try {
              //  new startQuiz();
                TeacherMembersFrame.dispose();
                TeacherMembersFrame.setVisible(false);
                
            } catch (Exception ex) {
                System.out.println("Error");
            }
        }
    }
}
