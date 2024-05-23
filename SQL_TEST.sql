create database [DU_AN_MOT_TEST]
go
USE [DU_AN_MOT_TEST]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TAI_KHOAN](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ID_NV] [int] NULL,
	[TENDANGNHAP] [varchar](50) NULL,
	[MATKHAU] [varchar](50) NULL,
 CONSTRAINT [PK_TAI_KHOAN] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

/* Bảng Chất Liệu*/

CREATE TABLE [dbo].[CHAT_LIEU](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MA] [varchar](50) NULL,
	[TEN] [nvarchar](50) NULL,
 CONSTRAINT [PK_CHAT_LIEU] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

/*Bảng Kích Cỡ */


CREATE TABLE [dbo].[KICH_CO](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MA] [varchar](50) NULL,
	[KICHCO] [varchar](50) NULL,
 CONSTRAINT [PK_KICH_CO] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

/*Bảng Màu Sắc */


CREATE TABLE [dbo].[MAU_SAC](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MA] [varchar](50) NULL,
	[TEN] [nvarchar](50) NULL,
 CONSTRAINT [PK_MAU_SAC] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

/*Bảng Loại SP */


CREATE TABLE [dbo].[LOAISANPHAM](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MA] [varchar](50) NULL,
	[TEN] [nvarchar](250) NULL,
 CONSTRAINT [PK_LOAISANPHAM] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


/* Bảng Thương Hiệu */ 


CREATE TABLE [dbo].[THUONG_HIEU](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MA] [varchar](50) NULL,
	[TEN] [nvarchar](250) NULL,
 CONSTRAINT [PK_THUONG_HIEU] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

/* Bảng Khách Hàng */ 
CREATE TABLE [dbo].[KHACH_HANG](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MA] [varchar](50) NULL,
	[HOTEN] [nvarchar](250) NULL,
	[EMAIL] [nvarchar](250) NULL,
	[SDT] [varchar](50) NULL,
	[GIOTINH] [bit] NULL,
	[NGAYSINH] [date] NULL,
	[DIACHI] [nvarchar](250) NULL,
	[TRANGTHAI] [bit] NULL,
 CONSTRAINT [PK_KHACH_HANG] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

/* Bảng Nhân Viên */ 


CREATE TABLE [dbo].[NHAN_VIEN](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MA] [varchar](50) NULL,
	[HOTEN] [nvarchar](250) NULL,
	[GIOTINH] [bit] NULL,
	[SDT] [varchar](50) NULL,
	[CCCD] [varchar](50) NULL,
	[NGAYSINH] [datetime] NULL,
	[DIACHI] [nvarchar](250) NULL,
	[EMAIL] [varchar](250) NULL,
	[CHUCVU] [bit] NULL,
	[TRANGTHAI] [bit] NULL,
 CONSTRAINT [PK_NHAN_VIEN] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

/* Bảng Sản Phẩm */

CREATE TABLE [dbo].[SAN_PHAM](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MA] [varchar](50) NULL,
	[TEN] [nvarchar](250) NULL,
	[SOLUONG] [int] NULL,
 CONSTRAINT [PK_SAN_PHAM] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

/* Bảng Sản Phẩm Chi Tiết */ 


CREATE TABLE [dbo].[SAN_PHAM_CHI_TIET](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MA] [varchar](50) NULL,
	[MAVACH] [varchar](50) NULL,
	[MOTA] [nvarchar](250) NULL,
	[SOLUONG] [int] NULL,
	[ID_SP] [int] NULL,
	[ID_TH] [int] NULL,
	[ID_LSP] [int] NULL,
	[ID_KC] [int] NULL,
	[ID_MS] [int] NULL,
	[ID_CL] [int] NULL,
	[GIANHAP] [bigint] NULL,
	[GIABAN] [bigint] NULL,
	[TRANGTHAI] [bit] NULL,
 CONSTRAINT [PK_SAN_PHAM_CHI_TIET] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


/* Bảng Phiếu Giảm Giá */ 


CREATE TABLE [dbo].[PHIEU_GIAM_GIA_CHI_TIET](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MA] [varchar](50) NULL,
	[TEN] [nvarchar](250) NULL,
	[NGAYBATDAU] [datetime] NULL,
	[NGAYKETTHUC] [datetime] NULL,
	[LUOTSUDUNG] [int] NULL,
	[DIEUKHOAN] [nvarchar](250) NULL,
	[GIATRI] [bigint] NULL,
	[TRANGTHAI] [bit] NULL,
 CONSTRAINT [PK_PHIEU_GIAM_GIA_CHI_TIET] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
