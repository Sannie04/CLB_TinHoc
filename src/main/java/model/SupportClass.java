package model;

public class SupportClass {
    private String maSupport;
    private String hoTen;
    private String LopSinhHoat;
    private String soDienThoai;
    private String email;
	public String getMaSupport() {
		return maSupport;
	}
	public void setMaSupport(String maSupport) {
		this.maSupport = maSupport;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public String getLopSinhHoat() {
		return LopSinhHoat;
	}
	public void setLopSinhHoat(String LopSinhHoat) {
		this.LopSinhHoat = LopSinhHoat;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public SupportClass(String maSupport, String hoTen, String LopSinhHoat, String soDienThoai,
			String email) {
		super();
		this.maSupport = maSupport;
		this.hoTen = hoTen;

		this.LopSinhHoat = LopSinhHoat;
		this.soDienThoai = soDienThoai;
		this.email = email;
	}
	public SupportClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SupportClass [maSupport=" + maSupport + ", hoTen=" + hoTen + ", LopSinhHoat="
				+ LopSinhHoat + ", soDienThoai=" + soDienThoai + ", email=" + email + "]";
	}
	
    
}
