package rapor;

import java.io.*;
import com.lowagie.text.pdf.*;
import com.lowagie.text.*;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import yonetici.DB;
import yonetici.YoneticiEkrani;

public class RaporEkrani extends javax.swing.JFrame {

    String secimID = "-1";
    String bolumID = null;
    String kategoriID = null;
    String urunID = null;
    String garsonID = null;
    String asciID = null;
    int sayi = 0;
    yonetici.DB db = new DB();
    String sorgu = "";

    public void bolumGetir() {
        cmbBolum.removeAllItems();
        cmbBolum.addItem("Hepsi");
        try {
            ResultSet rs = db.baglan().executeQuery("select *from bolum");
            while (rs.next()) {
                cmbBolum.addItem(rs.getString("bolum_adi"));
            }
            db.baglan().close();
        } catch (SQLException ex) {
            System.err.println("Bölüm Getirme Hatası : " + ex);
        }

    }

    public void bolumSecim() {

        try {
            ResultSet rs = db.baglan().executeQuery("select *from bolum where bolum_adi='" + cmbBolum.getSelectedItem() + "'");
            rs.next();
            bolumID = String.valueOf(rs.getString("id"));
            System.out.println(bolumID);
            db.baglan().close();
        } catch (SQLException ex) {
            System.err.println("Bölüm Seçim Hatası : " + ex);
        }

    }

    public void kategoriGetir() {
        cmbKategori.removeAllItems();
        cmbKategori.addItem("Hepsi");
        try {
            ResultSet rs = db.baglan().executeQuery("select *from kategoriler where bolum_id='" + bolumID + "'");
            while (rs.next()) {
                cmbKategori.addItem(rs.getString("kategori_adi"));

            }
            db.baglan().close();
        } catch (SQLException ex) {
            System.err.println("Kategori Getirme Hatası : " + ex);
        }
    }

    public void kategoriSecim() {

        try {
            ResultSet rs = db.baglan().executeQuery("select *from kategoriler where kategori_adi='" + cmbKategori.getSelectedItem() + "'");
            rs.next();
            kategoriID = String.valueOf(rs.getString("id"));
            System.out.println(kategoriID);
            db.baglan().close();
        } catch (SQLException ex) {
            System.err.println("Kategori Seçim Hatası : " + ex);
        }

    }

    public void urunGetir() {
        cmbUrun.removeAllItems();
        cmbUrun.addItem("Hepsi");
        try {
            ResultSet rs = db.baglan().executeQuery("select *from urunler where kategori_id='" + kategoriID + "'");
            while (rs.next()) {
                cmbUrun.addItem(rs.getString("urun_adi"));
            }
            db.baglan().close();
        } catch (SQLException ex) {
            System.err.println("Ürün Getirme Hatası : " + ex);
        }
    }

    public void urunSecim() {

        try {
            ResultSet rs = db.baglan().executeQuery("select *from urunler where urun_adi='" + cmbUrun.getSelectedItem() + "'");
            rs.next();
            urunID = String.valueOf(rs.getString("id"));
            System.out.println(urunID);
            db.baglan().close();
        } catch (SQLException ex) {
            System.err.println("Ürün Seçim Hatası : " + ex);
        }

    }

    public void garsonGetir() {
        cmbGarson.removeAllItems();
        cmbGarson.addItem("Hepsi");
        try {
            ResultSet rs = db.baglan().executeQuery("select *from garson");
            while (rs.next()) {
                cmbGarson.addItem(rs.getString("adi"));
            }
            db.baglan().close();
        } catch (SQLException ex) {
            System.err.println("Garson Getirme Hatası : " + ex);
        }
    }

    public void garsonSecim() {
        try {
            ResultSet rs = db.baglan().executeQuery("select *from garson where adi='" + cmbGarson.getSelectedItem() + "'");
            rs.next();
            garsonID = String.valueOf(rs.getString("id"));
            System.out.println(garsonID);
            db.baglan().close();
        } catch (SQLException ex) {
            System.err.println("Garson Seçim Hatası : " + ex);
        }
    }

    public void asciGetir() {
        cmbAsci.removeAllItems();
        cmbAsci.addItem("Hepsi");
        try {
            ResultSet rs = db.baglan().executeQuery("select *from asci");
            while (rs.next()) {
                cmbAsci.addItem(rs.getString("adi"));
            }
            db.baglan().close();
        } catch (SQLException ex) {
            System.err.println("Aşçı Getirme Hatası : " + ex);
        }
    }

