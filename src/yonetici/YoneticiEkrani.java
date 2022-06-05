package yonetici;

import asci.asciYonetimi;
import ayarlar.AyarEkrani;
import bolum.bolumYonetimi;
import garson.calisanGarsonlar;
import kategori.KategoriYonetimi;
import masa.masaSinif;
import rapor.RaporEkrani;
import urun.UrunEkrani;

public class YoneticiEkrani extends javax.swing.JFrame {

    public YoneticiEkrani() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnYonetim = new javax.swing.JButton();
        btnKategori = new javax.swing.JButton();
        btnUrun = new javax.swing.JButton();
        btnMasa = new javax.swing.JButton();
        btnAsci = new javax.swing.JButton();
        btnGarson = new javax.swing.JButton();
        btnRapor = new javax.swing.JButton();
        btnAyarlar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Yönetici Paneli");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnYonetim.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnYonetim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/bolum64.png"))); // NOI18N
        btnYonetim.setText("Bölüm Yönetimi");
        btnYonetim.setFocusable(false);
        btnYonetim.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnYonetim.setIconTextGap(30);
        btnYonetim.setMargin(new java.awt.Insets(2, 40, 2, 14));
        btnYonetim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYonetimActionPerformed(evt);
            }
        });

        btnKategori.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnKategori.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/kategori64.png"))); // NOI18N
        btnKategori.setText("Kategori Yönetimi");
        btnKategori.setFocusable(false);
        btnKategori.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnKategori.setIconTextGap(30);
        btnKategori.setMargin(new java.awt.Insets(2, 40, 2, 14));
        btnKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKategoriActionPerformed(evt);
            }
        });

        btnUrun.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnUrun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/urun64.png"))); // NOI18N
        btnUrun.setText("Ürün Yönetimi");
        btnUrun.setFocusable(false);
        btnUrun.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUrun.setIconTextGap(30);
        btnUrun.setMargin(new java.awt.Insets(2, 40, 2, 14));
        btnUrun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUrunActionPerformed(evt);
            }
        });

        btnMasa.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnMasa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/masa64.png"))); // NOI18N
        btnMasa.setText("Masa Yönetimi");
        btnMasa.setFocusable(false);
        btnMasa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMasa.setIconTextGap(30);
        btnMasa.setMargin(new java.awt.Insets(2, 40, 2, 14));
        btnMasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasaActionPerformed(evt);
            }
        });

        btnAsci.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnAsci.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/asci64.png"))); // NOI18N
        btnAsci.setText("Aşçı Yönetimi");
        btnAsci.setFocusable(false);
        btnAsci.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAsci.setIconTextGap(30);
        btnAsci.setMargin(new java.awt.Insets(2, 40, 2, 14));
        btnAsci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsciActionPerformed(evt);
            }
        });

        btnGarson.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnGarson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/garson64.png"))); // NOI18N
        btnGarson.setText("Garson Yönetimi");
        btnGarson.setFocusable(false);
        btnGarson.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGarson.setIconTextGap(30);
        btnGarson.setMargin(new java.awt.Insets(2, 40, 2, 14));
        btnGarson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGarsonActionPerformed(evt);
            }
        });

        btnRapor.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnRapor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/rapor64.png"))); // NOI18N
        btnRapor.setText("Rapor");
        btnRapor.setFocusable(false);
        btnRapor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRapor.setIconTextGap(30);
        btnRapor.setMargin(new java.awt.Insets(2, 40, 2, 14));
        btnRapor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRaporActionPerformed(evt);
            }
        });

        btnAyarlar.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnAyarlar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/ayarlar64.png"))); // NOI18N
        btnAyarlar.setText("Ayarlar");
        btnAyarlar.setFocusable(false);
        btnAyarlar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAyarlar.setIconTextGap(30);
        btnAyarlar.setMargin(new java.awt.Insets(2, 40, 2, 14));
        btnAyarlar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyarlarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUrun, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAsci, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRapor, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnYonetim, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMasa, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGarson, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAyarlar, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAsci, btnAyarlar, btnGarson, btnKategori, btnMasa, btnRapor, btnUrun, btnYonetim});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnYonetim, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUrun, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMasa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAsci, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGarson, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRapor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAyarlar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAsci, btnAyarlar, btnGarson, btnKategori, btnMasa, btnRapor, btnUrun, btnYonetim});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnYonetimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYonetimActionPerformed
        bolum.bolumYonetimi bolumEkrani = new bolumYonetimi();
        bolumEkrani.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnYonetimActionPerformed

    private void btnKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKategoriActionPerformed
        kategori.KategoriYonetimi kategoriEkrani = new KategoriYonetimi();
        kategoriEkrani.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKategoriActionPerformed

    private void btnUrunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrunActionPerformed
        urun.UrunEkrani urunEkrani = new UrunEkrani();
        urunEkrani.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnUrunActionPerformed

    private void btnMasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasaActionPerformed
        masa.masaSinif masaEkrani = new masaSinif();
        masaEkrani.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMasaActionPerformed

    private void btnAsciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsciActionPerformed
        asci.asciYonetimi asciEkrani = new asciYonetimi();
        asciEkrani.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAsciActionPerformed

    private void btnGarsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGarsonActionPerformed
        garson.calisanGarsonlar garsonEkrani = new calisanGarsonlar();
        garsonEkrani.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGarsonActionPerformed

    private void btnRaporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRaporActionPerformed
        rapor.RaporEkrani raporEkrani = new RaporEkrani();
        raporEkrani.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRaporActionPerformed

    private void btnAyarlarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyarlarActionPerformed
        ayarlar.AyarEkrani ayarEkrani = new AyarEkrani();
        ayarEkrani.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnAyarlarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        CafeProgramiStart anaGiris = new CafeProgramiStart();
        this.dispose();
        anaGiris.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(YoneticiEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YoneticiEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YoneticiEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YoneticiEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YoneticiEkrani().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsci;
    private javax.swing.JButton btnAyarlar;
    private javax.swing.JButton btnGarson;
    private javax.swing.JButton btnKategori;
    private javax.swing.JButton btnMasa;
    private javax.swing.JButton btnRapor;
    private javax.swing.JButton btnUrun;
    private javax.swing.JButton btnYonetim;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
