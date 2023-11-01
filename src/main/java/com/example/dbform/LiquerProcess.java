package com.example.dbform;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.*;
import java.util.ArrayList;

public class LiquerProcess {
    static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://10.10.104.136:5432/alko_anya?user=postgres&password=123";
        Connection conn = DriverManager.getConnection(url);
        return conn;
    }
        static void saveLiq(Liquer otr) throws SQLException {
            Connection conn = getConnection();
        /*    String a = otr.getLabel();
            float b = otr.getVolume();
            String c = String.valueOf(otr.getCategory());
            String d = otr.getSubcategory();
            String e = otr.getCountry();
            float f = otr.getStrength();
            float g = otr.getSugar();
            int h = otr.getYear();
            int j = otr.getAge();*/

            String query = "insert into \"liquer\" (label, volume, category, subcategory, country, strength, sugar, year, age) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, otr.getLabel());
            pst.setFloat(2, otr.getVolume());
            pst.setString(3, otr.getCategory().name());
            pst.setString(4, otr.getSubcategory());
            pst.setString(5, otr.getCountry());
            pst.setFloat(6, otr.getStrength());
            pst.setFloat(7, otr.getSugar());
            pst.setInt(8, otr.getYear());
            pst.setInt(9, otr.getAge());
            pst.executeUpdate();
        }

        static ArrayList<Liquer> readLiq() throws SQLException {
            ArrayList<Liquer> trrrr=new ArrayList<>();
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            String query ="select * from \"liquer\" l ;";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                String a = rs.getString("label");
                float b = rs.getFloat("volume");
                String c = rs.getString("category");
                AlcoCategory ac = AlcoCategory.valueOf(c);
                String d = rs.getString("subcategory");
                String e = rs.getString("country");
                float f = rs.getFloat("strength");
                float g = rs.getFloat("sugar");
                int h = rs.getInt("year");
                int j = rs.getInt("age");
                int id = rs.getInt("id");
                Liquer l = new Liquer(id,a, b, ac, d, e, f, g, h, j);
                trrrr.add(l);
            }
            return trrrr;
        }
    static void delLiq(int id) throws SQLException {
        Connection conn = getConnection();
        String query = "DELETE FROM liquer WHERE id=?;";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, id);
        System.out.println(id);
        System.out.println(pst.executeUpdate());

    }
    }


