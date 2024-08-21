package org.locadora.ProjetoLocadora.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/locadora_filmes"; // URL do banco de dados
        String user = "root"; // Nome de usuário do MySQL
        String password = ""; // Senha do MySQL

        Connection connection = null;

        try {
            // Carregar o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Estabelecer a conexão
            connection = DriverManager.getConnection(url, user, password);

            return connection;

        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado.");
            
            e.printStackTrace();
            return connection;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados.");
            e.printStackTrace();
            return connection;
        }
    }
}
