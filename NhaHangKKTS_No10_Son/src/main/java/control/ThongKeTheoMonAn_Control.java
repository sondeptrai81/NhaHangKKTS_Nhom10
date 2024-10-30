package control;

import dao.ThongKeTheoMonAn_DAO;
import entity.ChiTietHD_MonAn;
import entity.MonAn;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class ThongKeTheoMonAn_Control {


    @FXML
    private TextField textTim;

    @FXML
    public void handleEnterKey() {
        textTim.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String inputText = textTim.getText();
                textTim.setText("");
//                System.out.println("Bạn đã nhập: " + inputText);
            }
        });
    }

    public void handleClickText(){
        textTim.selectAll();
    }
    public void handleClickSearch() {
        String inputText = textTim.getText();
        textTim.setText("");
//        System.out.println("Bạn đã nhập: " + inputText);
    }

    @FXML
    private DatePicker datePicker;

    public void locNgay() {
        LocalDate test = datePicker.getValue();
        DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH).format(test);
        System.out.println(test);
    }

    @FXML
    private TableView<ChiTietHD_MonAn> tableView;

    @FXML
    private TableColumn<MonAn, String> colTenMonAn;

    @FXML
    private TableColumn<MonAn, Double> colGia;

    @FXML
    private TableColumn<MonAn, Integer> colSoLuong;

    @FXML
    private TableColumn<MonAn, Double> colDoanhThu;
    @FXML
    public void initialize() {
        ObservableList<ChiTietHD_MonAn> listMonAn = ThongKeTheoMonAn_DAO.getMonAnList(10,2024);

        colTenMonAn.setCellValueFactory(new PropertyValueFactory<>("tenMonAn"));
        colGia.setCellValueFactory(new PropertyValueFactory<>("gia"));
        colSoLuong.setCellValueFactory(new PropertyValueFactory<>("soLuong"));
        colDoanhThu.setCellValueFactory(new PropertyValueFactory<>("doanhThu"));

        tableView.setItems(listMonAn);
    }

}




