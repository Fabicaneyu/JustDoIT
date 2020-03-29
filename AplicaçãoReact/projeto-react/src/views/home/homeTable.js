import React from 'react'
import PostField from './post-field'

export default function HomeTable() {

    const posts = [
        {
        nome: 'Cassio',
        conteudo: 'Qualquer coisa'
        }
    ]


    return(
        <div className="Superior-post">
            <PostField Post={posts} />
        </div>
    )

}