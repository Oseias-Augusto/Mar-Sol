package MarSol.Repository;
import java.util.*;

import MarSol.Entidades.Cliente;

public interface ClienteRepository {

    void salvar(Cliente cliente);

    Cliente buscarPorId(int codigo);

    Collection<Cliente> listar();

    void atualizar(Cliente cliente);

    void remover(int codigo);

    boolean existe(int codigo);
}
