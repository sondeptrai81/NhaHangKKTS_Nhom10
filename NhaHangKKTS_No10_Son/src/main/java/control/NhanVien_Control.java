package control;

import dao.NhanVien_DAO;
import entity.NhanVien;
import entity.TrangThaiNhanVien;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class NhanVien_Control implements Initializable {
    @FXML
    private TextField txtMaNV;
    @FXML
    private TextField txtSDT;
    @FXML
    private TextField txtTenNV;
    @FXML
    private ComboBox comboChucVu;
    @FXML
    private ComboBox comboTrangThai;
    @FXML
    private DatePicker ngaySinh;
    @FXML
    private RadioButton radNam;
    @FXML
    private RadioButton radNu;
    @FXML
    private ToggleGroup genderGroup;
    @FXML
    private TableView<NhanVien> tblNhanVien;
    @FXML
    private TableColumn<NhanVien, String> cellMaNV;
    @FXML
    private TableColumn<NhanVien, String> cellTenNV;
    @FXML
    private TableColumn<NhanVien, String> cellGioiTinh;
    @FXML
    private TableColumn<NhanVien, String> cellSDT;
    @FXML
    private TableColumn<NhanVien, Date> cellNgaySinh;
    @FXML
    private TableColumn<NhanVien, Date> cellNgayVaoLam;
    @FXML
    private TableColumn<NhanVien, Date> cellNgayNghiLam;
    @FXML
    private TableColumn<NhanVien, String> cellChucVu;
    @FXML
    private TableColumn<NhanVien, String> cellTrangThai;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genderGroup = new ToggleGroup();
        radNam.setSelected(true);
        radNam.setToggleGroup(genderGroup);
        radNu.setToggleGroup(genderGroup);
        String chucVuNV[] = {"Nhân viên", "Quản lý"};
        comboChucVu.setItems(FXCollections.observableArrayList(chucVuNV));
        String trangThaiNV[] = {"NGHI", "DANG_LAM", "NGHI_DAI_HAN"};
        comboTrangThai.setItems(FXCollections.observableArrayList(trangThaiNV));
        ObservableList<NhanVien> nhanVienList = NhanVien_DAO.getNhanVienList();
        cellMaNV.setCellValueFactory(new PropertyValueFactory<>("maNV"));
        cellTenNV.setCellValueFactory(new PropertyValueFactory<>("tenNV"));
        cellGioiTinh.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().isGioiTinh() ? "Nam" : "Nữ")
        );
        cellNgaySinh.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        cellSDT.setCellValueFactory(new PropertyValueFactory<>("sDT"));
        cellNgayVaoLam.setCellValueFactory(new PropertyValueFactory<>("ngayVaoLam"));
        cellNgayNghiLam.setCellValueFactory(new PropertyValueFactory<>("ngayNghiLam"));
        cellChucVu.setCellValueFactory(new PropertyValueFactory<>("chucVu"));
        cellTrangThai.setCellValueFactory(new PropertyValueFactory<>("trangThai"));

        // Gắn dữ liệu vào TableView
        tblNhanVien.setItems(nhanVienList);
    }
    public NhanVien RevertNhanVien(){

        String ma = txtMaNV.getText();
        String ten = txtTenNV.getText();
        String sdt = txtSDT.getText();
        LocalDate ngaySinhSelected = ngaySinh.getValue();
        boolean gt = true;
        if(genderGroup.getSelectedToggle() != null){
            RadioButton SelectedGender = (RadioButton) genderGroup.getSelectedToggle();
            gt = SelectedGender.getText().equals("Nam");
        }
        LocalDate ngayVaoLamSelected = LocalDate.now();
        LocalDate ngayNghiLamSelected = null;
        String cv = (String) comboChucVu.getValue();
        TrangThaiNhanVien tTNV = null;
        String tt = (String) comboTrangThai.getValue();
        if(tt != null){
            tTNV = TrangThaiNhanVien.valueOf(tt);
        }
        NhanVien nv = new NhanVien(ma, ten, gt, sdt, tTNV, cv, ngayVaoLamSelected, ngayNghiLamSelected, ngaySinhSelected);
        return nv;
    }
    public void themNhanVien(ActionEvent actionEvent) {
        NhanVien_DAO dao = new NhanVien_DAO();
        String ten = txtTenNV.getText();
        String sdt = txtSDT.getText();
        LocalDate ngaySinhSelected = ngaySinh.getValue();
        boolean gt = true;
        if(genderGroup.getSelectedToggle() != null){
            RadioButton SelectedGender = (RadioButton) genderGroup.getSelectedToggle();
            gt = SelectedGender.getText().equals("Nam");
        }
        LocalDate ngayVaoLamSelected = LocalDate.now();
        LocalDate ngayNghiLamSelected = null;
        String cv = (String) comboChucVu.getValue();
        TrangThaiNhanVien tTNV = null;
        String tt = (String) comboTrangThai.getValue();
        if(tt != null){
            tTNV = TrangThaiNhanVien.valueOf(tt);
        }
        String ma = taoMaNhanVienTuDong(cv, ngayVaoLamSelected, dao.laySoThuTu(ngayVaoLamSelected));
        NhanVien nv = new NhanVien(ma, ten, gt, sdt, tTNV, cv, ngayVaoLamSelected, ngayNghiLamSelected, ngaySinhSelected);
        if(nv.getTenNV().isEmpty() || nv.getNgaySinh() == null){
            showAlert("Thông báo", "Vui lòng điền đầy đủ thông tin.");
            return;
        }
        boolean isAdd = dao.themNhanVien(nv);
        //Hiển thị thông báo cho người dùng
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if(isAdd){
            alert.setTitle("Thành công");
            alert.setHeaderText("Thêm nhân viên thành công");
            alert.setContentText("Nhân viên " + nv.getTenNV() + " đã được thêm vào hệ thống.");
        }
        else{
            alert.setTitle("Thất bại");
            alert.setHeaderText("Thêm nhân viên không thành công");
            alert.setContentText("Đã xảy ra lỗi khi thêm nhân viên. Vui lòng thử lại.");
        }
        alert.showAndWait();
        // Cập nhật bảng nhân viên nếu cần
        ObservableList<NhanVien> nhanVienList = NhanVien_DAO.getNhanVienList();
        tblNhanVien.setItems(nhanVienList);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private String taoMaNhanVienTuDong(String chucVu, LocalDate ngayVaoLam, int soThuTu) {
        // Định dạng ngày thành chuỗi ddMMyy
        String ngay = ngayVaoLam.format(java.time.format.DateTimeFormatter.ofPattern("ddMMyy"));

        // Xác định phần CV (TN cho nhân viên thường, QL cho quản lý)
        String cv;
        if (chucVu.equalsIgnoreCase("Quản lý")) {
            cv = "QL";
        } else {
            cv = "TN";
        }

        // Tạo mã số thứ tự với định dạng 2 chữ số
        String soThuTuFormat = String.format("%02d", soThuTu);

        // Tạo mã nhân viên hoàn chỉnh
        return "NV" + cv + ngay + soThuTuFormat;
    }

    public void rowClicked(MouseEvent mouseEvent) {
        NhanVien SelectedNhanVien = tblNhanVien.getSelectionModel().getSelectedItem();
        if(SelectedNhanVien != null){
            txtMaNV.setText(SelectedNhanVien.getMaNV());
            txtTenNV.setText(SelectedNhanVien.getTenNV());
            txtSDT.setText(SelectedNhanVien.getSDT());
            if(SelectedNhanVien.isGioiTinh()){
                radNam.setSelected(true);
            }
            else {
                radNu.setSelected(true);
            }
            if(SelectedNhanVien.getNgaySinh() != null){
                ngaySinh.setValue(SelectedNhanVien.getNgaySinh());
            }
            else {
                ngaySinh.setValue(null);
            }
            comboChucVu.setValue(SelectedNhanVien.getChucVu());
            comboTrangThai.setValue(SelectedNhanVien.getTrangThai());
        }
    }
}
