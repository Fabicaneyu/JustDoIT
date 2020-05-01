import React from 'react'
import Card from '../components/card.js'
import Formgroup from '../components/form-group'
import { withRouter } from 'react-router-dom'
import UsuarioCalls from '../calls/userCalls'

class Login extends React.Component {

    state = {

        email: '',
        senha: '',
        mensagemErro: null

    }

    constructor() {
        super();
        this.call = new UsuarioCalls();
    }

    entrar = () => {

        this.call.autenticar({
            email: this.state.email,
            senha: this.state.senha
        }).then(response => {
            localStorage.setItem('usuario_atual', JSON.stringify(response.data))
            this.props.history.push('/home')
        }).catch(erro => {
            this.setState({ mensagemErro: erro.response.data })
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

            <div className="container lala">

                <div className="col-md-12" >

                    <div className="card-login">

                            <Card title="Login">

                                <div className="row">
                                    <span>{this.state.mensagemErro}</span>
                                </div>

                                <div className="row">

                                    <div className="col-lg-12">

                                        <div className="bs-component">

                                            <fieldset>

                                                <Formgroup htmlFor="imputEmail" >

                                                    <input type="text" value={this.state.email}
                                                        onChange={e => this.setState({ email: e.target.value })} className="form-control" htmlFor="imputEmail"
                                                        aria-describedby="emailHelp" placeholder="Digite seu Email" />

                                                </Formgroup>

                                                <Formgroup htmlFor="imputPassword">

                                                    <input type="password" value={this.state.senha}
                                                        onChange={e => this.setState({ senha: e.target.value })} className="form-control" htmlFor="imputPassword"
                                                        placeholder="Digite sua Senha" />

                                                </Formgroup>

                                                <button onClick={this.entrar} className="btn btn-success-entrar">Entrar</button>
                                                <div className="divfrasecadastro" > <h2 className="frasecadastro"> Ou crie uma conta gratuitamente <b onClick={this.toCadastro} className="bold-cadastro">aqui</b> </h2></div>

                                            </fieldset>

                                        </div>

                                    </div>

                                </div>

                            </Card>

                        
                    </div>
                </div>

            </div>


        )
    };




}

export default Login