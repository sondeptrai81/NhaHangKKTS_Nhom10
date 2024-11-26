package dao;

import connectDB.ConnectDB;
import entity.ChiTietHD_MonAn;
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
            conn = ConnectDB.connect();
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


    public ObservableList<ChiTietHD_MonAn> getChiTietHoaDonList(String maHD) {
        ObservableList<ChiTietHD_MonAn> list = FXCollections.observableArrayList();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectDB.connect();
            String query = "SELECT ct.maHD, ma.tenMonAn, ma.gia, ct.soLuong, ma.VAT, ct.thanhTien " +
                    "FROM ChiTietHD_MonAn ct " +
                    "JOIN MonAn ma ON ct.maMonAn = ma.maMonAn " +
                    "WHERE ct.maHD = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, maHD);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String tenMonAn = rs.getString("tenMonAn");
                double gia = rs.getDouble("gia");
                int soLuong = rs.getInt("soLuong");
                int vat = rs.getInt("VAT");
                double thanhTien = rs.getDouble("thanhTien");

                ChiTietHD_MonAn chiTiet = new ChiTietHD_MonAn(maHD, tenMonAn, gia, soLuong, vat, thanhTien);
                list.add(chiTiet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}

