package ams;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewBookedFlight extends JFrame {

    JTable t;
    String[] x = {"Ticket ID", "Source", "Destination", "Class", "Price", "Flight Code", "Flight Name", "Journey Date", "Journey Time", "Username", "Name", "Status"};
    String[][] y = new String[20][12];
    int i = 0, j = 0;
    Font f;

    ViewBookedFlight() {
        super("Flight Journey Details");
        setSize(1300, 400);
        setLocation(10, 10);
        f = new Font("MS UI Gothic", Font.BOLD, 17);

        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "SELECT * FROM bookedflight";
            ResultSet res = obj.stm.executeQuery(q);
            while (res.next()) {
                // Retrieve data from ResultSet and place it in the correct order
                y[i][j++] = res.getString("tid");            // Ticket ID
                y[i][j++] = res.getString("source");         // Source
                y[i][j++] = res.getString("destination");    // Destination
                y[i][j++] = res.getString("class_name");     // Class
                y[i][j++] = res.getString("price");          // Price
                y[i][j++] = res.getString("f_code");         // Flight Code
                y[i][j++] = res.getString("f_name");         // Flight Name
                y[i][j++] = res.getString("journey_date");   // Journey Date
                y[i][j++] = res.getString("journey_time");   // Journey Time
                y[i][j++] = res.getString("username");       // Username
                y[i][j++] = res.getString("name");           // Name
                y[i][j++] = res.getString("status");         // Status
                i++;
                j = 0;
            }
            t = new JTable(y, x);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        t.setFont(f);
        t.setBackground(Color.BLACK);
        t.setForeground(Color.WHITE);
        JScrollPane js = new JScrollPane(t);

        add(js);
    }

    public static void main(String[] args) {
        new ViewBookedFlight().setVisible(true);
    }
}
