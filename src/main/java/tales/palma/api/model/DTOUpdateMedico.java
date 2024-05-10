package tales.palma.api.model;

import jakarta.validation.constraints.NotNull;


public record DTOUpdateMedico(
        @NotNull Long id,
        String telefone,
        EnderecoDTO edendereco,
        String email
) {

}
