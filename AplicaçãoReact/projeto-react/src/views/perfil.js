import React from 'react'
import Navbar from '../components/navbar'
import UsuarioCalls from '../calls/userCalls'
import Cancelar from '../imagens/cancelar.svg'
import Editar from '../imagens/editar.svg'
import Conhecimentos from '../components/conhecimentos-field'
import Interesses from '../components/interesses-field'
import axios from 'axios'



class Perfil extends React.Component {


    state = {

        nome: '',
        id_user: '',
        photo: '',
        desc_atualize : '',
        desc_default: '',
        description: '',
        know_request: [{"conhecimento": "Java",  "nivel" : "3",
         "descricao":"Linguagem orientada a objeto", "tipo": "Linguagem de programaçaõ" },
         {"conhecimento": "Java",  "nivel" : "3",
         "descricao":"Linguagem orientada a objeto", "tipo": "Linguagem de programaçaõ" },
         {"conhecimento": "Java",  "nivel" : "3",
         "descricao":"Linguagem orientada a objeto", "tipo": "Linguagem de programaçaõ" },
        ]

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

            this.setState({desc_default: data})
         
            this.format();
           
        })
        .catch(erro => {
            console.log(erro.data)
        })
    }

    format = () => {


        const data = this.state.description

        let str = data.replace(/(?:\r\n|\r|\n)/g, '<br>');

        this.setState({description: str})


    }

    editar = () =>{
        let descript = this.state.desc_default;
        document.getElementById('text-about').value = descript;
        document.getElementById('div-about').style.display = 'inline';
        document.getElementById('text-about').style.display = 'inline';
        document.getElementById('div-blur').style.filter = 'blur(4px)';
        
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
            <div id="span-desc" dangerouslySetInnerHTML={{__html:this.state.description }} className="descript-user"></div>

            </div> 
        
            <div className="box-perf1">
                <label className="label-know">Conhecimentos</label>                 
                <Conhecimentos body={this.state.know_request} />
            </div>
            <div className="box-perf2">
                <label className="label-interest">Interesses</label>                 
                <Interesses body={this.state.know_request} />
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