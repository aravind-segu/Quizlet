
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

public class shortAnswer extends Quiz implements ActionListener {
    shortAnswer (){
        GUI ();
    }
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    static Container contentPane;
    JPanel myPanel;
    JTextField Question;
    JTextField Answer;
    JFrame frameNewUser;
    int id;
    String idString;
   void GUI (){
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
       JLabel A = new JLabel ("Answer");
       bottom.add(A, gbc2);
       gbc2.gridx = 1;
       gbc2.gridy = 0;
       Answer = new JTextField (20);
       bottom.add(Answer,gbc2);
       
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
    String a = Answer.getText();
   ;
    //String co = CA.getText();
     if (q.equals ("")){
            JOptionPane.showMessageDialog(null, "Sorry Question is Left Blank");
            new shortAnswer();
            frameNewUser.dispose();
        }
        /*
        * If the last name is blank:
            * A Retry Message is printed
            * A constructor of this class, NuewUserGui is called
            * The current frame is disposed.
        */ 
        else if (a.equals ("")){
            JOptionPane.showMessageDialog(null, "Answer");
            new shortAnswer();
            frameNewUser.dispose();
        }
       
        id ();
       
    }
      void id (){
        try{
    connection = DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
			statement = connection.createStatement();
			//resultSet = statement.executeQuery("SELECT * FROM UserDetails WHERE Username = " + Username);
                        resultSet = statement.executeQuery("SELECT Topic,Question,Correct,QuestionNum FROM SA");
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
    String a = Answer.getText();
    
  //  String co = CA.getText();
    String topic = makeQuiz.topic;
    String sql = "INSERT INTO SA" 
               + "(Topic,Question,Correct,QuestionNum) VALUES" 
               + "(?,?,?,?)";
    
    try{
                                        Connection con=DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
                                        PreparedStatement ps =  con.prepareStatement(sql);
                                        ps.setString(1, topic);
                                        ps.setString(2, q);
                                        ps.setString(3, a);
                                        ps.setString (4,idString);
                                        
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
