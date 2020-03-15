import React from 'react'
import Card from '../components/card'
import FormGroup from '../components/form-group'
import {withRouter} from 'react-router-dom'

class Cadastro extends React.Component {

    state = {
        nome : '',
        email : '',
        senha : '',
        senha_repeat : ''
    }

    cadastro = () => {
        console.log(this.state)
    }

    toLogin = () => {
        this.props.history.push('/login')
    }
 

    render() {
        return(
            <div className="container-b">
            
            <Card title="Cadastro">
         
                    
                       <div className="bs-component">
                    
                            <FormGroup label="Nome: *" htmlFor="inputNome">
                                <input type="text" id="inputNome"
                                name="nome" className="form-control"
                                onChange={e => this.setState({nome: e.target.value})}/>
                            </FormGroup>
                            <FormGroup label="E-mail: *" htmlFor="inputEmail">
                                <input type="text" id="inputEmail"
                                name="email" className="form-control"
                                onChange={e => this.setState({email: e.target.value})}/>
                            </FormGroup>
                            <FormGroup label="Senha: *" htmlFor="inputSenha">
                                <input type="password" id="inputSenha"
                                name="senha" className="form-control"
                                onChange={e => this.setState({senha: e.target.value})}/>
                            </FormGroup>
                            <FormGroup label="Repita a senha: *" htmlFor="senhaRepeat">
                                <input type="password" id="senhaRepeat"
                                name="senharp" className="form-control"
                                onChange={e => this.setState({senha_repeat: e.target.value})}/>
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