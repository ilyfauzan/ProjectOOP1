package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBConnector {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbmyshop";
    private static final String USER = "root";
    private static final String PASS = "";

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public Connection getConnection() {
        return connection;

    }

    public DBConnector() {
        connection = null;
        statement = null;
        resultSet = null;
    }

    public void Connect() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
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
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getDatabase() {
        Connect();
        try {
            statement = connection.createStatement();
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
}
