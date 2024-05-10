package tales.palma.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tales.palma.api.jpa.Medico;
import tales.palma.api.model.DTOUpdateMedico;
import tales.palma.api.model.MedicoDTO;
import tales.palma.api.model.MedicoRepository;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;


    public Page<MedicoDTO> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(MedicoDTO::new);
    }


    public void registerMedico(MedicoDTO medico) {
        if (repository.existsByEmail(medico.email())) {
            throw new RuntimeException("Email ja existente");
        }else{
            repository.save(new Medico(medico));
        }
    }

    public MedicoDTO getById(Long id) {
        return repository.findById(id).map(MedicoDTO::new).orElse(null);
    }


    public void update(DTOUpdateMedico medicoUpdate) {
        var medico = repository.getReferenceById(medicoUpdate.id());
        medico.updateInfos(medicoUpdate);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }
}