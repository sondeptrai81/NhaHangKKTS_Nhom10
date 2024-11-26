package dao;

import connectDB.ConnectDB;
import entity.HoaDon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class ThongKeDoanhThu_DAO {
    public static ObservableList<HoaDon> getListHDNVCur(String maNhanVien) {
        ObservableList<HoaDon> list = FXCollections.observableArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectDB.connect();  // Kết nối tới CSDL
            String query = "SELECT hd.maHD, kh.tenKH, kh.SDT, hd.NgayTaoHD, hd.GioDatBan, b.MaBan, hd.TongTien " +
                    "FROM HoaDon hd " +
                    "JOIN KhachHang kh ON hd.MaKH = kh.MaKH " +
                    "JOIN Ban b ON hd.MaBan = b.MaBan " +
                    "WHERE hd.trangThaiHoaDon = 'DA_THANH_TOAN' " +
                    "AND hd.MaNV = '" + maNhanVien + "'";

            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                String maHD = rs.getString("maHD");
                String tenKhachHang = rs.getString("tenKH");
                String sdt = rs.getString("SDT");
                sdt = (sdt == null) ? "Không" : sdt;
                Date ngayTaoHD = rs.getDate("NgayTaoHD");
                String maBan = rs.getString("MaBan");
                double tongTien = rs.getDouble("TongTien");

                HoaDon hoaDon = new HoaDon(maHD, tenKhachHang, sdt, ngayTaoHD.toLocalDate(), maBan, tongTien);
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
