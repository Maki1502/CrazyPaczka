package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    private ObservableList<ObservableList> clientView;

    @FXML
    private TableView<ObservableList> userDataTable;

    @FXML
    private TableColumn<ObservableList, Integer> idCol;

    @FXML
    private TableColumn<ObservableList, String> nameCol;

    @FXML
    private TableColumn<ObservableList, Enum> statusCol;

    @FXML
    private TableColumn<ObservableList, String> shipCol;

    @FXML
    private TableColumn<ObservableList, String> recCol;

    @FXML
    private TableColumn<ObservableList, Enum> sizeCol;

    @FXML
    private TableColumn<ObservableList, String> automatCol;

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
    void onFindDate(ActionEvent event) throws SQLException, ClassNotFoundException {

        try{
            userDataTable.getItems().clear();
            if(clientView != null) {
                clientView = paczkiDAO.clientView();
                userDataTable.setItems(clientView);
            }else{
                consoleArea.appendText("No data found. \n");
            }
        }catch (SQLException e){
            consoleArea.appendText("Error occurred while getting data from DB. \n");
        }

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
        assert idCol != null : "fx:id=\"idCol\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert nameCol != null : "fx:id=\"nameCol\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert statusCol != null : "fx:id=\"statusCol\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert shipCol != null : "fx:id=\"shipCol\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert recCol != null : "fx:id=\"recCol\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert sizeCol != null : "fx:id=\"sizeCol\" was not injected: check your FXML file 'mainScreen.fxml'.";
        assert automatCol != null : "fx:id=\"automatCol\" was not injected: check your FXML file 'mainScreen.fxml'.";
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
