package com.projects.mservice;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class Search implements ActionListener{
	private JLabel l1,l2,l3,l4,l5;
	private JTextField tf1,tf2,tf3,tf4,tf5;
	private JFrame f,f1;
	private JButton b,b1;
	private JTable jt;
	private String column[]={"Id","Name","Brand","Model","Admin","Contact"};
	Search(){
		f=new JFrame();
		l1=new JLabel("ID");
		l2=new JLabel("Name");
		l3=new JLabel("Brand");
		l4=new JLabel("Model");
		l5=new JLabel("Enter Id");
		l5.setBounds(50,200,100,20);
		l1.setBounds(50,50,100,20);
		l2.setBounds(50,80,100,20);
		l3.setBounds(50,110,100,20);
		l4.setBounds(50,140,100,20);
		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
		tf5=new JTextField();
		tf5.setBounds(150,200,100,20);
		tf1.setBounds(150,50,100,20);
		tf2.setBounds(150,80,100,20);
		tf3.setBounds(150,110,100,20);
		tf4.setBounds(150,140,100,20);
		b=new JButton("Search");
		b.addActionListener(this);
		b.setBounds(125,170,100,20);
		b1=new JButton("Remove");
		b1.addActionListener(this);
		b1.setBounds(125,240,100,20);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(tf1);
		f.add(tf2);
		f.add(tf3);
		f.add(tf4);
		f.add(tf5);
		f.add(b);
		f.add(b1);
		f.setLayout(null);
		f.setSize(1400,1000);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e){
			try{
				if(e.getSource()==b){
					System.out.println("Inside try of search");
					String id,name,brand,model;
					id=tf1.getText();
					name=tf2.getText();
					brand=tf3.getText();
					model=tf4.getText();
					ResultSet rs,ts;
					if(id.length()==0 && name.length()==0 && brand.length()==0 && model.length()==0){
						rs=Connect.pstmt6.executeQuery();
						ts=Connect.pstmt7.executeQuery();
					}
					else{
						int id1=1;
						Connect.pstmt9.setInt(1,id1);
						Connect.pstmt9.setString(2,name);
						Connect.pstmt9.setString(3,brand);
						Connect.pstmt9.setString(4,model);
						Connect.pstmt8.setInt(1,id1);
						Connect.pstmt8.setString(2,name);
						Connect.pstmt8.setString(3,brand);
						Connect.pstmt8.setString(4,model);
						rs=Connect.pstmt8.executeQuery();
						ts=Connect.pstmt9.executeQuery();
					}

					if(ts.next()){
						int i=0,t;
						t=ts.getInt(1);
						String data[][]=new String[t][6];
						while(rs.next()){
							data[i][0]=rs.getString("id");
							data[i][1]=rs.getString("name");
							data[i][2]=rs.getString("brand");
							data[i][3]=rs.getString("model");
							data[i][4]=rs.getString("Admin");
							data[i][5]=rs.getString("contact");
							System.out.println(data[i][0]+" "+data[i][1]+" "+data[i][2]+" "+data[i][3]+" "+data[i][4]+" "+data[i][5]);
							i++;
						}
						f1=new JFrame();
						jt=new JTable(data,column);
						jt.setBounds(50,50,200,200);
						JScrollPane sp=new JScrollPane(jt);
						f1.add(sp);
						f1.setSize(400,400);
						f1.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(f,"Sorry no record found","Alert",JOptionPane.WARNING_MESSAGE);
				}
			}
			else{
				new CustomerCheckOut(tf5.getText());
				f.setVisible(false);
				if(f1!=null)
					f1.setVisible(false);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();

		}
	}
}