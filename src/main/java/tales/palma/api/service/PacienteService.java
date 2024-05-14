package tales.palma.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tales.palma.api.jpa.Paciente;
import tales.palma.api.model.paciente.PacienteDTO;
import tales.palma.api.model.paciente.PacienteRepository;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public List<PacienteDTO> getAll() {
        return repository.findAll().stream().map(PacienteDTO::new).toList();
    }

    public void registerPaciente(PacienteDTO paciente) {
        repository.save(new Paciente(paciente));
    }


}
