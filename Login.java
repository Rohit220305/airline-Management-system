package ams;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// Ensure that necessary imports are included
import java.sql.Connection;
import java.sql.ResultSet;

public class Login implements ActionListener {
    JLabel title, usern, passlab;
    JButton loginbut, signupbut;
    JPasswordField pass;
    JTextField textfield;
    JFrame logframe;

    Login() {
        logframe = new JFrame("Login");
        logframe.getContentPane().setBackground(Color.WHITE);
        logframe.setLayout(null);

        JLabel l1 = new JLabel();
        l1.setBounds(0, 0, 580, 350);
        l1.setLayout(null);
        logframe.add(l1);

        // Ensure this path is correct
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("ams/icons/Design2.png"));
        Image i1 = img.getImage().getScaledInstance(580, 350, Image.SCALE_SMOOTH);
        ImageIcon img2 = new ImageIcon(i1);
        l1.setIcon(img2);

        title = new JLabel("Login Account");
        title.setBounds(190, 30, 500, 50);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        l1.add(title);

        usern = new JLabel("USERNAME");
        usern.setBounds(120, 120, 150, 30);
        usern.setForeground(Color.BLACK);
        usern.setFont(new Font("Arial", Font.BOLD, 20));
        l1.add(usern);

        textfield = new JTextField();
        textfield.setBounds(320, 120, 150, 30);
        l1.add(textfield);

        passlab = new JLabel("PASSWORD");
        passlab.setBounds(120, 170, 150, 30);
        passlab.setForeground(Color.BLACK);
        passlab.setFont(new Font("Arial", Font.BOLD, 20));
        l1.add(passlab);

        pass = new JPasswordField();
        pass.setBounds(320, 170, 150, 30);
        l1.add(pass);

        loginbut = new JButton("LOGIN");
        loginbut.setBounds(120, 220, 150, 40);
        loginbut.setForeground(Color.WHITE);
        loginbut.setBackground(Color.BLACK);
        loginbut.addActionListener(this);
        l1.add(loginbut);

        signupbut = new JButton("SIGNUP");
        signupbut.setBounds(320, 220, 150, 40);
        signupbut.setForeground(Color.WHITE);
        signupbut.setBackground(Color.BLACK);
        signupbut.addActionListener(this);
        l1.add(signupbut);

        logframe.setVisible(true);
        logframe.setSize(580, 350);
        logframe.setLocation(300, 100);
        logframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == loginbut) {
            String username = textfield.getText();
            String password = new String(pass.getPassword());
            try {
                ConnectionClass obj = new ConnectionClass(); // 
                String q = "SELECT * FROM signup WHERE username = '"+username+"' AND password = '"+password+"'";
                ResultSet rs = obj.stm.executeQuery(q);
                if (rs.next()) {
//                    new HomePage().setVisible(true); // Ensure HomePage class exists
                    logframe.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "You have entered wrong username and password!");
                    logframe.setVisible(true);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == signupbut) {
            this.logframe.setVisible(false);
//            new SignupMessage(); 
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
