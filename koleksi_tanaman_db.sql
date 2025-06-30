
-- Membuat database
CREATE DATABASE IF NOT EXISTS koleksi_tanaman_db;
USE koleksi_tanaman_db;

-- Membuat tabel tanaman
CREATE TABLE IF NOT EXISTS tanaman (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nama VARCHAR(50) NOT NULL,
    jenis ENUM('Indoor', 'Outdoor') NOT NULL,
    umur INT NOT NULL,
    harga DECIMAL(10,2) NOT NULL,
    lokasi VARCHAR(50) NOT NULL
);

-- Contoh data awal
INSERT INTO tanaman (nama, jenis, umur, harga, lokasi) VALUES
('Monstera Deliciosa', 'Indoor', 12, 150000.00, 'Ruang Tamu'),
('Kaktus Mini', 'Outdoor', 6, 50000.00, 'Teras'),
('Lidah Mertua', 'Indoor', 8, 80000.00, 'Kamar Tidur');
