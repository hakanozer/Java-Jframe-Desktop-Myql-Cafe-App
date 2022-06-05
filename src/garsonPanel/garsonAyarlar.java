package garsonPanel;

import asciPanel.Asci;
import asciPanel.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class garsonAyarlar extends javax.swing.JFrame {

    DB db = new DB();
    String isim="";
    ArrayList<String> kulAdiListe = new ArrayList<>();
    
    public boolean HarfVarmi(String bak) {

        boolean durum = false;

        for (int i = 0; i < bak.length(); i++) {

            if (Character.isLetter(bak.charAt(i))) {

                durum = true;

            } else {
                durum = false;
            }

        }

        return durum;
    }
    
    public boolean boslukVarmi(String bak) {

        boolean boslukDurum = true;

        if (bak.equals("")) {
            
            boslukDurum = true;
        } else {
            
            boslukDurum = false;
        }

        return boslukDurum;
    }
    
    public boolean KulAdiKontrol() {
        boolean Kontrol = false;
        
        if (boslukVarmi(txtKulAdi.getText().trim())) {
            JOptionPane.showMessageDialog(this, "KULLANICI ADI BOŞ OLAMAZ!");
            Kontrol = false;
            txtKulAdi.setText("");
            txtKulAdi.requestFocus();
        
        }else {
            
            try {
            ResultSet rs = db.baglan().executeQuery("select kul_adi from garson");

            while (rs.next()) {
                kulAdiListe.add(rs.getString("kul_adi"));
            }
            for (int x = 0; x < kulAdiListe.size(); x++) {
                if (kulAdiListe.get(x).equals(txtKulAdi.getText())) {
                    System.out.println(kulAdiListe.get(x));
                    txtKulAdi.setText("");
                    txtKulAdi.requestFocus();
                    JOptionPane.showMessageDialog(this, "Tercih ettiğiniz kulanıcı adı başka bir kullanıcı tarafından kullanılmaktadır. Lütfen farklı bir kullanıcı adı belirleyiniz.");
                    Kontrol = false;
                    break;
                    
                } else {
                    Kontrol = true;
                }
            }

            } catch (Exception e) {
                System.err.println("kulAdiKontrol- MySQL Bağlantı Hatsı");
            }
            
        } 
        return Kontrol;
        } 
    
    
    public boolean SifreKontrol() {
        boolean Kontrol = false;
        
        if (boslukVarmi(txtYeniSifre.getText().trim())) {
            JOptionPane.showMessageDialog(this, "ŞİFRE ALANI BOŞ OLAMAZ!");
            Kontrol = false;
            txtYeniSifre.setText("");
            txtYeniSifre.requestFocus();
            
        } else if (boslukVarmi(txtEskiSifre.getText().trim())) {
            JOptionPane.showMessageDialog(this, "ŞİFRE ALANI BOŞ OLAMAZ!");
            Kontrol = false;
            txtEskiSifre.setText("");
            txtEskiSifre.requestFocus();
            
        } else if (txtEskiSifre.getText().contains("Eski Şifre")) {
            JOptionPane.showMessageDialog(this, "ŞİFRE ALANI BOŞ OLAMAZ!");
            Kontrol = false;
            txtEskiSifre.requestFocus();
            
        } else if (txtYeniSifre.getText().contains("Yeni Şifre")) {
            JOptionPane.showMessageDialog(this, "ŞİFRE ALANI BOŞ OLAMAZ!");
            Kontrol = false;
            txtYeniSifre.requestFocus();
        } else {
            
            Kontrol = true;
    }
        return Kontrol;        
    }
    
    public boolean TelKontrol() {
        boolean Kontrol = false;
      
    if (boslukVarmi(txtTel.getText().trim())) {
          JOptionPane.showMessageDialog(this, "TELEFON BİLGİSİ BOŞ OLAMAZ!");
          Kontrol = false;
          txtTel.setText("");
          txtTel.requestFocus();
        
    } else if (HarfVarmi(txtTel.getText())) {
            JOptionPane.showMessageDialog(this, "TELEFON BİLGİSİ HATALI GİRİLMİŞ. TEKRAR KONTROL EDİNİZ!");
            Kontrol = false;
            txtTel.requestFocus();
        
    } else {
            Kontrol = true;
        } 
        return Kontrol;
        } 
    
    
    public boolean AdresKontrol() {
        boolean Kontrol = false;
      
    if (boslukVarmi(txtAdres.getText().trim())) {
          JOptionPane.showMessageDialog(this, "ADRES BİLGİSİ BOŞ OLAMAZ!");
          Kontrol = false;
          txtAdres.setText("");
          txtAdres.requestFocus();
        
    } else {
            Kontrol = true;
        } 
        return Kontrol;
        } 
    
    public garsonAyarlar() {
        initComponents();
      
        jLabel1.setText(garsonuGetir());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnKulAdi = new javax.swing.JButton();
        btnSifre = new javax.swing.JButton();
        txtKulAdi = new javax.swing.JTextField();
        txtEskiSifre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnTel = new javax.swing.JButton();
        btnAdres = new javax.swing.JButton();
        txtTel = new javax.swing.JTextField();
        txtAdres = new javax.swing.JTextField();
        txtYeniSifre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ayarlar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        btnKulAdi.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnKulAdi.setText("Kullanıcı Adı Değiştir");
        btnKulAdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKulAdiActionPerformed(evt);
            }
        });

        btnSifre.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnSifre.setText("Şifre Değiştir");
        btnSifre.setPreferredSize(new java.awt.Dimension(145, 23));
        btnSifre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSifreActionPerformed(evt);
            }
        });

        txtKulAdi.setPreferredSize(new java.awt.Dimension(6, 23));

        txtEskiSifre.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        txtEskiSifre.setText("Eski Şifre");
        txtEskiSifre.setPreferredSize(new java.awt.Dimension(50, 23));
        txtEskiSifre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEskiSifreFocusGained(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N

        btnTel.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnTel.setText("Telefon Numarası Değiştir");
        btnTel.setPreferredSize(new java.awt.Dimension(145, 23));
        btnTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelActionPerformed(evt);
            }
        });

        btnAdres.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnAdres.setText("Adres Değiştir");
        btnAdres.setPreferredSize(new java.awt.Dimension(145, 23));
        btnAdres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdresActionPerformed(evt);
            }
        });

        txtTel.setPreferredSize(new java.awt.Dimension(6, 23));

        txtAdres.setPreferredSize(new java.awt.Dimension(6, 23));

        txtYeniSifre.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        txtYeniSifre.setText("Yeni Şifre");
        txtYeniSifre.setPreferredSize(new java.awt.Dimension(50, 23));
        txtYeniSifre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtYeniSifreFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTel, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtEskiSifre, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtYeniSifre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAdres, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKulAdi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(btnAdres, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSifre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnKulAdi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(36, 36, 36))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKulAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKulAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAdres, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdres, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtYeniSifre, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEskiSifre, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSifre, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public String garsonuGetir(){
    
        try {
            
            ResultSet rs = db.baglan().executeQuery("Select adi, soyadi FROM garson WHERE id= '"+Garson.garsonumuz+"'");
           while(rs.next()){
           isim = rs.getString("adi") + " " +rs.getString("soyadi");
           }
           
        } catch (SQLException ex) {
            Logger.getLogger(garsonAyarlar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isim;
    }
    
    private void btnKulAdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKulAdiActionPerformed

        if(KulAdiKontrol()){
            
        try {
            
            if (!db.baglan().isClosed()){
            
            int guncelDurum = db.baglan().executeUpdate("UPDATE garson SET kul_adi = '" + txtKulAdi.getText() + "' WHERE id = '"+Garson.garsonumuz+"' ");
            
            if (guncelDurum > 0) {

                if (boslukVarmi(txtKulAdi.getText().trim())) {

                    JOptionPane.showMessageDialog(this, "Kullanıcı Adı Girilmedi!");

                } else {
                    JOptionPane.showMessageDialog(this, "Kullanıcı Adınız Başarıyla Değiştirildi.");
                }

            }
            
            }
            
        } catch (Exception e) {
            System.err.println("Sorgu Hatası" + e);
        }
        
        finally {
            try {
                db.con.close();
                db.st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Garson.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        txtKulAdi.setText("");
        
        }

    }//GEN-LAST:event_btnKulAdiActionPerformed

    private void btnSifreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSifreActionPerformed

        if(SifreKontrol()){ 
            
        
        try {
            
            if (!db.baglan().isClosed()){

            int guncelDurum = db.baglan().executeUpdate("UPDATE garson SET sifre = '" + txtYeniSifre.getText() + "' WHERE sifre = '" + txtEskiSifre.getText() + "' AND id = '"+Garson.garsonumuz+"' ");

            if (guncelDurum > 0) {
              
                JOptionPane.showMessageDialog(this, "Şifreniz Başarıyla Değiştirildi.");
                txtEskiSifre.setText("Eski Şifre");
                txtYeniSifre.setText("Yeni Şifre");
            }
            
            else{
                
                txtYeniSifre.setText("");
                txtEskiSifre.requestFocus();
                JOptionPane.showMessageDialog(this, "HATALI ŞİFRE!");
            }
            
            }
        } catch (Exception e) {

            System.err.println("Sorgu Hatası" + e);
            
            }
        
        finally {
            try {
                db.con.close();
                db.st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Garson.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }//GEN-LAST:event_btnSifreActionPerformed

    private void btnTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelActionPerformed

        if(TelKontrol()){
            
        try {
            
            if (!db.baglan().isClosed()){

            int guncelDurum = db.baglan().executeUpdate("UPDATE garson SET telefon = '" + txtTel.getText() + "' WHERE id = '"+Garson.garsonumuz+"' ");

            if (guncelDurum > 0) {

                JOptionPane.showMessageDialog(this, "Telefon Numaranız Başarıyla Değiştirildi.");
            }
           
            }
            
        } catch (Exception e) {
            System.err.println("Sorgu Hatası" + e);
        }
        
        finally {
            try {
                db.con.close();
                db.st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Garson.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        txtTel.setText("");
        } 
    }//GEN-LAST:event_btnTelActionPerformed

    private void btnAdresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdresActionPerformed

        if(AdresKontrol()){ 
            
        try {
            
            if (!db.baglan().isClosed()){

            int guncelDurum = db.baglan().executeUpdate("UPDATE garson SET adres = '" + txtAdres.getText() + "' WHERE id = '"+Garson.garsonumuz+"' ");

            if (guncelDurum > 0) {

                if (boslukVarmi(txtAdres.getText().trim())) {
                JOptionPane.showMessageDialog(this, "Adres Bilgisi Girişi Yapılmadı!");
                txtAdres.setText("");
                txtAdres.requestFocus();

                } else {
                    JOptionPane.showMessageDialog(this, "Adres Bilgileriniz Başarıyla Değiştirildi.");
                }

            }
            
            }
        } catch (Exception e) {
            System.err.println("Sorgu Hatası" + e);
        }
        
        finally {
            try {
                db.con.close();
                db.st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Garson.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        txtAdres.setText("");
        }
    }//GEN-LAST:event_btnAdresActionPerformed

    private void txtEskiSifreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEskiSifreFocusGained

        
        txtEskiSifre.setText("");
    }//GEN-LAST:event_txtEskiSifreFocusGained

    private void txtYeniSifreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtYeniSifreFocusGained

        txtYeniSifre.setText("");
    }//GEN-LAST:event_txtYeniSifreFocusGained

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
            java.util.logging.Logger.getLogger(garsonAyarlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(garsonAyarlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(garsonAyarlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(garsonAyarlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new garsonAyarlar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdres;
    private javax.swing.JButton btnKulAdi;
    private javax.swing.JButton btnSifre;
    private javax.swing.JButton btnTel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAdres;
    private javax.swing.JTextField txtEskiSifre;
    private javax.swing.JTextField txtKulAdi;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtYeniSifre;
    // End of variables declaration//GEN-END:variables
}
