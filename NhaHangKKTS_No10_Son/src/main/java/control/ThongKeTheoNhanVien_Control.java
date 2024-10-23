package control;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class ThongKeTheoNhanVien_Control {
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
}
