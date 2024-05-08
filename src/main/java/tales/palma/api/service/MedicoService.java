package tales.palma.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tales.palma.api.jpa.Medico;
import tales.palma.api.model.MedicoDTO;
import tales.palma.api.model.MedicoRepository;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;


    public List<MedicoDTO> getAll() {
        return repository.findAll().stream().map(MedicoDTO::new).toList();
    }


    public void registerMedico(MedicoDTO medico) {
        repository.save(new Medico(medico));
    }

}