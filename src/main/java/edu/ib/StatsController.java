package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StatsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDailyProfit;

    @FXML
    private Button btnDailyShip;

    @FXML
    private Button btnProfit;

    @FXML
    private Button btnShip;

    @FXML
    private Button btnS;

    @FXML
    private Button btnM;

    @FXML
    private Button btnL;

    @FXML
    private TextField dateField;

    @FXML
    private TextArea textArea;

    @FXML
    private Button btnExit;

    private DBUtil dbUtil;
    private PaczkiDAO paczkiDAO;

    @FXML
    void onBtnDailyProfit(ActionEvent event) throws SQLException, ClassNotFoundException {

        String day = dateField.getText();

        String selectStmt = "select dailyProfit('"+day+"');";
        ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
        resultSet.next();
        textArea.clear();
        textArea.appendText(resultSet.getString(1));

    }

    @FXML
    void onBtnDailyShip(ActionEvent event) throws SQLException, ClassNotFoundException {

        String day = dateField.getText();

        String selectStmt = "select countDailyShipments('"+day+"');";
        ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
        resultSet.next();
        textArea.clear();
        textArea.appendText(resultSet.getString(1));

    }

    private static Scene scenePackage;
    Stage stage = new Stage();

    @FXML
    void onBtnExit(ActionEvent event){
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void onBtnL(ActionEvent event) throws SQLException, ClassNotFoundException {
        String selectStmt = "select totalPercentageOfL();";
        ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
        resultSet.next();
        textArea.clear();
        textArea.appendText(resultSet.getString(1));
    }

    @FXML
    void onBtnM(ActionEvent event) throws SQLException, ClassNotFoundException {
        String selectStmt = "select totalPercentageOfM();";
        ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
        resultSet.next();
        textArea.appendText(resultSet.getString(1));
    }

    @FXML
    void onBtnProfit(ActionEvent event) throws SQLException, ClassNotFoundException {

        String selectStmt = "select totalProfit();";
        ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
        resultSet.next();
        textArea.appendText(resultSet.getString(1));

    }

    @FXML
    void onBtnS(ActionEvent event) throws SQLException, ClassNotFoundException {
        String selectStmt = "select totalPercentageOfS();";
        ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
        resultSet.next();
        textArea.appendText(resultSet.getString(1));
    }

    @FXML
    void onBtnShip(ActionEvent event) throws SQLException, ClassNotFoundException {

        String selectStmt = "select countShipments();";
        ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
        resultSet.next();
        textArea.appendText(resultSet.getString(1));

    }

    @FXML
    void initialize() {
        assert btnDailyProfit != null : "fx:id=\"btnDailyProfit\" was not injected: check your FXML file 'stats.fxml'.";
        assert btnDailyShip != null : "fx:id=\"btnDailyShip\" was not injected: check your FXML file 'stats.fxml'.";
        assert btnProfit != null : "fx:id=\"btnProfit\" was not injected: check your FXML file 'stats.fxml'.";
        assert btnShip != null : "fx:id=\"btnShip\" was not injected: check your FXML file 'stats.fxml'.";
        assert btnS != null : "fx:id=\"btnS\" was not injected: check your FXML file 'stats.fxml'.";
        assert btnM != null : "fx:id=\"btnM\" was not injected: check your FXML file 'stats.fxml'.";
        assert btnL != null : "fx:id=\"btnL\" was not injected: check your FXML file 'stats.fxml'.";
        assert dateField != null : "fx:id=\"dateField\" was not injected: check your FXML file 'stats.fxml'.";
        assert textArea != null : "fx:id=\"textArea\" was not injected: check your FXML file 'stats.fxml'.";
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'stats.fxml'.";

        dbUtil = AdminController.dbUtil;
        paczkiDAO = new PaczkiDAO(dbUtil,textArea);

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PaczkaApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}
