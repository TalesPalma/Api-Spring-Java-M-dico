package tales.palma.api.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico,Long> {
    boolean existsByEmail(String email);
}
