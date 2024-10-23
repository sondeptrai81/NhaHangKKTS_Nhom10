package control;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dao.ThanhToan_1_DAO;
import entity.ChiTietHD_MonAn;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ThanhToan_1_Control {
    @FXML
    private Button btnHoanTac_tt;
    @FXML
    private TableView<ChiTietHD_MonAn> table_chitiet;
    @FXML
    private TableColumn<ChiTietHD_MonAn, String> colTenMonAn;
    @FXML
    private TableColumn<ChiTietHD_MonAn, Double> colGia;
    @FXML
    private TableColumn<ChiTietHD_MonAn, Integer> colSL;
    @FXML
    private TableColumn<ChiTietHD_MonAn, Double> colVAT;
    @FXML
    private TableColumn<ChiTietHD_MonAn, Double> colThanhTien;
    @FXML
    private Button btn_Xuathd_tt;

    public void initialize() {
        ObservableList<ChiTietHD_MonAn> hoaDonList1 = ThanhToan_1_DAO.getHoaDonList1();
        TableColumn<ChiTietHD_MonAn, Integer> colStt = new TableColumn<>("STT");
        colStt.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ChiTietHD_MonAn, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<ChiTietHD_MonAn, Integer> param) {
                // Tính toán STT dựa trên vị trí trong danh sách
                int index = hoaDonList1.indexOf(param.getValue());
                return new SimpleIntegerProperty(index + 1).asObject();
            }
        });
        colTenMonAn.setCellValueFactory(new PropertyValueFactory<>("tenMonAn"));
        colGia.setCellValueFactory(new PropertyValueFactory<>("gia"));
        colSL.setCellValueFactory(new PropertyValueFactory<>("soLuong"));
        colVAT.setCellValueFactory(new PropertyValueFactory<>("VAT"));
        //lam cho cot vat co hien thi % tren table view
        colVAT.setCellFactory(col -> new TableCell<ChiTietHD_MonAn, Double>() {
            @Override
            protected void updateItem(Double vat, boolean empty) {
                super.updateItem(vat, empty);
                if (empty || vat == null) {
                    setText(null);
                } else {
                    setText(vat + "%"); // Định dạng giá trị VAT
                }
            }
        });

        colThanhTien.setCellValueFactory(new PropertyValueFactory<>("thanhTien"));
        // Gắn dữ liệu vào TableView
        table_chitiet.setItems(hoaDonList1);
        table_chitiet.getColumns().add(0, colStt);
    }

    private void printInvoice() {
        Document document = new Document();
        try {
            // Tạo file PDF
            String dest = "/hoadon/hoadon.pdf"; // duong dan
            PdfWriter.getInstance(document, new FileOutputStream(dest));
            document.open();

            // Tiêu đề hóa đơn
            document.add(new Paragraph("HÓA ĐƠN"));

            // Tạo bảng
            PdfPTable table = new PdfPTable(6); // Số cột trong hoa don
            table.addCell("STT");
            table.addCell("Tên Món Ăn");
            table.addCell("Giá");
            table.addCell("Số Lượng");
            table.addCell("VAT");
            table.addCell("Thành Tiền");

            // Lấy dữ liệu từ TableView
            ObservableList<ChiTietHD_MonAn> items = table_chitiet.getItems();
            for (ChiTietHD_MonAn item : items) {
                table.addCell(String.valueOf(items.indexOf(item) + 1));
                table.addCell(item.getMonAn().getTenMonAn());
                table.addCell(String.valueOf(item.getGia()));
                table.addCell(String.valueOf(item.getSoLuong()));
                table.addCell(item.getMonAn().getVAT() + "%");
                table.addCell(String.valueOf(item.getThanhTien()));
            }

            document.add(table);
            System.out.println("Đã in hóa đơn thành công!");
            //hien thi hoa don len luon man hinh
            if (Desktop.isDesktopSupported()) {
                File pdfFile = new File(dest);
                Desktop.getDesktop().open(pdfFile);
            } else {
                System.out.println("Desktop is not supported.");
            }

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            document.close();
        }
    }


    @FXML
    private void handleHoanTac() {
        Stage currentStage = (Stage) btnHoanTac_tt.getScene().getWindow();
        currentStage.close(); // Đóng cửa sổ hiện tại
    }

    @FXML
    private void handleXuatHD() {
        printInvoice();
    }


}

