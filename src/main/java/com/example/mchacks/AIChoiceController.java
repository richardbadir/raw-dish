package com.example.mchacks;

import com.example.mchacks.Entities.Window;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class AIChoiceController {


    @FXML
    private AnchorPane navBarPane;

    @FXML
    private JFXButton letUsChoose;

    @FXML
    private Text or;

    @FXML
    private JFXButton facialButton;

    @FXML
    private Label time2;
    public volatile boolean stop = false;
    @FXML
    private JFXButton manualButton;

    @FXML
    private Text promptUser;

    public void goToFacial(ActionEvent actionEvent) {
    }
    public void initialize() {
        Timenow();
    }
    private void Timenow(){
        Thread thread = new Thread(()->{
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
            while(!stop) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                final String timenow = sdf.format(new Date());
                Platform.runLater(() -> {

                    time2.setText(timenow);
                });
            }
        });
        thread.start();
    }

    public void goToForm(ActionEvent actionEvent) {
        promptUser.getScene().getWindow().hide();
        Window questionaire = new Window("src/main/resources/com/example/mchacks/questionaire.fxml","src/main/resources/com/example/mchacks/Styles/questionaire.css");
        stop = true;
        questionaire.Open();

        System.out.println("[APP] Application has opened questionnaire");
    }

}

