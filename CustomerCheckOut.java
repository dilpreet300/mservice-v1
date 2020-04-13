package com.projects.mservice;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class CustomerCheckOut implements ActionListener{
	private JFrame f;
	private JLabel l1,l2,l3,l4,l5,l6,l7;
	private JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	private JButton b;
	private int id;
	private ResultSet rs;
	CustomerCheckOut(String newId){
		try{
			f=new JFrame();
			l1=new JLabel("ID");
			l2=new JLabel("Name");
			l3=new JLabel("Brand");
			l4=new JLabel("Model");
			l5=new JLabel("Charges");
			l6=new JLabel("Due");
			l7=new JLabel("Customer CheckOut");
			l7.setBounds(125,50,200,20);
			l1.setBounds(50,100,100,20);
			l2.setBounds(50,140,100,20);
			l3.setBounds(50,180,100,20);
			l4.setBounds(50,220,100,20);
			l5.setBounds(50,260,100,20);
			l6.setBounds(50,300,100,20);
			tf1=new JTextField();
			tf2=new JTextField();
			tf3=new JTextField();
			tf4=new JTextField();
			tf5=new JTextField();
			tf6=new JTextField();
			tf1.setBounds(150,100,100,20);
			tf2.setBounds(150,140,100,20);
			tf3.setBounds(150,180,100,20);
			tf4.setBounds(150,220,100,20);
			tf5.setBounds(150,260,100,20);
			tf6.setBounds(150,300,100,20);
			b=new JButton("Save");
			b.setBounds(125,340,100,20);
			tf1.setText(newId);
			id=Integer.parseInt(newId);
			Connect.pstmt10.setInt(1,id);
			rs=Connect.pstmt10.executeQuery();
			rs.next();
			System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3));
			tf2.setText(rs.getString(1));
			tf3.setText(rs.getString(2));
			tf4.setText(rs.getString(3));
			b.addActionListener(this);
			f.add(l7);
			f.add(l1);
			f.add(l2);
			f.add(l3);
			f.add(l4);
			f.add(l5);
			f.add(l6);
			f.add(tf1);
			f.add(tf2);
			f.add(tf3);
			f.add(tf4);
			f.add(tf5);
			f.add(tf6);
			f.add(b);
			f.setSize(500,500);
			f.setLayout(null);
			f.setVisible(true);
		}

		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e){
		try{
			System.out.println(tf5.getText()+tf6.getText());
			rs=Connect.pstmt5.executeQuery();
			rs.next();
			Connect.pstmt11.setInt(1,Integer.parseInt(tf5.getText()));
			Connect.pstmt11.setInt(2,Integer.parseInt(tf6.getText()));
			Connect.pstmt11.setString(3,rs.getString(1));
			Connect.pstmt11.setInt(4,id);
			Connect.pstmt11.executeUpdate();
			JOptionPane.showMessageDialog(f,"Successfully checked out");
			new Menu();
			f.setVisible(false);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        if (JOptionPane.showConfirmDialog(f,"Are you sure you want to close this window?", "Close Window?", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
}