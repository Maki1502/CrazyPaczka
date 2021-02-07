package edu.ib;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
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
        }
        return automatsList;
    }

    private ObservableList<Clients> getSendersList(ResultSet rs) throws SQLException{
        ObservableList<Clients> sendersList = FXCollections.observableArrayList();

        while(rs.next()){
            Clients s = new Clients();
            s.setId(rs.getInt("client_id"));
            s.setName(rs.getString("client_name"));
            s.setSurname(rs.getString("client_surname"));
            s.setAddress(rs.getString("client_address"));
            s.setEmail(rs.getString("client_email"));
            s.setPhone_number(rs.getString("client_phone_number"));
            s.setPassword(rs.getString("client_password"));
        }
        return sendersList;
    }

    private ObservableList<Shipments> getShipmentsList(ResultSet rs) throws SQLException{
        ObservableList<Shipments> shipmentsList = FXCollections.observableArrayList();

        while(rs.next()){
            Shipments p = new Shipments();
            p.setId(rs.getInt("shipment_id"));
            p.setSize(rs.getObject("shipment_package_size"));
            p.setPrice(rs.getDouble("shipment_price"));
            p.setSendPlace(rs.getString("shipment_sending_place"));
            p.setRecPlace(rs.getString("shipment_reception_place"));
            p.setStatus(rs.getObject("shipment_status"));
            p.setConsDate(rs.getString("shipment_consignment_date"));
            p.setShipDate(rs.getString("shipment_sending_date"));
            p.setDeliDate(rs.getString("shipment_delivery_date"));
            p.setRecDate(rs.getString("shipment_reception_date"));
            p.setRecId(rs.getInt("shipment_recipient_id"));
            p.setClientId(rs.getInt("client_id"));
            p.setAutoAddress(rs.getString("automat_address"));
        }
        return shipmentsList;
    }

    private ObservableList<ClientView> getClientsView(ResultSet rs) throws SQLException{
        ObservableList<ClientView> clientViews = FXCollections.observableArrayList();

        while(rs.next()){
            ClientView c = new ClientView();
            c.setId(rs.getInt("ID"));
            c.setName(rs.getString("recipient"));
            c.setStatus(rs.getObject("yourStatus"));
            c.setConDate(rs.getString("ConsignmentDate"));
            c.setRecDate(rs.getString("ReceptionDate"));
            c.setSize(rs.getObject("Size"));
            c.setAddress(rs.getString("s.automat_address"));
        }
        return clientViews;
    }

    public ObservableList<Automats> showAllAutomats() throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM automats;";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
            ObservableList<Automats> automatsList = getAutomatsList(resultSet);
            consoleTextArea.appendText(selectStmt);
            return automatsList;
        }catch (SQLException e){
            consoleTextArea.appendText("While searching, an error occurred. \n");
            throw e;
        }
    }

    public ObservableList<ClientView> clientView() throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM ClientView;";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
            ObservableList<ClientView> clientViews = getClientsView(resultSet);
            consoleTextArea.appendText(selectStmt);
            return clientViews;
        }catch (SQLException e){
            consoleTextArea.appendText("While searching, an error occurred. \n");
            throw e;
        }
    }
}
