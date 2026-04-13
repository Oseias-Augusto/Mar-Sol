package MarSol.Entidades;

import java.time.LocalDateTime;

public class Corrida {

    public enum StatusCorrida {
        AGUARDANDO_VR,
        AGUARDANDO_AVISO,
        AVISO_EFETUADO,
        TRIPULADO,
        CANCELADO_PASSAGEIRO,
        CANCELADO_COOPERATIVA
    }

    private Cliente cliente;
    private Endereco enderecoSaida;
    private String bairroDestino;
    private LocalDateTime dataHoraSaida;
    private Telefone telefoneContato;
    private int numeroVR;
    private StatusCorrida status;

    public Corrida(Cliente cliente, Endereco enderecoSaida,
                   String bairroDestino, LocalDateTime dataHoraSaida,
                   Telefone telefoneContato) {

        this.cliente = cliente;
        this.enderecoSaida = enderecoSaida;
        this.bairroDestino = bairroDestino;
        this.dataHoraSaida = dataHoraSaida;
        this.telefoneContato = telefoneContato;
        this.status = StatusCorrida.AGUARDANDO_VR;
    }

    public void atribuirVR(int vr) {
        this.numeroVR = vr;
    }

    public void prepararAviso() {
        if (numeroVR == 0) throw new IllegalStateException("Sem VR");
        this.status = StatusCorrida.AGUARDANDO_AVISO;
    }

    public void avisar() {
        if (status != StatusCorrida.AGUARDANDO_AVISO) {
            throw new IllegalStateException("Estado inválido");
        }
        this.status = StatusCorrida.AVISO_EFETUADO;
    }

    public void iniciar() {
        this.status = StatusCorrida.TRIPULADO;
    }

    public void cancelarPassageiro() {
        this.status = StatusCorrida.CANCELADO_PASSAGEIRO;
    }

    public void cancelarCooperativa() {
        this.status = StatusCorrida.CANCELADO_COOPERATIVA;
    }

    public StatusCorrida getStatus() { return status; }
    public Endereco getEnderecoSaida() { return enderecoSaida; }

    public Cliente getCliente () {return this.cliente;}

    public String getBairroDestino () { return this.bairroDestino; }

    public LocalDateTime getDataHoraSaida () { return this.dataHoraSaida; }

    public Telefone getTelefoneContato () { return this.telefoneContato; }

}