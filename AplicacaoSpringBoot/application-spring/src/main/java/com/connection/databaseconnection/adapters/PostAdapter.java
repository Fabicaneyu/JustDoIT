package com.connection.databaseconnection.adapters;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter {

    List<PostModel> listAdapt;

    public PostAdapter() {
        this.listAdapt = new ArrayList<PostModel>();
    }

    public void setModel(Long id, String nome, String conteudo, String date, String imagem) {

        PostModel newPost = new PostModel(id, nome, conteudo, date, imagem);

        listAdapt.add(newPost);

    }

    public List<PostModel> getModel() {
        if(listAdapt.isEmpty()) {
            return null;
        }
        else {
            return listAdapt;
        }
    }

}
