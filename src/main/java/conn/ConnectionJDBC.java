package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    public static void main(String[] args) {

        Password pwConnection = new Password();
        String pw = pwConnection.passwd;
        String url = pwConnection.urlConn;
        String user = pwConnection.user;

        System.out.println("senha: " + pw + "\nUsuario: " + user + "\nUrl: " + url);
        try {
            Connection conn = DriverManager.getConnection(url, user, pw);
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }
}
