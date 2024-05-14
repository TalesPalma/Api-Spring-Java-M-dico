package tales.palma.api.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tales.palma.api.model.medico.DTOUpdateMedico;
import tales.palma.api.model.medico.ESPECIALIDADE;
import tales.palma.api.model.EnderecoDTO;
import tales.palma.api.model.medico.MedicoDTO;


@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Medico {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    public String telefone;
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
        this.telefone = medico.telefone();
    }

    public void updateInfos(DTOUpdateMedico medico) {
        if (medico.edendereco() != null) {
            this.endereco = medico.edendereco();
        } else if (medico.telefone() != null) {
            this.telefone = medico.telefone();
        } else if(medico.email() != null) {
            this.email = medico.email();
        }else{
            System.out.println("Nada a ser att");
        }
    }
}
