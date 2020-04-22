import React from 'react'


export default prop => {


    const corpo = prop.body.map(req => {

        return (
            <div className="box standard-recomandation itens-rec">

                <div className="row row-anulled">
                    <div className="col-md-4 img-box">
                        <img className="imgRecomandation" src={req.imagem}/>
                    </div>

                    <div className="col-md-8 anulled">
                        <div className="title-recomandation"> 
                            {req.conhecimento}
                        </div>

                        <div className="text-recomandation">
                            {req.descricao}
                        </div>
                    </div>
                </div>
            </div>

        )
    })


    return (

        <div className="col-md-2">
            <div className="user-recomandation">
                <div className="first box">
                    Conteúdo remendados para <b>você</b>
                </div>
                { corpo }



            </div>
        </div>


    )
}
