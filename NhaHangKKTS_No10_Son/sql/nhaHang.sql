USE [master]
GO
/****** Object:  Database [QLiNhaHang]    Script Date: 10/23/2024 3:25:38 PM ******/
CREATE DATABASE [QLiNhaHang]
 CONTAINMENT = NONE
 ON  PRIMARY
( NAME = N'QLiNhaHang', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\QLiNhaHang.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON
( NAME = N'QLiNhaHang_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\QLiNhaHang_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [QLiNhaHang] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLiNhaHang].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLiNhaHang] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [QLiNhaHang] SET ANSI_NULLS OFF
GO
ALTER DATABASE [QLiNhaHang] SET ANSI_PADDING OFF
GO
ALTER DATABASE [QLiNhaHang] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [QLiNhaHang] SET ARITHABORT OFF
GO
ALTER DATABASE [QLiNhaHang] SET AUTO_CLOSE ON
GO
ALTER DATABASE [QLiNhaHang] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [QLiNhaHang] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [QLiNhaHang] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [QLiNhaHang] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [QLiNhaHang] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [QLiNhaHang] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [QLiNhaHang] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [QLiNhaHang] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [QLiNhaHang] SET  ENABLE_BROKER
GO
ALTER DATABASE [QLiNhaHang] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [QLiNhaHang] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [QLiNhaHang] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [QLiNhaHang] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [QLiNhaHang] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [QLiNhaHang] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [QLiNhaHang] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [QLiNhaHang] SET RECOVERY SIMPLE
GO
ALTER DATABASE [QLiNhaHang] SET  MULTI_USER
GO
ALTER DATABASE [QLiNhaHang] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [QLiNhaHang] SET DB_CHAINING OFF
GO
ALTER DATABASE [QLiNhaHang] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF )
GO
ALTER DATABASE [QLiNhaHang] SET TARGET_RECOVERY_TIME = 60 SECONDS
GO
ALTER DATABASE [QLiNhaHang] SET DELAYED_DURABILITY = DISABLED
GO
ALTER DATABASE [QLiNhaHang] SET ACCELERATED_DATABASE_RECOVERY = OFF
GO
ALTER DATABASE [QLiNhaHang] SET QUERY_STORE = ON
GO
ALTER DATABASE [QLiNhaHang] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QLiNhaHang]
GO
/****** Object:  Table [dbo].[Ban]    Script Date: 10/23/2024 3:25:38 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ban](
    [maBan] [nvarchar](3) NOT NULL,
    [soLuongGhe] [int] NULL,
    [khuVuc] [nvarchar](50) NULL,
    [trangThaiBan] [nvarchar](50) NULL,
    PRIMARY KEY CLUSTERED
(
[maBan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[ChiTietHD_MonAn]    Script Date: 10/23/2024 3:25:38 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[ChiTietHD_MonAn](
    [maHD] [nvarchar](12) NULL,
    [maMonAn] [nvarchar](4) NULL,
    [soLuong] [int] NULL,
    [thanhTien] [float] NULL,
    [ghiChu] [nvarchar](500) NULL
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 10/23/2024 3:25:38 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[HoaDon](
    [maHD] [nvarchar](12) NOT NULL,
    [ngayTaoHD] [date] NULL,
    [trangThaiHoaDon] [nvarchar](50) NULL,
    [ngayDat] [date] NULL,
    [maBan] [nvarchar](3) NULL,
    [maNV] [nvarchar](12) NULL,
    [maKH] [nvarchar](11) NULL,
    [tienCoc] [float] NULL,
    [gioDatBan] [time](7) NULL,
    [maKM] [nvarchar](5) NULL,
    [tongTien] [float] NULL,
    PRIMARY KEY CLUSTERED
(
[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 10/23/2024 3:25:38 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[KhachHang](
    [maKH] [nvarchar](11) NOT NULL,
    [tenKH] [nvarchar](100) NULL,
    [sDT] [nvarchar](10) NULL,
    [diemTichLuy] [int] NULL,
    PRIMARY KEY CLUSTERED
(
[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 10/23/2024 3:25:38 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[KhuyenMai](
    [maKM] [nvarchar](5) NOT NULL,
    [tenKM] [nvarchar](100) NULL,
    [ngayHetHan] [date] NULL,
    [ngayBatDau] [date] NULL,
    [phanTramGiam] [float] NULL,
    PRIMARY KEY CLUSTERED
(
[maKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[LoaiMonAn]    Script Date: 10/23/2024 3:25:38 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[LoaiMonAn](
    [maLoai] [nvarchar](2) NOT NULL,
    [tenLoai] [nvarchar](100) NULL,
    PRIMARY KEY CLUSTERED
(
[maLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[MonAn]    Script Date: 10/23/2024 3:25:38 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[MonAn](
    [maMonAn] [nvarchar](4) NOT NULL,
    [tenMonAn] [nvarchar](50) NULL,
    [loaiMonAn] [nvarchar](50) NULL,
    [gia] [float] NULL,
    [trangThaiMonAn] [nvarchar](50) NULL,
    [VAT] [float] NULL,
    [maLoai] [nvarchar](2) NULL,
    [tenLoai] [nvarchar](100) NULL,
    [hinhAnh] [nvarchar](100) NULL,
    PRIMARY KEY CLUSTERED
(
[maMonAn] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 10/23/2024 3:25:38 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[NhanVien](
    [maNV] [nvarchar](12) NOT NULL,
    [tenNV] [nvarchar](100) NULL,
    [gioiTinh] [bit] NULL,
    [sDT] [nvarchar](10) NULL,
    [chucVu] [nvarchar](20) NULL,
    [trangThai] [nvarchar](50) NULL,
    [ngayVaoLam] [date] NULL,
    [ngayNghiLam] [date] NULL,
    [ngaySinh] [date] NULL,
    PRIMARY KEY CLUSTERED
(
[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 10/23/2024 3:25:38 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[TaiKhoan](
    [tenDangNhap] [nvarchar](12) NOT NULL,
    [matKhau] [nvarchar](50) NULL
    ) ON [PRIMARY]
    GO
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'A01', 2, N'A', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'A02', 1, N'A', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'A03', 2, N'A', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'A04', 2, N'A', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'A05', 2, N'A', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'A06', 2, N'A', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'A07', 1, N'A', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'A08', 1, N'A', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'A09', 2, N'A', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'A10', 2, N'A', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'A11', 1, N'A', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'A12', 1, N'A', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'A13', 2, N'A', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'A14', 2, N'A', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'A15', 2, N'A', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'B01', 5, N'B', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'B02', 4, N'B', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'B03', 6, N'B', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'B04', 3, N'B', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'B05', 3, N'B', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'B06', 3, N'B', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'B07', 5, N'B', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'B08', 6, N'B', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'B09', 4, N'B', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'B10', 4, N'B', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'B11', 3, N'B', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'B12', 5, N'B', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'B13', 5, N'B', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'B14', 4, N'B', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'B15', 6, N'B', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'C01', 7, N'C', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'C02', 8, N'C', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'C03', 7, N'C', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'C04', 10, N'C', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'C05', 8, N'C', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'C06', 8, N'C', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'C07', 11, N'C', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'C08', 9, N'C', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'C09', 7, N'C', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'C10', 9, N'C', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'C11', 8, N'C', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'C12', 11, N'C', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'C13', 11, N'C', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'C14', 12, N'C', N'TRONG')
    INSERT [dbo].[Ban] ([maBan], [soLuongGhe], [khuVuc], [trangThaiBan]) VALUES (N'C15', 8, N'C', N'TRONG')
    GO
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDA191004001', N'FO01', 10, 1000000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDA231024002', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDA231024003', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDA231024005', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDA231024006', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDA231024009', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDA231024010', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDA231024012', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDA231024013', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDA231024015', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDA231024016', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDA231024017', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDA231024019', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDA231024021', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDA231024025', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDA231024030', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDA231024037', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDA231024040', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDA231024041', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDA231024050', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDC231024049', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDB231024001', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDB231024007', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDB231024008', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDB231024011', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDB231024020', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDB231024024', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDB231024027', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDB231024028', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDB231024031', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDB231024032', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDB231024033', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDB231024034', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDB231024035', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDB231024036', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDB231024042', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDB231024046', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDB231024047', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDC231024004', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDC231024014', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDC231024018', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDC231024022', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDC231024023', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDC231024026', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDC231024029', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDC231024038', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDC231024039', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDC231024043', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDC231024044', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDC231024045', N'FO01', 1, 100000, NULL)
    INSERT [dbo].[ChiTietHD_MonAn] ([maHD], [maMonAn], [soLuong], [thanhTien], [ghiChu]) VALUES (N'HDC231024048', N'FO01', 1, 100000, NULL)
    GO
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDA191004001', CAST(N'2004-10-19' AS Date), N'CHUA_THANH_TOAN', CAST(N'2024-10-19' AS Date), N'A01', N'NVTN01012401', N'KH191024001', NULL, CAST(N'12:12:12' AS Time), N'KM001', NULL)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDA231024002', CAST(N'2024-10-23' AS Date), N'CHUA_THANH_TOAN', CAST(N'2024-10-03' AS Date), N'B13', N'NVTN01012401', N'KH231024016', 254229.74, CAST(N'19:05:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDA231024003', CAST(N'2024-10-23' AS Date), N'BI_HUY', CAST(N'2024-10-04' AS Date), N'B06', N'NVTN01012401', N'KH231024003', 278088.49, CAST(N'11:26:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDA231024005', CAST(N'2024-10-23' AS Date), N'DA_THANH_TOAN', CAST(N'2024-10-18' AS Date), N'C04', N'NVTN01012401', N'KH231024012', 421022.49, CAST(N'18:12:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDA231024006', CAST(N'2024-10-23' AS Date), N'CHUA_THANH_TOAN', CAST(N'2024-10-07' AS Date), N'C11', N'NVTN01012401', N'KH240424017', 119774.4, CAST(N'16:37:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDA231024009', CAST(N'2024-10-23' AS Date), N'CHUA_THANH_TOAN', CAST(N'2024-10-22' AS Date), N'C03', N'NVTN01012401', N'KH140224001', 332239.11, CAST(N'11:06:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDA231024010', CAST(N'2024-10-23' AS Date), N'CHUA_THANH_TOAN', CAST(N'2024-10-04' AS Date), N'A09', N'NVTN01012401', N'KH231024005', 367389.97, CAST(N'09:59:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDA231024012', CAST(N'2024-10-23' AS Date), N'DA_THANH_TOAN', CAST(N'2024-09-28' AS Date), N'C01', N'NVTN01012401', N'KH231024004', 237104.07, CAST(N'16:50:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDA231024013', CAST(N'2024-10-23' AS Date), N'DA_THANH_TOAN', CAST(N'2024-10-18' AS Date), N'A11', N'NVTN01012401', N'KH201024018', 170963.84, CAST(N'12:57:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDA231024015', CAST(N'2024-10-23' AS Date), N'CHUA_THANH_TOAN', CAST(N'2024-10-17' AS Date), N'C08', N'NVTN01012401', N'KH231024012', 198661.58, CAST(N'17:17:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDA231024016', CAST(N'2024-10-23' AS Date), N'BI_HUY', CAST(N'2024-10-22' AS Date), N'A12', N'NVTN01012401', N'KH201024018', 278741.88, CAST(N'16:30:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDA231024017', CAST(N'2024-10-23' AS Date), N'DA_THANH_TOAN', CAST(N'2024-10-09' AS Date), N'A06', N'NVTN01012401', N'KH231024013', 214755.65, CAST(N'21:54:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDA231024019', CAST(N'2024-10-23' AS Date), N'DA_THANH_TOAN', CAST(N'2024-10-05' AS Date), N'C05', N'NVTN01012401', N'KH231024009', 458918.11, CAST(N'21:27:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDA231024021', CAST(N'2024-10-23' AS Date), N'CHUA_THANH_TOAN', CAST(N'2024-10-04' AS Date), N'A05', N'NVTN01012401', N'KH231024013', 277719.23, CAST(N'16:18:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDA231024025', CAST(N'2024-10-23' AS Date), N'DA_THANH_TOAN', CAST(N'2024-10-16' AS Date), N'A14', N'NVTN01012401', N'KH000', 182532.66, CAST(N'10:40:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDA231024030', CAST(N'2024-10-23' AS Date), N'BI_HUY', CAST(N'2024-10-11' AS Date), N'C14', N'NVTN01012401', N'KH300424006', 67025.68, CAST(N'19:07:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDA231024037', CAST(N'2024-10-23' AS Date), N'BI_HUY', CAST(N'2024-10-06' AS Date), N'A14', N'NVTN01012401', N'KH231024011', 364522.21, CAST(N'21:51:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDA231024040', CAST(N'2024-10-23' AS Date), N'DA_THANH_TOAN', CAST(N'2024-09-26' AS Date), N'A14', N'NVTN01012401', N'KH231024013', 159844.8, CAST(N'09:14:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDA231024041', CAST(N'2024-10-23' AS Date), N'BI_HUY', CAST(N'2024-10-05' AS Date), N'C13', N'NVTN01012401', N'KH231024014', 89828.02, CAST(N'10:40:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDA231024050', CAST(N'2024-10-23' AS Date), N'CHUA_THANH_TOAN', CAST(N'2024-09-23' AS Date), N'C06', N'NVTN01012401', N'KH231024007', 152694.02, CAST(N'12:37:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDB231024001', CAST(N'2024-10-23' AS Date), N'DA_THANH_TOAN', CAST(N'2024-10-13' AS Date), N'B13', N'NVTN01012401', N'KH201024018', 216615.77, CAST(N'19:24:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDB231024007', CAST(N'2024-10-23' AS Date), N'CHUA_THANH_TOAN', CAST(N'2024-10-09' AS Date), N'A05', N'NVTN01012401', N'KH231024005', 276647.54, CAST(N'17:47:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDB231024008', CAST(N'2024-10-23' AS Date), N'BI_HUY', CAST(N'2024-10-09' AS Date), N'B03', N'NVTN01012401', N'KH231024005', 219776.98, CAST(N'21:54:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDB231024011', CAST(N'2024-10-23' AS Date), N'CHUA_THANH_TOAN', CAST(N'2024-09-26' AS Date), N'C04', N'NVTN01012401', N'KH231024007', 137146.82, CAST(N'14:11:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDB231024020', CAST(N'2024-10-23' AS Date), N'CHUA_THANH_TOAN', CAST(N'2024-10-20' AS Date), N'C09', N'NVTN01012401', N'KH300424006', 456822.69, CAST(N'17:15:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDB231024024', CAST(N'2024-10-23' AS Date), N'BI_HUY', CAST(N'2024-09-23' AS Date), N'B14', N'NVTN01012401', N'KH150624002', 202643.78, CAST(N'13:33:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDB231024027', CAST(N'2024-10-23' AS Date), N'DA_THANH_TOAN', CAST(N'2024-10-05' AS Date), N'B07', N'NVTN01012401', N'KH231024016', 281162.79, CAST(N'17:59:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDB231024028', CAST(N'2024-10-23' AS Date), N'DA_THANH_TOAN', CAST(N'2024-10-03' AS Date), N'C04', N'NVTN01012401', N'KH231024005', 121829.86, CAST(N'20:13:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDB231024031', CAST(N'2024-10-23' AS Date), N'DA_THANH_TOAN', CAST(N'2024-10-04' AS Date), N'B03', N'NVTN01012401', N'KH240424017', 449358.78, CAST(N'21:21:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDB231024032', CAST(N'2024-10-23' AS Date), N'BI_HUY', CAST(N'2024-10-10' AS Date), N'C05', N'NVTN01012401', N'KH231024015', 303389.37, CAST(N'15:34:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDB231024033', CAST(N'2024-10-23' AS Date), N'DA_THANH_TOAN', CAST(N'2024-10-06' AS Date), N'A12', N'NVTN01012401', N'KH230924008', 190232.04, CAST(N'17:26:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDB231024034', CAST(N'2024-10-23' AS Date), N'DA_THANH_TOAN', CAST(N'2024-09-30' AS Date), N'B10', N'NVTN01012401', N'KH231024013', 333837.67, CAST(N'20:33:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDB231024035', CAST(N'2024-10-23' AS Date), N'BI_HUY', CAST(N'2024-10-20' AS Date), N'A13', N'NVTN01012401', N'KH231024014', 281339.95, CAST(N'17:02:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDB231024036', CAST(N'2024-10-23' AS Date), N'BI_HUY', CAST(N'2024-10-15' AS Date), N'B06', N'NVTN01012401', N'KH300424006', 105848.09, CAST(N'18:12:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDB231024042', CAST(N'2024-10-23' AS Date), N'DA_THANH_TOAN', CAST(N'2024-09-30' AS Date), N'A11', N'NVTN01012401', N'KH140224001', 121816.54, CAST(N'20:27:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDB231024046', CAST(N'2024-10-23' AS Date), N'DA_THANH_TOAN', CAST(N'2024-10-11' AS Date), N'B13', N'NVTN01012401', N'KH231024016', 266251.97, CAST(N'16:50:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDB231024047', CAST(N'2024-10-23' AS Date), N'BI_HUY', CAST(N'2024-10-23' AS Date), N'C02', N'NVTN01012401', N'KH231024011', 142901.35, CAST(N'21:09:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDC231024004', CAST(N'2024-10-23' AS Date), N'DA_THANH_TOAN', CAST(N'2024-10-02' AS Date), N'C09', N'NVTN01012401', N'KH231024016', 456738.93, CAST(N'09:23:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDC231024014', CAST(N'2024-10-23' AS Date), N'BI_HUY', CAST(N'2024-09-27' AS Date), N'C14', N'NVTN01012401', N'KH121024019', 203557.41, CAST(N'18:00:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDC231024018', CAST(N'2024-10-23' AS Date), N'BI_HUY', CAST(N'2024-09-29' AS Date), N'B03', N'NVTN01012401', N'KH231024003', 127148.53, CAST(N'18:26:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDC231024022', CAST(N'2024-10-23' AS Date), N'CHUA_THANH_TOAN', CAST(N'2024-10-17' AS Date), N'C02', N'NVTN01012401', N'KH231024012', 139288.1, CAST(N'19:38:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDC231024023', CAST(N'2024-10-23' AS Date), N'BI_HUY', CAST(N'2024-10-18' AS Date), N'A05', N'NVTN01012401', N'KH140224001', 155295.41, CAST(N'21:41:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDC231024026', CAST(N'2024-10-23' AS Date), N'BI_HUY', CAST(N'2024-10-03' AS Date), N'B07', N'NVTN01012401', N'KH231024011', 496632.14, CAST(N'17:31:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDC231024029', CAST(N'2024-10-23' AS Date), N'BI_HUY', CAST(N'2024-10-05' AS Date), N'B13', N'NVTN01012401', N'KH231024010', 344505.2, CAST(N'20:51:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDC231024038', CAST(N'2024-10-23' AS Date), N'DA_THANH_TOAN', CAST(N'2024-09-30' AS Date), N'B01', N'NVTN01012401', N'KH150624002', 334000.28, CAST(N'18:06:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDC231024039', CAST(N'2024-10-23' AS Date), N'CHUA_THANH_TOAN', CAST(N'2024-10-07' AS Date), N'A03', N'NVTN01012401', N'KH150624002', 465803.88, CAST(N'10:42:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDC231024043', CAST(N'2024-10-23' AS Date), N'DA_THANH_TOAN', CAST(N'2024-09-25' AS Date), N'A14', N'NVTN01012401', N'KH240424017', 323416.13, CAST(N'09:39:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDC231024044', CAST(N'2024-10-23' AS Date), N'BI_HUY', CAST(N'2024-10-06' AS Date), N'A03', N'NVTN01012401', N'KH000', 123418.54, CAST(N'09:17:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDC231024045', CAST(N'2024-10-23' AS Date), N'BI_HUY', CAST(N'2024-10-10' AS Date), N'C04', N'NVTN01012401', N'KH141024020', 431782.42, CAST(N'12:25:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDC231024048', CAST(N'2024-10-23' AS Date), N'CHUA_THANH_TOAN', CAST(N'2024-10-22' AS Date), N'A15', N'NVTN01012401', N'KH231024011', 483963.36, CAST(N'20:36:00' AS Time), NULL, 100000)
    INSERT [dbo].[HoaDon] ([maHD], [ngayTaoHD], [trangThaiHoaDon], [ngayDat], [maBan], [maNV], [maKH], [tienCoc], [gioDatBan], [maKM], [tongTien]) VALUES (N'HDC231024049', CAST(N'2024-10-23' AS Date), N'CHUA_THANH_TOAN', CAST(N'2024-10-05' AS Date), N'A02', N'NVTN01012401', N'KH231024015', 147607.27, CAST(N'13:27:00' AS Time), NULL, 100000)
    GO
    INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sDT], [diemTichLuy]) VALUES (N'KH000', N'Khách Vãng Lai', NULL, 0)
    INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sDT], [diemTichLuy]) VALUES (N'KH121024019', N'Đỗ Thị Sang', N'0936469061', 708)
    INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sDT], [diemTichLuy]) VALUES (N'KH140224001', N'Lê Thành Giang', N'0390821110', 912)
    INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sDT], [diemTichLuy]) VALUES (N'KH141024020', N'Đỗ Thị Sang', N'0708903202', 703)
    INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sDT], [diemTichLuy]) VALUES (N'KH150624002', N'Lê Thành Giang', N'0889631484', 145)
    INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sDT], [diemTichLuy]) VALUES (N'KH191024001', N'Tống Diệm', N'0323456789', 0)
    INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sDT], [diemTichLuy]) VALUES (N'KH201024018', N'Võ Thị Mến', N'0871668578', 138)
    INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sDT], [diemTichLuy]) VALUES (N'KH230924008', N'Nguyễn Yến Ngọc', N'0700465131', 576)
    INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sDT], [diemTichLuy]) VALUES (N'KH231024003', N'Trần Thị Bình', N'0900508584', 233)
    INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sDT], [diemTichLuy]) VALUES (N'KH231024004', N'Lê Thành Giang', N'0312420566', 984)
    INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sDT], [diemTichLuy]) VALUES (N'KH231024005', N'Nguyễn Thị Em', N'0871785060', 973)
    INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sDT], [diemTichLuy]) VALUES (N'KH231024007', N'Nguyễn Thị Em', N'0720235118', 13)
    INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sDT], [diemTichLuy]) VALUES (N'KH231024009', N'Nguyễn Hữu Cường', N'0829896244', 210)
    INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sDT], [diemTichLuy]) VALUES (N'KH231024010', N'Đỗ Thị Sang', N'0378584246', 505)
    INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sDT], [diemTichLuy]) VALUES (N'KH231024011', N'Lê Hoàng Chung', N'0899252331', 745)
    INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sDT], [diemTichLuy]) VALUES (N'KH231024012', N'Hoàng Văn Phước', N'0917130027', 931)
    INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sDT], [diemTichLuy]) VALUES (N'KH231024013', N'Nguyễn Hữu Cường', N'0835513295', 140)
    INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sDT], [diemTichLuy]) VALUES (N'KH231024014', N'Trần Văn Liêm', N'0705825430', 530)
    INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sDT], [diemTichLuy]) VALUES (N'KH231024015', N'Doàn Thị Hạnh', N'0543500258', 693)
    INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sDT], [diemTichLuy]) VALUES (N'KH231024016', N'Lê Hoàng Chung', N'0705634418', 796)
    INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sDT], [diemTichLuy]) VALUES (N'KH240424017', N'Nguyễn Quỳnh Anh', N'0373445232', 546)
    INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sDT], [diemTichLuy]) VALUES (N'KH300424006', N'Chung Thoại Nga', N'0896223693', 383)
    GO
    INSERT [dbo].[KhuyenMai] ([maKM], [tenKM], [ngayHetHan], [ngayBatDau], [phanTramGiam]) VALUES (N'KM001', N'Ngày phụ nữ', CAST(N'2024-10-21' AS Date), CAST(N'2024-10-20' AS Date), 0.2)
    GO
    INSERT [dbo].[LoaiMonAn] ([maLoai], [tenLoai]) VALUES (N'AC', NULL)
    INSERT [dbo].[LoaiMonAn] ([maLoai], [tenLoai]) VALUES (N'FO', N'Thức ăn')
    GO
    INSERT [dbo].[MonAn] ([maMonAn], [tenMonAn], [loaiMonAn], [gia], [trangThaiMonAn], [VAT], [maLoai], [tenLoai], [hinhAnh]) VALUES (N'FO01', N'Gà rán', N'FO', 100000, N'SANCO', NULL, N'FO', N'Thức ăn', NULL)
    GO
    INSERT [dbo].[NhanVien] ([maNV], [tenNV], [gioiTinh], [sDT], [chucVu], [trangThai], [ngayVaoLam], [ngayNghiLam], [ngaySinh]) VALUES (N'NVTN01012401', N'Nguyễn Thanh Tú', 1, N'0312345678', N'Nhân Viên', N'DANG_LAM', CAST(N'2024-01-01' AS Date), NULL, NULL)
    GO
    INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau]) VALUES (N'NVTN01012401', N'1')
    GO
ALTER TABLE [dbo].[ChiTietHD_MonAn]  WITH CHECK ADD FOREIGN KEY([maHD])
    REFERENCES [dbo].[HoaDon] ([maHD])
    GO
ALTER TABLE [dbo].[ChiTietHD_MonAn]  WITH CHECK ADD FOREIGN KEY([maMonAn])
    REFERENCES [dbo].[MonAn] ([maMonAn])
    GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([maBan])
    REFERENCES [dbo].[Ban] ([maBan])
    GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([maKH])
    REFERENCES [dbo].[KhachHang] ([maKH])
    GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([maKM])
    REFERENCES [dbo].[KhuyenMai] ([maKM])
    GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([maNV])
    REFERENCES [dbo].[NhanVien] ([maNV])
    GO
ALTER TABLE [dbo].[MonAn]  WITH CHECK ADD FOREIGN KEY([maLoai])
    REFERENCES [dbo].[LoaiMonAn] ([maLoai])
    GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD FOREIGN KEY([tenDangNhap])
    REFERENCES [dbo].[NhanVien] ([maNV])
    GO
    USE [master]
    GO
ALTER DATABASE [QLiNhaHang] SET  READ_WRITE
GO
