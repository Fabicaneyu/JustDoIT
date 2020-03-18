import React from 'react'
import Card from '../components/card'
import FormGroup from '../components/form-group'
import { withRouter } from 'react-router-dom'
import Axios from 'axios'

class Cadastro extends React.Component {

    state = {
        nome: '',
        email: '',
        senha: '',
        senha_repeat: '',
        mensagemErro : null
    }

    cadastro = () => {
        Axios.post('http://localhost:8080/user/cadastro', {
            nome: this.state.nome,
            email: this.state.email,
            senha: this.state.senha,
            senhaConfirma: this.state.senha_repeat

        }).then(Response => {
            this.props.history.push('/login')
        }).catch(erro => {
            console.log(this.state.senha, this.state.senha_repeat)
            console.log(erro.response.data)
            this.setState({ mensagemErro: erro.response.data })
        })
    }
    toLogin = () => {
        this.props.history.push('/login')
    }



    toLogin = () => {

        this.props.history.push('/login')
    }


    render() {
        return (
            <div className="container-b">

                <Card title="Cadastro">
                <div>
                    <span>
                        {this.state.mensagemErro}
                    </span>
                    
              </div>

                    <div className="bs-component">

                        <FormGroup label="Nome: *" htmlFor="inputNome">
                            <input type="text" id="inputNome"
                                name="nome" className="form-control"
                                onChange={e => this.setState({ nome: e.target.value })} />
                        </FormGroup>
                        <FormGroup label="E-mail: *" htmlFor="inputEmail">
                            <input type="text" id="inputEmail"
                                name="email" className="form-control"
                                onChange={e => this.setState({ email: e.target.value })} />
                        </FormGroup>
                        <FormGroup label="Senha: *" htmlFor="inputSenha">
                            <input type="password" id="inputSenha"
                                name="senha" className="form-control"
                                onChange={e => this.setState({ senha: e.target.value })} />
                        </FormGroup>
                        <FormGroup label="Repita a senha: *" htmlFor="senhaRepeat">
                            <input type="password" id="senhaRepeat"
                                name="senharp" className="form-control"
                                onChange={e => this.setState({ senha_repeat: e.target.value })} />
                        </FormGroup>
                        <button type="button" onClick={this.cadastro} className="btn btn-success">Enviar</button>
                        <button type="button" onClick={this.toLogin} className="btn btn-danger">Cancelar</button>
                    </div>


                </Card>


            </div>
        )
    }

}

export default Cadastro