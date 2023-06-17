package com.Layouts;

import java.sql.SQLException;
import java.util.Scanner;

import com.DataAccesor.DataAccessor;

public class ProductWriter {
    private DataAccessor dataAccessor;

    public ProductWriter(DataAccessor dataAccessor) {
        this.dataAccessor = dataAccessor;
    }

    public void insertData() {
        Scanner input = new Scanner(System.in);

        System.out.print("ID : ");
        int ID = input.nextInt();
        input.nextLine();

        System.out.print("NAMA : ");
        String Nama = input.nextLine();

        System.out.print("STOK : ");
        double Stok = input.nextDouble();

        System.out.print("HARGA: ");
        int Harga = input.nextInt();

        try {
            String query = "INSERT INTO `tbl_myshop` (`ID`, `Nama`, `Stok`, `Harga`) VALUES ('" + ID + "', '" + Nama
                    + "', '" + Stok + "', '" + Harga + "') ";
            dataAccessor.executeUpdate(query);
            System.out.println("Data successfully inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            input.close();
        }
    }
}
