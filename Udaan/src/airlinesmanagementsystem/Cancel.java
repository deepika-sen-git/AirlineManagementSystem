package airlinesmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Cancel extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel tfname, cancellationno, lblfcode, dateOfTravel;
    JButton fetchUserButton, flight;
    
    
    public Cancel(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        Random random = new Random();
        
        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(180, 20, 250, 35  );
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinesmanagementsystem/icons/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(470, 125, 250, 250);
        add(image);
        
        JLabel lblaadhar = new JLabel("PNR Number");
        lblaadhar.setBounds(60, 80, 150, 25  );
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25  );
        add(tfpnr);
        
        fetchUserButton = new JButton("Show Details");
        fetchUserButton.setBackground(Color.BLACK);
        fetchUserButton.setForeground(Color.WHITE);
        fetchUserButton.setBounds(380, 80, 150, 25);
        fetchUserButton.addActionListener(this);
        add(fetchUserButton);
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(60, 130, 150, 25  );
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblName);
        
        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25  );
        add(tfname);
        
        
        JLabel lblNationality = new JLabel("Cancellation Number");
        lblNationality.setBounds(60, 180, 150, 25  );
        lblNationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNationality);
        
        cancellationno = new JLabel("" + random.nextInt(1000000));
        cancellationno.setBounds(220, 180, 150, 25  );
        add(cancellationno);
        
        
        JLabel lblAddress = new JLabel("Flight Code");
        lblAddress.setBounds(60, 230, 150, 25  );
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAddress);
        
        lblfcode = new JLabel();
        lblfcode.setBounds(220, 230, 150, 25  );
        add(lblfcode);
        
        JLabel lblgender = new JLabel("Date of Travel");
        lblgender.setBounds(60, 280, 150, 25  );
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        dateOfTravel = new JLabel();
        dateOfTravel.setBounds(220, 280, 150, 25  );
        add(dateOfTravel);
        
        
        flight = new JButton("Cancel Ticket");
        flight.setBackground(Color.black);
        flight.setForeground(Color.white);
        flight.addActionListener(this);
        flight.setBounds(220, 330, 120, 25);
        add(flight);
        
       
        setSize(800, 450);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       
      if(ae.getSource() == fetchUserButton)  {
       
        String pnr = tfpnr.getText();
       
        try{
            
            Conn conn = new Conn();
            
            String query = "select * from reservation where PNR = '"+ pnr + "'";
            ResultSet rs = conn.s.executeQuery(query);
            
            if(rs.next()){
                
                tfname.setText(rs.getString("name"));
                lblfcode.setText(rs.getString("flightcode"));
                dateOfTravel.setText(rs.getString("ddate"));
//                labelgender.setText(rs.getString("gender"));
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Please enter correct PNR Number");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
      else if(ae.getSource() == flight)
   {
          
       
       String name = tfname.getText();
       String pnr = tfpnr.getText();
       String cancelno = cancellationno.getText();
       String fcode = lblfcode.getText();
       String date = dateOfTravel.getText();



       
        try{
            
            Conn conn = new Conn();
            
            String query = "insert into cancel values('"+pnr+"', '"+name+"', '"+cancelno+"', '"+fcode+"', '"+date+"')";
            conn.s.executeUpdate(query);
            conn.s.executeUpdate("delete from reservation where PNR = '"+pnr+"'");

            
            
            JOptionPane.showMessageDialog(null, "Ticket Cancelled");
            setVisible(false);
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    
      }
      
    }
    public static void main(String[] args){
        new Cancel();
    }
    
}
