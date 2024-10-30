package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InvoiceTableDialog_Dialog extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TrangChu_GUI.class.getResource("InvoiceTableDialog.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }
}
