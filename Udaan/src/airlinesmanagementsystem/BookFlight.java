package airlinesmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener{
    
    JTextField tfaadhar;
    JLabel tfname, tfnationality, tfaddress, labelgender, labelfname, labelfcode;
    JButton fetchUserButton, flight, bookFlight;
    Choice source, destination;
    JDateChooser dcdate;
    
    
    public BookFlight(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel heading = new JLabel("BOOK FLIGHT");
        heading.setBounds(420, 20, 500, 35  );
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.blue);
        add(heading);
        
        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(60, 80, 150, 25  );
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 80, 150, 25  );
        add(tfaadhar);
        
        fetchUserButton = new JButton("Fetch User");
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
        
        
        JLabel lblNationality = new JLabel("Nationality");
        lblNationality.setBounds(60, 180, 150, 25  );
        lblNationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25  );
        add(tfnationality);
        
        
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(60, 230, 150, 25  );
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAddress);
        
        tfaddress = new JLabel();
        tfaddress.setBounds(220, 230, 150, 25  );
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25  );
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        labelgender = new JLabel();
        labelgender.setBounds(220, 280, 150, 25  );
        add(labelgender);
        
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60, 330, 150, 25  );
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);
        
        source = new Choice();
        source.setBounds(220, 330, 150, 25);
        add(source);
        
        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(60, 380, 150, 25  );
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldest);
        
        destination = new Choice();
        destination.setBounds(220, 380, 150, 25);
        add(destination);
        
        try{
            Conn c = new Conn();
            String query = "select * from FlightInfo1";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                source.add(rs.getString("source1"));
                destination.add(rs.getString("destination1"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
     
        
        flight = new JButton("Fetch Flights");
        flight.setBackground(Color.black);
        flight.setForeground(Color.white);
        flight.addActionListener(this);
        flight.setBounds(380, 380, 150, 25);
        add(flight);
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 430, 150, 25  );
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 430, 150, 25  );
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60, 480, 150, 25  );
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(220, 480, 150, 25  );
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60, 530, 150, 25  );
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(220, 530, 150, 25  );
        add(dcdate);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinesmanagementsystem/icons/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550, 80, 500, 410);
        add(lblimage);
        
        bookFlight = new JButton("Book Flight");
        bookFlight.setBackground(Color.BLACK);
        bookFlight.setForeground(Color.WHITE);
        bookFlight.setBounds(220, 580, 150, 25);
        bookFlight.addActionListener(this);
        add(bookFlight);
        
        setSize(1100, 700);
        setLocation(150, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       
      if(ae.getSource() == fetchUserButton)  {
       
        String aadhar = tfaadhar.getText();
       
        try{
            
            Conn conn = new Conn();
            
            String query = "select * from passenger where aadhar = '"+ aadhar + "'";
            ResultSet rs = conn.s.executeQuery(query);
            
            if(rs.next()){
                
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                tfaddress.setText(rs.getString("address"));
                labelgender.setText(rs.getString("gender"));
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Please enter correct Aadhar Number");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
      else if(ae.getSource() == flight)
   {
          
       
        String src = source.getSelectedItem();
        String dest = destination.getSelectedItem();

       
        try{
            
            Conn conn = new Conn();
            
            String query = "select * from FlightInfo1 where source1 = '"+ src + "' and destination1 = '"+dest+"'";
            ResultSet rs = conn.s.executeQuery(query);
            
            if(rs.next()){
                
                labelfname.setText(rs.getString("f_name1"));
                labelfcode.setText(rs.getString("f_code1"));
                
                
            }
            else{
                JOptionPane.showMessageDialog(null, "No flights found");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    
      }
      else{
          Random random = new Random();
          String aadhar = tfaadhar.getText();
          String name = tfname.getText();
          String nationality = tfnationality.getText();
          String address = tfaddress.getText();
          String flightname = labelfname.getText();
          String flightcode =labelfcode.getText();
          String src = source.getSelectedItem();
          String des = destination.getSelectedItem();
          String ddate = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
          
        try{
            
            Conn conn = new Conn();
            
            String query = "insert into reservation values('PNR-"+ random.nextInt(1000000) + " ',' TIC- "+random.nextInt(10000)+"' , '"+aadhar+"', '"+name+"', '"+nationality+"', '"+flightname+"', '"+flightcode+"', '"+src+"', '"+des+"', '"+ddate+"')";
            conn.s.executeUpdate(query);
            
            
                JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");
                setVisible(false);
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
      }
    }
    public static void main(String[] args){
        new BookFlight();
    }
    
}