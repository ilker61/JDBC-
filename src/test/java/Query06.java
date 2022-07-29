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

        int s1 = st.executeUpdate("INSERT INTO bolumler VALUES (80, 'ARGE', 'ISTANBUL')");

        // Not; executeUpdate etkilenen satir ayisini dondurur

        System.out.println(s1+ "satir eklendi");



    }
}
