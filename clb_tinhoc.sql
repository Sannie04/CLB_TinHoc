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
('SV010', 'Bui Van J', '24CNTT2', 'buivanj@example.com', '0912345691', '2023-09-01'),
('SV011', 'Nguyen Thi K', '23CNTT1', 'nguyenthik@example.com', '0912345698', '2023-09-01'),
('SV012', 'Tran Thi L', '23CNTT2', 'tranthil@example.com', '0912345699', '2023-09-01'),
('SV013', 'Le Thi M', '24CNTT1', 'lethim@example.com', '0912345700', '2023-09-01'),
('SV014', 'Pham Thi N', '24CNTT2', 'phamthin@example.com', '0912345701', '2023-09-01'),
('SV015', 'Nguyen Thi O', '23CNTT1', 'nguyenthio@example.com', '0912345702', '2023-09-01'),
('SV016', 'Tran Thi P', '23CNTT1', 'tranthip@example.com', '0912345703', '2023-09-01'),
('SV017', 'Le Thi Q', '24CNTT2', 'lethiq@example.com', '0912345704', '2023-09-01'),
('SV018', 'Pham Thi R', '23CNTT1', 'phamthir@example.com', '0912345705', '2023-09-01'),
('SV019', 'Nguyen Thi S', '24CNTT2', 'nguyenthis@example.com', '0912345706', '2023-09-01'),
('SV020', 'Tran Thi T', '23CNTT1', 'tranthit@example.com', '0912345707', '2023-09-01'),
('SV021', 'Le Thi U', '24CNTT1', 'lethiu@example.com', '0912345708', '2023-09-01'),
('SV022', 'Pham Thi V', '23CNTT2', 'phamthiv@example.com', '0912345709', '2023-09-01'),
('SV023', 'Nguyen Thi W', '24CNTT1', 'nguyenthiw@example.com', '0912345710', '2023-09-01'),
('SV024', 'Tran Thi X', '23CNTT2', 'tranthix@example.com', '0912345711', '2023-09-01'),
('SV025', 'Le Thi Y', '24CNTT1', 'lethiy@example.com', '0912345712', '2023-09-01'),
('SV026', 'Pham Thi Z', '23CNTT2', 'phamthiz@example.com', '0912345713', '2023-09-01'),
('SV027', 'Nguyen Thi AA', '24CNTT1', 'nguyenthiaa@example.com', '0912345714', '2023-09-01'),
('SV028', 'Tran Thi BB', '23CNTT2', 'tranthibb@example.com', '0912345715', '2023-09-01'),
('SV029', 'Le Thi CC', '24CNTT1', 'lethicc@example.com', '0912345716', '2023-09-01'),
('SV030', 'Pham Thi DD', '23CNTT2', 'phamthidd@example.com', '0912345717', '2023-09-01');
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
('SUP001', 'Hoang Van E', 'hoangvane@example.com', '22CNTT2', '0912345682', 'image1.jpg'),
('SUP002', 'Do Thi F', 'dothif@example.com', '21CNTT1', '0912345683', 'image2.jpg'),
('SUP003', 'Bui Van G', 'buivang@example.com', '22CNTT2', '0912345684', 'image3.jpg'),
('SUP004', 'Ngo Thi H', 'ngothih@example.com', '21CNTT2', '0912345685', 'image4.jpg'),
('SUP005', 'Tran Van K', 'tranvank@example.com', '21CNTT1', '0912345692', 'image5.jpg'),
('SUP006', 'Nguyen Thi L', 'nguyenthil@example.com', '22CNTT2', '0912345693', 'image6..jpg'),
('SUP007', 'Le Van M', 'levanm@example.com', '21CNTT2', '0912345694', 'image7.jpg'),
('SUP008', 'Pham Thi N', 'phamthin@example.com', '22CNTT2', '0912345695', 'image8.jpg'),
('SUP009', 'Do Van O', 'dovano@example.com', '21CNTT1', '0912345696', 'image9.jpg'),
('SUP010', 'Hoang Thi P', 'hoangthip@example.com', '21CNTT2', '0912345697', 'image10.jpg'),
('SUP011', 'Nguyen Thi Q', 'nguyenthioq@example.com', '22CNTT2', '0912345703', 'image11.jpg'),
('SUP012', 'Bui Thi R', 'buithir@example.com', '21CNTT1', '0912345704', 'image12.jpg'),
('SUP013', 'Tran Thi S', 'tranthis@example.com', '22CNTT2', '0912345705', 'image13.jpg'),
('SUP014', 'Le Thi T', 'lethit@example.com', '21CNTT1', '0912345706', 'image14.jpg'),
('SUP015', 'Hoang Thi U', 'hoangthiu@example.com', '22CNTT1', '0912345707', 'image15.jpg'),
('SUP016', 'Nguyen Thi V', 'nguyenthiv@example.com', '21CNTT1', '0912345708', 'image16.jpg'),
('SUP017', 'Bui Thi W', 'buithiw@example.com', '22CNTT2', '0912345709', 'image17.jpg'),
('SUP018', 'Tran Thi X', 'tranthix@example.com', '21CNTT1', '0912345710', 'image18.jpg'),
('SUP019', 'Le Thi Y', 'lethiy@example.com', '22CNTT2', '0912345711', 'image19.jpg'),
('SUP020', 'Hoang Thi Z', 'hoangthiz@example.com', '21CNTT1', '0912345712', 'image20.jpg'),
('SUP021', 'Nguyen Thi AA', 'nguyenthiaa@example.com', '22CNTT1', '0912345713', 'image21.jpg'),
('SUP022', 'Bui Thi BB', 'buithibb@example.com', '21CNTT1', '0912345714', 'image22.jpg'),
('SUP023', 'Tran Thi CC', 'tranthicc@example.com', '22CNTT2', '0912345715', 'image23.jpg'),
('SUP024', 'Le Thi DD', 'lethidd@example.com', '21CNTT1', '0912345716', 'image24.jpg'),
('SUP025', 'Hoang Thi EE', 'hoangthiee@example.com', '22CNTT1', '0912345717', 'image25.jpg'),
('SUP026', 'Nguyen Thi FF', 'nguyenthiff@example.com', '21CNTT1', '0912345718', 'image26.jpg'),
('SUP027', 'Bui Thi GG', 'buithigg@example.com', '22CNTT2', '0912345719', 'image27.jpg'),
('SUP028', 'Tran Thi HH', 'tranthihh@example.com', '21CNTT1', '0912345720', 'image28.jpg'),
('SUP029', 'Le Thi II', 'lethiii@example.com', '22CNTT2', '0912345721', 'image29.jpg'),
('SUP030', 'Hoang Thi JJ', 'hoangthijj@example.com', '21CNTT1', '0912345722', 'image30.jpg');


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
('SV010', 10, 9.2, '2024-10-01'),
('SV011', 1, 8.3, '2024-06-01'),
('SV012', 2, 7.5, '2024-06-01'),
('SV013', 3, 9.0, '2024-07-01'),
('SV014', 4, 6.8, '2024-07-01'),
('SV015', 5, 8.1, '2024-08-01'),
('SV016', 6, 9.2, '2024-08-01'),
('SV017', 7, 7.4, '2024-09-01'),
('SV018', 8, 6.7, '2024-09-01'),
('SV019', 9, 8.9, '2024-10-01'),
('SV020', 10, 9.0, '2024-10-01'),
('SV021', 1, 8.6, '2024-06-01'),
('SV022', 2, 7.9, '2024-06-01'),
('SV023', 3, 9.3, '2024-07-01'),
('SV024', 4, 6.2, '2024-07-01'),
('SV025', 5, 8.4, '2024-08-01'),
('SV026', 6, 9.5, '2024-08-01'),
('SV027', 7, 7.8, '2024-09-01'),
('SV028', 8, 6.3, '2024-09-01'),
('SV029', 9, 8.6, '2024-10-01'),
('SV030', 10, 9.1, '2024-10-01');

