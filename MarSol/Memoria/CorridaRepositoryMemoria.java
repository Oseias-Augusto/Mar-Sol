package MarSol.Memoria;
import java.util.*;

import MarSol.Entidades.Corrida;
import MarSol.Repository.CorridaRepository;

public class CorridaRepositoryMemoria implements CorridaRepository {

    private List<Corrida> corridas = new ArrayList<>();

    @Override
    public void salvar(Corrida corrida) {
        corridas.add(corrida);
    }

    @Override
    public List<Corrida> listar() {
        return corridas;
    }

    @Override
    public void atualizar(Corrida corrida) {}
}