/* Bảng Hóa Đơn */ 


CREATE TABLE [dbo].[HOA_DON](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MA] [varchar](50) NULL,
	[ID_NV] [int] NULL,
	[ID_KH] [int] NULL,
	[MAPGG] [varchar](50) NULL,
	[NGAYTAO] [datetime] NULL,
	[NGAYTHANHTOAN] [datetime] NULL,
	[TIENGIAM] [bigint] NULL,
	[TONGTIEN] [bigint] NULL,
	[TIENKHACHDUA] [bigint] NULL,
	[TIENTHUA] [bigint] NULL,
	[TIENKHACHPHAITRA] [bigint] NULL,
	[HINHTHUCTHANHTOAN] [bit] NULL,
	[MACHUYENKHOAN] [varchar](50) NULL,
	[TRANGTHAI] [bit] NULL,
 CONSTRAINT [PK_HOA_DON] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

/*Bảng Hóa Đơn Chi Tiết */

CREATE TABLE [dbo].[HOA_DON_CT](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ID_HD] [int] NULL,
	[ID_SPCT] [int] NULL,
	[LOAISANPHAM] [nvarchar](250) NULL,
	[THUONGHIEU] [nvarchar](250) NULL,
	[MAUSAC] [nvarchar](250) NULL,
	[KICHCO] [nvarchar](250) NULL,
	[CHATLIEU] [nvarchar](250) NULL,
	[SOLUONG] [int] NULL,
	[DONGIA] [bigint] NULL,
 CONSTRAINT [PK_HOA_DON_CT] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[HOA_DON]  WITH CHECK ADD  CONSTRAINT [FK_HOA_DON_KHACH_HANG] FOREIGN KEY([ID_KH])
REFERENCES [dbo].[KHACH_HANG] ([ID])
GO
ALTER TABLE [dbo].[HOA_DON] CHECK CONSTRAINT [FK_HOA_DON_KHACH_HANG]
GO
ALTER TABLE [dbo].[HOA_DON]  WITH CHECK ADD  CONSTRAINT [FK_HOA_DON_NHAN_VIEN] FOREIGN KEY([ID_NV])
REFERENCES [dbo].[NHAN_VIEN] ([ID])
GO
ALTER TABLE [dbo].[HOA_DON] CHECK CONSTRAINT [FK_HOA_DON_NHAN_VIEN]
GO
ALTER TABLE [dbo].[HOA_DON_CT]  WITH CHECK ADD  CONSTRAINT [FK_HOA_DON_CT_HOA_DON] FOREIGN KEY([ID_HD])
REFERENCES [dbo].[HOA_DON] ([ID])
GO
ALTER TABLE [dbo].[HOA_DON_CT] CHECK CONSTRAINT [FK_HOA_DON_CT_HOA_DON]
GO
ALTER TABLE [dbo].[HOA_DON_CT]  WITH CHECK ADD  CONSTRAINT [FK_HOA_DON_CT_SAN_PHAM_CHI_TIET] FOREIGN KEY([ID_SPCT])
REFERENCES [dbo].[SAN_PHAM_CHI_TIET] ([ID])
GO
ALTER TABLE [dbo].[HOA_DON_CT] CHECK CONSTRAINT [FK_HOA_DON_CT_SAN_PHAM_CHI_TIET]
GO

