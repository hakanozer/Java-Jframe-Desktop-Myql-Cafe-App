package garson;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import yonetici.DB;
import yonetici.YoneticiEkrani;

public class garsonGuncelle extends javax.swing.JFrame {

    yonetici.DB db = new DB();
    garsonEkle garsonEkleNes = new garsonEkle();
    calisanGarsonlar anaGiris = new calisanGarsonlar();

    ArrayList<String> id_lerGuncelle = new ArrayList<String>();
    ArrayList<String> iseGirisTarihi = new ArrayList<String>();
    ArrayList<String> kulAdlari = new ArrayList<String>();

    int sayac1 = 0;
    int sayac2 = 0;

    int secilen = -1;

    DefaultTableModel model = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int i, int i1) {
            return false;
        }
    };

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

        tblBilgiler.setModel(model);
        tblBilgiler.getColumnModel().getColumn(0).setMaxWidth(40);
        tblBilgiler.getColumnModel().getColumn(0).setMinWidth(40);
    }

    public void bilgileriGetir() {

        ResultSet rs = null;
        int sayac = 1;

        try {
            rs = db.baglan().executeQuery("select * from garson order by adi asc");
            kulAdlari.clear();
            id_lerGuncelle.clear();
            iseGirisTarihi.clear();

            while (rs.next()) {
                String iseGiris = new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("tarih"));
                id_lerGuncelle.add(rs.getString("id"));
                kulAdlari.add(rs.getString("kul_adi"));
                iseGirisTarihi.add(iseGiris);

                model.addRow(new String[]{String.valueOf(sayac),
                    rs.getString("adi"),
                    rs.getString("soyadi"),
                    rs.getString("telefon"),
                    rs.getString("adres"),
                    rs.getString("kul_adi"),
                    rs.getString("sifre")
                });
                sayac++;
            }
        } catch (Exception e) {
            System.err.println("Listeleme Hatası : " + e);
        }
    }

    public boolean txtKontrol() {
        boolean alanDurum = false;

        if (garsonEkleNes.boslukVarmi(txtAdi.getText().trim())) {
            JOptionPane.showMessageDialog(this, "ADI ALANI BOŞ OLAMAZ!");
            alanDurum = false;
            txtAdi.setText("");
            txtAdi.requestFocus();
        } else if (garsonEkleNes.boslukVarmi(txtSoyadi.getText().trim())) {
            JOptionPane.showMessageDialog(this, "SOYADI ALANI BOŞ OLAMAZ!");
            alanDurum = false;
            txtSoyadi.setText("");
            txtSoyadi.requestFocus();
        } else if (garsonEkleNes.boslukVarmi(txtTelefon.getText().trim())) {
            JOptionPane.showMessageDialog(this, "TELEFON BİLGİSİ BOŞ OLAMAZ!");
            alanDurum = false;
            txtTelefon.setText("0");
            txtTelefon.requestFocus();
        } else if (txtTelefon.getText().trim().equals("0")) {
            JOptionPane.showMessageDialog(this, "TELEFON BİLGİSİ BOŞ OLAMAZ!");
            alanDurum = false;
            txtTelefon.requestFocus();
        } else if (garsonEkleNes.harfVarmi(txtTelefon.getText())) {
            JOptionPane.showMessageDialog(this, "TELEFON BİLGİSİ HATALI GİRİLMİŞ. TEKRAR KONTROL EDİNİZ!");
            alanDurum = false;
            txtTelefon.requestFocus();
        } else if (garsonEkleNes.boslukVarmi(txtAdres.getText().trim())) {
            JOptionPane.showMessageDialog(this, "ADRES BİLGİSİ BOŞ OLAMAZ!");
            alanDurum = false;
            txtAdres.setText("");
            txtAdres.requestFocus();
        } else if (garsonEkleNes.boslukVarmi(txtKullanici.getText().trim())) {
            JOptionPane.showMessageDialog(this, "KULLANICI ADI BİLGİSİ BOŞ OLAMAZ!");
            alanDurum = false;
            txtKullanici.requestFocus();
        } else if (garsonEkleNes.boslukVarmi(txtSifre.getText().trim())) {
            JOptionPane.showMessageDialog(this, "ŞİFRE ALANI BOŞ OLAMAZ!");
            alanDurum = false;
            txtSifre.requestFocus();
        } else {
            alanDurum = true;
        }
        return alanDurum;
    }

    public void garsonGuncelle(String adi, String soyAdi, String telefon, String adres, String kullaniciAdi, String sifre) {
        try {

            int durum = db.baglan().executeUpdate("update garson set adi ='" + adi + "', soyadi ='" + soyAdi + "', telefon = '" + telefon + "', "
                    + "adres ='" + adres + "', kul_adi ='" + kullaniciAdi + "', sifre ='" + sifre + "' where id =" + id_lerGuncelle.get(secilen));
            if (durum > 0) {
                JOptionPane.showMessageDialog(null, adi.toUpperCase() + " " + soyAdi.toUpperCase() + " ADLI PERSONEL BİLGİLERİ BAŞARILI BİR ŞEKİLDE GÜNCELLENDİ.");

                tabloModelleme();
                bilgileriGetir();

            }
        } catch (Exception e) {
            System.err.println("GARSON GÜNCELLEME HATASI : " + e);
        }
    }

    public void alanTemizle() {

        txtAdi.setText("");
        txtSoyadi.setText("");
        txtTelefon.setText("");
        txtAdres.setText("");
        txtKullanici.setText("");
        txtSifre.setText("");
        txtAdi.requestFocus();
        tblBilgiler.setSelectionMode(0);
    }

    public garsonGuncelle() {
        initComponents();

        tabloModelleme();
        bilgileriGetir();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAdres = new javax.swing.JTextArea();
        txtKullanici = new javax.swing.JTextField();
        btnGuncelle = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtTarih = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBilgiler = new javax.swing.JTable();
        btnAnaEkran = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Garson Yönetimi -> Garson Güncelleme");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/ileri26.png"))); // NOI18N
        jButton1.setText("Garson Sil");
        jButton1.setIconTextGap(8);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/ileri26.png"))); // NOI18N
        jButton2.setText("Garson Ekle");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Garson Güncelleme", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

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

        txtAdres.setColumns(20);
        txtAdres.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtAdres.setLineWrap(true);
        txtAdres.setRows(5);
        txtAdres.setWrapStyleWord(true);
        txtAdres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAdresKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(txtAdres);

        txtKullanici.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        btnGuncelle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnGuncelle.setText("Güncelle");
        btnGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuncelleActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel8.setText("Giriş Tarihi :");

        txtTarih.setEditable(false);
        txtTarih.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuncelle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKullanici, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                    .addComponent(txtSifre)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(40, 40, 40)
                                .addComponent(txtTelefon))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAdi, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                    .addComponent(txtSoyadi))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addComponent(txtTarih))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtSoyadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtKullanici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSifre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtTarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(btnGuncelle)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Garson Listesi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11))); // NOI18N

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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblBilgilerMouseReleased(evt);
            }
        });
        tblBilgiler.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblBilgilerKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblBilgiler);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAnaEkran, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
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
        garsonEkle add = new garsonEkle();
        add.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        garsonSil delete = new garsonSil();
        delete.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblBilgilerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBilgilerMouseReleased

        secilen = tblBilgiler.getSelectedRow();

        txtAdi.setText((String) tblBilgiler.getValueAt(tblBilgiler.getSelectedRow(), 1));
        txtSoyadi.setText((String) tblBilgiler.getValueAt(tblBilgiler.getSelectedRow(), 2));
        txtTelefon.setText((String) tblBilgiler.getValueAt(tblBilgiler.getSelectedRow(), 3));
        txtAdres.setText((String) tblBilgiler.getValueAt(tblBilgiler.getSelectedRow(), 4));
        txtKullanici.setText((String) tblBilgiler.getValueAt(tblBilgiler.getSelectedRow(), 5));
        txtSifre.setText((String) tblBilgiler.getValueAt(tblBilgiler.getSelectedRow(), 6));
        txtTarih.setText(iseGirisTarihi.get(secilen));
    }//GEN-LAST:event_tblBilgilerMouseReleased

    private void tblBilgilerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblBilgilerKeyReleased

        secilen = tblBilgiler.getSelectedRow();
        txtAdi.setText((String) tblBilgiler.getValueAt(tblBilgiler.getSelectedRow(), 1));
        txtSoyadi.setText((String) tblBilgiler.getValueAt(tblBilgiler.getSelectedRow(), 2));
        txtTelefon.setText((String) tblBilgiler.getValueAt(tblBilgiler.getSelectedRow(), 3));
        txtAdres.setText((String) tblBilgiler.getValueAt(tblBilgiler.getSelectedRow(), 4));
        txtKullanici.setText((String) tblBilgiler.getValueAt(tblBilgiler.getSelectedRow(), 5));
        txtSifre.setText((String) tblBilgiler.getValueAt(tblBilgiler.getSelectedRow(), 6));
        txtTarih.setText(iseGirisTarihi.get(secilen));

    }//GEN-LAST:event_tblBilgilerKeyReleased

    private void txtAdiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdiKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER || evt.getKeyCode() == evt.VK_TAB) {
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
            txtSifre.requestFocus();
        }

    }//GEN-LAST:event_txtTelefonKeyPressed

    private void txtSifreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSifreKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtAdres.requestFocus();
        }
    }//GEN-LAST:event_txtSifreKeyPressed

    private void txtAdresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdresKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER) {
            btnGuncelleActionPerformed(null);
        }
    }//GEN-LAST:event_txtAdresKeyPressed

    private void btnGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuncelleActionPerformed

        sayac1 = 0;
        sayac2 = 0;

        if (secilen == -1) {
            JOptionPane.showMessageDialog(this, "LÜTFEN TABLODAN BİLGİSİNİ GÜNCELLEMEK İSTEDİĞİNİZ PERSONELİ SEÇİNİZ");
        } else {
            String secileninKulAdi = kulAdlari.get(secilen);

            String ad = txtAdi.getText();
            String soyAdd = txtSoyadi.getText();
            String tel = txtTelefon.getText();
            String addrs = txtAdres.getText();
            String kullanicii = txtKullanici.getText();
            String siff = txtSifre.getText();

            if (txtKontrol()) {
                int onay = JOptionPane.showConfirmDialog(this, txtAdi.getText() + " " + txtSoyadi.getText() + " ADLI KULLANICININ BİLGİLERİ GÜNCELLENECEKTİR. ONAYLIYOR MUSUNUZ?");

                for (int i = 0; i < kulAdlari.size(); i++) {
                    // bu döngü içinde kişi seçtiği kişinin kul adı nı değiştirmeksizin işlem yaparsa sayac1 1 artar.
                    // kişi kendi kul adını değiştirirse sayac1 artmaz, yalnız değiştirdiği kul adı veri tabanındaki
                    //başka bir kul adı ile çakışırsa sayaç2 1 artar
                    // sayaç2 artmaz ise kuladı çakışmadan yeni kullanıcı adı tanımlana bilir (foru bitirdikten sonraki
//                    else if gövdesine uyar)
                    if (kulAdlari.get(i).equals(secileninKulAdi) && kulAdlari.get(i).equals(txtKullanici.getText())) {
                        sayac1++;

                        //sayaç 1 olduğunda seçilen personelin kullanıcı adı hariç diğer bilgileri güncellenmiş demektir.
                        // kullanıcı adına dakunulmamıştır.
                    } else if (kulAdlari.get(i).equals(txtKullanici.getText())) {
                        sayac2++;

                        //sayaç2 nin 1 olması demek, verilen kullanıcı adı veri tabanındaki bir başka id ye ait kullanıcı adı demektir.
                    }
                }
                System.out.println("for döngüsünden çıkınca sayaç1 : " + sayac1);
                System.out.println("for döngüsünden çıkınca sayaç2 : " + sayac2);
                // kişi işleme onay verdi (onay ==0) ve kendisi ile ilgili işlem yapıyor(sayac = 1 olur) ve kendi kul adını değiştirmedi
                if (onay == 0 && sayac1 < 2 && secileninKulAdi.equals(txtKullanici.getText())) {

                    garsonGuncelle(ad, soyAdd, tel, addrs, kullanicii, siff);

                    secilen = -1;
                    sayac1 = 0;
                    sayac2 = 0;
                    anaGiris.setVisible(true);
                    this.hide();
//                    kişi işleme onay verdi(onay ==0)ve kendi kullanıcı adını değiştirdi(sayac ==0 olur) ve veri tabanındaki diğer kullanıcı adları ile çakışmıyor
                } else if (onay == 0 && sayac1 < 1 && sayac2 < 1) {

                    garsonGuncelle(ad, soyAdd, tel, addrs, kullanicii, siff);

                    secilen = -1;
                    sayac1 = 0;
                    sayac2 = 0;
                    anaGiris.setVisible(true);
                    this.hide();

                } else if (onay == 1) {

                } else {
                    JOptionPane.showMessageDialog(this, "AYNI KULLANICI ADINDA BAŞKA BİR KULLANICI VAR. LÜTFEN KULLANICI ADINI DEĞİŞTİRİNİZ");
                    txtKullanici.requestFocus();
                }

            }

        }

    }//GEN-LAST:event_btnGuncelleActionPerformed

    private void btnAnaEkranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnaEkranActionPerformed
        yonetici.YoneticiEkrani anaEkran = new YoneticiEkrani();
        anaEkran.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAnaEkranActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
      alanTemizle();
      
    }//GEN-LAST:event_formMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      
        calisanGarsonlar calisanlar = new calisanGarsonlar();
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
            java.util.logging.Logger.getLogger(garsonGuncelle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(garsonGuncelle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(garsonGuncelle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(garsonGuncelle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new garsonGuncelle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnaEkran;
    private javax.swing.JButton btnGuncelle;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblBilgiler;
    private javax.swing.JTextField txtAdi;
    private javax.swing.JTextArea txtAdres;
    private javax.swing.JTextField txtKullanici;
    private javax.swing.JTextField txtSifre;
    private javax.swing.JTextField txtSoyadi;
    private javax.swing.JTextField txtTarih;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables
}
