package control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class TrangChu_Control {
    @FXML
    private Button btnDatBan;
    @FXML
    private Button btnThanhToan;
    @FXML
    private Pane showPane;

    @FXML
    private void handleMouseEntered(MouseEvent event) {
        ((Button) event.getSource()).setStyle("-fx-background-color: #ffffff; -fx-border-color: #ffffff; -fx-text-fill: #00b6f3;");
    }

    @FXML
    private void handleMouseExited(MouseEvent event) {
        ((Button) event.getSource()).setStyle("-fx-background-color: #00b6f3; -fx-border-color: #ffffff; -fx-text-fill: #ffffff;");
    }

    @FXML
    public void handleDatBanClick(MouseEvent mouseEvent) {
    }

    @FXML
    public void handleThanhToanClick() {
        try {
            Parent thanhToanContent = FXMLLoader.load(getClass().getResource("/gui/ThanhToan.fxml"));
            showPane.getChildren().clear();
            showPane.getChildren().add(thanhToanContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleThongKeClick() {
        try {
            Parent ThongKeContent = FXMLLoader.load(getClass().getResource("/gui/ThongKe.fxml"));
            showPane.getChildren().clear();
            showPane.getChildren().add(ThongKeContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleNhanVienClick() {
        try {
            Parent ThongKeContent = FXMLLoader.load(getClass().getResource("/gui/NhanVien.fxml"));
            showPane.getChildren().clear();
            showPane.getChildren().add(ThongKeContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
