package com.Layouts;

import java.sql.SQLException;
import java.util.Scanner;

import com.DataAccesor.DataAccessor;

public class ProductDeleter {
    private DataAccessor dataAccessor;

    public ProductDeleter(DataAccessor dataAccessor) {
        this.dataAccessor = dataAccessor;
    }

    public void deleteData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ID yang ingin dihapus: ");
        int ID = scanner.nextInt();

        try {
            String query = "DELETE FROM `tbl_myshop` WHERE `ID` = " + ID;
            dataAccessor.executeUpdate(query);
            System.out.println("Data berhasil dihapus");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dataAccessor.closeConnection();
            scanner.close();
        }
    }
}
