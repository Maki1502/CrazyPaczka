package edu.ib;

import javafx.beans.property.*;

public class Automats {
    private ObjectProperty address;
    private IntegerProperty sAmount;
    private IntegerProperty mAmount;
    private IntegerProperty lAmount;
    private IntegerProperty shipId;

    public Automats(){
        address = new SimpleObjectProperty();
        sAmount = new SimpleIntegerProperty();
        mAmount = new SimpleIntegerProperty();
        lAmount = new SimpleIntegerProperty();
        shipId = new SimpleIntegerProperty();
    }

    public Object getAddress() {
        return address.get();
    }

    public ObjectProperty addressProperty() {
        return address;
    }

    public void setAddress(Object address) {
        this.address.set(address);
    }

    public int getsAmount() {
        return sAmount.get();
    }

    public IntegerProperty sAmountProperty() {
        return sAmount;
    }

    public void setsAmount(int sAmount) {
        this.sAmount.set(sAmount);
    }

    public int getmAmount() {
        return mAmount.get();
    }

    public IntegerProperty mAmountProperty() {
        return mAmount;
    }

    public void setmAmount(int mAmount) {
        this.mAmount.set(mAmount);
    }

    public int getlAmount() {
        return lAmount.get();
    }

    public IntegerProperty lAmountProperty() {
        return lAmount;
    }

    public void setlAmount(int lAmount) {
        this.lAmount.set(lAmount);
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
