package control;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.time.Year;
import java.util.EventObject;
import java.util.stream.IntStream;

public class ThongKe_Control {
    @FXML
    private Tab tabTongDoanhThu;
    @FXML
    private Tab tabMonAn;

    @FXML
    private Tab tabNhanVien;
    @FXML
    public void initialize() {
        try {
            AnchorPane tongDoanhThuContent = FXMLLoader.load(getClass().getResource("/gui/ThongKeTongDoanhThu.fxml"));
            tabTongDoanhThu.setContent(tongDoanhThuContent);

            AnchorPane monAnContent = FXMLLoader.load(getClass().getResource("/gui/ThongKeTheoMonAn.fxml"));
            tabMonAn.setContent(monAnContent);

            AnchorPane nhanVienContent = FXMLLoader.load(getClass().getResource("/gui/ThongKeTheoNhanVien.fxml"));
            tabNhanVien.setContent(nhanVienContent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
