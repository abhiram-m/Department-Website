package seterm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Resourcedao {
	
	Connection conn;

	
	
	public int saveResource(String name, String type, String info){
		conn = new DbConnection().createCon();
		String q = "insert into resources(resourcename,resourcetype,resourceinfo) values('"+name+"','"+type+"','"+info+"');";
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
	
	
public LinkedHashMap getAllResources(){
	conn = new DbConnection().createCon();
		//String cname = null;
		ArrayList<String> rname = new ArrayList<String>();
		ArrayList<String> rtype = new ArrayList<String>();
		ArrayList<String> rinfo = new ArrayList<String>();
		LinkedHashMap<String, ArrayList> resources= new LinkedHashMap<String, ArrayList>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			//createCon();
			String q = "Select * from resources;";
			rs = stmt.executeQuery(q);
			while (rs.next()) {
				//System.out.println("RS");
				 rname.add(rs.getString("resourcename"));
				 rtype.add(rs.getString("resourcetype"));
				 rinfo.add(rs.getString("resourceinfo"));
				
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
		resources.put("rname", rname);
		resources.put("rtype",rtype);
		resources.put("rinfo",rinfo);
		return resources; 	
	}

public LinkedHashMap getMyResources(String name){
	conn = new DbConnection().createCon();
	//String cname = null;
	ArrayList<String> rname = new ArrayList<String>();
	ArrayList<String> rdate = new ArrayList<String>();
	ArrayList<String> rtime = new ArrayList<String>();
	LinkedHashMap<String, ArrayList> resources= new LinkedHashMap<String, ArrayList>();
	try {
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		//createCon();
		String q = "Select * from reservations where name='"+name+"';";
		rs = stmt.executeQuery(q);
		while (rs.next()) {
			//System.out.println("RS");
			 rname.add(rs.getString("resourcename"));
			 rdate.add(rs.getString("date"));
			 rtime.add(rs.getString("time"));
			
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
	resources.put("rname", rname);
	resources.put("rdate",rdate);
	resources.put("rtime",rtime);
	return resources; 	
}


public LinkedHashMap getSomeResources(String resourcename){
	conn = new DbConnection().createCon();
	//String cname = null;
	ArrayList<String> rtype = new ArrayList<String>();
	ArrayList<String> rinfo = new ArrayList<String>();
	LinkedHashMap<String, ArrayList> someresources= new LinkedHashMap<String, ArrayList>();
	try {
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		//createCon();
		String q = "Select * from resources where resourcename='"+resourcename+"';";
		rs = stmt.executeQuery(q);
		while (rs.next()) {
			//System.out.println("RS");
			 rtype.add(rs.getString("resourcetype"));
			 rinfo.add(rs.getString("resourceinfo"));
			
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
	someresources.put("rtype",rtype);
	someresources.put("rinfo",rinfo);
	return someresources; 	
}



public LinkedHashMap getResourceAvailabillity(String resourcename, String date){
	conn = new DbConnection().createCon();
	//String cname = null;
	ArrayList<String> timeslots = new ArrayList<String>();
	ArrayList<String> names = new ArrayList<String>();
	LinkedHashMap<String, ArrayList> reservations= new LinkedHashMap<String, ArrayList>();
	try {
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		//createCon();
		String q = "Select * from reservations where date='"+date+"' and resourcename='"+resourcename+"';";
		rs = stmt.executeQuery(q);
		while (rs.next()) {
			//System.out.println("RS");
			timeslots.add(rs.getString("time"));
			 names.add(rs.getString("name"));
			
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
	reservations.put("timeslots", timeslots);
	reservations.put("names",names);
	return reservations; 	
}
public int saveReservation(String rname, String date, String time, String name){
	conn = new DbConnection().createCon();
	String q = "insert into reservations(resourcename,date,time,name) values('"+rname+"','"+date+"','"+time+"','"+name+"');";
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

public int cancelReservation(String rname, String date, String time){
	conn = new DbConnection().createCon();
	String q = "delete from reservations where resourcename='"+rname+"' and date='"+date+"' and time='"+time+"';";
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
