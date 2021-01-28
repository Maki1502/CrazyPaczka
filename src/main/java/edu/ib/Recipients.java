package edu.ib;

import javafx.beans.property.*;

public class Recipients {
    private StringProperty name;
    private StringProperty surname;
    private StringProperty email;
    private StringProperty phone_number;
    private IntegerProperty shipId;

    public Recipients(){
        name = new SimpleStringProperty();
        surname = new SimpleStringProperty();
        email = new SimpleStringProperty();
        phone_number = new SimpleStringProperty();
        shipId = new SimpleIntegerProperty();
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

    public String getSurname() {
        return surname.get();
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPhone_number() {
        return phone_number.get();
    }

    public StringProperty phone_numberProperty() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number.set(phone_number);
    }

    public int getShipId() {
        return shipId.get();
    }

    public IntegerProperty shipIdProperty() {
        return shipId;
    }

    public void setShipId(int shipId) {
        this.shipId.set(shipId);
    }
}
