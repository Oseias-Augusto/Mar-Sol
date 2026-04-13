package MarSol.Entidades;

public class Telefone {

    public enum TipoTelefone {
        RESIDENCIAL {
            @Override
            public String toString() {
                return "Telefone Residencial";
            }
        },
        CELULAR {
            @Override
            public String toString() {
                return "Telefone Celular";
            }
        }
    }

    private long numero;
    private TipoTelefone tipo;

    private void verificaNum (long numero) {

        String numStr = String.valueOf(numero);
        if (numStr.length() < 8 || numStr.length() > 11){
            throw new IllegalArgumentException("Erro: Número precisa ter entre 8 a 11 digitos");
        }
    }

    public Telefone (long numero){

        verificaNum(numero);
        this.numero = numero;
        
    }

    public Telefone (long numero, TipoTelefone tipo) {
        verificaNum(numero);
        this.numero = numero;
        this.tipo = tipo;
        
    }

    // Getters e Setters

    public long getNumero() {return numero;}
    public void setNumero(long numero) {
        verificaNum(numero);
        this.numero = numero;
    }

    @Override
    public String toString() {
        String tel = String.valueOf(numero);

        if (tel.length() == 11) {
            return tel.replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");
        } else {
            return tel.replaceAll("(\\d{2})(\\d{4})(\\d{4})", "($1) $2-$3");
        }
    }

    public TipoTelefone getTipo() {return tipo;}
}