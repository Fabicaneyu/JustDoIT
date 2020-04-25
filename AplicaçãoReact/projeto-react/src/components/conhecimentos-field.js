import React from 'react'

export default prop => {

const card = prop.body.map( req => {


    return(
        <>
        <label className="label-name-know">{req.conhecimento}</label>
        <label className="label-type-know">Tipo</label>
        <label className="label-level-know">Nivel</label>
        <div className="div-know-inferior">
            <img className="box-img-know" src={req.imagem} />
            <span className="desc-know">{req.descricao}</span>
            <span className="type-know">{req.tipo}</span>
            <span className="level-know">{req.nivel}</span>
        </div>
        </>
    )


})


return (
<div className="div-know-superior">{ card }</div>
)


}