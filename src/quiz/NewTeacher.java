/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

/**
 *
 * @author mallikarjuna
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import static quiz.Quiz.frame;

public class NewTeacher extends Quiz implements ActionListener {

static Container contentPane;
    JPanel myPanel;
    JTextField firstName;
    JTextField lastName;
    JTextField userName;
    JTextField password;
    JTextField admin;
    JFrame frameNewTeacher;
    
    NewTeacher (){
               //The newTeacherGui Method is called                        
        newTeacherGUI();
    }
    
    @Override
    public void actionPerformed (ActionEvent e){
        String event = e.getActionCommand();
        /*
        * If the button clicked is create Account the check method is called
        * If the button clicked is Back, a login object is created. 
        */
        if (event.equals ("Create Account")){
            try {
                check ();
            } catch (Exception ex) {
                //Logger.getLogger(GuiNewTeacher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (event.equals ("Back")){
            try {
                new login();
                frameNewTeacher.dispose();
            } catch (Exception ex) {
                System.out.println("Error");
            }
        }
    }
    
    public void  newTeacherGUI() {
        /*
        * The frame is initialized
        * The Close option is removed
        * Title is set
        * Size is set to 400x400
        * visibility defined to be true 
        * It is placed at the center of the screen
        */
       
        frameNewTeacher = new JFrame ();
        frameNewTeacher.setUndecorated(true);
        frameNewTeacher.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frameNewTeacher.setTitle ("New User");
        frameNewTeacher.setSize (400,400);
        frameNewTeacher.setVisible(true);
        frameNewTeacher.setLocationRelativeTo(null);
        
        contentPane = frameNewTeacher.getContentPane();
        /*
        The main Panel is initialized
        It is set to Border Layout
        Secondary pannels of top and info are created
        */        
        myPanel = new JPanel ();
        myPanel.setLayout(new BorderLayout());
        JPanel top = new JPanel ();
        JPanel info = new JPanel();
        
         
        
        /*
        * The top panel is given a GridBagLayout
        * At 0,0 the title is written "New User" with an Arial Font
        * The instruction is printed at 0,2 with an Arial Font of 12
        */
        top.setLayout(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.insets = new Insets(1,1,1,1);
        JLabel welcome = new JLabel ("New User");
        welcome.setFont(new Font ("Arial",Font.BOLD , 18));
        top.add (welcome, gbc1);
                
        gbc1.gridx = 0;
        gbc1.gridy = 2;
        JLabel inst = new JLabel ("Please Enter the information and press Enter");
        inst.setFont(new Font ("Arial",Font.BOLD , 12));
        top.add (inst, gbc1);
        /*
        * The info is given a GridBag Layout
        * At 0,0 the FirstName Label and at 0,1 the subsequent text box is placed.
        * At 1,0 the LastName Label and at 1,1 the subsequent text box is placed.
        * At 2,0 the UserName Label and at 2,1 the subsequent text box is placed.
        * At 3,0 the Password Label and at 3,1 the subsequent text box is placed.
        * At 4,1 the button, Create Account is placed
        * At 6,1 the Back Button is placed
        */
        info.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(1,1,1,1);
        
        JLabel first = new JLabel ("*First Name: ");
        info.add (first,gbc);
        gbc.gridx ++;
        firstName = new JTextField (20);
        info.add (firstName,gbc);
        
        gbc.gridy = 1;
        gbc.gridx = 0;
        JLabel last = new JLabel ("*Last Name: ");
       info.add (last,gbc);
        gbc.gridx ++;
        lastName = new JTextField (20);
       info.add (lastName,gbc);
        
        gbc.gridy = 2;
        gbc.gridx = 0;
        JLabel user = new JLabel ("*Username: ");
        info.add (user,gbc);
        gbc.gridx ++;
        userName = new JTextField (20);
        info.add (userName,gbc);
        
        gbc.gridy = 3;
        gbc.gridx = 0;
        JLabel pass = new JLabel ("*Password: ");
        info.add (pass,gbc);
        gbc.gridx ++;
        password = new JTextField (20);
        info.add (password,gbc);
        
        gbc.gridy = 4;
        gbc.gridx = 0;
        JLabel adminLabel = new JLabel ("*Admin Password: ");
        info.add (adminLabel,gbc);
        gbc.gridx ++;
        admin = new JTextField (20);
        info.add (admin,gbc);
        
        gbc.gridy = 5;
        gbc.gridx = 1;
        JButton create = new JButton ("Create Account");
        create.addActionListener(this);
        info.add (create, gbc);
        
        gbc.gridy = 7;
        gbc.gridx = 1;
        JButton backLogin = new JButton ("Back");
        backLogin.addActionListener(this);
       info.add (backLogin, gbc);
       
       firstName.setText("");
         lastName.setText("");;
         userName.setText("");;
        password.setText("");
        admin.setText("");
        
        myPanel.add (top , BorderLayout.NORTH);
       myPanel .add (info, BorderLayout.CENTER);
        contentPane.add (myPanel);
        frameNewTeacher.validate ();
             
    }
    public void check () {
        /*
        * The data in the textfield is retrieved and stored in 4 seperate strings:
            * First
            * Last
            * User
            * Pass
        */
        String first = firstName.getText();
        String last = lastName.getText();
        String user = userName.getText();
        String pass = password.getText();
        String admi = admin.getText();
       /*
        * If the first name is blank:
            * A Retry Message is printed
            * A constructor of this class, NuewUserGui is called
            * The current frame is disposed.
        */ 
        if (first.equals ("")){
            JOptionPane.showMessageDialog(null, "Sorry First Name is Left Blank");
            newTeacherGUI();
            frameNewTeacher.dispose();
        }
        /*
        * If the last name is blank:
            * A Retry Message is printed
            * A constructor of this class, NuewUserGui is called
            * The current frame is disposed.
        */ 
        else if (last.equals ("")){
            JOptionPane.showMessageDialog(null, "Sorry Last Name is Left Blank");
            new NewTeacher();
            frameNewTeacher.dispose();
        }
        /*
        * If the username is blank:
            * A Retry Message is printed
            * A constructor of this class, NuewUserGui is called
            * The current frame is disposed.
        */ 

        else if (user.equals ("")){
            JOptionPane.showMessageDialog(null, "Sorry User Name is Left Blank");
           new NewTeacher();
            frameNewTeacher.dispose();
        }
        /*
        * If the password is blank:
            * A Retry Message is printed
            * A constructor of this class, NuewUserGui is called
            * The current frame is disposed.
        */ 
        else if (pass.equals ("")){
            JOptionPane.showMessageDialog(null, "Sorry Password is Left Blank");
           new NewTeacher();
            frameNewTeacher.dispose();
        }
        
        
        else if (admi.equals ("admin")){
           // JOptionPane.showMessageDialog(null, "Sorry Password is Left Blank");
           // newTeacher();
            createAccount();
        }
        
        else {
            JOptionPane.showMessageDialog(null, "Sorry Wrong Admin Pasword");
            new NewTeacher();
            frameNewTeacher.dispose();
        }
        /*
        * If all textboexes are filled the createAccount method is called
        */
        //else {createAccount();}
            
    }
    public void createAccount () {
        /*
        * The data in the textfield is retrieved and stored in 4 seperate strings:
            * First
            * Last
            * User
            * Pass
        */
        String first = firstName.getText();
        String last = lastName.getText();
        String user = userName.getText();
        String pass = password.getText();
     //   String admi = admin.getText();
        
        // The sql is prepared to access the UserDetails table in the Access Database
        
       String sql = "INSERT INTO TeacherDetails" 
               + "( FirstName, LastName, Username, Password) VALUES" 
               + "(?,?,?,?)";
    
    try{
                                        /*
                                            * The connection is established
                                            * The sql string is passed into the Prepared Statement
                                            * The preparedStatement sets the string or add the info to the table under the specified index number
                                            * All connections are closed
                                        */
                                        Connection con=DriverManager.getConnection("jdbc:ucanaccess://quiz.mdb");
                                        PreparedStatement ps =con.prepareStatement(sql);
                                        ps.setString(1, first);
                                        ps.setString(2, last);
                                        ps.setString(3, user);
                                        ps.setString(4, pass);                                        
                                        ps.executeUpdate();      
                                        
                                        ps.close();
                                        con.close();
                                        
                                }catch(Exception ex){
                                    JOptionPane.showMessageDialog(null, ex.toString());
                                }
    
    /*
    * A success message is printed
    * The user is redirected to the login
    * Current Frame is disposed
    */       
    String message = "Registration Successful";
    JOptionPane.showMessageDialog(null, message);
    
    new login ();
    frameNewTeacher.dispose();
    
}    
}