package DAO;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.DAOcn;
import model.BCrypt;
import model.SupportClass;
import model.UserJava;


public class DAOcn{
	Connection conn = null;
	PreparedStatement stm = null;
	ResultSet result = null;
	public List<UserJava> getAllStudent(){
		//Doc du lieu tu Database luu vao List<Student>
		//1. Khai bao List<student> de luu du lieu 
		List<UserJava> userName = new ArrayList<UserJava>();
		
		//3.Ket noi, truy van --> luu du lieu ve List Student
		try {
			conn = DBConnect.getConnection();
			String sql = "select * from user_login";
			stm = conn.prepareStatement(sql);
			result = stm.executeQuery();
			
			while (result.next()) {
				userName.add(new UserJava(
						result.getInt("id"),
						result.getString("studentId"),
		                result.getString("username"),
		                result.getString("email"),
		                result.getString("so_dien_thoai"),
		                result.getString("ngay_sinh"),
		                result.getString("pass"))
		                );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userName;
	}
	@SuppressWarnings("unchecked")
	public UserJava login(String user, String pass) {
        conn = DBConnect.getConnection();  // Giả sử bạn có lớp DBConnect để kết nối DB
        String sql = "SELECT * FROM user_login WHERE studentId = ?"; // Không cần so sánh mật khẩu ngay trong câu lệnh SQL

        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, user);
            result = stm.executeQuery();

            if (result.next()) {
                String storedHashedPassword = result.getString("pass");  // Lấy mật khẩu đã mã hóa từ DB

                // Kiểm tra mật khẩu nhập vào với mật khẩu đã mã hóa trong DB
                if (BCrypt.checkpw(pass, storedHashedPassword)) {
                    return new UserJava(
                        result.getInt("id"),
                        result.getString("studentId"),
                        result.getString("username"),
                        result.getString("email"),
                        result.getString("so_dien_thoai"),
                        result.getString("ngay_sinh"),
                        result.getString("pass")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


	public UserJava checkUser(String user){
		conn = DBConnect.getConnection();
		//Doc du lieu tu Database luu vao List<Student>
		//1. Khai bao List<student> de luu du lieu 
		//List<UserJava> userName = new ArrayList<UserJava>();
		String sql = "SELECT * FROM user_login \n"
				+ "where studentId = ?\n";
		//3.Ket noi, truy van --> luu du lieu ve List Student
		try {
			
			
			stm = conn.prepareStatement(sql);
			stm.setString(1, user);
//			stm.setString(2, pass);
			result = stm.executeQuery();
				
			while (result.next()) {
				return new UserJava (result.getInt("id"),
		                result.getString("studentId"),
		                result.getString("username"),
		                result.getString("email"),
		                result.getString("so_dien_thoai"),
		                result.getString("ngay_sinh"),
		                result.getString("pass"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void signup(String studentId, String username, String eamil, String so_dien_thoai, String ngay_sinh,
			String pass){
		conn = DBConnect.getConnection();
		//Doc du lieu tu Database luu vao List<Student>
		//1. Khai bao List<student> de luu du lieu 
		//List<UserJava> userName = new ArrayList<UserJava>();
		String sql = "insert into user_login (studentId, username, email, so_dien_thoai, ngay_sinh, pass) \n"
				+ "values(?,?,?,?,?,?)\n";
		//3.Ket noi, truy van --> luu du lieu ve List Student
		try {
			
			stm = conn.prepareStatement(sql);
			stm.setString(1, studentId);
			stm.setString(2, username);
			stm.setString(3, eamil);
			stm.setString(4, so_dien_thoai);
			stm.setString(5, ngay_sinh);
			stm.setString(6, pass);
			stm.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public List<SupportClass> getAllSupportClass() {
	    List<SupportClass> userName = new ArrayList<SupportClass>();
	    try {
	        conn = DBConnect.getConnection();
	        String sql = "SELECT * FROM Support";
	        stm = conn.prepareStatement(sql);
	        result = stm.executeQuery();
	        
	        // Lặp qua kết quả và thêm vào list
	        while (result.next()) {
	            userName.add(new SupportClass(
	                result.getString("maSupport"),
	                result.getString("hoTen"),
	                result.getString("LopSinhHoat"),
	                result.getString("soDienThoai"),
	                result.getString("email"),
	                result.getString("HinhAnh") // Get the HinhAnh field
	            ));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (stm != null) stm.close();
	            if (result != null) result.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return userName;
	}

	public SupportClass checkSupport(String maSupport){
	    conn = DBConnect.getConnection();
	    String sql = "SELECT * FROM Support WHERE maSupport = ?";
	    try {
	        stm = conn.prepareStatement(sql);
	        stm.setString(1, maSupport);
	        result = stm.executeQuery();

	        if (result.next()) {
	            return new SupportClass(
	                result.getString("maSupport"),
	                result.getString("hoTen"),
	                result.getString("LopSinhHoat"),
	                result.getString("soDienThoai"),
	                result.getString("email"),
	                result.getString("HinhAnh") // Get the HinhAnh field
	            );
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	public void addSupport(SupportClass support) {
	    conn = DBConnect.getConnection();
	    String sql = "INSERT INTO Support (maSupport, hoTen, LopSinhHoat, SoDienThoai, Email, HinhAnh) VALUES (?, ?, ?, ?, ?, ?)";
	    try {
	        stm = conn.prepareStatement(sql);
	        stm.setString(1, support.getMaSupport());
	        stm.setString(2, support.getHoTen());
	        stm.setString(3, support.getLopSinhHoat());
	        stm.setString(4, support.getSoDienThoai());
	        stm.setString(5, support.getEmail());
	        stm.setString(6, support.getHinhAnh()); // Set the image path in the database
	        stm.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void editSupport(String maSupport, String hoTen, String lopSinhHoat, String soDienThoai, String email, String hinhAnh) {
	    conn = DBConnect.getConnection();
	    String sql = "UPDATE Support SET "
	            + "hoTen = ?, "
	            + "lopSinhHoat = ?, "
	            + "soDienThoai = ?, "
	            + "email = ?, "
	            + "hinhAnh = ? "
	            + "WHERE maSupport = ?;";

	    try {
	        stm = conn.prepareStatement(sql);
	        stm.setString(1, hoTen);
	        stm.setString(2, lopSinhHoat);
	        stm.setString(3, soDienThoai);
	        stm.setString(4, email);
	        stm.setString(5, hinhAnh);
	        stm.setString(6, maSupport);

	        int rowsAffected = stm.executeUpdate();
	        System.out.println("Rows updated: " + rowsAffected);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}



	public void delete(String maSupport){
		conn = DBConnect.getConnection();
		//Doc du lieu tu Database luu vao List<Student>
		//1. Khai bao List<student> de luu du lieu 
		//List<UserJava> userName = new ArrayList<UserJava>();
		String sql = "delete from Support\n"
				+ "where maSupport = ?";
		//3.Ket noi, truy van --> luu du lieu ve List Student
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, maSupport);
			stm.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public SupportClass getSupportByMaSupport(String maSupport) {
	    String sql = "SELECT * FROM Support WHERE maSupport = ?";
	    try {
	        conn = DBConnect.getConnection();
	        stm = conn.prepareStatement(sql);
	        stm.setString(1, maSupport);
	        result = stm.executeQuery();

	        if (result.next()) {
	            return new SupportClass(
	                result.getString("maSupport"),
	                result.getString("hoTen"),
	                result.getString("lopSinhHoat"),
	                result.getString("soDienThoai"),
	                result.getString("email"),
	                result.getString("HinhAnh")
	            );
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	
	public static void main(String[] args) {
		DAOcn dao = new DAOcn();
		List<SupportClass> list = dao.getAllSupportClass();
		for(SupportClass o : list) {
			System.out.println(o);
		}
	}
	
}