package MarSol.Entidades;
import java.time.LocalDate;


public class Cooperador extends Pessoa{

    private String cpf;
    private String cnh;
    private Categoria categoria;
    private String validadeChn;
    private int numeroVR;
    private Veiculo veiculo;
    private LocalDate dataSaida;

    public enum Categoria{ A, B, C, D, E };


    public Cooperador( 
        String cpf, String cnh, Categoria categoria, String validadeCnh, int numeroVR, 
        Veiculo veiculo, String nome, Endereco endereco, Telefone... telefones) 
    {
        setCpf(cpf);
        setCnh(cnh);
        setCategoria(categoria);
        setValidadeCnh(validadeCnh);
        setNumeroVR(numeroVR);
        setVeiculo(veiculo);
        setNome(nome);
        setEndereco(endereco);
        for(Telefone t : telefones) {
            adicionarTelefone(t);
        }
    }
    

    //Getters e Setters

    public String getCpf() {return this.cpf;}
    public void setCpf(String cpf){
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("Erro: CPF invalido, necessário 11 digitos");
        }
        this.cpf = cpf;
    }

    public String getCnh() {return this.cnh;}
    public void setCnh(String cnh) {
        if (cnh.length() != 11) {
            throw new IllegalArgumentException("Erro: CNH invalido, necessário 11 digitos");
        }
        this.cnh = cnh;
    }

    public String getValidadeChn() {return this.validadeChn;}
    public void setValidadeCnh(String validade) {
        if (validade == null){
            throw new IllegalArgumentException("Erro: Data de validade invalida");
        }
        this.validadeChn = validade;
    }


    public Categoria getCategoria() {return this.categoria;}
    public void setCategoria(Categoria categoria) {
        if(categoria == null) {
            throw new IllegalArgumentException("Erro: Categoria invalida");
        }
        this.categoria = categoria;
    }

    public int getNumeroVR() {return this.numeroVR;}
    public void setNumeroVR(int numeroVR) {this.numeroVR = numeroVR;}

    public Veiculo getVeiculo() {return this.veiculo;}
    public void setVeiculo(Veiculo veiculo) {
        if (veiculo == null) {
            throw new IllegalArgumentException("Erro: Veiculo invalido");
        }
        this.veiculo = veiculo;
    }

    public LocalDate getDataSaida() {return this.dataSaida;}
    public void setDataSaida(LocalDate dataSaida) {
        if(dataSaida == null) {
            throw new IllegalArgumentException("Erro: Data de Saída invalida");
        }
        this.dataSaida = dataSaida;
    }

}
