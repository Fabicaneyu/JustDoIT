import React from 'react'
import Navbar from '../components/navbar'
import UsuarioCalls from '../calls/userCalls'
import Cancelar from '../imagens/cancelar.svg'
import Editar from '../imagens/editar.svg'
import axios from 'axios'



class Perfil extends React.Component {


    state = {

        nome: '',
        id_user: '',
        photo: '',
        desc_atualize : '',
        description: '',
        format: ''

    }
    
    constructor() {
        super();
        this.call = new UsuarioCalls();
    }


    componentDidMount(){
        

        this.load();


    }


    load = () => {

        const usuario = localStorage.getItem('usuario_atual') 
        const usuarioLogado = JSON.parse(usuario)

        this.setState({nome: usuarioLogado.nome})
        this.setState({id_user: usuarioLogado.id})
        this.setState({photo: usuarioLogado.photo})  

        console.log(usuarioLogado.id);
        axios.get(`http://localhost:8080/user/about?id=${usuarioLogado.id}`)
        .then(response => {
            const data = response.data    
            

            this.setState({description: data})

            
        })
        .catch(erro => {
            console.log(erro.data)
        })
    }

    split = (string) => {

        var arrayOfStrings = string.split("\r");
        console.log(arrayOfStrings[1])

        return arrayOfStrings
    }

    editar = () =>{
        let descript = this.state.description;
        document.getElementById('text-about').value = descript;
        document.getElementById('div-about').style.display = 'inline';
        document.getElementById('text-about').style.display = 'inline';
        document.getElementById('div-blur').style.filter = 'blur(2px)';
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

    atualizar = () => {

    
        axios.patch("http://localhost:8080/user/about", {
            id : this.state.id_user,
            sobre : this.state.desc_atualize })
            .then(response => {
                if (response) {
                    this.load()
                    document.getElementById('div-about').style.display = 'none';
                    document.getElementById('div-blur').style.filter = 'blur(0px)';
                    this.setState({desc_atualize: ''});
                }
            }).catch(erro => {
                console.log(erro.data)
            })
    }

    cancelar = () => {
        document.getElementById('div-about').style.display = 'none';
        document.getElementById('div-blur').style.filter = 'blur(0px)';
        this.setState({desc_atualize: ''});
    }


    render() {

        return(
            <>
            <Navbar executeSair={this.sair} executePerfil={this.toPerfil} executeHome={this.toHome} className="container"/>
            <div className="back-img"></div>
            <div className="circle-perf">
                <img className="img-perfil" src={this.state.photo} />
            </div>
            <div id="div-blur" className="blur">
            <div className="user-space">

            <span className="about">Sobre</span>
                <img onClick={this.editar} className="btn-edit" src={Editar}/>
                <br></br><br></br>
            <span id="span-desc" wrap="hard" className="descript-user">{this.split(this.state.description)}</span>

            </div> 
            </div> 
            <div id="div-about" className="div-sobre">
                <label className="label-about">Conte-nos um pouco sobre <b className="blue">você</b></label>
                <img onClick={this.cancelar} className="exit-about" src={Cancelar} />
                <textarea  onChange={e => this.setState({desc_atualize: e.target.value})} id="text-about" className="text-sobre" cols="30" rows="5"></textarea>
                <button onClick={this.atualizar} className="btn-sender-about">Enviar</button>
            </div>
            </>
        )

    }

}

export default Perfil