package com.projects.mservice;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class Login1 implements ActionListener{
	private JFrame f;
	private final JLabel l1,l2,l3;
	private JTextField tf1;
	private JPasswordField tf2;
	private final JButton b;
	private ResultSet rs;
	Login1(){
		f=new JFrame();
		l1=new JLabel("UserId");
		l2=new JLabel("Password");
		l3=new JLabel("MASTER-LOGIN");
		l1.setBounds(50,100,100,20);
		l2.setBounds(50,150,100,20);
		l3.setBounds(125,50,200,30);
		tf1=new JTextField();
		tf2=new JPasswordField();
		tf1.setBounds(150,100,100,20);
		tf2.setBounds(150,150,100,20);
		b=new JButton("Login");
		b.setBounds(125,200,100,20);
		b.addActionListener(this);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(tf1);
		f.add(tf2);
		f.add(b);
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e){
		try{
			Connect.pstmt1.setString(1,tf1.getText());
			Connect.pstmt2.setString(1,new String(tf2.getPassword()));
			ResultSet rs1=Connect.pstmt1.executeQuery(),rs2=Connect.pstmt2.executeQuery();
			if(rs1.next() && (rs2.next() && !(rs1.getString(1)==rs2.getString(1)))){
				Connect.pstmt3.setString(1,tf1.getText());
				Connect.pstmt3.executeUpdate();
				new Menu();
				f.setVisible(false); 
			}
			else{
				JOptionPane.showMessageDialog(f,"UserId or Password is wrong","Alert",JOptionPane.WARNING_MESSAGE);
			}
		}
		catch(Exception e1){
			System.out.println(e1+"I am inside actionPerformed");
		}
	}
	public static void logOut(){
		try{
			Connect.pstmt12.executeUpdate();
			new Login1();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}