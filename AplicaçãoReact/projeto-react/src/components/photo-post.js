import React from 'react'
import axios from 'axios'

export default function ImagePost() {

    let photo;

    function busca() {
        axios.get("http://localhost:8080/user/photo")
            .then(response => {

                photo = response.data
                console.log("tipo de dado " + typeof photo);
                console.log(photo);
                

                let testeImage = document.querySelector("#teste");
                testeImage.src = photo;

            }).catch(erro => {
                console.log(erro)
            })
    }


    return (
        busca(),
        <img id="teste" className="img-post" src="" />

    )

}
