package model;

import java.util.Date;

public class Student {
    private String MaSinhVien;  // Student ID
    private String HoTen;       // Full Name
    private String lopSinhHoat; // Class
    private String email;       // Email
    private String soDienThoai; // Phone Number
    private Date ngayThamGia;   // Joining Date

    // Default constructor
    public Student() {}

    // Parameterized constructor
    public Student(String maSinhVien, String hoTen, String lopSinhHoat, String email, String soDienThoai, Date ngayThamGia) {
        this.MaSinhVien = maSinhVien;
        this.HoTen = hoTen;
        this.lopSinhHoat = lopSinhHoat;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.ngayThamGia = ngayThamGia;
    }

    // Getters and setters
    public String getMaSinhVien() {
        return MaSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        MaSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getLopSinhHoat() {
        return lopSinhHoat;
    }

    public void setLopSinhHoat(String lopSinhHoat) {
        this.lopSinhHoat = lopSinhHoat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Date getNgayThamGia() {
        return ngayThamGia;
    }

    public void setNgayThamGia(Date ngayThamGia) {
        this.ngayThamGia = ngayThamGia;
    }

    // toString method
    @Override
    public String toString() {
        return "Student{" +
                "MaSinhVien='" + MaSinhVien + '\'' +
                ", HoTen='" + HoTen + '\'' +
                ", lopSinhHoat='" + lopSinhHoat + '\'' +
                ", email='" + email + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", ngayThamGia=" + ngayThamGia +
                '}';
    }
}
