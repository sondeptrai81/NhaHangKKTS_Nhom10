package control;

import dao.ThongKeTheoBanDat_DAO;
import entity.Ban;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ThongKeTheoBanDat_Control {
    @FXML
    private DatePicker datePicker;
    @FXML
    public void locNgay() {
        LocalDate selectedDate = datePicker.getValue();

    }
    @FXML
    private TableView<Ban> banTable;

    @FXML
    private TableColumn<Ban, String> colMaHD;

    @FXML
    private TableColumn<Ban, String> colKhuVuc;

    @FXML
    private TableColumn<Ban, java.sql.Date> colNgayTaoHD;

    @FXML
    private TableColumn<Ban, Integer> colSoLanDat;

    @FXML
    private TableColumn<Ban, Double> colDoanhThu;

    public void initialize() {
        colMaHD.setCellValueFactory(new PropertyValueFactory<>("maBan"));
        colKhuVuc.setCellValueFactory(new PropertyValueFactory<>("khuVuc"));
        colNgayTaoHD.setCellValueFactory(new PropertyValueFactory<>("ngayTaoHD"));
        colSoLanDat.setCellValueFactory(new PropertyValueFactory<>("soLanDat"));
        colDoanhThu.setCellValueFactory(new PropertyValueFactory<>("doanhThu"));

        ObservableList<Ban> danhSachBan = ThongKeTheoBanDat_DAO.getDanhSachBan();
        banTable.setItems(danhSachBan);
    }


}
