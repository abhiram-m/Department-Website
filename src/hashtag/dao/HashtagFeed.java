package hashtag.dao;
import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HashtagFeed {
	
	
	Hashtagdao hdao = new Hashtagdao();
	Connection conn = hdao.createCon();
	int count =0;

	//method to save posts
	
	
	public int savePost(String uniqueID, String datenow, String Hashtagname, String newpost){

		String q = "insert into HashtagFeed(ID,time,parentFeedID,hashtag,content) values("+uniqueID+",'"+datenow+"','parent','"+Hashtagname+"','"+newpost+"');";
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
	
	
	//method to save replies	

	
public int saveReply(String uniqueID, String datenow, String Hashtagname, String ID, String replypost){
		
		String q = "insert into HashtagFeed(ID,time,parentFeedID,hashtag,content) values("+uniqueID+",'"+datenow+"','"+ID+"','"+Hashtagname+"','"+replypost+"');";
		int r1 = 0;
		try {
			Statement stmt = conn.createStatement();
			r1 = stmt.executeUpdate(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r1;
	}


//method to get posts

	public ResultSet getPosts(){
			
		
		String q = "SELECT * FROM HashtagFeed ORDER BY time desc";
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(q);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}


	public LinkedHashMap<String, ArrayList> getReplies(){
		
		
		ArrayList<String> contentlist = new ArrayList<String>();
		ArrayList<String> parentFeedID = new ArrayList<String>();
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> ID = new ArrayList<String>();
		
		LinkedHashMap<String, ArrayList> m= new LinkedHashMap<String, ArrayList>();
		String q = "SELECT * FROM HashtagFeed ORDER BY time desc";
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(q);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//rs iterate
	
				
				
				try {
					while(rs.next()){	
						contentlist.add(rs.getString("content"));
						parentFeedID.add(rs.getString("parentFeedID"));
						name.add(rs.getString("hashtag"));
						ID.add(rs.getString("ID"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				m.put("name", name);
				m.put("parentFeedID", parentFeedID);
				m.put("content", contentlist);
				m.put("id",ID);
			
				
				return m;
			
			
		}
	
	
public int deleteDiscussion(String uniqueID){
		
		String q = "delete from HashtagFeed where content='"+uniqueID+"';";
		int r1 = 0;
		try {
			Statement stmt = conn.createStatement();
			r1 = stmt.executeUpdate(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r1;
	}


}
