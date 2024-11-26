package dao;

import entity.HoaDon;
import entity.NhanVien;
import entity.TrangThaiNhanVien;
import javafx.collections.ObservableList;

import java.sql.Connection;import connectDB.ConnectDB;
import javafx.collections.FXCollections;

import java.sql.*;


public class ThongKeTheoNhanVien_DAO {

    public static ObservableList<NhanVien> getListNhanVien() {
        ObservableList<NhanVien> list = FXCollections.observableArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectDB.connect();
            String query = "SELECT nv.maNV, " +
                    "nv.tenNV, nv.sDT, nv.trangThai, " +
                    "SUM(hd.tongTien) AS doanhThu " +
                    "FROM NhanVien nv " +
                    "LEFT JOIN HoaDon hd ON nv.maNV = hd.maNV " +
                    "WHERE hd.trangThaiHoaDon = 'DA_THANH_TOAN' " +
                    "GROUP BY nv.maNV, nv.tenNV, nv.sDT, nv.trangThai";

            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                String maNV = rs.getString("maNV");
                String tenNV = rs.getString("tenNV");
                String sdt = rs.getString("sDT");
                TrangThaiNhanVien trangThai = TrangThaiNhanVien.valueOf(rs.getString("trangThai"));
                double doanhThu = rs.getDouble("doanhThu");  // Đọc giá trị doanhThu

                NhanVien nhanVien = new NhanVien(maNV, tenNV, sdt, trangThai, doanhThu);  // Tạo đối tượng với doanhThu
                list.add(nhanVien);
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

    public static ObservableList<HoaDon> getHoaDonNhanVienList(String maNhanVien) {
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
