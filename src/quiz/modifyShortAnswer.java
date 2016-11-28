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
 import javax.swing.*;
 import java.awt.*;
 import java.sql.*;
 import java.awt.event.*;

public class modifyShortAnswer extends Quiz implements ActionListener{
    modifyShortAnswer(){
        data ();
    }
    static String Quiznum;
    String topic;
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    static String qu;
    static String answer;
   // static String OBS;
   // static String OCS;
   // static String ODS;
   // static String correct;
    static Container contentPane;
    JPanel myPanel;
    JTextField Question;
    JTextField Answer;
    JTextField OB;
    JTextField OC;
    JTextField OD;
    JTextField CA;
    JFrame frameNewUser;
    String co;
 
     public void data (){
         try{
             
        int rowLocal = modifyCenter.rowRight;
        Quiznum = modifyCenter.dataRight[rowLocal][0] ;
        topic = modifyCenter.dataRight[rowLocal][1];
    
         connection = DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
			statement = connection.createStatement();
	resultSet = statement.executeQuery("SELECT Topic,Question,Correct,QuestionNum FROM SA");
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
                                answer = resultSet.getString("Correct");
                                modifyMCQDisplay ();
                                //if (modify == 0){
                                  //  continue;
                                //}
                                //if (modify == 1){
                                 //   resultSet.updateString("Question", qu);
                                   // resultSet.updateString("OptionA", OAS);
                                  //  resultSet.updateString("OptionB", OBS);
                                  //  resultSet.updateString("OptionC", OCS);
                                 //   resultSet.updateString("OptionD", ODS);
                                 //   resultSet.updateString("Correct", correct);
                                 //   frameNewUser.dispose();
                                }
                            }
    
        }catch (Exception e){
             System.out.println (e);
        }
     }
    void  modifyMCQDisplay (){
         frameNewUser = new JFrame ();
        frameNewUser.setUndecorated(true);
        frameNewUser.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frameNewUser.setTitle ("Short Answer");
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
       Question.setText(qu);
       Question.setPreferredSize( new Dimension( 540, 50 ) );
       top.add(Question,gbc1);
       
        bottom.setLayout(new GridBagLayout());
       GridBagConstraints gbc2 = new GridBagConstraints();
       gbc2.gridx = 0;
       gbc2.gridy = 0;
       gbc2.insets = new Insets(6,6,6,6);
       JLabel A = new JLabel ("Answer");
       bottom.add(A, gbc2);
       gbc2.gridx = 1;
       gbc2.gridy = 0;
       Answer = new JTextField (20);
       Answer.setText(answer);
       bottom.add(Answer,gbc2);
       
        gbc1.gridx = 1;
        gbc1.gridy = 1;
        JButton Next = new JButton ("Modify");
        Next.addActionListener(this);
        low.add (Next, gbc1);
       
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
      
       
        if (event.equals ("Modify")){
            try {
               qu = Question.getText();
               answer = Answer.getText();
               
               
               new modifySA();   
               frameNewUser.dispose();
               
            } catch (Exception ex) {
               // Logger.getLogger(GuiNewUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
}
