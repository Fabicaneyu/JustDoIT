import React from 'react'
import axios from 'axios'

export default function ImagePost() {

    
    const data = ''


     function busca () {
     axios.get('http://localhost:8080/user/photo')
        .then( response => {
            console.log(response.data)
            const data = response.data
        }).catch( erro => {
            console.log(erro)
        })
    }


    return(

        <img className="img-post" onLoad={busca()} src={data}/>

    )

}
