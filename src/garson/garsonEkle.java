package garson;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import yonetici.DB;
import yonetici.YoneticiEkrani;

public class garsonEkle extends javax.swing.JFrame {

    yonetici.DB db = new DB();
    calisanGarsonlar calisanlar = new calisanGarsonlar();

    ArrayList<String> kullaniciAdlari = new ArrayList<>();

    DefaultTableModel model = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int i, int i1) {
            return false;
        }

    };

    public boolean boslukVarmi(String bak) {

        boolean boslukDurum = true;

        if (bak.equals("")) {
            boslukDurum = true;
        } else {
            boslukDurum = false;
        }

        return boslukDurum;
    }

    public boolean harfVarmi(String bakalim) {

        boolean harfDurum = true;

        for (int i = 0; i < bakalim.length(); i++) {
            if (Character.isLetter(bakalim.charAt(i))) {
                harfDurum = true;
                break;
            } else {
                harfDurum = false;
            }
        }
        return harfDurum;
    }

    public void alanTemizle() {

        txtAdi.setText("");
        txtSoyadi.setText("");
        txtTelefon.setText("");
        txtaAdres.setText("");
        txtKullaniciAdi.setText("");
        txtSifre.setText("");
        txtAdi.requestFocus();
    }

    public boolean kulAdiKontrol() {

        boolean durumm = false;

        try {
            ResultSet rs = db.baglan().executeQuery("select * from garson");

            while (rs.next()) {
                kullaniciAdlari.add(rs.getString("kul_adi"));
            }
            for (int i = 0; i < kullaniciAdlari.size(); i++) {
                if (kullaniciAdlari.get(i).equals(txtKullaniciAdi.getText())) {
                    System.out.println(kullaniciAdlari.get(i));
                    JOptionPane.showMessageDialog(this, "KULLANICI ADI"
                            + " DİĞER KULLANICI İSİMLERİNDEN FARKLI OLMALI. LÜTFEN KULLANICI ADINI DEĞİŞTİRİNİZ");
                    durumm = false;
                    txtKullaniciAdi.requestFocus();
                    break;
                } else {
                    durumm = true;
                }
            }

        } catch (Exception e) {
        }

        return durumm;
    }

    public boolean txtKontrol() {
        boolean alanDurum = false;

        if (boslukVarmi(txtAdi.getText().trim())) {
            JOptionPane.showMessageDialog(this, "ADI ALANI BOŞ OLAMAZ!");
            alanDurum = false;
            txtAdi.setText("");
            txtAdi.requestFocus();
        } else if (boslukVarmi(txtSoyadi.getText().trim())) {
            JOptionPane.showMessageDialog(this, "SOYADI ALANI BOŞ OLAMAZ!");
            alanDurum = false;
            txtSoyadi.setText("");
            txtSoyadi.requestFocus();
        } else if (boslukVarmi(txtTelefon.getText().trim())) {
            JOptionPane.showMessageDialog(this, "TELEFON BİLGİSİ BOŞ OLAMAZ!");
            alanDurum = false;
            txtTelefon.setText("0");
            txtTelefon.requestFocus();
        } else if (txtTelefon.getText().trim().equals("0")) {
            JOptionPane.showMessageDialog(this, "TELEFON BİLGİSİ BOŞ OLAMAZ!");
            alanDurum = false;
            txtTelefon.requestFocus();
        } else if (harfVarmi(txtTelefon.getText())) {
            JOptionPane.showMessageDialog(this, "TELEFON BİLGİSİ HATALI GİRİLMİŞ. TEKRAR KONTROL EDİNİZ!");
            alanDurum = false;
            txtTelefon.requestFocus();
        } else if (boslukVarmi(txtaAdres.getText().trim())) {
            JOptionPane.showMessageDialog(this, "ADRES BİLGİSİ BOŞ OLAMAZ!");
            alanDurum = false;
            txtaAdres.setText("");
            txtaAdres.requestFocus();
        } else if (boslukVarmi(txtKullaniciAdi.getText().trim())) {
            JOptionPane.showMessageDialog(this, "KULLANICI ADI BİLGİSİ BOŞ OLAMAZ!");
            alanDurum = false;
            txtKullaniciAdi.requestFocus();
        } else if (boslukVarmi(txtSifre.getText().trim())) {
            JOptionPane.showMessageDialog(this, "ŞİFRE ALANI BOŞ OLAMAZ!");
            alanDurum = false;
            txtSifre.requestFocus();
        } else {
            alanDurum = true;
        }
        return alanDurum;
    }

    public void garsonEkle(String adi, String soyAdi, String telefon, String adres, String kullaniciAdi, String sifre) {
        try {
            int durum = db.baglan().executeUpdate("insert into garson values (null, '" + adi + "', '" + soyAdi + "', '" + telefon + "', '" + adres + "', '" + kullaniciAdi + "', '" + sifre + "',now() ,2 )");
            System.out.println("personel ekleme durumu : " + durum);
            if (durum > 0) {
                JOptionPane.showMessageDialog(null, adi + " " + soyAdi + " BAŞARILI BİR ŞEKİLDE SİSTEME EKLENDİ.");
                calisanlar.tabloModelleme();
                calisanlar.bilgileriGetir();

            }
        } catch (Exception e) {
            System.err.println("GARSON EKLEME HATASI : " + e);
        }
    }

    public garsonEkle() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtAdi = new javax.swing.JTextField();
        txtSoyadi = new javax.swing.JTextField();
        txtTelefon = new javax.swing.JTextField();
        txtSifre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaAdres = new javax.swing.JTextArea();
        txtKullaniciAdi = new javax.swing.JTextField();
        btnEkle = new javax.swing.JButton();
        btnAnaEkran = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Garson Yönetimi -> Garson Ekleme ");
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

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/ileri26.png"))); // NOI18N
        jButton1.setText("Garson Güncelle");
        jButton1.setIconTextGap(8);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/ileri26.png"))); // NOI18N
        jButton2.setText("Garson Sil");
        jButton2.setIconTextGap(8);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/geri26.png"))); // NOI18N
        jButton3.setText("Garson Listesi");
        jButton3.setIconTextGap(8);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Garson Ekleme İşlemi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setText("Adı :");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel3.setText("Soyadı :");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel4.setText("Telefon :");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel5.setText("Adres :");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel6.setText("Şifre :");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel7.setText("Kullanıcı Adı :");

        txtAdi.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtAdi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAdiKeyPressed(evt);
            }
        });

        txtSoyadi.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtSoyadi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoyadiKeyPressed(evt);
            }
        });

        txtTelefon.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtTelefon.setText("0");
        txtTelefon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonKeyPressed(evt);
            }
        });

        txtSifre.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtSifre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSifreKeyPressed(evt);
            }
        });

        txtaAdres.setColumns(20);
        txtaAdres.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtaAdres.setLineWrap(true);
        txtaAdres.setRows(5);
        txtaAdres.setWrapStyleWord(true);
        txtaAdres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtaAdresKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtaAdres);

        txtKullaniciAdi.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtKullaniciAdi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKullaniciAdiKeyPressed(evt);
            }
        });

        btnEkle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEkle.setText("Ekle");
        btnEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSifre, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtKullaniciAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoyadi, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnEkle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSoyadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKullaniciAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSifre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnEkle)
                .addContainerGap(119, Short.MAX_VALUE))
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
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(btnAnaEkran, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAnaEkran, jButton1, jButton2, jButton3});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        calisanGarsonlar wait = new calisanGarsonlar();
        wait.setVisible(true);
        this.show(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        garsonSil del = new garsonSil();
        del.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        garsonGuncelle up = new garsonGuncelle();
        up.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed

        if (txtKontrol() && kulAdiKontrol()) {
            String ad = txtAdi.getText();
            String soyAdd = txtSoyadi.getText();
            String tel = txtTelefon.getText();
            String addrs = txtaAdres.getText();
            String kullanicii = txtKullaniciAdi.getText();
            String siff = txtSifre.getText();

            garsonEkle(ad, soyAdd, tel, addrs, kullanicii, siff);
            alanTemizle();
            calisanlar.setVisible(true);
            this.dispose();

        } else {

        }


    }//GEN-LAST:event_btnEkleActionPerformed

    private void txtaAdresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaAdresKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtKullaniciAdi.requestFocus();
        }

    }//GEN-LAST:event_txtaAdresKeyPressed

    private void txtAdiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdiKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtSoyadi.requestFocus();
        }

    }//GEN-LAST:event_txtAdiKeyPressed

    private void txtSoyadiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoyadiKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtTelefon.requestFocus();
        }


    }//GEN-LAST:event_txtSoyadiKeyPressed

    private void txtTelefonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtaAdres.requestFocus();
        }
    }//GEN-LAST:event_txtTelefonKeyPressed

    private void txtKullaniciAdiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKullaniciAdiKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtSifre.requestFocus();
        }
    }//GEN-LAST:event_txtKullaniciAdiKeyPressed

    private void txtSifreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSifreKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER) {

            btnEkleActionPerformed(null);
        }
    }//GEN-LAST:event_txtSifreKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        if (evt.getKeyCode() == evt.VK_ESCAPE) {

            calisanlar.setVisible(true);
            this.hide();
        }

    }//GEN-LAST:event_formKeyPressed

    private void btnAnaEkranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnaEkranActionPerformed
        yonetici.YoneticiEkrani anaEkran = new YoneticiEkrani();
        anaEkran.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAnaEkranActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       calisanlar.setVisible(true);
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
            java.util.logging.Logger.getLogger(garsonEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(garsonEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(garsonEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(garsonEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new garsonEkle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnaEkran;
    private javax.swing.JButton btnEkle;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAdi;
    private javax.swing.JTextField txtKullaniciAdi;
    private javax.swing.JTextField txtSifre;
    private javax.swing.JTextField txtSoyadi;
    private javax.swing.JTextField txtTelefon;
    private javax.swing.JTextArea txtaAdres;
    // End of variables declaration//GEN-END:variables
}
