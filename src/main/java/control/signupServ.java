package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DAOcn;
import model.UserJava;

/**
 * Servlet implementation class signupServ
 */
@WebServlet("/signupServ")
public class signupServ extends HttpServlet {
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
        String studentId = request.getParameter("studentId");
        String username = request.getParameter("name");
        String email = request.getParameter("email");
        String so_dien_thoai = request.getParameter("phone");
        String ngay_sinh = request.getParameter("dateOfBirth");
        String password = request.getParameter("password");
        
    	DAOcn dao = new DAOcn();
    	UserJava a = dao.checkUser(studentId);
    	if(a==null) {
    		dao.signup(studentId, username, email, so_dien_thoai, ngay_sinh, password);
    		request.getRequestDispatcher("login.jsp").forward(request, response);
    	}else {
    		request.setAttribute("mess1", "Wrong signup");
    		request.getRequestDispatcher("./register.jsp").forward(request, response);
    	}
    }

}
