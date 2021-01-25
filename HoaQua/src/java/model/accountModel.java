/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class accountModel {

    public static boolean login(accountDTO account) {
        boolean check = false;
        Connection conn;
        try {
            conn = connectDb.connect();
            //thao tac lay du lieu
            String query = "select * from tblAccount where username='" + account.getUsername() + "' and pass='" + account.getPass() + "'";
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(query);
            while (result.next()) {
                check = true;
            }
            //dong ket noi
            conn.close();
        } catch (ClassNotFoundException ex) {
            return false;
        } catch (SQLException ex) {
            return false;
        }
        return check;
    }
}
