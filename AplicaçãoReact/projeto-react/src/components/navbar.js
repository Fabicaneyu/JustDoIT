import React from 'react'
import NavbarItem from './navbarItem'
import Busca from './busca'
import Logo from '../imagens/logo_v.2.png'
import Home from '../imagens/home.svg'
import Brain from '../imagens/brain.svg'
import Exit from '../imagens/sair.svg'
import axios from 'axios'

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
            
  
                <NavbarItem href="#/" image={Home} classN="svg-item-home" label="Home" />
                <NavbarItem href="#/" image={Brain} classN="svg-item-brain" label="Conhecimentos" />
                <NavbarItem action={prop.execute} image={Exit} classN="svg-item-out" label="Sair" />
          </ul>
          </div>         
        </div>
      </div>

    )

}

export default Navbar