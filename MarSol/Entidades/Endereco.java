package MarSol.Entidades;


public class Endereco {

    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String estado;

    public Endereco( String logradouro, int numero, String bairro, 
                    String municipio, String estado, String complemento) 
    {
        setLogradouro(logradouro);
        setNumero(numero);
        setBairro(bairro);
        setMunicipio(municipio);
        setEstado(estado);
        setComplemento(complemento);
    }


    // Getters e Setters
    public String getLogradouro() { return this.logradouro; }
    public void setLogradouro (String logradouro ) {
        if (logradouro == null) {
            throw new IllegalArgumentException("Erro: Logradouro invalido");
        }
        this.logradouro = logradouro;
    }

    public int getNumero() { return this.numero; }
    public void setNumero (int numero) { 

        if( numero <= 0) {
            throw new IllegalArgumentException("Erro: Número invalido");
        }
        this.numero = numero;
    }

    public String getComplemento() { return this.complemento; }
    public void setComplemento (String complemento) { this.complemento = complemento; }

    public String getBairro() { return this.bairro; }
    public void setBairro (String bairro) {
        if (bairro == null) {
            throw new IllegalArgumentException("Erro: Bairro invalido");
        }
        this.bairro = bairro;
        
    }

    public String getMunicipio() { return this.municipio; }
    public void setMunicipio (String municipio) {
        
        this.municipio = municipio;
    }

    public String getEstado() { return this.estado; }
    public void setEstado (String estado) {
        
        this.estado = estado;
        
    }

    @Override
    public String toString() {
        return logradouro + ", " + numero +
               (complemento != null ? " - " + complemento : "") +
               ", " + bairro + ", " + municipio + " - " + estado;
    }
}
