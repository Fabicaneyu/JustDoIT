import React from 'react'
import Card from '../components/card-login.js'
import Logo from '../imagens/logo.png'
import Recaptcha from 'react-recaptcha'
import Formgroup from '../components/form-group'
import UsuarioCalls from '../calls/userCalls'
import {InputText} from 'primereact/inputtext';
import axios from 'axios'

class Login extends React.Component {

    state = {

        email: '',
        senha: '',
        mensagemErro: null,
        validated: false

    }

    constructor() {
        super();
        this.call = new UsuarioCalls();
    }

    entrar = () => {

        if(this.state.validated){
            
            this.setState({ mensagemErro: null })

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
        else{
            this.setState({ mensagemErro: "Por favor, comprove que você é humano" })
        }
    }


    toCadastro = () => {


        this.props.history.push('/cadastro')

    }

    recaptchaLoaded = () => {
        console.log('up')
    }

    verifyResponse = (response) => {
        if(response) {
            const data = response
            axios.post('http://localhost:8080/user/recaptcha',
            {
                captcha: data  

            }).then(response => {
                this.setState({validated: true})
            }).catch(error =>{
                console.log(error.response.data)
            })
            
        } else{
            console.log('no are')
        }
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

                            <div className="recaptcha-set">

                                    <Recaptcha                                    
                                    sitekey="6LfQs_sUAAAAAHbp43vdtXPTKe4zs9pO14PC9FBX"
                                    render="explicit"
                                    onloadCallback={this.recaptchaLoaded}
                                    verifyCallback={this.verifyResponse}
                                    />

                              </div>
                                                              

                    </div>
                </div>

            </div>

            </>

        )
    };




}

export default Login