import React from 'react'
import NavbarItem from './navbar-Item'
import Busca from './busca'
import Logo from '../imagens/logo_v.2.png'
import Home from '../imagens/home.svg'
import Evento from '../imagens/evento.svg'
import Brain from '../imagens/brain.svg'
import Exit from '../imagens/sair.svg'

function Navbar (prop) {

    return(

        <div className="navbar navbar-expand-lg fixed-top navbar-dark bg-primary" >

      <img src={Logo} className="navbar-brand"/> 
        <div className="container">
          <button className="navbar-toggler" type="button" data-toggle="collapse"
           data-target="#navbarResponsive" aria-controls="navbarResponsive"
            aria-expanded="false"aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <Busca/>
          <div className="collapse navbar-collapse" id="navbarResponsive">
            <ul className="navbar-nav">
            
  
                <NavbarItem action={prop.executeHome} href="#/home" image={Home} classN="svg-item-home" label="Home" />
                <NavbarItem action={prop.executePerfil} href="#/perfil" image={Brain} classN="svg-item-brain" label="Perfil" />
                <NavbarItem action={prop.executeEventos} href="#/cadastrarEvento" image={Evento} classN="svg-item-event" label="Eventos" />
                <NavbarItem action={prop.executeSair} href="#/login" image={Exit} classN="svg-item-out" label="Sair" />
          </ul>
          </div>         
        </div>
      </div>

    )

}

export default Navbar