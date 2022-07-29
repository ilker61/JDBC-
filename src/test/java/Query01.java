import java.sql.*;

public class Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1. adim ;  Driver yukleyecegiz

        Class.forName("com.mysql.jdbc.Driver");

        // 2. adim; Baglanti Olustur

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimeZone=UTC","root","1234");

        // okul ; baglanti yapacagimiz database ismi

        // 3. adim ; Statement: SQL kodlarimizi yazmak icun ber obje olusturucuz

        Statement st = con.createStatement();


        // 4. adim; ResultSet

        ResultSet veri = st.executeQuery("select * from ogrenciler");

        // 5. adim; Sonuclari al

        while (veri.next()){
            // 1. yol= en goleyi
            // System.out.println(veri.getInt(1) + veri.getString(2) +
                    // veri.getString(3) + veri.getString(4) );

            // 2. yol
            System.out.println(veri.getInt("okul_no") + veri.getString("ogrenci_ismi") +
                    veri.getString("sinif") + veri.getString("cinsiyet") );

           //3. yol
            // System.out.printf("%-6d %-15.15s %-8s %-8s\n", veri.getInt(1) + veri.getString(2) +
               //     veri.getString(3) + veri.getString(4));

        }

        // 6. Adim; KAPAT
        con.close();
        st.close();
        veri.close();

    }
}
