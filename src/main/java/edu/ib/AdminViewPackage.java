package edu.ib;

import javafx.beans.property.*;

public class AdminViewPackage {

    private IntegerProperty id;
    private DoubleProperty price;
    private StringProperty sendPlace;
    private StringProperty recPlace;
    private StringProperty status;
    private StringProperty consDate;
    private StringProperty recDate;
    private StringProperty recId;
    private IntegerProperty clientId;

    public AdminViewPackage(){
        id = new SimpleIntegerProperty();
        price = new SimpleDoubleProperty();
        sendPlace = new SimpleStringProperty();
        recPlace = new SimpleStringProperty();
        status = new SimpleStringProperty();
        consDate = new SimpleStringProperty();
        recDate = new SimpleStringProperty();
        recId = new SimpleStringProperty();
        clientId = new SimpleIntegerProperty();
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public String getSendPlace() {
        return sendPlace.get();
    }

    public StringProperty sendPlaceProperty() {
        return sendPlace;
    }

    public void setSendPlace(String sendPlace) {
        this.sendPlace.set(sendPlace);
    }

    public String getRecPlace() {
        return recPlace.get();
    }

    public StringProperty recPlaceProperty() {
        return recPlace;
    }

    public void setRecPlace(String recPlace) {
        this.recPlace.set(recPlace);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getConsDate() {
        return consDate.get();
    }

    public StringProperty consDateProperty() {
        return consDate;
    }

    public void setConsDate(String consDate) {
        this.consDate.set(consDate);
    }

    public String getRecDate() {
        return recDate.get();
    }

    public StringProperty recDateProperty() {
        return recDate;
    }

    public void setRecDate(String recDate) {
        this.recDate.set(recDate);
    }

    public String getRecId() {
        return recId.get();
    }

    public StringProperty recIdProperty() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId.set(recId);
    }

    public int getClientId() {
        return clientId.get();
    }

    public IntegerProperty clientIdProperty() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId.set(clientId);
    }
}
