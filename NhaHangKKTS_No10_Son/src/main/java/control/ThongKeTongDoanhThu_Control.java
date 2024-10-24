package control;

import dao.ThongKeTheoDoanhThu_DAO;
import entity.HoaDon;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.util.Callback;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.io.DataInput;
import java.sql.Time;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.IntStream;
public class ThongKeTongDoanhThu_Control {
    @FXML
    private TextField textTim;
    @FXML
    private TableView<HoaDon> invoiceTable;
    @FXML
    private TableColumn<HoaDon, String> colMaHD;
    @FXML
    private TableColumn<HoaDon, String> colTenKH;
    @FXML
    private TableColumn<HoaDon, String> colSDT;
    @FXML
    private TableColumn<HoaDon, LocalDate> colNgayTaoHD;
    @FXML
    private TableColumn<HoaDon, String> colMaBan;
    @FXML
    private TableColumn<HoaDon, String> colTenNV;
    @FXML
    private TableColumn<HoaDon, Double> colTongTien;
    @FXML
    private Label lblTongDoanhThu;
    @FXML
    private LineChart dailyRevenueChart;
    @FXML
    private PieChart  revenuePieChart;


    @FXML
    private DatePicker datePicker;

    ObservableList<HoaDon> hoaDonList = ThongKeTheoDoanhThu_DAO.getHoaDonDoneList();

    @FXML
    public void initialize() {

//        // Tạo cột STT
        TableColumn<HoaDon, Integer> colStt = new TableColumn<>("STT");
        colStt.setCellValueFactory(column ->
                new ReadOnlyObjectWrapper<>(invoiceTable.getItems().indexOf(column.getValue()) + 1)
        );
        invoiceTable.getColumns().add(0, colStt);
        colMaHD.setCellValueFactory(new PropertyValueFactory<>("maHD"));
        colTenKH.setCellValueFactory(new PropertyValueFactory<>("tenKH"));
        colSDT.setCellValueFactory(new PropertyValueFactory<>("sDT"));
        colNgayTaoHD.setCellValueFactory(new PropertyValueFactory<>("ngayTaoHD"));
        colMaBan.setCellValueFactory(new PropertyValueFactory<>("maBan"));
        colTenNV.setCellValueFactory(new PropertyValueFactory<>("tenNV"));
        colTongTien.setCellValueFactory(new PropertyValueFactory<>("tongTien"));
        invoiceTable.setItems(hoaDonList);
        tinhTongDoanhThu();
        hienThiDoanhThuTrenLineChart();
        hienThiDoanhThuTrenPieChart();
    }

    public void tinhTongDoanhThu(){
        double tongDoanhthu=0.0;
        for (HoaDon hoaDon : invoiceTable.getItems()) {
            tongDoanhthu += hoaDon.getTongTien();
        }
       lblTongDoanhThu.setText(String.valueOf(tongDoanhthu)+"VNĐ");
    }


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

    public void hienThiDoanhThuTrenLineChart() {
        // Lấy danh sách hóa đơn từ TableView
        ObservableList<HoaDon> hoaDonList = invoiceTable.getItems();

        // Tạo Series cho LineChart
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Doanh thu theo ngày");

        // Sử dụng Map để lưu trữ tổng doanh thu theo ngày
        Map<String, Double> doanhThuTheoNgay = new HashMap<>();

        // Duyệt qua danh sách hóa đơn và tính tổng doanh thu theo ngày
        for (HoaDon hoaDon : hoaDonList) {
            String ngay = String.valueOf(hoaDon.getNgayTaoHD());  // Lấy ngày tạo hóa đơn
            double doanhThu = hoaDon.getTongTien();  // Lấy tổng tiền của hóa đơn

            // Cộng dồn doanh thu vào ngày tương ứng
            doanhThuTheoNgay.put(ngay, doanhThuTheoNgay.getOrDefault(ngay, 0.0) + doanhThu);
        }

        // Thêm dữ liệu vào series từ Map (X là ngày, Y là tổng doanh thu)
        for (Map.Entry<String, Double> entry : doanhThuTheoNgay.entrySet()) {
            String ngay = entry.getKey();
            double tongDoanhThu = entry.getValue();
            series.getData().add(new XYChart.Data<>(ngay, tongDoanhThu));
        }

        // Xóa các series cũ nếu cần (để không bị trùng lặp)
        dailyRevenueChart.getData().clear();

        // Thêm series mới vào LineChart
        dailyRevenueChart.getData().add(series);
    }


    public void hienThiDoanhThuTrenPieChart() {
        // Lấy danh sách hóa đơn từ TableView
        ObservableList<HoaDon> hoaDonList = invoiceTable.getItems();

        // Tạo danh sách dữ liệu cho PieChart
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        // Duyệt qua danh sách hóa đơn và thêm dữ liệu vào PieChart
        for (HoaDon hoaDon : hoaDonList) {
            String tenKhachHang = hoaDon.getTenKH();  // Lấy tên khách hàng (hoặc có thể là tên nhân viên, bàn, ...)
            double doanhThu = hoaDon.getTongTien();   // Lấy tổng tiền của hóa đơn

            // Thêm dữ liệu vào PieChart (TenKH là tên, doanhThu là giá trị)
            pieChartData.add(new PieChart.Data(tenKhachHang, doanhThu));
        }

        // Xóa các dữ liệu cũ nếu cần (để không bị trùng lặp)
        revenuePieChart.getData().clear();

        // Thêm dữ liệu mới vào PieChart
        revenuePieChart.setData(pieChartData);
    }

}

