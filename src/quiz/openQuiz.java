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

public class openQuiz extends Quiz implements ActionListener{
    openQuiz(){
        data ();
    }
    
    static String Quiznum;
    String topic;
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    static String qu;
    static String OAS;
    static String OBS;
    static String OCS;
    static String ODS;
    static String correct;
    static Container contentPane;
    JPanel myPanel;
    JTextField Question;
    JTextField OA;
    JTextField OB;
    JTextField OC;
    JTextField OD;
    JTextField CA;
    JFrame frameNewUser;
    String co;
    JRadioButton oA;
    JRadioButton oB;
    JRadioButton oC;
    JRadioButton oD;
    int modify = 0;
    
    
    public void data (){
        /*
        * The row selected by the user is retreived 
        * The data in that row is stored for later user
        */
        int rowLocal = modifyCenter.rowLeft;
        Quiznum = modifyCenter.dataLeft[rowLocal][0] ;
        topic = modifyCenter.dataLeft[rowLocal][1];

        
       datamc();
        
    }
    void datamc(){
        try{
    
         connection = DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
			statement = connection.createStatement();
	resultSet = statement.executeQuery("SELECT Topic,Question,OptionA,OptionB,OptionC,OptionD,Correct,QuestionNum FROM MCQ");
                         /*
                        * The while loop iterates through each row of Table, BookDetails
                             * All data from each column is retrieved and stored in seperate strings
                             * An if loop determines if the input Text of user matches the BookID of the data
                                    * If found the data from each column is added to its specific ArrayList
                                    * boolean found is made true
                        * All connections are closed
                        */
			while (resultSet.next()) {
                            String QuestionNum = resultSet.getString("QuestionNum");
                            if (Quiznum.equalsIgnoreCase(QuestionNum)){ 
                                qu = resultSet.getString("Question");
                                OAS = resultSet.getString("OptionA");
                                OBS = resultSet.getString("OptionB");
                                OCS = resultSet.getString("OptionC");
                                ODS = resultSet.getString("OptionD");
                                correct = resultSet.getString ("Correct");
                                modifyMCQDisplay ();
                                if (modify == 0){
                                    continue;
                                }
                                if (modify == 1){
                                    resultSet.updateString("Question", qu);
                                    resultSet.updateString("OptionA", OAS);
                                    resultSet.updateString("OptionB", OBS);
                                    resultSet.updateString("OptionC", OCS);
                                    resultSet.updateString("OptionD", ODS);
                                    resultSet.updateString("Correct", correct);
                                    frameNewUser.dispose();
                                }
                            }
    }
        }catch (Exception e){
             System.out.println (e);
        }
}
     void modifyMCQDisplay () {
        frameNewUser = new JFrame ();
        frameNewUser.setUndecorated(true);
        frameNewUser.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frameNewUser.setTitle ("Multiple Choice Question Modification");
        frameNewUser.setSize (800,500);
        frameNewUser.setVisible(true);
        frameNewUser.setLocationRelativeTo(null);
        
         contentPane = frameNewUser.getContentPane();
         
         myPanel = new JPanel ();
        myPanel.setLayout(new BorderLayout());
        JPanel top = new JPanel ();
        JPanel bottom = new JPanel();
        JPanel low = new JPanel();
     
        
       top.setLayout(new GridBagLayout());
       GridBagConstraints gbc1 = new GridBagConstraints();
       gbc1.gridx = 1;
       gbc1.gridy = 0;
        gbc1.insets = new Insets(5,5,5,5);
       JLabel welcome = new JLabel ("Modify");
       welcome.setFont(new Font ("Arial",Font.BOLD , 24));
       top.add(welcome, gbc1);
      
       gbc1.gridx = 0;
       gbc1.gridy = 1;
              JLabel question = new JLabel ("Question");
       top.add(question, gbc1);
       
       gbc1.gridx = 1;
       gbc1.gridy = 1;
       Question = new JTextField (50);
       Question.setPreferredSize( new Dimension( 540, 50 ) );
       Question.setText(qu);
       top.add(Question,gbc1);
       
       bottom.setLayout(new GridBagLayout());
       GridBagConstraints gbc2 = new GridBagConstraints();
       gbc2.gridx = 0;
       gbc2.gridy = 0;
       gbc2.insets = new Insets(6,6,6,6);
       JLabel A = new JLabel ("Option A");
       bottom.add(A, gbc2);
       gbc2.gridx = 1;
       gbc2.gridy = 0;
       OA = new JTextField (20);
       OA.setText(OAS);
       bottom.add(OA,gbc2);
       
       
       gbc2.gridx = 0;
       gbc2.gridy = 1;
       //gbc1.insets = 
       JLabel B = new JLabel ("Option B");
       bottom.add(B, gbc2);
       gbc2.gridx = 1;
       gbc2.gridy = 1;
       OB = new JTextField (20);
       OB.setText(OBS);
       bottom.add(OB,gbc2);
       
        gbc2.gridx = 0;
       gbc2.gridy = 2;
       //gbc1.insets = 
       JLabel C = new JLabel ("Option C");
       bottom.add(C, gbc2);
       gbc2.gridx = 1;
       gbc2.gridy = 2;
       OC = new JTextField (20);
       OC.setText(OCS);
       bottom.add(OC,gbc2);
       
       gbc2.gridx = 0;
       gbc2.gridy = 3;
       //gbc1.insets = 
       JLabel D = new JLabel ("Option D");
       bottom.add(D, gbc2);
       gbc2.gridx = 1;
       gbc2.gridy = 3;
       OD = new JTextField (20);
       OD.setText(ODS);
       bottom.add(OD,gbc2);
       
       gbc2.gridx = 1;
       gbc2.gridy = 4;
       gbc2.insets = new Insets (1,1,1,1);
       JLabel Co = new JLabel ("Correct Answer:");
       bottom.add(Co, gbc2);
       gbc2.gridx = 2;
       oA = new JRadioButton ("A");
     //  oA.addActionListener(this);
       bottom.add(oA,gbc2);
       gbc2.gridx++;
        oB = new JRadioButton ("B");
    //   oB.addActionListener(this);
       bottom.add(oB,gbc2);
       gbc2.gridx++;
        oC = new JRadioButton ("C");
   //    oC.addActionListener(this);
       bottom.add(oC,gbc2);
       gbc2.gridx++;
       oD = new JRadioButton ("D");
   //    oD.addActionListener(this);
       bottom.add(oD,gbc2);
       ButtonGroup group = new ButtonGroup();
       group.add (oA);
       group.add (oB);
       group.add (oC);
       group.add (oD);
       
       if (correct.equals (OAS)){
           oA.setSelected(true);
       }
       if (correct.equals (OBS)){
           oB.setSelected(true);
       }
       if (correct.equals (OBS)){
           oB.setSelected(true);
       }
       if (correct.equals (OBS)){
           oB.setSelected(true);
       }
              
        gbc1.gridx = 2;
        gbc1.gridy = 1;
        JButton Modify = new JButton ("Modify");
        Modify.addActionListener(this);
        low.add (Modify, gbc1);
       
       myPanel.add (top, BorderLayout.NORTH);
         myPanel.add (bottom , BorderLayout.CENTER);
         myPanel.add(low, BorderLayout.SOUTH);
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
        boolean oAs = oA.isSelected();
       boolean oBs = oB.isSelected();
       boolean oCs = oC.isSelected();
       boolean oDs = oD.isSelected();
       
       if (oAs){
           co = OA.getText();
       }else if (oBs){
           co = OB.getText();
       }else if (oCs){
        co = OC.getText();
    }else if (oDs){
        co = OD.getText();
    }
       
        if (event.equals ("Modify")){
            try {
               qu = Question.getText();
               OAS = OA.getText();
               OBS = OB.getText();
               OCS = OC.getText();
               ODS = OD.getText();
               correct = co;
               
               new modifyMC();   
               frameNewUser.dispose();
               
            } catch (Exception ex) {
               // Logger.getLogger(GuiNewUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (event.equals ("Next")){
            try {
               modify = 0;
              // return;
               frameNewUser.dispose();
            } catch (Exception ex) {
               // Logger.getLogger(GuiNewUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   
    }
    
}
