package control;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DangNhap_Control {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}