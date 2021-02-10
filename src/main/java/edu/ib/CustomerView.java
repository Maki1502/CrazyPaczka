package edu.ib;

import javafx.beans.property.*;

public class CustomerView {

    private IntegerProperty id;
    private StringProperty name;
    private StringProperty status;
    private StringProperty consDate;
    private StringProperty recDate;
    private StringProperty size;
    private StringProperty address;

    public CustomerView(){
        id = new SimpleIntegerProperty();
        name = new SimpleStringProperty();
        status = new SimpleStringProperty();
        consDate = new SimpleStringProperty();
        recDate = new SimpleStringProperty();
        size = new SimpleStringProperty();
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

    public String getSize() {
        return size.get();
    }

    public StringProperty sizeProperty() {
        return size;
    }

    public void setSize(String size) {
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
