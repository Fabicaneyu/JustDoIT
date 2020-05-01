import React from 'react'
import Delete from '../imagens/delete.svg'
import axios from 'axios'

export default prop => {

const card = prop.body.map( req => {

    function deletar() {
        axios.delete(`http://localhost:8080/conhecimentos/remover/conhecimento/${req.id}`)
        .then(response => {
            console.log("Deletado com sucesso")
        }).catch(erro => {
            console.log(erro.data)
        })
   
}

    return(
        <>
        <label className="label-name-know">{req.conhecimento}</label>
        <label className="label-type-know">Tipo</label>
        <label className="label-level-know">Nível</label>
        <div className="div-know-inferior">
        <img className="box-img-know" src={req.imagem} />
            <div className="desc-know">{req.descricao_user}</div>   
            <span className="level-know">{req.nivel}</span>         
            <img onClick={deletar} className="delete-know" src={Delete} />  
            <div className="type-know">{req.tipoConhecimento}</div>
   
            
        </div>
        </>
    )


})


return (
<div className="div-know-superior">{ card }</div>
)


}