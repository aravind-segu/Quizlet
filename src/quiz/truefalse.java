
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
import static quiz.newstudent.contentPane;
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

public class truefalse extends Quiz implements ActionListener{
    static Container contentPane;
    JPanel myPanel;
    JFrame frameNewUser;
    int id;
    String idString;
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null; 
   
    truefalse (){
       truefalseGUI();
   } 
     JRadioButton oA;
    JRadioButton oB;
    String co;
    JTextField Question;
   
   void truefalseGUI (){
       
        frameNewUser = new JFrame ();
        frameNewUser.setUndecorated(true);
        frameNewUser.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frameNewUser.setTitle ("True or False");
        frameNewUser.setSize (800,500);
        frameNewUser.setVisible(true);
        frameNewUser.setLocationRelativeTo(null);
        
        contentPane = frameNewUser.getContentPane();
       
        
        
        myPanel = new JPanel ();
        myPanel.setLayout(new BorderLayout());
        JPanel top = new JPanel ();
        JPanel info = new JPanel();
        JPanel bottom = new JPanel ();
        
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
       
       info.setLayout(new GridBagLayout());
       GridBagConstraints gbc2 = new GridBagConstraints();
       gbc2.gridx = 1;
       gbc2.gridy = 4;
       gbc2.insets = new Insets (1,1,1,1);
       JLabel Co = new JLabel ("Correct Answer:");
         info.add(Co, gbc2);
       gbc2.gridx = 2;
       oA = new JRadioButton ("True");
     //  oA.addActionListener(this);
       info.add(oA,gbc2);
       gbc2.gridx++;
        oB = new JRadioButton ("False");
        info.add (oB, gbc2);
        ButtonGroup group = new ButtonGroup();
       group.add (oA);
       group.add (oB);
       
       
        bottom.setLayout(new GridBagLayout ());
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 1;
        gbc3.gridy = 1;
        JButton Next = new JButton ("Finish");
        Next.addActionListener(this);
        bottom.add (Next, gbc3);
        
         myPanel.add (top , BorderLayout.NORTH);
       myPanel .add (info, BorderLayout.CENTER);
       myPanel.add (bottom, BorderLayout.SOUTH);
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
        if (oAs){
           co = "true";
       }else if (oBs){
           co = "false";
       }
        if (event.equals ("Finish")){
            try {
               id();
               frameNewUser.dispose();
            } catch (Exception ex) {
               // Logger.getLogger(GuiNewUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   
    }
    void id(){
     try{
    connection = DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
			statement = connection.createStatement();
			//resultSet = statement.executeQuery("SELECT * FROM UserDetails WHERE Username = " + Username);
                        resultSet = statement.executeQuery("SELECT Topic,Question,Correct,QuestionNum FROM TF");
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
    }catch (Exception e){
        
    }
    }
   void data (){
    String q = Question.getText();
    String topic = makeQuiz.topic;
    String sql = "INSERT INTO TF" 
               + "( Topic,Question,Correct,QuestionNum ) VALUES" 
               + "(?,?,?,?)";
    
    try{
                                        Connection con=DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
                                        PreparedStatement ps =  con.prepareStatement(sql);
                                        ps.setString(1, topic);
                                        ps.setString(2, q);
                                        ps.setString(3, co);
                                        ps.setString(4, idString);
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
