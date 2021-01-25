create database quan_ly_hoa_qua
use quan_ly_hoa_qua;

create table tblUser(
	IdUser int identity primary key,
    Username varchar(50) not null,
    Pass varchar(50) not null,
    Email varchar(100) not null,
    Phone varchar(20),
    Address varchar(500) not null,
    RoleType varchar(10)
);

create table tblNSX(
	IdNSX int identity primary key,
    TenNSX varchar(100) not null
	
);


create table tblSanPham
(
	IdSP int identity primary key,
    TenSP varchar(200) not null,
    Gia int not null,
    IdNSX int FOREIGN KEY REFERENCES tblNSX(IdNSX),
    LoaiSP varchar(100),
	
    
);

Alter table tblSanPham add DonVi varchar(20);

create table tblDonHang(
	IdDonHang int identity primary key, 
    IdUser int FOREIGN KEY REFERENCES tblUser(IdUser),
    NgayDat datetime not null,
    Phone varchar(20),
    TongTien int, 
    TrangThai varchar(20),
	

);

create table tblChiTiet(
	IdDonHang int FOREIGN KEY REFERENCES tblDonHang(IdDonHang),
    IdSP int FOREIGN KEY REFERENCES tblSanPham(IdSP),
    SoLuong int,
    Gia int,
    
);

insert into tblUser(Username, Pass, Email, Phone, Address, RoleType) values 
('admin', '1', 'admin@123', '123456', 'Ha noi', 'admin'),
('khach', '2', 'khach@123', '654321', 'Ha noi', 'customer');

insert into tblNSX (TenNSX) values 
('Truong An'), 
('Vinmart'), 
('Kinh Do'), 
('Viet Fruit'), 
('Nong san Viet');

insert into tblSanPham(TenSP, Gia, IdNSX, LoaiSP, DonVi) values 
('Tao', 10000, 1, 'Qua tuoi', 'kg'),
('Cam', 15000, 2, 'Qua tuoi', 'kg'),
('Buoi', 30000, 2, 'Qua tuoi', 'Qua'),
('Tulip', 100000, 3, 'Hoa tuoi', 'Bo'),
('Cuc', 20000, 5, 'Hoa tuoi', 'Bo');

select* from tblNSX