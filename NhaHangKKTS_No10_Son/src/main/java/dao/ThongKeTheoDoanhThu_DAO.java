package dao;

import connectDB.ConnectDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class ThongKeTheoDoanhThu_DAO {
    public ArrayList<ThongKeTheoDoanhThu_DAO> getListHoaDon() {
        ArrayList<ThongKeTheoDoanhThu_DAO> thongKeTheoDoanhThuDaoArrayList = new ArrayList<ThongKeTheoDoanhThu_DAO>();
        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT hd.maHD, " +
                    "ROW_NUMBER() OVER (ORDER BY hd.NgayTaoHD) AS STT, " +
                    "kh.tenKH, kh.SDT, hd.NgayTaoHD, hd.GioDatBan, b.MaBan " +
                    "FROM HoaDon hd " +
                    "JOIN KhachHang kh ON hd.MaKH = kh.MaKH " +
                    "JOIN Ban b ON hd.MaBan = b.MaBan";

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

