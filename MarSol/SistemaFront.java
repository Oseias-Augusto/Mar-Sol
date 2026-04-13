package MarSol;

import java.util.*;
import MarSol.Repository.*;
import MarSol.Memoria.*;
import MarSol.Services.*;
import MarSol.Controller.*;
import MarSol.Fronteira.*;

public class SistemaFront {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ClienteRepository clienteRepo = new ClienteRepositoryMemoria();
        ClienteService clienteService = new ClienteService(clienteRepo);
        ClienteController clienteController = new ClienteController(clienteService);

        CooperadorRepository coopRepo = new CooperadorRepositoryMemoria();
        CooperadorService coopService = new CooperadorService(coopRepo);
        CooperadorController coopController = new CooperadorController(coopService);

        LogradouroService logService = new LogradouroService(new HashSet<>());

        CorridaRepository corridaRepo = new CorridaRepositoryMemoria();
        CorridaService corridaService = new CorridaService(corridaRepo, logService);
        CorridaController corridaController = new CorridaController(corridaService);

        FrontCliente frontCliente = new FrontCliente(clienteController);
        FrontCooperador frontCooperador = new FrontCooperador(coopController);
        FrontCorrida frontCorrida = new FrontCorrida(corridaController, clienteController, logService);

        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Cliente");
            System.out.println("2 - Cooperador");
            System.out.println("3 - Corrida");
            System.out.println("0 - Sair");

            System.out.print("\nEscolha: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    frontCliente.menu(sc);
                    break;
                case 2:
                    frontCooperador.menu(sc);
                    break;
                case 3:
                    frontCorrida.menu(sc);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
            }
        }
    }
}