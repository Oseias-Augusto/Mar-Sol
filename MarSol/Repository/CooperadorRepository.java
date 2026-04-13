package MarSol.Repository;
import java.util.*;

import MarSol.Entidades.Cooperador;

public interface CooperadorRepository {

    void salvar(Cooperador cooperador);

    Cooperador buscarPorVR(int numeroVR);

    Collection<Cooperador> listar();

    void atualizar(Cooperador cooperador);

    void remover(int numeroVR);

    boolean existe(int numeroVR);
}