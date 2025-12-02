package model;

public class Score {
    private String maSinhVien;
    private String tenKhoaHoc;
    private float diem;
    private int lanThi;
    private int maKhoaHoc;
    private String hoTen; // Thêm trường hoTen

    // Getter and Setter for maSinhVien
    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    // Getter and Setter for tenKhoaHoc
    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }

    // Getter and Setter for diem
    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    // Getter and Setter for lanThi
    public int getLanThi() {
        return lanThi;
    }

    public void setLanThi(int lanThi) {
        this.lanThi = lanThi;
    }

    // Getter and Setter for maKhoaHoc
    public int getMaKhoaHoc() {
        return maKhoaHoc;
    }

    public void setMaKhoaHoc(int maKhoaHoc) {
        this.maKhoaHoc = maKhoaHoc;
    }

    // Getter and Setter for hoTen
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
}
