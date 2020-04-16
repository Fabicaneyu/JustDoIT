package com.connection.databaseconnection.conhecimento;

import com.connection.databaseconnection.posts.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ConhecimentoService {

    @Autowired
    private ConhecimentoRepository repository;

    @Autowired
    private EntityManager entityManager;

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

    public List<Conhecimento> recomendados(){

        List<Conhecimento> result =
                entityManager.createQuery(
                        "select c from Conhecimento c order by c.id_conhecimento desc")
                .setMaxResults(4)
                .getResultList();

        if (result != null) {
            return result;
        }
        else {
            return null;
        }
    }


}