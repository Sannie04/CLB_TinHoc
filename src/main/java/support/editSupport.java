package support;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DAOcn;

/**
 * Servlet implementation class editSupport
 */
@WebServlet("/editSupport")
public class editSupport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editSupport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");

        String maSupport = request.getParameter("maSupport");
        String hoTen = request.getParameter("hoTen");
        String diaChi = request.getParameter("diaChi");
        String LopSinhHoat = request.getParameter("lopSinhHoat");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");
        DAOcn dao = new DAOcn();
        dao.editSupport(maSupport, hoTen, diaChi, LopSinhHoat, soDienThoai, email);
        response.sendRedirect("listSupport");
	}

}
