import java.sql.*;


public class Query04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimeZone=UTC","root","1234");

        PreparedStatement ps = con.prepareStatement("select * from ogrenciler");

        ResultSet rs= ps.executeQuery();

        ResultSetMetaData rsmd= rs.getMetaData();

        System.out.println("1. stunun ismi : "+rsmd.getColumnName(1));


    }
}
