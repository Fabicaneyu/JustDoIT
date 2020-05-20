package com.connection.databaseconnection.iterators;

import com.connection.databaseconnection.adapters.PostModel;
import com.connection.databaseconnection.associative.reacoes.ReacoesService;
import com.connection.databaseconnection.dto.ValidatorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReacaoValidator {

    private List<ValidatorDTO> lista ;

    @Autowired
    private ReacoesService service;

    public List build(List<PostModel> model) {
        for(int i =0 ; i< model.size(); i++) {
            Integer tipo = service.validarReacao(1, model.get(i).getId());
            ValidatorDTO novo = new ValidatorDTO(1, tipo);
            lista.add(novo);
        }
        return lista;
    }

    public void print(List<ValidatorDTO> lista) {

        for(ValidatorDTO v : lista) {
            System.out.println(v);
        }

    }

}
