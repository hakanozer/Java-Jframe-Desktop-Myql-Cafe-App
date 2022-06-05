package musteri;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import yonetici.CafeProgramiStart;

public class cafe extends javax.swing.JFrame {

    private static int masaID = 5;
    private static int apsis = 5, ordinat = 5;
    private static int genislik = 80, yukseklik = 25;
    private Dimension buttonDimension = new Dimension(150, 75);
    private static String ref = "";
    JButton[] carpiButonu;
    private ResultSet rs = null;
    JLabel[] lblTime, kacTane, fields, sureler;
    int timerSayac = 0;
    Timer t[];
    TimerTask task[];
    private static int butonTik = 0;
    //database baglantı nesnesi
    DB db;
    ArrayList<String> list;
    ArrayList<String> myList;
    ArrayList<String> numberOfMyList;
    ArrayList<String> fiyatlar;
    ArrayList<String> fiyatHesabi;
    ArrayList<String> sure;
    ArrayList<Object> urunListe;
    ArrayList<Object> goster;

    public cafe() {

        initComponents();
        list = new ArrayList<>();
        fiyatlar = new ArrayList<>();
        sure = new ArrayList<>();
        db = new DB();
        ref = refUret();
        urunListe = new ArrayList();
        Image img, img2;
        ImageIcon icon = null, icon2 = null;
        try {
            img = ImageIO.read(getClass().getResource("sepet.png"));
            Image scaledImage = img.getScaledInstance(40, 40, Image.SCALE_DEFAULT);
            icon = new ImageIcon(scaledImage);

            img2 = ImageIO.read(getClass().getResource("ekle.png"));
            Image scaledImage2 = img2.getScaledInstance(40, 40, Image.SCALE_DEFAULT);
            icon2 = new ImageIcon(scaledImage2);
        } catch (IOException ex) {
            System.out.println("hata " + ex);
        }
        btnSepetiniz.setIcon(icon);
        btnSepeteEkle.setIcon(icon2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroolBolum = new javax.swing.JScrollPane();
        panelBolum = new javax.swing.JPanel();
        scroolKategori = new javax.swing.JScrollPane();
        panelKategori = new javax.swing.JPanel();
        scroolUrun = new javax.swing.JScrollPane();
        panelUrun = new javax.swing.JPanel();
        panelSatis = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelSepet = new javax.swing.JPanel();
        panelSaat = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnSepeteEkle = new javax.swing.JButton();
        btnSepetiniz = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        scroolBolum.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelBolum.setBackground(new java.awt.Color(153, 153, 153));
        panelBolum.setEnabled(false);
        panelBolum.setLayout(new java.awt.GridLayout(0, 1));
        scroolBolum.setViewportView(panelBolum);

        getContentPane().add(scroolBolum);

        scroolKategori.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelKategori.setBackground(new java.awt.Color(153, 153, 153));
        panelKategori.setEnabled(false);
        panelKategori.setLayout(new java.awt.GridLayout(0, 1));
        scroolKategori.setViewportView(panelKategori);

        getContentPane().add(scroolKategori);

        scroolUrun.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelUrun.setBackground(new java.awt.Color(153, 153, 153));
        panelUrun.setLayout(new java.awt.GridLayout(0, 1));
        scroolUrun.setViewportView(panelUrun);

        getContentPane().add(scroolUrun);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelSepet.setBackground(new java.awt.Color(204, 204, 204));
        panelSepet.setAutoscrolls(true);
        panelSepet.setLayout(new java.awt.GridLayout(0, 2));
        jScrollPane1.setViewportView(panelSepet);

        panelSaat.setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setLayout(new java.awt.GridLayout(0, 1));

        btnSepeteEkle.setText("Sepete Ekle");
        btnSepeteEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSepeteEkleActionPerformed(evt);
            }
        });
        jPanel1.add(btnSepeteEkle);

        btnSepetiniz.setText("Sepetim");
        btnSepetiniz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSepetinizActionPerformed(evt);
            }
        });
        jPanel1.add(btnSepetiniz);

        javax.swing.GroupLayout panelSatisLayout = new javax.swing.GroupLayout(panelSatis);
        panelSatis.setLayout(panelSatisLayout);
        panelSatisLayout.setHorizontalGroup(
            panelSatisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelSaat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelSatisLayout.setVerticalGroup(
            panelSatisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSatisLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSaat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(panelSatis);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Bolum();
        Saat();
    }//GEN-LAST:event_formWindowOpened

    private void btnSepeteEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSepeteEkleActionPerformed
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lütfen ürün seçiniz");
        } else {
            ArrayList<String> yazdir = new ArrayList<>();

            for (String yazdir1 : myList) {
                System.out.println("mylist " + yazdir1);
            }

            for (String yazdir1 : numberOfMyList) {
                System.out.println("number " + yazdir1);
            }
            for (int j = 0; j < myList.size(); j++) {
                for (int k = 0; k < Integer.parseInt(numberOfMyList.get(j)); k++) {
                    yazdir.add(idBul(myList.get(j)));
                    System.out.println("idBulucu " + idBul(myList.get(j)));
                }
            }

            try {
                for (int i = 0; i < yazdir.size(); i++) {
                    System.out.println("sepete ekleniyor");
                    System.out.println(yazdir.get(i));
                    db.baglan().executeUpdate("call sepeteEkle('" + ref + "'," + masaID + "," + yazdir.get(i) + ")");
                }
            } catch (SQLException ex) {
                System.out.println("hataaa " + ex);
            } finally {
                try {
                    if (!db.baglan().isClosed()) {
                        db.baglan().close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(cafe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            for (String yazdir1 : yazdir) {
                System.out.println("yazdir " + yazdir1);
            }

            JOptionPane.showMessageDialog(null, "Siparişleriniz sepete eklenmiştir.");
            list.clear();
            numberOfMyList.clear();
            myList.clear();
            fiyatlar.clear();
            fiyatHesabi.clear();
        }
        panelSepet.removeAll();
        panelSepet.repaint();
    }//GEN-LAST:event_btnSepeteEkleActionPerformed

    private String idBul(String get) {
        HashMap<String, String> hash = null;
        for (Object ul1 : urunListe) {
            hash = (HashMap<String, String>) ul1;
            if (hash.get("id" + get) != null) {
                return hash.get("id" + get);
            }
        }
        return null;

    }

    private void btnSepetinizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSepetinizActionPerformed
        int count = 0;
        try {
            rs = db.baglan().executeQuery("SELECT COUNT(*) AS rowcount FROM sepet where ref_kodu='" + ref + "';");
            rs.next();
            count = rs.getInt("rowcount");
            rs.close();
            System.out.println("MyTable has " + count + " row(s).");
        } catch (Exception e) {
            System.err.println("sepet sayi hatası");
        } finally {
            try {
                if (!db.baglan().isClosed()) {
                    db.baglan().close();

                }
            } catch (SQLException ex) {
                Logger.getLogger(cafe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (count > 0) {
            hesap h = new hesap(cafe.this, ref);
            cafe.this.setVisible(false);
            h.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "henüz sipariş vermediniz");
        }

    }//GEN-LAST:event_btnSepetinizActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       
        CafeProgramiStart anaGiris = new CafeProgramiStart();
        anaGiris.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(cafe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cafe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cafe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cafe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cafe().setVisible(true);
            }
        });
    }

    private String refUret() {
        Random r = new Random(1000000);
        String ref = System.currentTimeMillis() + "" + r.nextInt();
        return ref;
    }

    private void Bolum() {
        panelBolum.removeAll();
        repaint();

        ArrayList<Object> bolumListe = new ArrayList();

        try {
            ResultSet rs = db.baglan().executeQuery("select * from bolum");
            while (rs.next()) {
                HashMap<String, String> bolumHashMap = new HashMap<>();
                bolumHashMap.put("id", rs.getString("id"));
                bolumHashMap.put("bolum_adi", rs.getString("bolum_adi"));
                bolumListe.add(bolumHashMap);

            }
        } catch (SQLException ex) {
            System.err.println("Sql bağlantı hatası" + ex);
        } finally {
            try {
                if (!db.baglan().isClosed()) {
                    db.baglan().close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(cafe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        int butonSayisi = bolumListe.size();
        JButton[] buttons = new JButton[butonSayisi];

        int i = 0;
        for (Object bolumListe1 : bolumListe) {

            HashMap<String, String> temp = (HashMap) bolumListe1;
            String id = temp.get("id");
            String bolumAdi = temp.get("bolum_adi");

            buttons[i] = new JButton(bolumAdi);
            buttons[i].setPreferredSize(buttonDimension);
            panelBolum.add(buttons[i]);

            buttons[i].setActionCommand(id);
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    panelUrun.removeAll();
                    String choice = e.getActionCommand();
                    Kategori(Integer.valueOf(choice));
                }
            });
            i++;
        }

        pack();
    }

    private void Kategori(int bolumID) {
        panelKategori.removeAll();
        repaint();

        /*
         veritabanı işlemleri yapılıacak.
         kategorilerden çekilen değerler arrayliste aktarılacak
         */
        ArrayList<Object> kategoriListe = new ArrayList();
        try {
            rs = db.baglan().executeQuery("select * from kategoriler where bolum_id = " + bolumID + "");
            while (rs.next()) {
                HashMap<String, String> kategoriHashMap = new HashMap<>();
                kategoriHashMap.put("id", rs.getString("id"));
                kategoriHashMap.put("kategori_adi", rs.getString("kategori_adi"));
                kategoriListe.add(kategoriHashMap);

            }
        } catch (SQLException ex) {
            System.err.println("Sql bağlantı hatası" + ex);
        }

        int butonSayisi = kategoriListe.size();
        JButton[] buttons = new JButton[butonSayisi];

        int i = 0;
        for (Object kategoriListe1 : kategoriListe) {

            HashMap<String, String> temp = (HashMap) kategoriListe1;
            String id = temp.get("id");
            String kategoriAdi = temp.get("kategori_adi");

            buttons[i] = new JButton(kategoriAdi);
            buttons[i].setPreferredSize(buttonDimension);
            panelKategori.add(buttons[i]);

            buttons[i].setActionCommand(id);
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String choice = e.getActionCommand();
                    Urun(Integer.valueOf(choice));
                }
            });
            i++;
        }

        pack();
    }

    private void Urun(int kategoriID) {
        panelUrun.removeAll();
        repaint();
        goster = new ArrayList<>();

        try {
            ResultSet rs = db.baglan().executeQuery("select * from urunler where kategori_id = " + kategoriID + "");
            while (rs.next()) {
                HashMap<String, String> urunHashMap = new HashMap<>();
                urunHashMap.put("id" + rs.getString("urun_adi"), rs.getString("id"));
                urunHashMap.put("urun_adi", rs.getString("urun_adi"));
                urunHashMap.put(rs.getString("urun_adi"), rs.getString("fiyat"));
                urunListe.add(urunHashMap);
                goster.add(urunHashMap);
            }
        } catch (SQLException ex) {
            System.err.println("Sql bağlantı hatası" + ex);
        }

        int butonSayisi = goster.size();
        JButton[] buttons = new JButton[butonSayisi];

        int i = 0;
        for (Object urunListe1 : goster) {

            HashMap<String, String> temp = (HashMap) urunListe1;
            String id = temp.get("id");
            String urunAdi = temp.get("urun_adi");

            buttons[i] = new JButton(urunAdi);
            buttons[i].setPreferredSize(buttonDimension);
            panelUrun.add(buttons[i]);

            buttons[i].setActionCommand(urunAdi);
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String choice = e.getActionCommand();
                    //Urun(Integer.valueOf(choice));
                    list.add(choice);
                    fiyatlar.add(temp.get(choice));
                    listeParcala(list);
                    listele(myList, numberOfMyList);
                }
            });
            i++;
        }
        pack();
    }

    private void listeParcala(ArrayList<String> list) {
        int sayac = 0;
        myList = new ArrayList<>();
        numberOfMyList = new ArrayList<>();
        fiyatHesabi = new ArrayList<>();
        for (int j = 0; j < list.size(); j++) {
            if (!myList.contains(list.get(j))) {
                myList.add(list.get(j));
                fiyatHesabi.add(fiyatlar.get(j));
            }
        }
        int asd = 0;
        for (String string : fiyatHesabi) {
            System.out.println((asd++) + string);
        }

        for (int j = 0; j < myList.size(); j++) {
            sayac = 0;
            for (int k = 0; k < list.size(); k++) {
                if (myList.get(j).equals(list.get(k))) {
                    sayac++;
                }
            }
            numberOfMyList.add(sayac + "");
        }
    }

    private void listele(ArrayList<String> myList, ArrayList<String> numberOfMyList) {
        int i = 0;
        panelSepet.removeAll();
        panelSepet.repaint();

        fields = null;
        t = null;
        task = null;
        kacTane = null;
        carpiButonu = null;
        sureler = null;
        apsis = 10;
        ordinat = 10;

        for (int k = 0; k < myList.size(); k++) {
            fields = new JLabel[myList.size()];
            fields[k] = new JLabel(myList.get(k));
//            fields[i].setSize(genislik, yukseklik);
//            //fields[i].setLocation(apsis, ordinat);
//            fields[i].setOpaque(true);
//            fields[i].setBackground(Color.black);
//            fields[i].setForeground(Color.white);
            fields[k].setFont(new Font("Lucida Grande", Font.PLAIN, 13));
//              fields[i].setAlignmentX(CENTER_ALIGNMENT);
//              fields[i].setVerticalTextPosition((int) CENTER_ALIGNMENT);
//              fields[i].setVerticalTextPosition((int) Component.CENTER_ALIGNMENT);
//              fields[i].setHorizontalTextPosition((int) Component.CENTER_ALIGNMENT);

            kacTane = new JLabel[myList.size()];
            kacTane[k] = new JLabel(numberOfMyList.get(k));
//            kacTane[i].setSize(25, yukseklik);
//            kacTane[i].setLocation(apsis + genislik + 5, ordinat);
//            kacTane[i].setHorizontalTextPosition((int) Component.CENTER_ALIGNMENT);
            kacTane[k].setOpaque(true);
//            kacTane[i].setBackground(Color.cyan);
//            kacTane[i].setForeground(Color.white);
            //kacTane[i].setFont(new Font("Lucida Grande", Font.PLAIN, 18));
//            kacTane[i].setVerticalTextPosition((int) CENTER_ALIGNMENT);
//            kacTane[i].setVerticalTextPosition((int) Component.CENTER_ALIGNMENT);
//            kacTane[i].setHorizontalTextPosition((int) Component.CENTER_ALIGNMENT);

            carpiButonu = new JButton[myList.size()];
            Image img;
            ImageIcon icon = null;
            try {
                img = ImageIO.read(getClass().getResource("delete.png"));
                Image scaledImage = img.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
                icon = new ImageIcon(scaledImage);
            } catch (IOException ex) {
                System.out.println("hata " + ex);
            }

            carpiButonu[k] = new JButton(myList.get(k));

            //carpiButonu[i].setSize(50,50);
            //carpiButonu[i].setSize(30, yukseklik);
            //carpiButonu[i].setBorderPainted(false);
            //carpiButonu[i].setHorizontalTextPosition((int)CENTER_ALIGNMENT);
            carpiButonu[k].setText(kacTane[k].getText());
            carpiButonu[k].setFont(new Font("Lucida Grande", Font.BOLD, 15));
            //carpiButonu[i].setContentAreaFilled(false);
//              carpiButonu[i].setFocusPainted(false);
            carpiButonu[k].setOpaque(false);
            carpiButonu[k].setIcon(icon);
//            carpiButonu[i].setLocation(apsis + genislik + 35, ordinat);
            carpiButonu[k].setActionCommand(myList.get(k));
            carpiButonu[k].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int j = 0; j < 10; j++) {
                        if (myList.get(j).equals(e.getActionCommand())) {
                            int sayi = Integer.parseInt(numberOfMyList.get(j));
                            if (sayi > 1) {
                                sayi--;
                                numberOfMyList.remove(j);
                                numberOfMyList.add(j, sayi + "");
                                for (int a = 0; a < list.size(); a++) {
                                    if (list.get(a).equals(myList.get(j))) {
                                        list.remove(a);
                                        break;
                                    }
                                }
                                listele(myList, numberOfMyList);
                                break;
                            } else {

                                for (int a = 0; a < list.size(); a++) {
                                    if (list.get(a).equals(myList.get(j))) {
                                        list.remove(a);
                                        a--;
                                    }
                                }

                                numberOfMyList.remove(j);
                                myList.remove(j);
                                fiyatHesabi.remove(j);
                                listele(myList, numberOfMyList);
                                break;
                            }

                        }
                    }
                }

            });

            if (fields[i].getText().length() > 11) {
                fields[i].setText(fields[i].getText().substring(0, 10) + "..");
            }
            panelSepet.add(fields[i]);
            //panelSepet.add(kacTane[i]);
            panelSepet.add(carpiButonu[i]);
            i++;

        }
        pack();
    }

    private double fiyatGetir(ArrayList<String> fiyatHesabi) {
        double toplam = 0;
        int i = 0;
        for (String string : fiyatHesabi) {
            toplam += (Double.parseDouble(string) * Integer.parseInt(numberOfMyList.get(i)));
            i++;
        }
        return toplam;
    }

    private void Saat() {
        panelSaat.removeAll();

        panelSaat.repaint();

        ClockAnalogBuf c = new ClockAnalogBuf();

        //c.setSize(152, 152);
        c.setPreferredSize(new Dimension(200, 200));
        //c.setLocation(30, 10);
        c.setBackground(panelSaat.getBackground());
        panelSaat.add(c);
        //panelSaat.setBackground(Color.lightGray);
        //jScrollPane1.setBackground(Color.BLUE);
        //jScrollPane1.add(jPanel3);
        pack();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSepeteEkle;
    private javax.swing.JButton btnSepetiniz;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelBolum;
    private javax.swing.JPanel panelKategori;
    private javax.swing.JPanel panelSaat;
    private javax.swing.JPanel panelSatis;
    private javax.swing.JPanel panelSepet;
    private javax.swing.JPanel panelUrun;
    private javax.swing.JScrollPane scroolBolum;
    private javax.swing.JScrollPane scroolKategori;
    private javax.swing.JScrollPane scroolUrun;
    // End of variables declaration//GEN-END:variables
}
