package model;

public class SupportClass {
    private String maSupport;
    private String hoTen;
    private String lopSinhHoat;
    private String soDienThoai;
    private String email;
    private String hinhAnh; // Optional: If you're adding an image field

    // Default constructor
    public SupportClass() {
    }

    // Parameterized constructor
    public SupportClass(String maSupport, String hoTen, String lopSinhHoat, String soDienThoai, String email, String hinhAnh) {
        this.maSupport = maSupport;
        this.hoTen = hoTen;
        this.lopSinhHoat = lopSinhHoat;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.hinhAnh = hinhAnh;
    }

    // Getters and Setters
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
        return lopSinhHoat;
    }

    public void setLopSinhHoat(String lopSinhHoat) {
        this.lopSinhHoat = lopSinhHoat;
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

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    // Optional: Override toString() for debugging/logging
    @Override
    public String toString() {
        return "SupportClass{" +
                "maSupport='" + maSupport + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", lopSinhHoat='" + lopSinhHoat + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", email='" + email + '\'' +
                ", hinhAnh='" + hinhAnh + '\'' +
                '}';
    }
}