CREATE TABLE student_lophoc (
    MaSinhVien VARCHAR(20),
    MaLopHoc INT,
    PRIMARY KEY (MaSinhVien, MaLopHoc),
    FOREIGN KEY (MaSinhVien) REFERENCES sinhvien(MaSinhVien),
    FOREIGN KEY (MaLopHoc) REFERENCES lophoc(MaLopHoc)
);
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
('SUP010', 10),
('SUP011', 1),
('SUP012', 2),
('SUP013', 3),
('SUP014', 4),
('SUP015', 5),
('SUP016', 6),
('SUP017', 7),
('SUP018', 8),
('SUP019', 9),
('SUP020', 10),
('SUP021', 1),
('SUP022', 2),
('SUP023', 3),
('SUP024', 4),
('SUP025', 5),
('SUP026', 6),
('SUP027', 7),
('SUP028', 8),
('SUP029', 9),
('SUP030', 10);


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
('SV010', 5, 9.2, 1),
('SV011', 1, 8.3, 1),
('SV012', 2, 7.5, 1),
('SV013', 3, 9.0, 1),
('SV014', 4, 6.8, 1),
('SV015', 5, 8.1, 1),
('SV016', 1, 9.2, 1),
('SV017', 2, 7.4, 1),
('SV018', 3, 6.7, 1),
('SV019', 4, 8.9, 1),
('SV020', 5, 9.0, 1),
('SV021', 1, 8.6, 1),
('SV022', 2, 7.9, 1),
('SV023', 3, 9.3, 1),
('SV024', 4, 6.2, 1),
('SV025', 5, 8.4, 1),
('SV026', 1, 9.5, 1),
('SV027', 2, 7.8, 1),
('SV028', 3, 6.3, 1),
('SV029', 4, 8.6, 1),
('SV030', 5, 9.1, 1);
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
