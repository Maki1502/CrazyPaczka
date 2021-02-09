package edu.ib;

import com.github.vldrus.sql.rowset.CachedRowSetWrapper;
import javafx.scene.control.TextArea;
import java.sql.*;
import javax.sql.rowset.CachedRowSet;

public class DBUtil {

    private String userName;
    private String userPassword;
    private TextArea consoleTextArea;

    private Connection connection = null;

    public DBUtil(String userName, String userPassword, TextArea consoleTextArea) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.consoleTextArea = consoleTextArea;
    }

    public String getUserName(){
        return userName;
    }

    public void dbConnect() throws SQLException, ClassNotFoundException{ //ladowanie
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            consoleTextArea.appendText("No MySQL JDBC Driver found."+"\n");
            e.printStackTrace();
            throw e;
        }

        try{
            connection = DriverManager.getConnection(createURL());
        }catch (SQLException e){
            consoleTextArea.appendText("Connection Failed! Try again."+"\n");
            e.printStackTrace();
            throw e;
        }
    }

    public void dbDisconnect() throws SQLException{
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
                consoleTextArea.appendText("Succesfully disconected."+"\n");
            }
        }catch (Exception e){
            throw e;
        }
    }

    public String createURL(){
        StringBuilder sbURL = new StringBuilder("jdbc:mysql://");
        sbURL.append("localhost:3306/");
        sbURL.append("paczkomat?");
        sbURL.append("useUnicode=true&characterEncoding=utf-8");
        sbURL.append("&user=");
        sbURL.append(userName);
        sbURL.append("&password=");
        sbURL.append(userPassword);
        sbURL.append("&serverTimezone=CET");

        return sbURL.toString();
    }

    public ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException{
        PreparedStatement stms = null;
        ResultSet resultSet = null;
        CachedRowSet cachedRowSet;

        try{
            dbConnect();
            stms = connection.prepareStatement(queryStmt);
            resultSet = stms.executeQuery(queryStmt);
            cachedRowSet = new CachedRowSetWrapper();
            cachedRowSet.populate(resultSet);
        }catch (SQLException e){
            consoleTextArea.appendText("Problem occurred at executeQuery operation. \n");
            throw e;
        }finally {
            if(resultSet!= null) resultSet.close();
            if(stms != null) stms.close();
        }
        return cachedRowSet;
    }

    public void dbExecuteUpdate(String sqlStm) throws SQLException, ClassNotFoundException{
        Statement statement = null;
        try{
            dbConnect();
            statement = connection.createStatement();
            statement.executeUpdate(sqlStm);
        }catch (SQLException e){
            consoleTextArea.appendText("Problem occurred at executeUpdate operation,"+"\n");
            throw e;
        }finally {
            if (statement != null) statement.close();
        }
        dbDisconnect();
    }
}
