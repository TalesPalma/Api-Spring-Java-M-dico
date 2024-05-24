package tales.palma.api.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tales.palma.api.model.medico.DTOUpdateMedico;
import tales.palma.api.model.medico.MedicoDTO;
import tales.palma.api.service.MedicoService;

@RestController
@RequestMapping("medico")
public class MedicoController {

    @Autowired
    private MedicoService service;

    @PostMapping
    @Transactional
    public ResponseEntity<MedicoDTO> register(@RequestBody @Valid MedicoDTO medico, UriComponentsBuilder uriBuilder) {
        try {
            return service.registerMedico(medico, uriBuilder);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public ResponseEntity<Page<MedicoDTO>> getAll(Pageable pageable) {
        return service.getAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<MedicoDTO> update(@RequestBody @Valid DTOUpdateMedico medico) {
        System.out.println(medico);
        return service.update(medico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (id != null) {
            return service.delete(id);
        } else {
            throw new RuntimeException("Id inválido");
        }
    }

}
