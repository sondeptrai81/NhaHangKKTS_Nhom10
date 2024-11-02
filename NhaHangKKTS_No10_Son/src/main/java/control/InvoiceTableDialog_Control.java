package control;

import dao.ThongKeTheoDoanhThu_DAO;
import entity.ChiTietHD_MonAn;
import entity.HoaDon;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class InvoiceTableDialog_Control {
    @FXML
    private TableView<ChiTietHD_MonAn> tableView;
    @FXML
    private TableColumn<ChiTietHD_MonAn,String> colTenMonAn;
    @FXML
    private TableColumn<ChiTietHD_MonAn,String> colGia;
    @FXML
    private TableColumn<ChiTietHD_MonAn,String> colSoLuong;
    @FXML
    private TableColumn<ChiTietHD_MonAn,String> colVAT;
    @FXML
    private TableColumn<ChiTietHD_MonAn,String> colThanhTien;
    ChiTietHD_MonAn chiTietHD_monAn;
    public void initialize() {
        // Thiết lập các cột
        TableColumn<ChiTietHD_MonAn, Integer> colStt = new TableColumn<>("STT");
        colStt.setCellValueFactory(column ->
                new ReadOnlyObjectWrapper<>(tableView.getItems().indexOf(column.getValue()) + 1)
        );
        tableView.getColumns().add(0, colStt);

        colTenMonAn.setCellValueFactory(new PropertyValueFactory<>("tenMonAn"));
        colGia.setCellValueFactory(new PropertyValueFactory<>("gia"));
        colSoLuong.setCellValueFactory(new PropertyValueFactory<>("soLuong"));
        colVAT.setCellValueFactory(new PropertyValueFactory<>("VAT"));
        colThanhTien.setCellValueFactory(new PropertyValueFactory<>("thanhTien"));

    }

    public void setInvoiceData(String maHD) {
        ObservableList<ChiTietHD_MonAn> dataList = getChiTietHoaDonList(maHD);
        if (dataList != null && !dataList.isEmpty()) {
            tableView.setItems(dataList);
        } else {
            System.out.println("Không có dữ liệu chi tiết cho mã hóa đơn: " + maHD);
        }
    }
    private ObservableList<ChiTietHD_MonAn> getChiTietHoaDonList(String maHD) {
        ThongKeTheoDoanhThu_DAO dao = new ThongKeTheoDoanhThu_DAO();
        return dao.getChiTietHoaDonList(maHD);
    }


}
