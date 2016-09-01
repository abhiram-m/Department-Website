package seterm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Announcementsdao {
	Connection conn;
	
	public int saveAnnouncements(String netid, String details, String type, String id, String datenow, String link){
		conn = new DbConnection().createCon();
		String q = "insert into announcements(netid,details,type,id,time,link) values('"+netid+"','"+details+"','"+type+"','"+id+"','"+datenow+"','"+link+"');";
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
	
public LinkedHashMap getAllAnnouncements(){
	conn = new DbConnection().createCon();
		//String cname = null;
		ArrayList<String> details = new ArrayList<String>();
		ArrayList<String> type = new ArrayList<String>();
		ArrayList<String> netid = new ArrayList<String>();
		ArrayList<String> aid = new ArrayList<String>();
		ArrayList<String> link = new ArrayList<String>();
		LinkedHashMap<String, ArrayList> announcements= new LinkedHashMap<String, ArrayList>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			//createCon();
			String q = "Select * from announcements ORDER BY time desc;";
			rs = stmt.executeQuery(q);
			while (rs.next()) {
				//System.out.println("RS");
				details.add(rs.getString("details"));
				type.add(rs.getString("type"));
				netid.add(rs.getString("netid"));
				aid.add(rs.getString("id"));
				link.add(rs.getString("link"));
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
		announcements.put("details", details);
		announcements.put("type",type);
		announcements.put("netid",netid);
		announcements.put("aid",aid);
		announcements.put("link",link);
		return announcements; 	
	}

public int deleteAnnouncement(String id){
	conn = new DbConnection().createCon();
	String q = "delete from announcements where id='"+id+"';";
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

public LinkedHashMap getOneAnnouncement(String id){
	conn = new DbConnection().createCon();
	//String cname = null;
	ArrayList<String> details = new ArrayList<String>();
	ArrayList<String> type = new ArrayList<String>();
	ArrayList<String> netid = new ArrayList<String>();
	ArrayList<String> aid = new ArrayList<String>();
	ArrayList<String> link = new ArrayList<String>();
	LinkedHashMap<String, ArrayList> announcements= new LinkedHashMap<String, ArrayList>();
	try {
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		//createCon();
		String q = "Select * from announcements where id='"+id+"';";
		rs = stmt.executeQuery(q);
		while (rs.next()) {
			//System.out.println("RS");
			details.add(rs.getString("details"));
			type.add(rs.getString("type"));
			//netid.add(rs.getString("netid"));
			aid.add(rs.getString("id"));
			link.add(rs.getString("link"));
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
	announcements.put("details", details);
	announcements.put("type",type);
	//announcements.put("netid",netid);
	announcements.put("aid",aid);
	announcements.put("link",link);
	return announcements; 	
}

public int updateAnnouncements(String details, String id, String link){
	conn = new DbConnection().createCon();
//	System.out.println("DETAILS "+details+" LINKS "+link+" ID "+id);

	String q = "update announcements set details='"+details+"', link = '"+link+"' where id='"+id+"';";
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

public int applyJob(String netid, String jobid){
	conn = new DbConnection().createCon();
	String q = "insert into jobsapply(netid,id) values('"+netid+"','"+jobid+"');";
	int r = 0;
	try {
		Statement stmt = conn.createStatement();
		r = stmt.executeUpdate(q);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	return r;
}
}
