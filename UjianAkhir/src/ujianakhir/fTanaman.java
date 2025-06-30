/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ujianakhir;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static ujianakhir.dbkoneksi.koneksi;


/**
 *
 * @author Imelda Jaleha Meo
 * 30/06/2025
 */

public class fTanaman extends javax.swing.JFrame {
    DefaultTableModel DTM = new DefaultTableModel();

  

    /**
     * Creates new form fTanaman
     * @throws java.sql.SQLException
     */
    
     public fTanaman() throws SQLException {
        initComponents();

        tbltmn.setModel(DTM);
        DTM.addColumn("id");
        DTM.addColumn("nama");
        DTM.addColumn("jenis");
        DTM.addColumn("umur");
        DTM.addColumn("harga");
        DTM.addColumn("lokasi");
        
     cbjenis.removeAllItems();
        String[] opsiJNS = {"Pilih jenis", "Indoor", "Outdoor"};
        for (String opsi : opsiJNS) {
            cbjenis.addItem(opsi);
        }

        lsdttmn();
        clearform();
        tombol(false);
        cBaru.setEnabled(true);
        cTutup.setEnabled(true);
        fieldAktif(false);
        cbjenis.setVisible(true);

        aksiTombol();
    }

// Tambahkan fungsi ini

    private void aksiTombol() {
        cBaru.addActionListener(evt -> {
            if (cBaru.getText().equals("Baru")) {
                clearform();
                fieldAktif(true);
                cbjenis.setVisible(true);
                cBaru.setText("Simpan");
                cTutup.setText("Batal");
                cUbah.setEnabled(false);
                cHapus.setEnabled(false);
            } else {
                try {
                    storeData();
                    lsdttmn();
                } catch (SQLException ex) {
                    Logger.getLogger(fTanaman.class.getName()).log(Level.SEVERE, null, ex);
                }
                cBaru.setText("Baru");
                cTutup.setText("Tutup");
                clearform();
                fieldAktif(false);
                cbjenis.setVisible(false);
            }
        });

    cUbah.addActionListener(evt -> {
            if (cUbah.getText().equals("Ubah")) {
                cUbah.setText("Simpan");
                cTutup.setText("Batal");
                cBaru.setEnabled(false);
                cHapus.setEnabled(false);
                fieldAktif(true);
                txid.setEditable(false);
                cbjenis.setVisible(true);
                cbjenis.setSelectedItem(tbltmn.getValueAt(tbltmn.getSelectedRow(), 2).toString());
            } else {
                try {
                    updateData();
                    lsdttmn();
                } catch (SQLException ex) {
                    Logger.getLogger(fTanaman.class.getName()).log(Level.SEVERE, null, ex);
                }
                cUbah.setText("Ubah");
                cTutup.setText("Tutup");
                cBaru.setEnabled(true);
                cUbah.setEnabled(false);
                cbjenis.setVisible(false);
                fieldAktif(false);
                clearform();
            }
        });
       cHapus.addActionListener(evt -> {
            int opsi = JOptionPane.showConfirmDialog(this, "Yakin akan menghapus Data " + txid.getText() + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (opsi == JOptionPane.YES_OPTION) {
                try {
                    destroyData();
                    lsdttmn();
                    clearform();
                    cHapus.setEnabled(false);
                    cUbah.setEnabled(false);
                } catch (SQLException ex) {
                    Logger.getLogger(fTanaman.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
cTutup.addActionListener(evt -> {
            if (cTutup.getText().equals("Tutup")) {
                int opsi = JOptionPane.showConfirmDialog(this, "Yakin akan menutup Aplikasi?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (opsi == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            } else {
                cTutup.setText("Tutup");
                cBaru.setText("Baru");
                cUbah.setText("Ubah");
                cBaru.setEnabled(true);
                cUbah.setEnabled(false);
                cbjenis.setVisible(false);
                fieldAktif(false);
                clearform();
            }
        });

        tbltmn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int baris = tbltmn.getSelectedRow();
                if (baris >= 0) {
                    txid.setText(DTM.getValueAt(baris, 0).toString());
                    txnama.setText(DTM.getValueAt(baris, 1).toString());
                    cbjenis.setSelectedItem(DTM.getValueAt(baris, 2).toString());
                    txumur.setText(DTM.getValueAt(baris, 3).toString());
                    txharga.setText(DTM.getValueAt(baris, 4).toString());
                    txlokasi.setText(DTM.getValueAt(baris, 5).toString());
                    tombol(true);
                    fieldAktif(true);
                }
            }
        });
    }



    private void tombol(boolean opsi) {
        cBaru.setEnabled(opsi);
        cUbah.setEnabled(opsi);
        cHapus.setEnabled(opsi);
        cTutup.setEnabled(true);
    }

    private void fieldAktif(boolean opsi) {
        txid.setEditable(opsi);
        txnama.setEditable(opsi);
        cbjenis.setEnabled(opsi);
        txumur.setEditable(opsi);
        txharga.setEditable(opsi);
        txlokasi.setEditable(opsi);
    }

private void clearform() {
        txid.setText("");
        txnama.setText("");
        cbjenis.setSelectedIndex(0);
        txumur.setText("");
        txharga.setText("");
        txlokasi.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltmn = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txnama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txumur = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txharga = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txlokasi = new javax.swing.JTextPane();
        cBaru = new javax.swing.JButton();
        cUbah = new javax.swing.JButton();
        cHapus = new javax.swing.JButton();
        cTutup = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbjenis = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jTextField1.setText("Data Tanaman");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        tbltmn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(tbltmn);

        jLabel1.setText("id");

        txid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txidActionPerformed(evt);
            }
        });
        txid.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txidPropertyChange(evt);
            }
        });

        jLabel2.setText("nama");

        jLabel4.setText("umur");

        jLabel5.setText("harga");

        jLabel6.setText("lokasi");

        jScrollPane2.setViewportView(txlokasi);

        cBaru.setText("Baru");

        cUbah.setText("Ubah");

        cHapus.setText("Hapus");

        cTutup.setText("Tutup");

        jLabel7.setText("jenis");

        cbjenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel6)
                                                .addComponent(txid)
                                                .addComponent(txnama)
                                                .addComponent(txumur, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
                                            .addComponent(txharga, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(cbjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(cBaru)
                        .addGap(34, 34, 34)
                        .addComponent(cUbah)
                        .addGap(18, 18, 18)
                        .addComponent(cHapus)
                        .addGap(18, 18, 18)
                        .addComponent(cTutup)))
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(cbjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txumur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBaru)
                    .addComponent(cUbah)
                    .addComponent(cHapus)
                    .addComponent(cTutup))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
   // TODO add your handling code here:
    } 
    private void txnamaActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        


    private void txumurActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     
    private void txhargaActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:  
    } 
    private void txlokasiActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void txidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txidActionPerformed

    private void txidPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txidPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txidPropertyChange
    private void cHapusActionPerformed(java.awt.event.ActionEvent evt) {                                       
      int opsi = JOptionPane.showOptionDialog(this, "Yakin akan menghapus Data "+txid.getText() +" ?", "Konfirmasi Hapus Data", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(opsi==JOptionPane.YES_NO_OPTION){
          try {
              destroyData();
              lsdttmn();
              clearform();
              cHapus.setEnabled(false);
              cUbah.setEnabled(false);
              
            } catch (SQLException ex) {
              Logger.getLogger(fTanaman.class.getName()).log(Level.SEVERE, null, ex);
              
          }
            }
    } 
    private void cUbahActionPerformed(java.awt.event.ActionEvent evt) {                                      
    if (cUbah.getText().equals("Ubah")) {
        cUbah.setText("Simpan");
        cTutup.setText("Batal");
        cBaru.setEnabled(false);
        cHapus.setEnabled(false);
        fieldAktif(true);
        txid.setEditable(false);
cbjenis.setVisible(true);
cbjenis.setSelectedItem(tbltmn.getValueAt(tbltmn.getSelectedRow(), 2).toString()); // Ambil data jenis dari tabel

       
    } else {
        try {
            updateData();
            lsdttmn();
        } catch (SQLException ex) {
            Logger.getLogger(fTanaman.class.getName()).log(Level.SEVERE, null, ex);
        }

        cUbah.setText("Ubah");
        cTutup.setText("Tutup");
        cBaru.setEnabled(true);
        cUbah.setEnabled(false);
        cbjenis.setVisible(false);
        fieldAktif(false);
        clearform();
    }
}

  private void cBaruActionPerformed(java.awt.event.ActionEvent evt) {                                      

    if(cBaru.getText().equals("Baru")){
        clearform();
        fieldAktif(true);    
        cbjenis.setVisible(true); // Tampilkan combo box
        cBaru.setText("Simpan");
        cTutup.setText("Batal"); // <- ini sebelumnya salah: cTutupsetText()
        cUbah.setEnabled(false);
        cHapus.setEnabled(false);
    } else {
        try {
            storeData();
            lsdttmn(); // <- ini juga sebelumnya salah tulis
        } catch (SQLException ex) {
            Logger.getLogger(fTanaman.class.getName()).log(Level.SEVERE, null, ex);
        }
        cBaru.setText("Baru");
        cTutup.setText("Tutup");
        clearform();
        fieldAktif(false);
        cbjenis.setVisible(false); // Sembunyikan combo box setelah simpan
    }
}

     
   private void cTutupActionPerformed(java.awt.event.ActionEvent evt) {                                       
    if (cTutup.getText().equals("Tutup")) {
        int opsi = JOptionPane.showOptionDialog(this, "Yakin akan menutup Aplikasi?", "Konfirmasi Tutup Aplikasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (opsi == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    } else {
        cTutup.setText("Tutup");
        cBaru.setText("Baru");
        cUbah.setText("Ubah");
        cBaru.setEnabled(true);
        cUbah.setEnabled(false);
        cbjenis.setVisible(false); // Biarkan combo box disembunyikan
        fieldAktif(false);
        clearform();
    }
}

 private void tblmhsMouseClicked(java.awt.event.MouseEvent evt) {                                    
    txid.setText(tbltmn.getValueAt(tbltmn.getSelectedRow(), 0).toString());
    txnama.setText(tbltmn.getValueAt(tbltmn.getSelectedRow(), 1).toString());
    cbjenis.setSelectedItem(tbltmn.getValueAt(tbltmn.getSelectedRow(), 2).toString()); // Ganti txjenis
    txumur.setText(tbltmn.getValueAt(tbltmn.getSelectedRow(), 3).toString());
    txharga.setText(tbltmn.getValueAt(tbltmn.getSelectedRow(), 4).toString());
    txlokasi.setText(tbltmn.getValueAt(tbltmn.getSelectedRow(), 5).toString());

    cUbah.setEnabled(true);
    cHapus.setEnabled(true);
}

    private void cBaruMouseClicked(java.awt.event.MouseEvent evt) {                                   
        // TODO add your handling code here:
        
    } 

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fTanaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fTanaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fTanaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fTanaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new fTanaman().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(fTanaman.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cBaru;
    private javax.swing.JButton cHapus;
    private javax.swing.JButton cTutup;
    private javax.swing.JButton cUbah;
    private javax.swing.JComboBox<String> cbjenis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbltmn;
    private javax.swing.JTextField txharga;
    private javax.swing.JTextField txid;
    private javax.swing.JTextPane txlokasi;
    private javax.swing.JTextField txnama;
    private javax.swing.JTextField txumur;
    // End of variables declaration//GEN-END:variables

    private void lsdttmn() throws SQLException {
        Connection cnn = koneksi();
        DTM.getDataVector().removeAllElements();
        DTM.fireTableDataChanged();
        if (!cnn.isClosed()) {
            PreparedStatement PS = cnn.prepareStatement("SELECT * FROM tanaman;");
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                Object[] dttmn = new Object[6];
                dttmn[0] = RS.getString("id");
                dttmn[1] = RS.getString("nama");
                dttmn[2] = RS.getString("jenis");
                dttmn[3] = RS.getString("umur");
                dttmn[4] = RS.getString("harga");
                dttmn[5] = RS.getString("lokasi");
                DTM.addRow(dttmn);
            }
            cnn.close();
        }
    }

    


    private void storeData() throws SQLException {
        Connection cnn = koneksi();
      if (!cnn.isClosed()) {
            PreparedStatement PS = cnn.prepareStatement("INSERT INTO tanaman(id,nama,jenis,umur,harga,lokasi) VALUES(?,?,?,?,?,?);");
            PS.setString(1, txid.getText());
            PS.setString(2, txnama.getText());
            PS.setString(3, cbjenis.getSelectedItem().toString());
            PS.setString(4, txumur.getText());
            PS.setString(5, txharga.getText());
            PS.setString(6, txlokasi.getText());
            PS.executeUpdate();
            cnn.close();
        }
    }

     
    private void updateData() throws SQLException {
        Connection cnn = koneksi();
        if (!cnn.isClosed()) {
            PreparedStatement PS = cnn.prepareStatement("UPDATE tanaman SET nama=?, jenis=?, umur=?, harga=?, lokasi=? WHERE id=?;");
            PS.setString(1, txnama.getText());
            PS.setString(2, cbjenis.getSelectedItem().toString());
            PS.setString(3, txumur.getText());
            PS.setString(4, txharga.getText());
            PS.setString(5, txlokasi.getText());
            PS.setString(6, txid.getText());
            PS.executeUpdate();
            cnn.close();
        }
    }

    private void destroyData() throws SQLException {
        Connection cnn = koneksi();
        if (!cnn.isClosed()) {
            PreparedStatement PS = cnn.prepareStatement("DELETE FROM tanaman WHERE id=?;");
            PS.setString(1, txid.getText());
            PS.executeUpdate();
            cnn.close();
        }
    }
}

   



