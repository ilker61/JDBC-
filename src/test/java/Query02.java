import java.sql.*;

public class Query02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimeZone=UTC","root","1234");

        Statement st = con.createStatement();

        /*

        SORU; ogernciler tablosundaki erkek ogrenci bilgileri getir

         */

        ResultSet veri = st.executeQuery("select * from ogrenciler where cinsiyet='E'");

        while (veri.next()){

            System.out.println(veri.getInt("okul_no") + veri.getString("ogrenci_ismi") +
                    veri.getString("sinif") + veri.getString("cinsiyet") );
        }

        con.close();
        st.close();
        veri.close();

    }
}
