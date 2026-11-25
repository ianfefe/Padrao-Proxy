import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PacienteProxyTest {

    @BeforeEach
    void setUp() {
        BD.addPaciente(new Paciente(1, "Carlos", "Unimed", "Hipertensão", "Diabetes tipo 2"));
        BD.addPaciente(new Paciente(2, "Fernanda", "Particular", "Enxaqueca", "Rinite alérgica"));
    }

    @Test
    void deveRetornarDadosCadastraisPaciente() {
        PacienteProxy paciente = new PacienteProxy(1);

        assertEquals(Arrays.asList("Carlos", "Unimed"), paciente.obterDadosCadastrais());
    }

    @Test
    void deveRetornarDiagnosticosPaciente() {
        Profissional medico = new Profissional("Dr. Roberto", true);
        PacienteProxy paciente = new PacienteProxy(2);

        assertEquals(Arrays.asList("Enxaqueca", "Rinite alérgica"), paciente.obterDiagnosticos(medico));
    }

    @Test
    void deveRetornarExcecaoProfissionalNaoAutorizadoConsultarDiagnosticos() {
        try {
            Profissional recepcionista = new Profissional("Juliana", false);
            PacienteProxy paciente = new PacienteProxy(2);

            paciente.obterDiagnosticos(recepcionista);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Profissional não autorizado", e.getMessage());
        }
    }
}
