package MarSol.Services;
import java.util.*;

public class LogradouroService {

    private Set<String> logradouros;

    public LogradouroService(Set<String> logradouros) {
        this.logradouros = logradouros;
    }

    public void adicionar(String logradouro) {
        logradouros.add(logradouro);
    }

    public boolean existe(String logradouro) {
        return logradouros.contains(logradouro);
    }

    public Set<String> listar() {
        return logradouros;
    }
}