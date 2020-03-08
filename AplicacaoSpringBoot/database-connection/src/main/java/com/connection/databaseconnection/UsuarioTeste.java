package com.connection.databaseconnection;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UsuarioTeste {

    @Autowired
    UsuarioRepository repository;

    @Test
    public void verificaEmailTrue() {


//        Usuario usuario  = Usuario.builder().nome("usuario").email("usuario@email.com").build();
//        repository.save(usuario);

        boolean result = repository.existsByEmail("usuario@email.com");

        Assertions.assertThat(result).isTrue();


    }
//
//    @Test
//    public void verificaEmailFalse() {
//
//
//
//        boolean result = repository.existsByEmail("usuario@email.com");
//
//        Assertions.assertThat(result).isFalse();
//
//
//    }

}
