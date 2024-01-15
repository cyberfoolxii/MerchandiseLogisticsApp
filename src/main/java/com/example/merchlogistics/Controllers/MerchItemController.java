package com.example.merchlogistics.Controllers;

import com.example.merchlogistics.Entities.Merchandise;
import com.example.merchlogistics.Enums.SceneEnum;
import com.example.merchlogistics.Workers.Formatter;
import com.example.merchlogistics.Workers.Getter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class MerchItemController implements Initializable {

    private static int numberOfSelectedMerch;
    @FXML
    private Button itemButton;
    @FXML
    private Label merchNameLabel;
    @FXML
    private Label merchStatusLabel;
    @FXML
    private Label merchQuantityLabel;
    @FXML
    private Label merchPriceLabel;
    @FXML
    private Label merchDateLabel;
    @FXML
    private ImageView imageView;
    @FXML
    private CheckBox checkBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void checkboxClick(ActionEvent event) {
        selectionCheck();
    }

    private void selectionCheck() {
        if (checkBox.isSelected()) {
            numberOfSelectedMerch++;
        } else {
            numberOfSelectedMerch--;
        }
        updateOptionsVisibility();
    }

    private void updateOptionsVisibility() {
        MerchSceneController merchSceneController =
                (MerchSceneController) Getter.getInstance().getController(SceneEnum.MERCH_SCENE);
        if (numberOfSelectedMerch > 0) {
            merchSceneController.showOptions();
        } else {
            merchSceneController.hideOptions();
        }
    }

    public void setup(Merchandise merchandise) {
        merchNameLabel.setText("Tên sản phẩm : " + merchandise.getName());
        if (merchandise.isAvailable()) {
            merchStatusLabel.setText("Tình trạng : Còn hàng");
        } else {
            merchStatusLabel.setText("Tình trạng : Hết hàng");
        }
        merchQuantityLabel.setText("Số lượng : x" + String.valueOf(merchandise.getQuantity()));
        merchPriceLabel.setText("Giá thành : " + Formatter.format(merchandise.getPrice()) + " VND");
        merchDateLabel.setText("Ngày tạo : " + merchandise.getImportDate());
        imageView.setImage(merchandise.getImage());
    }
}
