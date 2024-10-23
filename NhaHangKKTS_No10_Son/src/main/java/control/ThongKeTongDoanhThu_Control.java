package control;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.stream.IntStream;

public class ThongKeTongDoanhThu_Control {

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
        System.out.println(test);
    }
}
