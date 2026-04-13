package MarSol.Fronteira;

import java.util.Scanner;

import MarSol.Controller.*;
import MarSol.Entidades.*;

public class FrontCooperador {

    private CooperadorController controller;

    public FrontCooperador(CooperadorController controller) {
        this.controller = controller;
    }

    public void menu(Scanner sc) {

        System.out.println("\n=== COOPERADOR ===");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");

        System.out.print("\nEscolha: ");
        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {

            case 1:
                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("CPF: ");
                String cpf = sc.nextLine();

                System.out.print("CNH: ");
                String cnh = sc.nextLine();

                System.out.print("Categoria (A-E): ");
                Cooperador.Categoria cat = Cooperador.Categoria.valueOf(sc.nextLine().toUpperCase());

                System.out.print("Validade CNH: ");
                String validade = sc.nextLine();

                System.out.print("VR: ");
                int vr = sc.nextInt();
                sc.nextLine();

                System.out.println("=== Veículo ===");
                System.out.print("Placa: ");
                String placa = sc.nextLine();

                System.out.print("Modelo: ");
                String modelo = sc.nextLine();

                System.out.print("Fabricante: ");
                String fab = sc.nextLine();

                System.out.print("Cor: ");
                String cor = sc.nextLine();

                Veiculo v = new Veiculo(placa, modelo, fab, cor);

                Endereco end = UtilsFront.lerEndereco(sc);

                Telefone t1 = UtilsFront.lerTelefone(sc);
                Telefone t2 = UtilsFront.lerTelefone(sc);

                controller.criarCooperador(cpf, cnh, cat, validade, vr, v, nome, end, t1, t2);
                System.out.println("Criado!");
                break;

            case 2:
                controller.listar()
                        .forEach(c -> System.out.println(c.getNumeroVR() + " - " + c.getNome()));
                break;
        }
    }
}