package tales.palma.api.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tales.palma.api.model.DTOUpdateMedico;
import tales.palma.api.model.MedicoDTO;
import tales.palma.api.service.MedicoService;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;

@RestController
@RequestMapping("medico")
public class MedicoController {

    @Autowired
    private MedicoService service;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid MedicoDTO medico) {
        try {
            service.registerMedico(medico);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public Page<MedicoDTO> getAll(Pageable pageable) {
        return service.getAll(pageable);
    }

    @GetMapping("/{id}")
    public MedicoDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DTOUpdateMedico medico) {
        System.out.println(medico);
        service.update(medico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        if(id != null){
            service.delete(id);
        }else{
            throw new RuntimeException("Id inválido");
        }
    }

}
