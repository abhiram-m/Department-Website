package seterm.controller;
import seterm.dao.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
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
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String netid = request.getParameter("netid");
		String password = request.getParameter("password");
		String joinyear = null;
		String program = null;
		String major = null;
		String phdsem =null;
		String role = request.getParameter("role");
		if(role.equals("Student")){
		 joinyear = request.getParameter("joinyear");
		 program = request.getParameter("program");
		 major = request.getParameter("major");
		  phdsem = request.getParameter("phdsem");
		}
		
		
		
		//System.out.println(firstname+lastname+netid+password+role+joinyear+password+program+major);
		if(role.equals("Student")){
			
			if(netid==""|| password==""|| firstname==""|| lastname==""||role==""||joinyear==""||program==""||major==""){
				request.setAttribute("registerfail", "Please fill all the fields!");
				RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
			    rd.forward(request,response);
			    return;
			}}else{
				joinyear = "none";
				program ="none";
				major="none";
		if(netid==""|| password==""|| firstname==""|| lastname==""||role==""){
			request.setAttribute("registerfail", "Please fill all the fields!");
			RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
		    rd.forward(request,response);
		    return;
		}
		}
		
		User u = new User();
		u.setFirstname(firstname);
		u.setLastname(lastname);
		u.setNetid(netid);
		u.setPassword(password);
		u.setRole(role);
		u.setJoinyear(joinyear);
		u.setProgram(program);
		u.setMajor(major);
		
		int count = u.saveUserinfo();
		if(program.equals("PhD")){
			u.savePhDName(phdsem);
		}
		
		if(count>0){
			request.setAttribute("registersuccess", "Resgistration Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		    rd.forward(request,response);
		}else{
			request.setAttribute("registerfail", "Resgistration Not Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
		    rd.forward(request,response);
			
		}
	}

}
