package yonetici;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class YoneticiLogin extends javax.swing.JFrame {

    DB db = new DB();
    YoneticiEkrani yetkili = new YoneticiEkrani();

    public YoneticiLogin() {
        initComponents();
    }

    protected boolean login(JTextField txtKulAdi, JPasswordField txtSifre, JLabel jl1, JLabel jl2) {
        // bu metod aşçının sisteme giriş işlemini yapıyor
        // parametre olarak textfield ve uyarı labellerini alıyor
        String kuladi = txtKulAdi.getText();
        String sifre = txtSifre.getText();

        boolean acKapa = false; // login ekranını geçtiğimizde kapanması için
        try {
            if (!db.baglan().isClosed()) {
                ResultSet rs = db.baglan().executeQuery("select * from yonetici where mail = '" + kuladi + "' and sifre = '" + sifre + "'");
                if (rs.next()) {
                    // kullanıcı var olma durumunda
                    // son giriş tarihini tut

                    int giris = db.baglan().executeUpdate("INSERT INTO giris_tarihleri VALUE (null, '" + rs.getString("seviye") + "' , '" + rs.getString("id") + "' ,now())");
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "Hoşgeldin " + rs.getString("adi") + " " + rs.getString("soyadi"));

                    yetkili.setVisible(true); // ikinci pencere açılıyor
                    acKapa = true;
                } else {
                    // kullanıcı yok ise...
                    JOptionPane.showMessageDialog(null, "Kullanıcı Adı veya Şifre hatalı!");
                    txtKulAdi.setText("");
                    txtSifre.setText("");
                    jl1.setText("");
                    jl2.setText("");
                    txtKulAdi.requestFocus();
                    acKapa = false;
                }
                rs.close();

            }
        } catch (Exception e) {
            System.err.println("Mysql Giriş Hatası" + e);
        } finally {
            try {
                db.con.close();
                db.st.close();
            } catch (SQLException ex) {
                Logger.getLogger(YoneticiEkrani.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return acKapa;
    }

    public void boslukKontrol(JTextField jt1, JTextField jt2, JLabel jl1, JLabel jl2) {

        // bu metod boş bırakılmış textfield için uyarı vererek odaklanma sağlıyor
        if (jt1.getText().isEmpty()) {
            jt1.requestFocus();
            jl1.setText("Kullanıcı Adı giriniz!");
        } else {
            jl1.setText("");
        }
        if (jt2.getText().isEmpty()) {
            jt2.requestFocus();
            jl2.setText("Şifre giriniz!");
        } else {
            jl2.setText("");
        }
//bu koşul, ikisinin de boş bırakılması durumunda kullanıcı adına odaklanma sağlıyor
        if (jt1.getText().isEmpty() && jt2.getText().isEmpty()) {
            jt1.requestFocus();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrs = new javax.swing.JButton();
        txtKulAdi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSifre = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnGrs.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        btnGrs.setText("Giriş Yap");
        btnGrs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrsActionPerformed(evt);
            }
        });

        txtKulAdi.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        txtKulAdi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtKulAdi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKulAdiKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Yönetici Giriş Paneli");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));

        txtSifre.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        txtSifre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSifre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSifreKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtKulAdi)
            .addComponent(txtSifre, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(btnGrs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(136, Short.MAX_VALUE))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKulAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(txtSifre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnGrs, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGrsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrsActionPerformed
        if (!txtKulAdi.getText().isEmpty() && !txtSifre.getText().isEmpty()) {
            if (this.login(txtKulAdi, txtSifre, jLabel4, jLabel5)) {
                // bu if ile login sağlandığında,
                // login penceresini kapattık
                setVisible(false);
                dispose();
            }
        } else {
            boslukKontrol(txtKulAdi, txtSifre, jLabel4, jLabel5);
        }
    }//GEN-LAST:event_btnGrsActionPerformed

    private void txtKulAdiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKulAdiKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtKulAdi.getText().isEmpty() && !txtSifre.getText().isEmpty()) {
                if (this.login(txtKulAdi, txtSifre, jLabel4, jLabel5)) {
                    // bu if ile login sağlandığında,
                    // login penceresini kapattık
                    setVisible(false);
                    dispose();
                }
            } else {
                boslukKontrol(txtKulAdi, txtSifre, jLabel4, jLabel5);
            }
        }
    }//GEN-LAST:event_txtKulAdiKeyPressed

    private void txtSifreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSifreKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtKulAdi.getText().isEmpty() && !txtSifre.getText().isEmpty()) {
                if (this.login(txtKulAdi, txtSifre, jLabel4, jLabel5)) {
                    // bu if ile login sağlandığında,
                    // login penceresini kapattık
                    setVisible(false);
                    dispose();
                }
            } else {
                boslukKontrol(txtKulAdi, txtSifre, jLabel4, jLabel5);
            }
        }
    }//GEN-LAST:event_txtSifreKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        CafeProgramiStart anaGiris = new CafeProgramiStart();
        anaGiris.setVisible(true);
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
            java.util.logging.Logger.getLogger(YoneticiLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YoneticiLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YoneticiLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YoneticiLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YoneticiLogin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGrs;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtKulAdi;
    private javax.swing.JPasswordField txtSifre;
    // End of variables declaration//GEN-END:variables
}
