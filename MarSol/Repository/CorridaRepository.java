package MarSol.Repository;
import java.util.*;

import MarSol.Entidades.Corrida;

public interface CorridaRepository {

    void salvar(Corrida corrida);

    List<Corrida> listar();

    void atualizar(Corrida corrida);
}