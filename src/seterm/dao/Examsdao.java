package seterm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Examsdao {
	
	Connection conn;
	
	
	public int saveExam(String name, String date,String info, String netid){
		conn = new DbConnection().createCon();
		String q = "insert into exam(name,date,info,netid) values('"+name+"','"+date+"','"+info+"','"+netid+"');";
		int r = 0;
		try {
			Statement stmt = conn.createStatement();
			r = stmt.executeUpdate(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	
public LinkedHashMap getAllExams(){
	conn = new DbConnection().createCon();
		//String cname = null;
		ArrayList<String> ename = new ArrayList<String>();
		ArrayList<Integer> eid = new ArrayList<Integer>();
		ArrayList<String> edate = new ArrayList<String>();
		ArrayList<String> einfo = new ArrayList<String>();
		ArrayList<String> netid = new ArrayList<String>();
		LinkedHashMap<String, ArrayList> examdetails= new LinkedHashMap<String, ArrayList>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			//createCon();
			String q = "Select * from exam order by exam_id desc;";
			rs = stmt.executeQuery(q);
			while (rs.next()) {
				//System.out.println("RS");
				 ename.add(rs.getString("name"));
				 eid.add(rs.getInt("exam_id"));
				 edate.add(rs.getString("date"));
				 einfo.add(rs.getString("info"));
				 netid.add(rs.getString("netid"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		examdetails.put("ename", ename);
		examdetails.put("eid",eid);
		examdetails.put("edate",edate);
		examdetails.put("einfo",einfo);
		examdetails.put("netid",netid);
		return examdetails; 	
	}
public int saveExamResult(String name, String result, String netid, int examid){
	conn = new DbConnection().createCon();
	String q = "insert into examresults(name,result,netid,examid) values('"+name+"','"+result+"','"+netid+"',"+examid+");";
	int r = 0;
	try {
		Statement stmt = conn.createStatement();
		r = stmt.executeUpdate(q);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return r;
}

public LinkedHashMap getAllExamResults(){
	conn = new DbConnection().createCon();
	//String cname = null;
	ArrayList<String> ename = new ArrayList<String>();
	ArrayList<Integer> eid = new ArrayList<Integer>();
	ArrayList<String> einfo = new ArrayList<String>();
	ArrayList<Integer> examid = new ArrayList<Integer>();
	LinkedHashMap<String, ArrayList> examdetails= new LinkedHashMap<String, ArrayList>();
	try {
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		//createCon();
		String q = "Select * from examresults order by id desc;";
		rs = stmt.executeQuery(q);
		while (rs.next()) {
			//System.out.println("RS");
			 ename.add(rs.getString("name"));
			 eid.add(rs.getInt("id"));
			 einfo.add(rs.getString("result"));
			 examid.add(rs.getInt("examid"));
		}
	} catch (Exception e) {
		e.printStackTrace();
		
	}
	examdetails.put("ename", ename);
	examdetails.put("eid",eid);
	examdetails.put("einfo",einfo);
	examdetails.put("examid",examid);
	return examdetails; 	
}

public LinkedHashMap getExamResultsbyId(String id){
	conn = new DbConnection().createCon();
	//String cname = null;
	ArrayList<String> ename = new ArrayList<String>();
	ArrayList<Integer> eid = new ArrayList<Integer>();
	ArrayList<String> einfo = new ArrayList<String>();
	LinkedHashMap<String, ArrayList> examdetails= new LinkedHashMap<String, ArrayList>();
	try {
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		//createCon();
		String q = "Select * from examresults where name='"+id+"';";
		rs = stmt.executeQuery(q);
		while (rs.next()) {
			//System.out.println("RS");
			 ename.add(rs.getString("name"));
			 eid.add(rs.getInt("id"));
			 einfo.add(rs.getString("result"));
			
		}
	} catch (Exception e) {
		e.printStackTrace();
		
	}
	examdetails.put("ename", ename);
	examdetails.put("eid",eid);
	examdetails.put("einfo",einfo);
	return examdetails; 	
}


public int updateExamResultsbyId(String id, String result){
	conn = new DbConnection().createCon();
	String q = "update examresults set result = '"+result+"' where name = "+id+";";
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

public int deleteExamReult(int id){
	conn = new DbConnection().createCon();
	String q = "delete from examresults where id='"+id+"';";
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
public int deleteExam(int id){
	conn = new DbConnection().createCon();
	String q = "delete from exam where exam_id="+id+";";
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

public int applyExam(String id, String netid){
	conn = new DbConnection().createCon();
	String q = "insert into applyexams(name,netid) values('"+id+"','"+netid+"');";
	int r = 0;
	try {
		Statement stmt = conn.createStatement();
		r = stmt.executeUpdate(q);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	}
	return r;
}
}
