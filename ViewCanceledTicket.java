package ams;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ViewCanceledTicket extends JFrame{
    JTable t;
    String x[] = {"Ticket id", "source", "Destination", "class", "Price", "Flight code", "Flight Name", "Journey date", "Journey time", "Username","Name", "Reason"};
    String y[][] = new String[20][12];
    int i = 0, j = 0;
    Font f;
    
    ViewCanceledTicket()
    {
        super("All Canceled Flight Details");
        setSize(1300,400);
        setLocation(0,10);
        f = new Font("Arial",Font.BOLD,16);
        
        try
        {
            ConnectionClass con = new ConnectionClass();
            String query = "select * from cancelFlight";
            ResultSet res  = con.stm.executeQuery(query);
            while(res.next()){
                y[i][j++] = res.getString("tid");  // table nanter banavane ani change krne query
                y[i][j++] = res.getString("source");
                y[i][j++] = res.getString("destination");
                y[i][j++] = res.getString("class_name");
                y[i][j++] = res.getString("price");
                y[i][j++] = res.getString("f_code");
                y[i][j++] = res.getString("f_name");
                y[i][j++] = res.getString("journey_date");
                y[i][j++] = res.getString("journey_time");
                y[i][j++] = res.getString("username");
                y[i][j++] = res.getString("name");
                y[i][j++] = res.getString("reason");
                
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
        JScrollPane js = new JScrollPane(t);
        add(js);
    }
    public static void main(String[] args)
    {
        new ViewCanceledTicket().setVisible(true);
        
    }
}
