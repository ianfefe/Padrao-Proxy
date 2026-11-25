import java.util.List;

public class PacienteProxy implements IPaciente {

    private Paciente paciente;

    private Integer prontuario;

    public PacienteProxy(Integer prontuario) {
        this.prontuario = prontuario;
    }

    @Override
    public List<String> obterDadosCadastrais() {
        if (this.paciente == null) {
            this.paciente = new Paciente(this.prontuario);
        }
        return this.paciente.obterDadosCadastrais();
    }

    @Override
    public List<String> obterDiagnosticos(Profissional profissional) {
        if (!profissional.isMedico()) {
            throw new IllegalArgumentException("Profissional não autorizado");
        }
        if (this.paciente == null) {
            this.paciente = new Paciente(this.prontuario);
        }
        return this.paciente.obterDiagnosticos(profissional);
    }
}
