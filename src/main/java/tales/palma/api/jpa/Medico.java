package tales.palma.api.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tales.palma.api.model.ESPECIALIDADE;
import tales.palma.api.model.EnderecoDTO;
import tales.palma.api.model.MedicoDTO;


@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private ESPECIALIDADE especialidade;

    @Embedded
    private EnderecoDTO endereco;

    public Medico(MedicoDTO medico) {
        this.nome = medico.nome();
        this.email = medico.email();
        this.crm = medico.crm();
        this.especialidade = medico.especialidade();
        this.endereco = medico.endereco();
    }

}
