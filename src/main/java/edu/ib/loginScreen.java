package edu.ib;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class loginScreen {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private TextField city;

    @FXML
    private TextField phone;

    @FXML
    private TextField mail;

    @FXML
    private TextField password;

    @FXML
    private TextField confPassword;

    @FXML
    private Button newAcc;

    @FXML
    private Button exitNew;

    @FXML
    void makeNewAcc(ActionEvent event) {

    }

    @FXML
    void onExit(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'signIn.fxml'.";
        assert surname != null : "fx:id=\"surname\" was not injected: check your FXML file 'signIn.fxml'.";
        assert city != null : "fx:id=\"city\" was not injected: check your FXML file 'signIn.fxml'.";
        assert phone != null : "fx:id=\"phone\" was not injected: check your FXML file 'signIn.fxml'.";
        assert mail != null : "fx:id=\"mail\" was not injected: check your FXML file 'signIn.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'signIn.fxml'.";
        assert confPassword != null : "fx:id=\"confPassword\" was not injected: check your FXML file 'signIn.fxml'.";
        assert newAcc != null : "fx:id=\"newAcc\" was not injected: check your FXML file 'signIn.fxml'.";
        assert exitNew != null : "fx:id=\"exitNew\" was not injected: check your FXML file 'signIn.fxml'.";

    }
}

