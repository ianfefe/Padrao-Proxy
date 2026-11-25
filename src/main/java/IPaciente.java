import java.util.List;

public interface IPaciente {
    List<String> obterDadosCadastrais();
    List<String> obterDiagnosticos(Profissional profissional);
}
