import React from 'react'
import Navbar from '../../components/navbar'
import UserInfo from '../../components/info-user-bar'
import {withRouter} from 'react-router-dom'
import UsuarioCalls from '../../calls/userCalls'
import PostField from './post-field'
import axios from 'axios'

class Home extends React.Component {

    state = {
        nome: '',
        idUser : '',
        photo : '',
        conteudo : '',
        request : []
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
        this.setState({photo: usuarioLogado.photo})    
        this.buscar();
        this.buscarPhoto();
       
    }
  

    buscar = () => {
        axios.get('http://localhost:8080/post/load')
        .then( response => {
            this.setState({request: response.data})
            console.log('Tudo certo')
        }).catch( erro => {
            console.log(erro)
        })
    }

    buscarPhoto = () => {
        axios.get('http://localhost:8080/user/photo')
        .then( response => {
            this.setState({photo : response.data})
            // console.log(this.state.photo)
            return this.state.photo
            
        }).catch( erro => {
            console.log(erro)
        })
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
            nome_user: this.state.nome,
            id_usuario : this.state.idUser
        }).then( response => {
         this.setState({conteudo: ''})
         document.getElementById("One").reset();
         window.location.reload();
         console.log('enviado com sucesso')
        }).catch( erro => {
            console.log('falha na requisição')
        })
    }



    render() {


        return(
            <>
            <Navbar execute={this.sair} className="container"/>

            <UserInfo label={this.state.nome} />

                <div className="divShare">
                        <form id="One">
                            <input onChange={e => this.setState({conteudo: e.target.value})} className="inputShare-one" placeholder="  algo que queira Compartilhar ?"  />
                            <input className="inputShare-two" placeholder="      algum Conteúdo ?" />
                         </form>
                    <button onClick={this.postar} className="btn-sender">Enviar</button>
                </div>
                
                <br></br>

                <PostField body={this.state.request} photo = {this.state.photo} />
            </>
        )

    }


}

export default Home