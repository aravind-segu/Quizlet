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
import java.util.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumn;

public class modifyCenter extends Quiz implements ActionListener {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    static ArrayList <String> questionnumber = new ArrayList<> ();
    static ArrayList <String> question = new ArrayList<> ();
    
    static int counter;
    static int rowLeft;
    static int rowCenter;
    static int rowRight;
    static int size;
    static String [][] dataLeft;
    static String [][] dataCenter;
    static String [][] dataRight;
    static JFrame manageFrame;
    public modifyCenter (){
        //ArrayInputMCQ();
       GUI();
    }
 public void ArrayInputMCQ (){
      try {
            /*
            * The Array List is cleared
            * Counter is given one
            */
          int rowLocal = quizSlection.row;
          String topicSelected = quizSlection.data[rowLocal][1];
            int found = 0;
                                questionnumber.clear();
                                question.clear();

                                counter = 1;
                                /*
                                * Connection is established from BookDetails
                                */
                                
                                   
                        connection = DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT Topic,Question,OptionA,OptionB,OptionC,OptionD,Correct,QuestionNum FROM MCQ");
			/*
                        * Each row is iterated
                        * The data in each column is stored in local variables
                        * the copies and copies remaining are turned to integers
                        * If the copies checked out is equal to copies 
                            * the local variables are added to arrayLists  
                        else
                            * The local variables are added to arrayLists with available as no
                        */
                                
                        while (resultSet.next()) {
                              
                                //String quizNum = resultSet.getString("CHANGE THIS");
                                String topic = resultSet.getString("Topic");
                                String qu = resultSet.getString ("Question");
                                String QuizNum = resultSet.getString("QuestionNum");
                                
                              if (topicSelected.equalsIgnoreCase(topic)){
                                
                                questionnumber.add (QuizNum);
                                question.add (qu);
                              }
                                //AvailableArray.add ("No");
                             
                                
                               // String count = String.valueOf(counter);
                                //Numbers.add(count);
                                
                                
                                
                               
    }
                        resultSet.close();
			statement.close();
			connection.close();
                       // dataLeft = new String [questionnumber.size()][2];
                       
    
} catch (Exception e){
    System.out.println (e);
}
 }
     public void ArrayInputTF (){
      try {
            /*
            * The Array List is cleared
            * Counter is given one
            */
          int rowLocal = quizSlection.row;
          String topicSelected = quizSlection.data[rowLocal][1];
            int found = 0;
                                questionnumber.clear();
                                question.clear();

                                counter = 1;
                                /*
                                * Connection is established from BookDetails
                                */
                                
                                   
                        connection = DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT Topic,Question,Correct,QuestionNum FROM TF");
			/*
                        * Each row is iterated
                        * The data in each column is stored in local variables
                        * the copies and copies remaining are turned to integers
                        * If the copies checked out is equal to copies 
                            * the local variables are added to arrayLists  
                        else
                            * The local variables are added to arrayLists with available as no
                        */
                                
                        while (resultSet.next()) {
                              
                                //String quizNum = resultSet.getString("CHANGE THIS");
                                String topic = resultSet.getString("Topic");
                                String qu = resultSet.getString ("Question");
                                String QuizNum = resultSet.getString("QuestionNum");
                                
                              if (topicSelected.equalsIgnoreCase(topic)){
                                
                                questionnumber.add (QuizNum);
                                question.add (qu);
                              }
                                //AvailableArray.add ("No");
                             
                                
                               // String count = String.valueOf(counter);
                                //Numbers.add(count);
                                
                                
                                
                               
    }
                        resultSet.close();
			statement.close();
			connection.close();
                       // dataLeft = new String [questionnumber.size()][2];
                        
    
} catch (Exception e){
    System.out.println (e);
}
 }
          public void ArrayInputSA (){
      try {
            /*
            * The Array List is cleared
            * Counter is given one
            */
          int rowLocal = quizSlection.row;
          String topicSelected = quizSlection.data[rowLocal][1];
            int found = 0;
                                questionnumber.clear();
                                question.clear();

                                counter = 1;
                                /*
                                * Connection is established from BookDetails
                                */
                                
                                   
                        connection = DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT Topic,Question,Correct,QuestionNum FROM SA");
			/*
                        * Each row is iterated
                        * The data in each column is stored in local variables
                        * the copies and copies remaining are turned to integers
                        * If the copies checked out is equal to copies 
                            * the local variables are added to arrayLists  
                        else
                            * The local variables are added to arrayLists with available as no
                        */
                                
                        while (resultSet.next()) {
                              
                                //String quizNum = resultSet.getString("CHANGE THIS");
                                String topic = resultSet.getString("Topic");
                                String qu = resultSet.getString ("Question");
                                String QuizNum = resultSet.getString("QuestionNum");
                                
                              if (topicSelected.equalsIgnoreCase(topic)){
                                
                                questionnumber.add (QuizNum);
                                question.add (qu);
                              }
                                //AvailableArray.add ("No");
                             
                                
                               // String count = String.valueOf(counter);
                                //Numbers.add(count);
                                
                                
                                
                               
    }
                        resultSet.close();
			statement.close();
			connection.close();
                        
                       
    
} catch (Exception e){
    System.out.println (e);
}
 }
 
void GUI (){
        
               /*
        * Each arrayList is added to the two dimensional array data
        */ 
    ArrayInputMCQ();
   
  dataLeft = new String [questionnumber.size()][2];
        for (int i = 0; i < questionnumber.size(); i++){
            String num = questionnumber.get(i);
            dataLeft [i][0] = num;
        }
        for (int i =0; i < questionnumber.size(); i++){
            String topic = question.get(i);
            dataLeft [i][1] = topic;
        }
        for (int i =0 ; i < questionnumber.size(); i++){
            for (int j=0; j<2; j++){
                System.out.println(dataLeft[i][j]);
            }
        }
        size = 200 + (questionnumber.size()*2);
         //True.False Table Starts Here
           
           questionnumber.clear();
           question.clear();
        
       ArrayInputTF();
       /*
        * Each arrayList is added to the two dimensional array data
        */ 
       dataCenter = new String [questionnumber.size()][2];
        for (int i = 0; i < questionnumber.size(); i++){
            String num = questionnumber.get(i);
            dataCenter [i][0] = num;
        }
        for (int i =0; i < questionnumber.size(); i++){
            String topic = question.get(i);
            dataCenter [i][1] = topic;
        }
        size = 200 + (questionnumber.size()*2);
        String [] columnNames = {"Question Number","Question"};
        
         
           questionnumber.clear();
           question.clear();
        
       ArrayInputSA();
       /*
        * Each arrayList is added to the two dimensional array data
        */ 
       dataRight = new String [questionnumber.size()][2];
        for (int i = 0; i < questionnumber.size(); i++){
            String num = questionnumber.get(i);
            dataRight [i][0] = num;
        }
        for (int i =0; i < questionnumber.size(); i++){
            String topic = question.get(i);
            dataRight [i][1] = topic;
        }
        size = 200 + (questionnumber.size()*2);
        //String [] columnNames = {"Question Number","Question"};
         /*
        * The frame is initialized
        * The Close option is removed
        * Title is set
        * Size is set to 400x400
        * visibility defined to be true 
        * It is placed at the center of the screen
        */
        manageFrame = new JFrame ();
        manageFrame.setUndecorated(true);
        manageFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        manageFrame.setTitle ("View Questions");
        manageFrame.setSize (1000,3*size);
        manageFrame.setVisible(true);
        manageFrame.setLocationRelativeTo(null);
        Container contentPane = manageFrame.getContentPane();
         /*
        * Two Panels are defined main and bottom
        */       
        JPanel myPanel = new JPanel ();
        myPanel.setLayout(new BorderLayout());
        JPanel bottom = new JPanel ();
        JPanel tableZero = new JPanel ();
        JPanel tableOne = new JPanel();
        JPanel tableTwo = new JPanel ();
        
        bottom.setLayout(new GridBagLayout());
         GridBagConstraints gbc1 = new GridBagConstraints();
         gbc1.gridx = 0;
         gbc1.gridy = 0;
         gbc1.insets = new Insets(5,5,5,5);
        /*
        * Modify button is added to the bottom panel
        */
       JButton button = new JButton ("Modify MCQ");
       button.addActionListener (this);
       bottom.add(button, gbc1);
       
       gbc1.gridx++;

       JButton back = new JButton ("Delete MCQ");
       back.addActionListener (this);
       bottom.add(back, gbc1);
       
       gbc1.gridx++;

       JButton take = new JButton ("Modify True/False");
       take.addActionListener (this);
       bottom.add(take, gbc1);
       /*
       * The bottom is added to myPanel
       */
      gbc1.gridx++;

       JButton delete = new JButton ("Delete True/False");
       delete.addActionListener (this);
       bottom.add(delete, gbc1);
       
       gbc1.gridx++;
         JButton b1 = new JButton ("Modify Short Answer");
       b1.addActionListener (this);
       bottom.add(b1, gbc1);
       /*
       * The bottom is added to myPanel
       */
      gbc1.gridx++;

       JButton b2 = new JButton ("Delete Short Answer");
       b2.addActionListener (this);
       bottom.add(b2, gbc1);
       
       gbc1.gridx++;
       
       JButton b3 = new JButton ("Back");
       b3.addActionListener (this);
       bottom.add(b3, gbc1);
        /*
       * A table is created
       */
        JTable table0 = new JTable(dataLeft, columnNames);
       	table0.addMouseListener (new MouseAdapter ()
		{
		    public void mouseClicked (MouseEvent e)
		    {
				rowLeft = table0.getSelectedRow ();
                         
		   }
		}
		);
        
        JTable table1 = new JTable(dataCenter, columnNames);
       	table1.addMouseListener (new MouseAdapter ()
		{
		    public void mouseClicked (MouseEvent e)
		    {
				rowCenter = table1.getSelectedRow ();
                         
		   }
		}
		);
    
        JTable table2 = new JTable(dataRight, columnNames);
       	table2.addMouseListener (new MouseAdapter ()
		{
		    public void mouseClicked (MouseEvent e)
		    {
				rowRight= table2.getSelectedRow ();
                         
		   }
		}
		);
        /*
        * The columns are given specific widths
        * These widths are given to each column
        * A scroll Pane is addde
        */
        int colleft [] = {50,150};
        int x = table0.getColumnCount()-1;
        TableColumn col0 = null;
        table0.setPreferredScrollableViewportSize(new Dimension (200,size));
        for (int i =0; i < 1 ; i++){
        col0 = table0.getColumnModel().getColumn(i);
        col0.setPreferredWidth (colleft [i]);
        
        }
        int colleft1 [] = {50,150};
        int x1 = table1.getColumnCount()-1;
        TableColumn col1 = null;
        table1.setPreferredScrollableViewportSize(new Dimension (200,size));
        for (int i =0; i < 1 ; i++){
        col1 = table1.getColumnModel().getColumn(i);
        col1.setPreferredWidth (colleft [i]);
        
        }
        int colleft2 [] = {50,150};
        int x2 = table2.getColumnCount()-1;
        TableColumn col2 = null;
        table2.setPreferredScrollableViewportSize(new Dimension (200,size));
        for (int i =0; i < 1 ; i++){
        col2 = table2.getColumnModel().getColumn(i);
        col2.setPreferredWidth (colleft [i]);
        
        }
        JScrollPane scroll = new JScrollPane (table0);
        JScrollPane scroll1 = new JScrollPane (table1);
        JScrollPane scroll2 = new JScrollPane (table2);
       
        //MCQ Table Ends Here
        
       
        
        //Short Answer Question Ends Here
       tableZero.add(scroll);
       tableZero.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(), "Multiple Choice", TitledBorder.CENTER,
        TitledBorder.TOP));
       tableOne.add(scroll1);
       tableOne.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(), "True or False", TitledBorder.CENTER,
        TitledBorder.TOP));
       tableTwo.add(scroll2);
       tableTwo.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(), "Short Answer", TitledBorder.CENTER,
        TitledBorder.TOP));
       myPanel.add (tableZero, BorderLayout.WEST);
       myPanel.add (tableOne, BorderLayout.CENTER);
       myPanel.add (tableTwo, BorderLayout.EAST);
       myPanel.add(bottom,BorderLayout.NORTH);
       contentPane.add(myPanel);
       manageFrame.validate();
}
     @Override
    public void actionPerformed (ActionEvent e){
        String event = e.getActionCommand();
        /*
        * If the modify button is pressed the modify object is made
        */
        if (event.equals ("Modify MCQ")){
            try {
                new openQuiz ();
                manageFrame.dispose();
                
            } catch (Exception ex) {
                System.out.println("Error");
            }
        }
        if (event.equals ("Modify Short Answer")){
            try {
                new modifyShortAnswer ();
                manageFrame.dispose();
                
            } catch (Exception ex) {
                System.out.println("Error");
            }
        }
        if (event.equals ("Modify True/False")){
            try {
                new TrueFalseModify ();
                manageFrame.dispose();
                
            } catch (Exception ex) {
                System.out.println("Error");
            }
        }
        /*
        * If the back button is pressed the mainWindow object is made
        */
          if (event.equals ("Back To Main")){
            try {
               // new MainWindowTeacher ();
                manageFrame.dispose();
                
            } catch (Exception ex) {
                System.out.println("Error");
            }
        } 
          if (event.equals ("Delete Quiz")){
            try {
              //  new deleteQuiz ();
                manageFrame.dispose();
                
            } catch (Exception ex) {
                System.out.println("Error");
            }
        }
          if (event.equals ("Back")){
            try {
                new quizSlection ();
                manageFrame.dispose();
                manageFrame.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING));
                
                
                
            } catch (Exception ex) {
                System.out.println("Error");
            }
        }
    }
 
}



