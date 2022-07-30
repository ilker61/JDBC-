import java.sql.*;

public class Query07 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimeZone=UTC","root","1234");

        // STATEMENT, PREPAREDSTATEMENT FARKI

        // STATEMENT:

        /*
        Statement st = con.createStatement();
        st.executeUpdate("INSERT INTO ogrenciler VALUES (200, 'Aali CANA', 10, 'E')");
        */

        // PREPAREDSTATEMENT; ifadeler parametlre ile yollanabilir

        PreparedStatement ps= con.prepareStatement("INSERT INTO ogrenciler VALUES (?, ?, ?, ?)");
        ps.setInt(1, 201);
        ps.setString(2, "Veli Xan");
        ps.setString(3,"12");
        ps.setString(4,"E");

        ps.executeUpdate();

        System.out.println("Veri girisi saglandi ya laa");

    }
}
