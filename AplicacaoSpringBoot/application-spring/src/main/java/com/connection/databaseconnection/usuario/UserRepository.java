package com.connection.databaseconnection.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <Usuario, Long>{

   // Optional<Usuario> findByEmail(String email);
    //para criar um metodo "findBy<alguma-coisa>", o parametro tem que ser um atributo da classe User

    boolean existsByEmail(String email);

    Usuario findByEmail(String email);

    Usuario findByNome(String nome);

    boolean existsBySenha(String senha);

}
