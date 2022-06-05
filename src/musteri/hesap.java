package musteri;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class hesap extends javax.swing.JFrame {

    private static int masaID = 5;
    DB db;
    cafe c;
    private static String refKodu = "";
    private static int apsis = 10, ordinat = 10;
    private String[] urunId;
    private String[] sepetId;
    private static double toplam = 0;
    JCheckBox[] check;
    HashMap<String, String> fiyat;

    public hesap() {
        initComponents();

        db = new DB();
    }

    public hesap(String refKodu) {
        initComponents();

        this.refKodu = refKodu;
        db = new DB();
        sepetGetir();
    }

    public hesap(cafe c, String ref) {
        initComponents();
        this.refKodu = ref;
        this.c = c;
        apsis = 10;
        ordinat = 10;
        db = new DB();
        sepetGetir();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnOdeme = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        btnOdeme.setText("Nakit");
        btnOdeme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdemeActionPerformed(evt);
            }
        });
        jPanel7.add(btnOdeme);

        jButton2.setText("Kredi Kartı");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton2);

        jButton3.setText("Diğer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton3);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 102, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addGap(6, 6, 6)))
        );

        jLabel1.setText("Toplam : 0");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        jPanel4.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        jPanel5.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addGap(64, 64, 64))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel3);

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Tümünü Seç");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        c.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        c.setVisible(true);
        try {
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(hesap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnOdemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdemeActionPerformed

        ArrayList<String> sepetID = new ArrayList<>();
        for (int i = 0; i < check.length; i++) {
            if (check[i].isSelected() && check[i].isEnabled()) {
                sepetID.add(sepetId[i]);
            }
        }

        if (!sepetID.isEmpty()) {

            try {

               // String durum = optionPane();
               // System.out.println(durum);
               // if (durum != null) {

                    for (String sepetID1 : sepetID) {
                        db.baglan().executeUpdate("update sepet set durum=2 where id='" + sepetID1 + "' AND durum = 0");
                        db.baglan().close();
                        System.out.println(sepetID1 + "Sepet ");
                    }
                    db.baglan().executeUpdate("call satisaEkle('" + masaID + "','1','" + toplam + "','" + refKodu + "')");
                    db.baglan().close();

                    toplam = 0;
                    jLabel1.setText("Toplam : " + toplam);
               // } else {
               //     System.out.println("cancel");
               // }
            } catch (SQLException ex) {
                System.err.println("btnOdemeActionPerformed" + ex);
            }
        }
        sepetGetir();
    }//GEN-LAST:event_btnOdemeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ArrayList<String> sepetID = new ArrayList<>();
        for (int i = 0; i < check.length; i++) {
            if (check[i].isSelected() && check[i].isEnabled()) {
                sepetID.add(sepetId[i]);
            }
        }

        if (!sepetID.isEmpty()) {

            try {

                //String durum = optionPane();
              //  System.out.println(durum);
              //  if (durum != null) {

                    for (String sepetID1 : sepetID) {
                        db.baglan().executeUpdate("update sepet set durum=2 where id='" + sepetID1 + "' AND durum = 0");
                        db.baglan().close();
                        System.out.println(sepetID1 + "Sepet ");
                    }
                    db.baglan().executeUpdate("call satisaEkle('" + masaID + "','0','" + toplam + "','" + refKodu + "')");
                    db.baglan().close();

                    toplam = 0;
                    jLabel1.setText("Toplam : " + toplam);
               // } else {
              //      System.out.println("cancel");
              //  }
            } catch (SQLException ex) {
                System.err.println("btnOdemeActionPerformed" + ex);
            }
        }
        sepetGetir();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ArrayList<String> sepetID = new ArrayList<>();
        for (int i = 0; i < check.length; i++) {
            if (check[i].isSelected() && check[i].isEnabled()) {
                sepetID.add(sepetId[i]);
            }
        }

        if (!sepetID.isEmpty()) {

            try {

               // String durum = optionPane();
               // System.out.println(durum);
               // if (durum != null) {

                    for (String sepetID1 : sepetID) {
                        db.baglan().executeUpdate("update sepet set durum=2 where id='" + sepetID1 + "' AND durum = 0");
                        db.baglan().close();
                        System.out.println(sepetID1 + "Sepet ");
                    }

                    db.baglan().executeUpdate("call satisaEkle('" + masaID + "','2','" + toplam + "','" + refKodu + "')");
                    db.baglan().close();

                    toplam = 0;
                    jLabel1.setText("Toplam : " + toplam);
              //  } else {
              //      System.out.println("cancel");
              //  }
            } catch (SQLException ex) {
                System.err.println("btnOdemeActionPerformed" + ex);
            }
        }
        sepetGetir();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        
        if (jCheckBox1.isSelected()) {
            toplam = 0.0;
            for (JCheckBox c : check) {
                c.setSelected(true);;
                toplam += Double.valueOf(fiyat.get(c.getText()));
                jLabel1.setText("Toplam : " + toplam);
            }
        } else {

            for (JCheckBox c : check) {
                if (c.isEnabled() && c.isSelected()) {
                    c.setSelected(false);
                    toplam -= Double.valueOf(fiyat.get(c.getText()));
                    jLabel1.setText("Toplam : " + toplam);
                }
            }
        }

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
        jCheckBox1ActionPerformed(null);
        
        
    }//GEN-LAST:event_formWindowActivated

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(hesap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hesap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hesap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hesap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hesap().setVisible(true);
            }
        });
    }

    JLabel[] field, fiyatlar;

    private String optionPane() {
        JOptionPane.showConfirmDialog(null, new StarRater(5, 0, 0) + " kadar ödemelisiniz!\nBizi oylamak ister msiniz?", "", JOptionPane.YES_NO_CANCEL_OPTION);
        /*
         Object[] possibilities = {"Kredi Kartı", "Nakit", "Diğer"};
         String s = (String) JOptionPane.showInputDialog(
         this,
         "Lütfen ödeme türünü seçiniz:\n",
         "Hesap Ödeme",
         JOptionPane.INFORMATION_MESSAGE,
         null,
         possibilities,
         "Kredi Kartı");

         if ((s != null) && (s.length() > 0)) {
         return s;
         }*/

        return null;
    }

    private void sepetGetir() {
        int i = 0;
        apsis = 10;
        ordinat = 10;

        jPanel1.removeAll();
        jPanel4.removeAll();
        jPanel5.removeAll();
        repaint();

        toplam = 0.0;
        jLabel1.setText("Toplam : " + toplam);

        fiyat = new HashMap<String, String>();
        try {
            ResultSet r = db.baglan().executeQuery("SELECT COUNT(*) AS rowcount FROM sepet where ref_kodu='" + refKodu + "';");
            r.next();
            int count = r.getInt("rowcount");
            r.close();
            System.out.println("MyTable has " + count + " row(s).");
            if (count > 0) {
                System.out.println("ifli cmle");
                check = new JCheckBox[count];
                field = new JLabel[count];
                fiyatlar = new JLabel[count];
                urunId = new String[count];
                sepetId = new String[count];

                ArrayList<String> durum = new ArrayList<>();
                ResultSet rs = db.baglan().executeQuery("call sepetGetir('" + refKodu + "');");
                System.out.println("ref" + refKodu);
                while (rs.next()) {
                    System.out.println("durum eklendi");
                    durum.add(rs.getString("durum"));
                }

                rs.beforeFirst();
                while (rs.next()) {
                    sepetId[i] = rs.getString("id");

                    urunId[i] = rs.getString("urunId");

                    check[i] = new JCheckBox(rs.getString("id"));

                    field[i] = new JLabel(rs.getString("ad"));

                    fiyatlar[i] = new JLabel(rs.getString("fiyat"));

                    fiyat.put(rs.getString("Id"), rs.getString("fiyat"));

                    if (durum.get(i).equals("2")) {
                        check[i].setEnabled(false);
                        field[i].setEnabled(false);
                        fiyatlar[i].setEnabled(false);
                        check[i].setSelected(true);
                    } else {
                        check[i].setEnabled(true);
                        field[i].setEnabled(true);
                        fiyatlar[i].setEnabled(true);
                        check[i].setSelected(false);
                    }
                    check[i].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            JCheckBox checkBox = (JCheckBox) ae.getSource();
                            System.out.println(ae.getSource() + "    " + checkBox.getText());
                            if (checkBox.isSelected()) {
                                toplam += Double.valueOf(fiyat.get(checkBox.getText()));
                            } else {
                                toplam -= Double.valueOf(fiyat.get(checkBox.getText()));
                            }

                            jLabel1.setText("Toplam : " + toplam);
                        }
                    });
                    ordinat += 35;
                    System.out.println("fiyat " + fiyatlar[i].getText());
                    jPanel5.add(fiyatlar[i]);
                    jPanel1.add(check[i]);
                    jPanel4.add(field[i]);
                    i++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(hesap.class.getName()).log(Level.SEVERE, null, ex);
        }
        pack();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOdeme;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
