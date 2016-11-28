
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

public class startTF extends Quiz implements ActionListener{
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
    String topicselected;
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
    static String OAS;
     JRadioButton oA;
    JRadioButton oB;
    String [][] data = new String [20][2];
    int max;
    boolean oAs;
    boolean oBs;
    int count = 0;
    
  startTF (){
      
      
     data();
  }
   void data (){
        try
        {
            int rowLocal = quizSlection.row;
            topicselected = quizSlection.data[rowLocal][1];
    
         connection = DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
			statement = connection.createStatement();
	resultSet = statement.executeQuery("SELECT Topic,Question,Correct,QuestionNum FROM TF");
                         
                        int i = 0;
			while (resultSet.next()) 
                        {
                           
                            String topicNum = resultSet.getString("Topic");
                            if (topicselected.equalsIgnoreCase(topicNum)){ 
                                qu = resultSet.getString("Question");
                                OAS = resultSet.getString("Correct");
                                
                               data [i][0] = qu;
                               data [i][1] = OAS;
                               
                               i++;
                                }
                           
                            }
                         max = i;
                        GUI(0);
                        
        }
        catch (Exception e)
        {
             System.out.println (e);
        }
        
    }

    
   void CheckTrueFalse()
   {
       if(data[count][1].equalsIgnoreCase(co))
       {
           //startMCQ.result++;
           JOptionPane.showMessageDialog(null, "Correct");
       }
       else
       {
            JOptionPane.showMessageDialog(null, "Wrong");
       }
      
         }
   
    void GUI (int i){
         if (i == max){
          //  String mark = Integer.toString(startMCQ.result);
          //  String total = Integer.toString(startMCQ.total);
          //  String expr = mark + "/" + total;
           // JOptionPane.showMessageDialog(null, "You have Recieved " + expr);
          //  System.out.println("Going to Short Answer");
            new startSA();
            frameNewUser.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING));
        }
        frameNewUser = new JFrame ();
        frameNewUser.setUndecorated(true);
        frameNewUser.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frameNewUser.setTitle ("True or False");
        frameNewUser.setSize (1000,500);
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
       JLabel welcome = new JLabel ("Question");
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
       Question.setText(data[i][0]);
       top.add(Question,gbc1);
       Question.setEditable(false);
       
       info.setLayout(new GridBagLayout());
       GridBagConstraints gbc2 = new GridBagConstraints();
       gbc2.gridx = 1;
       gbc2.gridy = 4;
       gbc2.insets = new Insets (1,1,1,1);
       JLabel Co = new JLabel ("Answer:");
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
      /* 
       if (answer.equalsIgnoreCase("true")){
           oA.setSelected(true);
       }
       if (answer.equalsIgnoreCase("false")){
           oB.setSelected(true);
       }
       */
        bottom.setLayout(new GridBagLayout ());
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 1;
        gbc3.gridy = 1;
        JButton submit = new JButton ("Submit");
        submit.addActionListener(this);
        bottom.add (submit, gbc3);
        
        myPanel.add (top , BorderLayout.NORTH);
        myPanel .add (info, BorderLayout.CENTER);
        myPanel.add (bottom, BorderLayout.SOUTH);
        contentPane.add (myPanel);
        frameNewUser.validate ();
        frameNewUser.setVisible(true);
        frameNewUser.toFront();
      
    }
      @Override
    public void actionPerformed (ActionEvent e)
    {
        String event = e.getActionCommand();
        /*
        * If the button clicked is create Account the check method is called
        * If the button clicked is Back, a login object is created. 
        */
        oAs = oA.isSelected();
        oBs = oB.isSelected();
        
       
        if (oAs)
        {
           co = "true";
        }
        else if (oBs)
        {
           co = "false";
        }
        
       
        if (event.equals ("Submit"))
        {
            try 
            {
                //qu = Question.getText();
                //answer = co;
               CheckTrueFalse();
               startMCQ.total++;
               GUI(++count);
               //frameNewUser.dispose();
            } 
            catch (Exception ex) 
            {
                //Avoid Error
            }
        }
    }
}
        
    
    
   