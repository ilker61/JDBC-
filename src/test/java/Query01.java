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
            System.out.println(veri.getInt(1) + veri.getString(2) +
                    veri.getString(3) + veri.getString(4) );
        }



    }
}
