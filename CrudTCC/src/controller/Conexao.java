package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Conexão com o banco do EcoMaps.
 *
 * IMPORTANTE: se o seu XAMPP usar outra porta ou o root tiver senha,
 * altere apenas as constantes abaixo.
 */
public final class Conexao {

    private static final String HOST = "127.0.0.1";
    private static final String PORTA = "3306"; // XAMPP normalmente usa 3306
    private static final String BANCO = "ecomaps";
    private static final String USUARIO = "root";
    private static final String SENHA = ""; // XAMPP padrão: senha vazia

    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORTA + "/" + BANCO
            + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=America/Sao_Paulo"
            + "&useUnicode=true&characterEncoding=UTF-8";

    private Conexao() {
    }

    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public static boolean testarConexao() {
        try (Connection conexao = getConexao()) {
            return conexao != null && !conexao.isClosed();
        } catch (SQLException ex) {
            return false;
        }
    }

    public static String getResumoConfiguracao() {
        return HOST + ":" + PORTA + "/" + BANCO + " | usuário: " + USUARIO;
    }
}
