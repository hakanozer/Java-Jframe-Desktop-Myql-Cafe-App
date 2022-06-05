package bolum;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import yonetici.DB;
import yonetici.YoneticiEkrani;

public class bolumYonetimi extends javax.swing.JFrame {

    yonetici.DB db = new DB();
    String secimID = "";
    String secim = "";

    public bolumYonetimi() {
        initComponents();
    }

    public void bilgiGetir() {

        DefaultTableModel model = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };

        model.addColumn("ID");
        model.addColumn("Bölüm Adı");
        model.addColumn("Tarih");

        try {

            ResultSet rs = db.baglan().executeQuery("select * from bolum order by id asc");
            while (rs.next()) {
                model.addRow(new String[]{rs.getString("id"), rs.getString("bolum_adi"), rs.getString("tarih")});
            }

        } catch (Exception e) {
            System.err.println("Listeleme Hatası : " + e);
        }
        secimID = "";
        tblbolumler.setModel(model);
        tblbolumler.getColumnModel().getColumn(0).setMaxWidth(30);
        tblbolumler.getColumnModel().getColumn(2).setMaxWidth(120);
        tblbolumler.getColumnModel().getColumn(0).setMinWidth(30);
        tblbolumler.getColumnModel().getColumn(2).setMinWidth(120);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAnaEkran = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnEkle = new javax.swing.JButton();
        txtEkle = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbolumler = new javax.swing.JTable();
        txtDuzenle = new javax.swing.JTextField();
        btnSil = new javax.swing.JButton();
        btnDegistir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bölüm Yönetimi");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bölüm Yönetimi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setText("Bölüm Adı :");

        btnEkle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEkle.setText("Ekle");
        btnEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleActionPerformed(evt);
            }
        });

        txtEkle.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtEkle.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtEkle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEkleMouseClicked(evt);
            }
        });
        txtEkle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEkleKeyPressed(evt);
            }
        });

        tblbolumler.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tblbolumler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Bölüm Adı", "Tarih"
            }
        ));
        tblbolumler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbolumlerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblbolumler);

        txtDuzenle.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtDuzenle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDuzenleMouseClicked(evt);
            }
        });

        btnSil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSil.setText("Sil");
        btnSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilActionPerformed(evt);
            }
        });

        btnDegistir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnDegistir.setText("Değiştir");
        btnDegistir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDegistirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEkle)
                        .addGap(18, 18, 18)
                        .addComponent(btnEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDuzenle)
                        .addGap(18, 18, 18)
                        .addComponent(btnDegistir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDegistir, btnSil});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEkle)
                    .addComponent(txtEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSil)
                    .addComponent(btnDegistir))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAnaEkran, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed
        try {
            String bolumadi = txtEkle.getText();
            int durum = 0;
            if (!bolumadi.trim().isEmpty()) {
                durum = db.baglan().executeUpdate("insert into bolum values(null, '" + bolumadi.trim() + "', now())");
            }

        } catch (Exception e) {
            System.err.println("Yazma Hatası : " + e);
        }
        bilgiGetir();
        txtEkle.setText("");
        txtDuzenle.setText("");
    }//GEN-LAST:event_btnEkleActionPerformed

    private void tblbolumlerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbolumlerMouseClicked

        this.getRootPane().setDefaultButton(btnDegistir);
        txtDuzenle.requestFocus();
        secimID = "" + tblbolumler.getValueAt(tblbolumler.getSelectedRow(), 0);
        secim = "" + tblbolumler.getValueAt(tblbolumler.getSelectedRow(), 1);
        txtDuzenle.setText(secim);

    }//GEN-LAST:event_tblbolumlerMouseClicked

    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
        if (secimID.equals("")) {
            JOptionPane.showMessageDialog(this, "        LÜTFEN SEÇİM YAPINIZ!");
        } else {
            try {
                int tasdik = JOptionPane.showConfirmDialog(this, secim + " BÖLÜMÜNÜ SİLMEK İSTEDİĞİNİZDEN EMİN MİSİNİZ?");

                if (tasdik == 0) {

                    int silDurum = db.baglan().executeUpdate("delete from bolum where id = '" + secimID + "'");
                    txtDuzenle.setText("");
                    txtEkle.setText("");
                    bilgiGetir();

                    if (silDurum > 0) {
                        JOptionPane.showMessageDialog(this, secim + " BÖLÜMÜ BAŞARI İLE SİSTEMDEN SİLİNDİ.");
                    }
                }

            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnSilActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        bilgiGetir();
        this.getRootPane().setDefaultButton(btnEkle);

    }//GEN-LAST:event_formWindowOpened

    private void btnDegistirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDegistirActionPerformed
        String adi = txtDuzenle.getText().trim();

        if (secimID.equals("")) {
            JOptionPane.showMessageDialog(this, "        LÜTFEN SEÇİM YAPINIZ!");
        } else {
            if (adi.equals(secim) || adi.isEmpty()) {
                JOptionPane.showMessageDialog(this, "            DEĞİŞTİRMEDİNİZ!");
            } else {

                try {

                    int guncelDurum = db.baglan().executeUpdate("update bolum set bolum_adi = '" + adi + "',tarih=now() where id='" + secimID + "'");

                } catch (Exception e) {
                    System.err.println("Güncelleme Hatası : " + e);
                }
            }
        }
        bilgiGetir();
        txtDuzenle.setText("");
        txtEkle.setText("");

    }//GEN-LAST:event_btnDegistirActionPerformed

    private void txtEkleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEkleMouseClicked
        this.getRootPane().setDefaultButton(btnEkle);
        txtDuzenle.setText("");
    }//GEN-LAST:event_txtEkleMouseClicked

    private void txtDuzenleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDuzenleMouseClicked
        this.getRootPane().setDefaultButton(btnDegistir);
    }//GEN-LAST:event_txtDuzenleMouseClicked

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

    private void txtEkleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEkleKeyPressed
       if(evt.getKeyCode() == evt.VK_ESCAPE){
           
           yonetici.YoneticiEkrani anaEkran = new YoneticiEkrani();
        anaEkran.setVisible(true);
        this.dispose();
           
       }
        
    }//GEN-LAST:event_txtEkleKeyPressed

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
            java.util.logging.Logger.getLogger(bolumYonetimi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bolumYonetimi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bolumYonetimi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bolumYonetimi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bolumYonetimi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnaEkran;
    private javax.swing.JButton btnDegistir;
    private javax.swing.JButton btnEkle;
    private javax.swing.JButton btnSil;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblbolumler;
    private javax.swing.JTextField txtDuzenle;
    private javax.swing.JTextField txtEkle;
    // End of variables declaration//GEN-END:variables
}
