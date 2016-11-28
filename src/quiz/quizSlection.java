/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.table.TableColumn;

public class quizSlection extends Quiz implements ActionListener {
     Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    static ArrayList <String> quizNumArray = new ArrayList<> ();
    static ArrayList <String> topicArray = new ArrayList<> ();
    
    static int counter;
    static int row;
    static int size;
    static String [][] data;
    static JFrame manageFrame;
    public quizSlection (){
        ArrayInput();
    }
 public void ArrayInput (){
        try {
            /*
            * The Array List is cleared
            * Counter is given one
            */
            int found = 0;
                                quizNumArray.clear();
                                topicArray.clear();

                                counter = 1;
                                /*
                                * Connection is established from BookDetails
                                */
                        connection = DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT QuizNum,Topic FROM QuizList");
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
                               String QuizNum = resultSet.getString("QuizNum");
                                //String quizNum = resultSet.getString("CHANGE THIS");
                                String topic = resultSet.getString("Topic");
                                
                              
                                
                                quizNumArray.add (QuizNum);
                                topicArray.add (topic);
                                
                                //AvailableArray.add ("No");
                             
                                
                               // String count = String.valueOf(counter);
                                //Numbers.add(count);
                                
                                
                                
                               
    }
                        resultSet.close();
			statement.close();
			connection.close();
                        data = new String [quizNumArray.size()][2];
                        GUI();
    
} catch (Exception e){
    System.out.println (e);
}
    }
    
    public void GUI (){
       
       /*
        * Each arrayList is added to the two dimensional array data
        */ 
        for (int i = 0; i < quizNumArray.size(); i++){
            String num = quizNumArray.get(i);
            data [i][0] = num;
        }
        for (int i =0; i < quizNumArray.size(); i++){
            String topic = topicArray.get(i);
            data [i][1] = topic;
        }
        size = 200 + (quizNumArray.size()*2);
        String [] columnNames = {"Quiz Number","Topic"};
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
        manageFrame.setTitle ("View Quizzes");
        manageFrame.setSize (1000,size);
        manageFrame.setVisible(true);
        manageFrame.setLocationRelativeTo(null);
        Container contentPane = manageFrame.getContentPane();
         /*
        * Two Panels are defined main and bottom
        */       
        JPanel myPanel = new JPanel ();
        JPanel bottom = new JPanel ();
        
        bottom.setLayout(new GridBagLayout());
         GridBagConstraints gbc1 = new GridBagConstraints();
         gbc1.gridx = 0;
         gbc1.gridy = 0;
         gbc1.insets = new Insets(5,5,5,5);
        /*
        * Modify button is added to the bottom panel
        */
         /*
       JButton button = new JButton ("Open Quiz");
       button.addActionListener (this);
       bottom.add(button, gbc1);
       */
       gbc1.gridx++;

       JButton back = new JButton ("Back To Main");
       back.addActionListener (this);
       bottom.add(back, gbc1);
       
       gbc1.gridx++;

       JButton take = new JButton ("Take Quiz");
       take.addActionListener (this);
       bottom.add(take, gbc1);
       /*
       * The bottom is added to myPanel
       */
      gbc1.gridx++;

       JButton delete = new JButton ("Delete Quiz");
       delete.addActionListener (this);
       bottom.add(delete, gbc1);
       myPanel.add(bottom,gbc1);
       
       gbc1.gridx++;

       JButton modify = new JButton ("Modify Quiz");
       modify.addActionListener (this);
       bottom.add(modify, gbc1);
      
        /*
       * A table is created
       */
        JTable table = new JTable(data, columnNames);
       	table.addMouseListener (new MouseAdapter ()
		{
		    public void mouseClicked (MouseEvent e)
		    {
				row = table.getSelectedRow ();
                         
		   }
		}
		);
        /*
        * The columns are given specific widths
        * These widths are given to each column
        * A scroll Pane is addde
        */
        int col [] = {8,150};
        int x = table.getColumnCount()-1;
        TableColumn col0 = null;
        table.setPreferredScrollableViewportSize(new Dimension (500,size));
        for (int i =0; i < 1 ; i++){
        col0 = table.getColumnModel().getColumn(i);
        col0.setPreferredWidth (col [i]);
        
        }
        JScrollPane scroll = new JScrollPane (table);
       
        
       myPanel.add(scroll);
       contentPane.add(myPanel);
       manageFrame.validate();
}
     @Override
    public void actionPerformed (ActionEvent e){
        String event = e.getActionCommand();
        /*
        * If the modify button is pressed the modify object is made
        */
        /*
        if (event.equals ("Open Quiz")){
            try {
                new openQuiz ();
                manageFrame.dispose();
                
            } catch (Exception ex) {
                System.out.println("Error");
            }
        }
        */
        /*
        * If the back button is pressed the mainWindow object is made
        */
          if (event.equals ("Back To Main")){
            try {
                new MainWindowTeacher ();
                manageFrame.dispose();
                
            } catch (Exception ex) {
                System.out.println("Error");
            }
        } 
          if (event.equals ("Delete Quiz")){
            try {
                new deleteQuiz ();
                manageFrame.dispose();
                
            } catch (Exception ex) {
                System.out.println("Error");
            }
        }
           if (event.equals ("Modify Quiz")){
            try {
                new modifyCenter();
                manageFrame.dispose();
                
            } catch (Exception ex) {
                System.out.println("Error");
            }
        }
            if (event.equals ("Take Quiz")){
            try {
                new startMCQ();
                manageFrame.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING));
                
            } catch (Exception ex) {
                System.out.println("Error");
            }
        }
    }
 
}
