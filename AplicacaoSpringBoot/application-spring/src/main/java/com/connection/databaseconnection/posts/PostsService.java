package com.connection.databaseconnection.posts;

import com.connection.databaseconnection.dataTreat.ListBuilder;
import com.connection.databaseconnection.dataTreat.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class PostsService {

    @Autowired
    private PostsRepository repository;

    @Autowired
    private EntityManager entityManager;

    private Long rangeAtual;

    private Long last;

    boolean first;


    @Transactional
    Posts novoPost(Posts post){
        repository.save(post);
        return post;
    }

    @Transactional
    public void setFirst() {
        List<Long> count = entityManager.createQuery(
                "select count(*) from Posts ")
                .getResultList();

        rangeAtual = count.get(0);

        List<Posts> result = entityManager.createQuery(
                "select p from Posts p order by p.id desc ")
                .setMaxResults(1)
                .getResultList();

        last = result.get(0).getId();

        first = true;

    }

    @Transactional
    List<PostModel> loadFeed() {

        List<Object[]>  result;
        List<PostModel> resultFinal;

        if (rangeAtual > 0) {
            if (first) {
                result = entityManager.createQuery(
                        "select p.id, p.conteudo, u.nome, u.photo from Posts p inner join" +
                                " p.usuario as u where p.id <= :range order by p.id desc ")
                        .setParameter("range", last)
                        .setMaxResults(5)
                        .getResultList();

                resultFinal = dataBuilder(result);

                rangeAtual -= resultFinal.size();

                last = resultFinal.get(resultFinal.size()-1).getId();

                this.first = false;

            } else {
                result = entityManager.createQuery(
                        "select p.id, p.conteudo, u.nome, u.photo from Posts p inner join" +
                                " p.usuario as u where p.id < :range order by p.id desc ")
                        .setParameter("range", last)
                        .setMaxResults(5)
                        .getResultList();

                resultFinal = dataBuilder(result);

                rangeAtual -= resultFinal.size();

                last = resultFinal.get(resultFinal.size()-1).getId();

            }
            return resultFinal;
        }
        else {
            return null;
        }
    }

    public List<PostModel> dataBuilder(List<Object[]> lista) {

        List<PostModel> result;

        ListBuilder builder = new ListBuilder(lista);

        result = builder.formatList();

        return result;
    }



}