package ams;

import java.awt.*;
import javax.swing.*;
import java.sql.ResultSet;

public class FlightJourneyDetails extends JFrame {
    
    JTable t;
    String x[] = {"Ticket ID","Source","Destination","Class","Price","Flight Code","Flight Name","Journey Date","Journey Time","Username","Name"};
    String Y[][] = new String[20][11];
    int i = 0, j = 0;
    Font f;
    
    FlightJourneyDetails(String src, String dst) {
        super("Flight Journey Details");
        setSize(1300, 400);
        setLocation(0, 10);
        f = new Font("MS UI Gothic", Font.BOLD, 17);

        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "select * from bookedflight where source='" + src + "' and destination='" + dst + "'";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                Y[i][j++] = rest.getString("tid");
                Y[i][j++] = rest.getString("source");
                Y[i][j++] = rest.getString("destination");
                Y[i][j++] = rest.getString("class_name");
                Y[i][j++] = rest.getString("price");
                Y[i][j++] = rest.getString("f_code");  // Corrected column name
                Y[i][j++] = rest.getString("f_name");  // Corrected column name
                Y[i][j++] = rest.getString("journey_date");
                Y[i][j++] = rest.getString("journey_time");
                Y[i][j++] = rest.getString("username");
                Y[i][j++] = rest.getString("name");
                i++;
                j = 0;
            }
            t = new JTable(Y, x);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        t.setFont(f);
        t.setBackground(Color.BLACK);
        t.setForeground(Color.WHITE);

        JScrollPane js = new JScrollPane(t);
        add(js);
    }
}