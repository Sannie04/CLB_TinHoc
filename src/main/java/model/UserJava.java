package model;

public class UserJava {
	private int id;
	private String studentId;
	private String username;
	private String eamil;
	private String so_dien_thoai;
	private String ngay_sinh;
	private String pass;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	public String getSo_dien_thoai() {
		return so_dien_thoai;
	}
	public void setSo_dien_thoai(String so_dien_thoai) {
		this.so_dien_thoai = so_dien_thoai;
	}
	public String getNgay_sinh() {
		return ngay_sinh;
	}
	public void setNgay_sinh(String ngay_sinh) {
		this.ngay_sinh = ngay_sinh;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public UserJava(int id, String studentId, String username, String eamil, String so_dien_thoai, String ngay_sinh,
			String pass) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.username = username;
		this.eamil = eamil;
		this.so_dien_thoai = so_dien_thoai;
		this.ngay_sinh = ngay_sinh;
		this.pass = pass;
	}
	public UserJava() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserJava [id=" + id + ", studentId=" + studentId + ", username=" + username + ", eamil=" + eamil
				+ ", so_dien_thoai=" + so_dien_thoai + ", ngay_sinh=" + ngay_sinh + ", pass=" + pass + "]";
	}
	
	
}
