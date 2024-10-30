package control;

import dao.NhanVien_DAO;
import dao.ThongKeTheoNhanVien_DAO;
import entity.NhanVien;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import dao.ThongKeTheoDoanhThu_DAO;
import entity.HoaDon;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;


public class ThongKeTheoNhanVien_Control {

    @FXML
    private TextField textTim;

    @FXML
    public void handleEnterKey() {
        textTim.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String inputText = textTim.getText();
                textTim.setText("");
            }
        });
    }

    public void handleClickText(){
        textTim.selectAll();
    }
    public void handleClickSearch() {
        String inputText = textTim.getText();
        textTim.setText("");
    }
    @FXML
    private TableView<NhanVien> nhanVienTable;

    @FXML
    private TableColumn<NhanVien, String> colMaNV;

    @FXML
    private TableColumn<NhanVien, String> colTenNV;

    @FXML
    private TableColumn<NhanVien, String> colSDT;

    @FXML
    private TableColumn<NhanVien, String> colTrangThai;

    @FXML
    private TableColumn<NhanVien, Double> colDoanhThu;

    @FXML
    public void initialize() {
        ObservableList<NhanVien> listNhanVien = ThongKeTheoNhanVien_DAO.getListNhanVien();

        colMaNV.setCellValueFactory(new PropertyValueFactory<>("maNV"));
        colTenNV.setCellValueFactory(new PropertyValueFactory<>("tenNV"));
        colSDT.setCellValueFactory(new PropertyValueFactory<>("sDT"));
        colTrangThai.setCellValueFactory(new PropertyValueFactory<>("trangThai"));
        colDoanhThu.setCellValueFactory(new PropertyValueFactory<>("doanhThu"));
        nhanVienTable.setItems(listNhanVien);

    }

    @FXML
    private TableView<HoaDon> hoaDonTable;
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
    public void initialize1() {
        // Kiểm tra xem cột "STT" đã tồn tại hay chưa
        if (hoaDonTable.getColumns().stream().noneMatch(col -> "STT".equals(col.getText()))) {
            TableColumn<HoaDon, Integer> colStt = new TableColumn<>("STT");
            colStt.setCellValueFactory(column ->
                    new ReadOnlyObjectWrapper<>(hoaDonTable.getItems().indexOf(column.getValue()) + 1)
            );
            hoaDonTable.getColumns().add(0, colStt);
        }

        colMaHD.setCellValueFactory(new PropertyValueFactory<>("maHD"));
        colTenKH.setCellValueFactory(new PropertyValueFactory<>("tenKH"));
        colSDTKH.setCellValueFactory(new PropertyValueFactory<>("sDT"));
        colNgayTao.setCellValueFactory(new PropertyValueFactory<>("ngayTaoHD"));
        colBan.setCellValueFactory(new PropertyValueFactory<>("maBan"));
        colTongTien.setCellValueFactory(new PropertyValueFactory<>("tongTien"));
    }


    public void updateUnDerTable(){
        nhanVienTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {

                initialize1();
                NhanVien selectedNhanVien = (NhanVien) newSelection;

                String maNV = selectedNhanVien.getMaNV();
                ObservableList<HoaDon> listHDNV = ThongKeTheoNhanVien_DAO.getHoaDonNhanVienList(maNV);
                hoaDonTable.setItems(listHDNV);
            }
        });
    }


    public void clickNhanVienTable() {
        updateUnDerTable();
    }
}
