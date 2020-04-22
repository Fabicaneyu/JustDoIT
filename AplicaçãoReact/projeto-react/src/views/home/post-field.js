import React from 'react'
import Inovador from '../../imagens/comece.svg'
import Interessante from '../../imagens/conhecimento.svg'
import Compartilhar from '../../imagens/compartilhar.svg'
import Graticao from '../../imagens/graticao.svg'



export default prop => {


    const divs = prop.body.map( post => {
    
        return (
            <>
            
            {/*DataHora do banco ---->>> <h2 classNameName="data-post">{"• "+ post.data + " •"}</h2> */}
                  <div className="row">
                        <div className="post-field">
                            <div className="row">
                                <div className="col-md-10">
                                    <div className="row">
                                        <div className="photo-postField">
                                            <img className="img-user-menu" src={post.imagem} />
                                        </div>
                                        <div className="userPost-name">
                                            <div className="username"> {post.nome} </div>
                                            <div className="carrerJob-user user-text">Ocupação-: Back-end Developer</div>
                                            <div className="carrerCollege-user user-text">Estudou(a)-: Bandtec</div>
                                        </div>
                                    </div>
                                </div>
                                <div className="tag col-md-2">
                                    <span className="tag-size">Tags:</span><a className="tags-reference" href="">#Java
                                        #Database</a>
                                </div>
                            </div>
                            <div className="content-field">
                                {post.conteudo}
                            </div>
                            <div className="row anulled">
                                <div className="icon-value col-md-10">
                                    <span className="size-around">
                                        <span className="score-style">
                                            <img src={Interessante}/>
                                        </span>
                                    
                                        Interessante</span>
                                      
                            
                                    
                                    <span className="size-around">
                                        <span className="score-style">
                                            <img src={Graticao} />
                                        </span>Gratidão</span>
                                  
                                  
                                  
                                        <span className="size-around">
                                            <span className="score-style">
                                            <img src={Inovador}/>
                                            </span>Inovador</span>
                                    
                                </div>
                                <div className="icon-value  col-md-2">
                                    <span className="share-icon">
                                        <img src={Compartilhar} />
                                    </span>
                                    compartilhar
                                </div>

                            </div>
                            
                        </div>
                    </div>
          </>
        )
    })

    return(
        <div>{ divs }</div>
    )


}