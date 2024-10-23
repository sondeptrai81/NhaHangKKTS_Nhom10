package dao;

import connectDB.ConnectDB;
import entity.ChiTietHD_MonAn;
import entity.HoaDon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class ThanhToan_1_DAO {
    public static ObservableList<ChiTietHD_MonAn> getHoaDonList1() {
        ObservableList<ChiTietHD_MonAn> list = FXCollections.observableArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectDB.connect();  // Sử dụng lớp ConnectDB để kết nối
            String query = "SELECT ROW_NUMBER() OVER (ORDER BY hd.NgayTaoHD) AS STT, " +
                    "m.TenMonAn, m.Gia, ct.SoLuong, m.VAT, ct.ThanhTien " +
                    "FROM HoaDon hd " +
                    "JOIN ChiTietHD_MonAn ct ON hd.MaHD = ct.MaHD " + // Giả định rằng ChiTietHoaDon là bảng chứa chi tiết hóa đơn
                    "JOIN MonAn m ON ct.MaMonAn = m.MaMonAn"; // Giả định rằng MonAn là bảng chứa thông tin món ăn

            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int stt = rs.getInt("STT");
                String tenMonAn = rs.getString("tenMonAn");
                double gia = rs.getDouble("gia");
                int soLuong = rs.getInt("soLuong");
                double vat = rs.getDouble("vAT");
                double thanhTien = rs.getDouble("thanhTien");
                ChiTietHD_MonAn chiTiet = new ChiTietHD_MonAn(tenMonAn, gia, soLuong, vat, thanhTien);
                list.add(chiTiet);
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
