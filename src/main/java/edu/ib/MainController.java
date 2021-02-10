package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<CustomerView> userDataTable;

    @FXML
    private TableColumn<CustomerView, Integer> idCol;

    @FXML
    private TableColumn<CustomerView, String> nameCol;

    @FXML
    private TableColumn<CustomerView, String> statusCol;

    @FXML
    private TableColumn<CustomerView, String> shipCol;

    @FXML
    private TableColumn<CustomerView, String> recCol;

    @FXML
    private TableColumn<CustomerView, String> sizeCol;

    @FXML
    private TableColumn<CustomerView, String> automatCol;

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

        try{
            userDataTable.getItems().clear();
            ObservableList<CustomerView> viewCustomer = paczkiDAO.showClientData();
            userDataTable.setItems(viewCustomer);
            userDataTable.setPlaceholder(new Label("No data to display"));
        }catch (SQLException e){
            consoleArea.appendText("Error occurred while getting data from DB. \n");
        }

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

    private boolean isLogged = false;

    @FXML
    void onBtnNewPackage(ActionEvent event) throws IOException {

        isLogged = true; //nwm czm nie dziala

        scenePackage = new Scene(loadFXML("/fxml/screen"), 600, 400);
        stage.setScene(scenePackage);
        stage.setTitle("New package");
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void onBtnSaveUser(ActionEvent event) throws IOException{
        scenePackage = new Scene(loadFXML("/fxml/signIn"), 600, 400);
        stage.setScene(scenePackage);
        stage.setTitle("Sign In");
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void onFindDate(ActionEvent event) throws SQLException, ClassNotFoundException {

        try {
            if(!findDate.getText().equals(null)){
                userDataTable.getItems().clear();
                ObservableList<CustomerView> wineData = paczkiDAO.findClientByData(findDate.getText());
                userDataTable.setItems(wineData);
                userDataTable.setPlaceholder(new Label("No data to display"));
            }
        }catch (SQLException e) {
            consoleArea.appendText("Error 200 \n");
            throw e;
        }
    }

    @FXML
    void onFindStatus(ActionEvent event) throws SQLException, ClassNotFoundException{

        try {
            if(!findStatus.getText().equals(null)){
                userDataTable.getItems().clear();
                ObservableList<CustomerView> wineData = paczkiDAO.findClientByStatus(findStatus.getText());
                userDataTable.setItems(wineData);
                userDataTable.setPlaceholder(new Label("No data to display"));
            }
        }catch (SQLException e) {
            consoleArea.appendText("Error 200 \n");
            throw e;
        }

    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
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

        idCol.setCellValueFactory(
                new PropertyValueFactory<CustomerView, Integer>("id")
        );
        nameCol.setCellValueFactory(
                new PropertyValueFactory<CustomerView, String>("name")
        );
        statusCol.setCellValueFactory(
                new PropertyValueFactory<CustomerView, String>("status")
        );
        shipCol.setCellValueFactory(
                new PropertyValueFactory<CustomerView, String>("consDate")
        );
        recCol.setCellValueFactory(
                new PropertyValueFactory<CustomerView, String>("recDate")
        );
        sizeCol.setCellValueFactory(
                new PropertyValueFactory<CustomerView, String>("size")
        );
        automatCol.setCellValueFactory(
                new PropertyValueFactory<CustomerView, String>("address")
        );

        btnLogOut.setDisable(true);
        btnNewPackage.setDisable(true);
        findDate.setDisable(true);
        btnFindDate.setDisable(true);
        findStatus.setDisable(true);
        btnFindStatus.setDisable(true);
        userDataTable.setDisable(true);

        consoleArea.appendText(String.valueOf(isLogged));

        if(isLogged == true){

            dbUtil = new DBUtil(loginName.getText(), passwordCode.getText(), consoleArea);
            paczkiDAO = new PaczkiDAO(dbUtil, consoleArea);

            dbUtil.dbConnect();

            consoleArea.appendText("Logged as "+loginName.getText()+".\n");
            btnLogIn.setDisable(true);

            btnLogOut.setDisable(false);
            btnNewPackage.setDisable(false);
            findDate.setDisable(false);
            btnFindDate.setDisable(false);
            findStatus.setDisable(false);
            btnFindStatus.setDisable(false);
            userDataTable.setDisable(false);

            try{
                userDataTable.getItems().clear();
                ObservableList<CustomerView> viewCustomer = paczkiDAO.showClientData();
                userDataTable.setItems(viewCustomer);
                userDataTable.setPlaceholder(new Label("No data to display"));
            }catch (SQLException e){
                consoleArea.appendText("Error occurred while getting data from DB. \n");
            }
        }

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PaczkaApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}
