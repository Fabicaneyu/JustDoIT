package com.connection.databaseconnection.iterators;

import com.connection.databaseconnection.adapters.PostAdapter;
import com.connection.databaseconnection.adapters.PostModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListBuilder implements Iterator {

    private List<Object[]> listaDefault;
    private PostAdapter postAdapter;

    public ListBuilder(List<Object[]> lista) {
        this.listaDefault = lista;
        this.postAdapter = new PostAdapter();
    }

    public boolean hasNext() {

        if(listaDefault.isEmpty()) {
            return false;
        }
        return true;
    }

    public List<PostModel> nextList() {
        if (listaDefault != null) {
            for (int i = 0; i < listaDefault.size(); i++) {
                Object[] data = listaDefault.get(i);
                Long id = (Long) data[0];
                String conteudo = data[1].toString();
                String nome = data[2].toString();
                String date = data[3].toString();
                String imagem = data[4].toString();

                postAdapter.setModel(id, nome, conteudo, date, imagem);

            }
            return postAdapter.getModel();
        }
        return null;
    }
}

