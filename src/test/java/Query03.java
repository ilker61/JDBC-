import java.sql.*;

public class Query03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimeZone=UTC","root","1234");

        Statement st = con.createStatement();

        // SORU1= manav tablosundan tum kayitlari listeleyiniz

        ResultSet veri1= st.executeQuery("select * from markalar");

        while (veri1.next()){

            System.out.println( veri1.getInt("calisan_sayisi") +veri1.getInt("marka_id") +veri1.getString("marka_isim"));
        }



        // SORU; marka_id ve calisan_sayisi ni sirali olaraktana listele

        System.out.println("=======================================");

        ResultSet veri2= st.executeQuery("select marka_id, calisan_sayisi from markalar order by calisan_sayisi desc");

        while (veri2.next()){

            System.out.println(veri2.getInt(1) + veri2.getInt(2));

        }

        con.close();
        st.close();
        veri1.close();


    }
}
