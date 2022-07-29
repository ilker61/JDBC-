import java.sql.*;


public class Query04VeriCekme {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimeZone=UTC","root","1234");

        PreparedStatement ps = con.prepareStatement("select * from ogrenciler");

        ResultSet rs= ps.executeQuery();

        ResultSetMetaData rsmd= rs.getMetaData();

        System.out.println("1. stunun ismi : "+rsmd.getColumnName(1));
        System.out.println("2. stunun ismi : "+rsmd.getColumnName(2));
        System.out.println("3. stunun ismi : "+rsmd.getColumnName(3));
        System.out.println("4. stunun ismi : "+rsmd.getColumnName(4));


        System.out.println("Toplam Stun sayisi ; "+rsmd.getColumnCount());
        System.out.println("1. stunun database dosya ismi ; " + rsmd.getCatalogName(1));  // okul
        System.out.println("2. stunun data type ; "+rsmd.getColumnTypeName(2));

        System.out.println("Daplonun isimi ; " + rsmd.getTableName(1));


    }
}
