/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

 import javax.swing.*;
 import java.awt.*;
 import java.sql.*;
 import java.awt.event.*;

public class modifyMC extends Quiz {
    String Q;
    String A;
    String B;
    String C;
    String D;
    String Cor;
    String number;
    
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    
    modifyMC (){
        Data();
    }
    void Data(){
        Q = openQuiz.qu;
        A = openQuiz.OAS;
        B = openQuiz.OBS;
        C = openQuiz.OCS;
        D = openQuiz.ODS;
        Cor = openQuiz.correct;
        number = openQuiz.Quiznum;
        try{
            String num = "0";
         connection = DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
			statement = connection.createStatement (resultSet.TYPE_FORWARD_ONLY, resultSet.CONCUR_UPDATABLE);
			
                        resultSet = statement.executeQuery("SELECT Topic,Question,OptionA,OptionB,OptionC,OptionD,Correct,QuestionNum FROM MCQ");
               
			while (resultSet.next()) {
                             num = resultSet.getString("QuestionNum");
                               if (num.equals(number)){ 
                                  resultSet.updateString("Question",Q);
                                  resultSet.updateString("OptionA", A);
                                  resultSet.updateString("OptionB", B);
                                  resultSet.updateString("OptionC", C);
                                  resultSet.updateString("OptionD", D);
                                  resultSet.updateString("Correct", Cor);
                               break;
                               }
        
    }
                         
                                  
                                  
                                  
                                  new quizSlection();
                                  resultSet.updateRow();
                                          
     }
    
catch (Exception e){
    
}
    }
}
