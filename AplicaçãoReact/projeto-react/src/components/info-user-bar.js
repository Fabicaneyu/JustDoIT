import React from 'react'
import Foto from '../imagens/circulo.png'

function UserInfo(prop) {

    return(

            <div className="div-user-info">
                <img className="img-perf" src={Foto}/>
                <h2 className="user-info" >{prop.label}</h2>
            </div>

    )

}
export default UserInfo


