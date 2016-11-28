
package quiz;

import javax.swing.*;
 import java.awt.*;
 import java.sql.*;
 import java.awt.event.*;

public class modifyTF extends Quiz{
    String Q;
    String Cor;
    String number;
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    
    modifyTF(){
        Data();
    }
      void Data(){
        Q = TrueFalseModify.qu;
        Cor = TrueFalseModify.answer;
        number = TrueFalseModify.Quiznum;
        try{
            String num = "0";
         connection = DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
			statement = connection.createStatement (resultSet.TYPE_FORWARD_ONLY, resultSet.CONCUR_UPDATABLE);
			
                        resultSet = statement.executeQuery("SELECT Topic,Question,Correct,QuestionNum FROM TF");
               
			while (resultSet.next()) {
                             num = resultSet.getString("QuestionNum");
                               if (num.equals(number)){ 
                                  resultSet.updateString("Question",Q);
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


