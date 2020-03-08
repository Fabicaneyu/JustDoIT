package com.connection.databaseconnection;

import org.springframework.stereotype.Service;

@Service
public class UserController implements UsuarioServico {

    private UsuarioRepository repository;

    public UserController(UsuarioRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public Usuario autenticar(String email, String senha) {
//        Optional<Usuario> usuario = repository.findByEmail(email);
//
//        if(!usuario.isPresent()) {
//            throw  new ErroAutenticacao("Usuário não encontrado!");
//        }
//        if(!usuario.get().getSenha().equals(senha)) {
//            throw  new ErroAutenticacao("Senha inválida!");
//        }
//        return usuario.get();
        return null;
    }

    @Override
    public Usuario atribuirId(Usuario usuario) {
        return null;
    }

    @Override
    public void validarEmail(String email) {

        boolean existe = repository.existsByEmail(email);
        if (existe) {
            throw new RegraException("Já existe um usuário com este e-mail");


        }
    }
}
