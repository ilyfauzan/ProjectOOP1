package com.Layouts;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.DataAccesor.DataAccessor;
import com.Models.Product;

public class ProductReader {
    private DataAccessor dataAccessor;

    public ProductReader(DataAccessor dataAccessor) {
        this.dataAccessor = dataAccessor;
    }

    public void readData() {
        try {
            ResultSet resultSet = dataAccessor
                    .executeQuery("SELECT Nama, Stok, Harga FROM `tbl_myshop` ORDER BY ID DESC");

            while (resultSet.next()) {
                String Nama = resultSet.getString("Nama");
                double Stok = resultSet.getDouble("Stok");
                int Harga = resultSet.getInt("Harga");

                Product product = new Product(0, Nama, Stok, Harga);

                System.out.println(product.getNama() + product.getStok() + " (" + product.getHarga() + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dataAccessor.closeConnection();
        }
    }
}
