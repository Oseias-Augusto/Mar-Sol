package MarSol.Controller;
import java.util.Collection;

import MarSol.Entidades.Cliente;
import MarSol.Entidades.Endereco;
import MarSol.Entidades.Telefone;
import MarSol.Services.ClienteService;

public class ClienteController {

    private ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    public Cliente criarCliente(String nome) {
        return service.criarCliente(nome);
    }

    public Cliente criarClienteCompleto(String nome, Endereco endereco, Telefone... telefones) {
        return service.criarCliente(nome, endereco, telefones);
    }

    public Cliente buscarCliente(int codigo) {
        return service.buscarCliente(codigo);
    }

    public Collection<Cliente> listarClientes() {
        return service.listarClientes();
    }

    public void atualizarCliente(Cliente cliente) {
        service.atualizarCliente(cliente);
    }

    public void removerCliente(int codigo) {
        service.removerCliente(codigo);
    }
}