import React from 'react'

export default prop => {

const card = prop.body.map( req => {


    return(
        <>
        <label className="label-name-know">{req.conhecimento}</label>
        <label className="label-type-interest">Tipo</label>
        <div className="div-know-inferior">
            <img className="box-img-interest" src={req.imagem} />
            <span className="desc-interest">{req.descricao}</span>
            <span className="type-interest">{req.tipo}</span>
        </div>
        </>
    )


})


return (
<div className="div-know-superior">{ card }</div>
)


}