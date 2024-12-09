package model;

import java.util.Date;
public class Course {
	  private int maKhoaHoc;
	    private String tenKhoaHoc;
	    private String moTa;
	    private Date ngayBatDau;
	    private Date ngayKetThuc;
	    private String image; // Thêm trường hinhAnh

	    public Course(int maKhoaHoc, String tenKhoaHoc, String moTa, Date ngayBatDau, Date ngayKetThuc, String image) {
	        this.maKhoaHoc = maKhoaHoc;
	        this.tenKhoaHoc = tenKhoaHoc;
	        this.moTa = moTa;
	        this.ngayBatDau = ngayBatDau;
	        this.ngayKetThuc = ngayKetThuc;
	        this.image = image;
	    }

	    // Getters
	    public int getMaKhoaHoc() {
	        return maKhoaHoc;
	    }

	    public String getTenKhoaHoc() {
	        return tenKhoaHoc;
	    }

	    public String getMoTa() {
	        return moTa;
	    }

	    public Date getNgayBatDau() {
	        return ngayBatDau;
	    }

	    public Date getNgayKetThuc() {
	        return ngayKetThuc;
	    }

	    public String getImage() {
	        return image; // Getter cho hinhAnh
	    }
	}