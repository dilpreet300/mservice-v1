package com.projects.mservice;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class addCustomer implements ActionListener{
	private final JLabel l1,l2,l3,l4,l5,l6;
	private JTextField tf1,tf2,tf3,tf4;
	private JTextArea ta;
	private JFrame f;
	private JButton b;
	addCustomer(){
		f=new JFrame();
		l1=new JLabel("Name");
		l2=new JLabel("Brand");
		l3=new JLabel("Model");
		l4=new JLabel("Contact");
		l5=new JLabel("Problem");
		l6=new JLabel("Add Customer");
		l6.setBounds(125,50,100,40);
		l1.setBounds(50,100,100,20);
		l2.setBounds(50,150,100,20);
		l3.setBounds(50,200,100,20);
		l4.setBounds(50,250,100,20);
		l5.setBounds(50,300,100,20);
		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
		tf1.setBounds(150,100,100,20);
		tf2.setBounds(150,150,100,20);
		tf3.setBounds(150,200,100,20);
		tf4.setBounds(150,250,100,20);
		ta=new JTextArea();
		ta.setBounds(150,300,200,40);
		b=new JButton("Submit");
		b.setBounds(125,350,100,20);
		System.out.println("Inside addCustomer constructor");
		b.addActionListener(this);
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
		f.add(ta);
		f.add(b);
		f.setSize(500,500);
		f.setLayout(null);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e){
		try{
			System.out.println("I am inside addCustomer try block");
			String name,brand,model,admin,problem,contact;
			name=tf1.getText();
			brand=tf2.getText();
			model=tf3.getText();
			contact=tf4.getText();
			problem=ta.getText();
			ResultSet rs=Connect.pstmt5.executeQuery();
			rs.next();
			admin=rs.getString(1);
			System.out.println(name+brand+model+contact+problem+admin);
			Connect.pstmt4.setString(1,name);
			Connect.pstmt4.setString(2,brand);
			Connect.pstmt4.setString(3,model);
			Connect.pstmt4.setString(4,admin);
			Connect.pstmt4.setString(5,problem);
			Connect.pstmt4.setString(6,contact);
			Connect.pstmt4.executeUpdate();
			JOptionPane.showMessageDialog(f,"Successfully added");
			new Menu();
			f.setVisible(false);  
		}
		catch(Exception ex){
			System.out.println(ex+"I am inside addCustomer actionPerformed");
		}
	}
}