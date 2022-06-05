package asciPanel;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

// 192.168.39.254


public class Asci {

    SimpleDateFormat format = new SimpleDateFormat("HH:mm");
    Date date = new Date();
    URL ikonURL = getClass().getResource("wait.gif");
    ImageIcon ikon = new ImageIcon(ikonURL);
    HucreBoyama boya = new HucreBoyama();
    DB db = new DB();
    public static String ascimiz = "";
    // hangi aşçının giriş yaptığını algılayıp, sorguya ekleyebilmek için static oluşturduk
    // login metodu içinde aşçı id sini değer olarak alıyor.
    // daha sonra siparisAl metodunda kullanıyor.

    protected boolean login(JTextField txtKulAdi, JPasswordField txtSifre, JLabel jl1, JLabel jl2) {
        // bu metod aşçının sisteme giriş işlemini yapıyor
        // parametre olarak textfield ve uyarı labellerini alıyor
        String kuladi = txtKulAdi.getText();
        String sifre = txtSifre.getText();

        boolean acKapa = false; // login ekranını geçtiğimizde kapanması için
        try {
            if (!db.baglan().isClosed()) {
                ResultSet rs = db.baglan().executeQuery("select *from asci where kul_adi = '" + kuladi + "' and sifre = '" + sifre + "'");
                if (rs.next()) {
                    // kullanıcı var olma durumunda
                    // son giriş tarihini tut

                    int giris = db.baglan().executeUpdate("INSERT INTO giris_tarihleri VALUE (null, '" + rs.getString("seviye") + "' , '" + rs.getString("id") + "' ,now())");
                    JOptionPane.showMessageDialog(null, "Hoşgeldin " + rs.getString("adi") + " " + rs.getString("soyadi"));

                    ascimiz = rs.getString("id");
                    AsciSiparis aSiparis = new AsciSiparis();
                    aSiparis.setVisible(true); // ikinci pencere açılıyor
                    acKapa = true;
                } else {
                    // kullanıcı yok ise...
                    JOptionPane.showMessageDialog(null, "Kullanıcı Adı veya Şifre hatalı!");
                    txtKulAdi.setText("");
                    txtSifre.setText("");
                    jl1.setText("");
                    jl2.setText("");
                    txtKulAdi.requestFocus();
                    acKapa = false;
                }
                rs.close();

            }
        } catch (Exception e) {
            System.err.println("Mysql Giriş Hatası" + e);
        } finally {
            try {
                db.con.close();
                db.st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Asci.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return acKapa;
    }

    protected void siparisAl(JTable tablo, int durum) {

        //  System.out.println(System.currentTimeMillis());
        DefaultTableModel dlis = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        dlis.addColumn("Sipariş");
        dlis.addColumn("Aşçı Adı");
        dlis.addColumn("Aşçı Soyadı");
        dlis.addColumn("Masa");
        dlis.addColumn("Ürün");
        dlis.addColumn("Saat");

        try {

            if (!db.baglan().isClosed()) {
                ResultSet rs = db.baglan().executeQuery(""
                        + "SELECT A.adi,A.soyadi,S.masa_id,S.tarih, U.urun_adi, S.id AS sipID "
                        + "FROM sepet S "
                        + "LEFT JOIN urunler U ON S.urun_id = U.id "
                        + "LEFT JOIN kategoriler K ON U.kategori_id = K.id "
                        + "LEFT JOIN bolum B ON K.bolum_id = B.id "
                        + "LEFT JOIN asci A ON B.id = A.bolum_id "
                        + "WHERE A.bolum_id = '" + ascimiz + "' AND S.durum=0 AND S.asciDurum='" + durum + "' ");

                while (rs.next()) {

                    dlis.addRow(new String[]{rs.getString("sipID"), rs.getString("adi"), rs.getString("soyadi"), rs.getString("masa_id"), rs.getString("urun_adi"), modifyDateLayout(rs.getString("tarih"))});

                }

                tablo.setModel(dlis);
                dlis.fireTableDataChanged();
                tabloRender(tablo);
                rs.close();
            }
        } catch (Exception e) {
            System.err.println("Sipariş Alma Hatası" + e);
        } finally {
            try {
                db.con.close();
                db.st.close();
            } catch (SQLException ex) {
                System.err.println("Bağlantı Kapatma Hatası! " + ex);
            }
        }

    }

    public String modifyDateLayout(String inputDate) throws ParseException {

        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(inputDate);
        return new SimpleDateFormat("HH:mm").format(date);
    }

    public void boslukKontrol(JTextField jt1, JTextField jt2, JLabel jl1, JLabel jl2) {

// bu metod boş bırakılmış textfield için uyarı vererek odaklanma sağlıyor
        if (jt1.getText().isEmpty()) {
            jt1.requestFocus();
            jl1.setText("Kullanıcı Adı giriniz!");
        } else {
            jl1.setText("");
        }
        if (jt2.getText().isEmpty()) {
            jt2.requestFocus();
            jl2.setText("Şifre giriniz!");
        } else {
            jl2.setText("");
        }
//bu koşul, ikisinin de boş bırakılması durumunda kullanıcı adına odaklanma sağlıyor
        if (jt1.getText().isEmpty() && jt2.getText().isEmpty()) {
            jt1.requestFocus();
        }
    }

    public void tabloRender(JTable tablo) {
           // tablo ile ilgili hücreler, sütunlar vs stilleri bu metod içine yazılabilir.
        tablo.getTableHeader().setReorderingAllowed(false); // sütunlar yer değiştiremez
        tablo.getTableHeader().setResizingAllowed(false);   // sütunlar yeniden boyutlandırılmaz
        tablo.getColumnModel().getColumn(2).setPreferredWidth(100); // sütun boyutu sabit
        tablo.getColumnModel().getColumn(3).setPreferredWidth(50);
        tablo.getColumnModel().getColumn(4).setPreferredWidth(120);
        tablo.getColumnModel().getColumn(4).setCellRenderer(boya);  // hücre boyama

    }
}
