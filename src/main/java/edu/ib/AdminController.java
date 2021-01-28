package edu.ib;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AdminController {

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
    private TextArea consoleArea;

    @FXML
    private TextField findId;

    @FXML
    private TextField deleteId;

    @FXML
    private Button btnFindId;

    @FXML
    private Button btnDeleteId;

    @FXML
    private TableView<?> packageTable;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private TableColumn<?, ?> shipDateCol;

    @FXML
    private TableColumn<?, ?> recDateCol;

    @FXML
    private TableColumn<?, ?> sizeCol;

    @FXML
    private TableColumn<?, ?> autoIdCol;

    @FXML
    void onBtnDelete(ActionEvent event) {

    }

    @FXML
    void onBtnFind(ActionEvent event) {

    }

    @FXML
    void onBtnLogIn(ActionEvent event) {

    }

    @FXML
    void onBtnLogOut(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert loginName != null : "fx:id=\"loginName\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert passwordCode != null : "fx:id=\"passwordCode\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert btnLogIn != null : "fx:id=\"btnLogIn\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert btnLogOut != null : "fx:id=\"btnLogOut\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert consoleArea != null : "fx:id=\"consoleArea\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert findId != null : "fx:id=\"findId\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert deleteId != null : "fx:id=\"deleteId\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert btnFindId != null : "fx:id=\"btnFindId\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert btnDeleteId != null : "fx:id=\"btnDeleteId\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert packageTable != null : "fx:id=\"packageTable\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert idCol != null : "fx:id=\"idCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert shipDateCol != null : "fx:id=\"shipDateCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert recDateCol != null : "fx:id=\"recDateCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert sizeCol != null : "fx:id=\"sizeCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert autoIdCol != null : "fx:id=\"autoIdCol\" was not injected: check your FXML file 'techScreen.fxml'.";

    }
}

