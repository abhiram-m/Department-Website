package seterm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Alumnidao {
	Connection conn;
	
	public LinkedHashMap getAllAlumni(){
		conn = new DbConnection().createCon();
		//String cname = null;
		ArrayList<String> id = new ArrayList<String>();
		ArrayList<String> fname = new ArrayList<String>();
		ArrayList<String> lname = new ArrayList<String>();
		ArrayList<String> info = new ArrayList<String>();
		
		LinkedHashMap<String, ArrayList> alumni= new LinkedHashMap<String, ArrayList>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			//createCon();
			String q = "Select * from alumni;";
			rs = stmt.executeQuery(q);
			while (rs.next()) {
				//System.out.println("RS");
				id.add(rs.getString("id"));
				 fname.add(rs.getString("fname"));
				 lname.add(rs.getString("lname"));
				 info.add(rs.getString("info"));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		alumni.put("netid", id);
		alumni.put("fname",fname);
		alumni.put("lname", lname);
		alumni.put("semester", info);
		return alumni; 	
	}
	
public LinkedHashMap getOneAlumni(int ids){
	conn = new DbConnection().createCon();
		//String cname = null;
		ArrayList<String> id = new ArrayList<String>();
		ArrayList<String> fname = new ArrayList<String>();
		ArrayList<String> lname = new ArrayList<String>();
		ArrayList<String> info = new ArrayList<String>();
		LinkedHashMap<String, ArrayList> alumni= new LinkedHashMap<String, ArrayList>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			//createCon();
			String q = "Select * from alumni where id='"+ids+"';";
			rs = stmt.executeQuery(q);
			while (rs.next()) {
				//System.out.println("RS");
				id.add(rs.getString("id"));
				 fname.add(rs.getString("fname"));
				 lname.add(rs.getString("lname"));
				 info.add(rs.getString("info"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		alumni.put("id", id);
		alumni.put("fname",fname);
		alumni.put("lname", lname);
		alumni.put("info", info);
		return alumni; 	
	}

public int updateAlumniInfo(int studentselected, String info){
	conn = new DbConnection().createCon();
	String q = "update alumni set info='"+info+"' Where id="+studentselected+";";
	int r = 0;
	try {
		Statement stmt = conn.createStatement();
		r = stmt.executeUpdate(q);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return r;
}


public int addAlumniInfo(String fname,String lname, String info){
	conn = new DbConnection().createCon();
	String q = "insert into alumni(fname,lname,info) values('"+fname+"','"+lname+"','"+info+"');";
	int r = 0;
	try {
		Statement stmt = conn.createStatement();
		r = stmt.executeUpdate(q);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return r;
}
}
