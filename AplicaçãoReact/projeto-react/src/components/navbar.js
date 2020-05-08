import React from 'react'
import NavbarItem from './navbar-Item'
import Busca from './busca'
import Logo from '../imagens/logo.png'
import Home from '../imagens/home.svg'
import Evento from '../imagens/evento.svg'
import Brain from '../imagens/brain.svg'
import Exit from '../imagens/sair.svg'

function Navbar(prop) {

  return (

    <div className="navbar navbar-expand-lg navbar-light bg-header" >
          <div className="logo-size">
            <img className="img-size-logo" src={Logo} alt="logo"/>
                </div>

      <div className="header container-fluid">
        <div className="col-md-3">

        </div>

        
        <Busca />
        <div className="col-md-3 col-sm-2 col-2">
            <div className="row">
                <div className="col-md-3" align="right">
                  <div className="icon-size">
                      <NavbarItem spam="home-navbar-label" action={prop.executeHome} href="#/home" image={Home} label="Home" classN="svg-item-home" />
                  </div>
                </div>

                <div className="col-md-3" align="right">
                    <div className="icon-size">
                    <NavbarItem spam="perfil-navbar-label" action={prop.executePerfil} href="#/perfil" label="Perfil" image={Brain} classN="svg-item-brain"/>
                    </div>
                </div>

                <div className="col-md-3" align="right">
                  <div className="icon-size">
                  <NavbarItem spam="eventos-navbar-label" action={prop.executeEventos} href="#/cadastrarEvento" label="Eventos" image={Evento} classN="svg-item-event"/>
                  </div>
                </div>

                <div className="col-md-3 menu" align="right">
                  <div className="icon-size">
                  <NavbarItem spam="sair-navbar-label" action={prop.executeSair} href="#/login" image={Exit} label="Sair" classN="svg-item-out"/>
                  </div>
                </div>


            </div>       

        </div>
      </div>
    </div>

  )

}

export default Navbar