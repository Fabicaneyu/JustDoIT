import React from 'react'
import Navbar from '../components/navbar'
import UserInfo from '../components/infoUserBar'
import {withRouter} from 'react-router-dom'
import UsuarioCalls from '../calls/userCalls'
import ShareCard from '../components/fieldShare'

class Home extends React.Component {

    state = {
        nome: ''
    }

    constructor() {
        super();
        this.call = new UsuarioCalls();
    }

    componentDidMount(){
        
        const usuario = localStorage.getItem('usuario_atual')
        const usuarioLogado = JSON.parse(usuario)

        this.setState({nome: usuarioLogado.nome})
       
    }

    sair = () => {
        this.call.sair()
        .then( response => {
          this.props.history.push('/login')
        }).catch( erro => {
            console.log(erro.response.data)
        })
    }

    render() {


        return(
            <>
            <Navbar execute={this.sair} className="container"/>
            <ShareCard />
            <UserInfo label={this.state.nome} />
            </>
        )

    }


}

export default Home