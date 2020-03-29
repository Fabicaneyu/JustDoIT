package com.connection.databaseconnection.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query(value = " from Posts p order by p.id desc ")
    List<Posts>obterTodos();

}
