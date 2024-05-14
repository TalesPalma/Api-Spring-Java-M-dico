package tales.palma.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tales.palma.api.model.paciente.PacienteDTO;
import tales.palma.api.service.PacienteService;

import java.util.List;


@RestController
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping
    public List<PacienteDTO> getAll(){
        return service.getAll();
    }


    @PostMapping
    @Transactional
    public void postPacienteDTO( @RequestBody PacienteDTO pacienteDTO) {
        service.registerPaciente(pacienteDTO);
    }



}
