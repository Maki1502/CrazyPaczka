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
    private TableView<Shipments> packageTable;

    @FXML
    private TableColumn<Shipments, Integer> idCol;

    @FXML
    private TableColumn<Shipments, String> shipDateCol;

    @FXML
    private TableColumn<Shipments, String> recDateCol;

    @FXML
    private TableColumn<Shipments, Integer> sendCol;

    @FXML
    private TableColumn<Shipments, String> recCol;

    @FXML
    private TableColumn<Shipments, String> fromCol;

    @FXML
    private TableColumn<Shipments, String> toCol;

    @FXML
    private TableColumn<Shipments, Double> priceCol;

    @FXML
    private TableColumn<Shipments, Enum> statusCol;

    @FXML
    private TextField findIdUser;

    @FXML
    private TextField deleteIdUser;

    @FXML
    private Button btnFindIdUser;

    @FXML
    private Button btnDeleteIdUser;

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

    private DBUtil dbUtil;
    private PaczkiDAO paczkiDAO;

    private static Scene scenePackage;
    Stage stage = new Stage();

    @FXML
    void onBtnDeleteIdPackage(ActionEvent event) {
        //work in progress
    }

    @FXML
    void onBtnDeleteIdUser(ActionEvent event) {
        //work in progress
    }

    @FXML
    void onBtnFindIdPackage(ActionEvent event) throws SQLException, ClassNotFoundException{
        try{
            if(!findIdPackage.getText().equals(null)){
                packageTable.getItems().clear();
                ObservableList<Shipments> wineData = paczkiDAO.findAdminPackage(findIdPackage.getText());
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
            if(!findIdUser.getText().equals(null)){
                packageTable1.getItems().clear();
                ObservableList<Clients> wineData = paczkiDAO.findAdminClients(findIdUser.getText());
                packageTable1.setItems(wineData);
                packageTable1.setPlaceholder(new Label("No data to display"));
            }
        }catch (SQLException e){
            AdminConsoleArea.appendText("Error 100 \n");
            throw e;
        }
    }

    @FXML
    void onBtnLogIn(ActionEvent event) throws SQLException, ClassNotFoundException {
        dbUtil = new DBUtil(adminName.getText(), AdminPasswordCode.getText(), AdminConsoleArea);
        paczkiDAO = new PaczkiDAO(dbUtil, AdminConsoleArea);

        dbUtil.dbConnect();

        AdminConsoleArea.appendText("Access granted for user \""+adminName.getText()+"\"."+"\n");
        btnAdminLogIn.setDisable(true);
        btnAdminLogOut.setDisable(false);

        findIdPackage.setDisable(false);
        deleteIdPackage.setDisable(false);
        btnFindIdPackage.setDisable(false);
        btnDeleteIdPackage.setDisable(false);
        packageTable.setDisable(false);
        findIdUser.setDisable(false);
        deleteIdUser.setDisable(false);
        btnFindIdUser.setDisable(false);
        deleteIdUser.setDisable(false);
        btnDeleteIdUser.setDisable(false);
        packageTable1.setDisable(false);

       try{
            packageTable.getItems().clear();
            packageTable1.getItems().clear();

            ObservableList<Clients> viewUserAdmin = paczkiDAO.showAdminClients();
            ObservableList<Shipments> viewPackageAdmin = paczkiDAO.showAdminPackage();

            packageTable.setItems(viewPackageAdmin);
            packageTable1.setItems(viewUserAdmin);

            packageTable.setPlaceholder(new Label("No data to display"));
            packageTable1.setPlaceholder(new Label("No data to display"));

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
        deleteIdPackage.setDisable(true);
        btnFindIdPackage.setDisable(true);
        btnDeleteIdPackage.setDisable(true);
        packageTable.setDisable(true);
        findIdUser.setDisable(true);
        deleteIdUser.setDisable(true);
        btnFindIdUser.setDisable(true);
        deleteIdUser.setDisable(true);
        btnDeleteIdUser.setDisable(true);
        packageTable1.setDisable(true);


        scenePackage = new Scene(loadFXML("/fxml/mainScreen"), 600, 400);
        stage.setScene(scenePackage);
        stage.setTitle("Main screen");
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();

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
        assert sendCol != null : "fx:id=\"sendCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert recCol != null : "fx:id=\"recCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert fromCol != null : "fx:id=\"fromCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert toCol != null : "fx:id=\"toCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert priceCol != null : "fx:id=\"priceCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert statusCol != null : "fx:id=\"statusCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert findIdUser != null : "fx:id=\"findIdUser\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert deleteIdUser != null : "fx:id=\"deleteIdUser\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert btnFindIdUser != null : "fx:id=\"btnFindIdUser\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert btnDeleteIdUser != null : "fx:id=\"btnDeleteIdUser\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert packageTable1 != null : "fx:id=\"packageTable1\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert userIdCol != null : "fx:id=\"userIdCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert nameCol != null : "fx:id=\"nameCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert surnameCol != null : "fx:id=\"surnameCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert cityCol != null : "fx:id=\"cityCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert mailCol != null : "fx:id=\"mailCol\" was not injected: check your FXML file 'techScreen.fxml'.";
        assert phoneCol != null : "fx:id=\"phoneCol\" was not injected: check your FXML file 'techScreen.fxml'.";

        idCol.setCellValueFactory(
                new PropertyValueFactory<Shipments, Integer>("id")
        );
        shipDateCol.setCellValueFactory(
                new PropertyValueFactory<Shipments, String>("consDate")
        );
        recDateCol.setCellValueFactory(
                new PropertyValueFactory<Shipments, String>("recDate")
        );
        sendCol.setCellValueFactory(
                new PropertyValueFactory<Shipments, Integer>("clId")
        );
        recCol.setCellValueFactory(
                new PropertyValueFactory<Shipments, String>("recId")
        );
        fromCol.setCellValueFactory(
                new PropertyValueFactory<Shipments, String>("")
        );
        toCol.setCellValueFactory(
                new PropertyValueFactory<Shipments, String>("")
        );
        priceCol.setCellValueFactory(
                new PropertyValueFactory<Shipments, Double>("price")
        );
        statusCol.setCellValueFactory(
                new PropertyValueFactory<Shipments, Enum>("status")
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
        deleteIdPackage.setDisable(true);
        btnFindIdPackage.setDisable(true);
        btnDeleteIdPackage.setDisable(true);
        packageTable.setDisable(true);
        findIdUser.setDisable(true);
        deleteIdUser.setDisable(true);
        btnFindIdUser.setDisable(true);
        deleteIdUser.setDisable(true);
        btnDeleteIdUser.setDisable(true);
        packageTable1.setDisable(true);

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PaczkaApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}
