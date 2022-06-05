
package yonetici;

import asciPanel.AsciLogin;
import garsonPanel.GarsonLogin;
import musteri.cafe;

public class CafeProgramiStart extends javax.swing.JFrame {

    public CafeProgramiStart() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMutfak = new javax.swing.JButton();
        btnGarson = new javax.swing.JButton();
        btnMusteri = new javax.swing.JButton();
        btnYonetici = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cafe Programı Login");

        btnMutfak.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnMutfak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/asci64.png"))); // NOI18N
        btnMutfak.setText("Mutfak ");
        btnMutfak.setFocusable(false);
        btnMutfak.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMutfak.setIconTextGap(30);
        btnMutfak.setMargin(new java.awt.Insets(2, 40, 2, 2));
        btnMutfak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMutfakActionPerformed(evt);
            }
        });

        btnGarson.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnGarson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/garson64.png"))); // NOI18N
        btnGarson.setText("Garson");
        btnGarson.setFocusable(false);
        btnGarson.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGarson.setIconTextGap(30);
        btnGarson.setMargin(new java.awt.Insets(2, 40, 2, 2));
        btnGarson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGarsonActionPerformed(evt);
            }
        });

        btnMusteri.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnMusteri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/menu64.png"))); // NOI18N
        btnMusteri.setText("Menü");
        btnMusteri.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMusteri.setIconTextGap(30);
        btnMusteri.setMargin(new java.awt.Insets(2, 40, 2, 2));
        btnMusteri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusteriActionPerformed(evt);
            }
        });

        btnYonetici.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnYonetici.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/yonetici64.png"))); // NOI18N
        btnYonetici.setText("Yönetici");
        btnYonetici.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnYonetici.setIconTextGap(30);
        btnYonetici.setMargin(new java.awt.Insets(2, 40, 2, 2));
        btnYonetici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYoneticiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cafe Otomasyonu");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGarson, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMusteri, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMutfak, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnYonetici, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMusteri, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMutfak, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGarson, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnYonetici, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMutfakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMutfakActionPerformed
        
        asciPanel.AsciLogin asci = new AsciLogin();
        asci.setVisible(true);
        this.setVisible(false);
        this.dispose();
        
        
    }//GEN-LAST:event_btnMutfakActionPerformed

    private void btnGarsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGarsonActionPerformed
        
         garsonPanel.GarsonLogin garson = new GarsonLogin();
         garson.setVisible(true);
         this.setVisible(false);
         this.dispose();
        
    }//GEN-LAST:event_btnGarsonActionPerformed

    private void btnMusteriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusteriActionPerformed
        
        cafe musteri = new cafe();
        musteri.setVisible(true);
        this.setVisible(false);
        this.dispose();
        
    }//GEN-LAST:event_btnMusteriActionPerformed

    private void btnYoneticiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYoneticiActionPerformed
       
        YoneticiLogin yonetici = new YoneticiLogin();
        yonetici.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnYoneticiActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CafeProgramiStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CafeProgramiStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CafeProgramiStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CafeProgramiStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CafeProgramiStart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGarson;
    private javax.swing.JButton btnMusteri;
    private javax.swing.JButton btnMutfak;
    private javax.swing.JButton btnYonetici;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
