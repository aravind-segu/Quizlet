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

public class startMCQ extends Quiz implements ActionListener
{
    startMCQ ()
    {
        data ();
    }
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null; 
    static Container contentPane;
    JPanel myPanel;
    JTextField Question;
    
    boolean oAs;
    boolean oBs;
    boolean oCs;
    boolean oDs;
    
    static String qu;
    static String OAS;
    static String OBS;
    static String OCS;
    static String ODS;
    static String num;
    static String correct;
    static int count = 0;
    String topicselected;
    JFrame frameNewUser;
    String co;
    JRadioButton oA;
    JRadioButton oB;
    JRadioButton oC;
    JRadioButton oD;
    int max;
    int id;
    String idString;
    int question = 0;
    String [][] data = new String [20][7];
    static int result = 0;
    static int total = 0;
    void data (){
        try
        {
            int rowLocal = quizSlection.row;
            topicselected = quizSlection.data[rowLocal][1];
    
         connection = DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
			statement = connection.createStatement();
	resultSet = statement.executeQuery("SELECT Topic,Question,OptionA,OptionB,OptionC,OptionD,Correct,QuestionNum FROM MCQ");
                         
                        int i = 0;
			while (resultSet.next()) 
                        {
                           
                            String topicNum = resultSet.getString("Topic");
                            if (topicselected.equalsIgnoreCase(topicNum)){ 
                                qu = resultSet.getString("Question");
                                OAS = resultSet.getString("OptionA");
                                OBS = resultSet.getString("OptionB");
                                OCS = resultSet.getString("OptionC");
                                ODS = resultSet.getString("OptionD");
                                correct = resultSet.getString ("Correct");
                                num = resultSet.getString("QuestionNum");
                               data [i][0] = qu;
                               data [i][1] = OAS;
                               data [i][2] = OBS;
                               data [i][3] = OCS;
                               data [i][4] = ODS;
                               data [i][5] = correct;
                               data [i][6] = num;
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
    void GUI (int i){
       
        if (i == max){
            new startTF();
            frameNewUser.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING));
            
           
            
            //System.out.println("Going to True False");
           // frameNewUser.dispose();
            
        }
        
        
        frameNewUser = new JFrame ();
        frameNewUser.setUndecorated(true);
        frameNewUser.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frameNewUser.setTitle ("Multiple Choice Question");
        frameNewUser.setSize (1000,500);
        frameNewUser.setVisible(true);
        frameNewUser.setLocationRelativeTo(null);
        
        contentPane = frameNewUser.getContentPane();
         
        myPanel = new JPanel ();
        myPanel.setLayout(new BorderLayout());
        JPanel top = new JPanel ();
        JPanel bottom = new JPanel();
        JPanel low = new JPanel();
     
        
        GridBagConstraints gbc1 = new GridBagConstraints();
        
        /*
       top.setLayout(new GridBagLayout());
       
       gbc1.gridx = 1;
       gbc1.gridy = 0;
        gbc1.insets = new Insets(5,5,5,5);
      // JLabel welcome = new JLabel ("Question for "+ .topic);   //CHANGE THIS
       welcome.setFont(new Font ("Arial",Font.BOLD , 24));
       top.add(welcome, gbc1);
      */
       gbc1.gridx = 0;
       gbc1.gridy = 1;
              JLabel question = new JLabel ("Question");
       top.add(question, gbc1);
       
       gbc1.gridx = 1;
       gbc1.gridy = 1;
       Question = new JTextField (50);
       Question.setPreferredSize( new Dimension( 540, 50 ) );
       Question.setText(data[i][0]);
       Question.setEditable(false);
       top.add(Question,gbc1);
       
       bottom.setLayout(new GridBagLayout());
       GridBagConstraints gbc2 = new GridBagConstraints();
       
       
       gbc2.gridx = 2;
       gbc2.gridy = 0;
       oA = new JRadioButton ("A - " + data [i][1]);
     //  oA.addActionListener(this);
       bottom.add(oA,gbc2);
       gbc2.gridy++;
        oB = new JRadioButton ("B - " + data [i][2]);
    //   oB.addActionListener(this);
       bottom.add(oB,gbc2);
       gbc2.gridy++;
        oC = new JRadioButton ("C - " + data [i][3]);
   //    oC.addActionListener(this);
       bottom.add(oC,gbc2);
       gbc2.gridy++;
       oD = new JRadioButton ("D - " + data [i][4]);
   //    oD.addActionListener(this);
       bottom.add(oD,gbc2);
       ButtonGroup group = new ButtonGroup();
       group.add (oA);
       group.add (oB);
       group.add (oC);
       group.add (oD);
         
       gbc1.gridx = 1;
       gbc1.gridy = 1;
       JButton Next = new JButton ("Submit");
       Next.addActionListener (this);
       /*
       Next.addActionListener(new ActionListener() {  
  public void actionPerformed(ActionEvent e) { 
    boolean oAs = oA.isSelected();
       boolean oBs = oB.isSelected();
       boolean oCs = oC.isSelected();
       boolean oDs = oD.isSelected();
       
       
        if (e.equals ("Submit"))
        {
            try 
            {
                
                check();
                //question++;
                data();
             
            } 
            catch (Exception ex) 
            {
               // Logger.getLogger(GuiNewUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
  } 
} );*/
       low.add (Next, gbc1);
       
       myPanel.add (top, BorderLayout.NORTH);
       myPanel.add (bottom , BorderLayout.CENTER);
       myPanel.add(low, BorderLayout.SOUTH);
       contentPane.add (myPanel);
       frameNewUser.validate (); 
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
        oCs = oC.isSelected();
        oDs = oD.isSelected();
       
       
        if (event.equals ("Submit"))
        {
            try 
            {
                
                check();
                //question++;
                //data();
                int i = ++count;
                /*
                 if (i == max){
                     new startTF();
                   //  frameNewUser.dispose();
                 }
                       */
                frameNewUser.dispose();
                total++;
                GUI(i);
                
             
            } 
            catch (Exception ex) 
            {
               // Logger.getLogger(GuiNewUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   
    }
    
    void check ()
    {
        if (!oAs && !oBs && !oCs && !oDs)
        {
            JOptionPane.showMessageDialog(null, "You have not selected an answer");
            //GUI(count);
            frameNewUser.dispose();
        }      
        if (oAs)
        {
            if (data[count][1].equals(data[count][5])){
                result++;
                JOptionPane.showMessageDialog(null, "Correct!");
             //   GUI (count++);
            }
            else
                JOptionPane.showMessageDialog(null, "Wrong!");
            //    GUI (count++);
        }
        if (oBs)
        {
            if (data[count][2].equals(data[count][5])){
                result++;
                JOptionPane.showMessageDialog(null, "Correct!");
             //   GUI (count++);
            }
            else
                JOptionPane.showMessageDialog(null, "Wrong!");
            //    GUI (count++);
        }
        if (oCs)
        {
            if (data[count][3].equals(data[count][5])){
                result++;
                JOptionPane.showMessageDialog(null, "Correct!");
             //   GUI (count++);
            }
            else
                JOptionPane.showMessageDialog(null, "Wrong!");
            //    GUI (count++);
        }
        if (oDs)
        {
            if (data[count][4].equals(data[count][5])){
                result++;
                JOptionPane.showMessageDialog(null, "Correct!");
             //   GUI (count++);
            }
            else
                JOptionPane.showMessageDialog(null, "Wrong!");
             //   GUI (count++);
        }
       // id ();    
    }
    void id ()
    {
        try
        {
            connection = DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
            statement = connection.createStatement();
            //resultSet = statement.executeQuery("SELECT * FROM UserDetails WHERE Username = " + Username);
            resultSet = statement.executeQuery("SELECT Topic,Question,OptionA,OptionB,OptionC,OptionD,Correct,QuestionNum FROM MCQ");
            while (resultSet.next()) 
            {
                idString = resultSet.getString("QuestionNum");
            }
            id = Integer.parseInt(idString);
            id++;
            idString = Integer.toString(id);
            resultSet.close();
            statement.close();
            connection.close();       
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
}
