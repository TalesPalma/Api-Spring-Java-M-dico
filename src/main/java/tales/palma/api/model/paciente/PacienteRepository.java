package tales.palma.api.model.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import tales.palma.api.jpa.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}
