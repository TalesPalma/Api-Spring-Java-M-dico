package tales.palma.api.model;


import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class EnderecoDTO {
   @NotBlank @Pattern(regexp = "\\d{5}-\\d{3}")
   private String cep;
   @NotBlank
    private String logradouro;
   @NotBlank
    private String bairro;
   @NotBlank
    private String localidade;
   @NotBlank
    private String uf;
}
