package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ThongKeTheoMonAn_GUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ThongKe_GUI.class.getResource("ThongKeTheoMonAn.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Chương trình quản lý nhà hàng");
        stage.setScene(scene);
        stage.show();
    }
}
