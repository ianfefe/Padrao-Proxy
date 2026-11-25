import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<Integer, Paciente> pacientes = new HashMap<>();

    public static Paciente getPaciente(Integer prontuario) {
        return pacientes.get(prontuario);
    }

    public static void addPaciente(Paciente paciente) {
        pacientes.put(paciente.getProntuario(), paciente);
    }
}
