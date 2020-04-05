import React from 'react'


export default prop => {


    const divs = prop.body.map( post => {
        return (

            <div className="Superior-post">
  
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