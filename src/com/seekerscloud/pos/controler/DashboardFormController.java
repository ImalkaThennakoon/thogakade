package com.seekerscloud.pos.controler;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DashboardFormController {
    public AnchorPane dashboardContext;
    public Label lblTime;
    public Label lblDate;

    public void initialize(){
        setDateAndTime();
    }

    private void setDateAndTime() {
        //set time
        Timeline time = new Timeline(
                new KeyFrame(Duration.ZERO,e->{
                    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    lblTime.setText(LocalDateTime.now().format(formatter));
                }),new KeyFrame(Duration.seconds(1)));
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public void openCustomerFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("CustomerForm");
    }

    public void openItemFormOnAction(ActionEvent actionEvent) {
    }

    public void openPlaceOrderFormOnAction(ActionEvent actionEvent) {
    }

    public void openOrderDetailsFormOnAction(ActionEvent actionEvent) {
    }
    private void setUi(String ui) throws IOException {
        Stage stage =(Stage) dashboardContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+ui+".fxml"))));
        stage.centerOnScreen();

    }
}
