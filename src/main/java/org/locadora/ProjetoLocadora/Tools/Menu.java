
package org.locadora.ProjetoLocadora.Tools;
import java.util.Scanner;
public class Menu {
    public void menuNavegacao(){
        int opcao;
        Scanner scanner = new Scanner(System.in);
        Operacoes operacoes = new Operacoes();
        do {
            System.out.println("----- MENU CRUD -----");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Deletar Cliente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    operacoes.adicionarCliente();
                    break;
                case 2:
                    operacoes.listarClientes();
                    break;
                case 3:
                    operacoes.updateCliente();
                    break;
                case 4:
                    operacoes.deleteCliente();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
    }

}
