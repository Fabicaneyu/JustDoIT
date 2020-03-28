import React from 'react'
import Navbar from '../components/navbar'
import UserInfo from '../components/infoUserBar'
import {withRouter} from 'react-router-dom'
import UsuarioCalls from '../calls/userCalls'
import axios from 'axios'

class Home extends React.Component {

    state = {
        nome: '',
        idUser : '',
        conteudo : ''
    }

    constructor() {
        super();
        this.call = new UsuarioCalls();
    }

    componentDidMount(){
        
        const usuario = localStorage.getItem('usuario_atual')
        const usuarioLogado = JSON.parse(usuario)

        this.setState({nome: usuarioLogado.nome})
        this.setState({idUser: usuarioLogado.idUser})
       
    }

    sair = () => {
        this.call.sair()
        .then( response => {
          this.props.history.push('/login')
        }).catch( erro => {
            console.log(erro.response.data)
        })
    }

    postar = () => {
        axios.post('http://localhost:8080/post/new', {
            conteudo: this.state.conteudo,
            id_usuario : this.state.idUser
        }).then( response => {
         this.setState({conteudo: ''})
         document.getElementById("One").reset();
         console.log('enviado com sucesso')
        }).catch( erro => {
            console.log('falha na requisição')
        })
    }

    render() {


        return(
            <>
            <Navbar execute={this.sair} className="container"/>

                <div className="divShare">
                        <form id="One">
                            <input onChange={e => this.setState({conteudo: e.target.value})} className="inputShare-one" placeholder="  algo que queira Compartilhar ?"  />
                            <input className="inputShare-two" placeholder="      algum Conteúdo ?" />
                         </form>
                    <button onClick={this.postar} className="btn-sender">Enviar</button>
                </div>

            <UserInfo label={this.state.nome} />
            </>
        )

    }


}

export default Home