package tales.palma.api.model;

import org.springframework.data.jpa.repository.JpaRepository;
import tales.palma.api.jpa.Medico;

public interface MedicoRepository extends JpaRepository<Medico,Long> {
    boolean existsByEmail(String email);
}
