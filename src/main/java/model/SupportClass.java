package model;

public class SupportClass {
	private int id;
    private String maSupport;
    private String hoTen;
    private String diaChi;
    private String soDienThoai;
    private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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
	public SupportClass(int id, String maSupport, String hoTen, String diaChi, String soDienThoai, String email) {
		super();
		this.id = id;
		this.maSupport = maSupport;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
	}
	public SupportClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SupportClass [id=" + id + ", maSupport=" + maSupport + ", hoTen=" + hoTen + ", diaChi=" + diaChi
				+ ", soDienThoai=" + soDienThoai + ", email=" + email + "]";
	}

    
}
