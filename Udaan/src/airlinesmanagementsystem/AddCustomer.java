package airlinesmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField tfname, tfnationality, tfaadhar, tfphone, tfemail, tfaddress;
    JRadioButton rbmale, rbfemale;
    
    public AddCustomer(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(220, 20, 500, 35  );
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.blue);
        add(heading);
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(60, 80, 150, 25  );
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblName);
        
        tfname = new JTextField();
        tfname.setBounds(220, 80, 150, 25  );
        add(tfname);
        
        
        JLabel lblNationality = new JLabel("Nationality");
        lblNationality.setBounds(60, 130, 150, 25  );
        lblNationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(220, 130, 150, 25  );
        add(tfnationality);
        
        
        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(60, 180, 150, 25  );
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 180, 150, 25  );
        add(tfaadhar);
        
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(60, 230, 150, 25  );
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAddress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 230, 150, 25  );
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25  );
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        ButtonGroup genderGroup = new ButtonGroup();
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220, 280, 70, 25);
        rbmale.setBackground(Color.white);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300, 280, 70, 25);
        rbfemale.setBackground(Color.white);
        add(rbfemale);
        
        genderGroup.add(rbmale);
        genderGroup.add(rbfemale);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(60, 330, 150, 25  );
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25  );
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(60, 380, 150, 25  );
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(220, 380, 150, 25  );
        add(tfemail);
        
        JButton save = new JButton("SAVE");
        save.setBackground(Color.black);
        save.setForeground(Color.white);
        save.addActionListener(this);
        save.setBounds(220, 430, 150, 25);
        add(save);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinesmanagementsystem/icons/emp.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(450, 80, 280, 400);
        add(lblimage);
        
        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String aadhar = tfaadhar.getText();
        String address = tfaddress.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String gender = null;
        if ( rbmale.isSelected()){
            gender = "Male"; 
        }
        else{
            gender = "Female";
        }
        
        try{
            
            Conn conn = new Conn();
            
            String query = "insert into passenger values('"+ name + "', '"+ nationality + "', '"+ aadhar + "', '"+ address + "', '"+ phone + "', '"+ email + "', '"+ gender + "') ";
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
            
            setVisible(false);
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new AddCustomer();
    }
    
}
