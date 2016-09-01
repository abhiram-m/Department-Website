package seterm.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seterm.dao.DbConnection;
import seterm.dao.Examsdao;

/**
 * Servlet implementation class StudentExamResultsListServlet
 */
@WebServlet("/StudentExamResultsListServlet")
public class StudentExamResultsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentExamResultsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Examsdao e= new Examsdao();
		LinkedHashMap<String, ArrayList> examdetails = e.getAllExamResults();
		request.setAttribute("examdetails", examdetails);
		
		Connection conn=new DbConnection().createCon();
		String netids = (String)request.getSession().getAttribute("netid");
		ArrayList<String> ename = new ArrayList<String>();
		
		LinkedHashMap<String, ArrayList> apply= new LinkedHashMap<String, ArrayList>();
		try {
			
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			//createCon();
			String q = "Select * from applyexams where netid='"+netids+"';";
			rs = stmt.executeQuery(q);
			while (rs.next()) {
				//System.out.println("RS");
				 
				ename.add(rs.getString("name"));
				 
				
			}
		} catch (Exception ee) {
			ee.printStackTrace();
			
		}
		
		
		ArrayList<Integer> eids = new ArrayList<Integer>();
		ArrayList<String> enames = new ArrayList<String>();
		enames = examdetails.get("ename");
		eids = examdetails.get("examid");
		
		
		ArrayList<Integer> appid = new ArrayList<Integer>();
		ArrayList<String> appname = new ArrayList<String>();
		System.out.println("EID"+ename.size());
		for(int i=0;i<enames.size();i++){
			System.out.println("EID"+enames.get(i));
			if(ename.contains(enames.get(i))){
				appid.add(eids.get(i));
				appname.add(enames.get(i));
				
			}
		}
		
		apply.put("id",appid);
		apply.put("name",appname);
		request.setAttribute("apply",apply);
		RequestDispatcher rd=request.getRequestDispatcher("viewresultexamlist.jsp");
	    rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
