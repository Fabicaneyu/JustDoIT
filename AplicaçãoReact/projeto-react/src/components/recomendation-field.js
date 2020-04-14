import React from 'react'


export default prop => {


const corpo = prop.body.map( req => {
    
    return(

         <div className="box-recomedation">

                    <div className="text-box">                        
                        <h2 className="text-content">{req.conhecimento}</h2>
                        <h2 className="text-recomendation">{req.descricao}</h2>
                    </div>
                    <img className="box-img" src={req.imagem}/>
                                   
         </div>

    )
})


    return (
        <div className="div-recomendation">
            <div className="div-rec-title">Conteúdos recomendados para <b>você</b>
            </div>{ corpo }</div>
    )
}
