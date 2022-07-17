package aula02;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionJDBC {

    public static void main(String[] args) {

        Secrets pwConnection = new Secrets();

        try (Connection conn = DriverManager.getConnection(pwConnection.urlConn, pwConnection.user, pwConnection.passwd)){
            System.out.println("Conectado ao MYSQL com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao servidor MYSQL");
        }
    }
}
