import React from 'react'



export default prop => {


    const divs = prop.body.map( post => {
    
        return (
            <>
            
           <div className="superior-post">
                     <h3 className="nome-post">{post.nome}</h3>
                     <h2 className="data-post">{"• "+ post.data + " •"}</h2>
                <div class="circle">                    
                    <img class="img-post" src={post.imagem}/>                    
                </div>                     
                    <div className="inferior-post">
                        <span className="conteudo-post">{post.conteudo}</span>
                    </div>

            </div>
          </>
        )
    })

    return(
        <div>{ divs }</div>
    )


}