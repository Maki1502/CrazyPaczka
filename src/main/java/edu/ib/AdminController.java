package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    private TableView<PackageView> packageTable;

    @FXML
    private TableColumn<PackageView, IntegerProperty> idCol;

    @FXML
    private TableColumn<PackageView, StringProperty> shipDateCol;

    @FXML
    private TableColumn<PackageView, StringProperty> recDateCol;

    @FXML
    private TableColumn<PackageView, IntegerProperty> sendCol;

    @FXML
    private TableColumn<PackageView, StringProperty> recCol;

    @FXML
    private TableColumn<PackageView, StringProperty> fromCol;

    @FXML
    private TableColumn<PackageView, StringProperty> toCol;

    @FXML
    private TableColumn<PackageView, DoubleProperty> priceCol;

    @FXML
    private TableColumn<PackageView, ObjectProperty> statusCol;

    @FXML
    private TextField findIdUser;

    @FXML
    private TextField deleteIdUser;

    @FXML
    private Button btnFindIdUser;

    @FXML
    private Button btnDeleteIdUser;

    @FXML
    private TableView<UserView> packageTable1;

    @FXML
    private TableColumn<UserView, IntegerProperty> userIdCol;

    @FXML
    private TableColumn<UserView, StringProperty> nameCol;

    @FXML
    private TableColumn<UserView, StringProperty> surnameCol;

    @FXML
    private TableColumn<UserView, StringProperty> cityCol;

    @FXML
    private TableColumn<UserView, StringProperty> mailCol;

    @FXML
    private TableColumn<UserView, StringProperty> phoneCol;

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
                ObservableList<PackageView> wineData = paczkiDAO.findAdminPackage(findIdUser.getText());
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
                ObservableList<UserView> wineData = paczkiDAO.findAdminClients(findIdUser.getText());
                packageTable1.setItems(wineData);
                packageTable1.setPlaceholder(new Label("No data to display"));
            }
        }catch (SQLException e){
            AdminConsoleArea.appendText("Error 100 \n");
            throw e;
        }
    }
    UserView userView = new UserView();

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

            ObservableList<UserView> viewUserAdmin = paczkiDAO.showAdminClients();
            ObservableList<PackageView> viewPackageAdmin = paczkiDAO.showAdminPackage();

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
