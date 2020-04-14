import React from 'react'
import { Route, Switch, HashRouter } from 'react-router-dom'
import Home from '../views/home'
import Login from '../views/login'
import Cadastro from '../views/cadastro'

import CadastrarEventos from '../views/Eventos/cadastroEvento';
import ListarEventos from '../views/Eventos/listaEvento';
import DetalhesEventos from '../views/Eventos/detalhesEvento';




function Rotas() {

    return (
        <HashRouter>
            <Switch>
                <Route path="/login" component={Login} />
                <Route path="/cadastro" component={Cadastro} />
                <Route path="/home" component={Home} />
                <Route path="/cadastrarEvento" component={CadastrarEventos} />
                <Route path="/listarEvento" component={ListarEventos} />
                <Route path="/detalhesEvento" component={DetalhesEventos} />
            </Switch>

        </HashRouter>
    )

}

export default Rotas