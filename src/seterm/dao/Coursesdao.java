package seterm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Coursesdao {
	Connection conn;
	
public int saveCourseinfo(String coursename, String courseid){
	conn = new DbConnection().createCon();
		String q = "insert into courses(courseid,coursename) values('"+courseid+"','"+coursename+"');";
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
	

public int saveMyCourse(String courseid, String netid){
	conn = new DbConnection().createCon();
	String q = "update courses set netid='"+netid+"' where courseid='"+courseid+"';";
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


	public LinkedHashMap getAllCoursesNameandId(){
		conn = new DbConnection().createCon();
		//String cname = null;
		ArrayList<String> cname = new ArrayList<String>();
		ArrayList<String> cid = new ArrayList<String>();
		ArrayList<String> netid = new ArrayList<String>();
		LinkedHashMap<String, ArrayList> coursedetails= new LinkedHashMap<String, ArrayList>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			//createCon();
			String q = "Select * from courses;";
			rs = stmt.executeQuery(q);
			while (rs.next()) {
				//System.out.println("RS");
				 cname.add(rs.getString("coursename"));
				 cid.add(rs.getString("courseid"));
				netid.add(rs.getString("netid"));
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
		coursedetails.put("cname", cname);
		coursedetails.put("cid",cid);
		coursedetails.put("netid",netid);
		return coursedetails; 	
	}
	
	public LinkedHashMap getMyCoursesNameandId(String netid){
		conn = new DbConnection().createCon();
		//String cname = null;
		ArrayList<String> cname = new ArrayList<String>();
		ArrayList<String> cid = new ArrayList<String>();
		LinkedHashMap<String, ArrayList> coursedetails= new LinkedHashMap<String, ArrayList>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			//createCon();
			String q = "Select * from courses Where netid='"+netid+"';";
			rs = stmt.executeQuery(q);
			while (rs.next()) {
				//System.out.println("RS");
				 cname.add(rs.getString("coursename"));
				 cid.add(rs.getString("courseid"));
				
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
		coursedetails.put("cname", cname);
		coursedetails.put("cid",cid);
		return coursedetails; 	
	}
	
public int saveCourseTAinfo(String courseid, String officehours, String tainfo, String syllabus){
	conn = new DbConnection().createCon();
		String q = "update courses set officehours='"+officehours+"', tainfo = '"+tainfo+"',syllabus ='"+syllabus+"' Where courseid='"+courseid+"';";
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

public LinkedHashMap getMyOfficehours(String courseid){
	conn = new DbConnection().createCon();
	//String cname = null;
	ArrayList<String> ohours = new ArrayList<String>();
	ArrayList<String> tainfo = new ArrayList<String>();
	ArrayList<String> syllabus = new ArrayList<String>();
	ArrayList<String> netid = new ArrayList<String>();
	LinkedHashMap<String, ArrayList> myofficehours= new LinkedHashMap<String, ArrayList>();
	try {
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		//createCon();
		String q = "Select * from courses Where courseid='"+courseid+"';";
		rs = stmt.executeQuery(q);
		while (rs.next()) {
			//System.out.println("RS");
			ohours.add(rs.getString("officehours"));
			 tainfo.add(rs.getString("tainfo"));
			 syllabus.add(rs.getString("syllabus"));
			netid.add(rs.getString("netid"));
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
	myofficehours.put("ohours", ohours);
	myofficehours.put("tainfo",tainfo);
	myofficehours.put("syllabus", syllabus);
	myofficehours.put("netid", netid);
	return myofficehours; 	
}

public int enrollCourse(String coursename, String netid){
	conn = new DbConnection().createCon();
		String q = "insert into studentcourses(netid,cname) values('"+netid+"','"+coursename+"');";
		int r = 0;
		try {
			Statement stmt = conn.createStatement();
			r = stmt.executeUpdate(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
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
public ArrayList<String> getMyEnrolledCourses(String netid){
	conn = new DbConnection().createCon();
	//String cname = null;
	ArrayList<String> cname = new ArrayList<String>();
	
	
	try {
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		//createCon();
		String q = "Select * from studentcourses where netid='"+netid+"';";
		rs = stmt.executeQuery(q);
		while (rs.next()) {
			//System.out.println("RS");
			 cname.add(rs.getString("cname"));
			
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

	return cname; 	
}

public int deRegister(String cname, String netid){
	conn = new DbConnection().createCon();
		String q = "delete from studentcourses where netid='"+netid+"' and cname='"+cname+"';";
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

public LinkedHashMap getAllSuggestions(){
	conn = new DbConnection().createCon();
	//String cname = null;
	ArrayList<String> cname = new ArrayList<String>();
	ArrayList<String> major = new ArrayList<String>();
	LinkedHashMap<String, ArrayList> coursedetails= new LinkedHashMap<String, ArrayList>();
	try {
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		//createCon();
		String q = "Select distinct major from concentration;";
		rs = stmt.executeQuery(q);
		while (rs.next()) {
			//System.out.println("RS");
			 
			 major.add(rs.getString("major"));
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
	coursedetails.put("cname", cname);
	coursedetails.put("major",major);
	return coursedetails; 	
}

public ArrayList<String> getSomeSuggestions(String major){
	conn = new DbConnection().createCon();
	//String cname = null;
	ArrayList<String> cname = new ArrayList<String>();
	
	LinkedHashMap<String, ArrayList> coursedetails= new LinkedHashMap<String, ArrayList>();
	try {
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		//createCon();
		String q = "Select * from concentration where major='"+major+"';";
		rs = stmt.executeQuery(q);
		while (rs.next()) {
			//System.out.println("RS");
			 cname.add(rs.getString("cname"));
			 
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
	
	
	return cname; 	
}

}
