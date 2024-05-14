package tales.palma.api.model.paciente;


import tales.palma.api.jpa.Paciente;

public record PacienteDTO(
        Long id,
        String nome,
        String email,
        String logradouro,
        String bairro,
        String cep,
        String localidade,
        String uf
) {

    public PacienteDTO(Paciente paciente) {
        this(
                paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getLogradouro(),
                paciente.getBairro(),
                paciente.getCep(),
                paciente.getLocalidade(),
                paciente.getUf()
        );
    }

}
