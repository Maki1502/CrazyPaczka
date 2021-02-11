package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
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
    private Button btnStats;

    @FXML
    private Button btnPackages;

    @FXML
    private TextField findIdPackage;

    @FXML
    private TextField deleteIdPackage;

    @FXML
    private Button btnFindIdPackage;

    @FXML
    private Button btnOnMyWay;

    @FXML
    private Button btnArrived;

    @FXML
    private Button btnReceived;

    @FXML
    private TableView<AdminViewPackage> packageTable;

    @FXML
    private TableColumn<AdminViewPackage, Integer> idCol;

    @FXML
    private TableColumn<AdminViewPackage, String> shipDateCol;

    @FXML
    private TableColumn<AdminViewPackage, String> recDateCol;

    @FXML
    private TableColumn<AdminViewPackage, Integer> sendCol;

    @FXML
    private TableColumn<AdminViewPackage, String> recCol;

    @FXML
    private TableColumn<AdminViewPackage, String> fromCol;

    @FXML
    private TableColumn<AdminViewPackage, String> toCol;

    @FXML
    private TableColumn<AdminViewPackage, Double> priceCol;

    @FXML
    private TableColumn<AdminViewPackage, String> statusCol;

    @FXML
    private TextField findIdUser;

    @FXML
    private Button btnFindIdUser;

    @FXML
    private TableView<Clients> packageTable1;

    @FXML
    private TableColumn<Clients, Integer> userIdCol;

    @FXML
    private TableColumn<Clients, String> nameCol;

    @FXML
    private TableColumn<Clients, String> surnameCol;

    @FXML
    private TableColumn<Clients, String> cityCol;

    @FXML
    private TableColumn<Clients, String> mailCol;

    @FXML
    private TableColumn<Clients, String> phoneCol;

    public static DBUtil dbUtil;
    private PaczkiDAO paczkiDAO;

    private static Scene scenePackage;
    Stage stage = new Stage();

    @FXML
    void onBtnFindIdPackage(ActionEvent event) throws SQLException, ClassNotFoundException{
        try{
            if(!findIdPackage.getText().equals(null)){
                packageTable.getItems().clear();
                ObservableList<AdminViewPackage> wineData = paczkiDAO.findAdminPackage(findIdPackage.getText());
                packageTable.setItems(wineData);
                packageTable.setPlaceholder(new Label("No data to display"));
            }
        }catch (SQLException e){
            AdminConsoleArea.appendText("Error 200 \n");
            throw e;
        }
    }

    @FXML
    void onBtnFindIdUser(ActionEvent event) throws SQLException, ClassNotFoundException{
        try{
                packageTable1.getItems().clear();
                ObservableList<Clients> wineData = paczkiDAO.findAdminClients(findIdUser.getText());
                packageTable1.setItems(wineData);
                packageTable1.setPlaceholder(new Label("No data to display"));

        }catch (SQLException e){
            AdminConsoleArea.appendText("Error 100 \n");
            throw e;
        }
    }

    @FXML
    void onBtnLogIn(ActionEvent event) throws SQLException, ClassNotFoundException {
        dbUtil = new DBUtil(adminName.getText(), AdminPasswordCode.getText(), AdminConsoleArea);
        paczkiDAO = new PaczkiDAO(dbUtil, AdminConsoleArea);
        boolean isAdmin = dbUtil.getUserName().contains("AdminSCP");
        String selectStmt = "SELECT client_password FROM clients WHERE client_email like '%"+adminName.getText()+"%';";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
            if((isAdmin)&&(resultSet == AdminPasswordCode)) {
                dbUtil.dbConnect();

                AdminConsoleArea.appendText("Access granted for user \"" + adminName.getText() + "\"." + "\n");
                btnAdminLogIn.setDisable(true);
                btnAdminLogOut.setDisable(false);

        findIdPackage.setDisable(false);
        deleteIdPackage.setDisable(false);
        btnFindIdPackage.setDisable(false);
        packageTable.setDisable(false);
        findIdUser.setDisable(false);
        btnFindIdUser.setDisable(false);
        packageTable1.setDisable(false);

                try {
                    packageTable.getItems().clear();
                    packageTable1.getItems().clear();

                    ObservableList<Clients> viewUserAdmin = paczkiDAO.showAdminClients();
                    ObservableList<AdminViewPackage> viewPackageAdmin = paczkiDAO.showAdminPackage();

                    packageTable.setItems(viewPackageAdmin);
                    packageTable1.setItems(viewUserAdmin);

                    packageTable.setPlaceholder(new Label("No data to display"));
                    packageTable1.setPlaceholder(new Label("No data to display"));

                } catch (SQLException e) {
                    AdminConsoleArea.appendText("Error occurred while getting data from DB. \n");
                }
            }
        }catch (SQLException e){
            AdminConsoleArea.appendText("Error occurred while getting data from DB. \n");
        }
    }

    @FXML
    void onBtnLogOut(ActionEvent event) throws IOException, SQLException {

        dbUtil.dbDisconnect();
        btnAdminLogIn.setDisable(false);

        btnAdminLogOut.setDisable(true);
        findIdPackage.setDisable(true);
        btnFindIdPackage.setDisable(true);
        packageTable.setDisable(true);
        findIdUser.setDisable(true);
        btnFindIdUser.setDisable(true);
        packageTable1.setDisable(true);
        btnStats.setDisable(true);
        btnOnMyWay.setDisable(true);
        btnArrived.setDisable(true);
        btnReceived.setDisable(true);


        scenePackage = new Scene(loadFXML("/fxml/mainScreen"), 720,400);
        stage.setScene(scenePackage);
        stage.setTitle("Main screen");
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void onBtnOnMyWay(ActionEvent event) throws SQLException, ClassNotFoundException {
        if(!findIdPackage.getText().equals(null)) {
            String selectStmt = "CALL SendPackage('" + findIdPackage.getText() + "');";
            dbUtil.dbExecuteUpdate(selectStmt);
        }
    }

    @FXML
    void onBtnArrived(ActionEvent event) throws SQLException, ClassNotFoundException {
        if(!findIdPackage.getText().equals(null)) {
            String selectStmt = "CALL DeliverPackage('" + findIdPackage.getText() + "');";
            dbUtil.dbExecuteUpdate(selectStmt);
        }
    }

    @FXML
    void onBtnReceived(ActionEvent event) throws SQLException, ClassNotFoundException {
        if(!findIdPackage.getText().equals(null)) {
            String selectStmt = "CALL PickUpPackage('" + findIdPackage.getText() + "');";
            dbUtil.dbExecuteUpdate(selectStmt);
        }
    }

    @FXML
    void onBtnStats(ActionEvent event) throws IOException {
        scenePackage = new Scene(loadFXML("/fxml/stats"), 600, 400);
        stage.setScene(scenePackage);
        stage.setTitle("Statistics");
        stage.show();
    }

    @FXML
    void initialize() {
        assert adminName != null : "fx:id=\"adminName\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert AdminPasswordCode != null : "fx:id=\"AdminPasswordCode\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert btnAdminLogIn != null : "fx:id=\"btnAdminLogIn\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert btnAdminLogOut != null : "fx:id=\"btnAdminLogOut\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert AdminConsoleArea != null : "fx:id=\"AdminConsoleArea\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert btnStats != null : "fx:id=\"btnStats\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert findIdPackage != null : "fx:id=\"findIdPackage\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert btnFindIdPackage != null : "fx:id=\"btnFindIdPackage\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert btnOnMyWay != null : "fx:id=\"btnOnMyWay\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert btnArrived != null : "fx:id=\"btnArrived\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert btnReceived != null : "fx:id=\"btnReceived\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert packageTable != null : "fx:id=\"packageTable\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert idCol != null : "fx:id=\"idCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert shipDateCol != null : "fx:id=\"shipDateCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert recDateCol != null : "fx:id=\"recDateCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert sendCol != null : "fx:id=\"sendCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert recCol != null : "fx:id=\"recCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert fromCol != null : "fx:id=\"fromCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert toCol != null : "fx:id=\"toCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert priceCol != null : "fx:id=\"priceCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert statusCol != null : "fx:id=\"statusCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert findIdUser != null : "fx:id=\"findIdUser\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert btnFindIdUser != null : "fx:id=\"btnFindIdUser\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert packageTable1 != null : "fx:id=\"packageTable1\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert userIdCol != null : "fx:id=\"userIdCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert nameCol != null : "fx:id=\"nameCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert surnameCol != null : "fx:id=\"surnameCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert cityCol != null : "fx:id=\"cityCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert mailCol != null : "fx:id=\"mailCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert phoneCol != null : "fx:id=\"phoneCol\" was not injected: check your FXML file 'techScreen.fxml'.";


        idCol.setCellValueFactory(
                new PropertyValueFactory<AdminViewPackage, Integer>("id")
        );
        shipDateCol.setCellValueFactory(
                new PropertyValueFactory<AdminViewPackage, String>("consDate")
        );
        recDateCol.setCellValueFactory(
                new PropertyValueFactory<AdminViewPackage, String>("recDate")
        );
        sendCol.setCellValueFactory(
                new PropertyValueFactory<AdminViewPackage, Integer>("clientId")
        );
        recCol.setCellValueFactory(
                new PropertyValueFactory<AdminViewPackage, String>("recId")
        );
        fromCol.setCellValueFactory(
                new PropertyValueFactory<AdminViewPackage, String>("sendPlace")
        );
        toCol.setCellValueFactory(
                new PropertyValueFactory<AdminViewPackage, String>("recPlace")
        );
        priceCol.setCellValueFactory(
                new PropertyValueFactory<AdminViewPackage, Double>("price")
        );
        statusCol.setCellValueFactory(
                new PropertyValueFactory<AdminViewPackage, String>("status")
        );


        userIdCol.setCellValueFactory(
                new PropertyValueFactory<Clients, Integer>("id")
        );
        nameCol.setCellValueFactory(
                new PropertyValueFactory<Clients, String>("name")
        );
        surnameCol.setCellValueFactory(
                new PropertyValueFactory<Clients, String>("surname")
        );
        cityCol.setCellValueFactory(
                new PropertyValueFactory<Clients, String>("address")
        );
        mailCol.setCellValueFactory(
                new PropertyValueFactory<Clients, String>("email")
        );
        phoneCol.setCellValueFactory(
                new PropertyValueFactory<Clients, String>("phone_number")
        );

        btnAdminLogOut.setDisable(true);
        findIdPackage.setDisable(true);
        btnFindIdPackage.setDisable(true);
        packageTable.setDisable(true);
        findIdUser.setDisable(true);
        btnFindIdUser.setDisable(true);
        packageTable1.setDisable(true);
        btnStats.setDisable(true);
        btnOnMyWay.setDisable(true);
        btnArrived.setDisable(true);
        btnReceived.setDisable(true);

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PaczkaApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}
