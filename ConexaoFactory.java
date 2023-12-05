import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {


    private static final String URL = "jdbc:mysql://127.0.0.1:3306/crud";
    private static final String USUARIO = "root";
   // private static final String SENHA = "password";
    private static final String SENHA = "senai";

    private static Connection conexao;

    private ConexaoFactory() {}

    public static Connection getConexao() throws SQLException {
        if (conexao == null) {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        }
        
        return conexao;
    }
}
