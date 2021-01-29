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
    private TextField adminName;

    @FXML
    private PasswordField AdminPasswordCode;

    @FXML
    private Button btnAdminLogIn;

    @FXML
    private Button btnAdminLogOut;

    @FXML
    private TextArea AdminConsoleArea;

    @FXML
    private TextField findIdPackage;

    @FXML
    private TextField deleteIdPackage;

    @FXML
    private Button btnFindIdPackage;

    @FXML
    private Button btnDeleteIdPackage;

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
    private TextField findIdUser;

    @FXML
    private TextField deleteIdUser;

    @FXML
    private Button btnFindIdUser;

    @FXML
    private Button btnDeleteIdUser;

    @FXML
    private TableView<?> packageTable1;

    @FXML
    private TableColumn<?, ?> userIdCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> surnameCol;

    @FXML
    private TableColumn<?, ?> mailCol;

    @FXML
    private TableColumn<?, ?> phoneCol;

    @FXML
    private TableColumn<?, ?> cityCol;

    @FXML
    void onBtnDeleteIdPackage(ActionEvent event) {

    }

    @FXML
    void onBtnDeleteIdUser(ActionEvent event) {

    }

    @FXML
    void onBtnFindIdPackage(ActionEvent event) {

    }

    @FXML
    void onBtnFindIdUser(ActionEvent event) {

    }

    @FXML
    void onBtnLogIn(ActionEvent event) {

    }

    @FXML
    void onBtnLogOut(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert adminName != null : "fx:id=\"adminName\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert AdminPasswordCode != null : "fx:id=\"AdminPasswordCode\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert btnAdminLogIn != null : "fx:id=\"btnAdminLogIn\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert btnAdminLogOut != null : "fx:id=\"btnAdminLogOut\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert AdminConsoleArea != null : "fx:id=\"AdminConsoleArea\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert findIdPackage != null : "fx:id=\"findIdPackage\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert deleteIdPackage != null : "fx:id=\"deleteIdPackage\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert btnFindIdPackage != null : "fx:id=\"btnFindIdPackage\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert btnDeleteIdPackage != null : "fx:id=\"btnDeleteIdPackage\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert packageTable != null : "fx:id=\"packageTable\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert idCol != null : "fx:id=\"idCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert shipDateCol != null : "fx:id=\"shipDateCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert recDateCol != null : "fx:id=\"recDateCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert sizeCol != null : "fx:id=\"sizeCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert autoIdCol != null : "fx:id=\"autoIdCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert findIdUser != null : "fx:id=\"findIdUser\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert deleteIdUser != null : "fx:id=\"deleteIdUser\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert btnFindIdUser != null : "fx:id=\"btnFindIdUser\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert btnDeleteIdUser != null : "fx:id=\"btnDeleteIdUser\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert packageTable1 != null : "fx:id=\"packageTable1\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert userIdCol != null : "fx:id=\"userIdCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert nameCol != null : "fx:id=\"nameCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert surnameCol != null : "fx:id=\"surnameCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert mailCol != null : "fx:id=\"mailCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert phoneCol != null : "fx:id=\"phoneCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert cityCol != null : "fx:id=\"cityCol\" was not injected: check your FXML file 'techScreen.fxml'.";

    }
}
