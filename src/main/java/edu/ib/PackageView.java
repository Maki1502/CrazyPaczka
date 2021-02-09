package edu.ib;

import javafx.beans.property.*;

public class PackageView {

    private IntegerProperty id;
    private StringProperty consDate;
    private StringProperty recDate;
    private IntegerProperty clId;
    private IntegerProperty recId;
    private DoubleProperty price;
    private ObjectProperty status;

    public PackageView(){
        id = new SimpleIntegerProperty();
        consDate = new SimpleStringProperty();
        recDate = new SimpleStringProperty();
        clId = new SimpleIntegerProperty();
        recId = new SimpleIntegerProperty();
        price = new SimpleDoubleProperty();
        status = new SimpleObjectProperty();
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

    public int getClId() {
        return clId.get();
    }

    public IntegerProperty clIdProperty() {
        return clId;
    }

    public void setClId(int clId) {
        this.clId.set(clId);
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

    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
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
}
