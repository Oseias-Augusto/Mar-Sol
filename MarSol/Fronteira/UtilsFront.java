package MarSol.Fronteira;

import java.util.Scanner;

import MarSol.Entidades.*;

public class UtilsFront {

    public static Endereco lerEndereco(Scanner sc) {
        System.out.print("Logradouro: ");
        String log = sc.nextLine();

        System.out.print("Número: ");
        int num = sc.nextInt();
        sc.nextLine();

        System.out.print("Bairro: ");
        String bairro = sc.nextLine();

        System.out.print("Município: ");
        String mun = sc.nextLine();

        System.out.print("Estado: ");
        String est = sc.nextLine();

        System.out.print("Complemento: ");
        String comp = sc.nextLine();

        return new Endereco(log, num, bairro, mun, est, comp);
    }

    public static Telefone lerTelefone(Scanner sc) {
        System.out.print("Número: ");
        long num = sc.nextLong();
        sc.nextLine();

        System.out.print("Tipo (RESIDENCIAL/CELULAR): ");
        Telefone.TipoTelefone tipo = Telefone.TipoTelefone.valueOf(sc.nextLine().toUpperCase());

        return new Telefone(num, tipo);
    }
}