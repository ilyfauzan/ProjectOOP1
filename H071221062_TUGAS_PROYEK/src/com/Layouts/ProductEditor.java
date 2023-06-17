package com.Layouts;

import java.sql.SQLException;
import java.util.Scanner;

import com.DataAccesor.DataAccessor;

public class ProductEditor {
    private DataAccessor dataAccessor;

    public ProductEditor(DataAccessor dataAccessor) {
        this.dataAccessor = dataAccessor;
    }

    public void editData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan ID data yang akan diubah: ");
        int ID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Masukkan nilai baru untuk NAMA: ");
        String Nama = scanner.nextLine();

        System.out.print("Masukkan nilai baru untuk STOK: ");
        double Stok = scanner.nextDouble();

        System.out.print("Masukkan nilai baru untuk HARGA: ");
        int Harga = scanner.nextInt();

        try {
            String query = "UPDATE `tbl_myshop` SET `NAMA` = '" + Nama + "', `STOK` = " + Stok + ", `HARGA` = " + Harga
                    + " WHERE `tbl_myshop`.`ID` = " + ID;
            dataAccessor.executeUpdate(query);
            System.out.println("Data berhasil diperbarui");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dataAccessor.closeConnection();
            scanner.close();
        }
    }
}
