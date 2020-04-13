package com.projects.mservice;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class Menu implements ActionListener{
	private JFrame f;
	private final JButton b1,b2,b3,b4,b5;
	Menu(){
		f=new JFrame();
		b1=new JButton("Add Customer");
		b2=new JButton("Search Customer");
		b3=new JButton("Customer Check Out");
		b4=new JButton("Add Master");
		b5=new JButton("LogOut");
		b1.setBounds(50,100,200,20);
		b2.setBounds(50,150,200,20);
		b3.setBounds(50,200,200,20);
		b4.setBounds(50,250,200,20);
		b5.setBounds(50,300,200,20);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.addWindowListener(this);
		f.setLayout(null);
		f.setSize(400,400);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e){
		try{
			System.out.println("Inside Try block");
			if(e.getSource()==b1){
				System.out.println("inside addCustomer");
				new addCustomer();
				f.setVisible(false);
			}
			else if(e.getSource()==b2){
				new Search();
				f.setVisible(false);
				System.out.println("inside search");

			}
			else if(e.getSource()==b3){
				new Search();
				f.setVisible(false);
				System.out.println("inside CustomerCheckOut");

			}
			else if(e.getSource()==b4){
				new AddMaster();
				f.setVisible(false);
				System.out.println("inside add master");
			}
			else{
				Login1.logOut();
				f.setVisible(false);
			}

		}
		catch (Exception ex) {
			
		}
	}
	@Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
    	System.out.println("Close is clicked");
    }	
}