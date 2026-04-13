package MarSol.Services;
import java.util.*;

import MarSol.Entidades.Cliente;
import MarSol.Entidades.Endereco;
import MarSol.Entidades.Telefone;
import MarSol.Repository.ClienteRepository;

public class ClienteService {

    private ClienteRepository repository;
    private int contador;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
        this.contador = 1;
    }

    public Cliente criarCliente(String nome) {
        Cliente cliente = new Cliente(contador++, nome);
        repository.salvar(cliente);
        return cliente;
    }

    public Cliente criarCliente(String nome, Endereco endereco, Telefone... telefones) {
        Cliente cliente = new Cliente(contador++, nome, endereco, telefones);
        repository.salvar(cliente);
        return cliente;
    }

    public Cliente buscarCliente(int codigo) {
        if (!repository.existe(codigo)) {
            throw new IllegalArgumentException("Cliente não existe");
        }
        return repository.buscarPorId(codigo);
    }

    public Collection<Cliente> listarClientes() {
        return repository.listar();
    }

    public void atualizarCliente(Cliente cliente) {
        if (!repository.existe(cliente.getCodigo())) {
            throw new IllegalArgumentException("Cliente não existe");
        }
        repository.atualizar(cliente);
    }

    public void removerCliente(int codigo) {
        repository.remover(codigo);
    }
}