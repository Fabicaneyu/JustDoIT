package com.connection.databaseconnection.iterators;

import com.connection.databaseconnection.adapters.PostModel;
import com.connection.databaseconnection.associative.reacoes.ReacoesService;
import com.connection.databaseconnection.usuario.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

public class PostBuilder implements Iterator {

    private List<Object[]> listaDefault;

    private Integer reacao, all;

    @Autowired
    private UserController userController;

    @Autowired
    private ReacoesService reacoesController;


    public PostBuilder(List<Object[]> lista, Integer reacao, Integer all) {
        this.listaDefault = lista;
        this.reacao = reacao;
        this.all = all;
    }

    public boolean hasNext() {

        if(listaDefault.isEmpty()) {
            return false;
        }
        return true;
    }

    public PostModel nextList() {

        if (listaDefault != null) {
            for (int i = 0; i < listaDefault.size(); i++) {
                Object[] data = listaDefault.get(i);
                Integer id = (Integer) data[0];
                String conteudo = data[1].toString();
                String nome = data[2].toString();
                String date = data[3].toString();
                String imagem = data[4].toString();
                Integer id_user = (Integer) data[5];

                PostModel novo = new PostModel(id,id_user,this.reacao, this.all,nome, conteudo, imagem, date);
                return novo ;

            }

        }
        return null;
    }
}

