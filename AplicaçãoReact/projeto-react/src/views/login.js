import React from 'react'
import Card from '../components/card-login.js'
import Logo from '../imagens/logo.png'
import Formgroup from '../components/form-group'
import UsuarioCalls from '../calls/userCalls'
import {InputText} from 'primereact/inputtext';

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

            <>

            <div className="box-logo-login">
                <img src={Logo} className="logo-login" alt="login" />
            </div>

            <div className="container-login">

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

                                                <Formgroup label="E-mail: *" htmlFor="imputEmail" >
                                                   

                                                                  <span className="p-float-label">
                                                                            <InputText id="in" value={this.state.email}
                                                                            className="form-control"
                                                                            onChange={(e) => this.setState({email: e.target.value})} />
                                                                            <label htmlFor="in">Digite seu Email</label>
                                                                    </span> 

                                                </Formgroup>

                                                <Formgroup label="Senha: *" htmlFor="imputPassword">

                                                                    <span className="p-float-label">
                                                                            <InputText id="in" value={this.state.senha}
                                                                            className="form-control"
                                                                            type="password"
                                                                            onChange={(e) => this.setState({senha: e.target.value})} />
                                                                            <label htmlFor="in">Digite sua senha</label>
                                                                    </span> 

                                                </Formgroup>

                                                <button onClick={this.entrar} className="btn-success-entrar">Entrar</button>
                                                <div className="divfrasecadastro" > <h2 className="frasecadastro"> Ou crie uma conta gratuitamente <b onClick={this.toCadastro} className="bold-cadastro">aqui</b> </h2></div>

                                            </fieldset>

                                        </div>

                                    </div>

                                </div>

                            </Card>

                        
                    </div>
                </div>

            </div>

            </>

        )
    };




}

export default Login