ALTER TABLE [dbo].[SAN_PHAM_CHI_TIET]  WITH CHECK ADD  CONSTRAINT [FK_SAN_PHAM_CHI_TIET_CHAT_LIEU] FOREIGN KEY([ID_CL])
REFERENCES [dbo].[CHAT_LIEU] ([ID])
GO
ALTER TABLE [dbo].[SAN_PHAM_CHI_TIET] CHECK CONSTRAINT [FK_SAN_PHAM_CHI_TIET_CHAT_LIEU]
GO
ALTER TABLE [dbo].[SAN_PHAM_CHI_TIET]  WITH CHECK ADD  CONSTRAINT [FK_SAN_PHAM_CHI_TIET_KICH_CO] FOREIGN KEY([ID_KC])
REFERENCES [dbo].[KICH_CO] ([ID])
GO
ALTER TABLE [dbo].[SAN_PHAM_CHI_TIET] CHECK CONSTRAINT [FK_SAN_PHAM_CHI_TIET_KICH_CO]
GO
ALTER TABLE [dbo].[SAN_PHAM_CHI_TIET]  WITH CHECK ADD  CONSTRAINT [FK_SAN_PHAM_CHI_TIET_LOAISANPHAM] FOREIGN KEY([ID_LSP])
REFERENCES [dbo].[LOAISANPHAM] ([ID])
GO
ALTER TABLE [dbo].[SAN_PHAM_CHI_TIET] CHECK CONSTRAINT [FK_SAN_PHAM_CHI_TIET_LOAISANPHAM]
GO
ALTER TABLE [dbo].[SAN_PHAM_CHI_TIET]  WITH CHECK ADD  CONSTRAINT [FK_SAN_PHAM_CHI_TIET_MAU_SAC] FOREIGN KEY([ID_MS])
REFERENCES [dbo].[MAU_SAC] ([ID])
GO
ALTER TABLE [dbo].[SAN_PHAM_CHI_TIET] CHECK CONSTRAINT [FK_SAN_PHAM_CHI_TIET_MAU_SAC]
GO
ALTER TABLE [dbo].[SAN_PHAM_CHI_TIET]  WITH CHECK ADD  CONSTRAINT [FK_SAN_PHAM_CHI_TIET_SAN_PHAM] FOREIGN KEY([ID_SP])
REFERENCES [dbo].[SAN_PHAM] ([ID])
GO
ALTER TABLE [dbo].[SAN_PHAM_CHI_TIET] CHECK CONSTRAINT [FK_SAN_PHAM_CHI_TIET_SAN_PHAM]
GO
ALTER TABLE [dbo].[SAN_PHAM_CHI_TIET]  WITH CHECK ADD  CONSTRAINT [FK_SAN_PHAM_CHI_TIET_THUONG_HIEU] FOREIGN KEY([ID_TH])
REFERENCES [dbo].[THUONG_HIEU] ([ID])
GO
ALTER TABLE [dbo].[SAN_PHAM_CHI_TIET] CHECK CONSTRAINT [FK_SAN_PHAM_CHI_TIET_THUONG_HIEU]
GO
ALTER TABLE [dbo].[TAI_KHOAN]  WITH CHECK ADD  CONSTRAINT [FK_TAI_KHOAN_NHAN_VIEN] FOREIGN KEY([ID_NV])
REFERENCES [dbo].[NHAN_VIEN] ([ID])
GO
ALTER TABLE [dbo].[TAI_KHOAN] CHECK CONSTRAINT [FK_TAI_KHOAN_NHAN_VIEN]
GO

-- Chèn dữ liệu vào bảng CHAT_LIEU
INSERT INTO CHAT_LIEU (MA, TEN) VALUES
('CL001', N'Da'),
('CL002', N'Vải Cotton'),
('CL003', N'Nỉ'),
('CL004', N'Da Tổng Hợp'),
('CL005', N'Da Bò'),
('CL006', N'Da Lộn'),
('CL007', N'Vải Lưới');


-- Chèn dữ liệu vào bảng KICH_CO
INSERT INTO KICH_CO (MA, KICHCO) VALUES
('KC001', '35'),
('KC002', '36'),
('KC003', '37'),
('KC004', '38'),
('KC005', '39'),
('KC006', '40'),
('KC007', '41'),
('KC008', '42'),
('KC009', '43'),
('KC010', '44'),
('KC011', '45');


-- Chèn dữ liệu vào bảng MAU_SAC
INSERT INTO MAU_SAC (MA, TEN) VALUES
('MS001', N'Đen'),
('MS002', N'Trắng'),
('MS003', N'Đỏ'),
('MS004', N'Xanh'),
('MS005', N'Vàng'),
('MS006', N'Cam'),
('MS007', N'Be'),
('MS008', N'Xám'),
('MS009', N'Tím'),
('MS010', N'Hồng');

-- Chèn dữ liệu vào bảng LOAISANPHAM
INSERT INTO LOAISANPHAM (MA, TEN) VALUES
('LSP001', N'Giày Cao Cổ Dây Buộc'),
('LSP002', N'Giày Cao Cổ Dây Dán'),
('LSP003', N'Giày Cao Cổ Không Dây'),
('LSP004', N'Giày Thấp Cổ Dây Buộc'),
('LSP005', N'Giày Thấp Cổ Co Dán'),
('LSP006', N'Giày Thấp Cổ Không Dây'),
('LSP007', N'Giày Sục Lười');

