package tales.palma.api.service;

import org.springframework.stereotype.Service;
import tales.palma.api.model.Pessoa;

import java.util.List;

@Service
public class Hello {
    public List<Pessoa> helloWord() {
        List<Pessoa> lista = List.of(
                new Pessoa("tales", "tales@tales", "123"),
                new Pessoa("tales", "tales@tales", "123"),
                new Pessoa("tales", "tales@tales", "123")
        );
        return lista;
    }
}
