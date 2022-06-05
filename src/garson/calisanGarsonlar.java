package garson;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import yonetici.DB;
import yonetici.YoneticiEkrani;

public class calisanGarsonlar extends javax.swing.JFrame {

    yonetici.DB db = new DB();

    int secilen, sayac = 0;

    DefaultTableModel model = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int i, int i1) {
            return false;
        }
    };

    public calisanGarsonlar() {
        initComponents();
        tabloModelleme();
        bilgileriGetir();

    }

    public void tabloModelleme() {

        model.setRowCount(0);
        model.setColumnCount(0);

        model.addColumn("Sıra");
        model.addColumn("Adı");
        model.addColumn("Soyadı");
        model.addColumn("Telefon");
        model.addColumn("Adres");
        model.addColumn("Kullanıcı Adı");
        model.addColumn("Şifre");
        model.addColumn("Başlama Tarihi");

        tblBilgiler.setModel(model);
        tblBilgiler.getColumnModel().getColumn(0).setMaxWidth(40);
        tblBilgiler.getColumnModel().getColumn(0).setMinWidth(40);
    }

    public void bilgileriGetir() {
        model.setRowCount(0);

        ResultSet rs = null;
        sayac = 1;

        try {
            rs = db.baglan().executeQuery("select * from garson order by adi asc");

            while (rs.next()) {
                String trh = new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("tarih"));
                model.addRow(new String[]{String.valueOf(sayac),
                    rs.getString("adi"),
                    rs.getString("soyadi"),
                    rs.getString("telefon"),
                    rs.getString("adres"),
                    rs.getString("kul_adi"),
                    rs.getString("sifre"),
                    trh});
                sayac++;
            }
        } catch (Exception e) {
            System.err.println("Listeleme Hatası : " + e);
        }
    }

    public void garsonArama() {

        model.setRowCount(0);

        String aranacak = txtArama.getText().replace(" ", "*");
        sayac = 1;

        ResultSet rs = null;
        String sorgu = "call garsonAra('*" + aranacak + "*')";

        try {

            rs = db.baglan().executeQuery(sorgu);

            while (rs.next()) {

                String trh = new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("tarih"));

                model.addRow(new String[]{String.valueOf(sayac),
                    rs.getString("adi"),
                    rs.getString("soyadi"),
                    rs.getString("telefon"),
                    rs.getString("adres"),
                    rs.getString("kul_adi"),
                    rs.getString("sifre"),
                    trh});
                sayac++;

            }

        } catch (Exception e) {
            System.err.println("Garson Bulma Hatası");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSil = new javax.swing.JButton();
        btnDuzenle = new javax.swing.JButton();
        btnEkle = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtArama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBilgiler = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Garson Yönetimi");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnSil.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/ileri26.png"))); // NOI18N
        btnSil.setText("Garson Sil");
        btnSil.setIconTextGap(8);
        btnSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilActionPerformed(evt);
            }
        });

        btnDuzenle.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDuzenle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/ileri26.png"))); // NOI18N
        btnDuzenle.setText("Garson Güncelle");
        btnDuzenle.setIconTextGap(8);
        btnDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDuzenleActionPerformed(evt);
            }
        });

        btnEkle.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEkle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/ileri26.png"))); // NOI18N
        btnEkle.setText("Garson Ekle");
        btnEkle.setIconTextGap(8);
        btnEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Garson Bilgileri", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setText("Personel Ara :");

        txtArama.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtArama.setToolTipText("ARAMAK İSTEDİĞİNİZ PERSONELİN ADINI YAZINIZ");
        txtArama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAramaKeyReleased(evt);
            }
        });

        tblBilgiler.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tblBilgiler.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBilgiler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBilgilerMouseClicked(evt);
            }
        });
        tblBilgiler.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblBilgilerKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblBilgiler);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtArama)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtArama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/anaEkran26.png"))); // NOI18N
        jButton1.setText("Ana Ekran");
        jButton1.setIconTextGap(8);
        jButton1.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                        .addComponent(btnEkle)
                        .addGap(18, 18, 18)
                        .addComponent(btnSil)
                        .addGap(18, 18, 18)
                        .addComponent(btnDuzenle)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDuzenle, btnEkle, btnSil});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDuzenle)
                    .addComponent(btnSil)
                    .addComponent(btnEkle))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDuzenle, btnEkle, btnSil, jButton1});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed
        garsonEkle add = new garsonEkle();
        this.show(false);
        add.setVisible(true);


    }//GEN-LAST:event_btnEkleActionPerformed

    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
        garsonSil del = new garsonSil();
        del.setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnSilActionPerformed

    private void btnDuzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDuzenleActionPerformed
        garsonGuncelle update = new garsonGuncelle();
        update.setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnDuzenleActionPerformed

    private void tblBilgilerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBilgilerMouseClicked

        secilen = tblBilgiler.getSelectedRow();


    }//GEN-LAST:event_tblBilgilerMouseClicked

    private void txtAramaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAramaKeyReleased

        if (txtArama.getText().equals("")) {
            bilgileriGetir();
        } else {
            garsonArama();
        }

    }//GEN-LAST:event_txtAramaKeyReleased

    private void tblBilgilerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblBilgilerKeyReleased

        secilen = tblBilgiler.getSelectedRow();

    }//GEN-LAST:event_tblBilgilerKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        yonetici.YoneticiEkrani anaEkran = new YoneticiEkrani();
        anaEkran.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        yonetici.YoneticiEkrani anaEkran = new YoneticiEkrani();
        anaEkran.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(calisanGarsonlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(calisanGarsonlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(calisanGarsonlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(calisanGarsonlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new calisanGarsonlar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDuzenle;
    private javax.swing.JButton btnEkle;
    private javax.swing.JButton btnSil;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBilgiler;
    private javax.swing.JTextField txtArama;
    // End of variables declaration//GEN-END:variables
}
