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

        // SORU; Ogrenciler taplosundaki 9. sinif kiz ogrencilerin bilgilerini getir

        System.out.println("===========================================================");

        ResultSet veri2=st.executeQuery("select * from ogrenciler where cinsiyet='K' and sinif=9");

        while (veri2.next()){
            System.out.println(veri2.getInt("okul_no") + veri2.getString("ogrenci_ismi") +
                    veri2.getString("sinif") + veri2.getString("cinsiyet") );
        }

        con.close();
        st.close();
        veri.close();
        veri2.close();
    }
}
