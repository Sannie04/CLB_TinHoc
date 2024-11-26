package support;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.SQLException;


import model.SupportClass;



/**
 * Servlet implementation class AddSupportServlet
 */
@WebServlet("/AddSupportServlet")
public class AddSupportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
        String maSupport = request.getParameter("maSupport");
        String hoTen = request.getParameter("hoTen");
        String diaChi = request.getParameter("diaChi");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");
        DAOcn dao = new DAOcn();
        SupportClass a = dao.checkSupport(maSupport);
        List<SupportClass> list = dao.getAllSupportClass();
        if(a==null) {
    		dao.addSupport(maSupport, hoTen, diaChi, soDienThoai, email);
    		request.getRequestDispatcher("./menuSupPort.jsp").forward(request, response);
    	}else {
    		request.getRequestDispatcher("./menuSupPort.jsp").forward(request, response);
    	}
        
    }
}
