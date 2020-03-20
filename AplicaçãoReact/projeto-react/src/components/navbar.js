import React from 'react'
import NavbarItem from './navbarItem'
import Busca from './busca'
import Logo from '../imagens/logo.png'
import axios from 'axios'

class Navbar extends React.Component {


  render() {
    return(

        <div className="navbar navbar-expand-lg fixed-top navbar-dark bg-primary" >
       {/*  <img src={Logo} className="navbar-brand"/> */ }
        <div className="container">
          <button className="navbar-toggler" type="button" data-toggle="collapse"
           data-target="#navbarResponsive" aria-controls="navbarResponsive"
            aria-expanded="false"aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <Busca/>
          <div className="collapse navbar-collapse" id="navbarResponsive">
            <ul className="navbar-nav">
                <NavbarItem href="#/" label="Home" />
                <NavbarItem href="#/cadastro" label="  " />
                <NavbarItem href="#/lancamentos" label="Conhecimentos" />
                <NavbarItem href="#/login" label="Sair" />
          </ul>
          </div>         
        </div>
      </div>

    )

}
}

export default Navbar