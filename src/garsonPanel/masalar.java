package garsonPanel;

import asciPanel.DB;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

public class masalar extends javax.swing.JFrame implements Runnable {

    private int location_x = 4;
    private int location_y = 0;
    DB db = new DB();
    masaSiparis mas = new masaSiparis();
    public static String masaID = "";
    ArrayList list = new ArrayList();
    ArrayList listId = new ArrayList();
    ArrayList buttonlar = new ArrayList();
    static String reff = "";

    ActionListener click = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JButton button = (JButton) ae.getSource();
            String[] dizi1 = null;
            masaID = null;
            try {

                if (!db.baglan().isClosed()) {
                    // click ile masa isminden masanın ID sini getir.

                    masaID = ae.getActionCommand();
                    mas.jLabel1.setText("Masa " + masaID + " " + "Sipariş Bilgisi");
                    ResultSet rs1 = db.baglan().executeQuery("SELECT ref_kodu FROM sepet WHERE masa_id='" + masaID + "' AND (durum = 0 OR durum =2)");
                    if (rs1.next()) {
                        // tıklanan masanın O ANKİ ref_kodunu getir
                        reff = rs1.getString("ref_kodu");
                    }rs1.close();
                    // masalar kırmızı veya mavi ise click aktif olur
                    if (button.getBackground().getRGB() == Color.decode("#e34360").getRGB() || button.getBackground().getRGB() == Color.decode("#4584bb").getRGB()) {
                        mas.setVisible(true);
                    }
                    
                }
            } catch (SQLException ex) {
                System.err.println("Buton click hatası : " + ex);
            } finally {
                try {
                    db.con.close();
                    db.st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(masalar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    };

    @Override
    public void run() {
        try {
            while (true) {
                siparisVarsa(); // masaları dinle
                odemeTalep();   // ödeme talep edenleri dinleme
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.err.println("Thread run Hatası : " + e);
        }
    }

    public masalar() throws SQLException {
        initComponents();
        masalariGetir();
        Thread t1 = new Thread(this);
        t1.start();
    }

    public void siparisVarsa() {
        list.clear();
        JButton btn2 = null;
        try {
            if (!db.baglan().isClosed()) {
                ResultSet rs = db.baglan().executeQuery("call durumAra(0)");
                while (rs.next()) {
                    list.add(rs.getString("masa_id"));
                }rs.close();
                if (list.isEmpty()) {
                    for (int i = 0; i < buttonlar.size(); i++) {
                        btn2 = (JButton) buttonlar.get(i);
                        btn2.setBackground(Color.decode("#60d277"));
                    }
                }
                for (int i = 0; i < listId.size(); i++) {
                    for (int j = 0; j < list.size(); j++) {
                        if (listId.get(i) != (list.get(j))) {
                            btn2 = (JButton) buttonlar.get(i);
                            btn2.setBackground(Color.decode("#60d277"));
                        }
                    }
                }
                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < listId.size(); j++) {
                        if (list.get(i).equals(listId.get(j))) {
                            btn2 = (JButton) buttonlar.get(j);
                            btn2.removeActionListener(click);
                            btn2.setBackground(Color.decode("#e34360"));
                            btn2.addActionListener(click);
                        }
                    }
                }
                          }
        } catch (Exception e) {
            System.err.println("Sipariş dinleme hatası : " + e);
        } finally {
            try {
                db.con.close();
                db.st.close();
            } catch (SQLException ex) {
                Logger.getLogger(masalar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void odemeTalep() {
//////////ödeme taleplerini dinleme metodu/////////////////
        try {
            if (!db.baglan().isClosed()) {
                ResultSet rs = db.baglan().executeQuery(""
                        + "SELECT M.id FROM masalar M \n"
                        + "LEFT JOIN sepet SE ON M.id = SE.masa_id\n"
                        + "LEFT JOIN satis SA ON SA.ref_kodu = SE.ref_kodu\n"
                        + "WHERE SA.durum = 1 OR SE.durum=2");
                while (rs.next()) {
                    // bir masa ödeme talep ettiyse buton rengini değiştiriyor

                    for (int i = 0; i < buttonlar.size(); i++) {

                        JButton btn1 = (JButton) buttonlar.get(i);
                        String dizi1 = btn1.getActionCommand();
                        String masaa = rs.getString("id");
                        if (dizi1.equals(masaa)) {
                            btn1.removeActionListener(click);
                            btn1.setBackground(Color.decode("#4584bb"));
                            btn1.addActionListener(click);
                            dizi1 = "";
                        }
                    }
                }
                rs.close();
            }
        } catch (Exception e) {
            System.err.println("Ödeme dinleme hatası : " + e);
        } finally {
            try {
                db.con.close();
                db.st.close();
            } catch (SQLException ex) {
                Logger.getLogger(masalar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void masalariGetir() {

        int sayac = 0;
        try {
            if (!db.baglan().isClosed()) {
                ResultSet rs = db.baglan().executeQuery("select * from masalar");

                while (rs.next()) {
                    listId.add(rs.getString("id"));
                    JButton button = new JButton();
                    button.setText(rs.getString("masa_adi"));
                    button.setSize(150, 150);
                    button.setFont(new Font("Calibri", 0, 25));
                    if (sayac % 5 == 0 && sayac != 0) {
                        location_x = 4;
                        location_y += 150;
                        button.setLocation(location_x, location_y);
                    }
                    button.setLocation(location_x, location_y);
                    location_x += 154;

                    button.setActionCommand(rs.getString("id"));
                    buttonlar.add(button);
                    panel.add(button);
                    button = null;
                    sayac++;
                }
                rs.close();
            }
        } catch (SQLException ex) {
            System.err.println("Masa oluşturma hatası: " + ex);
        } finally {
            try {
                db.con.close();
                db.st.close();
            } catch (SQLException ex) {
                Logger.getLogger(masalar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setAutoscrolls(true);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        jButton1.setText("Kullanıcı Ayarları");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getAccessibleContext().setAccessibleName("frame1");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new garsonAyarlar().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(masalar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(masalar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(masalar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(masalar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new masalar().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(masalar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

}
