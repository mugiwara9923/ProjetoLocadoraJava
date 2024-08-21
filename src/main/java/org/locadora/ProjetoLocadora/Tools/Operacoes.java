package org.locadora.ProjetoLocadora.Tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.locadora.ProjetoLocadora.BD.MySQLConnection;
import org.locadora.ProjetoLocadora.Class.Cliente;

public class Operacoes {
    public void adicionarCliente(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite o email do cliente: ");
        String email = scanner.nextLine();
        Cliente cliente = new Cliente(nome, cpf, email, telefone);
        cliente.cadastrarCliente();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateCliente(){
        Scanner scanner = new Scanner (System.in);
        listarClientes();
        System.out.print("Digite o ID do cliente que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        System.out.print("Digite o novo nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o novo CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o novo telefone do cliente: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite o novo email do cliente: ");
        String email = scanner.nextLine();
        Cliente cliente = new Cliente(nome, cpf, email, telefone);
        cliente.atualizaCliente(id);
    }
    public void deleteCliente(){
        Scanner scanner = new Scanner (System.in);
        listarClientes();
        System.out.print("Digite o ID do cliente que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        Cliente cliente = new Cliente("", "", "", "");
        cliente.deletarCliente(id);
    }
}
