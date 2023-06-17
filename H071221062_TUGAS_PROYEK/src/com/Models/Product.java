package com.Models;

public class Product {
    private int ID;
    private String Nama;
    private double Stok;
    private int Harga;

    public Product(int ID, String Nama, double Stok, int Harga) {
        this.ID = ID;
        this.Nama = Nama;
        this.Stok = Stok;
        this.Harga = Harga;
    }

    public int getID() {
        return ID;
    }

    public void setId(int ID) {
        this.ID = ID;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public double getStok() {
        return Stok;
    }

    public void setStok(double Stok) {
        this.Stok = Stok;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int Harga) {
        this.Harga = Harga;
    }
}
