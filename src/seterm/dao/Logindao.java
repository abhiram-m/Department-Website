package seterm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Logindao {
	Connection conn;
	
int count;
public int loginAuth(String netid, String password){
	conn = new DbConnection().createCon();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			//createCon();
			String q = "Select count(netid) from registration Where netid='" + netid + "' and password='" + password + "'";
			rs = stmt.executeQuery(q);
			while (rs.next()) {
				 count = rs.getInt(1);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			 count = 0;
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count; 	
	}

public String getNamefromreg(String netid){
	conn = new DbConnection().createCon();
	String name = null;
	try {
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		//createCon();
		String q = "Select firstname from registration Where netid='" + netid + "'";
		rs = stmt.executeQuery(q);
		while (rs.next()) {
			 name = rs.getString(1);
			
		}
	} catch (Exception e) {
		e.printStackTrace();
		name = "NO";
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return name; 	
}
public String getNetidfromreg(String netid){
	conn = new DbConnection().createCon();
	String name = null;
	try {
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		//createCon();
		String q = "Select netid from registration Where netid='" + netid + "'";
		rs = stmt.executeQuery(q);
		while (rs.next()) {
			 name = rs.getString(1);
			
		}
	} catch (Exception e) {
		e.printStackTrace();
		name = "NO";
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return name; 	
}

public String getRolefromreg(String netid){
	conn = new DbConnection().createCon();
	String role = null;
	try {
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		//createCon();
		String q = "Select role from registration Where netid='" + netid + "'";
		rs = stmt.executeQuery(q);
		while (rs.next()) {
			 role = rs.getString(1);
			
		}
	} catch (Exception e) {
		e.printStackTrace();
		role = "NO";
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return role; 	
}
}
