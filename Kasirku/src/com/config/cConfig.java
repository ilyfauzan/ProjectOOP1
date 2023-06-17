package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class cConfig {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbmyshop";
    private static final String USER = "root";
    private static final String PASS = "";

    private static Connection connect;
    private static Statement statement;
    private static ResultSet resultSet;

    public cConfig() {
        connect = null;
        statement = null;
        resultSet = null;
    }

    public void connection() {
        try {
            connect = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Database Connected Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (connect != null)
                connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getDatabase() {
        connection();
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery(
                    "SELECT Nama, Harga, Stok FROM `tbl_myshop` ORDER BY ID DESC");

            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString("Nama") + ": Rp." +
                                resultSet.getDouble("Nama") + " (" +
                                resultSet.getInt("Stok") + ")");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void insertData(int ID, String Nama, Double Harga,int Stok) {
       
        connection();
        try {
            statement = connect.createStatement();
            statement.executeUpdate(
                    "INSERT INTO `tbl_myshop` (`ID`, `Nama`, `Harga`, `Stok`) VALUES ('"
                            + ID
                            + "', '" + Nama + "', '" + Harga + "', '" + Stok + "') ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void editData(int ID, String Nama, double Harga, int Stok) {
        connection();
        try {
            statement = connect.createStatement();
            String sql = "UPDATE `tbl_myshop` SET `Nama` = '" + Nama + "', `Harga` = " + Harga
                    + ", `Stok` = " + Stok
                    + " WHERE `tbl_myshop`.`ID` = " + ID;
            statement.executeUpdate(sql);
            System.out.println("Data successfully updated");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void deleteData() {
        int ID;
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan ID Barang yang ingin dihapus: ");
        ID = sc.nextInt();
        connection();
        try {
            statement = connect.createStatement();
            statement.executeUpdate("DELETE FROM `tbl_myshop` WHERE `ID` = " + ID);
            System.out.println("Data successfully deleted");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        sc.close();
    }
    
    }

