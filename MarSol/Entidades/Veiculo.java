package MarSol.Entidades;


public class Veiculo {

    private String placa;
    private String modelo;
    private String fabricante;
    private String cor;

    public Veiculo ( String placa, String modelo, String Fabricante, String cor) {
        setPlaca(placa);
        setModelo(modelo);
        setFabricante(Fabricante);
        setCor(cor);
    }

    // Getters e Setters

    public String getPlaca () { return this.placa; }
    public void setPlaca ( String placa) {
        if (placa == null || placa.length() != 7) {
            throw new IllegalArgumentException("Erro: placa invalida, placas tem 7 caracteres");
        }
        this.placa = placa;
    }

    public String getModelo () { return this.modelo; }
    public void setModelo ( String modelo) {
        if ( modelo == null) {
            throw new IllegalArgumentException("Erro: Modelo invalido, entre com um modelo");
        }
        this.modelo = modelo;
    }

    public String getFabricante () { return this.fabricante; } 
    public void setFabricante (String fabricante) {
        if (fabricante == null) {
            throw new IllegalArgumentException("Erro: Fabricante invalido, entre com um fabricante");
        }
        this.fabricante = fabricante;
    }

    public String getCor () { return this.cor; }
    public void setCor (String cor) {
        if (cor == null) {
            throw new IllegalArgumentException("Erro: Cor invalida, entre com uma cor");
        }
        this.cor = cor;
    }
}
