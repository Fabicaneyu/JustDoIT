import React from 'react'
import Home from '../views/home/home'
import axios from 'axios'

export default function PhotoPost() {



const buscaPhoto = ()  => {

    axios.get('http://localhost:8080/user/photo')
    .then( response => {
        console.log("foi");
        console.log(response.data)
      
        return response.data;

        
    }).catch( erro => {
        console.log(erro)
    })

}

console.log(buscaPhoto());

    return(

        <img src={buscaPhoto()}/>
    

    )

}