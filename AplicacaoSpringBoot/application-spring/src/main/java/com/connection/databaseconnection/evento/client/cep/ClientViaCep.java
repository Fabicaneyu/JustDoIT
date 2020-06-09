package com.connection.databaseconnection.evento.client.cep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
 A @FeignClient indica que a interface mapeará um CLIENTE de uma REST API
 o atributo 'value' é o nome da API para o Spring Boot
 o atributo 'url' é a URL base da API
 */
//@FeignClient(value = "viacep", url = "https://viacep.com.br")
public interface ClientViaCep {
// cada método nessa interface mapeia um endpoint na API

    /* Aqui estamos mapeando um endpoint que:
        - Responderá pelo verbo (ou método) GET (@GetMapping)
        - Acessível pela URI "/ws/{cep}/json" (note que há um path param, o {cep} )
        - A resposta do Endpoint, se tudo funcionar, será um JSON compatível com a classe Cep
          (porque o retorno do método é do tipo Cep)
     */
    @GetMapping("/ws/{cep}/json")
    Cep getCep(@PathVariable String cep);

    @GetMapping("/ws/{cep}/xml")
    Cep getCepXml(@PathVariable String cep);
}