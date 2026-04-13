package MarSol.Fronteira;

import java.util.Scanner;

import MarSol.Controller.ClienteController;
import MarSol.Entidades.*;

public class FrontCliente {

    private ClienteController controller;

    public FrontCliente(ClienteController controller) {
        this.controller = controller;
    }

    public void menu(Scanner sc) {

        System.out.println("\n=== CLIENTE ===");
        System.out.println("1 - Criar simples");
        System.out.println("2 - Criar completo");
        System.out.println("3 - Listar");

        System.out.print("\nEscolha: ");
        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {

            case 1:
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                Cliente c1 = controller.criarCliente(nome);
                System.out.println("Código: " + c1.getCodigo());
                break;

            case 2:
                System.out.print("Nome: ");
                String nomeC = sc.nextLine();

                Endereco end = UtilsFront.lerEndereco(sc);

                Telefone t1 = UtilsFront.lerTelefone(sc);
                Telefone t2 = UtilsFront.lerTelefone(sc);

                Cliente c2 = controller.criarClienteCompleto(nomeC, end, t1, t2);
                System.out.println("Código: " + c2.getCodigo());
                break;

            case 3:
                controller.listarClientes()
                        .forEach(c -> System.out.println(c.getCodigo() + " - " + c.getNome()));
                break;
        }
    }
}