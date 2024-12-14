package model;

import java.util.List;

public class ClassDetails {
	private int maLopHoc; // Class ID
    private String tenLopHoc;
    private List<Student> students;
    private List<SupportClass> supports;
  

    // Getters và Setters
    public int getMaLopHoc() {
        return maLopHoc;
    }

    public void setMaLopHoc(int maLopHoc) {
        this.maLopHoc = maLopHoc;
    }

    public String getTenLopHoc() {
        return tenLopHoc;
    }

    public void setTenLopHoc(String tenLopHoc) {
        this.tenLopHoc = tenLopHoc;
    }
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<SupportClass> getSupports() {
        return supports;
    }

    public void setSupports(List<SupportClass> supports) {
        this.supports = supports;
    }
}
