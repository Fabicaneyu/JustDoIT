package com.connection.databaseconnection.teste;

import com.connection.databaseconnection.usuario.UserService;
import com.connection.databaseconnection.usuario.Usuario;
import com.connection.databaseconnection.usuario.UserRepository;
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
    UserRepository repository;

    @Autowired
    UserService controller;

    @Test
    public void verificaEmailTrue() {


        Usuario user = Usuario.builder().nome("usuario").email("usuario@email.com").build();

        repository.save(user);

        boolean result = repository.existsByEmail("usuario@email.com");

        Assertions.assertThat(result).isTrue();

//
////        boolean email = teste.validaEmail(e);
////
////        boolean senha = teste.validaSenha(s);
////
////        if (email && senha) {
////            System.out.println("Usuário autenticado com sucesso");
////        }
////        else {
////            System.out.println("Falha na autenticação");
////        }
//
//        boolean result = repository.existsByEmail(email);
//
//        if (result) {
//            return true;
//        }
//        else {
//            return false;
//        }


    }


    @Test
    public void verificaEmailFalse() {

        repository.deleteAll();

        boolean result = repository.existsByEmail("usuario@email.com");

        Assertions.assertThat(result).isFalse();


    }

    //usuario serviço
//    @Test(expected = RegraException.class)
//    public void lancaErro() {
//
//        Usuario usuario = Usuario.builder().nome("usuario").email("usuario@user").build();
//
//        repository.save(usuario);
//
//        controller.("usuario@user");
//
//
//    }



}


