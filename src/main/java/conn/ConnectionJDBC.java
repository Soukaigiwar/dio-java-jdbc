package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    public static void main(String[] args) throws SQLException {

        Password pwConnection = new Password();
        Connection conn = null;
        String pw = pwConnection.passwd;
        String url = pwConnection.urlConn;
        String user = pwConnection.user;

        System.out.println("senha: " + pw + "\nUsuario: " + user + "\nUrl: " + url);

        try {
            conn = DriverManager.getConnection(url, user, pw);
            System.out.println("Conectado ao MYSQL com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro");
        } finally {
            conn.close();
        }

        System.out.println(conn);
    }
}
