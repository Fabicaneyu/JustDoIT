package com.connection.databaseconnection.conhecimento;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ConhecimentoService {

    private ConhecimentoRepository repository;

    public ConhecimentoService(ConhecimentoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    Conhecimento adicionarNovo(Conhecimento conhecimento){
        return repository.save(conhecimento);
    }

    Conhecimento atualizar(Conhecimento conhecimento) {
        return null;
    }

    void apagar(Conhecimento conhecimento) {
        return;
    }

    List<Conhecimento> buscar(Conhecimento conhecimento){
        return null;
    }



}
