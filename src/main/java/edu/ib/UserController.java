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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField senderName;

    @FXML
    private TextField senderSurname;

    @FXML
    private TextField senderCity;

    @FXML
    private TextField senderTel;

    @FXML
    private TextField senderMail;

    @FXML
    private TextField recipientName;

    @FXML
    private TextField recipientSurname;

    @FXML
    private TextField recipientCity;

    @FXML
    private TextField recipientTel;

    @FXML
    private TextField recipientMail;

    @FXML
    private GridPane tableCheckBox;

    @FXML
    private CheckBox chkS;

    @FXML
    private CheckBox chkM;

    @FXML
    private CheckBox chkL;

    @FXML
    private TextArea seePrice;

    @FXML
    private Button btnSendPackage;

    @FXML
    private Button btnExit;

    private DBUtil dbUtil;
    private PaczkiDAO paczkiDAO;

    private static Scene scenePackage;
    Stage stage = new Stage();

    @FXML
    void onBtnExit(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void onBtnSend(ActionEvent event) throws SQLException, ClassNotFoundException {

        String m1 = senderMail.getText();

        String n2 = recipientName.getText();
        String s2 = recipientSurname.getText();
        String c2 = recipientCity.getText();
        String t2 = recipientTel.getText();
        String m2 = recipientMail.getText();

        String price = null;

        if(chkS.isSelected()){
            price = "S";
        }else if(chkM.isSelected()){
            price = "M";
        }else if(chkL.isSelected()){
            price = "L";
        }

        if(!senderName.getText().equals(null) && !senderSurname.getText().equals(null) && !senderCity.getText().equals(null)
                && !senderTel.getText().equals(null) && !senderMail.getText().equals(null)
        && !recipientName.getText().equals(null) && !recipientSurname.getText().equals(null) && !recipientCity.getText().equals(null)
        && !recipientTel.getText().equals(null) && !recipientMail.getText().equals(null)) {
            String selectStmt = "CALL OrderAShipment('"+m1+"', '"+n2+"', '"+s2+"', '"+c2+"', '"+t2+"', '"+m2+"', '"+price+"');";
            dbUtil.dbExecuteUpdate(selectStmt);
        }

        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void onChkL(ActionEvent event) throws SQLException, ClassNotFoundException {

        String selectStmt = "select returnPrice('L');";
        ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
        resultSet.next();
        seePrice.clear();
        chkS.setSelected(false);
        chkM.setSelected(false);
        seePrice.appendText(resultSet.getString(1));

    }

    @FXML
    void onChkM(ActionEvent event) throws SQLException, ClassNotFoundException {
        String selectStmt = "select returnPrice('M');";
        ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
        resultSet.next();
        seePrice.clear();
        chkS.setSelected(false);
        chkL.setSelected(false);
        seePrice.appendText(resultSet.getString(1));
    }

    @FXML
    void onChkS(ActionEvent event) throws SQLException, ClassNotFoundException {
        String selectStmt = "select returnPrice('S');";
        ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
        resultSet.next();
        seePrice.clear();
        chkL.setSelected(false);
        chkM.setSelected(false);
        seePrice.appendText(resultSet.getString(1));
    }

    @FXML
    void initialize() {
        assert senderName != null : "fx:id=\"senderName\" was not injected: check your FXML file 'screen.fxml'.";
        assert senderSurname != null : "fx:id=\"senderSurname\" was not injected: check your FXML file 'screen.fxml'.";
        assert senderCity != null : "fx:id=\"senderCity\" was not injected: check your FXML file 'screen.fxml'.";
        assert senderTel != null : "fx:id=\"senderTel\" was not injected: check your FXML file 'screen.fxml'.";
        assert senderMail != null : "fx:id=\"senderMail\" was not injected: check your FXML file 'screen.fxml'.";
        assert recipientName != null : "fx:id=\"recipientName\" was not injected: check your FXML file 'screen.fxml'.";
        assert recipientSurname != null : "fx:id=\"recipientSurname\" was not injected: check your FXML file 'screen.fxml'.";
        assert recipientCity != null : "fx:id=\"recipientCity\" was not injected: check your FXML file 'screen.fxml'.";
        assert recipientTel != null : "fx:id=\"recipientTel\" was not injected: check your FXML file 'screen.fxml'.";
        assert recipientMail != null : "fx:id=\"recipientMail\" was not injected: check your FXML file 'screen.fxml'.";
        assert tableCheckBox != null : "fx:id=\"tableCheckBox\" was not injected: check your FXML file 'screen.fxml'.";
        assert chkS != null : "fx:id=\"chkS\" was not injected: check your FXML file 'screen.fxml'.";
        assert chkM != null : "fx:id=\"chkM\" was not injected: check your FXML file 'screen.fxml'.";
        assert chkL != null : "fx:id=\"chkL\" was not injected: check your FXML file 'screen.fxml'.";
        assert seePrice != null : "fx:id=\"seePrice\" was not injected: check your FXML file 'screen.fxml'.";
        assert btnSendPackage != null : "fx:id=\"btnSendPackage\" was not injected: check your FXML file 'screen.fxml'.";
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'screen.fxml'.";

        dbUtil = MainController.dbUtil;
        paczkiDAO = new PaczkiDAO(dbUtil,seePrice);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PaczkaApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}

