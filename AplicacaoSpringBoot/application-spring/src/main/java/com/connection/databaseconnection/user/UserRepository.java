package com.connection.databaseconnection.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository <Usuario, Long>{

   // Optional<Usuario> findByEmail(String email);
    //para criar um metodo "findBy<alguma-coisa>", o parametro tem que ser um atributo da classe User

    boolean existsByEmail(String email);

    Usuario findByEmail(String email);

    Usuario findByNome(String nome);

    boolean existsBySenha(String senha);

}
