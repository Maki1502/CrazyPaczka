package edu.ib;

import javafx.beans.property.*;


public class Shipments {

    private IntegerProperty id;
    private ObjectProperty size; //?
    private ObjectProperty status; //?
    private StringProperty shipDate;
    private StringProperty recDate;

    public Shipments(){
        id = new SimpleIntegerProperty();
        size = new SimpleObjectProperty();
        status = new SimpleObjectProperty();
        shipDate = new SimpleStringProperty();
        recDate = new SimpleStringProperty();
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
}
