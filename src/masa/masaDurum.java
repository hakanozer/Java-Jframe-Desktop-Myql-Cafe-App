package masa;

import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import yonetici.DB;
import yonetici.YoneticiEkrani;

public class masaDurum extends javax.swing.JFrame {

    yonetici.DB db = new DB();

    public masaDurum() {
        initComponents();
        masaSatisSepetBilgi();

    }

    public void masaSatisSepetBilgi() {
        DefaultTableModel model2 = new DefaultTableModel();

        model2.addColumn("ID");
        model2.addColumn("Ref. Kodu");
        model2.addColumn("Masa ID");
        model2.addColumn("Sepet Durumu");
        model2.addColumn("Sepet Tarihi");
        model2.addColumn("Satış ID");
        model2.addColumn("Satış Durumu");
        model2.addColumn("Satış Tarihi");

        try {
            ResultSet rs2 = db.baglan().executeQuery("select *from sepet inner join satis on sepet.ref_kodu=satis.ref_kodu");
            while (rs2.next()) {
                model2.addRow(new String[]{rs2.getString("sepet.id"), rs2.getString("sepet.ref_kodu"), rs2.getString("masa_id"), rs2.getString("sepet.durum"), rs2.getString("sepet.tarih"), rs2.getString("satis.id"), rs2.getString("satis.durum"), rs2.getString("satis.tarih")});
            }
            tblDurum.setModel(model2);

        } catch (Exception e) {
            System.err.println("Sepet bilgi getirme hatası : " + e);
        }

        tblDurum.getColumnModel().getColumn(0).setMaxWidth(30);
        tblDurum.getColumnModel().getColumn(0).setMinWidth(30);

//        tblDurum.getColumnModel().getColumn(1).setMaxWidth(70);
//        tblDurum.getColumnModel().getColumn(1).setMinWidth(70);

        tblDurum.getColumnModel().getColumn(2).setMaxWidth(50);
        tblDurum.getColumnModel().getColumn(2).setMinWidth(50);

        tblDurum.getColumnModel().getColumn(3).setMaxWidth(80);
        tblDurum.getColumnModel().getColumn(3).setMinWidth(80);

        tblDurum.getColumnModel().getColumn(5).setMaxWidth(50);
        tblDurum.getColumnModel().getColumn(5).setMinWidth(50);

        tblDurum.getColumnModel().getColumn(6).setMaxWidth(80);
        tblDurum.getColumnModel().getColumn(6).setMinWidth(80);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDurum = new javax.swing.JTable();
        lblDurum = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnMasaYonetim = new javax.swing.JButton();
        btnAnaEkran = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Masa Yönetimi -> Masa Durum");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Masa Durum", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11))); // NOI18N

        tblDurum.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDurum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDurumMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDurum);

        lblDurum.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblDurum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDurum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        lblDurum.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Masa Durumu :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblDurum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDurum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnMasaYonetim.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnMasaYonetim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/geri26.png"))); // NOI18N
        btnMasaYonetim.setText("Masa Yönetimi");
        btnMasaYonetim.setIconTextGap(8);
        btnMasaYonetim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasaYonetimActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnaEkran, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMasaYonetim)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMasaYonetim, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnaEkran, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAnaEkran, btnMasaYonetim});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblDurumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDurumMouseClicked

        if (tblDurum.getValueAt(tblDurum.getSelectedRow(), 6).toString().equals("0")) {
            lblDurum.setBackground(Color.RED);
            lblDurum.setText("Masa Dolu");

        } else {
            lblDurum.setBackground(Color.GREEN);
            lblDurum.setText("Masa Boş");

        }

    }//GEN-LAST:event_tblDurumMouseClicked

    private void btnMasaYonetimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasaYonetimActionPerformed
        masaSinif masaEkrani = new masaSinif();
        masaEkrani.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMasaYonetimActionPerformed

    private void btnAnaEkranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnaEkranActionPerformed
        yonetici.YoneticiEkrani anaEkran = new YoneticiEkrani();
        anaEkran.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAnaEkranActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        masaSinif masalar = new masaSinif();
        masalar.setVisible(true);
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
            java.util.logging.Logger.getLogger(masaDurum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(masaDurum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(masaDurum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(masaDurum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new masaDurum().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnaEkran;
    private javax.swing.JButton btnMasaYonetim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDurum;
    private javax.swing.JTable tblDurum;
    // End of variables declaration//GEN-END:variables
}