-- Chèn dữ liệu vào bảng THUONG_HIEU
INSERT INTO THUONG_HIEU (MA, TEN) VALUES
('TH001', 'Nike'),
('TH002', 'Adidas'),
('TH003', 'Converse'),
('TH004', 'Puma'),
('TH005', 'Vans'),
('TH006', 'New Balance'),
('TH007', 'Reebok'),
('TH008', 'Under Armour'),
('TH009', 'Asics'),
('TH010', 'Fila');

-- Chèn dữ liệu vào bảng KHACH_HANG
INSERT INTO KHACH_HANG (MA, HOTEN, EMAIL, SDT, GIOTINH, NGAYSINH, DIACHI, TRANGTHAI) VALUES
('KH001', N'Nguyễn Văn A', 'nguyenvana@example.com', '0123456789', 1, '1990-01-01', N'Hà Nội', 1),
('KH002', N'Trần Thị B', 'tranthib@example.com', '0987654321', 0, '1995-05-05', N'Hồ Chí Minh', 1),
('KH003', N'Phạm Văn C', 'phamvanc@example.com', '0369852147', 1, '1988-12-25', N'Đà Nẵng', 1),
('KH004', N'Lê Thị D', 'lethid@example.com', '0527419638', 0, '1992-08-15', N'Hải Phòng', 1),
('KH005', N'Hoàng Văn E', 'hoangvane@example.com', '0147852369', 1, '1998-03-10', N'Cần Thơ', 1);
INSERT [dbo].[KHACH_HANG] ( [MA], [HOTEN], [EMAIL], [SDT], [GIOTINH], [NGAYSINH], [DIACHI], [TRANGTHAI]) VALUES ( N'KHL01', N'Khách Lẻ',null, null, null,null, null, 1)


-- Chèn dữ liệu vào bảng NHAN_VIEN
INSERT INTO NHAN_VIEN (MA, HOTEN, GIOTINH, SDT, CCCD, NGAYSINH, DIACHI, EMAIL, CHUCVU, TRANGTHAI) VALUES
('NV001', N'Trần Ngọc Quang', 1, '0987654321', '123456789012', '2000-01-01', N'Hà Nội', 'quangtnph3007@gmail.com', 0, 1),
('NV002', N'Trần Ngọc Lâm', 1, '0123456789', '987654321098', '1995-05-05', N'Hồ Chí Minh', 'lamtn@gmail.com',  1,1),
('NV003', N'Nguyễn Đình Thắng', 1, '0369852147', '456789012345', '1988-12-25', N'Đà Nẵng', 'thangnd@gmail.com', 1 ,1),
('NV004', N'Lê Công Vinh', 1, '0527419638', '789012345678', '1992-08-15', N'Hải Phòng', 'Vinhlc@gmail.com', 1, 1),
('NV005', N'Nguyễn Thu Trang', 0, '0147852369', '234567890123', '1998-03-10', N'Cần Thơ', 'trangnt@gmail.com', 1, 1);

-- Chèn dữ liệu vào bảng SAN_PHAM
INSERT INTO SAN_PHAM (MA, TEN, SOLUONG) VALUES
('SP001', N'Giày Nike Air Force 1', 50),
('SP002', N'Giày Adidas Superstar', 30),
('SP003', N'Giày Converse Chuck Taylor', 40),
('SP004', N'Giày Vans Old Skool', 35),
('SP005', N'Giày Puma RS-X', 25),
('SP006', N'Giày New Balance 574', 20),
('SP007', N'Giày Reebok Classic Leather', 15),
('SP008', N'Giày Under Armour HOVR Phantom', 10),
('SP009', N'Giày Asics Gel-Kayano', 28),
('SP010', N'Giày Fila Disruptor II', 32),
('SP011', N'Giày Nike Air Max 90', 45),
('SP012', N'Giày Adidas NMD', 18),
('SP013', N'Giày Converse One Star', 27),
('SP014', N'Giày Vans Authentic', 38),
('SP015', N'Giày Puma Suede Classic', 22),
('SP016', N'Giày New Balance 990', 29),
('SP017', N'Giày Reebok Club C', 33),
('SP018', N'Giày Under Armour Curry 8', 8),
('SP019', N'Giày Asics Gel-Lyte III', 17),
('SP020', N'Giày Fila Ray Tracer', 21),
('SP021', N'Giày Nike Air Jordan', 42),
('SP022', N'Giày Adidas Ultra Boost', 12),
('SP023', N'Giày Converse Jack Purcell', 24),
('SP024', N'Giày Vans Slip-On', 36),
('SP025', N'Giày Puma Clyde', 26),
('SP026', N'Giày New Balance 997', 31),
('SP027', N'Giày Reebok Nano X', 9),
('SP028', N'Giày Under Armour Project Rock', 14),
('SP029', N'Giày Asics Gel-Quantum', 19),
('SP030', N'Giày Fila Grant Hill 2', 23);


