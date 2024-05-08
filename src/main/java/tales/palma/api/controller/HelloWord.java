package tales.palma.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tales.palma.api.model.Pessoa;
import tales.palma.api.service.Hello;

import java.util.List;

@RestController
public class HelloWord {

    private Hello hello = new Hello();


    @GetMapping("/hello")
    public List<Pessoa> HelloWord() {
        return hello.helloWord();
    }
}
