package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {

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
    private TableView<?> userDataTable;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> statusCol;

    @FXML
    private TableColumn<?, ?> fromCol;

    @FXML
    private TableColumn<?, ?> toCol;

    @FXML
    private TableColumn<?, ?> shipCol;

    @FXML
    private TableColumn<?, ?> recCol;

    @FXML
    private TableColumn<?, ?> priceCol;

    @FXML
    private Button btnFindDate;

    @FXML
    private Button btnFindStatus;

    @FXML
    private TextField findDate;

    @FXML
    private TextField findStatus;

    @FXML
    private Button btnNewPackage;

    private DBUtil dbUtil;
    private PaczkiDAO paczkiDAO;

    private static Scene scenePackage;
    Stage stage = new Stage();

    @FXML
    void onBtnAdmin(ActionEvent event) throws IOException { //done
        scenePackage = new Scene(loadFXML("/fxml/techScreen"), 800, 500);
        stage.setScene(scenePackage);
        stage.setTitle("Admin mode");
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void onBtnLogIn(ActionEvent event) throws SQLException, ClassNotFoundException { //done
        dbUtil = new DBUtil(loginName.getText(), passwordCode.getText(), consoleArea);
        paczkiDAO = new PaczkiDAO(dbUtil, consoleArea);

        dbUtil.dbConnect();

        consoleArea.appendText("Access granted for user \""+loginName.getText()+"\"."+"\n");
        btnLogIn.setDisable(true);

        btnLogOut.setDisable(false);
        btnNewPackage.setDisable(false);
        findDate.setDisable(false);
        btnFindDate.setDisable(false);
        findStatus.setDisable(false);
        btnFindStatus.setDisable(false);
        userDataTable.setDisable(false);

    }

    @FXML
    void onBtnLogOut(ActionEvent event) throws SQLException {

        dbUtil.dbDisconnect();
        btnLogIn.setDisable(false);
        btnLogOut.setDisable(true);

        btnNewPackage.setDisable(true);
        findDate.setDisable(true);
        btnFindDate.setDisable(true);
        findStatus.setDisable(true);
        btnFindStatus.setDisable(true);
        userDataTable.setDisable(true);

        findDate.clear();
        findStatus.clear();
        userDataTable.getItems().clear();

        loginName.clear();
        passwordCode.clear();
    }

    @FXML
    void onBtnNewPackage(ActionEvent event) throws IOException {

        scenePackage = new Scene(loadFXML("/fxml/screen"), 600, 400);
        stage.setScene(scenePackage);
        stage.setTitle("New package");
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void onBtnSaveUser(ActionEvent event) {

    }

    @FXML
    void onFindDate(ActionEvent event) {

    }

    @FXML
    void onFindStatus(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert loginName != null : "fx:id=\"loginName\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert passwordCode != null : "fx:id=\"passwordCode\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert btnLogIn != null : "fx:id=\"btnLogIn\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert btnLogOut != null : "fx:id=\"btnLogOut\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert btnSignIn != null : "fx:id=\"btnSignIn\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert btnAdmin != null : "fx:id=\"btnAdmin\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert consoleArea != null : "fx:id=\"consoleArea\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert userDataTable != null : "fx:id=\"userDataTable\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert nameCol != null : "fx:id=\"nameCol\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert statusCol != null : "fx:id=\"statusCol\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert fromCol != null : "fx:id=\"fromCol\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert toCol != null : "fx:id=\"toCol\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert shipCol != null : "fx:id=\"shipCol\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert recCol != null : "fx:id=\"recCol\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert priceCol != null : "fx:id=\"priceCol\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert btnFindDate != null : "fx:id=\"btnFindDate\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert btnFindStatus != null : "fx:id=\"btnFindStatus\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert findDate != null : "fx:id=\"findDate\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert findStatus != null : "fx:id=\"findStatus\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert btnNewPackage != null : "fx:id=\"btnNewPackage\" was not injected: check your FXML file 'mainScreen.fxml'.";


        btnLogOut.setDisable(true);
        btnNewPackage.setDisable(true);
        findDate.setDisable(true);
        btnFindDate.setDisable(true);
        findStatus.setDisable(true);
        btnFindStatus.setDisable(true);
        userDataTable.setDisable(true);

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PaczkaApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}
