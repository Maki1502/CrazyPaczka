package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField senderName;

    @FXML
    private TextField senderSurname;

    @FXML
    private TextField senderCity;

    @FXML
    private TextField senderTel;

    @FXML
    private TextField senderMail;

    @FXML
    private TextField recipientName;

    @FXML
    private TextField recipientSurname;

    @FXML
    private TextField recipientCity;

    @FXML
    private TextField recipientTel;

    @FXML
    private TextField recipientMail;

    @FXML
    private GridPane tableCheckBox;

    @FXML
    private CheckBox chkS;

    @FXML
    private CheckBox chkM;

    @FXML
    private CheckBox chkL;

    @FXML
    private TextArea seePrice;

    @FXML
    private Button btnSendPackage;

    @FXML
    private Button btnExit;

    private DBUtil dbUtil;
    private PaczkiDAO paczkiDAO;

    private static Scene scenePackage;
    Stage stage = new Stage();

    @FXML
    void onBtnExit(ActionEvent event) throws IOException {
        scenePackage = new Scene(loadFXML("/fxml/mainScreen"), 600, 400);
        stage.setScene(scenePackage);
        stage.setTitle("Main screen");
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void onBtnSend(ActionEvent event) {

        //tutaj podpiac sendPackage

    }

    @FXML
    void onChkL(ActionEvent event) {

        //tych chyba nie trzeba uzywac, tylko w send dac, ze jak ten wcisniety to taki rozmiar

    }

    @FXML
    void onChkM(ActionEvent event) {

    }

    @FXML
    void onChkS(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert senderName != null : "fx:id=\"senderName\" was not injected: check your FXML file 'screen.fxml'.";
        assert senderSurname != null : "fx:id=\"senderSurname\" was not injected: check your FXML file 'screen.fxml'.";
        assert senderCity != null : "fx:id=\"senderCity\" was not injected: check your FXML file 'screen.fxml'.";
        assert senderTel != null : "fx:id=\"senderTel\" was not injected: check your FXML file 'screen.fxml'.";
        assert senderMail != null : "fx:id=\"senderMail\" was not injected: check your FXML file 'screen.fxml'.";
        assert recipientName != null : "fx:id=\"recipientName\" was not injected: check your FXML file 'screen.fxml'.";
        assert recipientSurname != null : "fx:id=\"recipientSurname\" was not injected: check your FXML file 'screen.fxml'.";
        assert recipientCity != null : "fx:id=\"recipientCity\" was not injected: check your FXML file 'screen.fxml'.";
        assert recipientTel != null : "fx:id=\"recipientTel\" was not injected: check your FXML file 'screen.fxml'.";
        assert recipientMail != null : "fx:id=\"recipientMail\" was not injected: check your FXML file 'screen.fxml'.";
        assert tableCheckBox != null : "fx:id=\"tableCheckBox\" was not injected: check your FXML file 'screen.fxml'.";
        assert chkS != null : "fx:id=\"chkS\" was not injected: check your FXML file 'screen.fxml'.";
        assert chkM != null : "fx:id=\"chkM\" was not injected: check your FXML file 'screen.fxml'.";
        assert chkL != null : "fx:id=\"chkL\" was not injected: check your FXML file 'screen.fxml'.";
        assert seePrice != null : "fx:id=\"seePrice\" was not injected: check your FXML file 'screen.fxml'.";
        assert btnSendPackage != null : "fx:id=\"btnSendPackage\" was not injected: check your FXML file 'screen.fxml'.";
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'screen.fxml'.";

        dbUtil = MainController.dbUtil;
        paczkiDAO = new PaczkiDAO(dbUtil,seePrice);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PaczkaApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}

