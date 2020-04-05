package com.connection.databaseconnection.posts;

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

        last = result.get(result.size()-1).getId();

    }

    @Transactional
    List<Posts> loadFeed() {

        List<Posts> result;

        if (rangeAtual > 0) {
            result = entityManager.createQuery(
                    " select p from Posts p where p.id <= :range " +
                            "order by p.id desc " )
                    .setParameter("range", last )
                    .setMaxResults(5)
                    .getResultList();

            rangeAtual -= result.size();
            last = result.get(result.size()-1).getId();
            return result;
        }
        else {
            return null;
        }
    }

}