package control;

import java.io.IOException;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.DAOcn;
import model.UserJava;

/**
 * Servlet implementation class loginServ
 * @param <DAO>
 */
@WebServlet("/loginServ")
public class loginServ<DAO> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
	    String username = request.getParameter("studentId");
	    String password = request.getParameter("password");
	    System.out.println("Received studentId: " + username);
	    System.out.println("Received password: " + password);

	    DAOcn dao = new DAOcn();
	    UserJava users = (UserJava) dao.login(username, password);
	    if (users == null) {
	        request.setAttribute("mess", "Wrong user or pass");
	        request.getRequestDispatcher("./login.jsp").forward(request, response);
	    } else {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("acc", users);
	    	session.setMaxInactiveInterval(1000);
	        //request.getRequestDispatcher("./Home.jsp").forward(request, response);
	        response.sendRedirect("Home.jsp");
	    }
	}

}
