package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    public static void main(String[] args) {

        Password pwConnection = new Password();
        //Connection conn = null;

        try (Connection conn = DriverManager.getConnection(pwConnection.urlConn, pwConnection.user, pwConnection.passwd)){
            System.out.println("Conectado ao MYSQL com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao servidor MYSQL");
        }
    }
}
