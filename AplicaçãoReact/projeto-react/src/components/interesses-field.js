import React from 'react'
import Delete from '../imagens/delete.svg'
import axios from 'axios'

export default prop => {



const card = prop.body.map( req => {
    
 function deletar() {
        axios.delete(`http://localhost:8080/conhecimentos/remover/interesse/${req.id}`)
        .then(response => {
            console.log("Deletado com sucesso")
            window.location.reload();
        }).catch(erro => {
            console.log(erro.data)
        })
    
}

    return(
        <>
        <label className="label-name-know">{req.conhecimento}</label>
        <label className="label-type-interest">Tipo</label>
        <div className="div-know-inferior">
        <div className="desc-interest">{req.descricao_interesse}</div>
        <img onClick={deletar} className="delete-interest" src={Delete} />  
        <div className="type-interest">{req.tipoConhecimento}</div>        
            <img className="box-img-interest" src={req.imagem} />                                    
        </div>
        </>
    )


})


return (
<div className="div-know-superior">{ card }</div>
)


}