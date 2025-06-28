/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LAB F
 */
public class TanamanOutdoor {  
    

public class TanamanOutdoor extends Tanaman {

    // Constructor: otomatis set jenis ke "Outdoor"
    public TanamanOutdoor(int id, String nama, int umur, double harga, String lokasi) {
        super(id, nama, "Outdoor", umur, harga, lokasi);
    }

    // Override method getInfo dari class Tanaman
    @Override
    public String getInfo() {
        return "[Outdoor] " + super.getInfo();
    }
}

}