CREATE TABLE sinhvien (
    MaSinhVien VARCHAR(20) PRIMARY KEY,
    HoTen VARCHAR(50),
    LopSinhHoat VARCHAR(50),
    Email VARCHAR(50),
    SoDienThoai VARCHAR(15),
    NgayThamGia DATE
);
INSERT INTO sinhvien (MaSinhVien, HoTen, LopSinhHoat, Email, SoDienThoai, NgayThamGia) 
VALUES 
('SV001', 'Nguyen Van A', '23CNTT1', 'nguyenvana@example.com', '0912345678', '2023-09-01'),
('SV002', 'Tran Thi B', '23CNTT1', 'tranthib@example.com', '0912345679', '2023-09-01'),
('SV003', 'Le Van C', '24CNTT1', 'levanc@example.com', '0912345680', '2023-09-01'),
('SV004', 'Pham Thi D', '24CNTT2', 'phamthid@example.com', '0912345681', '2023-09-01'),
('SV005', 'Nguyen Thi E', '23CNTT1', 'nguyenthie@example.com', '0912345686', '2023-09-01'),
('SV006', 'Tran Van F', '24CNTT1', 'tranvanf@example.com', '0912345687', '2023-09-01'),
('SV007', 'Le Thi G', '24CNTT2', 'lethig@example.com', '0912345688', '2023-09-01'),
('SV008', 'Pham Van H', '23CNTT1', 'phamvanh@example.com', '0912345689', '2023-09-01'),
('SV009', 'Hoang Thi I', '24CNTT1', 'hoangthii@example.com', '0912345690', '2023-09-01'),
('SV010', 'Bui Van J', '24CNTT2', 'buivanj@example.com', '0912345691', '2023-09-01');
CREATE TABLE support (
    MaSupport VARCHAR(20) PRIMARY KEY,
    HoTen VARCHAR(100),
    Email VARCHAR(100),
    LopSinhHoat VARCHAR(50),
    SoDienThoai VARCHAR(15),
    HinhAnh VARCHAR(255)
);
INSERT INTO support (MaSupport, HoTen, Email, LopSinhHoat, SoDienThoai, HinhAnh)
VALUES
('SUP001', 'Hoang Van E', 'hoangvane@example.com', '22CNTT2', '0912345682', 'image1'),
('SUP002', 'Do Thi F', 'dothif@example.com', '21CNTT1', '0912345683', 'image2'),
('SUP003', 'Bui Van G', 'buivang@example.com', '22CNTT2', '0912345684', 'image3'),
('SUP004', 'Ngo Thi H', 'ngothih@example.com', '21CNTT2', '0912345685', 'image4'),
('SUP005', 'Tran Van K', 'tranvank@example.com', '21CNTT1', '0912345692', 'image5'),
('SUP006', 'Nguyen Thi L', 'nguyenthil@example.com', '22CNTT2', '0912345693', 'image6'),
('SUP007', 'Le Van M', 'levanm@example.com', '21CNTT2', '0912345694', 'image7'),
('SUP008', 'Pham Thi N', 'phamthin@example.com', '22CNTT2', '0912345695', 'image8'),
('SUP009', 'Do Van O', 'dovano@example.com', '21CNTT1', '0912345696', 'image9'),
('SUP010', 'Hoang Thi P', 'hoangthip@example.com', '21CNTT2', '0912345697', 'image10');


CREATE TABLE khoahoc (
    MaKhoaHoc INT AUTO_INCREMENT PRIMARY KEY,
    TenKhoaHoc VARCHAR(100),
    MoTa TEXT,
    NgayBatDau DATE,
    NgayKetThuc DATE,
    image VARCHAR(255)
);
INSERT INTO khoahoc (TenKhoaHoc, MoTa, NgayBatDau, NgayKetThuc, image) 
VALUES 
('Java', 'Khóa học lập trình Java cơ bản đến nâng cao', '2024-01-01', '2024-06-01', 'java.png'),
('Python', 'Khóa học lập trình Python cho người mới bắt đầu', '2024-02-01', '2024-07-01', 'python.png'),
('C++', 'Khóa học lập trình C++ chuyên sâu', '2024-03-01', '2024-08-01', 'c++.png'),
('JavaScript', 'Khóa học lập trình JavaScript toàn diện', '2024-04-01', '2024-09-01', 'js.jpg'),
('React', 'Khóa học lập trình React và phát triển frontend', '2024-05-01', '2024-10-01', 'react.png');

