import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query05VeriGonderme {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        // Yazacagimiz kod ile Data Base ye veri gonderecegiz
        // Okul database sinde isciler isminde bir tablo olusturuyoruz


        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimeZone=UTC","root","1234");

        Statement st = con.createStatement();

        // Soru;  Isciler adinda bir tablo olustur. id int, birim varchar(10), maas int


        // String sorgu="create table isciler (id int, birim varchar(10), maas int)";

        //st.execute(sorgu);

        //System.out.println("Isciler tablosu olusturuldu");


        // Soru:   isciler tablosunu silelem

        // st.execute("drop table isciler");
        // System.out.println("Isciler tablosu silindi");


        // Soru; isciler tablosnua isim varchar(20), sehir varchar(10) adinda iki dene stun ekle

        // st.execute("alter table isciler add isim varchar(20)");
        // st.execute("alter table isciler add sehir varchar(10)");

        // System.out.println("2 stun eklendi");


        // SORU; isciler tablosundaki sehir stun ismini ulkeler olaraktana degistir

        // st.execute("alter table isciler rename column sehir to ulke");

        // System.out.println("Stun ismi degistirildi");


        // SORU; Tablonuu isimini employee olarak degistirin

        // st.execute("alter table isciler rename to empleyee");

        // System.out.println("Tablo ismi degistirildi");


        // SORU; Ulke stunun data durunu char(30) yapin

        st.execute("alter table empleyee modify ulke char(30)");

        System.out.println("Ulke stununun data turu degistirildi");

    }
}
