package com.connection.databaseconnection.dataTreat;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListBuilder {

    private List<Object[]> listaDefault;
    private List<PostModel> listaOK;

    public ListBuilder(List<Object[]> lista) {
        this.listaDefault = lista;
        this.listaOK = new ArrayList<PostModel>();
    }

    public List<PostModel> formatList() {
        if (listaDefault != null) {
            for (int i = 0; i < listaDefault.size(); i++) {
                Object[] data = listaDefault.get(i);
                Long id = (Long) data[0];
                String conteudo = data[1].toString();
                String nome = data[2].toString();
                String imagem = data[3].toString();

                PostModel novoPost = new PostModel(id, nome, conteudo, imagem);

                listaOK.add(novoPost);
            }
            return listaOK;
        }
        return null;
    }
}

