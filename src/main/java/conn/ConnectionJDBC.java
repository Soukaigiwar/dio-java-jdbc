package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    public static void main(String[] args) throws SQLException {
        String urlConnection = "jdbc:mysql:http://192.185.217.159";
        Connection conn = DriverManager.getConnection(urlConnection,"fastf981_dio","");
    }
}
