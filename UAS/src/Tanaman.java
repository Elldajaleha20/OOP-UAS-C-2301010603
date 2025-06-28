/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LAB F
 */

public class Tanaman {
    private int id;
    private String nama;
    private String jenis;
    private int umur;
    private double harga;
    private String lokasi;

    public Tanaman() {}

    public Tanaman(int id, String nama, String jenis, int umur, double harga, String lokasi) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.umur = umur;
        this.harga = harga;
        this.lokasi = lokasi;
    }

    // Getter dan Setter...

    public String getInfo() {
        return nama + " - " + jenis + " - " + umur + " bulan - Rp" + harga + " - " + lokasi;
    }
}

