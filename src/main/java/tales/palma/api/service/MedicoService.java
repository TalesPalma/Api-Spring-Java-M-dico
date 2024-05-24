package tales.palma.api.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import tales.palma.api.jpa.Medico;
import tales.palma.api.model.medico.DTOUpdateMedico;
import tales.palma.api.model.medico.MedicoDTO;
import tales.palma.api.model.medico.MedicoRepository;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;


    public ResponseEntity<Page<MedicoDTO>> getAll(Pageable pageable) {
        Page<MedicoDTO> medicoPage = repository.findAll(pageable).map(MedicoDTO::new);
        return ResponseEntity.ok(medicoPage);
    }


    public ResponseEntity<MedicoDTO> registerMedico(MedicoDTO medico, UriComponentsBuilder uriBuilder) {
        if (repository.existsByEmail(medico.email())) {
            throw new RuntimeException("Email ja existente");
        } else {
            var newMedico = new Medico(medico);
            repository.save(newMedico);
            var uri = uriBuilder.path("/medico/{id}").buildAndExpand(newMedico.getId()).toUri();
            return ResponseEntity.created(uri).body(medico);
        }
    }

    public ResponseEntity<MedicoDTO> getById(Long id) {
        MedicoDTO medico = repository.findById(id).map(MedicoDTO::new).orElse(null);
        if (medico == null) {
            throw new EntityNotFoundException("Medico não encontrado");
        }
        return ResponseEntity.ok(medico);
    }


    public ResponseEntity<MedicoDTO> update(DTOUpdateMedico medicoUpdate) {
        var medico = repository.getReferenceById(medicoUpdate.id());
        MedicoDTO medicoAtt = medico.updateInfos(medicoUpdate);
        return ResponseEntity.ok(medicoAtt);
    }


    public ResponseEntity<Void> delete(Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}