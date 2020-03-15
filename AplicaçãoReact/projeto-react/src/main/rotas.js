import React from 'react'
import {Route, Switch, HashRouter} from 'react-router-dom'
import Login from '../views/login'
import Cadastro from '../views/cadastro'

function Rotas() {

    return(
        <HashRouter>
            <Switch>
                    <Route path="/login" component={Login} />
                    <Route path="/cadastro" component={Cadastro} />
            </Switch>

        </HashRouter>
    )

}

export default Rotas