package seterm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class User {
	
	private String firstname;
	private String lastname;
	private String netid;
	private String password;
	private String role;
	private String joinyear;
	private String program;
	private String major;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getNetid() {
		return netid;
	}
	public void setNetid(String netid) {
		this.netid = netid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getJoinyear() {
		return joinyear;
	}
	public void setJoinyear(String joinyear) {
		this.joinyear = joinyear;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	
	Connection conn;
	
	public int saveUserinfo(){
		conn = new DbConnection().createCon();
		String q = "insert into registration(netid,password,firstname,lastname,role,joinyear,program,major) values('"+netid+"','"+password+"','"+firstname+"','"+lastname+"','"+role+"','"+joinyear+"','"+program+"','"+major+"');";
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
	
	public int savePhDName(String sem){
		conn = new DbConnection().createCon();
		String q = "insert into phdstudents(netid,firstname,lastname,program,major,semester) values('"+netid+"','"+firstname+"','"+lastname+"','"+program+"','"+major+"','"+sem+"');";
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
	
public LinkedHashMap getOneUser(String netids){
	conn = new DbConnection().createCon();
		//String cname = null;
		ArrayList<String> netid = new ArrayList<String>();
		ArrayList<String> fname = new ArrayList<String>();
		ArrayList<String> lname = new ArrayList<String>();
		ArrayList<String> password = new ArrayList<String>();
		
		ArrayList<String> email = new ArrayList<String>();
		ArrayList<String> phone = new ArrayList<String>();
		ArrayList<String> advisor = new ArrayList<String>();
		ArrayList<String> semester = new ArrayList<String>();
		LinkedHashMap<String, ArrayList> users= new LinkedHashMap<String, ArrayList>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			//createCon();
			String q = "Select * from registration where netid='"+netids+"';";
			rs = stmt.executeQuery(q);
			while (rs.next()) {
				//System.out.println("RS");
				
				 fname.add(rs.getString("firstname"));
				 lname.add(rs.getString("lastname"));
				 password.add(rs.getString("password"));
				 netid.add(rs.getString("netid"));
				 email.add(rs.getString("email"));
				 phone.add(rs.getString("phone"));
				 advisor.add(rs.getString("advisor"));
				
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
		
		users.put("fname",fname);
		users.put("lname", lname);
		users.put("password", password);
		users.put("netid",netid);
		
		users.put("email",email);
		users.put("phone",phone);
		users.put("advisor",advisor);
		return users; 	
	}

public int updateUserinfo(String passwords,String firstnames, String lastnames,String netids,String email,String phone,String advisor){
	conn = new DbConnection().createCon();
	String q = "update registration set password= '"+passwords+"',firstname='"+firstnames+"',lastname='"+lastnames+"',email='"+email+"',phone='"+phone+"',advisor='"+advisor+"' where netid='"+netids+"';";
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


public LinkedHashMap getProfessorsEmail(){
	conn = new DbConnection().createCon();
		//String cname = null;
		
		ArrayList<String> fname = new ArrayList<String>();
		ArrayList<String> lname = new ArrayList<String>();
		ArrayList<String> email = new ArrayList<String>();
		
		LinkedHashMap<String, ArrayList> users= new LinkedHashMap<String, ArrayList>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			//createCon();
			String q = "Select * from registration where role='Faculty';";
			rs = stmt.executeQuery(q);
			while (rs.next()) {
				//System.out.println("RS");
				
				 fname.add(rs.getString("firstname"));
				 lname.add(rs.getString("lastname"));
				 email.add(rs.getString("email"));
				
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
		
		users.put("fname",fname);
		users.put("lname", lname);
		users.put("email",email);
		return users; 	
	}
}
