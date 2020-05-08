import React from 'react'
import Card from '../components/card-cadastro'
import FormGroup from '../components/form-group'
import UsuarioCalls from '../calls/userCalls'

class Cadastro extends React.Component {

    state = {
        nome: '',
        email: '',
        senha: '',
        photo: '',
        senha_repeat: '',
        mensagemErro : null
    }

    constructor() {
        super();
        this.call = new UsuarioCalls();
    }

    validar() {
        const msg = []

        if(!this.state.nome){
            msg.push('O campo NOME é obrigatório.')
        }

        if(!this.state.email) {
            msg.push('O campo EMAIL é obrigatório.')
        }

        else if(!this.state.email.match(/^[a-z0-9.]+@[a-z0-9]/)){
            msg.push('Informe um E-mail válido!')
        }

        if (!this.state.senha || !this.state.senha_repeat) {
            msg.push('Os campos de Senha são obrigatórios.')
        }
        
        else if(this.state.senha !== this.state.senha_repeat) {
            msg.push('As senhas não estão batendo.')
        }

        return msg;

    }

    cadastro = () => {

        const msg = this.validar()

        if(msg && msg.length > 0) {
            this.setState({mensagemErro: msg[0]})
            return false
        }

        const usuario = {
                nome: this.state.nome,
                email: this.state.email,
                senha: this.state.senha,
                photo: this.state.photo
         }

        this.call.cadastrar(usuario)
        .then(Response => {
            console.log('cadastrado com sucesso')
            this.props.history.push('/login')
        }).catch(erro => {
            this.setState({ mensagemErro: erro.response.data })
        })
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
                        <FormGroup label="Foto: *" htmlFor="photo">
                            <input type="file" id="photo"
                                name="photo" className="form-control"
                                onChange={()=>{
                                    let fileReader = new FileReader();
                                    var fileToRead = document.querySelector('#photo').files[0];
                                    fileReader.addEventListener("loadend", ()=> {
                                        console.log(fileReader.result); 
                                        this.setState({ photo: fileReader.result  })
                                        console.log("asdodsko" +this.state.photo)
                                    })
                                    fileReader.readAsDataURL(fileToRead);                                     
                                }}  
                                    />
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
                        <button type="button" onClick={this.cadastro} className="btn-success">Enviar</button>
                        <button type="button" onClick={this.toLogin} className="btn-danger">Cancelar</button>
                    </div>


                </Card>


            </div>
        )
    }

}

export default Cadastro