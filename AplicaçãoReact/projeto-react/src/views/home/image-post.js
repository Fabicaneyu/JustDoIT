import React from 'react'
import axios from 'axios'
import { useEffect } from 'react';

function ImagePost (prop) {


    function busca(id) {
        let imagem = "";
        axios.get(`http://localhost:8080/user/photo/${id}`)
        .then(response => {
             imagem = response.data
             console.log(imagem)
         }).catch(erro => {
             console.log(erro)
        })
        return imagem;
    }

 

    return (
        
        <img src={busca(prop.id_user)} className="img-post" />
       
    )

}

export default ImagePost
