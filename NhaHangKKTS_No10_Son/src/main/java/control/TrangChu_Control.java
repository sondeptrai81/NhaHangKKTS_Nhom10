package control;

import javafx.event.ActionEvent;
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
    private Button btnNhanVien;

    @FXML
    private Button btnMonAn;
    @FXML
    private  Button btnThongKe;

    @FXML
    private Pane showPane;
    private Button selectedButton = null;

    

    @FXML
    private void handleMouseEntered(MouseEvent event) {
        ((Button) event.getSource()).setStyle("-fx-background-color: #ffffff; -fx-border-color: #ffffff; -fx-text-fill: #00b6f3;");
    }

    @FXML
    private void handleMouseExited(MouseEvent event) {
        Button button = (Button) event.getSource();

        // Chỉ quay về màu mặc định nếu nút không phải là nút đã chọn
        if (button != selectedButton) {
            button.setStyle("-fx-background-color: #00b6f3; -fx-border-color: #ffffff; -fx-text-fill: #ffffff;");
        } }

    @FXML
    public void handleDatBanClick() {
    }

    @FXML
    public void  handleMonAnClick(){

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
    @FXML
    private void handleButtonClick(javafx.event.ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getSource();

        if (selectedButton != null) {
            selectedButton.setStyle("-fx-background-color: #00bfff; -fx-border-color: #ffffff; -fx-text-fill: #fafafa;"); // Màu mặc định
        }

        // Đặt màu cho nút hiện tại và gán nó làm `selectedButton`
        clickedButton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #ffffff; -fx-text-fill: #00b6f3;");
        selectedButton = clickedButton;

        if (clickedButton == btnMonAn) {
            handleMonAnClick();
        } else if (clickedButton == btnNhanVien) {
            handleNhanVienClick();
        } else if (clickedButton == btnThanhToan) {
            handleThanhToanClick();
        } else if (clickedButton == btnThongKe) {
            handleThongKeClick();
        } else if (clickedButton == btnDatBan) {
            handleDatBanClick();
        }
    }

}
