import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query06 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimeZone=UTC","root","1234");

        Statement st = con.createStatement();

        // Soru; Bolumler tablosunda yani bir kayit (80, 'ARGE', 'ISTANBUL')

        // int s1 = st.executeUpdate("INSERT INTO bolumler VALUES (80, 'ARGE', 'ISTANBUL')");

        // Not; executeUpdate etkilenen satir ayisini dondurur

        // System.out.println(s1+ "satir eklendi");

        /*
        String [] veri1={"INSERT INTO bolumler VALUES (95, 'YEMEKHANE', 'ISTANBUL')",
                "INSERT INTO bolumler VALUES (85, 'OFIS', 'ANKARA')",
                "INSERT INTO bolumler VALUES (75, 'OFIS','TRABZON')"};

        int count=0;

        for (String each: veri1
             ) {
        count=count + st.executeUpdate(each);
        }
        System.out.println(count + " data eklendi");

        // 2.yol

        String [] veri2={"INSERT INTO bolumler VALUES (81, 'YEMEKHANE', 'ISTANBUL')",
                "INSERT INTO bolumler VALUES (82, 'OFIS', 'ANKARA')",
                "INSERT INTO bolumler VALUES (83, 'OFIS','TRABZON')"};


        for (String w: veri2
             ) {
            st.addBatch(w);  // yukaridaki verilerin tamamini bir araya topluyor
        }

        st.executeBatch();  // bir araya getirilen verileri tek seferde gonderiyor

        System.out.println("Veriler database ye eklendi");

        */

        // Soru; Bolumler tablosuna birden fazla kayit ekleyelim.

        String [] veri3={"INSERT INTO bolumler VALUES (100, 'YEMEKHANE', 'ISTANBUL')",
                "INSERT INTO bolumler VALUES (101, 'OFIS', 'ANKARA')",
                "INSERT INTO bolumler VALUES (102, 'OFIS','TRABZON')", "INSERT INTO bolumler VALUES (103, 'OFIS','TRABZON')",
                "INSERT INTO bolumler VALUES (104, 'OFIS','TRABZON')"};

        for (String e: veri3
             ) {
            st.addBatch(e);
        }
        st.executeBatch();

    }
}
