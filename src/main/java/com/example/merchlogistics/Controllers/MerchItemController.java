package com.example.merchlogistics.Controllers;

import com.example.merchlogistics.Entities.MerchandiseComposite;
import com.example.merchlogistics.Enums.SceneEnum;
import com.example.merchlogistics.Workers.Formatter;
import com.example.merchlogistics.Workers.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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

    private MerchandiseComposite merchandiseComposite;

    // content when clicked

    public void buttonClick(ActionEvent event) {
        showContent();
    }

    private void showContent() {

    }

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
                (MerchSceneController) SceneManager.getInstance().getController(SceneEnum.MERCH_SCENE);
        if (numberOfSelectedMerch > 0) {
            merchSceneController.showOptions();
        } else {
            merchSceneController.hideOptions();
        }
    }

    public void setup(MerchandiseComposite merchandiseComposite) {
        this.merchandiseComposite = merchandiseComposite;
        updateGraphicElements();
    }

    private void updateGraphicElements() {
        if (merchandiseComposite == null) {
            return;
        }

        merchNameLabel.setText("Tên sản phẩm : " + merchandiseComposite.getName());
        if (merchandiseComposite.isAvailable()) {
            merchStatusLabel.setText("Tình trạng : Còn hàng");
        } else {
            merchStatusLabel.setText("Tình trạng : Hết hàng");
        }
        merchPriceLabel.setText("Giá thành : " + Formatter.format(merchandiseComposite.calculate()) + " VND");
        merchDateLabel.setText("Ngày tạo : " + merchandiseComposite.getCreateDate());
        imageView.setImage(merchandiseComposite.getImage());
    }
}
