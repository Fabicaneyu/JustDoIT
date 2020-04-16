import React from 'react'
import Navbar from '../components/navbar'
import UsuarioCalls from '../calls/userCalls'



class Perfil extends React.Component {


    state = {

        nome: '',
        idUser: '',
        photo: '',
        description: "Trabalho na Área,\n " +
                       "formada em ADS, " +
                        "\ngosto de tecnologia"

    }
    
    constructor() {
        super();
        this.call = new UsuarioCalls();
    }


    componentDidMount(){
        

        const usuario = localStorage.getItem('usuario_atual')
        const usuarioLogado = JSON.parse(usuario)


        this.setState({nome: usuarioLogado.nome})
        this.setState({idUser: usuarioLogado.id})
        this.setState({photo: usuarioLogado.photo})  


    }


    toHome = () => {
        this.props.history.push('/home')
    }

    toPerfil = () => {
        this.props.history.push('/perfil')
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
            <Navbar executeSair={this.sair} executePerfil={this.toPerfil} executeHome={this.toHome} className="container"/>
            <div className="back-img"></div>
            <div className="circle-perf">
                <img className="img-perfil" src={this.state.photo} />
            </div>
            <div className="user-space">

                <span className="name-profile">Sobre</span>
                {/* <br></br>
                <span className="name-profile">Idade: 23</span>
                <br></br>
                <span className="descript-user">{this.state.description}</span> */}


            </div> 
            </>
        )

    }

}

export default Perfil