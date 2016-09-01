package seterm.controller;
import seterm.dao.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String netid = request.getParameter("netid");
		String password = request.getParameter("password");
		
		Logindao ldao = new Logindao();
		int count = ldao.loginAuth(netid, password);
		
		//set session
		HttpSession session = request.getSession();
		String name = ldao.getNamefromreg(netid);
	    session.setAttribute("username", name);
		session.setAttribute("role", ldao.getRolefromreg(netid));
		session.setAttribute("netid", ldao.getNetidfromreg(netid));
		if(count>0){
			
			if(ldao.getRolefromreg(netid).equals("Faculty")){
			
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
		    rd.forward(request,response);
			}else if(ldao.getRolefromreg(netid).equals("Staff")){
				
				RequestDispatcher rd=request.getRequestDispatcher("staffhome.jsp");
			    rd.forward(request,response);
				}else{
					RequestDispatcher rd=request.getRequestDispatcher("studenthome.jsp");
				    rd.forward(request,response);
				}
		    
		}else{
			request.setAttribute("loginerr", "Sorry error in login credentials");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		    rd.forward(request,response);
		}
	
	}

}
