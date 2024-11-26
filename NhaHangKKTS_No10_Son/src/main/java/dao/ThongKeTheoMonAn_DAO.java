package dao;

import java.sql.*;

import connectDB.ConnectDB;
import entity.ChiTietHD_MonAn;
import entity.MonAn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ThongKeTheoMonAn_DAO {
    public static ObservableList<ChiTietHD_MonAn> getMonAnList(int month, int year) {
        ObservableList<ChiTietHD_MonAn> list = FXCollections.observableArrayList();

        String query = "SELECT m.tenMonAn, m.gia, SUM(ct.soLuong) AS soLuong, " +
                "SUM(ct.soLuong * m.gia * (1 + m.VAT)) AS doanhThu " +
                "FROM HoaDon hd " +
                "JOIN ChiTietHD_MonAn ct ON hd.maHD = ct.maHD " +
                "JOIN MonAn m ON ct.maMonAn = m.maMonAn " +
                "WHERE MONTH(hd.ngayTaoHD) = ? AND YEAR(hd.ngayTaoHD) = ? " +
                "GROUP BY m.tenMonAn, m.gia, m.VAT";

        try (Connection conn = ConnectDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, month);
            pstmt.setInt(2, year);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String tenMonAn = rs.getString("tenMonAn");
                    double gia = rs.getDouble("gia");
                    int soLuong = rs.getInt("soLuong");
                    double doanhThu = rs.getDouble("doanhThu");
                    ChiTietHD_MonAn chiTietHD_monAn = new ChiTietHD_MonAn(tenMonAn, gia, soLuong, doanhThu);

                    list.add(chiTietHD_monAn);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
