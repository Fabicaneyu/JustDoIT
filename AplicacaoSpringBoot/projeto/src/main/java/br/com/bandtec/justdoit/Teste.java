package br.com.bandtec.justdoit;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Teste {

    @GetMapping
    public String beleza(){
        return "teste";
    }
}
