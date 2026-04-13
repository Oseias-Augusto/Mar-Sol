package MarSol.Controller;

import java.time.LocalDateTime;
import java.util.List;

import MarSol.Entidades.Cliente;
import MarSol.Entidades.Corrida;
import MarSol.Entidades.Endereco;
import MarSol.Entidades.Telefone;
import MarSol.Services.CorridaService;

public class CorridaController {

    private CorridaService service;

    public CorridaController(CorridaService service) {
        this.service = service;
    }

    public Corrida solicitarCorrida(Cliente cliente,
                                    Endereco endereco,
                                    String destino,
                                    LocalDateTime dataHora,
                                    Telefone telefone) {

        return service.solicitarCorrida(cliente, endereco, destino, dataHora, telefone);
    }

    public void atribuirVR(Corrida corrida, int vr) {
        service.atribuirVR(corrida, vr);
    }

    public void prepararAviso(Corrida corrida) {
        service.prepararAviso(corrida);
    }

    public void avisar(Corrida corrida) {
        service.avisarCliente(corrida);
    }

    public void iniciar(Corrida corrida) {
        service.iniciarCorrida(corrida);
    }

    public void cancelarPassageiro(Corrida corrida) {
        service.cancelarPorPassageiro(corrida);
    }

    public void cancelarCooperativa(Corrida corrida) {
        service.cancelarPorCooperativa(corrida);
    }

    public List<Corrida> listar() {
        return service.listarCorridas();
    }
}