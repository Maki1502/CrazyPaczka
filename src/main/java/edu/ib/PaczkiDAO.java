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
            sendersList.add(s);
        }
        return sendersList;
    }

    private ObservableList<CustomerView> getCustomerView(ResultSet rs) throws SQLException{

        ObservableList<CustomerView> customerViews = FXCollections.observableArrayList();

        while (rs.next()){

            CustomerView cv = new CustomerView();
            cv.setId(rs.getInt("ID"));
            cv.setName(rs.getString("recipient"));
            cv.setStatus(rs.getObject("ShipmentStatus"));
            cv.setConsDate(rs.getString("ConsignmentDate"));
            cv.setRecDate(rs.getString("ReceptionDate"));
            cv.setSize(rs.getObject("Size"));
            cv.setAddress(rs.getString("s.automat_address"));
            customerViews.add(cv);
        }
        return customerViews;
    }

    private ObservableList<PackageView> getPackages(ResultSet rs) throws SQLException{

        ObservableList<PackageView> packageViews = FXCollections.observableArrayList();
        while (rs.next()){
            PackageView p = new PackageView();
            p.setId(rs.getInt("ID"));
            p.setConsDate(rs.getString("ConsDate"));
            p.setRecDate(rs.getString("RecDate"));
            p.setClId(rs.getInt("SenderId"));
            p.setRecId(rs.getString("ReceiverId"));
            p.setPrice(rs.getDouble("Price"));
            p.setStatus(rs.getObject("packStatus"));
            packageViews.add(p);
        }
        return packageViews;
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

    public ObservableList<CustomerView> showClientData() throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM CustomerView;";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<CustomerView> customerViews = getCustomerView(resultSet);
            consoleTextArea.appendText(selectStmt+"\n");

            printResultSet(resultSet);

            return customerViews;
        }catch (SQLException e){
            consoleTextArea.appendText("Error \n");
            throw e;
        }
    }

    public ObservableList<CustomerView> findClientByData(String findData) throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM CustomerView WHERE ConsignmentDate like %'"+findData+"%' OR ReceptionDate like %'"+findData+"%';";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<CustomerView> customerViews = getCustomerView(resultSet);
            consoleTextArea.appendText(selectStmt+"\n");

            printResultSet(resultSet);

            return customerViews;
        }catch (SQLException e){
            consoleTextArea.appendText("Error \n");
            throw e;
        }
    }

    public ObservableList<CustomerView> findClientByStatus(String findStatus) throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM CustomerView WHERE ShipmentStatus like %'"+findStatus+"%';";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<CustomerView> customerViews = getCustomerView(resultSet);
            consoleTextArea.appendText(selectStmt+"\n");

            printResultSet(resultSet);

            return customerViews;
        }catch (SQLException e){
            consoleTextArea.appendText("Error \n");
            throw e;
        }
    }

    public ObservableList<Clients> showAdminClients() throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * from clients;";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<Clients> clientsList = getSendersList(resultSet);
            consoleTextArea.appendText(selectStmt+"\n");

            printResultSet(resultSet);

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
            printResultSet(resultSet);

            return clientsList;
        }catch (SQLException e){
            consoleTextArea.appendText("Error1.2 \n");
            throw e;
        }
    }

    public ObservableList<Shipments> showAdminPackage() throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM Shipments;";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
            ObservableList<Shipments> packageViews = getShipmentsList(resultSet);
            consoleTextArea.appendText(selectStmt+"\n");

            return packageViews;
        }catch (SQLException e){
            consoleTextArea.appendText("Error2 \n");
            throw e;
        }
    }

    public ObservableList<Shipments> findAdminPackage(String findPackage) throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM Shipments WHERE shipment_id like '%"+findPackage+"%';";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
            ObservableList<Shipments> packageViews = getShipmentsList(resultSet);
            consoleTextArea.appendText(selectStmt+"\n");

            return packageViews;
        }catch (SQLException e){
            consoleTextArea.appendText("Error2.2 \n");
            throw e;
        }
    }





    public static void printResultSet(ResultSet resultSet) throws SQLException {

        ResultSetMetaData rsmd = resultSet.getMetaData(); // metadane o zapytaniu
        int columnsNumber = rsmd.getColumnCount(); // liczba kolumn
        resultSet.beforeFirst();
        while (resultSet.next()) {  // wyswietlenie nazw kolumn i wartosci w rzedach

            for (int i = 1; i <= columnsNumber; i++) {

                if (i > 1)
                    System.out.print(",  ");

                String columnValue = resultSet.getString(i);
                System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
            }

            System.out.println("");
        }

        System.out.println("");

    }
}
