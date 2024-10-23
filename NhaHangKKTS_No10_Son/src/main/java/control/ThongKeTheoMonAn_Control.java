package control;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.time.Year;
import java.util.stream.IntStream;


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
    private ComboBox<Integer> dayCombo;

    @FXML
    private ComboBox<Integer> monthCombo;

    @FXML
    private ComboBox<Integer> yearCombo;


    @FXML
    public void initialize() {
        monthCombo.setItems(FXCollections.observableArrayList(IntStream.rangeClosed(1, 12).boxed().toList()));

        yearCombo.setItems(FXCollections.observableArrayList(IntStream.rangeClosed(2000, 2030).boxed().toList()));

        monthCombo.setOnAction(event -> updateDays());
        yearCombo.setOnAction(event -> updateDays());

        monthCombo.setValue(1);
        dayCombo.setValue(1);
        yearCombo.setValue(Year.now().getValue());
        updateDays();
    }

    private void updateDays() {
        if (monthCombo.getValue() == null || yearCombo.getValue() == null) {
            return;
        }

        int selectedMonth = monthCombo.getValue();
        int selectedYear = yearCombo.getValue();

        int daysInMonth = switch (selectedMonth) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> (Year.isLeap(selectedYear) ? 29 : 28);
            default -> 31;
        };
        dayCombo.setItems(FXCollections.observableArrayList(IntStream.rangeClosed(1, daysInMonth).boxed().toList()));
    }

    public void handleClickLoc() {
        int day,month,year;
        day = dayCombo.getValue();
        month = monthCombo.getValue();
        year = yearCombo.getValue();
//        System.out.println(  a +""+ b+""+ c);
    }
}
