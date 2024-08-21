package org.locadora.ProjetoLocadora.Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.locadora.ProjetoLocadora.BD.MySQLConnection;
import org.locadora.ProjetoLocadora.Tools.Menu;

public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    
    public Cliente(String nome, String cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void cadastrarCliente(){
        MySQLConnection conexao = new MySQLConnection();
        try (Connection connection = conexao.conectar()){
        // Inserir dados na tabela Clientes
        String sqlClientes = "INSERT INTO Clientes (nome, cpf, email, telefone) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sqlClientes)) {
            pstmt.setString(1, getNome());
            pstmt.setString(2, getCpf());
            pstmt.setString(3, getEmail());
            pstmt.setString(4, getTelefone());
            pstmt.executeUpdate();
           connection.close();
           Menu menu = new Menu();
           menu.menuNavegacao();
        }

    } catch (SQLException e) {
        System.out.println("Erro ao conectar ao inserir dados.");
        e.printStackTrace();
        Menu menu = new Menu();
           menu.menuNavegacao();
    }
    }
    public static void listarClientes() {
        String sql = "SELECT * FROM Clientes";
        MySQLConnection conexao = new MySQLConnection();
        try (Connection connection = conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Nome: " + rs.getString("nome") +
                        ", CPF: " + rs.getString("cpf") +
                        ", Telefone: " + rs.getString("telefone") +
                        ", Email: " + rs.getString("email"));
            }
            System.out.println();
            Menu menu = new Menu();
           menu.menuNavegacao();
        } catch (SQLException e) {
            e.printStackTrace();
            Menu menu = new Menu();
           menu.menuNavegacao();
        }
    }
    public void atualizaCliente(int id){
        String sql = "UPDATE Clientes SET nome = ?, cpf = ?, telefone = ?, email = ? WHERE id = ?";
        MySQLConnection conexao = new MySQLConnection();
        try (Connection connection = conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, getNome());
            stmt.setString(2, getCpf());
            stmt.setString(3, getTelefone());
            stmt.setString(4, getEmail());
            stmt.setInt(5, id);

            stmt.executeUpdate();
            Menu menu = new Menu();
            menu.menuNavegacao();
            System.out.println("Cliente atualizado com sucesso!\n");
        } catch (SQLException e) {
            e.printStackTrace();
            Menu menu = new Menu();
           menu.menuNavegacao();
        }
    }
    public void deletarCliente(int id){
        
        String sql = "DELETE FROM clientes WHERE (id = ?)";
        MySQLConnection conexao = new MySQLConnection();
        try (Connection connection = conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            stmt.executeUpdate();
            System.out.println("Cliente deletado com sucesso!\n");
            Menu menu = new Menu();
            menu.menuNavegacao();
        } catch (SQLException e) {
            e.printStackTrace();
            Menu menu = new Menu();
           menu.menuNavegacao();
        }
    }
}
