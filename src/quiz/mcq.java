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

public class mcq extends Quiz implements ActionListener{
    
    mcq (){
        GUI ();
    }
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null; 
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
    int id;
    String idString;
    
    void GUI (){
        frameNewUser = new JFrame ();
        frameNewUser.setUndecorated(true);
        frameNewUser.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frameNewUser.setTitle ("Multiple Choice Question");
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
       JLabel welcome = new JLabel ("Question for "+ makeQuiz.topic);
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
       bottom.add(OA,gbc2);
       
       
       gbc2.gridx = 0;
       gbc2.gridy = 1;
       //gbc1.insets = 
       JLabel B = new JLabel ("Option B");
       bottom.add(B, gbc2);
       gbc2.gridx = 1;
       gbc2.gridy = 1;
       OB = new JTextField (20);
       bottom.add(OB,gbc2);
       
        gbc2.gridx = 0;
       gbc2.gridy = 2;
       //gbc1.insets = 
       JLabel C = new JLabel ("Option C");
       bottom.add(C, gbc2);
       gbc2.gridx = 1;
       gbc2.gridy = 2;
       OC = new JTextField (20);
       bottom.add(OC,gbc2);
       
       gbc2.gridx = 0;
       gbc2.gridy = 3;
       //gbc1.insets = 
       JLabel D = new JLabel ("Option D");
       bottom.add(D, gbc2);
       gbc2.gridx = 1;
       gbc2.gridy = 3;
       OD = new JTextField (20);
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
       
       
       
       
              
       gbc1.gridx = 1;
        gbc1.gridy = 1;
        JButton Next = new JButton ("Finish");
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
       
        if (event.equals ("Finish")){
            try {
               check();
               frameNewUser.dispose();
            } catch (Exception ex) {
               // Logger.getLogger(GuiNewUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   
    }
    
    void check (){
          String q = Question.getText();
    String a = OA.getText();
    String b = OB.getText();
    String c = OC.getText();
    String d = OD.getText();
    //String co = CA.getText();
     if (q.equals ("")){
            JOptionPane.showMessageDialog(null, "Sorry Question is Left Blank");
            new mcq();
            frameNewUser.dispose();
        }
        /*
        * If the last name is blank:
            * A Retry Message is printed
            * A constructor of this class, NuewUserGui is called
            * The current frame is disposed.
        */ 
        else if (a.equals ("")){
            JOptionPane.showMessageDialog(null, "Option A is Left Blank");
            new mcq();
            frameNewUser.dispose();
        }
        /*
        * If the username is blank:
            * A Retry Message is printed
            * A constructor of this class, NuewUserGui is called
            * The current frame is disposed.
        */ 

        else if (b.equals ("")){
            JOptionPane.showMessageDialog(null, "Option B is Left Blank");
            new mcq();
            frameNewUser.dispose();
        }
        /*
        * If the password is blank:
            * A Retry Message is printed
            * A constructor of this class, NuewUserGui is called
            * The current frame is disposed.
        */ 
        else if (c.equals ("")){
            JOptionPane.showMessageDialog(null, "Option C is Left Blank");
            new mcq();
            frameNewUser.dispose();
        }
     else if (d.equals ("")){
            JOptionPane.showMessageDialog(null, "Option D is Left Blank");
            new mcq();
            frameNewUser.dispose();
        }
     /*
     else if (co.equals ("")){
            JOptionPane.showMessageDialog(null, "Correct Answer is Left Blank");
            new mcq();
            frameNewUser.dispose();
        }
     */   
        id ();
       
    }
    void id (){
        try{
    connection = DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
			statement = connection.createStatement();
			//resultSet = statement.executeQuery("SELECT * FROM UserDetails WHERE Username = " + Username);
                        resultSet = statement.executeQuery("SELECT Topic,Question,OptionA,OptionB,OptionC,OptionD,Correct,QuestionNum FROM MCQ");
			while (resultSet.next()) {
                                idString = resultSet.getString("QuestionNum");
                               
                                
                               
                        }
                        id = Integer.parseInt(idString);
                        id++;
                        idString = Integer.toString(id);
                        resultSet.close();
			statement.close();
			connection.close();
                        data();
                        
 }catch(Exception ex){
                                    JOptionPane.showMessageDialog(null, ex.toString());
                                }
    }
    void data (){
    String q = Question.getText();
    String a = OA.getText();
    String b = OB.getText();
    String c = OC.getText();
    String d = OD.getText();
  //  String co = CA.getText();
    String topic = makeQuiz.topic;
    String sql = "INSERT INTO MCQ" 
               + "( Topic,Question,OptionA,OptionB,OptionC,OptionD,Correct,QuestionNum ) VALUES" 
               + "(?,?,?,?,?,?,?,?)";
    
    try{
                                        Connection con=DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
                                        PreparedStatement ps =  con.prepareStatement(sql);
                                        ps.setString(1, topic);
                                        ps.setString(2, q);
                                        ps.setString(3, a);
                                        ps.setString(4, b);
                                        ps.setString(5, c);
                                        ps.setString(6, d);
                                        ps.setString(7, co);
                                        ps.setString(8, idString);
                                        ps.executeUpdate();      
                                        
                                        ps.close();
                                        con.close();
                                        
                                }catch(Exception ex){
                                    JOptionPane.showMessageDialog(null, ex.toString());
                                }
         JOptionPane.showMessageDialog(null, "Question Added into " + topic);
         new questionType();
    }
         
         
}
    

