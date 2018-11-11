/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ConnectDB {

    Connection connect = null;
    ResultSet rs = null;
    String user = "root";
    String pass = "1234";

    public void hasDriver() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new Exception("Invalid Driver!!Please check this drver....");
        }
    }

    public Connection openConnect() throws Exception {
            hasDriver();
            String url = "jdbc:mysql://localhost:3306/usb?autoReconnect=true&useSSL=false";
            try {
                this.connect = DriverManager.getConnection(url, user, pass);
                System.out.println("Đã kết nối");
            } catch (SQLException e) {
                System.out.println("Lỗi kết nối : " + e.getMessage() );
            }
        return connect;
    }

    
    protected void closeConnect(){
        try {
             if (connect != null) connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public static void main(String[] args) {
        ConnectDB con = new ConnectDB();
        try {
            con.openConnect();
        } catch (Exception ex) {
            
        }
    }

}
