/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class connectDb {

    public static Connection connect() throws ClassNotFoundException, SQLException {
        String urlConnect = "jdbc:sqlserver://localhost:1433;databaseName=quan_ly_hoa_qua;user=sa;password=admin123";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(urlConnect);
        return conn;
    }
}
