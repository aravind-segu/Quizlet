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

public class modifySA {
 String Q;
 String ans;
 String number;
 
 Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    
    modifySA (){
        Data();
    }
    void Data(){
        Q = modifyShortAnswer.qu;
        ans = modifyShortAnswer.answer;
        number = modifyShortAnswer.Quiznum;
        try{
            String num = "0";
         connection = DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
			statement = connection.createStatement (resultSet.TYPE_FORWARD_ONLY, resultSet.CONCUR_UPDATABLE);
			
                        resultSet = statement.executeQuery("SELECT Topic,Question,Correct,QuestionNum FROM SA");
               
			while (resultSet.next()) {
                             num = resultSet.getString("QuestionNum");
                               if (num.equals(number)){ 
                                  resultSet.updateString("Question",Q);
                                  resultSet.updateString("Correct", ans);
                                
                               break;
                               }
        
    }
                         
                                  
                                  
                                  
                                  new quizSlection();
                                  resultSet.updateRow();
                                          
     }catch (Exception e){
         
     }
}
}
