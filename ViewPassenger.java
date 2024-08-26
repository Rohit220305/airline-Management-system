package ams;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ViewPassenger extends JFrame 
{

    JTable t;
    String x[] = {"Username", "Name", "Age", "Date of birth","Address","Phone","Email","Nationality","Gender","Passport Number"};
    String y[][] = new String [20][10];
    int i=0, j = 0;
    Font f;
    
    
    
    ViewPassenger()
    {
        super("All Passenger Details");
        setSize(1300,400);
        setLocation(0,10);
        f = new Font("Arial",Font.BOLD,16);
        
        try
        {
            ConnectionClass con = new ConnectionClass();
            String query = "select * from passenger";
            ResultSet res  = con.stm.executeQuery(query);
            while(res.next()){
                y[i][j++] = res.getString("username");  // table nanter banavane ani change krne query
                y[i][j++] = res.getString("name");
                y[i][j++] = res.getString("age");
                y[i][j++] = res.getString("dob");
                y[i][j++] = res.getString("address");
                y[i][j++] = res.getString("phone");
                y[i][j++] = res.getString("Email");
                y[i][j++] = res.getString("nationality");
                y[i][j++] = res.getString("gender");
                y[i][j++] = res.getString("passport");
                
                i++;
                j =0;
                
            }
            t = new JTable(y,x);
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        t.setFont(f);
        t.setBackground(Color.BLACK);
        t.setForeground(Color.WHITE);
        JScrollPane scrollbar = new JScrollPane(t);

        add(scrollbar);
    }
    public static void main(String[] args)
    {
        new ViewPassenger().setVisible(true);
        
    }
    
}