package com.connection.databaseconnection.usuario;

import com.connection.databaseconnection.exception.ErroAutenticacao;
import com.connection.databaseconnection.exception.RegraException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository repository;

    public UserService(UsuarioRepository repository) {
        super();
        this.repository = repository;
    }

    @Transactional
    public Usuario salvarUsuario(Usuario usuario) {
        validarNovoEmail(usuario.getEmail());
        repository.save(usuario);
        return usuario;
    }


    public void validarNovoEmail(String email) {
        boolean existe = repository.existsByEmail(email);

        if (existe) {
            throw new RegraException("Já existe um usuário cadastrado com este e-mail!");
        }
    }


//    public boolean validarEmail(String email) {
//
//        boolean existe = repository.existsByEmail(email);
//
//        if (existe) {
//            return true;
//        }
//        else {
//            return false;
//        }
//    }
//
//    public boolean validarSenha(String senha) {
//
//        boolean existe = repository.existsBySenha(senha);
//
//        if (existe) {
//            return true;
//        }
//        else {
//            return false;
//        }
//    }

    public Usuario autenticar(String email, String senha) {

        Usuario usuario = repository.findByEmail(email);

        if (usuario == null) {
            throw new ErroAutenticacao("Usuário não encontrado");
        }

        if (!usuario.getSenha().equals(senha)) {
            throw new ErroAutenticacao("Senha inválida");
        }

        return usuario;

    }
    public void validarSenhas(String senha , String senhaConfirma) {


        if (!senhaConfirma.equals(senha)) {
            throw new RegraException("Senhas não estão iguais");
        }
    }


    }







