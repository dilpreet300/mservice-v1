package com.projects.mservice;
import java.sql.*;
import javax.swing.*;
public class AddMaster{
	private JFrame f;
	private final JLabel l1,l2,l3,l4,l5;
	private JTextField tf1,tf2,tf3,tf4;
	private JButton b;
	AddMaster(){
		f=new JFrame();
		l1=new JLabel("UserId");
		l2=new JLabel("Name");
		l3=new JLabel("Email");
		l4=new JLabel("Password");
		l5=new JLabel("Add Master");
		l5.setBounds(125,60,100,20);
		l1.setBounds(50,100,100,20);
		l2.setBounds(50,140,100,20);
		l3.setBounds(50,180,100,20);
		l4.setBounds(50,220,100,20);
		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
		tf1.setBounds(150,100,100,20);
		tf2.setBounds(150,140,100,20);
		tf3.setBounds(150,180,100,20);
		tf4.setBounds(150,220,100,20);
		b=new JButton("Create");
		b.setBounds(125,260,100,20);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(tf4);
		f.add(tf1);
		f.add(tf2);
		f.add(tf3);
		f.add(b);
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);

	}
}