-- Chèn dữ liệu vào bảng SAN_PHAM_CHI_TIET
INSERT INTO SAN_PHAM_CHI_TIET (MA, MAVACH, MOTA, SOLUONG, ID_SP, ID_TH, ID_LSP, ID_KC, ID_MS, ID_CL, GIANHAP, GIABAN, TRANGTHAI) VALUES
('SP001', 'GV001', N'Giày Nike Air Force 1 - Đen/Trắng', 50, 1, 1, 1, 1, 1, 1, 1500000, 2000000, 1),
('SP002', 'GV002', N'Giày Adidas Superstar - Trắng/Đen', 30, 2, 2, 2, 2, 2, 2, 1200000, 1800000, 1),
('SP003', 'GV003', N'Giày Converse Chuck Taylor - Trắng', 40, 3, 3, 3, 3, 3, 3, 800000, 1300000, 1),
('SP004', 'GV004', N'Giày Vans Old Skool - Đen/Trắng', 35, 4, 4, 4, 4, 4, 4, 1000000, 1500000, 1),
('SP005', 'GV005', N'Giày Puma RS-X - Đỏ/Trắng/Đen', 25, 5, 5, 5, 5, 5, 5, 900000, 1400000, 1),
('SP006', 'GV006', N'Giày New Balance 574 - Xanh/Trắng', 20, 6, 6, 6, 6, 6, 6, 1100000, 1600000, 1),
('SP007', 'GV007', N'Giày Reebok Classic Leather - Trắng', 15, 7, 7, 7, 7, 7, 7, 950000, 1450000, 1),
('SP008', 'GV008', N'Giày Under Armour HOVR Phantom - Đen', 10, 8, 8, 1, 8, 8, 1, 1300000, 1900000, 1),
('SP009', 'GV009', N'Giày Asics Gel-Kayano - Xanh/Nâu', 28, 9, 9, 2, 2, 9, 2, 1250000, 1850000, 1),
('SP010', 'GV010', N'Giày Fila Disruptor II - Trắng/Đen', 32, 10, 10, 3, 10, 10, 3, 1050000, 1650000, 1),
('SP011', 'GV011', N'Giày Nike Air Max 90 - Trắng/Đỏ', 45, 11, 1, 4, 11, 1, 4, 1400000, 2000000, 1),
('SP012', 'GV012', N'Giày Adidas NMD - Đen/Trắng', 18, 12, 2, 5, 2, 2, 5, 1150000, 1750000, 1),
('SP013', 'GV013', N'Giày Converse One Star - Xanh', 27, 13, 3, 6,3, 3, 6, 1000000, 1550000, 1),
('SP014', 'GV014', N'Giày Vans Authentic - Đen', 38, 14, 4, 7, 7, 4, 7, 950000, 1450000, 1),
('SP015', 'GV015', N'Giày Puma Suede Classic - Nâu', 22, 15, 5, 1, 5, 5, 1, 1200000, 1800000, 1),
('SP016', 'GV016', N'Giày New Balance 990 - Xanh/Trắng', 29, 16, 6, 2, 6, 6, 2, 1300000, 1900000, 1),
('SP017', 'GV017', N'Giày Reebok Club C - Trắng/Đen', 33, 17, 7, 3, 7, 7, 3, 1150000, 1750000, 1),
('SP018', 'GV018', N'Giày Under Armour Curry 8 - Vàng', 8, 18, 8, 4, 8, 8, 4, 1350000, 1950000, 1),
('SP019', 'GV019', N'Giày Asics Gel-Lyte III - Xanh/Trắng', 17, 19, 9, 5, 9, 9, 5, 1250000, 1850000, 1),
('SP020', 'GV020', N'Giày Fila Ray Tracer - Trắng/Đen', 21, 20,10, 6, 10,10, 6, 1050000, 1650000, 1),
('SP021', 'GV021', N'Giày Nike Air Jordan - Đỏ/Trắng', 42, 21, 1, 7, 11, 1, 7, 1400000, 2000000, 1),
('SP022', 'GV022', N'Giày Adidas Ultra Boost - Đen/Trắng', 12, 22, 2,1 , 1, 2, 2, 1300000, 1900000, 1),
('SP023', 'GV023', N'Giày Converse Jack Purcell - Đen', 24, 23, 3, 2, 2, 3, 3, 950000, 1450000, 1),
('SP024', 'GV024', N'Giày Vans Slip-On - Đen/Trắng', 36, 24, 4, 3, 4, 4, 4, 1000000, 1550000, 1),
('SP025', 'GV025', N'Giày Puma Clyde - Đen/Vàng', 26, 25, 5, 4, 5, 5, 5, 1200000, 1800000, 1),
('SP026', 'GV026', N'Giày New Balance 997 - Xanh/Nâu', 31,  26, 6, 5, 6, 6, 6, 1300000, 1900000, 1),
('SP027', 'GV027', N'Giày Reebok Zig Kinetica - Đen', 19, 27, 7, 6, 7, 7, 7, 1250000, 1850000, 1),
('SP028', 'GV028', N'Giày Under Armour Project Rock - Xám', 14, 28, 8, 7, 8, 8, 2, 1350000, 1950000, 1),
('SP029', 'GV029', N'Giày Asics Gel-Nimbus - Đen/Trắng', 23, 29, 9, 2, 9, 9, 2, 1400000, 2000000, 1),
('SP030', 'GV030', N'Giày Fila Disruptor II Premium - Trắng', 16, 30, 10, 3, 10,10, 3, 1300000, 1900000, 1);



