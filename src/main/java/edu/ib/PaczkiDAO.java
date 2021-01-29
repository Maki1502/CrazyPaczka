package edu.ib;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaczkiDAO {

    private DBUtil dbUtil;
    private TextArea consoleTextArea;

    public PaczkiDAO(DBUtil dbUtil, TextArea consoleTextArea) {
        this.dbUtil = dbUtil;
        this.consoleTextArea = consoleTextArea;
    }

    private ObservableList<Automats> getAutomatsList(ResultSet rs) throws SQLException{
        ObservableList<Automats> automatsList = FXCollections.observableArrayList();

        while(rs.next()){
            Automats a = new Automats();
            a.setAddress(rs.getString("automat_address"));
            a.setsAmount(rs.getInt("S_lockers_amount"));
            a.setmAmount(rs.getInt("M_lockers_amount"));
            a.setlAmount(rs.getInt("L_lockers_amount"));
            a.setShipId(rs.getInt("shipment_id"));
        }
        return automatsList;
    }

    private ObservableList<Recipients> getRecipientsList(ResultSet rs) throws SQLException{
        ObservableList<Recipients> recipientsList = FXCollections.observableArrayList();

        while(rs.next()){
            Recipients r = new Recipients();
            r.setName(rs.getString("recipient_name"));
            r.setSurname(rs.getString("recipient_surname"));
            r.setEmail(rs.getString("recipient_email"));
            r.setPhone_number(rs.getString("recipient_phone_number"));
            r.setShipId(rs.getInt("shipment_id"));
        }
        return recipientsList;
    }

    private ObservableList<Senders> getSendersList(ResultSet rs) throws SQLException{
        ObservableList<Senders> sendersList = FXCollections.observableArrayList();

        while(rs.next()){
            Senders s = new Senders();
            s.setName(rs.getString("sender_name"));
            s.setSurname(rs.getString("sender_surname"));
            s.setEmail(rs.getString("sender_email"));
            s.setPhone_number(rs.getString("sender_phone_number"));
            s.setId(rs.getInt("sender_id"));
            s.setShipId(rs.getInt("shipment_id"));
        }
        return sendersList;
    }

    private ObservableList<Shipments> getShipmentsList(ResultSet rs) throws SQLException{
        ObservableList<Shipments> shipmentsList = FXCollections.observableArrayList();

        while(rs.next()){
            Shipments p = new Shipments();
            p.setId(rs.getInt("shipment_id"));
            p.setSize(rs.getObject("shipment_package_size"));
            p.setStatus(rs.getObject("shipment_status"));
            p.setShipDate(rs.getString("shipment_date"));
            p.setRecDate(rs.getString("reception_date"));
        }
        return shipmentsList;
    }
}
