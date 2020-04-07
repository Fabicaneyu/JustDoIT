import React from 'react'
import Card from '../components/card.js'
import Formgroup from '../components/form-group'
import {whithRouter} from 'react-router-dom'
import UsuarioCalls from '../calls/userCalls'

class Login extends React.Component {

    state = {

        email : '',
        senha : '',
        mensagemErro : null
        
    }

    constructor () {
        super();
        this.call = new UsuarioCalls();
    }

    entrar = () => {

        this.call.autenticar({
            email: this.state.email,
            senha: this.state.senha
        }).then( response => {
            localStorage.setItem('usuario_atual', JSON.stringify (response.data))
            this.props.history.push('/home')
        }).catch( erro => {
            this.setState({mensagemErro : erro.response.data})
        })
    }


    toCadastro = () => {

        
        this.props.history.push('/cadastro')

    }   


//  logar = () => {
//        console.log('Email: ' , this.state.email)
//        console.log('Senha' , this.state.senha)
//    }

    render() {
        return (
            
                <div className="row">
                 <div className="col-md-6" style={{position : 'relative', left: '25%'}}>
                
                        <div className="bs-docs-section"> 
                          <div className="container-b">                            
                            <Card title="Login">

                                <div className="row">
                                    <span>{this.state.mensagemErro}</span>
                                </div>

                                <div className="row">

                                    <div className="col-lg-12">
                                        
                                        <div className="bs-component">

                                            <fieldset>

                                            <Formgroup htmlFor="imputEmail" label="Email : *">

                                                <input type="text" value={this.state.email}
                                                 onChange={e => this.setState({email: e.target.value})} className="form-control" htmlFor="imputEmail"
                                                 aria-describedby="emailHelp" placeholder="Digite o Email"/>

                                             </Formgroup>

                                             <Formgroup label="Senha : *" htmlFor="imputPassword">

                                               <input type="password" value={this.state.senha}
                                               onChange={e => this.setState({senha: e.target.value})} className="form-control" htmlFor="imputPassword"
                                                placeholder="Password"/>

                                            </Formgroup> 
                                            
                                            <button onClick={this.entrar} className="btn btn-success">Entrar</button>
                                            <button onClick={this.toCadastro} className="btn btn-danger">Cadastrar</button>
                                            </fieldset>

                                        </div>

                                    </div>

                                </div>

                            </Card>

                        </div>
                </div>
                </div>

            </div>
           
 
        )
    };
        



}

export default Login