    public void asciSecim() {
        try {
            ResultSet rs = db.baglan().executeQuery("select *from asci where adi='" + cmbAsci.getSelectedItem() + "'");
            rs.next();
            asciID = String.valueOf(rs.getString("id"));
            System.out.println(asciID);
            db.baglan().close();
        } catch (SQLException ex) {
            System.err.println("Aşçı Seçim Hatası : " + ex);
        }
    }

    public void bilgiGetir() {
        sayi = 0;
        String basTarih = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dcBaslangic.getDate().getTime());
        String bitTarih = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dcBitis.getDate().getTime());
        if (dcBaslangic.getDate().equals("")) {
            basTarih = null;
        }
        if (dcBitis.getDate().equals("")) {
            bitTarih = null;
        }
        if (cmbBolum.getSelectedItem().equals("Hepsi")) {
            bolumID = null;
        }
        if (cmbKategori.getSelectedItem().equals("Hepsi")) {
            kategoriID = null;
        }
        if (cmbUrun.getSelectedItem().equals("Hepsi")) {
            urunID = null;
        }
        if (cmbGarson.getSelectedItem().equals("Hepsi")) {
            garsonID = null;
        }
        if (cmbAsci.getSelectedItem().equals("Hepsi")) {
            asciID = null;
        }
        sorgu = "SELECT b.bolum_adi, k.kategori_adi, u.urun_adi, s.urun_fiyat, a.kul_adi, g.kul_adi, sts.tarih   FROM sepet s LEFT JOIN urunler u ON s.urun_id = u.id\n"
                + "LEFT JOIN kategoriler k ON k.id= u.kategori_id\n"
                + "LEFT JOIN bolum b ON b.id=k.bolum_id\n"
                + "LEFT JOIN asci a ON a.bolum_id= b.id\n"
                + "LEFT JOIN satis sts ON s.ref_kodu=sts.ref_kodu\n"
                + "LEFT JOIN garson g ON g.id = sts.garson_id\n"
                + "WHERE sts.tarih BETWEEN '" + basTarih + "' AND '" + bitTarih + "'\n"
                + "AND s.durum = 0\n"
                + "AND (b.id = " + bolumID + " or " + bolumID + " is NULL)\n"
                + "AND (k.id = " + kategoriID + " or " + kategoriID + " is NULL)\n"
                + "AND (u.id = " + urunID + " or " + urunID + " is NULL)\n"
                + "AND (a.id = " + asciID + " or " + asciID + " is NULL)\n"
                + "AND (g.id = " + garsonID + " or " + garsonID + " is NULL)";
        DefaultTableModel model = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }

        };
        model.addColumn("Bölüm Adı");
        model.addColumn("Kategori Adı");
        model.addColumn("Ürün Adı");
        model.addColumn("Ürün Fiyatı");
        model.addColumn("Aşçı");
        model.addColumn("Garson");
        model.addColumn("Satış Tarihi");

        double toplamCiro = 0;

        try {
            ResultSet rs = db.baglan().executeQuery(sorgu);
            while (rs.next()) {
                model.addRow(new String[]{rs.getString("b.bolum_adi"), rs.getString("k.kategori_adi"), rs.getString("u.urun_adi"), rs.getString("s.urun_fiyat"), rs.getString("a.kul_adi"), rs.getString("g.kul_adi"), String.valueOf(rs.getDate("sts.tarih"))});
                toplamCiro = toplamCiro + Double.valueOf(rs.getString("s.urun_fiyat"));
            }
            db.baglan().close();
        } catch (SQLException ex) {
            System.err.println("Seçim Hatası : " + ex);
        }
        sayi = model.getRowCount();
        lblAdet.setText(String.valueOf(sayi));
        tblRapor.setModel(model);
        lblTutar.setText(String.valueOf(toplamCiro) + " TL");
    }

    public void pdfOlustur() {
        Document document = new Document(PageSize.A4.rotate());
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("raporlar/Rapor.pdf"));

            document.open();
            PdfContentByte cb = writer.getDirectContent();

            cb.saveState();
            Graphics2D g2 = cb.createGraphicsShapes(500, 500);

            Shape oldClip = g2.getClip();
            g2.clipRect(0, 0, 1000, 1000);

            tblRapor.print(g2);
            g2.setClip(oldClip);

            g2.dispose();
            cb.restoreState();
        } catch (Exception e) {
            System.err.println("PDF Oluşturma Hatası : " + e.getMessage());
        }
        document.close();
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("raporlar/Rapor.pdf");
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                System.err.println("PDF Açma Hatası : " + ex);
            }
        }
    }

    public RaporEkrani() {
        initComponents();
        Date dt = new Date();
        dcBaslangic.setDate(dt);
        dcBitis.setDate(dt);
        bolumGetir();
        garsonGetir();
        asciGetir();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAnaEkran = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRapor = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbBolum = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbKategori = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbUrun = new javax.swing.JComboBox();
        cmbGarson = new javax.swing.JComboBox();
        cmbAsci = new javax.swing.JComboBox();
        btnListele = new javax.swing.JButton();
        dcBaslangic = new com.toedter.calendar.JDateChooser();
        dcBitis = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblTutar = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblAdet = new javax.swing.JLabel();
        btnPdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rapor");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rapor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11))); // NOI18N

        tblRapor.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tblRapor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bölüm Adı", "Kategori Adı", "Ürün Adı", "Ürün Fiyatı", "Aşçı", "Garson", "Satış Tarihi"
            }
        ));
        jScrollPane1.setViewportView(tblRapor);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seçim", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setText("Başlangıç :");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setText("Bitiş :");

        cmbBolum.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cmbBolum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBolumActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel3.setText("Bölüm :");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel4.setText("Kategori :");

        cmbKategori.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cmbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKategoriActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel5.setText("Ürün :");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel6.setText("Garson :");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel7.setText("Aşçı :");

        cmbUrun.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cmbUrun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUrunActionPerformed(evt);
            }
        });

        cmbGarson.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cmbGarson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGarsonActionPerformed(evt);
            }
        });

        cmbAsci.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cmbAsci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAsciActionPerformed(evt);
            }
        });

        btnListele.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnListele.setText("Seçime Göre Listele");
        btnListele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListeleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(dcBaslangic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(dcBitis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(36, 36, 36)
                        .addComponent(cmbBolum, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnListele, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbAsci, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbGarson, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbUrun, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbKategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(dcBaslangic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(dcBitis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBolum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbUrun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbGarson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbAsci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnListele, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Satış Raporu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Toplam Tutar :");
        jLabel8.setOpaque(true);

        lblTutar.setBackground(new java.awt.Color(255, 255, 255));
        lblTutar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTutar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTutar.setText("0.0 TL");
        lblTutar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        lblTutar.setOpaque(true);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Toplam Adet :");

        lblAdet.setBackground(new java.awt.Color(255, 255, 255));
        lblAdet.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblAdet.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAdet.setText("0");
        lblAdet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        lblAdet.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAdet, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(lblTutar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdet, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTutar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnPdf.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simgeler/pdf26.png"))); // NOI18N
        btnPdf.setText("PDF Oluştur");
        btnPdf.setIconTextGap(8);
        btnPdf.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnaEkran, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAnaEkran, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnPdf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnaEkranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnaEkranActionPerformed
        yonetici.YoneticiEkrani anaEkran = new YoneticiEkrani();
        anaEkran.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAnaEkranActionPerformed

    private void btnListeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListeleActionPerformed
        bilgiGetir();
    }//GEN-LAST:event_btnListeleActionPerformed

    private void cmbBolumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBolumActionPerformed
        if (cmbBolum.getSelectedIndex() == 0) {
            cmbKategori.removeAllItems();
            cmbKategori.addItem("Hepsi");
        } else {
            bolumSecim();
            kategoriGetir();
        }

    }//GEN-LAST:event_cmbBolumActionPerformed

    private void cmbKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKategoriActionPerformed
        if (cmbKategori.getSelectedIndex() == 0) {
            cmbUrun.removeAllItems();
            cmbUrun.addItem("Hepsi");
        } else {
            kategoriSecim();
            urunGetir();
        }
    }//GEN-LAST:event_cmbKategoriActionPerformed

    private void cmbGarsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGarsonActionPerformed
        garsonSecim();
    }//GEN-LAST:event_cmbGarsonActionPerformed

    private void cmbAsciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAsciActionPerformed
        asciSecim();
    }//GEN-LAST:event_cmbAsciActionPerformed

    private void cmbUrunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUrunActionPerformed
        urunSecim();
    }//GEN-LAST:event_cmbUrunActionPerformed

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        pdfOlustur();
    }//GEN-LAST:event_btnPdfActionPerformed

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
            java.util.logging.Logger.getLogger(RaporEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RaporEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RaporEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RaporEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RaporEkrani().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnaEkran;
    private javax.swing.JButton btnListele;
    private javax.swing.JButton btnPdf;
    private javax.swing.JComboBox cmbAsci;
    private javax.swing.JComboBox cmbBolum;
    private javax.swing.JComboBox cmbGarson;
    private javax.swing.JComboBox cmbKategori;
    private javax.swing.JComboBox cmbUrun;
    private com.toedter.calendar.JDateChooser dcBaslangic;
    private com.toedter.calendar.JDateChooser dcBitis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdet;
    private javax.swing.JLabel lblTutar;
    private javax.swing.JTable tblRapor;
    // End of variables declaration//GEN-END:variables
}
