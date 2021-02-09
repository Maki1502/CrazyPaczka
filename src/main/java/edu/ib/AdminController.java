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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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

    private ObservableList<PackageView> adminViewPackage;

    @FXML
    private TableView<PackageView> packageTable;

    @FXML
    private TableColumn<PackageView, Integer> idCol;

    @FXML
    private TableColumn<PackageView, String> shipDateCol;

    @FXML
    private TableColumn<PackageView, String> recDateCol;

    @FXML
    private TableColumn<PackageView, Integer> sendCol;

    @FXML
    private TableColumn<PackageView, Integer> recCol;

    @FXML
    private TableColumn<PackageView, String> fromCol;

    @FXML
    private TableColumn<PackageView, String> toCol;

    @FXML
    private TableColumn<PackageView, Double> priceCol;

    @FXML
    private TableColumn<PackageView, Enum> statusCol;

    @FXML
    private TextField findIdUser;

    @FXML
    private TextField deleteIdUser;

    @FXML
    private Button btnFindIdUser;

    @FXML
    private Button btnDeleteIdUser;

    private ObservableList<UserView> adminViewUser;

    @FXML
    private TableView<UserView> packageTable1;

    @FXML
    private TableColumn<UserView, Integer> userIdCol;

    @FXML
    private TableColumn<UserView, String> nameCol;

    @FXML
    private TableColumn<UserView, String> surnameCol;

    @FXML
    private TableColumn<UserView, String> cityCol;

    @FXML
    private TableColumn<UserView, String> mailCol;

    @FXML
    private TableColumn<UserView, String> phoneCol;

    private DBUtil dbUtil;
    private PaczkiDAO paczkiDAO;

    private static Scene scenePackage;
    Stage stage = new Stage();

    @FXML
    void onBtnDeleteIdPackage(ActionEvent event) {

    }

    @FXML
    void onBtnDeleteIdUser(ActionEvent event) {

    }

    @FXML
    void onBtnFindIdPackage(ActionEvent event) throws SQLException, ClassNotFoundException{
        try{
            if(!findIdPackage.getText().equals(null)){
                packageTable.getItems().clear();
                ObservableList<PackageView> wineData = paczkiDAO.findAdminPackage(findIdUser.getText());
                packageTable.setItems(wineData);
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
            adminViewUser = paczkiDAO.showAdminClients();
            packageTable1.setItems(adminViewUser);

            if(adminViewUser.equals(null)){
                AdminConsoleArea.appendText("No data found. \n");
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
