package MarSol.Controller;
import java.time.LocalDate;
import java.util.Collection;

import MarSol.Entidades.Cooperador;
import MarSol.Entidades.Endereco;
import MarSol.Entidades.Telefone;
import MarSol.Entidades.Veiculo;
import MarSol.Services.CooperadorService;

public class CooperadorController {

    private CooperadorService service;

    public CooperadorController(CooperadorService service) {
        this.service = service;
    }

    public Cooperador criarCooperador(
            String cpf, String cnh, Cooperador.Categoria categoria,
            String validadeCnh, int numeroVR, Veiculo veiculo,
            String nome, Endereco endereco, Telefone... telefones) {

        return service.criarCooperador(
                cpf, cnh, categoria, validadeCnh,
                numeroVR, veiculo, nome, endereco, telefones
        );
    }

    public Cooperador buscar(int vr) {
        return service.buscar(vr);
    }

    public Collection<Cooperador> listar() {
        return service.listar();
    }

    public void desligar(int vr, LocalDate dataSaida) {
        service.desligarCooperador(vr, dataSaida);
    }
}