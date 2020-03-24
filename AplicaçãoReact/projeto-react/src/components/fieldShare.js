import React from 'react'

class ShareCard extends React.Component {

    render(prop){
    return(
        <>
        <div className="divShare-one">
            <input className="inputShare-one" placeholder="      algo que queira Compartilhar ?" />
        </div>

        <div className="divShare-two">
             <input className="inputShare-two" placeholder="      algum Conteúdo ?" />
        </div>
        </>    
    )

    }
}

export default ShareCard
