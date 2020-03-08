package com.connection.databaseconnection;

public interface UsuarioServico {

    Usuario autenticar(String email, String senha);

    Usuario atribuirId(Usuario usuario);

    void validarEmail(String emiail);


}