-- Chèn dữ liệu vào bảng PHIEU_GIAM_GIA_CHI_TIET
INSERT INTO PHIEU_GIAM_GIA_CHI_TIET (MA, TEN, NGAYBATDAU, NGAYKETTHUC, LUOTSUDUNG, DIEUKHOAN, GIATRI, TRANGTHAI) VALUES
('PGG001', N'Giảm giá 10% cho đợt sale mùa hè', '2024-06-01', '2024-06-30', 100, N'Áp dụng cho đợt sale mùa hè', 10, 1),
('PGG002', N'Giảm giá 20% cho sản phẩm mới', '2024-07-01', '2024-07-31', 200, N'Áp dụng cho các sản phẩm mới nhập về', 20, 1),
('PGG003', N'Giảm giá 15% cho thành viên VIP', '2024-08-01', '2024-08-31', 150, N'Chỉ áp dụng cho các thành viên VIP', 15, 1),
('PGG004', N'Giảm giá 30% cho các đơn hàng trên 3 triệu đồng', '2024-09-01', '2024-09-30', 300, N'Chỉ áp dụng cho đơn hàng trên 3 triệu đồng', 30, 1),
('PGG005', N'Giảm giá 25% cho sản phẩm cuối cùng còn lại', '2024-10-01', '2024-10-31', 250, N'Chỉ áp dụng cho sản phẩm còn lại cuối cùng trong kho', 25, 1),
('PGG006', N'Giảm giá 10% cho đợt sale mùa hè', '2024-05-01', '2024-06-30', 100, N'Áp dụng cho đợt sale mùa hè', 10, 1),
('PGG007', N'Giảm giá 20% cho sản phẩm mới', '2024-05-01', '2024-07-31', 200, N'Áp dụng cho các sản phẩm mới nhập về', 20, 1),
('PGG008', N'Giảm giá 15% cho thành viên VIP', '2024-05-01', '2024-08-31', 150, N'Chỉ áp dụng cho các thành viên VIP', 15, 1);

-- Chèn dữ liệu vào bảng HOA_DON
INSERT INTO HOA_DON (MA, ID_NV, ID_KH, MAPGG, NGAYTAO, NGAYTHANHTOAN, TIENGIAM, TONGTIEN, TIENKHACHDUA, TIENTHUA, TIENKHACHPHAITRA, HINHTHUCTHANHTOAN, MACHUYENKHOAN, TRANGTHAI) VALUES
('HD001', 1, 1, 'PGG001', '2024-06-15', '2024-06-15', 50000, 450000, 500000, 50000, 0, 1, 'CK001', 1),
('HD002', 2, 2, 'PGG002', '2024-07-10', '2024-07-10', 120000, 480000, 600000, 120000, 0, 1, 'CK002', 1),
('HD003', 3, 3, 'PGG003', '2024-08-20', '2024-08-20', 150000, 850000, 1000000, 150000, 0, 1, 'CK003', 1),
('HD004', 4, 4, 'PGG004', '2024-09-05', '2024-09-05', 300000, 1200000, 1500000, 300000, 0, 1, 'CK004', 1),
('HD005', 5, 5, 'PGG005', '2024-10-30', '2024-10-30', 200000, 800000, 1000000, 200000, 0, 1, 'CK005', 1),
('HD006', 3, 3, 'PGG003', '2024-08-20', '2024-08-20', 150000, 850000, 1000000, 150000, 0, 1, 'CK003', 0),
('HD007', 4, 4, 'PGG004', '2024-09-05', '2024-09-05', 300000, 1200000, 1500000, 300000, 0, 1, 'CK004', 0),
('HD008', 5, 5, 'PGG005', '2024-10-30', '2024-10-30', 200000, 800000, 1000000, 200000, 0, 1, 'CK005', 0);


