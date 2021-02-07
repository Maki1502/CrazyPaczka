package edu.ib;

import javafx.beans.property.*;

public class ClientView {

    private IntegerProperty id;
    private StringProperty name;
    private ObjectProperty status;
    private StringProperty conDate;
    private StringProperty recDate;
    private ObjectProperty size;
    private StringProperty address;

    public ClientView(){
        id = new SimpleIntegerProperty();
        name = new SimpleStringProperty();
        status = new SimpleObjectProperty();
        conDate = new SimpleStringProperty();
        recDate = new SimpleStringProperty();
        size = new SimpleObjectProperty();
        address = new SimpleStringProperty();
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

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
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

    public String getConDate() {
        return conDate.get();
    }

    public StringProperty conDateProperty() {
        return conDate;
    }

    public void setConDate(String conDate) {
        this.conDate.set(conDate);
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

    public Object getSize() {
        return size.get();
    }

    public ObjectProperty sizeProperty() {
        return size;
    }

    public void setSize(Object size) {
        this.size.set(size);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }
}
