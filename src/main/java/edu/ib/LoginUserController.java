package edu.ib;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LoginUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginName;

    @FXML
    private PasswordField passwordCode;

    @FXML
    private Button btnLogIn;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnSignIn;

    @FXML
    private Button btnAdmin;

    @FXML
    private TextArea consoleArea;

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
    private ChoiceBox<?> choseSize;

    @FXML
    private TextArea seeData;

    @FXML
    private Button btnSendPackage;

    @FXML
    private Button btnSeeAll;

    @FXML
    void onBtnAdmin(ActionEvent event) {

    }

    @FXML
    void onBtnLogIn(ActionEvent event) {

    }

    @FXML
    void onBtnLogOut(ActionEvent event) {

    }

    @FXML
    void onBtnSaveUser(ActionEvent event) {

    }

    @FXML
    void onBtnSeeAll(ActionEvent event) {

    }

    @FXML
    void onBtnSend(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert loginName != null : "fx:id=\"loginName\" was not injected: check your FXML file 'screen.fxml'.";
        assert passwordCode != null : "fx:id=\"passwordCode\" was not injected: check your FXML file 'screen.fxml'.";
        assert btnLogIn != null : "fx:id=\"btnLogIn\" was not injected: check your FXML file 'screen.fxml'.";
        assert btnLogOut != null : "fx:id=\"btnLogOut\" was not injected: check your FXML file 'screen.fxml'.";
        assert btnSignIn != null : "fx:id=\"btnSignIn\" was not injected: check your FXML file 'screen.fxml'.";
        assert btnAdmin != null : "fx:id=\"btnAdmin\" was not injected: check your FXML file 'screen.fxml'.";
        assert consoleArea != null : "fx:id=\"consoleArea\" was not injected: check your FXML file 'screen.fxml'.";
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
        assert choseSize != null : "fx:id=\"choseSize\" was not injected: check your FXML file 'screen.fxml'.";
        assert seeData != null : "fx:id=\"seeData\" was not injected: check your FXML file 'screen.fxml'.";
        assert btnSendPackage != null : "fx:id=\"btnSendPackage\" was not injected: check your FXML file 'screen.fxml'.";
        assert btnSeeAll != null : "fx:id=\"btnSeeAll\" was not injected: check your FXML file 'screen.fxml'.";

    }
}

