import React from 'react'

import axios from 'axios'
import Home from './home'
import ImagePost from '../../components/photo-post'

export default prop => {


    const divs = prop.body.map( post => {
    
        return (

            <div className="Superior-post">

                <ImagePost />
                <h3 className="Nome-post">{post.nome_user}</h3>

                <div className="Inferior-post">
                        <span className="Conteudo-post">{post.conteudo}</span>
                </div>

        </div>

        )
    })

    return(
        <div>{ divs }</div>
    )


}