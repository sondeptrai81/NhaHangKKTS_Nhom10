package dao;

import connectDB.ConnectDB;
import entity.HoaDon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;


public class ThongKeTheoDoanhThu_DAO {
    public static ObservableList<HoaDon> getHoaDonDoneList() {
        ObservableList<HoaDon> list = FXCollections.observableArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectDB.connect();  // Kết nối tới CSDL
            String query = "SELECT hd.maHD, " +
                    "kh.tenKH, kh.SDT, hd.NgayTaoHD, hd.GioDatBan, b.MaBan, nv.tenNV, hd.TongTien " +
                    "FROM HoaDon hd " +
                    "JOIN KhachHang kh ON hd.MaKH = kh.MaKH " +
                    "JOIN Ban b ON hd.MaBan = b.MaBan " +
                    "JOIN NhanVien nv ON hd.MaNV = nv.MaNV " +
                    "WHERE hd.trangThaiHoaDon = 'DA_THANH_TOAN'";


            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                String maHD = rs.getString("maHD");
                String tenKhachHang = rs.getString("tenKH");
                String sdt = rs.getString("SDT");
                // Xử lý trường hợp số điện thoại null
                sdt = (sdt == null) ? "Không" : sdt;
                Date ngayTaoHD = rs.getDate("NgayTaoHD");
                String maBan = rs.getString("MaBan");
                String tenNhanVien = rs.getString("tenNV");
                double tongTien = rs.getDouble("TongTien");

                HoaDon hoaDon = new HoaDon(maHD, tenKhachHang, sdt, ngayTaoHD.toLocalDate(), maBan, tenNhanVien, tongTien);
                list.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }


}

