package com.connection.databaseconnection.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{

   // Optional<Usuario> findByEmail(String email);
    //para criar um metodo "findBy<alguma-coisa>", o parametro tem que ser um atributo da classe User

    boolean existsByEmail(String email);

    User findByEmail(String email);

    User findByIdUser(Integer id);

    User findByNome(String nome);

    boolean existsBySenha(String senha);

}
