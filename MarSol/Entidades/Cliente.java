package MarSol.Entidades;

public class Cliente extends Pessoa{

    private int codigo;

    public Cliente (int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    public Cliente ( int codigo ,String nome, Endereco endereco, Telefone... telefones) {

        this.codigo = codigo;
        setNome(nome);
        setEndereco(endereco);
        for (Telefone t : telefones) {
            adicionarTelefone(t);
        }
    }


    // Getters e Setters
    public int getCodigo() {return codigo;}
}
