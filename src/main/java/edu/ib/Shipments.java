package edu.ib;

import javafx.beans.property.*;

public class Shipments {

    private IntegerProperty id;
    private ObjectProperty size; //?
    private DoubleProperty price;
    private StringProperty sendPlace;
    private StringProperty recPlace;
    private ObjectProperty status; //?
    private StringProperty consDate;
    private StringProperty shipDate;
    private StringProperty deliDate;
    private StringProperty recDate;
    private IntegerProperty recId;
    private IntegerProperty clientId;
    private StringProperty autoAddress;

    public Shipments(){
        id = new SimpleIntegerProperty();
        size = new SimpleObjectProperty();
        price = new SimpleDoubleProperty();
        sendPlace = new SimpleStringProperty();
        recPlace = new SimpleStringProperty();
        status = new SimpleObjectProperty();
        consDate = new SimpleStringProperty();
        shipDate = new SimpleStringProperty();
        deliDate = new SimpleStringProperty();
        recDate = new SimpleStringProperty();
        recId = new SimpleIntegerProperty();
        clientId = new SimpleIntegerProperty();
        autoAddress = new SimpleStringProperty();
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

    public Object getSize() {
        return size.get();
    }

    public ObjectProperty sizeProperty() {
        return size;
    }

    public void setSize(Object size) {
        this.size.set(size);
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

    public Object getStatus() {
        return status.get();
    }

    public ObjectProperty statusProperty() {
        return status;
    }

    public void setStatus(Object status) {
        this.status.set(status);
    }

    public String getShipDate() {
        return shipDate.get();
    }

    public StringProperty shipDateProperty() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate.set(shipDate);
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

    public int getRecId() {
        return recId.get();
    }

    public IntegerProperty recIdProperty() {
        return recId;
    }

    public void setRecId(int recId) {
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

    public String getAutoAddress() {
        return autoAddress.get();
    }

    public StringProperty autoAddressProperty() {
        return autoAddress;
    }

    public void setAutoAddress(String autoAddress) {
        this.autoAddress.set(autoAddress);
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

    public String getDeliDate() {
        return deliDate.get();
    }

    public StringProperty deliDateProperty() {
        return deliDate;
    }

    public void setDeliDate(String deliDate) {
        this.deliDate.set(deliDate);
    }
}
