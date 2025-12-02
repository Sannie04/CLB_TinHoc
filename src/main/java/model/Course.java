package model;

import java.sql.Date;
import java.util.List;
public class Course {
    private int maKhoaHoc;
    private String tenKhoaHoc;
    private String moTa;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String image;  // Image is the file name (e.g., "course_image.jpg")
    private List<ClassDetails> danhSachLop; // Danh sách lớp học
    // No-argument constructor
    public Course() {
        this.maKhoaHoc = 0;
        this.tenKhoaHoc = "";
        this.moTa = "";
        this.ngayBatDau = new Date(System.currentTimeMillis());
        this.ngayKetThuc = new Date(System.currentTimeMillis());
        this.image = "";
    }
    public List<ClassDetails> getDanhSachLop() {
        return danhSachLop;
    }

    public void setDanhSachLop(List<ClassDetails> danhSachLop) {
        this.danhSachLop = danhSachLop;
    }
    // Parameterized constructor
    public Course(int maKhoaHoc, String tenKhoaHoc, String moTa, Date ngayBatDau, Date ngayKetThuc, String image) {
        setMaKhoaHoc(maKhoaHoc);  // Ensure validation
        setTenKhoaHoc(tenKhoaHoc);  // Ensure validation
        this.moTa = moTa;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        setImage(image);  // Ensure validation
    }

    // Getters and setters with validation
    public int getMaKhoaHoc() {
        return maKhoaHoc;
    }

    public void setMaKhoaHoc(int maKhoaHoc) {
        if (maKhoaHoc > 0) {
            this.maKhoaHoc = maKhoaHoc;
        } else {
            throw new IllegalArgumentException("maKhoaHoc must be greater than 0");
        }
    }

    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        if (tenKhoaHoc != null && !tenKhoaHoc.trim().isEmpty()) {
            this.tenKhoaHoc = tenKhoaHoc;
        } else {
            throw new IllegalArgumentException("tenKhoaHoc cannot be null or empty");
        }
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        if (image == null || image.trim().isEmpty()) {
            this.image = "igame/logo.jpg";  // Đặt giá trị ảnh mặc định nếu ảnh là null hoặc rỗng
        } else {
            this.image = image;
        }
    }

    @Override
    public String toString() {
        return "Course{" +
                "maKhoaHoc=" + maKhoaHoc +
                ", tenKhoaHoc='" + tenKhoaHoc + '\'' +
                ", moTa='" + moTa + '\'' +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                ", image='" + image + '\'' +
                '}';
    }
}
