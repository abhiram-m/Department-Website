package hashtag.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

public class Hashtag {
		
	Hashtagdao hdao = new Hashtagdao();
	Connection conn = hdao.createCon();
	int count =0;
	public int searchHashtag(String hashtagname){
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			//createCon();
			String q = "SELECT count(Nameofhashtag) AS col FROM Hashtag where Nameofhashtag collate latin1_general_cs='"+hashtagname+"'";
			rs = stmt.executeQuery(q);
			while (rs.next()) {
				 count = rs.getInt(1);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			 count = 0;
		}
		return count; 	
	}

	
	public int createHashtag(String hashtagname, SimpleDateFormat sdf, Date dt, String netid){
		
		int r=0;
		String p = "insert into Hashtag(Nameofhashtag, DateCreated, netid) values('"+hashtagname+"','"+sdf.format(dt)+"','"+netid+"');";
		try {
			Statement stmt = conn.createStatement();
			 r = stmt.executeUpdate(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	
public LinkedHashMap<String, ArrayList> getHashtag(){
	ResultSet rs = null;
	LinkedHashMap<String, ArrayList> hashtags= new LinkedHashMap<String, ArrayList>();
	ArrayList<String> names= new ArrayList<String>();
	ArrayList<String> netids= new ArrayList<String>();
		String p = "select * from Hashtag;";
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(p);
			while (rs.next()) {
				names.add(rs.getString("Nameofhashtag"));
				netids.add(rs.getString("netid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hashtags.put("names", names);
		hashtags.put("netids",netids);
		return hashtags;
	}
public int deleteHashtag(String hashtagname){
	int c;
	try {
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		//createCon();
		String q = "delete from hashtag where Nameofhashtag='"+hashtagname+"'";
		c = stmt.executeUpdate(q);
		
	} catch (Exception e) {
		e.printStackTrace();
		 c = 0;
	}
	return c; 	
}	
	
}
