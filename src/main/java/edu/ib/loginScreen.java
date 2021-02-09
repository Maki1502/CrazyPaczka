package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginScreen {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private TextField city;

    @FXML
    private TextField phone;

    @FXML
    private TextField mail;

    @FXML
    private TextField password;

    @FXML
    private TextField confPassword;

    @FXML
    private Button newAcc;

    @FXML
    private Button exitNew;

    @FXML
    void makeNewAcc(ActionEvent event) throws IOException {

        String newName = name.getText();
        String newSurname = surname.getText();
        String newAddress = city.getText();
        String newPhone = phone.getText();
        String newMail = mail.getText();
        String pswrd1 = password.getText();
        String pswrd2 = confPassword.getText();

        if(pswrd1.equals(pswrd2)){

            //tutaj podpiac addClient i stworzyc konto nowe z uprawnieniami customera

            scenePackage = new Scene(loadFXML("/fxml/mainScreen"), 600, 400); //nwm czy tego jakos nie zmienic, na pewno niech od razu loguje
            stage.setScene(scenePackage);
            stage.setTitle("Main screen");
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();

        }else{
            String error = "Wrong password!";
            confPassword.setText(error);
        }

    }

    private static Scene scenePackage;
    Stage stage = new Stage();

    @FXML
    void onExit(ActionEvent event) throws IOException {

        scenePackage = new Scene(loadFXML("/fxml/mainScreen"), 600, 400);
        stage.setScene(scenePackage);
        stage.setTitle("Main screen");
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void initialize() {
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'signIn.fxml'.";
        assert surname != null : "fx:id=\"surname\" was not injected: check your FXML file 'signIn.fxml'.";
        assert city != null : "fx:id=\"city\" was not injected: check your FXML file 'signIn.fxml'.";
        assert phone != null : "fx:id=\"phone\" was not injected: check your FXML file 'signIn.fxml'.";
        assert mail != null : "fx:id=\"mail\" was not injected: check your FXML file 'signIn.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'signIn.fxml'.";
        assert confPassword != null : "fx:id=\"confPassword\" was not injected: check your FXML file 'signIn.fxml'.";
        assert newAcc != null : "fx:id=\"newAcc\" was not injected: check your FXML file 'signIn.fxml'.";
        assert exitNew != null : "fx:id=\"exitNew\" was not injected: check your FXML file 'signIn.fxml'.";

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PaczkaApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}

