package control;

import dao.ThongKeDoanhThu_DAO;
import dao.ThongKeTheoNhanVien_DAO;
import entity.HoaDon;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;

import java.time.LocalDate;

public class ThongKeDoanhThu_Control {
    @FXML
    private TextField textTim;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TableView<HoaDon> doanhThuTable;
    @FXML
    private TableColumn<HoaDon, String> colTenKH;
    @FXML
    private TableColumn<HoaDon, String> colSDTKH;
    @FXML
    private TableColumn<HoaDon, LocalDate> colNgayTao;
    @FXML
    private TableColumn<HoaDon, String> colBan;
    @FXML
    private TableColumn<HoaDon, String> colMaHD;
    @FXML
    private TableColumn<HoaDon, Double> colTongTien;
    @FXML
    private Label lblTongDoanhThu;
    @FXML
    public void handleEnterKey() {
        textTim.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String inputText = textTim.getText();
                textTim.setText("");
            }
        });
    }
    @FXML
    public void handleClickText() {
        textTim.selectAll();
    }

    @FXML
    public void handleClickSearch() {
        String inputText = textTim.getText();
        textTim.setText("");

    }

    @FXML
    public void locNgay() {
        LocalDate selectedDate = datePicker.getValue();

    }

    @FXML
    public void initialize() {
        // Kiểm tra xem cột "STT" đã tồn tại hay chưa
        if (doanhThuTable.getColumns().stream().noneMatch(col -> "STT".equals(col.getText()))) {
            TableColumn<HoaDon, Integer> colStt = new TableColumn<>("STT");
            colStt.setCellValueFactory(column ->
                    new ReadOnlyObjectWrapper<>(doanhThuTable.getItems().indexOf(column.getValue()) + 1)
            );
            doanhThuTable.getColumns().add(0, colStt);
        }
        colMaHD.setCellValueFactory(new PropertyValueFactory<>("maHD"));
        colTenKH.setCellValueFactory(new PropertyValueFactory<>("tenKH"));
        colSDTKH.setCellValueFactory(new PropertyValueFactory<>("sDT"));
        colNgayTao.setCellValueFactory(new PropertyValueFactory<>("ngayTaoHD"));
        colBan.setCellValueFactory(new PropertyValueFactory<>("maBan"));
        colTongTien.setCellValueFactory(new PropertyValueFactory<>("tongTien"));
        updateTable();
        tinhTongDoanhThu();
    }

    public void tinhTongDoanhThu(){
        double tongDoanhthu=0.0;
        for (HoaDon hoaDon : doanhThuTable.getItems()) {
            tongDoanhthu += hoaDon.getTongTien();
        }
        lblTongDoanhThu.setText(String.valueOf(tongDoanhthu)+"  VNĐ");
    }
    public void updateTable(){
        // lấy mã nhân viên tu hệ thống truyền vào func dưới đây:
        ObservableList<HoaDon> listHDNV = ThongKeDoanhThu_DAO.getListHDNVCur("NVTN01012401");
        doanhThuTable.setItems(listHDNV);
    }
}
