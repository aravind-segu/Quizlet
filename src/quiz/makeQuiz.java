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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class makeQuiz extends Quiz implements ActionListener {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null; 
    static Container contentPane;
    JPanel myPanel;
    JTextField firstName;
    JTextField lastName;
    JTextField userName;
    JTextField password;
    JTextField age;
    JFrame frameNewUser;
    static String topic;
    JTextField topicText;
    boolean found;
    makeQuiz (){
    GUI();
    }
    void GUI(){
        
        frameNewUser = new JFrame ();
        frameNewUser.setUndecorated(true);
        frameNewUser.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frameNewUser.setTitle ("New User");
        frameNewUser.setSize (500,200);
        frameNewUser.setVisible(true);
        frameNewUser.setLocationRelativeTo(null);
        
         contentPane = frameNewUser.getContentPane();
       
        
        
        myPanel = new JPanel ();
        myPanel.setLayout(new BorderLayout());
        JPanel top = new JPanel ();
        JPanel bottom = new JPanel();
     
        
        top.setLayout(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        JLabel welcome = new JLabel ("Enter Topic of Quiz");
        top.add(welcome, gbc1);
        topicText = new JTextField (20);
        topicText.setText(topic);
        top.add(topicText);
        
        gbc1.gridx = 0;
        gbc1.gridy = 1;
        JButton backLogin = new JButton ("Back");
        backLogin.addActionListener(this);
        bottom.add (backLogin, gbc1);
        
        gbc1.gridx = 1;
        gbc1.gridy = 1;
        JButton Next = new JButton ("Next");
        Next.addActionListener(this);
        bottom.add (Next, gbc1);
        
        
         myPanel.add (top , BorderLayout.CENTER);
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
        
          if (event.equals ("Next")){
            try {
                topic = topicText.getText();
                check();
                new questionType();
                frameNewUser.dispose();
            } catch (Exception ex) {
                System.out.println("Error");
            }
          }
          if (event.equals ("Back")){
            try {
               new MainWindowTeacher();
                frameNewUser.dispose();
            } catch (Exception ex) {
                System.out.println("Error");
            }
          }
    }
    void check (){
        String ltopic = topic;
        if (ltopic.equals (" ")){
            JOptionPane.showMessageDialog(null, "Sorry Topic is Left Blank");
            new mcq();
            frameNewUser.dispose();
        }
         try{
    connection = DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
			statement = connection.createStatement();
			//resultSet = statement.executeQuery("SELECT * FROM UserDetails WHERE Username = " + Username);
                        resultSet = statement.executeQuery("SELECT QuizNum, Topic FROM QuizList");
			while (resultSet.next()) {
                                String Topic = resultSet.getString("Topic");
                               if (Topic.equalsIgnoreCase(ltopic)){
                                   found = true;
                               }
                             
                               
                        }
                        //countid = Integer.parseInt(id);
                       // countid++;
                        resultSet.close();
			statement.close();
			connection.close();
                        if (found == true){
                            new questionType();
                        }else {
                            data();
                        }
                        
 }catch(Exception ex){
                                    JOptionPane.showMessageDialog(null, ex.toString());
                                }
        
        
    }
    void data (){
        String id = "0";
        int countid = 0;
 try{
    connection = DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
			statement = connection.createStatement();
			//resultSet = statement.executeQuery("SELECT * FROM UserDetails WHERE Username = " + Username);
                        resultSet = statement.executeQuery("SELECT QuizNum, Topic FROM QuizList");
			while (resultSet.next()) {
                                id = resultSet.getString("QuizNum");
                               
                                
                               
                        }
                        countid = Integer.parseInt(id);
                        countid++;
                        resultSet.close();
			statement.close();
			connection.close();
                        
 }catch(Exception ex){
                                    JOptionPane.showMessageDialog(null, ex.toString());
                                }
  //  String co = CA.getText();
    
    String sql = "INSERT INTO QuizList" 
               + "( QuizNum, Topic ) VALUES" 
               + "(?,?)";
    
    try{
        String num = Integer.toString(countid);
                                        Connection con=DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
                                        PreparedStatement ps =  con.prepareStatement(sql);
                                        ps.setString(1, num);
                                        ps.setString(2, topic);
                                       
                                        
                                        ps.executeUpdate();      
                                        
                                        ps.close();
                                        con.close();
                                        
                                }catch(Exception ex){
                                    JOptionPane.showMessageDialog(null, ex.toString());
                                }
         JOptionPane.showMessageDialog(null, "Quiz on " + topic + " successfully created");
         new questionType();
    }
    }
    

