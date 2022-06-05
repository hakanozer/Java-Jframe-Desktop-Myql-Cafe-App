package yonetici;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {

    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/cafe";
    String user = "root";
    String pass = "";

    Connection con = null;
    Statement st = null;

    public Statement baglan() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            st = con.createStatement();
            System.out.println("Bağlantı Başarılı");
        } catch (Exception e) {
            System.err.println("Bağlantı Hatası : " + e);
        }
        return st;
    }

}
