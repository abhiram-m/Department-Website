package seterm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class PhdStudentsdao {
	
	Connection conn;
	
	public LinkedHashMap getAllPhdStudents(){
		conn = new DbConnection().createCon();
		//String cname = null;
		ArrayList<String> netid = new ArrayList<String>();
		ArrayList<String> fname = new ArrayList<String>();
		ArrayList<String> lname = new ArrayList<String>();
		ArrayList<String> candidate = new ArrayList<String>();
		ArrayList<String> semester = new ArrayList<String>();
		LinkedHashMap<String, ArrayList> phdstudents= new LinkedHashMap<String, ArrayList>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			//createCon();
			String q = "Select * from phdstudents;";
			rs = stmt.executeQuery(q);
			while (rs.next()) {
				//System.out.println("RS");
				netid.add(rs.getString("netid"));
				 fname.add(rs.getString("firstname"));
				 lname.add(rs.getString("lastname"));
				 semester.add(rs.getString("semester"));
				 candidate.add(rs.getString("candidate"));
				
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
		phdstudents.put("netid", netid);
		phdstudents.put("fname",fname);
		phdstudents.put("lname", lname);
		phdstudents.put("semester", semester);
		phdstudents.put("candidate", candidate);
		return phdstudents; 	
	}
	
public LinkedHashMap getOnePhdStudents(String netids){
	conn = new DbConnection().createCon();
		//String cname = null;
		ArrayList<String> netid = new ArrayList<String>();
		ArrayList<String> fname = new ArrayList<String>();
		ArrayList<String> lname = new ArrayList<String>();
		ArrayList<String> candidate = new ArrayList<String>();
		ArrayList<String> semester = new ArrayList<String>();
		LinkedHashMap<String, ArrayList> phdstudents= new LinkedHashMap<String, ArrayList>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			//createCon();
			String q = "Select * from phdstudents where netid='"+netids+"';";
			rs = stmt.executeQuery(q);
			while (rs.next()) {
				//System.out.println("RS");
				netid.add(rs.getString("netid"));
				 fname.add(rs.getString("firstname"));
				 lname.add(rs.getString("lastname"));
				 semester.add(rs.getString("semester"));
				 candidate.add(rs.getString("candidate"));
				
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
		phdstudents.put("netid", netid);
		phdstudents.put("fname",fname);
		phdstudents.put("lname", lname);
		phdstudents.put("semester", semester);
		phdstudents.put("candidate", candidate);
		return phdstudents; 	
	}
	
	public int savePhdInfo(String studentselected, String phdcandidate, String phdsemester){
		conn = new DbConnection().createCon();
		String q = "update phdstudents set semester='"+phdsemester+"', candidate = '"+phdcandidate+"' Where netid='"+studentselected+"';";
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

	public int saveRegPhdInfo(String netid, String fname, String lname, String major, String phdsemester){
		conn = new DbConnection().createCon();
		String q = "insert into phdstudents(netid,firstname,lastname,program,major,semester) values('"+netid+"','"+fname+"','"+lname+"','PhD','"+major+"''"+phdsemester+"');";
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
