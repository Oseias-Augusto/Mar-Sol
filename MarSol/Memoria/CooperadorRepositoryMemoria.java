package MarSol.Memoria;
import java.util.*;

import MarSol.Entidades.Cooperador;
import MarSol.Repository.CooperadorRepository;

public class CooperadorRepositoryMemoria implements CooperadorRepository {

    private Map<Integer, Cooperador> cooperadores = new HashMap<>();

    @Override
    public void salvar(Cooperador cooperador) {
        cooperadores.put(cooperador.getNumeroVR(), cooperador);
    }

    @Override
    public Cooperador buscarPorVR(int numeroVR) {
        return cooperadores.get(numeroVR);
    }

    @Override
    public Collection<Cooperador> listar() {
        return cooperadores.values();
    }

    @Override
    public void atualizar(Cooperador cooperador) {
        cooperadores.put(cooperador.getNumeroVR(), cooperador);
    }

    @Override
    public void remover(int numeroVR) {
        cooperadores.remove(numeroVR);
    }

    @Override
    public boolean existe(int numeroVR) {
        return cooperadores.containsKey(numeroVR);
    }
}