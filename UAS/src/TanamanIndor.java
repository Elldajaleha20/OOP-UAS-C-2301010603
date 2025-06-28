/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LAB F
 */
public class TanamanIndor {

public class TanamanIndoor extends Tanaman {
    public TanamanIndoor(int id, String nama, int umur, double harga, String lokasi) {
        super(id, nama, "Indoor", umur, harga, lokasi);
    }

    public String getInfo() {
        return "[Indoor] " + super.getInfo();
    }
}
    
}