-- Chèn dữ liệu vào bảng HOA_DON_CT
INSERT INTO HOA_DON_CT (ID_HD,ID_SPCT, LOAISANPHAM, THUONGHIEU, MAUSAC, KICHCO, CHATLIEU, SOLUONG, DONGIA)
VALUES
(6,1, 'Sneaker', 'Adidas', N'Trắng', '39', N'Da', 2, 1500000),
(6,2, 'Sneaker', 'Nike', N'Đen', '42', N'Vải', 1, 1800000),
(6,3, 'Sneaker', 'Puma', N'Xanh', '40', N'Da', 3, 1300000),
(7,4, 'Sneaker', 'Converse', N'Đen', '38', N'Vải', 1, 1200000),
(7,5, 'Sneaker', 'New Balance', N'Xám', '41', N'Vải', 2, 1700000),
(8,6, 'Sneaker', 'Reebok', N'Trắng', '37', N'Da', 1, 1600000),
(8,7, 'Sneaker', 'Vans', N'Đỏ', '39', N'Vải', 1, 1400000),
(1,1, 'Sneaker', 'Adidas', N'Trắng', '39', N'Da', 2, 1500000),
(1,2, 'Sneaker', 'Nike', N'Đen', '42', N'Vải', 1, 1800000),
(1,3, 'Sneaker', 'Puma', N'Xanh', '40', N'Da', 3, 1300000),
(2,4, 'Sneaker', 'Converse', N'Đen', '38', N'Vải', 1, 1200000),
(2,5, 'Sneaker', 'New Balance', N'Xám', '41', N'Vải', 2, 1700000),
(3,6, 'Sneaker', 'Reebok', N'Trắng', '37', N'Da', 1, 1600000),
(3,7, 'Sneaker', 'Vans', N'Đỏ', '39', N'Vải', 1, 1400000),
(4,8, 'Sneaker', 'Under Armour', N'Cam', '40', N'Da', 2, 1900000),
(5,9, 'Sneaker', 'Fila', N'Hồng', '38', N'Vải', 1, 1100000),
(5, 10,'Sneaker', 'Asics', 'Xanh', '42', N'Vải', 2, 2000000);
-- Chèn dữ liệu vào bảng TAI_KHOAN
INSERT INTO TAI_KHOAN (ID_NV, TENDANGNHAP, MATKHAU) VALUES
(1, 'quanly', N'827ccb0eea8a706c4c34a16891f84e7b'),
(2, 'nhanvien', N'827ccb0eea8a706c4c34a16891f84e7b'),
(3, 'nhanvien1', N'827ccb0eea8a706c4c34a16891f84e7b'),
(4, 'nhanvien2', N'827ccb0eea8a706c4c34a16891f84e7b'),
(5, 'nhanvien3', N'827ccb0eea8a706c4c34a16891f84e7b');
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
  create proc [dbo].[xoaKhachHang] @id int
as
begin
   begin try
       begin tran
	   delete from KHACH_HANG where ID=@id
       commit tran
   end try
   begin catch
       print N'Thao tác xóa thất bại'
       rollback tran -- Roll back nếu không xóa được
   end catch
end
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
 create proc [dbo].[xosHoaDon] @id int
as
begin
   begin try
       begin tran
       delete from HOA_DON_CT where ID_HD = @id
	   delete from HOA_DON where ID=@id
       commit tran
   end try
   begin catch
       print N'Thao tác xóa thất bại'
       rollback tran 
   end catch
end
GO

