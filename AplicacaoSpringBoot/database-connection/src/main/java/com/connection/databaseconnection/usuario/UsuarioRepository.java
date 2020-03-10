package com.connection.databaseconnection.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{

   // Optional<Usuario> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsBySenha(String senha);

}
