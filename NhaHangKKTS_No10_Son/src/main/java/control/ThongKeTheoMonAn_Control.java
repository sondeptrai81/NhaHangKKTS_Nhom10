package control;

import dao.ThongKeTheoMonAn_DAO;
import entity.ChiTietHD_MonAn;
import entity.MonAn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class ThongKeTheoMonAn_Control {


    ObservableList<ChiTietHD_MonAn> listMonAn = ThongKeTheoMonAn_DAO.getMonAnList(10,2024);

    @FXML
    private TextField textTim;

    @FXML
    public void handleEnterKey() {
        textTim.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                handleSearch();
            }
        });
    }



    @FXML
    public void handleClickSearch() {
        handleSearch();

    }

    @FXML
    private void handleSearch() {
        String inputText = textTim.getText();
        textTim.setText("");

        if (inputText.isEmpty()) {
            tableView.setItems(listMonAn); // Reset to full list if search is empty
        } else {
            ObservableList<ChiTietHD_MonAn> filteredList = FXCollections.observableArrayList(
                    listMonAn.stream()
                            .filter(monAn -> monAn.getTenMonAn().contains(inputText))
                            .toList()
            );
            tableView.setItems(filteredList);
        }
    }
    public void handleClickText(){
        textTim.selectAll();
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

        colTenMonAn.setCellValueFactory(new PropertyValueFactory<>("tenMonAn"));
        colGia.setCellValueFactory(new PropertyValueFactory<>("gia"));
        colSoLuong.setCellValueFactory(new PropertyValueFactory<>("soLuong"));
        colDoanhThu.setCellValueFactory(new PropertyValueFactory<>("doanhThu"));

        tableView.setItems(listMonAn);
    }

}




