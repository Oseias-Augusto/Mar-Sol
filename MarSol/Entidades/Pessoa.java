package MarSol.Entidades;
import java.util.List;
import java.util.ArrayList;

public abstract class Pessoa {

    protected String nome;
    protected Endereco endereco;
    protected List<Telefone> telefones = new ArrayList<>(2);

    //getters e setters

    public String getNome() {return nome;}
    public void setNome(String nome) { 
        
        if (nome != null) {
            this.nome = nome;
        }
        else {
            throw new IllegalArgumentException("Erro: entre com um nome");
        }
    }

    public Endereco getEndereco() { return endereco;} 
    public void setEndereco( Endereco endereco) {
        
        if (endereco != null) {
            this.endereco = endereco;
        }
        else {
            throw new IllegalArgumentException("Erro: Endereço invalido");
        }
    }

    public List<Telefone> getTelefones() {return telefones;}
    public void adicionarTelefone(Telefone telefone) {
        if (telefone == null) {
            throw new IllegalArgumentException("Erro: Número invalido");
        }

        if (telefones.size() >= 2) {
            throw new IllegalStateException("Máximo de 2 telefones atingido");
        }

        telefones.add(telefone);
    }

}
