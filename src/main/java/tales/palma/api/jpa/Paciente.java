package tales.palma.api.jpa;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tales.palma.api.model.paciente.PacienteDTO;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String logradouro;
    private String bairro;
    private String cep;
    private String localidade;
    private String uf;

    public Paciente(PacienteDTO paciente) {
        this.nome = paciente.nome();
        this.email = paciente.email();
        this.logradouro = paciente.logradouro();
        this.bairro = paciente.bairro();
        this.cep = paciente.cep();
        this.localidade = paciente.localidade();
        this.uf = paciente.uf();
    }


}
