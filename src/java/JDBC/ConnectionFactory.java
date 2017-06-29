package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author <Leticia e Mylena>
 */
public class ConnectionFactory {

    String driver = "org.postgresql.Driver";
    String usuario = "postgres";
    String senha = "aluno";
    String nomeBanco = "Tcc";
    String enderecoServer = "localhost";

    public Connection getConnection() {

        try {
            
            Class.forName(driver);
            return DriverManager.getConnection("jdbc:postgresql://" + enderecoServer + "/" + nomeBanco,
                    usuario, senha);

        } catch (SQLException e) {
            System.err.println("ERRO!Conexão não aconteceu");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}