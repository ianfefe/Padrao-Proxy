import java.util.Arrays;
import java.util.List;

public class Paciente implements IPaciente {

    private Integer prontuario;
    private String nome;
    private String convenio;
    private String diagnostico1;
    private String diagnostico2;

    public Paciente(int prontuario) {
        this.prontuario = prontuario;
        Paciente objeto = BD.getPaciente(prontuario);
        this.nome = objeto.nome;
        this.convenio = objeto.convenio;
        this.diagnostico1 = objeto.diagnostico1;
        this.diagnostico2 = objeto.diagnostico2;
    }

    public Paciente(Integer prontuario, String nome, String convenio, String diagnostico1, String diagnostico2) {
        this.prontuario = prontuario;
        this.nome = nome;
        this.convenio = convenio;
        this.diagnostico1 = diagnostico1;
        this.diagnostico2 = diagnostico2;
    }

    public Integer getProntuario() {
        return prontuario;
    }

    @Override
    public List<String> obterDadosCadastrais() {
        return Arrays.asList(this.nome, this.convenio);
    }

    @Override
    public List<String> obterDiagnosticos(Profissional profissional) {
        return Arrays.asList(this.diagnostico1, this.diagnostico2);
    }
}
