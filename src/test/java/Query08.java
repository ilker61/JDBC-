import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query08 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimeZone=UTC","root","1234");

        Statement st = con.createStatement();

        // SORU; urunler adinda bir tablo olusturalim (id int, isim varchar(10), fiyat int)

        //String sorgu="create table urunler (id int, isim varchar(10), fiyat int)";

        //st.execute(sorgu);

        //System.out.println("Urunler tablosu olusturuldu");

        // SORU2; Urunler tablosuna asagidaki verileri toplu bir sekilde ekleyin
        // Cok miktarda kayit eklemek icin preperedStatement methidu kullanilir
        // 1- Veri girisine uygun bir pojo (Plain Old Java Object) class olusturulur
        // 2-POJO class ta nesneleri saklayacak bir collection olusturulur
        // 3-Bir dongu ile kayitlar eklenir

        List<Urun> kayitlar = new ArrayList<>();
        kayitlar.add(new Urun(101, "laptop", 6500));
        kayitlar.add(new Urun(102, "PC", 4500));
        kayitlar.add(new Urun(103, "Telefon", 4500));
        kayitlar.add(new Urun(104, "Klavye", 1500));
        kayitlar.add(new Urun(105, "Anakart", 500));
        kayitlar.add(new Urun(106, "Fare", 400));

        PreparedStatement tablo= con.prepareStatement("INSERT INTO urunler VALUES(?, ?, ?)");
        for ( Urun w: kayitlar
             ) {
            tablo.setInt(1, w.getId());
            tablo.setString(2, w.getIsim());
            tablo.setDouble(3, w.getFiyat());

            tablo.addBatch();
        }

            tablo.executeBatch();
        System.out.println("Veriler database ye gonderildi");

        con.close();
        st.close();
        tablo.close();
    }
}
