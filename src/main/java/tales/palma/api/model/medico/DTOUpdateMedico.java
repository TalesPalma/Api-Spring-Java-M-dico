package tales.palma.api.model.medico;

import jakarta.validation.constraints.NotNull;
import tales.palma.api.model.EnderecoDTO;


public record DTOUpdateMedico(
        @NotNull Long id,
        String telefone,
        String nome,
        EnderecoDTO edendereco,
        String email
) {

}
