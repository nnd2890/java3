/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingStudent;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.View;

/**
 *
 * @author nnd2890
 */
public class FormInsert extends JFrame {
    public static void main(String[] args) {
        FormInsert form = new FormInsert();
//        form.setVisible(false);
    }
    //  Panel 2
    private JPanel panel2;
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel phoneLabel;
    private JLabel emailLabel;
    private JLabel idValidField;
    private JTextField idField;
    private JLabel nameValidField;
    private JPasswordField nameField;
    private JLabel phoneValidField;
    private JPasswordField phoneField;
    private JLabel emailValidField;
    private JTextField emailField;
    private JButton submitButton;
    private JButton resetButton;
    public FormInsert() {
        
         // Panel 2
        this.panel2=new JPanel();  
        this.panel2.setBounds(40,40,400,330);    
        this.panel2.setBackground(Color.white);  
        this.panel2.setLayout(null);
        
        // Set the label
        this.idLabel = new JLabel("Email: ");
        this.idLabel.setBounds(30, 30, 100, 30);
        this.panel2.add(this.idLabel);
        
        this.nameLabel = new JLabel("Password: ");
        this.nameLabel.setBounds(30, 90, 100, 30);
        this.panel2.add(this.nameLabel);
        
        this.phoneLabel = new JLabel("Confirm Password: ");
        this.phoneLabel.setBounds(30, 150, 120, 30);
        this.panel2.add(this.phoneLabel);
        
        this.emailLabel = new JLabel("Phone number: ");
        this.emailLabel.setBounds(30, 210, 100, 30);
        this.panel2.add(this.emailLabel);
        
        // Set the place for input the information
        this.idValidField = new JLabel();
        this.idValidField.setBounds(150, 0, 200, 30);
        this.panel2.add(this.idValidField);
        this.idField = new JTextField();
        this.idField.setBounds(150, 30, 200, 30);
        this.panel2.add(this.idField);
        
        this.nameValidField = new JLabel();
        this.nameValidField.setBounds(150, 60, 200, 30);
        this.panel2.add(this.nameValidField);
        this.nameField = new JPasswordField();
        this.nameField.setBounds(150, 90, 200, 30);
        this.panel2.add(this.nameField);
        
        this.phoneValidField = new JLabel();
        this.phoneValidField.setBounds(150, 120, 200, 30);
        this.panel2.add(this.phoneValidField);
        this.phoneField = new JPasswordField();
        this.phoneField.setBounds(150, 150, 200, 30);
        this.panel2.add(this.phoneField);
        
        this.emailValidField = new JLabel();
        this.emailValidField.setBounds(150, 180, 200, 30);
        this.panel2.add(this.emailValidField);
        this.emailField = new JTextField();
        this.emailField.setBounds(150, 210, 200, 30);
        this.panel2.add(this.emailField);

        // Set the buttons.
        Contact contact = new Contact();
        this.submitButton = new JButton("Send");     
        this.submitButton.setBounds(150, 270, 80, 30); 
        this.submitButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Valid the id
                if (idField.getText().equals("")) {
                    idValidField.setText("* Enter your character! ");
                    idValidField.setForeground(Color.red);
                } else {
                    idValidField.setText("Valid");
                    idValidField.setForeground(Color.green);
                }
                // Valid the name
                if (nameField.getPassword().equals("")  ) {
                    nameValidField.setText("* Enter your character! ");
                    nameValidField.setForeground(Color.red);
                } else {
                    nameValidField.setText("Valid");
                    nameValidField.setForeground(Color.green);
                }
                // Valid the phone
//                if (passwordChange.equals("") || !passwordChange.equals(confirmPasswordChange)) {
//                    phoneValidField.setText("* Your character not confirm!");
//                    phoneValidField.setForeground(Color.red);
//                } else {
//                    phoneValidField.setText("Valid");
//                    phoneValidField.setForeground(Color.green);
//                }
                // Valid the email
                if (emailField.getText().equals("")) {
                    emailValidField.setText("* Enter your character! ");
                    emailValidField.setForeground(Color.red);
                } else {
                    emailValidField.setText("Valid");
                    emailValidField.setForeground(Color.green);
                }
                String email = idField.getText();
                char[] password = nameField.getPassword();
                String passwordChange = new String(password);
                char[] confirmPassword = phoneField.getPassword();
                String confirmPasswordChange = new String(confirmPassword);
                String phone = emailField.getText();
                contact.setEmail(email);
                contact.setPassword(passwordChange);
                contact.setConfirmPassword(confirmPasswordChange);
                contact.setPhone(phone);
                try {
                    Controller.insert(contact);
                    JOptionPane.showMessageDialog(null, "Successful!");
                } catch (SQLException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.panel2.add(submitButton);
        
          
        this.resetButton = new JButton("Reset");     
        this.resetButton.setBounds(250, 270, 80, 30); 
        this.resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                idValidField.setText("");
                idField.setText("");
                nameValidField.setText("");
                nameField.setText("");
                phoneValidField.setText("");
                phoneField.setText("");
                emailValidField.setText("");
                emailField.setText("");
            }
        });
        this.panel2.add(this.resetButton);
        
        // Set the Frame
        setTitle("Design Preview[Exam04]");
        add(this.panel2);
        setSize(500,440); 
        setLocationRelativeTo(null);
        setLayout(null);    
        setVisible(true);    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }
    
    
}
