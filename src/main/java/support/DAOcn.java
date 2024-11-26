package support;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.SupportClass;
import support.DAOcn;
import support.DBConnect;
import support.UserJava;


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
	    conn = DBConnect.getConnection();
	    String sql = "SELECT * FROM user_login WHERE studentId = ? AND pass = ?";
	    try {
	        stm = conn.prepareStatement(sql);
	        stm.setString(1, user);
	        stm.setString(2, pass);
	        result = stm.executeQuery();
	        if (result.next()) {
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
	    } catch (Exception e) {
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
	        // Kết nối với cơ sở dữ liệu
	        conn = DBConnect.getConnection();
	        String sql = "SELECT * FROM Support";
	        stm = conn.prepareStatement(sql);
	        result = stm.executeQuery();
	        
	        // Lặp qua kết quả và thêm vào list
	        while (result.next()) {
	            userName.add(new SupportClass(
	                result.getInt("id"),
	                result.getString("maSupport"),
	                result.getString("hoTen"),
	                result.getString("diaChi"),
	                result.getString("soDienThoai"),
	                result.getString("email")
	            ));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        // Đảm bảo đóng kết nối
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
		//Doc du lieu tu Database luu vao List<Student>
		//1. Khai bao List<student> de luu du lieu 
		//List<UserJava> userName = new ArrayList<UserJava>();
		String sql = "SELECT * FROM Support \n"
				+ "where maSupport = ?\n";
		//3.Ket noi, truy van --> luu du lieu ve List Student
		try {
			
			
			stm = conn.prepareStatement(sql);
			stm.setString(1, maSupport);
//			stm.setString(2, pass);
			result = stm.executeQuery();
				
			while (result.next()) {
				return new SupportClass(
						result.getInt("id"),
						result.getString("maSupport"),
		                result.getString("hoTen"),
		                result.getString("diaChi"),
		                result.getString("soDienThoai"),
		                result.getString("email")
		                );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void addSupport(String maSupport, String hoTen, String diaChi, String soDienThoai, String email){
		conn = DBConnect.getConnection();
		//Doc du lieu tu Database luu vao List<Student>
		//1. Khai bao List<student> de luu du lieu 
		//List<UserJava> userName = new ArrayList<UserJava>();
		String sql = "insert into Support (maSupport, hoTen, diaChi, soDienThoai, email)\n"
				+ "values(?,?,?,?,?)\n";
		//3.Ket noi, truy van --> luu du lieu ve List Student
		try {
			
			stm = conn.prepareStatement(sql);
			stm.setString(1, maSupport);
			stm.setString(2, hoTen);
			stm.setString(3, diaChi);
			stm.setString(4, soDienThoai);
			stm.setString(5, email);
			stm.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		DAOcn dao = new DAOcn();
		List<SupportClass> list = dao.getAllSupportClass();
		for(SupportClass o : list) {
			System.out.println(o);
		}
	}
	
}
