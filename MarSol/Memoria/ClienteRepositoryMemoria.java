package MarSol.Memoria;
import java.util.*;

import MarSol.Entidades.Cliente;
import MarSol.Repository.ClienteRepository;

public class ClienteRepositoryMemoria implements ClienteRepository {

    private Map<Integer, Cliente> clientes = new HashMap<>();

    @Override
    public void salvar(Cliente cliente) {
        clientes.put(cliente.getCodigo(), cliente);
    }

    @Override
    public Cliente buscarPorId(int codigo) {
        return clientes.get(codigo);
    }

    @Override
    public Collection<Cliente> listar() {
        return clientes.values();
    }

    @Override
    public void atualizar(Cliente cliente) {
        clientes.put(cliente.getCodigo(), cliente);
    }

    @Override
    public void remover(int codigo) {
        clientes.remove(codigo);
    }

    @Override
    public boolean existe(int codigo) {
        return clientes.containsKey(codigo);
    }
}