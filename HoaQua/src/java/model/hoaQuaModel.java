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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class hoaQuaModel {

    public static List<hoaQuaDTO> getAll() {
        List<hoaQuaDTO> arr = new ArrayList<>();
        //mo ket noi
        Connection conn;
        try {
            conn = connectDb.connect();
            //thao tac lay du lieu
            String query = "select maSv,tenSv,tuoi,tenLop from tblSinhVien inner join tblLop on tblSinhVien.maLop=tblLop.maLop";
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(query);
            while (result.next()) {
                int ma = Integer.valueOf(result.getString("maSv"));
                String ten = result.getString("tenSv");
                int tuoi = Integer.valueOf(result.getString("tuoi"));
                String tenLop = result.getString("tenLop");
                hoaQuaDTO sp = new hoaQuaDTO();
                arr.add(sp);
            }
            //dong ket noi
            conn.close();
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        return arr;

    }

    public static void insert(sinhVienDTO sv) {
        Connection conn;
        try {
            conn = connectDb.connect();
            //thao tac lay du lieu
            String query = "insert into tblSinhVien(tenSv,tuoi,maLop) values('" + sv.getTenSv() + "'," + sv.getTuoi() + ", " + sv.getMaLop() + ")";
            Statement stm = conn.createStatement();
            stm.execute(query);
            //dong ket noi
            conn.close();
        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {
        }
    }

    public static void main(String[] args) {
        getById(2);
    }

    public static sinhVienDTO getById(int id) {
        Connection conn;
        try {
            conn = connectDb.connect();
            //thao tac lay du lieu
            String query = "select * from tblSinhVien where maSv=" + id;
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(query);
            while (result.next()) {
                int ma = Integer.valueOf(result.getString("maSv"));
                String ten = result.getString("tenSv");
                int tuoi = Integer.valueOf(result.getString("tuoi"));
                int maLop = Integer.valueOf(result.getString("maLop"));
                sinhVienDTO sv = new sinhVienDTO(ma, ten, tuoi, maLop);
                return sv;
            }
            //dong ket noi
            conn.close();
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }
    public static void updateSv(sinhVienDTO obj){
        Connection conn;
        try {
            conn = connectDb.connect();
            //thao tac lay du lieu
            String query = "update tblSinhVien set tenSv='"+obj.getTenSv()+"', tuoi="+obj.getTuoi()+", maLop="+obj.getMaLop()+" where maSv="+obj.getMaSv()+"";
            Statement stm = conn.createStatement();
            stm.execute(query);
            //dong ket noi
            conn.close();
        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {
        }
    }
}
