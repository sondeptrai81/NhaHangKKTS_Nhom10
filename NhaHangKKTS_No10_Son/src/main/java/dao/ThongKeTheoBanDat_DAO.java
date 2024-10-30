package dao;

import connectDB.ConnectDB;
import entity.Ban;
import entity.KhuVuc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class ThongKeTheoBanDat_DAO {
    public static ObservableList<Ban> getDanhSachBan() {
        ObservableList<Ban> danhSachBan = FXCollections.observableArrayList();
        String sql = """
            SELECT b.maBan, b.khuVuc, MIN(hd.ngayTaoHD) AS ngayTaoHD, COUNT(hd.maHD) AS soLanDat, 
                   COALESCE(SUM(hd.tongTien), 0) AS doanhThu
            FROM Ban b
            LEFT JOIN HoaDon hd ON b.maBan = hd.maBan
            GROUP BY b.maBan, b.khuVuc
            ORDER BY b.maBan
            """;

        try (Connection conn = ConnectDB.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String maBan = rs.getString("maBan");

                // Chuyển đổi khuVuc thành enum KhuVuc
                KhuVuc khuVuc = KhuVuc.valueOf("KHU_VUC_" + rs.getString("khuVuc"));

//                LocalDate ngayTaoHD = rs.getDate("ngayTaoHD").toLocalDate();
                LocalDate ngayTaoHD = rs.getDate("ngayTaoHD") != null ? rs.getDate("ngayTaoHD").toLocalDate() : null;

                int soLanDat = rs.getInt("soLanDat");
                double doanhThu = rs.getDouble("doanhThu");

                Ban ban = new Ban(maBan, khuVuc, ngayTaoHD, soLanDat, doanhThu);
                danhSachBan.add(ban);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Khu vực không hợp lệ trong cơ sở dữ liệu: " + e.getMessage());
        }

        return danhSachBan;
    }
}
