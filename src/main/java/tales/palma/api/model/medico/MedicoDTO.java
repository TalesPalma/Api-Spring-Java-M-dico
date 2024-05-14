package tales.palma.api.model.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import tales.palma.api.jpa.Medico;
import tales.palma.api.model.EnderecoDTO;

public record MedicoDTO(
        Long id,
        @NotBlank String nome,
        @NotBlank @Email String email,
        @NotBlank @Pattern(regexp = "\\d{4,6}") String crm,
        @NotNull ESPECIALIDADE especialidade,
        @NotNull String telefone,
        @NotNull @Valid EnderecoDTO endereco
) {

    public MedicoDTO(Medico medico) {
            this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(),medico.getEspecialidade(), medico.getTelefone(), medico.getEndereco());
    }

}
