package tales.palma.api.model;

import tales.palma.api.jpa.Medico;

public record MedicoDTO(
        String nome,
        String email,
        String crm,
        ESPECIALIDADE especialidade,
        EnderecoDTO endereco
) {

    public MedicoDTO(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }

}
