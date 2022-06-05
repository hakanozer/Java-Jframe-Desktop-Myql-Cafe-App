package garsonPanel;

import asciPanel.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class masaSiparis extends javax.swing.JFrame {

    DB db = new DB();

    public static String garsonnn = "";
    public static String odemeTipi = "";
    static String reff2 = "";
    static String odemeT = "";
    float toplam = 0f;
    String sid2 = "";

    public masaSiparis() {
        initComponents();
        // bu pencere açılır açılmaz
        // listeye focuslanıyor
        listSiparis.requestFocus();
        jLabel4.setText(String.valueOf(toplam));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnMasaKapa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSiparis = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("jLabel1");

        btnMasaKapa.setText("Masayı Kapat");
        btnMasaKapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasaKapaActionPerformed(evt);
            }
        });

        jLabel2.setText("Ödeme Tipi : ");

        listSiparis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        listSiparis.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                listSiparisFocusGained(evt);
            }
        });
        listSiparis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listSiparisMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(listSiparis);

        jLabel4.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel5.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jLabel5.setText("Toplam :");

        jButton1.setText("Ödendi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnMasaKapa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMasaKapa)
                        .addComponent(jLabel2))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public String odemeTipi(String ref) {
        btnMasaKapa.setEnabled(false);
        jButton1.setEnabled(false);
        try {
            odemeT = "";
            if (!db.baglan().isClosed()) {
                ResultSet rs = db.baglan().executeQuery("SELECT odeme_tipi FROM satis WHERE ref_kodu = '" + ref + "' AND durum = 1");
                while (rs.next()) {
                    odemeTipi = (rs.getString("odeme_tipi"));
                    switch (odemeTipi) {
                        case "0":
                            odemeT += " Nakit ";
                            break;
                        case "1":
                            odemeT += " Kredi Kartı ";
                            break;
                        case "2":
                            odemeT += " Diğer ";
                            break;
                    }

                    btnMasaKapa.setEnabled(true);
                    jButton1.setEnabled(true);
                }
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(masaSiparis.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                db.con.close();
                db.st.close();
            } catch (SQLException ex) {
                System.err.println("Bağlantı Kapatma Hatası! " + ex);
            }
        }
        return odemeT;
    }

    public void siparisGetir() {
        toplam = 0;
        // metod siparişleri getiriyor
        // listeye focuslanma sağlandığında çalışıyor
        try {
            if (!db.baglan().isClosed()) {
                DefaultTableModel lis = new DefaultTableModel();

                lis.addColumn("Sipariş ID");
                lis.addColumn("Ürün");
                lis.addColumn("Fiyat");

                for (int i = 0; i < lis.getRowCount(); i++) {
                    toplam += Float.valueOf("" + listSiparis.getValueAt(i, 1));
                }
                ResultSet rs1 = db.baglan().executeQuery("SELECT S.id AS sipID\n"
                        + "FROM sepet S\n"
                        + "LEFT JOIN satis Sa ON S.ref_kodu = Sa.ref_kodu\n"
                        + "WHERE S.masa_id= '" + masalar.masaID + "' AND (S.durum = 0 OR S.durum =2)");
                ResultSet rs = db.baglan().executeQuery(""
                        + "SELECT U.urun_adi AS urunnn, U.fiyat AS fiyat \n"
                        + "FROM urunler U\n"
                        + "LEFT JOIN sepet S ON S.urun_id = U.id\n"
                        + "WHERE S.masa_id= '" + masalar.masaID + "' AND (S.durum = 0 OR S.durum =2)");
                // tıklanan masaya ait ÖDENMEMİŞ siparişleri getir
                while (rs.next() && rs1.next()) {
                    lis.addRow(new String[]{rs1.getString("sipID"), rs.getString("urunnn"), rs.getString("fiyat")});
                    toplam += Float.valueOf(rs.getString("fiyat"));
                }
                rs1.close();
                rs.close();
                lis.fireTableDataChanged();
                listSiparis.setModel(lis);

            }
        } catch (SQLException ex) {
            Logger.getLogger(masaSiparis.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                db.con.close();
                db.st.close();
            } catch (SQLException ex) {
                System.err.println("Bağlantı Kapatma Hatası! " + ex);
            }
        }
        // ödeme tipini labela yaz
        jLabel3.setText(odemeTipi(masalar.reff));
        jLabel4.setText(toplam + " TL");

    }


    private void btnMasaKapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasaKapaActionPerformed
        try {
            if (!db.baglan().isClosed()) {
                ResultSet rs = db.baglan().executeQuery("SELECT ref_kodu FROM sepet WHERE masa_id='" + masalar.masaID + "' AND (durum = 0 OR durum=2)");
                // tıklanan masanın O ANKİ ref_kodunu getir
                if (rs.next()) {
                    reff2 = rs.getString("ref_kodu");
                }
                rs.close();
                // ilk aşamada sepetteki durumu ÖDENDİ yap
                int durum1 = db.baglan().executeUpdate("UPDATE sepet SET durum = 1 WHERE masa_id ='" + masalar.masaID + "' ");
                // sonra satis taki durumu ÖDENDİ yap
                db.con.close();
                db.st.close();
                int durum2 = db.baglan().executeUpdate("UPDATE satis SET durum = 0 WHERE ref_kodu = '" + reff2 + "'");
                // paranın hangi garsonda olduğunu yaz
                db.con.close();
                db.st.close();
                int durum3 = db.baglan().executeUpdate("UPDATE satis SET garson_id = '" + Integer.valueOf(garsonnn) + "' WHERE ref_kodu = '" + masalar.reff + "'");
                db.con.close();
                db.st.close();
                this.dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(masaSiparis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMasaKapaActionPerformed

    private void listSiparisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listSiparisFocusGained
        siparisGetir();
        garsonnn = Garson.garsonumuz;

    }//GEN-LAST:event_listSiparisFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (sid2.equals("")) {
            JOptionPane.showMessageDialog(this, "Sipariş Seçin!..");
        } else {
            try {
                if (!db.baglan().isClosed()) {
                    ResultSet rs = db.baglan().executeQuery("SELECT ref_kodu FROM sepet WHERE masa_id='" + masalar.masaID + "' AND (durum = 0 OR durum=2)");
                    // tıklanan masanın O ANKİ ref_kodunu getir
                    if (rs.next()) {
                        reff2 = rs.getString("ref_kodu");
                    }
                    // ilk aşamada sepetteki durumu ÖDENDİ yap
                    int durum1 = db.baglan().executeUpdate("UPDATE sepet SET durum = 1 WHERE id ='" + sid2 + "' ");
                    // sonra satis taki durumu ÖDENDİ yap
                    db.con.close();
                    db.st.close();
                    int durum2 = db.baglan().executeUpdate("UPDATE satis SET durum = 0 WHERE ref_kodu = '" + reff2 + "'");
                    // paranın hangi garsonda olduğunu yaz
                    db.con.close();
                    db.st.close();
                   

                }
            } catch (SQLException ex) {
                Logger.getLogger(masaSiparis.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        listSiparis.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void listSiparisMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listSiparisMousePressed
        sid2 = "" + listSiparis.getValueAt(listSiparis.getSelectedRow(), 0);
    }//GEN-LAST:event_listSiparisMousePressed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(masaSiparis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(masaSiparis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(masaSiparis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(masaSiparis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new masaSiparis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMasaKapa;
    private javax.swing.JButton jButton1;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listSiparis;
    // End of variables declaration//GEN-END:variables
}
