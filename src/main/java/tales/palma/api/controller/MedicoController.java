package tales.palma.api.controller;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tales.palma.api.jpa.Medico;
import tales.palma.api.model.MedicoDTO;
import tales.palma.api.model.MedicoRepository;
import tales.palma.api.service.MedicoService;

import java.util.List;

@RestController
@RequestMapping("medico")
public class MedicoController {

    @Autowired
    private MedicoService service;

    @PostMapping
    @Transactional
    public void register(@RequestBody MedicoDTO medico) {
        service.registerMedico(medico);
    }

    @GetMapping
    public List<MedicoDTO> getAll() {
        return service.getAll();
    }


}
