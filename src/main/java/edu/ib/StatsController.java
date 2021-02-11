package edu.ib;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class StatsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDailyProfit;

    @FXML
    private Button btnDailyShip;

    @FXML
    private Button btnProfit;

    @FXML
    private Button btnShip;

    @FXML
    private Button btnS;

    @FXML
    private Button btnM;

    @FXML
    private Button btnL;

    @FXML
    private TextArea textArea;

    @FXML
    private Button btnExit;

    @FXML
    void onBtnDailyProfit(ActionEvent event) {

    }

    @FXML
    void onBtnDailyShip(ActionEvent event) {

    }

    @FXML
    void onBtnExit(ActionEvent event) {

    }

    @FXML
    void onBtnL(ActionEvent event) {

    }

    @FXML
    void onBtnM(ActionEvent event) {

    }

    @FXML
    void onBtnProfit(ActionEvent event) {

    }

    @FXML
    void onBtnS(ActionEvent event) {

    }

    @FXML
    void onBtnShip(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnDailyProfit != null : "fx:id=\"btnDailyProfit\" was not injected: check your FXML file 'stats.fxml'.";
        assert btnDailyShip != null : "fx:id=\"btnDailyShip\" was not injected: check your FXML file 'stats.fxml'.";
        assert btnProfit != null : "fx:id=\"btnProfit\" was not injected: check your FXML file 'stats.fxml'.";
        assert btnShip != null : "fx:id=\"btnShip\" was not injected: check your FXML file 'stats.fxml'.";
        assert btnS != null : "fx:id=\"btnS\" was not injected: check your FXML file 'stats.fxml'.";
        assert btnM != null : "fx:id=\"btnM\" was not injected: check your FXML file 'stats.fxml'.";
        assert btnL != null : "fx:id=\"btnL\" was not injected: check your FXML file 'stats.fxml'.";
        assert textArea != null : "fx:id=\"textArea\" was not injected: check your FXML file 'stats.fxml'.";
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'stats.fxml'.";

    }
}
