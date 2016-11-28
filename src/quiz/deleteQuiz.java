package quiz;

import javax.swing.*;
 import java.awt.*;
 import java.sql.*;
 import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;

public class deleteQuiz extends Quiz implements ActionListener {
    
    JFrame manageaFrame;
    int rowLocal;
    String quizNum ;
    String topic ;
    
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    boolean checked = false;
    
    public deleteQuiz(){
        /*
        * the deletebook method is called
        */
        deleteQuiz();
    }
    public void deleteQuiz (){
        /*
        * The row selected by user is inputted
        * All the details in that row are inputted and stored in local variables
        */
        rowLocal = quizSlection.row;
        
        quizNum = quizSlection.data[rowLocal][0] ;
        topic = quizSlection.data[rowLocal][1];
       //QuizList
        try {
                            
                        connection = DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
			statement = connection.createStatement (resultSet.TYPE_FORWARD_ONLY, resultSet.CONCUR_UPDATABLE);
			
                        resultSet = statement.executeQuery("SELECT QuizNum, Topic, TimesTaken, Average FROM QuizList");
               
			while (resultSet.next()) 
                        {
                                //String quizNum = resultSet.getString("ID");
                                String topicLocal = resultSet.getString ("Topic");
                               
                                
                                if (topic.equals(topicLocal))
                                {
                                                                           
                                       resultSet.deleteRow();
                                       break;                                     
                                }
                                
                        }
                                resultSet.close();
                                statement.close();
                                connection.close();   
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        //MCQ
        
        try {
                            
                        connection = DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
			statement = connection.createStatement (resultSet.TYPE_FORWARD_ONLY, resultSet.CONCUR_UPDATABLE);
			
                        resultSet = statement.executeQuery("SELECT ID, Topic, Question, OptionA, OptionB, OptionC, OptionD, Correct FROM MCQ");
               
			while (resultSet.next()) 
                        {
                                //String quizNum = resultSet.getString("ID");
                                String topicLocal = resultSet.getString ("Topic");
                               
                                
                                if (topic.equals(topicLocal))
                                {
                                                                           
                                       resultSet.deleteRow();
                                       break;                                     
                                }
                                
                        }
                                resultSet.close();
                                statement.close();
                                connection.close();   
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        //Short Answer
        try {
                            
                        connection = DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
			statement = connection.createStatement (resultSet.TYPE_FORWARD_ONLY, resultSet.CONCUR_UPDATABLE);
			
                        resultSet = statement.executeQuery("SELECT ID, Topic, Question, Correct FROM SA");
               
			while (resultSet.next()) 
                        {
                                //String quizNum = resultSet.getString("ID");
                                String topicLocal = resultSet.getString ("Topic");
                               
                                
                                if (topic.equals(topicLocal))
                                {
                                                                           
                                       resultSet.deleteRow();
                                       break;                                     
                                }
                                
                        }
                                resultSet.close();
                                statement.close();
                                connection.close();   
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        //True or False
        try {
                            
                        connection = DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
			statement = connection.createStatement (resultSet.TYPE_FORWARD_ONLY, resultSet.CONCUR_UPDATABLE);
			
                        resultSet = statement.executeQuery("SELECT ID, Topic, Question, Correct FROM TF");
               
			while (resultSet.next()) 
                        {
                                //String quizNum = resultSet.getString("ID");
                                String topicLocal = resultSet.getString ("Topic");
                               
                                
                                if (topic.equals(topicLocal))
                                {
                                                                           
                                       resultSet.deleteRow();
                                       break;                                     
                                }
                                
                        }
                                resultSet.close();
                                statement.close();
                                connection.close();   
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
                                
                            /*
                                * That bookiD is searched in memCheckouts tables
                                * And that specific row is deleted
                                * Connections are closed
                                * Manage Books is called
                      */
                                manageaFrame = new JFrame ();
        manageaFrame.setUndecorated(true);
        manageaFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        manageaFrame.setTitle ("Delete Quiz");
        manageaFrame.setSize (150,100);
        manageaFrame.setVisible(true);
        manageaFrame.setLocationRelativeTo(null);
        Container contentPane = manageaFrame.getContentPane();
        JPanel myPanel = new JPanel();
        JLabel mes = new JLabel ("Successfully Deleted");
        JButton back = new JButton("Back");
       back.addActionListener(new ActionListener() {
     
     
     public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        
        if (event.equals ("Back")){
            try {
                new quizSlection ();
                manageaFrame.dispose();
                
            } catch (Exception ex) {
                System.out.println("Error");
            }
                
        }
                }
       });
       myPanel.add(mes);
       myPanel.add(back);
       contentPane.add(myPanel);
       manageaFrame.validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
         
}

