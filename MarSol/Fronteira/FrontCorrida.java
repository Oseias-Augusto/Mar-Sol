package MarSol.Fronteira;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import MarSol.Controller.*;
import MarSol.Entidades.*;
import MarSol.Services.LogradouroService;


public class FrontCorrida {

    private CorridaController controller;
    private ClienteController clienteController;
    private LogradouroService logService;

    public FrontCorrida(CorridaController controller,
                        ClienteController clienteController,
                        LogradouroService logService) {
        this.controller = controller;
        this.clienteController = clienteController;
        this.logService = logService;
    }

    public void menu(Scanner sc) {

        System.out.println("\n=== CORRIDA ===");
        System.out.println("1 - Solicitar");
        System.out.println("2 - Gerenciar");
        System.out.println("3 - Listar");
        System.out.println("4 - Adicionar logradouro");
        System.out.println("5 - Listar logradouros");

        System.out.print("\nEscolha: ");
        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {

            case 1:
                System.out.print("Código cliente: ");
                int cod = sc.nextInt();
                sc.nextLine();

                Cliente cliente = clienteController.buscarCliente(cod);

                Endereco end = UtilsFront.lerEndereco(sc);

                System.out.print("Destino: ");
                String destino = sc.nextLine();

                Telefone tel = UtilsFront.lerTelefone(sc);

                Corrida corrida = controller.solicitarCorrida(
                        cliente, end, destino, LocalDateTime.now(), tel
                );

                System.out.println("Status: " + corrida.getStatus());
                break;

            case 2:
                List<Corrida> lista = controller.listar();

                for (int i = 0; i < lista.size(); i++) {
                    System.out.println(i + " - " + lista.get(i).getStatus());
                }

                int idx = sc.nextInt();
                Corrida c = lista.get(idx);

                System.out.println("1-VR 2-Aviso 3-Confirmar 4-Iniciar 5-Cancelar P 6-Cancelar C");
                int acao = sc.nextInt();

                switch (acao) {
                    case 1:
                        System.out.print("VR: ");
                        controller.atribuirVR(c, sc.nextInt());
                        break;
                    case 2:
                        controller.prepararAviso(c);
                        break;
                    case 3:
                        controller.avisar(c);
                        break;
                    case 4:
                        controller.iniciar(c);
                        break;
                    case 5:
                        controller.cancelarPassageiro(c);
                        break;
                    case 6:
                        controller.cancelarCooperativa(c);
                        break;
                }

                System.out.println("Novo status: " + c.getStatus());
                break;

            case 3:
                controller.listar()
                        .forEach(x -> System.out.println(x.getStatus()));
                break;

            case 4:
                System.out.print("Logradouro: ");
                logService.adicionar(sc.nextLine());
                break;

            case 5:
                logService.listar()
                        .forEach(System.out::println);
                break;
        }
    }
}