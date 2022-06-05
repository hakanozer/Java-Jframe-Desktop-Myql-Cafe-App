/*
 Akın Çandır
 */
package urun;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import yonetici.DB;
import yonetici.YoneticiEkrani;

public class UrunEkrani extends javax.swing.JFrame {

    yonetici.DB db = new DB();
    String secimID = "";
    String kategoriID = "";

    public void urunGetir() {
        DefaultTableModel urunModel = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }

        };
        urunModel.addColumn("ID");
        urunModel.addColumn("Bölüm");
        urunModel.addColumn("Kategori");
        urunModel.addColumn("Ürün");
        urunModel.addColumn("Fiyat");
        urunModel.addColumn("Durum");
        urunModel.addColumn("Tarih");
        try {
            ResultSet rs = db.baglan().executeQuery("select *from urunler inner join kategoriler on kategoriler.id = urunler.kategori_id inner join bolum on kategoriler.bolum_id=bolum.id");
            while (rs.next()) {
                String urunDurum;
                switch (rs.getString("durum")) {
                    case "0":
                        urunDurum = "Var";
                        break;
                    case "1":
                        urunDurum = "Yok";
                        break;
                    default:
                        urunDurum = "Belirtilmemiş";
                        break;
                }
                urunModel.addRow(new String[]{rs.getString("urunler.id"), rs.getString("bolum_adi"), rs.getString("kategori_adi"), rs.getString("urun_adi"), rs.getString("fiyat"), urunDurum, rs.getString("tarih")});
            }
        } catch (SQLException ex) {
            System.err.println("Ürün Listeleme Hatası : " + ex);
        }

        tblUrunler.setModel(urunModel);
        tblUrunler.getColumnModel().getColumn(0).setMaxWidth(30);
        tblUrunler.getColumnModel().getColumn(4).setMaxWidth(50);
        tblUrunler.getColumnModel().getColumn(5).setMaxWidth(45);
        tblUrunler.getColumnModel().getColumn(6).setMinWidth(70);
        tblUrunler.getColumnModel().getColumn(6).setMaxWidth(70);
        temizle();
    }

    public void urunAra() {

        DefaultTableModel urunList = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }

        };
        urunList.addColumn("ID");
        urunList.addColumn("Bölüm");
        urunList.addColumn("Kategori");
        urunList.addColumn("Ürün");
        urunList.addColumn("Fiyat");
        urunList.addColumn("Durum");
        urunList.addColumn("Tarih");

        try {
            String ara = txtAra.getText().replace(" ", "*");
            ResultSet rs = db.baglan().executeQuery("call urunArama('*" + ara + "*')");
            while (rs.next()) {
                urunList.addRow(new String[]{rs.getString("urunler.id"), rs.getString("bolum_adi"), rs.getString("kategori_adi"), rs.getString("urun_adi"), rs.getString("fiyat"), rs.getString("durum"), rs.getString("tarih")});
            }
        } catch (SQLException ex) {
            System.err.println("Ürün Arama Hatası : " + ex);
        }

        tblUrunler.setModel(urunList);
        tblUrunler.getColumnModel().getColumn(0).setMaxWidth(30);
        tblUrunler.getColumnModel().getColumn(4).setMaxWidth(50);
        tblUrunler.getColumnModel().getColumn(5).setMaxWidth(45);
        tblUrunler.getColumnModel().getColumn(6).setMinWidth(70);
        tblUrunler.getColumnModel().getColumn(6).setMaxWidth(70);
        temizle();
    }

    public void bolumGetir() {
        cmbBolum.removeAllItems();
        cmbBolum.addItem("Seçiniz");
        try {
            ResultSet rs = db.baglan().executeQuery("select *from bolum");
            while (rs.next()) {
                cmbBolum.addItem(rs.getString("bolum_adi"));
            }
        } catch (SQLException ex) {
            System.err.println("Bölüm Getirme Hatası : " + ex);
        }
    }

    public void kategoriGetir() {
        cmbKategori.removeAllItems();
        cmbKategori.addItem("Seçiniz");
        try {
            ResultSet rs = db.baglan().executeQuery("select *from kategoriler inner join bolum on bolum.id = kategoriler.bolum_id where bolum_adi='" + cmbBolum.getSelectedItem() + "'");
            while (rs.next()) {
                cmbKategori.addItem(rs.getString("kategori_adi"));

            }
        } catch (SQLException ex) {
            System.err.println("Kategori Getirme Hatası : " + ex);
        }
    }

    public void secimGetir() {
        secimID = "" + tblUrunler.getValueAt(tblUrunler.getSelectedRow(), 0);

        try {
            ResultSet rs = db.baglan().executeQuery("select *from urunler inner join kategoriler on kategoriler.id = urunler.kategori_id inner join bolum on kategoriler.bolum_id=bolum.id where urunler.id='" + secimID + "'");
            rs.next();
            cmbBolum.setSelectedItem(rs.getString("bolum_adi"));
            cmbKategori.setSelectedItem(rs.getString("kategori_adi"));
            txtAd.setText(rs.getString("urun_adi"));
            txtFiyat.setText(rs.getString("fiyat"));
            txtKisaAciklama.setText(rs.getString("urun_kisa_aciklama"));
            txtAciklama.setText(rs.getString("urun_aciklamasi"));
            txtResim.setText(rs.getString("urun_resim"));
            if (txtResim.getText().equals("")) {
                ImageIcon resim = new ImageIcon("images/varsayilan.png");
                Image img = resim.getImage().getScaledInstance(252, 162, java.awt.Image.SCALE_SMOOTH);
                resim = new ImageIcon(img);
                lblResim.setIcon(resim);
            } else {
                ImageIcon resim = new ImageIcon(txtResim.getText());
                Image img = resim.getImage().getScaledInstance(252, 162, java.awt.Image.SCALE_SMOOTH);
                resim = new ImageIcon(img);
                lblResim.setIcon(resim);
            }

            switch (rs.getString("durum")) {
                case "0":
                    rdoVar.setSelected(true);
                    break;
                case "1":
                    rdoYok.setSelected(true);
                    break;
            }
            kategoriID = rs.getString("kategoriler.id");
        } catch (SQLException ex) {
            System.err.println("Seçim Hatası : " + ex);
        }
    }

    public void urunEkle() {
        if (kontrol()) {
            String urunAd = txtAd.getText();
            double urunFiyat = Double.valueOf(txtFiyat.getText());
            String urunKisaAciklama = txtKisaAciklama.getText();
            String urunAciklama = txtAciklama.getText();
            String urunResim = txtResim.getText();
            int urunDurum = 0;
            if (rdoVar.isSelected()) {
                urunDurum = 0;
            } else if (rdoYok.isSelected()) {
                urunDurum = 1;
            }

            try {
                int drm = db.baglan().executeUpdate("insert into urunler values(null,'" + kategoriID + "','" + urunAd + "','" + urunKisaAciklama + "','" + urunAciklama + "'," + urunFiyat + ",'" + urunResim + "'," + urunDurum + ", now())");
                if (drm > 0) {
                    JOptionPane.showMessageDialog(this, txtAd.getText() + " Eklendi");
                }
            } catch (SQLException ex) {
                System.err.println("Ürün Ekleme Hatası : " + ex);
            }
            urunGetir();
        }
    }

    public void urunGuncelle() {
        if (secimID.equals("")) {
            JOptionPane.showMessageDialog(this, "Lütfen Seçim Yapınız");
        } else if (kontrol()) {
            String urunAd = txtAd.getText();
            double urunFiyat = Double.valueOf(txtFiyat.getText());
            String urunKisaAciklama = txtKisaAciklama.getText();
            String urunAciklama = txtAciklama.getText();
            String urunResim = txtResim.getText();
            int urunDurum = 0;
            if (rdoVar.isSelected()) {
                urunDurum = 0;
            } else if (rdoYok.isSelected()) {
                urunDurum = 1;
            }

            try {
                int drm = db.baglan().executeUpdate("update urunler set kategori_id=" + kategoriID + ", urun_adi='" + urunAd + "', urun_kisa_aciklama='" + urunKisaAciklama + "', urun_aciklamasi='" + urunAciklama + "', fiyat='" + urunFiyat + "', urun_resim='" + urunResim + "', durum=" + urunDurum + ", tarih=now() where id = '" + secimID + "'");
                if (drm > 0) {
                    JOptionPane.showMessageDialog(this, txtAd.getText() + " Güncellendi");
                }
            } catch (SQLException ex) {
                System.err.println("Ürün Güncelleme Hatası : " + ex);
            }
            urunGetir();
        }
    }

    public void urunSil() {
        if (secimID.equals("")) {
            JOptionPane.showMessageDialog(this, "Lütfen Seçim Yapınız");
        } else {
            try {
                int onay = JOptionPane.showConfirmDialog(this, txtAd.getText() + " silinecek! Emin misiniz?");
                if (onay == 0) {
                    int silDurum = db.baglan().executeUpdate("delete from urunler where id = '" + secimID + "'");
//                    if (silDurum > 0) {
//                        JOptionPane.showMessageDialog(this, txtAd.getText() + " Silindi");
//                    }
                }
            } catch (SQLException ex) {
                System.err.println("Ürün Silme Hatası : " + ex);
            }
            urunGetir();
        }
    }

    public void kategoriSecim() {

        try {
            ResultSet rs = db.baglan().executeQuery("select *from kategoriler where kategori_adi='" + cmbKategori.getSelectedItem() + "'");
            rs.next();
            kategoriID = String.valueOf(rs.getString("id"));
        } catch (SQLException ex) {
        }

    }

    public void temizle() {
        secimID = "";
        tblUrunler.setSelectionMode(0);
        cmbBolum.setSelectedIndex(0);
        txtAd.setText("");
        txtFiyat.setText("");
        txtAciklama.setText("");
        txtKisaAciklama.setText("");
        rdoVar.setSelected(true);
        txtResim.setText("");
        ImageIcon resim = new ImageIcon("images/varsayilan.png");
        Image img = resim.getImage().getScaledInstance(252, 162, java.awt.Image.SCALE_SMOOTH);
        resim = new ImageIcon(img);
        lblResim.setIcon(resim);
    }

    public void gozAt() {
        JFileChooser jfc = new JFileChooser();
        int kullaniciSecimi = jfc.showOpenDialog(null);
        if (kullaniciSecimi == JFileChooser.APPROVE_OPTION) {
            String resimYolu = String.valueOf(jfc.getSelectedFile()).replace("\\", "/");
            txtResim.setText(resimYolu);
            ImageIcon resim = new ImageIcon(txtResim.getText());
            Image img = resim.getImage().getScaledInstance(252, 162, java.awt.Image.SCALE_SMOOTH);
            resim = new ImageIcon(img);
            lblResim.setIcon(resim);
        }
    }

    public boolean kontrol() {
        boolean durum = true;
        if (cmbBolum.getSelectedItem().equals("Seçiniz")) {
            durum = false;
            JOptionPane.showMessageDialog(this, "Bölüm Seçiniz");
        } else if (cmbKategori.getSelectedItem().equals("Seçiniz")) {
            durum = false;
            JOptionPane.showMessageDialog(this, "Kategori Seçiniz");
        } else if (txtAd.getText().trim().equals("")) {
            txtAd.setText("");
            durum = false;
            JOptionPane.showMessageDialog(this, "Ürün Adını Giriniz");
        } else if (txtFiyat.getText().trim().equals("")) {
            txtFiyat.setText("");
            durum = false;
            JOptionPane.showMessageDialog(this, "Ürün Fiyatını Giriniz");
        } else if (!harfKontrol()) {
            durum = false;
            JOptionPane.showMessageDialog(this, "Ürün Fiyatını Hatalı Girdiniz");
        }
        return durum;
    }

    public boolean harfKontrol() {
        boolean durum = true;
        for (int i = 0; i < txtFiyat.getText().length(); i++) {
            if (Character.isLetter(txtFiyat.getText().charAt(i))) {
                durum = false;
                break;
            }
        }
        return durum;
    }

    public UrunEkrani() {
        initComponents();
        bolumGetir();
        urunGetir();
        txtAra.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        cmbBolum = new javax.swing.JComboBox();
        cmbKategori = new javax.swing.JComboBox();
        txtAd = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFiyat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAciklama = new javax.swing.JTextArea();
        txtKisaAciklama = new javax.swing.JTextField();
        rdoVar = new javax.swing.JRadioButton();
        rdoYok = new javax.swing.JRadioButton();
        txtResim = new javax.swing.JTextField();
        btnGozat = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lblResim = new javax.swing.JLabel();
        btnGuncelle = new javax.swing.JButton();
        btnEkle = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUrunler = new javax.swing.JTable();
        txtAra = new javax.swing.JTextField();
        btnSil = new javax.swing.JButton();
        btnAnaEkran = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ürün Yönetimi");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ürün Yönetimi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11))); // NOI18N

        cmbBolum.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cmbBolum.setToolTipText("");
        cmbBolum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBolumActionPerformed(evt);
            }
        });

        cmbKategori.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cmbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKategoriActionPerformed(evt);
            }
        });

        txtAd.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtAd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAdKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setText("Ürün Bölümü :");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setText("Ürün Kategorisi :");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel3.setText("Ürün Adı :");

        txtFiyat.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtFiyat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFiyatKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel4.setText("Ürün Fiyatı :");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel5.setText("Açıklama :");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel6.setText("Kısa Açıklama :");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel7.setText("Ürün Durumu :");

        txtAciklama.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtAciklama.setLineWrap(true);
        txtAciklama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAciklamaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtAciklama);

        txtKisaAciklama.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        buttonGroup1.add(rdoVar);
        rdoVar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        rdoVar.setSelected(true);
        rdoVar.setText("Var");

        buttonGroup1.add(rdoYok);
        rdoYok.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        rdoYok.setText("Yok");

        txtResim.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtResim.setMaximumSize(new java.awt.Dimension(87, 2147483647));

        btnGozat.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnGozat.setText("Gözat");
        btnGozat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGozatActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel8.setText("Ürün Resmi :");

        lblResim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/urun/varsayilan.png"))); // NOI18N
        lblResim.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        lblResim.setMaximumSize(new java.awt.Dimension(252, 154));
        lblResim.setMinimumSize(new java.awt.Dimension(252, 154));
        lblResim.setPreferredSize(new java.awt.Dimension(252, 154));
        lblResim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblResimMouseClicked(evt);
            }
        });

        btnGuncelle.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnGuncelle.setText("Güncelle");
        btnGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuncelleActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblResim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbBolum, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFiyat, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKisaAciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtResim, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnGozat))))
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(rdoVar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdoYok, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuncelle)
                        .addGap(18, 18, 18)
                        .addComponent(btnEkle)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEkle, btnGuncelle});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbBolum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFiyat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(39, 39, 39))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtKisaAciklama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoVar)
                    .addComponent(rdoYok)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtResim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGozat)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblResim, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuncelle)
                    .addComponent(btnEkle))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ürün Arama", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11))); // NOI18N

        tblUrunler.setAutoCreateRowSorter(true);
        tblUrunler.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tblUrunler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        tblUrunler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUrunlerMouseClicked(evt);
            }
        });
        tblUrunler.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblUrunlerKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblUrunler);

        txtAra.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtAra.setToolTipText("");
        txtAra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAraKeyReleased(evt);
            }
        });

        btnSil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSil.setText("Sil");
        btnSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAra)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSil)
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnaEkran, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAnaEkran, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbBolumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBolumActionPerformed
        kategoriGetir();
    }//GEN-LAST:event_cmbBolumActionPerformed

    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed
        urunEkle();
    }//GEN-LAST:event_btnEkleActionPerformed

    private void cmbKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKategoriActionPerformed
        kategoriSecim();
    }//GEN-LAST:event_cmbKategoriActionPerformed

    private void btnGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuncelleActionPerformed
        urunGuncelle();
    }//GEN-LAST:event_btnGuncelleActionPerformed

    private void tblUrunlerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUrunlerMouseClicked
        secimGetir();
    }//GEN-LAST:event_tblUrunlerMouseClicked

    private void tblUrunlerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblUrunlerKeyReleased
        secimGetir();
    }//GEN-LAST:event_tblUrunlerKeyReleased

    private void txtAraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAraKeyReleased
        if (txtAra.getText().equals("")) {
            urunGetir();
        } else {
            urunAra();
        }
    }//GEN-LAST:event_txtAraKeyReleased

    private void btnGozatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGozatActionPerformed
        gozAt();
    }//GEN-LAST:event_btnGozatActionPerformed

    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
        urunSil();
    }//GEN-LAST:event_btnSilActionPerformed

    private void btnAnaEkranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnaEkranActionPerformed
        yonetici.YoneticiEkrani anaEkran = new YoneticiEkrani();
        anaEkran.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAnaEkranActionPerformed

    private void txtAdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtFiyat.requestFocus();
        }
    }//GEN-LAST:event_txtAdKeyPressed

    private void txtFiyatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiyatKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtAciklama.requestFocus();
        }
    }//GEN-LAST:event_txtFiyatKeyPressed

    private void txtAciklamaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAciklamaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtKisaAciklama.requestFocus();
        }
    }//GEN-LAST:event_txtAciklamaKeyPressed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        temizle();
    }//GEN-LAST:event_formMouseClicked

    private void lblResimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResimMouseClicked
        gozAt();
    }//GEN-LAST:event_lblResimMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UrunEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UrunEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UrunEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UrunEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UrunEkrani().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnaEkran;
    private javax.swing.JButton btnEkle;
    private javax.swing.JButton btnGozat;
    private javax.swing.JButton btnGuncelle;
    private javax.swing.JButton btnSil;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbBolum;
    private javax.swing.JComboBox cmbKategori;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblResim;
    private javax.swing.JRadioButton rdoVar;
    private javax.swing.JRadioButton rdoYok;
    private javax.swing.JTable tblUrunler;
    private javax.swing.JTextArea txtAciklama;
    private javax.swing.JTextField txtAd;
    private javax.swing.JTextField txtAra;
    private javax.swing.JTextField txtFiyat;
    private javax.swing.JTextField txtKisaAciklama;
    private javax.swing.JTextField txtResim;
    // End of variables declaration//GEN-END:variables
}
