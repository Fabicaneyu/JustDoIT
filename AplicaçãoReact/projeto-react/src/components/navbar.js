import React from 'react'
import NavbarItem from './navbar-Item'
import Busca from './busca'
import Logo from '../imagens/logo_v.2.png'
import Home from '../imagens/home.svg'
import Evento from '../imagens/evento.svg'
import Brain from '../imagens/brain.svg'
import Exit from '../imagens/sair.svg'

function Navbar(prop) {

  return (

    <div className="navbar navbar-expand-lg navbar-light bg-header" >


      <div className="header container-fluid">
        <div className="col-md-3">
          <div className="logo-size">
            <img className="img-size-logo" src={Logo}/>
                </div>
        </div>

        
        <Busca />
        <div className="col-md-3 col-sm-2 col-2">
            <div className="row">
                <div className="col-md-3 icons-header" align="right">
                  <div className="icon-size">
                      <NavbarItem action={prop.executeHome} href="#/home" image={Home} classN="svg-item-home" />
                  </div>
                </div>

                <div className="col-md-3 icons-header" align="right">
                    <div className="icon-size">
                    <NavbarItem action={prop.executePerfil} href="#/perfil" image={Brain} classN="svg-item-brain"/>
                    </div>
                </div>

                <div className="col-md-3 icons-header" align="right">
                  <div className="icon-size">
                  <NavbarItem action={prop.executeEventos} href="#/cadastrarEvento" image={Evento} classN="svg-item-event"/>
                  </div>
                </div>

                <div className="col-md-3 menu icon-size" align="right">
                  <div className="icon-size">
                  <NavbarItem action={prop.executeSair} href="#/login" image={Exit} classN="svg-item-out"/>
                  </div>
                </div>


            </div>       

        </div>
      </div>
    </div>

  )

}

export default Navbar