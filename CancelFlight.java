package ams;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class CancelFlight extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14;
    JButton bt1, bt2;
    JPanel p1, p2, p3;
    Font f1, f2;
    Choice ch1;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11;

    CancelFlight() {
        super("Cancel Airline India Flight");
        setLocation(50, 10);
        setSize(1100, 650);

        f1 = new Font("Arial", Font.BOLD, 25);
        f2 = new Font("Arial", Font.BOLD, 18);

        ch1 = new Choice();

        try {
            ConnectionClass con = new ConnectionClass();

            // Correcting the SQL query
            String query = "SELECT DISTINCT tid FROM bookedflight WHERE status='success'";

            ResultSet res = con.stm.executeQuery(query);
            while (res.next()) {
                ch1.add(res.getString("tid"));
            }
            res.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        l1 = new JLabel("Cancel Your Flight Ticket");
        l2 = new JLabel("Ticket id");
        l3 = new JLabel("Source");
        l4 = new JLabel("Destination");
        l5 = new JLabel("Class");
        l6 = new JLabel("Price");
        l7 = new JLabel("Flight Code");
        l8 = new JLabel("Flight Name");
        l9 = new JLabel("Journey Date");
        l10 = new JLabel("Journey Time");
        l11 = new JLabel("Username");
        l12 = new JLabel("Name");
        l13 = new JLabel("Reason");

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        tf8 = new JTextField();
        tf9 = new JTextField();
        tf10 = new JTextField();
        tf11 = new JTextField();

        tf1.setEditable(false);
        tf2.setEditable(false);
        tf3.setEditable(false);
        tf4.setEditable(false);
        tf5.setEditable(false);
        tf6.setEditable(false);
        tf7.setEditable(false);
        tf8.setEditable(false);
        tf9.setEditable(false);
        tf10.setEditable(false);

        bt1 = new JButton("Cancel Flight");
        bt2 = new JButton("Back");

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(new java.awt.Color(176, 4, 21));

        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        l6.setFont(f2);
        l7.setFont(f2);
        l8.setFont(f2);
        l9.setFont(f2);
        l10.setFont(f2);
        l11.setFont(f2);
        l12.setFont(f2);

        tf1.setFont(f2);
        tf2.setFont(f2);
        tf3.setFont(f2);
        tf4.setFont(f2);
        tf5.setFont(f2);
        tf6.setFont(f2);
        tf7.setFont(f2);
        tf8.setFont(f2);
        tf9.setFont(f2);
        tf10.setFont(f2);
        tf11.setFont(f2);

        bt1.setFont(f2);
        bt2.setFont(f2);

        l2.setForeground(new java.awt.Color(20, 2, 117));
        l3.setForeground(new java.awt.Color(20, 2, 117));
        l4.setForeground(new java.awt.Color(20, 2, 117));
        l5.setForeground(new java.awt.Color(20, 2, 117));
        l6.setForeground(new java.awt.Color(20, 2, 117));
        l7.setForeground(new java.awt.Color(20, 2, 117));
        l8.setForeground(new java.awt.Color(20, 2, 117));
        l9.setForeground(new java.awt.Color(20, 2, 117));
        l10.setForeground(new java.awt.Color(20, 2, 117));
        l11.setForeground(new java.awt.Color(20, 2, 117));
        l12.setForeground(new java.awt.Color(20, 2, 117));
        l13.setForeground(new java.awt.Color(20, 2, 117));

        bt1.setBackground(new java.awt.Color(176, 4, 21));
        bt1.setForeground(Color.WHITE);

        bt2.setForeground(new java.awt.Color(230, 225, 225));
        bt2.setBackground(Color.BLACK);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(13, 2, 10, 10));

        p2.add(l2);
        p2.add(ch1);
        p2.add(l3);
        p2.add(tf1);
        p2.add(l4);
        p2.add(tf2);
        p2.add(l5);
        p2.add(tf3);
        p2.add(l6);
        p2.add(tf4);
        p2.add(l7);
        p2.add(tf5);
        p2.add(l8);
        p2.add(tf6);
        p2.add(l9);
        p2.add(tf7);
        p2.add(l10);
        p2.add(tf8);
        p2.add(l11);
        p2.add(tf9);
        p2.add(l12);
        p2.add(tf10);
        p2.add(l13);
        p2.add(tf11);
        p2.add(bt1);
        p2.add(bt2);

        p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 1, 10, 10));

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("ams/icons/Design2.png"));
        Image img1 = img.getImage().getScaledInstance(620, 580, Image.SCALE_SMOOTH);

        ImageIcon ic1 = new ImageIcon(img1);
        l14 = new JLabel(ic1);
        p3.add(l14);

        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p2, "Center");
        add(p3, "West");

        ch1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {

                try {
                    ConnectionClass obj = new ConnectionClass();
                    String tid = ch1.getSelectedItem();
                    String q1 = "select * from bookedflight where tid='" + tid + "'";
                    ResultSet rest1 = obj.stm.executeQuery(q1);
                    while (rest1.next()) {
                        tf1.setText(rest1.getString("source"));
                        tf2.setText(rest1.getString("destination"));
                        tf3.setText(rest1.getString("Class_name"));
                        tf4.setText(rest1.getString("price"));
                        tf5.setText(rest1.getString("f_code"));
                        tf6.setText(rest1.getString("f_name"));
                        tf7.setText(rest1.getString("journey_date"));
                        tf8.setText(rest1.getString("journey_time"));
                        tf9.setText(rest1.getString("username"));
                        tf10.setText(rest1.getString("name"));
                    }
                } catch (Exception exx) {
                    exx.printStackTrace();
                }

            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bt1) {
            String tid = ch1.getSelectedItem();
            String source = tf1.getText();
            String destination = tf2.getText();
            String classname = tf3.getText();
            String price = tf4.getText();
            String fcode = tf5.getText();
            String fname = tf6.getText();
            String jdate = tf7.getText();
            String jtime = tf8.getText();
            String username = tf9.getText();
            String name = tf10.getText();
            String reason = tf11.getText();
            String status = "Cancel";

            try {
                ConnectionClass obj3 = new ConnectionClass();
                String q1 = "INSERT INTO cancelFlight (tid, source, destination, class_name, price, f_code, f_name,journey_date, journey_time, username, name, reason ) VALUES ('" + tid + "','" + source + "','" + destination + "','" + classname + "','" + price + "','" + fcode + "','" + fname + "','" + jdate + "','" + jtime + "','" + username + "','" + name + "','" + reason + "')";
                String q2 = "update bookedflight set status='" + status + "' where tid='" + tid + "'";
                int aa = obj3.stm.executeUpdate(q1);
                if (aa == 1) {
                    JOptionPane.showMessageDialog(null, "Your flight successfully canceled");
                    obj3.stm.executeUpdate(q2);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Please! Fill all details carefully");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        if (e.getSource() == bt2) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new CancelFlight().setVisible(true);
    }

}
