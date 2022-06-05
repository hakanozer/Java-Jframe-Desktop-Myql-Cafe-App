package asci;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import yonetici.DB;
import yonetici.YoneticiEkrani;

public class asciYonetimi extends javax.swing.JFrame {

    yonetici.DB db = new DB();
    String secimID = "";

    ArrayList<String> alist ;

    public asciYonetimi() {
        initComponents();
        alist = new ArrayList<>();
        bilgiGetir();
    }

    public void bilgiGetir() {

        DefaultTableModel model = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }

        };

        model.addColumn("ID");
        model.addColumn("Bölüm ID");
        model.addColumn("Adı");
        model.addColumn("Soyadı");
        model.addColumn("Telefon");
        model.addColumn("Adres");
        model.addColumn("Kullanıcı Adı");
        model.addColumn("Şifre");
        model.addColumn("Tarih");
        model.addColumn("Seviye");

        try {

            ResultSet rs = db.baglan().executeQuery("select *from asci order by id asc");
            while (rs.next()) {
                model.addRow(new String[]{rs.getString("id"), rs.getString("bolum_id"), rs.getString("adi"), rs.getString("soyadi"), rs.getString("telefon"), rs.getString("adres"), rs.getString("kul_adi"), rs.getString("sifre"), rs.getString("tarih"), rs.getString("seviye")});
            }

            liste.setModel(model);

        } catch (Exception e) {
            System.err.println("Listeleme Hatası " + e);
        }

        liste.getColumnModel().getColumn(0).setMaxWidth(30);
        liste.getColumnModel().getColumn(1).setMaxWidth(60);
        liste.getColumnModel().getColumn(9).setMaxWidth(50);
        liste.getColumnModel().getColumn(0).setMinWidth(30);
        liste.getColumnModel().getColumn(1).setMinWidth(60);
        liste.getColumnModel().getColumn(9).setMinWidth(50);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtadi = new javax.swing.JTextField();
        txtsoyadi = new javax.swing.JTextField();
        txtadres = new javax.swing.JTextField();
        txtTelefon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtKulAdi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSifre = new javax.swing.JTextField();
        guncelleBtn = new javax.swing.JButton();
        ekleBtn = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        liste = new javax.swing.JTable();
        silBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aşçı Yönetimi");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aşçı Yönetimi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setText("Adı :");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setText("Soyadı :");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel3.setText("Adres :");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel4.setText("Telefon :");

        txtadi.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtadi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtadiKeyPressed(evt);
            }
        });

        txtsoyadi.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtsoyadi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsoyadiKeyPressed(evt);
            }
        });

        txtadres.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtadres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtadresKeyPressed(evt);
            }
        });

        txtTelefon.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtTelefon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel5.setText("Kullanıcı Adı :");

        txtKulAdi.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtKulAdi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKulAdiKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel6.setText("Şifre :");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel7.setText("Seviye :");

        txtSifre.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtSifre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSifreKeyPressed(evt);
            }
        });

        guncelleBtn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        guncelleBtn.setText("Güncelle");
        guncelleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guncelleBtnActionPerformed(evt);
            }
        });

        ekleBtn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ekleBtn.setText("Ekle");
        ekleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekleBtnActionPerformed(evt);
            }
        });
        ekleBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ekleBtnKeyPressed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1" }));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel8.setText("Bölüm :");

        jComboBox2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        liste.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        liste.setModel(new javax.swing.table.DefaultTableModel(
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
        liste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(liste);

        silBtn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        silBtn.setText("Sil");
        silBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtadres))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtadi, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtsoyadi))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefon)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtKulAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtSifre, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(guncelleBtn)
                                                .addGap(18, 18, 18)
                                                .addComponent(ekleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(silBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBox1, jComboBox2, txtKulAdi, txtSifre, txtTelefon, txtadi, txtadres, txtsoyadi});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ekleBtn, guncelleBtn, silBtn});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtKulAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtsoyadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtSifre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtadres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guncelleBtn)
                    .addComponent(ekleBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(silBtn)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtKulAdi, txtSifre, txtTelefon, txtadi, txtadres, txtsoyadi});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ekleBtn, guncelleBtn, silBtn});

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ekleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekleBtnActionPerformed

        try {

            String adi = txtadi.getText().trim();
            String soyadi = txtsoyadi.getText().trim();
            String telefon = txtTelefon.getText().trim();
            String adres = txtadres.getText().trim();
            String kul_adi = txtKulAdi.getText().trim();
            String sifre = txtSifre.getText().trim();
            int comboId = jComboBox2.getSelectedIndex();
            int bolumId = 0;

            int i = 0;
            for (String alist1 : alist) {
                if (i == comboId) {
                    bolumId = Integer.valueOf(alist1);
                    System.out.println("Bölüm id :" + bolumId);
                    break;
                }
                i++;

            }

            if (adi.equals("")) {
                JOptionPane.showMessageDialog(this, "Lütfen adini giriniz");
                txtadi.requestFocus();
            } else if (soyadi.equals("")) {
                JOptionPane.showMessageDialog(this, "Lütfen Soyadini Giriniz");
                txtsoyadi.requestFocus();
            } else if (telefon.equals("")) {
                JOptionPane.showMessageDialog(this, "Lütfen Telefon Bilgisini Giriniz");
                txtTelefon.requestFocus();
            } else if (adres.equals("")) {
                JOptionPane.showMessageDialog(this, "Lütfen Adres Giriniz");
                txtadres.requestFocus();
            } else if (kul_adi.equals("")) {
                JOptionPane.showMessageDialog(this, "Lütfen Kullanıcı Adı Giriniz");
                txtKulAdi.requestFocus();
            } else if (sifre.equals("")) {
                JOptionPane.showMessageDialog(this, "Lütfen Sifre Giriniz");
                txtSifre.requestFocus();
            } else {
                int durum = db.baglan().executeUpdate("insert into asci values(null,'" + bolumId + "','" + adi + "','" + soyadi + "','" + telefon + "','" + adres + "','" + kul_adi + "','" + sifre + "',now(),1)");

                if (durum > 0) {
                    System.out.println("Yazma İşlemi Başarılı.");
                    alist.removeAll(alist);
                    jComboBox2.removeAllItems();
                    
                    bolumGuncelleForArrayList();
                    txtadi.setText("");
                    txtsoyadi.setText("");
                    txtTelefon.setText("");
                    txtadres.setText("");
                    txtKulAdi.setText("");
                    txtSifre.setText("");

                    txtadi.requestFocus();
                }
            }

        } catch (SQLException e) {
            System.err.println("Yazma Hatası" + e);
        }

        bilgiGetir();
        secimID = "";

    }//GEN-LAST:event_ekleBtnActionPerformed

    private void listeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeMouseClicked

        secimID = "" + liste.getValueAt(liste.getSelectedRow(), 0);
        System.err.println(secimID);

        try {
            ResultSet rs = db.baglan().executeQuery("select *from asci where id = '" + secimID + "'");
            rs.next();
            txtadi.setText(rs.getString("adi"));
            txtsoyadi.setText(rs.getString("soyadi"));
            txtTelefon.setText(rs.getString("telefon"));
            txtadres.setText(rs.getString("adres"));
            txtKulAdi.setText(rs.getString("kul_adi"));
            txtSifre.setText(rs.getString("sifre"));

            int comboId  ;//jComboBox2.getSelectedIndex();
            String bolumID = (String) liste.getValueAt(liste.getSelectedRow(), 1);

            System.err.println("bolumID : " + bolumID);

            int i = 0;
            for (String alist1 : alist) {
                if (alist1.equals(bolumID)) {
                    comboId = i;

                    jComboBox2.setSelectedIndex(comboId);
                    break;
                }
                i++;

            }

        } catch (Exception e) {
            System.err.println("Liste Seçme Hatası " + e);
        }

    }//GEN-LAST:event_listeMouseClicked

    private void guncelleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guncelleBtnActionPerformed

        if (secimID.equals("")) {
            JOptionPane.showMessageDialog(this, "Lütfen Seçim Yapınız.");
        } else {

            String adi = txtadi.getText().trim();
            String soyadi = txtsoyadi.getText().trim();
            String telefon = txtTelefon.getText().trim();
            String adres = txtadres.getText().trim();
            String kul_adi = txtKulAdi.getText().trim();
            String sifre = txtSifre.getText().trim();

            int update_bolumID = jComboBox2.getSelectedIndex();
            int bolumId = 0;

            int i = 0;
            for (String alist1 : alist) {
                if (i == update_bolumID) {
                    bolumId = Integer.valueOf(alist1);
                    System.out.println("Bölüm id :" + bolumId);
                    break;
                }
                i++;

            }
            try {
                if (adi.equals("")) {
                    JOptionPane.showMessageDialog(this, "Lütfen Adini Giriniz");
                    txtadi.requestFocus();

                } else if (soyadi.equals("")) {
                    JOptionPane.showMessageDialog(this, "Lütfen Soyadini Giriniz");
                    txtsoyadi.requestFocus();

                } else if (telefon.equals("")) {
                    JOptionPane.showMessageDialog(this, "Lütfen Telefon Bilgisini Giriniz");
                    txtTelefon.requestFocus();

                } else if (adres.equals("")) {
                    JOptionPane.showMessageDialog(this, "Lütfen Adres Giriniz");
                    txtadres.requestFocus();

                } else if (kul_adi.equals("")) {
                    JOptionPane.showMessageDialog(this, "Lütfen Kullanıcı Adı Giriniz");
                    txtKulAdi.requestFocus();

                } else if (sifre.equals("")) {
                    JOptionPane.showMessageDialog(this, "Lütfen Sifre Giriniz");
                    txtSifre.requestFocus();

                } else {

                    int guncelle = db.baglan().executeUpdate("update asci set bolum_id = '" + bolumId + "',adi = '" + adi + "',soyadi = '" + soyadi + "',telefon = '" + telefon + "',adres = '" + adres + "',kul_adi = '" + kul_adi + "',sifre = '" + sifre + "' where id = '" + secimID + "' limit 1");
                    secimID = "";
                    if (guncelle > 0) {
                        System.out.println("Güncelleme Başarılı");
                        jComboBox2.removeAllItems();
                        bolumGuncelleForArrayList();
                        txtadi.setText("");
                        txtsoyadi.setText("");
                        txtTelefon.setText("");
                        txtadres.setText("");
                        txtKulAdi.setText("");
                        txtSifre.setText("");
                        txtadi.requestFocus();
                    }
                }
            } catch (SQLException ex) {
                System.err.println("Güncelleme Hatası " + ex);
            }

            bilgiGetir();

        }

    }//GEN-LAST:event_guncelleBtnActionPerformed
    public void bolumGuncelleForArrayList() {

        ResultSet rs2;
        try {
            alist.removeAll(alist);
            rs2 = db.baglan().executeQuery("SELECT id,bolum_adi FROM bolum WHERE id NOT IN(\n"
                    + "SELECT bolum_id FROM asci\n"
                    + ")");
            while (rs2.next()) {
                // comboya strıng gonder array lıste id gonder
                jComboBox2.addItem(rs2.getString("bolum_adi"));
                alist.add(rs2.getString("id"));

            }

            rs2.close();
            db.baglan().close();
        } catch (SQLException ex) {
            Logger.getLogger(asciYonetimi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void silBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silBtnActionPerformed

        if (secimID.equals("")) {
            JOptionPane.showMessageDialog(this, "Lütfen Seçim Yapınız ");
        } else {

            try {
                int onay = JOptionPane.showConfirmDialog(this, "Silmek İşlemini Onaylıyormusunuz?");
                if (onay == 0) {
                    int silDurum = db.baglan().executeUpdate("delete from asci where id = '" + secimID + "'");
                    System.out.println(silDurum);
                    if (silDurum > 0) {
                        
                        bilgiGetir();
                        JOptionPane.showMessageDialog(this, "Silme İşlemi Başarılı");
                        jComboBox2.removeAllItems();
                        bolumGuncelleForArrayList();
                        System.out.println("Silme İşlemi Başarılı ");
                    } else {
                        JOptionPane.showMessageDialog(this, "Silinmedi");
                    }
                }
            } catch (SQLException ex) {
                System.err.println("Silme Hatası");
            }

        }
        txtadi.setText("");
        txtsoyadi.setText("");
        txtTelefon.setText("");
        txtadres.setText("");
        txtKulAdi.setText("");
        txtSifre.setText("");

        txtadi.requestFocus();
        bilgiGetir();
        secimID = "";

    }//GEN-LAST:event_silBtnActionPerformed

    private void txtadiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtadiKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtsoyadi.requestFocus();
        }
    }//GEN-LAST:event_txtadiKeyPressed

    private void txtsoyadiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsoyadiKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtadres.requestFocus();
        }
    }//GEN-LAST:event_txtsoyadiKeyPressed

    private void txtadresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtadresKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtTelefon.requestFocus();
        }
    }//GEN-LAST:event_txtadresKeyPressed

    private void txtTelefonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtKulAdi.requestFocus();
        }
    }//GEN-LAST:event_txtTelefonKeyPressed

    private void txtKulAdiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKulAdiKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtSifre.requestFocus();
        }
    }//GEN-LAST:event_txtKulAdiKeyPressed

    private void txtSifreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSifreKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ekleBtn.requestFocus();
        }
    }//GEN-LAST:event_txtSifreKeyPressed

    private void ekleBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ekleBtnKeyPressed

        try {
            String adi = txtadi.getText().trim();
            String soyadi = txtsoyadi.getText().trim();
            String telefon = txtTelefon.getText().trim();
            String adres = txtadres.getText().trim();
            String kul_adi = txtKulAdi.getText().trim();
            String sifre = txtSifre.getText().trim();
            int comboId = jComboBox2.getSelectedIndex();
            int bolumId = 0;

            int i = 0;
            for (String alist1 : alist) {
                if (i == comboId) {
                    bolumId = Integer.valueOf(alist1);
                    System.out.println("Bölüm id :" + bolumId);
                    break;
                }
                i++;

            }
            if (adi.equals("")) {
                JOptionPane.showMessageDialog(this, "Lütfen adini giriniz");
                txtadi.requestFocus();
            } else if (soyadi.equals("")) {
                JOptionPane.showMessageDialog(this, "Lütfen Soyadini Giriniz");
                txtsoyadi.requestFocus();
            } else if (telefon.equals("")) {
                JOptionPane.showMessageDialog(this, "Lütfen Telefon Bilgisini Giriniz");
                txtTelefon.requestFocus();
            } else if (adres.equals("")) {
                JOptionPane.showMessageDialog(this, "Lütfen Adres Giriniz");
                txtadres.requestFocus();
            } else if (kul_adi.equals("")) {
                JOptionPane.showMessageDialog(this, "Lütfen Kullanıcı Adı Giriniz");
                txtKulAdi.requestFocus();
            } else if (sifre.equals("")) {
                JOptionPane.showMessageDialog(this, "Lütfen Sifre Giriniz");
                txtSifre.requestFocus();
            } else {
                int durum = db.baglan().executeUpdate("insert into asci values(null,'" + bolumId + "','" + adi + "','" + soyadi + "','" + telefon + "','" + adres + "','" + kul_adi + "','" + sifre + "',now(),1)");

                if (durum > 0) {
                    System.out.println("Yazma İşlemi Başarılı.");
                    alist.removeAll(alist);
                    jComboBox2.removeAllItems();
                        
                    bolumGuncelleForArrayList();
                    txtadi.setText("");
                    txtsoyadi.setText("");
                    txtTelefon.setText("");
                    txtadres.setText("");
                    txtKulAdi.setText("");
                    txtSifre.setText("");

                    txtadi.requestFocus();
                }
            }
        } catch (SQLException e) {
            System.err.println("Enter Yazma Hatası" + e);
        }

        bilgiGetir();
    }//GEN-LAST:event_ekleBtnKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        bolumGuncelleForArrayList();


    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        yonetici.YoneticiEkrani anaEkran = new YoneticiEkrani();
        anaEkran.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        
        txtadi.setText("");
        txtsoyadi.setText("");
        txtTelefon.setText("");
        txtadres.setText("");
        txtKulAdi.setText("");
        txtSifre.setText("");

        txtadi.requestFocus();
        
        
    }//GEN-LAST:event_jPanel1MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        yonetici.YoneticiEkrani anaEkran = new YoneticiEkrani();
        anaEkran.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(asciYonetimi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(asciYonetimi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(asciYonetimi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(asciYonetimi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new asciYonetimi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ekleBtn;
    private javax.swing.JButton guncelleBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable liste;
    private javax.swing.JButton silBtn;
    private javax.swing.JTextField txtKulAdi;
    private javax.swing.JTextField txtSifre;
    private javax.swing.JTextField txtTelefon;
    private javax.swing.JTextField txtadi;
    private javax.swing.JTextField txtadres;
    private javax.swing.JTextField txtsoyadi;
    // End of variables declaration//GEN-END:variables

}
