
package ams;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class FlightZone extends JFrame
{
    
    private JTable table;
    private JTextField t;
    Choice ch1;
    
    public static void main(String[] args)
    {
        new FlightZone().setVisible(true);
        
    }
    FlightZone()
    {
        getContentPane().setBackground(new java.awt.Color(77,157,227));
        getContentPane().setFont(new Font("Arial",Font.BOLD,18));
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(860,523);
        setLayout(null);
        setVisible(true);
        
        JLabel flightcode = new JLabel("Flight Code");
        flightcode.setFont(new Font("Arial",Font.BOLD,18));
        flightcode.setBounds(100,100,150,30);
        flightcode.setForeground(new Color(15,11,1));
        add(flightcode);
        
        JLabel flightdetails = new JLabel("Air India Flight Information");
        flightdetails.setFont(new Font("Arial",Font.BOLD,33));
        flightdetails.setBounds(250,20,570,35);
        flightdetails.setForeground(new Color(15,11,1));
        add(flightdetails);
        
        JButton bt = new JButton ("Show Details");
        bt.setFont(new Font("Arial",Font.BOLD,20));
        bt.setBounds(560,100,220,30);
        bt.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent er)
            {
                try
                {
                    String code = ch1.getSelectedItem();
                    ConnectionClass c = new ConnectionClass();
                    String str = "SELECT * FROM flight WHERE f_code = '"+code+"'";
                    ResultSet rs = c.stm.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }

          
        });
        add(bt);
        
        table = new JTable();
        table.setBounds(23,250,800,300);
        table.setFont(new Font("Arial",Font.BOLD,14));
        add(table);
        
        ch1 = new Choice();
        ch1.setBounds(290,103,200,35);
        ch1.setFont(new Font("Arial",Font.BOLD,18));
        
        try
        {
            ConnectionClass con = new ConnectionClass();
            String str = "SELECT DISTINCT f_code FROM flight";
            ResultSet rs = con.stm.executeQuery(str);
            while(rs.next())
            {
                ch1.add(rs.getString("f_code"));
            }
        }
        catch(Exception ea)
        {
            ea.printStackTrace();
        }
                
                
        add(ch1);
        
        JLabel flightc = new JLabel("Flight Code");
        flightc.setFont(new Font("Arial",Font.BOLD,14));
        flightc.setBounds(33,220,126,16);
        flightc.setForeground(new Color(15,11,1));
        add(flightc);
        
        JLabel flightName = new JLabel("Flight Name");
        flightName.setFont(new Font("Arial",Font.BOLD,14));
        flightName.setBounds(155,220,112,16);
        flightName.setForeground(new Color(15,11,1));
        add(flightName);
        
        JLabel source = new JLabel("source");
        source.setFont(new Font("Arial",Font.BOLD,14));
        source.setBounds(275,220,120,16);
        source.setForeground(new Color(15,11,1));
        add(source);
        
        JLabel destination = new JLabel("Destination");
        destination.setFont(new Font("Arial",Font.BOLD,14));
        destination.setBounds(380,220,120,16);
        destination.setForeground(new Color(15,11,1));
        add(destination);
        
        JLabel capacity = new JLabel("Capacity");
        capacity.setFont(new Font("Arial",Font.BOLD,14));
        capacity.setBounds(497,220,111,16);
        capacity.setForeground(new Color(15,11,1));
        add(capacity);
        
        JLabel className = new JLabel("Class Name");
        className.setFont(new Font("Arial",Font.BOLD,14));
        className.setBounds(610,220,120,16);
        className.setForeground(new Color(15,11,1));
        add(className);
        
        JLabel price = new JLabel("price");
        price.setFont(new Font("Arial",Font.BOLD,14));
        price.setBounds(720,220,111,16);
        price.setForeground(new Color(15,11,1));
        add(price);
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(900,650);
        setVisible(true);
        setLocation(100,50);
        
        
        
    }
}
