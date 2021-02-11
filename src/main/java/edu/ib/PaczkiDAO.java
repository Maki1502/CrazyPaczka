package edu.ib;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;

import java.sql.*;

public class PaczkiDAO {

    private DBUtil dbUtil;
    private TextArea consoleTextArea;

    public PaczkiDAO(DBUtil dbUtil, TextArea consoleTextArea) {
        this.dbUtil = dbUtil;
        this.consoleTextArea = consoleTextArea;
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
            sendersList.add(s);
        }
        return sendersList;
    }

    private ObservableList<CustomerView> getCustomerView(ResultSet rs) throws SQLException{

        ObservableList<CustomerView> customerViews = FXCollections.observableArrayList();

        while (rs.next()){

            CustomerView cv = new CustomerView();
            cv.setId(rs.getInt("ID"));
            cv.setName(rs.getString("mail"));
            cv.setStatus(rs.getString("ShipmentStatus"));
            cv.setConsDate(rs.getString("ConsignmentDate"));
            cv.setRecDate(rs.getString("ReceptionDate"));
            cv.setSize(rs.getString("Size"));
            cv.setAddress(rs.getString("Address"));
            customerViews.add(cv);
        }
        return customerViews;
    }

    private ObservableList<Shipments> getShipmentsList(ResultSet rs) throws SQLException{
        ObservableList<Shipments> shipmentsList = FXCollections.observableArrayList();

        while(rs.next()){
            Shipments p = new Shipments();
            p.setId(rs.getInt("shipment_id"));
            p.setSize(rs.getObject("shipment_package_size"));
            p.setPrice(rs.getDouble("shipment_price"));
            p.setSendPlace(rs.getString("shipment_consignment_place"));
            p.setRecPlace(rs.getString("shipment_reception_place"));
            p.setStatus(rs.getObject("shipment_status"));
            p.setConsDate(rs.getString("shipment_consignment_date"));
            p.setShipDate(rs.getString("shipment_sending_date"));
            p.setDeliDate(rs.getString("shipment_delivery_date"));
            p.setRecDate(rs.getString("shipment_reception_date"));
            p.setRecId(rs.getInt("shipment_recipient_id"));
            p.setClientId(rs.getInt("client_id"));
            p.setAutoAddress(rs.getString("automat_address"));
            shipmentsList.add(p);
        }
        return shipmentsList;
    }

    private ObservableList<AdminViewPackage> getShipAdmin(ResultSet rs) throws SQLException{
        ObservableList<AdminViewPackage> shipmentsView = FXCollections.observableArrayList();

        while(rs.next()){
            AdminViewPackage adm = new AdminViewPackage();
            adm.setId(rs.getInt("ID"));
            adm.setPrice(rs.getDouble("Price"));
            adm.setSendPlace(rs.getString("fromPlace"));
            adm.setRecPlace(rs.getString("toPlace"));
            adm.setStatus(rs.getString("packStatus"));
            adm.setConsDate(rs.getString("ConsDate"));
            adm.setRecDate(rs.getString("RecDate"));
            adm.setRecId(rs.getString("ReceiverId"));
            adm.setClientId(rs.getInt("SenderId"));
            shipmentsView.add(adm);
        }
        return shipmentsView;
    }

    public ObservableList<CustomerView> showClientData(String name) throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM CustomerView WHERE mail like '"+name+"';";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<CustomerView> customerViews = getCustomerView(resultSet);
            consoleTextArea.appendText(selectStmt+"\n");

            return customerViews;
        }catch (SQLException e){
            consoleTextArea.appendText("Error \n");
            throw e;
        }
    }

    public ObservableList<CustomerView> findClientByData(String findData, String name) throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM CustomerView WHERE mail like '"+name+"' AND ConsignmentDate like '%"+findData+"%' OR ReceptionDate like '%"+findData+"%';";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<CustomerView> customerViews = getCustomerView(resultSet);
            consoleTextArea.appendText(selectStmt+"\n");

            return customerViews;
        }catch (SQLException e){
            consoleTextArea.appendText("Error \n");
            throw e;
        }
    }

    public ObservableList<CustomerView> findClientByStatus(String findStatus, String name) throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM CustomerView WHERE ShipmentStatus like '%"+findStatus+"%' AND mail like '"+name+"';";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<CustomerView> customerViews = getCustomerView(resultSet);
            consoleTextArea.appendText(selectStmt+"\n");

            return customerViews;
        }catch (SQLException e){
            consoleTextArea.appendText("Error \n");
            throw e;
        }
    }

    public ObservableList<Clients> showAdminClients() throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * from Clients;";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<Clients> clientsList = getSendersList(resultSet);
            consoleTextArea.appendText(selectStmt+"\n");

            return clientsList;
        }catch (SQLException e){
            consoleTextArea.appendText("Error1 \n");
            throw e;
        }
    }

   public ObservableList<Clients> findAdminClients(String findUser) throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM Clients WHERE client_id like "+findUser+";";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
            ObservableList<Clients> clientsList = getSendersList(resultSet);
            consoleTextArea.appendText(selectStmt+"\n");

            return clientsList;
        }catch (SQLException e){
            consoleTextArea.appendText("Error1.2 \n");
            throw e;
        }
    }

    public ObservableList<AdminViewPackage> showAdminPackage() throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM AdminViewPackage;";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
            ObservableList<AdminViewPackage> packageViews = getShipAdmin(resultSet);
            consoleTextArea.appendText(selectStmt+"\n");

            return packageViews;
        }catch (SQLException e){
            consoleTextArea.appendText("Error2 \n");
            throw e;
        }
    }

    public ObservableList<AdminViewPackage> findAdminPackage(String findPackage) throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM AdminViewPackage WHERE ID like "+findPackage+";";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
            ObservableList<AdminViewPackage> packageViews = getShipAdmin(resultSet);
            consoleTextArea.appendText(selectStmt+"\n");

            return packageViews;
        }catch (SQLException e){
            consoleTextArea.appendText("Error2.2 \n");
            throw e;
        }
    }
}
