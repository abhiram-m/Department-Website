package seterm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seterm.dao.Resourcedao;

/**
 * Servlet implementation class AddResourceServlet
 */
@WebServlet("/AddResourceServlet")
public class AddResourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddResourceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String resourcename = request.getParameter("resourcename");
		String resourcetype = request.getParameter("resourcetype");
		String resourceinfo = request.getParameter("resourceinfo");
		
		if(resourcename==""||resourcetype==""||resourceinfo==""){
			
			request.setAttribute("addreserror", "Please add all info!");
			RequestDispatcher rd=request.getRequestDispatcher("addresource.jsp");
		    rd.forward(request,response);
			
		}
		
		
		Resourcedao rdao = new Resourcedao();
		int count = rdao.saveResource(resourcename, resourcetype, resourceinfo);
		
		if(count>0){
			
			request.setAttribute("addressuccess", "Resource Addition Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("addresource.jsp");
		    rd.forward(request,response);
		}else{
			request.setAttribute("addreserror", "Resource Addition Not Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("addresource.jsp");
		    rd.forward(request,response);
		}
	}

}
