package masa;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import yonetici.DB;
import yonetici.YoneticiEkrani;

public class masaSinif extends javax.swing.JFrame {

    yonetici.DB db = new DB();
    String secilenMasa = "";

    public masaSinif() {
        initComponents();

        masaBilgiGetir();

    }

    public void masaEkle() {

        String masaAdi = txtMasaAdi.getText().trim();
        if (masaAdi.equals("")) {
            txtMasaAdi.setText("");
            JOptionPane.showMessageDialog(this, "Lütfen Masa ismi giriniz");
            txtMasaAdi.requestFocus();
            return;

        }

        try {
            int masaDurum = db.baglan().executeUpdate("insert into masalar values(null, '" + masaAdi + "', now())");
            if (masaDurum > 0) {
                masaBilgiGetir();
                JOptionPane.showMessageDialog(this, "Masa ekleme işlemi başarılı");
            }
        } catch (Exception e) {
            System.err.println("Masa ekleme işlemi başarısız : " + e);
        }

    }

    public void masaBilgiGetir() {
        DefaultTableModel model = new DefaultTableModel();
        // model.setRowCount(0);
        model.addColumn("ID");
        model.addColumn("Masa Adı");
        model.addColumn("Tarih");

        try {
            ResultSet rs = db.baglan().executeQuery("select *from masalar");

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("id"), rs.getString("masa_adi"), rs.getString("tarih")});

            }

        } catch (Exception e) {
            System.err.println("masaBilgiGetir Hatası : " + e);
        }
        tblMasalar.setModel(model);
        tblMasalar.getColumnModel().getColumn(0).setMaxWidth(30);
        tblMasalar.getColumnModel().getColumn(2).setMaxWidth(120);
        tblMasalar.getColumnModel().getColumn(0).setMinWidth(30);
        tblMasalar.getColumnModel().getColumn(2).setMinWidth(120);
    }

    public void masaSil() {

        if (txtMasaAdi.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Lütfen Masa Seçiniz!");

        } else {
            String secilenMasa = "" + tblMasalar.getValueAt(tblMasalar.getSelectedRow(), 0);
            try {

                int silDurum = db.baglan().executeUpdate("delete from masalar where id='" + secilenMasa + "'");
                if (silDurum > 0) {

                    masaBilgiGetir();
                    JOptionPane.showMessageDialog(this, "Silme işlemi başarılı");
                }
            } catch (Exception e) {
                System.err.println("Masa silme işlemi başarısız : " + e);
            }

        }
        secilenMasa = "";
    }

    public void MasaGuncelle() {
        if (txtMasaAdi.getText().trim().equals("") && secilenMasa.equals("")) {
            JOptionPane.showMessageDialog(this, "Geçersiz Masa Seçimi, Lütfen Masa Seçiniz!");

        } else {
            String secilenMasa = "" + tblMasalar.getValueAt(tblMasalar.getSelectedRow(), 0);
            String masaAdi = txtMasaAdi.getText().trim();

            try {

                int guncelleDurum = db.baglan().executeUpdate("update masalar set masa_adi ='" + masaAdi + "' where  id='" + secilenMasa + "' limit 1");
                if (guncelleDurum > 0) {

                    masaBilgiGetir();
                    JOptionPane.showMessageDialog(this, "Güncelleme işlemi başarılı");
                }
            } catch (Exception e) {
                System.err.println("Masa guncelleme işlemi başarısız : " + e);
            }

        }

    }

    public void masaAra() {
        DefaultTableModel model = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };

        //model.setRowCount(0);
        model.addColumn("ID");
        model.addColumn("Masa Adı");
        model.addColumn("Tarih");

        try {

            String gel = txtAra.getText();

            ResultSet rs = db.baglan().executeQuery("call cumleAramaFnc('%" + gel + "%')");

            while (rs.next()) {
                model.addRow(new String[]{rs.getString("id"), rs.getString("masa_adi"), rs.getString("tarih")});

            }

        } catch (Exception e) {
            System.out.println("Arama hatası : " + e);
        }
        tblMasalar.setModel(model);
        tblMasalar.getColumnModel().getColumn(0).setMaxWidth(30);
        tblMasalar.getColumnModel().getColumn(2).setMaxWidth(120);
        tblMasalar.getColumnModel().getColumn(0).setMinWidth(30);
        tblMasalar.getColumnModel().getColumn(2).setMinWidth(120);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btnEkle = new javax.swing.JButton();
        btnSil = new javax.swing.JButton();
        btnGuncelle = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMasalar = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtMasaAdi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAra = new javax.swing.JTextField();
        btnAnaEkran = new javax.swing.JButton();
        btnDurum = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Masa Yönetimi");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Masa Yönetimi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11))); // NOI18N

        btnEkle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEkle.setText("Ekle");
        btnEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleActionPerformed(evt);
            }
        });

        btnSil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSil.setText("Sil");
        btnSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilActionPerformed(evt);
            }
        });

        btnGuncelle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnGuncelle.setText("Güncelle");
        btnGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuncelleActionPerformed(evt);
            }
        });

        tblMasalar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tblMasalar.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMasalar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMasalarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMasalar);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setText("Masa Adı :");

        txtMasaAdi.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setText("Masa Ara :");

        txtAra.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtAra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAraKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSil))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtMasaAdi)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuncelle)
                                .addGap(18, 18, 18)
                                .addComponent(btnEkle))
                            .addComponent(txtAra))))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEkle, btnGuncelle, btnSil});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMasaAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEkle)
                    .addComponent(btnGuncelle))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSil)
                .addContainerGap())
        );

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

        btnDurum.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDurum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/ileri26.png"))); // NOI18N
        btnDurum.setText("Masa Durum");
        btnDurum.setIconTextGap(8);
        btnDurum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDurumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnaEkran, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDurum)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnaEkran, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDurum))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAnaEkran, btnDurum});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed
        masaEkle();
        masaBilgiGetir();
    }//GEN-LAST:event_btnEkleActionPerformed

    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
        masaSil();
    }//GEN-LAST:event_btnSilActionPerformed

    private void btnGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuncelleActionPerformed
        MasaGuncelle();
    }//GEN-LAST:event_btnGuncelleActionPerformed

    private void tblMasalarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMasalarMouseClicked
        String secilenMasaİsmi = "" + tblMasalar.getValueAt(tblMasalar.getSelectedRow(), 1);
        String secilenMasa = "" + tblMasalar.getValueAt(tblMasalar.getSelectedRow(), 0);

        txtMasaAdi.setText(secilenMasaİsmi);

        System.err.println(secilenMasa);

    }//GEN-LAST:event_tblMasalarMouseClicked

    private void txtAraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAraKeyReleased
        if (txtAra.getText().equals("")) {
            masaBilgiGetir();
        } else {

            masaAra();
        }
    }//GEN-LAST:event_txtAraKeyReleased

    private void btnDurumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDurumActionPerformed
        masaDurum md = new masaDurum();
        md.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnDurumActionPerformed

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

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(masaSinif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(masaSinif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(masaSinif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(masaSinif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new masaSinif().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnaEkran;
    private javax.swing.JButton btnDurum;
    private javax.swing.JButton btnEkle;
    private javax.swing.JButton btnGuncelle;
    private javax.swing.JButton btnSil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMasalar;
    private javax.swing.JTextField txtAra;
    private javax.swing.JTextField txtMasaAdi;
    // End of variables declaration//GEN-END:variables
}
