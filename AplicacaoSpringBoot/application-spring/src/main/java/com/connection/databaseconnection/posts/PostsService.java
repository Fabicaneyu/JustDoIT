package com.connection.databaseconnection.posts;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PostsService {

    private PostsRepository repository;

    public PostsService(PostsRepository repository) {
        this.repository = repository;
    }

    @Transactional
    Posts novoPost(Posts post){
        repository.save(post);
        return post;
    }

    List<Posts> loadAll() {
        List<Posts> result = repository.findAll();

        return result;
    }


//    void apagar(Conhecimento conhecimento) {
//        return;
//    }




}