package asciPanel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {

    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/cafe";
    String user = "root";
    String pass = "";

    public Connection con = null;
    public Statement st = null;

    public Statement baglan() {

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            st = con.createStatement();
        } catch (Exception e) {
            System.err.println("Bağlantı Hatası : " + e);
        }
        return st;
    }
}
