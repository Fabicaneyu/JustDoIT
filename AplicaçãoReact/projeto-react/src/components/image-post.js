import React from 'react'
import axios from 'axios'

export default function ImagePost() {

   const busca = () => {
        axios.get('http://localhost:8080/user/photo')
        .then( response => {
            console.log(response.data)
            return "teste123"
        }).catch( erro => {
            console.log(erro)
        })

}

    return(
        <div className="img-post" >
        <img src={busca()}/>
        </div>
    )

}