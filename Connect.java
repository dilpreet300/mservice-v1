package com.projects.mservice;
import java.sql.*;
public class Connect{
	private final String url="jdbc:mysql://localhost:3306/mservice";
	private final String password="dilpreet";
	private final String user="root";
	private  Connection conn;
	static PreparedStatement pstmt1,pstmt2,pstmt3,pstmt4,pstmt5,pstmt6,pstmt7,pstmt8,pstmt9,pstmt10,pstmt11,pstmt12;
	Connect(){
		try{
			conn=DriverManager.getConnection(url,user,password);
			// stmt=conn.createStatement();
			pstmt1=conn.prepareStatement("select passw from admin where userid=?");
			pstmt2=conn.prepareStatement("select sha2(?,256)");
			pstmt3=conn.prepareStatement("update admin set isloggedin='Y' where userid=?");
			pstmt4=conn.prepareStatement("insert into mobilein(name,brand,model,admin,problem,contact) values(?,?,?,?,?,?)");
			pstmt5=conn.prepareStatement("select userid from admin where isloggedin='Y'");
			pstmt6=conn.prepareStatement("select * from mobilein");
			pstmt7=conn.prepareStatement("select count(*) from mobilein");
			pstmt8=conn.prepareStatement("select * from mobilein where id=? or name=? or brand=? or model=?");
			pstmt9=conn.prepareStatement("select count(*) from mobilein where id=? or name=? or brand=? or model=?");
			pstmt10=conn.prepareStatement("select name,brand,model from mobilein where id=?");
			pstmt11=conn.prepareStatement("update mobileout set charges=?,due=?,admin=?,date_time=current_timestamp(),received='Y' where id=?");
			pstmt12=conn.prepareStatement("update admin set isloggedin='N' where isloggedin='Y'");
		}
	    catch(Exception e){
	     	System.out.println("I am in connect");
	     	System.out.println(e);
		    }
		}
}