CREATE TABLE lophoc (
    MaLopHoc INT AUTO_INCREMENT PRIMARY KEY,
    TenLopHoc VARCHAR(100),
    MaKhoaHoc INT,
    FOREIGN KEY (MaKhoaHoc) REFERENCES khoahoc(MaKhoaHoc)
);
INSERT INTO lophoc (TenLopHoc, MaKhoaHoc) 
VALUES 
('Lớp Java 1', 1),
('Lớp Java 2', 1),
('Lớp Python 1', 2),
('Lớp Python 2', 2),
('Lớp C++ 1', 3),
('Lớp C++ 2', 3),
('Lớp JavaScript 1', 4),
('Lớp JavaScript 2', 4),
('Lớp React 1', 5),
('Lớp React 2', 5);

CREATE TABLE ketqua (
    MaKetQua INT AUTO_INCREMENT PRIMARY KEY,
    MaSinhVien VARCHAR(20),
    MaLopHoc INT,
    DiemCuoiKy FLOAT,
    NgayCapNhat DATE,
    FOREIGN KEY (MaSinhVien) REFERENCES sinhvien(MaSinhVien),
    FOREIGN KEY (MaLopHoc) REFERENCES lophoc(MaLopHoc)
);
INSERT INTO ketqua (MaSinhVien, MaLopHoc, DiemCuoiKy, NgayCapNhat) 
VALUES 
('SV001', 1, 8.5, '2024-06-01'),
('SV002', 2, 7.0, '2024-06-01'),
('SV003', 3, 9.0, '2024-07-01'),
('SV004', 4, 6.5, '2024-07-01'),
('SV005', 5, 8.0, '2024-08-01'),
('SV006', 6, 9.5, '2024-08-01'),
('SV007', 7, 7.5, '2024-09-01'),
('SV008', 8, 6.0, '2024-09-01'),
('SV009', 9, 8.7, '2024-10-01'),
('SV010', 10, 9.2, '2024-10-01');

CREATE TABLE support_lophoc (
    MaSupport VARCHAR(20),
    MaLopHoc INT,
    PRIMARY KEY (MaSupport, MaLopHoc),
    FOREIGN KEY (MaSupport) REFERENCES support(MaSupport),
    FOREIGN KEY (MaLopHoc) REFERENCES lophoc(MaLopHoc)
);


INSERT INTO support_lophoc (MaSupport, MaLopHoc) 
VALUES 
('SUP001', 1),
('SUP002', 2),
('SUP003', 3),
('SUP004', 4),
('SUP005', 5),
('SUP006', 6),
('SUP007', 7),
('SUP008', 8),
('SUP009', 9),
('SUP010', 10);


CREATE TABLE diemthi (
    MaDiem INT AUTO_INCREMENT PRIMARY KEY,
    MaSinhVien VARCHAR(10),
    MaKhoaHoc INT,
    Diem FLOAT,
    LanThi INT,
    FOREIGN KEY (MaSinhVien) REFERENCES sinhvien(MaSinhVien),
    FOREIGN KEY (MaKhoaHoc) REFERENCES khoahoc(MaKhoaHoc)
);

INSERT INTO diemthi (MaSinhVien, MaKhoaHoc, Diem, LanThi) 
VALUES 
('SV001', 1, 8.5, 1),
('SV002', 2, 7.0, 1),
('SV003', 3, 9.0, 1),
('SV004', 4, 6.5, 1),
('SV005', 5, 8.0, 1),
('SV006', 1, 9.5, 1),
('SV007', 2, 7.5, 1),
('SV008', 3, 6.0, 1),
('SV009', 4, 8.7, 1),
('SV010', 5, 9.2, 1);
CREATE TABLE user_login (  
	id INT AUTO_INCREMENT PRIMARY KEY,
	studentId VARCHAR(20) NOT NULL,  
    username VARCHAR(50) NOT NULL,  
    email VARCHAR(100) NOT NULL,  
    so_dien_thoai VARCHAR(15) NOT NULL,  
    ngay_sinh DATE NOT NULL,  
    pass VARCHAR(100) NOT NULL
);
insert into user_login (studentId, username, email, so_dien_thoai, ngay_sinh, pass)
VALUES 
('admin','sinhvien1', 'hihi@gmail.com', '0987265612', '2000-03-12', '123'),
('hiu','sinhvien2', 'hi@gmail.com', '0983652412', '2000-05-08', '111');