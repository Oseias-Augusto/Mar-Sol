package MarSol.Services;
import java.time.LocalDate;
import java.util.Collection;

import MarSol.Entidades.Cooperador;
import MarSol.Entidades.Endereco;
import MarSol.Entidades.Telefone;
import MarSol.Entidades.Veiculo;
import MarSol.Repository.CooperadorRepository;

public class CooperadorService {

    private CooperadorRepository repository;

    public CooperadorService(CooperadorRepository repository) {
        this.repository = repository;
    }

    public Cooperador criarCooperador(
            String cpf, String cnh, Cooperador.Categoria categoria,
            String validadeCnh, int numeroVR, Veiculo veiculo,
            String nome, Endereco endereco, Telefone... telefones) {

        if (repository.existe(numeroVR)) {
            throw new IllegalArgumentException("VR já existe");
        }

        Cooperador cooperador = new Cooperador(
                cpf, cnh, categoria, validadeCnh,
                numeroVR, veiculo, nome, endereco, telefones
        );

        repository.salvar(cooperador);
        return cooperador;
    }

    public Cooperador buscar(int numeroVR) {
        if (!repository.existe(numeroVR)) {
            throw new IllegalArgumentException("Cooperador não existe");
        }
        return repository.buscarPorVR(numeroVR);
    }

    public Collection<Cooperador> listar() {
        return repository.listar();
    }

    public void atualizar(Cooperador cooperador) {
        if (!repository.existe(cooperador.getNumeroVR())) {
            throw new IllegalArgumentException("Cooperador não existe");
        }
        repository.atualizar(cooperador);
    }

    public void remover(int numeroVR) {
        repository.remover(numeroVR);
    }

    public void desligarCooperador(int numeroVR, LocalDate dataSaida) {
        Cooperador c = buscar(numeroVR);
        c.setDataSaida(dataSaida);
        repository.atualizar(c);
    }
}