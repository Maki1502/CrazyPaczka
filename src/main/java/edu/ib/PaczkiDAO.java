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

    /*public ObservableList<Automats> showAllAutomats() throws SQLException, ClassNotFoundException{
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
    }*/

    private ObservableList<ObservableList> data;

    public ObservableList<ObservableList> clientView() throws SQLException, ClassNotFoundException{
        Connection conn = DriverManager.getConnection(dbUtil.createURL());
        PreparedStatement selectStmt = conn.prepareStatement("SELECT * FROM CustomerView;");
        try{
            ResultSet resultSet = selectStmt.executeQuery();
            printResultSet(resultSet);
            System.out.println("Wyniki");
            while(resultSet.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++){
                    row.add(resultSet.getString(i));
                }
                data.add(row);
            }
            return data;
        }catch (SQLException e){
                consoleTextArea.appendText("While searching, an error occurred. \n");
                throw e;
        }
    }

    public ObservableList<ObservableList> findDataClientView(String findData) throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM CustomerView WHERE ConsignmentDate like '%"+findData+"%' OR ReceptionDate like '%"+findData+"%';";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            while(resultSet.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++){
                    row.add(resultSet.getString(i));
                }
                data.add(row);
            }
            return data;
        }catch (SQLException e){
            consoleTextArea.appendText("While searching, an error occurred. \n");
            throw e;
        }
    }

    public ObservableList<ObservableList> findStatusClientView(String findStatus) throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM CustomerView WHERE yourStatus like "+findStatus+";";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            while(resultSet.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++){
                    row.add(resultSet.getString(i));
                }
                data.add(row);
            }
            return data;
        }catch (SQLException e){
            consoleTextArea.appendText("While searching, an error occurred. \n");
            throw e;
        }
    }

    public ObservableList<ObservableList> findPackage(String findPackage) throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM AdminViewPackage WHERE ID like "+findPackage+";";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            while(resultSet.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++){
                    row.add(resultSet.getString(i));
                }
                data.add(row);
            }
            return data;
        }catch (SQLException e){
            consoleTextArea.appendText("While searching, an error occurred. \n");
            throw e;
        }
    }

    public ObservableList<ObservableList> findUser(String findUser) throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM AdminViewUser WHERE ID like "+findUser+";";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            while(resultSet.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++){
                    row.add(resultSet.getString(i));
                }
                data.add(row);
            }
            return data;
        }catch (SQLException e){
            consoleTextArea.appendText("While searching, an error occurred. \n");
            throw e;
        }
    }
    private ObservableList<ObservableList> pack;

    public ObservableList<ObservableList> adminGetPackage() throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM AdminViewPackage;";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            while(resultSet.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++){
                    row.add(resultSet.getString(i));
                }
                pack.add(row);
            }
            return pack;
        }catch (SQLException e){
            consoleTextArea.appendText("While searching, an error occurred. \n");
            throw e;
        }
    }

    private ObservableList<ObservableList> user;

    public ObservableList<ObservableList> adminGetUser() throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM AdminViewUser;";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
            ObservableList<String> row = FXCollections.observableArrayList();
            while(resultSet.next()){
                for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++){
                    row.add(resultSet.getString(i));
                }
                user.add(row);
            }
            return user;
        }catch (SQLException e){
            consoleTextArea.appendText("While searching, an error occurred. \n");
            throw e;
        }
    }

    public ObservableList<Clients> showAdminClients() throws SQLException, ClassNotFoundException{
        String selectStmt = "SELECT * FROM AdminViewUser;";
        try{
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
            printResultSet(resultSet);
            ObservableList<Clients> clientsList = getSendersList(resultSet);
            consoleTextArea.appendText(selectStmt);

            return clientsList;
        }catch (SQLException e){
            consoleTextArea.appendText("Error1 \n");
            throw e;
        }
    }

    public static void printResultSet(ResultSet resultSet) throws SQLException {

        ResultSetMetaData rsmd = resultSet.getMetaData(); // metadane o zapytaniu
        int columnsNumber = rsmd.getColumnCount(); // liczba kolumn

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
