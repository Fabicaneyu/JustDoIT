import React from 'react'
import Navbar from '../../components/navbar'
import UserInfo from '../../components/info-user-bar'
import CardBusca from './busca-field'
// import PostField from './post-field'
// import Recomendation from '../../components/recomendation-field'
// import Waypoint from '../../components/way'
import Loading from '../../imagens/Spinner.gif'
// import Pencil from '../../imagens/pencil.svg'
// import File from '../../imagens/file.svg'
import axios from 'axios'

class Busca extends React.Component {

    state = {
        nome: '',
        idUser : '',
        photo : '',
        conteudo : '',
        recomendados : [],
        busca_content: '',
        resultados : 0,
        request : [],
        busca: ''

    }


    componentDidMount(){
        

        

        const usuario = localStorage.getItem('usuario_atual')
        const usuarioLogado = JSON.parse(usuario)


        this.setState({nome: usuarioLogado.nome})
        this.setState({idUser: usuarioLogado.id})
        this.setState({photo: usuarioLogado.photo}) 
        this.setState({busca: this.loadBusca}) 
        
        this.loadBusca();

        // this.buscar(param);


        // this.initial();
        // this.loadRecomendation();

    }

    // setBusca = (parametro) =>  {

    //    this.componentDidMount(parametro);
        
        

    // }

    buscarUsuarios = () => {
         
        axios.get(`http://localhost:8080/user/find?conhecimento=${this.state.busca}`)
        .then(response => {
            const data = response.data
            console.log(data)
            this.setState({request: data})
            this.setState({resultados: data.length})
            document.getElementById('load').style.display = 'none';
        }).catch(error => {
            console.log(error.data)
        })
    }

    buscar = () => {

        axios.get(`http://localhost:8080/conhecimentos/busca/set?textBusca=${this.state.busca_content}`)
        .then(response => {            
            this.loadBusca();
            document.getElementById('load').style.display = 'inline';
        })
        .catch(erro => {
            console.log(erro.data)
        })
            
    }

    loadBusca = () => {

        axios.get('http://localhost:8080/conhecimentos/busca/get')
        .then(response =>{
            const data = response.data
            this.setState({busca: data})
            this.buscarUsuarios();
            document.getElementById('load').style.display = 'inline';
        }).catch(erro => {
            console.log(erro.data)
        })

    }

  

    sair = () => {
        axios.get('http://localhost:8080/logoff')
        .then( response => {
          this.props.history.push('/login')
        }).catch( erro => {
            console.log(erro.response.data)
        })
    }

    toPerfil = () => {
        this.props.history.push('/perfil')
    }

    toHome = () => {
        this.props.history.push('/home')
    }

    verifyBusca = () => {

        if(this.state.request.length >=1) {
            return(
                <>
                <label className="label-resultados">Exibindo <b>{this.state.resultados}</b> resultado(s)</label>
                <CardBusca body={this.state.request}/>
                </>
            )
        }else{
            return(
                <div className="frase-no-content">Infelizmente ainda não temos usuários que possuem este conhecimento :,(</div>
            )
        }

    }



    render() {


        return(
            <>
            <Navbar           
            executeSair={this.sair}
            executePerfil={this.toPerfil} 
            sendTo={this.toHome}
            className="container"
            action={this.buscar}
            value={this.state.busca_content}
            change={e =>this.setState({busca_content: e})}/>
            <div className="content">
                <div className="container-fluid">
                    <div className="row">
                                                

                        <UserInfo photo={this.state.photo} label={this.state.nome} />
                        
                           
                          </div>
                                                    
                          <div className="div-superior-busca">                    

                             {this.verifyBusca()}

                          </div>
                          <img id="load" className="gif-load" src={Loading} alt="load"/>
            
                        
                        {/* <Recomendation body={this.state.recomendados}/> */}
                                           
                        

                    </div>
                </div>
               
        
                      

                
            </>
        )

    }


}

export default Busca
