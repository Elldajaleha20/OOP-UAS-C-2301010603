/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LAB F
 */
public class DatabaseHelper {
    
    
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/koleksi_tanaman_db";
    private static final String USER = "root"; // ganti kalau beda
    private static final String PASS = "";     // ganti sesuai password MySQL

    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("Koneksi Gagal: " + e.getMessage());
            return null;
        }
    }
}
}
