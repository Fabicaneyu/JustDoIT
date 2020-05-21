import React from 'react'
import Inovador from '../../imagens/comece.svg'
import Interessante from '../../imagens/conhecimento.svg'
import Compartilhar from '../../imagens/compartilhar.svg'
import Gratidao from '../../imagens/graticao.svg'
import axios from 'axios'



export default prop => {
    

    const divs = prop.body.map( post => {


        // function like(val) {
           
        //     if(liked) {
        //         console.log('já curtido')
        //         setLiked(false)
        //     }else{
        //         prop.action(val)
        //         setLiked(true)
        //     }
        // }
    
        return (
            <>
            
            {/*DataHora do banco ---->>> <h2 classNameName="data-post">{"• "+ post.data + " •"}</h2> */}
                  <div className="row">
                        <div className="post-field">
                            <div className="row">
                                <div className="col-md-10">
                                    <div className="row">
                                        <div className="photo-postField">
                                            <img className="img-user-menu" src={post.imagem} alt="img-user" />
                                        </div>
                                        <div className="userPost-name">
                                            <div onClick={e => prop.view(post.id_user)} className="username"> {post.nome} </div>
                                            <div className="carrerJob-user user-text">Ocupação-: Back-end Developer</div>
                                            <div className="carrerCollege-user user-text">Estudou(a)-: Bandtec</div>
                                        </div>
                                    </div>
                                </div>
                                <div className="tag col-md-2">
                                    <span className="tag-size">Tags:</span><a className="tags-reference">#Java
                                        #Database</a>
                                </div>
                            </div>
                            <div className="content-field">
                                {post.conteudo}
                            </div>
                            <div className="row anulled">
                           
                                <div className="icon-value col-md-10">    
                                <span className="interessante-counter">• {post.total}</span>                                
                                    <div className="react-box-one">
                                        <span className={post.reacao == 1 ? 'size-liked':'size-around'} id={post.id+"interesting"}
                                        onClick={e =>prop.action(post.id,"interesting")}>                                        
                                            
                                            Interessante</span>
                                            <span className="score-style-light">
                                                <img src={Interessante} alt="interessante" />
                                            </span >
                                            
                                     </div>                                    
                                     <div className="react-box-two">                                                          
                                            <span className={post.reacao == 2 ? 'size-liked':'size-around'} id={post.id+"gratefull"}
                                            onClick={e =>prop.action(post.id,"gratefull")}>
                                               Gratidão</span>

                                               <span className="score-style">
                                                    <img src={Gratidao} alt="gratidao" />
                                                </span>
                                      </div>   
                                  
                                     <div className="react-box-three">  
                                        <span className={post.reacao == 3 ? 'size-liked':'size-around'} id={post.id+"inovated"}
                                        onClick={e =>prop.action(post.id,"inovated")}>
                                            Inovador</span>

                                            <span className="score-style">
                                            <img src={Inovador} alt="inovador"/>
                                            </span>
                                     </div> 
                                </div>
                           
                                <div className="icon-value  col-md-2">
                                    <div className="share-icon">                                        
                                        compartilhar
                                    </div>  
                                    <img className="icon-share" src={Compartilhar} alt="share" />                                 
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