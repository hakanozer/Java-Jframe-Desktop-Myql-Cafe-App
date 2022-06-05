package kategori;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import yonetici.DB;
import yonetici.YoneticiEkrani;

public class KategoriYonetimi extends javax.swing.JFrame {

    yonetici.DB db = new DB();
    String secimBolumID = "";
    String secimKategoriID = "";
    DefaultTableModel model = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int i, int i1) {
            return false;
        }

    };
    DefaultComboBoxModel comboModel = new DefaultComboBoxModel();

    ArrayList bolum_id = new ArrayList();

    public KategoriYonetimi() {
        initComponents();

        model.addColumn("ID");
        model.addColumn("Bölüm ID");
        model.addColumn("Kategori Adı");
        model.addColumn("Tarih");

        comboModel.setSelectedItem("Seçiniz");

        kategoriGetir();
        bolumGetir();

        kat_liste.setModel(model);
        kat_liste.getColumnModel().getColumn(0).setMaxWidth(30);
        kat_liste.getColumnModel().getColumn(1).setMaxWidth(60);
        kat_liste.getColumnModel().getColumn(3).setMaxWidth(120);
        kat_liste.getColumnModel().getColumn(0).setMinWidth(30);
        kat_liste.getColumnModel().getColumn(1).setMinWidth(60);
        kat_liste.getColumnModel().getColumn(3).setMinWidth(120);
        comboBolumID.setModel(comboModel);

    }

    public void kategoriGetir() {
        model.setRowCount(0);
        try {
            ResultSet rs = db.baglan().executeQuery("SELECT * FROM kategoriler");
            while (rs.next()) {
                model.addRow(new String[]{rs.getString("id"), rs.getString("bolum_id"), rs.getString("kategori_adi"), rs.getString("tarih")});
            }
        } catch (SQLException ex) {
            System.err.println("Hata : " + ex);
        }
    }

    public void bolumGetir() {
        try {
            ResultSet rs = db.baglan().executeQuery("SELECT * FROM bolum");
            while (rs.next()) {
                bolum_id.add(Integer.valueOf(rs.getString("id")));
                comboModel.addElement(rs.getString("bolum_adi"));
            }
        } catch (SQLException ex) {
            System.err.println("Hata : " + ex);
        }
    }

    public void kategoriEkle(int bol_id, String kat_adi) {
        try {
            int durum = db.baglan().executeUpdate("INSERT INTO kategoriler VALUES(null,'" + bol_id + "','" + kat_adi + "',NOW())");
            if (durum > 0) {
                kategoriGetir();
                JOptionPane.showMessageDialog(this, "Kayıt Başarıyla Eklendi!");
            }
        } catch (SQLException ex) {
            System.err.println("Hata : " + ex);
        }
    }

    public void alanlariDoldur(String bolum_id, String kat_id) {

        try {
            ResultSet rs1 = db.baglan().executeQuery("SELECT * FROM bolum WHERE id = '" + bolum_id + "'");
            ResultSet rs2 = db.baglan().executeQuery("SELECT * FROM kategoriler WHERE id = '" + kat_id + "'");
            rs1.next();
            rs2.next();
            comboBolumID.setSelectedItem(rs1.getString("bolum_adi"));
            txtKatAdi.setText(rs2.getString("kategori_adi"));

        } catch (Exception e) {
            System.err.println("Hata : " + e);
        }

    }

    public void kategoriDuzenle(String a) {
        int bol_id = comboBolumID.getSelectedIndex();
        String kat_adi = txtKatAdi.getText();

        if (secimKategoriID.equals("")) {
            JOptionPane.showMessageDialog(this, "Lütfen Tablodan Bir Kayıt Seçin!");
        } else {

            try {

                int guncelDurum = db.baglan().executeUpdate("UPDATE kategoriler SET bolum_id = '" + bolum_id.get(bol_id) + "', kategori_adi = '" + kat_adi + "' WHERE id = '" + secimKategoriID + "' LIMIT 1");
                if (guncelDurum > 0) {
                    kategoriGetir();
                    comboModel.setSelectedItem("Seçiniz");
                    txtKatAdi.setText("");
                    JOptionPane.showMessageDialog(this, "Güncelleme Başarılı!");
                    btnEkle.setEnabled(true);
                }

            } catch (Exception e) {
                System.err.println("Hata : " + e);
            }
        }
        secimKategoriID = "";
    }

    public void kategoriSil(String a) {
        if (!secimKategoriID.equals("")) {

            try {

                int silDurum = db.baglan().executeUpdate("DELETE FROM kategoriler WHERE id = '" + secimKategoriID + "'");
                if (silDurum > 0) {
                    kategoriGetir();
                    comboModel.setSelectedItem("Seçiniz");
                    txtKatAdi.setText("");
                    JOptionPane.showMessageDialog(this, "Silme İşlemi Başarılı!");
                    btnEkle.setEnabled(true);
                }

            } catch (Exception e) {
                System.err.println("Hata : " + e);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Lütfen Tablodan Bir Kayıt Seçin!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAnaEkran = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboBolumID = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        kat_liste = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtKatAdi = new javax.swing.JTextField();
        btnEkle = new javax.swing.JButton();
        btnDuzenle = new javax.swing.JButton();
        btnSil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kategori Yönetimi");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        btnAnaEkran.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAnaEkran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/anaEkran26.png"))); // NOI18N
        btnAnaEkran.setText("Ana Ekran");
        btnAnaEkran.setIconTextGap(8);
        btnAnaEkran.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnAnaEkran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnaEkranActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kategori Yönetimi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setText("Bölüm Adı :");

        comboBolumID.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        comboBolumID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboBolumIDKeyPressed(evt);
            }
        });

        kat_liste.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        kat_liste.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Bölüm ID", "Kategori Adı", "Tarih"
            }
        ));
        kat_liste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kat_listeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(kat_liste);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel3.setText("Kategori Adı :");

        txtKatAdi.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        btnEkle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEkle.setText("Ekle");
        btnEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleActionPerformed(evt);
            }
        });

        btnDuzenle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnDuzenle.setText("Düzenle");
        btnDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDuzenleActionPerformed(evt);
            }
        });

        btnSil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSil.setText("Sil");
        btnSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboBolumID, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtKatAdi, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEkle)
                        .addGap(18, 18, 18)
                        .addComponent(btnDuzenle))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSil)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDuzenle, btnEkle, btnSil});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboBolumID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtKatAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEkle)
                    .addComponent(btnDuzenle))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSil)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnaEkran, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnAnaEkran, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed

        int bol_id = comboBolumID.getSelectedIndex();
        String kat_adi = txtKatAdi.getText();

        if (comboBolumID.getSelectedItem().equals("Seçiniz")) {
            JOptionPane.showMessageDialog(this, "Lütfen Bölüm Seçiniz!");
        } else if (kat_adi.equals("")) {
            JOptionPane.showMessageDialog(this, "Lütfen Kategori Adı Girin!");
        } else {
            kategoriEkle((int) bolum_id.get(bol_id), kat_adi);
        }

    }//GEN-LAST:event_btnEkleActionPerformed

    private void kat_listeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kat_listeMouseClicked

        secimKategoriID = "" + kat_liste.getValueAt(kat_liste.getSelectedRow(), 0);
        secimBolumID = "" + kat_liste.getValueAt(kat_liste.getSelectedRow(), 1);
        alanlariDoldur(secimBolumID, secimKategoriID);
        btnEkle.setEnabled(false);

    }//GEN-LAST:event_kat_listeMouseClicked

    private void btnDuzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDuzenleActionPerformed

        kategoriDuzenle(secimKategoriID);

    }//GEN-LAST:event_btnDuzenleActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

        secimKategoriID = "";
        kat_liste.setSelectionMode(0);
        comboModel.setSelectedItem("Seçiniz");
        txtKatAdi.setText("");
        btnEkle.setEnabled(true);

    }//GEN-LAST:event_formMouseClicked

    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed

        kategoriSil(secimKategoriID);

    }//GEN-LAST:event_btnSilActionPerformed

    private void btnAnaEkranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnaEkranActionPerformed
        yonetici.YoneticiEkrani anaEkran = new YoneticiEkrani();
        anaEkran.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAnaEkranActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        yonetici.YoneticiEkrani anaEkran = new YoneticiEkrani();
        anaEkran.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        if (evt.getKeyCode() == evt.VK_ESCAPE) {
            yonetici.YoneticiEkrani anaEkran = new YoneticiEkrani();
            anaEkran.setVisible(true);
            this.dispose();
        }


    }//GEN-LAST:event_formKeyPressed

    private void comboBolumIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboBolumIDKeyPressed
        if (evt.getKeyCode() == evt.VK_ESCAPE) {
            yonetici.YoneticiEkrani anaEkran = new YoneticiEkrani();
            anaEkran.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_comboBolumIDKeyPressed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KategoriYonetimi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KategoriYonetimi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KategoriYonetimi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KategoriYonetimi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KategoriYonetimi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnaEkran;
    private javax.swing.JButton btnDuzenle;
    private javax.swing.JButton btnEkle;
    private javax.swing.JButton btnSil;
    private javax.swing.JComboBox comboBolumID;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable kat_liste;
    private javax.swing.JTextField txtKatAdi;
    // End of variables declaration//GEN-END:variables
}