select ID, MA, HOTEN, EMAIL, SDT, GIOTINH, NGAYSINH, DIACHI, TRANGTHAI from KHACH_HANG
select * from SAN_PHAM
select * from SAN_PHAM_CHI_TIET
select * from HOA_DON where TRANGTHAI = 1
select * from HOA_DON_CT
select * from TAI_KHOAN
select * from THUONG_HIEU
select * from KICH_CO
select * from MAU_SAC
select * from CHAT_LIEU
select * from NHAN_VIEN
select * from KHACH_HANG
select * from LOAISANPHAM
select * from PHIEU_GIAM_GIA_CHI_TIET
 SELECT [ID]
                          ,[MA]
                          ,[TEN]
                          ,[NGAYBATDAU]
                          ,[NGAYKETTHUC]
                          ,[LUOTSUDUNG]
                          ,[DIEUKHOAN]
                          ,[GIATRI]
                          ,[TRANGTHAI]
                      FROM [dbo].[PHIEU_GIAM_GIA_CHI_TIET]
                    WHERE GETDATE() Between [NGAYBATDAU] and [NGAYKETTHUC]

SELECT SAN_PHAM_CHI_TIET.[ID]
                                                    ,SAN_PHAM_CHI_TIET.[MA]
                                                    ,[MAVACH]
                                                    ,[MOTA]
                                                    ,SAN_PHAM_CHI_TIET.[SOLUONG]
                                                    ,SAN_PHAM.[TEN] AS TENSANPHAM
                                                    ,THUONG_HIEU.[TEN] AS THUONGHIEU
                                                    ,LOAISANPHAM.[TEN] AS LOAISANPHAM
                                                    ,KICH_CO.[KICHCO] AS KICHCO
                                                    ,MAU_SAC.[TEN] AS MAUSAC
                                                    ,CHAT_LIEU.[TEN] AS CHATLIEU
                                                    ,[GIANHAP]
                                                    ,[GIABAN]
                                                    ,SAN_PHAM_CHI_TIET.[TRANGTHAI]
                                                FROM [dbo].[SAN_PHAM_CHI_TIET]
                                              	JOIN SAN_PHAM ON SAN_PHAM.ID=SAN_PHAM_CHI_TIET.ID_SP
                                              	JOIN THUONG_HIEU ON THUONG_HIEU.ID=SAN_PHAM_CHI_TIET.ID_TH
                                              	JOIN LOAISANPHAM ON LOAISANPHAM.ID=SAN_PHAM_CHI_TIET.ID_LSP
                                              	JOIN KICH_CO ON KICH_CO.ID=SAN_PHAM_CHI_TIET.ID_KC
                                              	JOIN MAU_SAC ON MAU_SAC.ID=SAN_PHAM_CHI_TIET.ID_MS
                                              	JOIN CHAT_LIEU ON CHAT_LIEU.ID=SAN_PHAM_CHI_TIET.ID_CL
                        			order by MA ASC


 SELECT GioHang.[ID]
                                           ,GioHang.[MA]
                                           ,SAN_PHAM.TEN 
                                        ,GioHang.[LOAISANPHAM]
                                        ,GioHang.[THUONGHIEU]
                                        ,GioHang.[MAUSAC]
                                        ,GioHang.[KICHCO]
                                           ,GioHang.[CHATLIEU]
                                           ,GioHang.[SOLUONG]
                                           ,GioHang.[DONGIA]
                                       FROM (SELECT HOA_DON_CT.[ID]
                                           ,HOA_DON.[MA]
                                           ,SAN_PHAM_CHI_TIET.[ID_SP] as TenSP
                  						 ,  [LOAISANPHAM]
                  						 ,  [THUONGHIEU]
                  						 ,  [MAUSAC]
                  						 ,  [KICHCO]
                  						 ,[CHATLIEU]
                                           ,HOA_DON_CT.[SOLUONG]
                                           ,[DONGIA]
                                       FROM [dbo].[HOA_DON_CT]
                                       join HOA_DON on HOA_DON.ID=HOA_DON_CT.ID_HD
                                       join SAN_PHAM_CHI_TIET on SAN_PHAM_CHI_TIET.ID=HOA_DON_CT.ID_SPCT
                                       join SAN_PHAM on SAN_PHAM.ID=SAN_PHAM_CHI_TIET.ID_SP) as GioHang
                                       join SAN_PHAM on SAN_PHAM.ID=GioHang.TenSP

									   SELECT [ID]
                         ,[ID_HD]
                         ,[ID_SPCT]
                         ,[LOAISANPHAM]
                         ,[THUONGHIEU]
                         ,[MAUSAC]
                         ,[KICHCO]
                         ,[CHATLIEU]
                         ,[SOLUONG]
                         ,[DONGIA]
                     FROM [dbo].[HOA_DON_CT]