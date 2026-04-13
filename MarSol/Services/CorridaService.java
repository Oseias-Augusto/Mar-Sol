package MarSol.Services;
import java.time.LocalDateTime;
import java.util.List;

import MarSol.Entidades.Cliente;
import MarSol.Entidades.Corrida;
import MarSol.Entidades.Endereco;
import MarSol.Entidades.Telefone;
import MarSol.Repository.CorridaRepository;

public class CorridaService {

    private CorridaRepository repository;
    private LogradouroService logradouroService;

    public CorridaService(CorridaRepository repository,
                          LogradouroService logradouroService) {
        this.repository = repository;
        this.logradouroService = logradouroService;
    }

    public Corrida solicitarCorrida(Cliente cliente,
                                    Endereco enderecoSaida,
                                    String bairroDestino,
                                    LocalDateTime dataHoraSaida,
                                    Telefone telefoneContato) {

        if (!logradouroService.existe(enderecoSaida.getLogradouro())) {
            throw new IllegalArgumentException("Logradouro não atendido");
        }

        Corrida corrida = new Corrida(
                cliente,
                enderecoSaida,
                bairroDestino,
                dataHoraSaida,
                telefoneContato
        );

        repository.salvar(corrida);
        return corrida;
    }

    public void atribuirVR(Corrida corrida, int numeroVR) {
        corrida.atribuirVR(numeroVR);
        repository.atualizar(corrida);
    }

    public void prepararAviso(Corrida corrida) {
        corrida.prepararAviso();
        repository.atualizar(corrida);
    }

    public void avisarCliente(Corrida corrida) {
        corrida.avisar();
        repository.atualizar(corrida);
    }

    public void iniciarCorrida(Corrida corrida) {
        corrida.iniciar();
        repository.atualizar(corrida);
    }

    public void cancelarPorPassageiro(Corrida corrida) {
        corrida.cancelarPassageiro();
        repository.atualizar(corrida);
    }

    public void cancelarPorCooperativa(Corrida corrida) {
        corrida.cancelarCooperativa();
        repository.atualizar(corrida);
    }

    public List<Corrida> listarCorridas() {
        return repository.listar();
    }
}