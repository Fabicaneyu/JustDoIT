import React from 'react'
import Navbar from '../../components/navbar'
import UserInfo from '../../components/info-user-bar'
import CardBusca from './busca-field'

import Loading from '../../imagens/Spinner.gif'

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
        busca_content: ''

    }


    componentDidMount(){
        
               
        const usuario = localStorage.getItem('usuario_atual')
        const usuarioLogado = JSON.parse(usuario)


        this.setState({nome: usuarioLogado.nome})
        this.setState({idUser: usuarioLogado.id})
        this.setState({photo: usuarioLogado.photo})      
        document.getElementById('load').style.display = 'inline';  
       
         
        this.buscar();

    }

    buscar = (dado) => {

        const parametro = this.props.match.params.conhecimento

        this.setState({request: ''})        

        if(dado){
            axios.get(`http://localhost:8080/user/find?conhecimento=${dado}`)
            .then(response => {
                const data = response.data
               
                this.setState({request: data})
                this.setState({resultados: data.length})
                document.getElementById('load').style.display = 'none';
                
            }).catch(error => {
                console.log(error.data)
            })
        }
        else {
            axios.get(`http://localhost:8080/user/find?conhecimento=${parametro}`)
            .then(response => {
                const data = response.data
               
                this.setState({request: data})
                this.setState({resultados: data.length})
                document.getElementById('load').style.display = 'none';
              
            }).catch(error => {
                console.log(error.data)
            })
        }
       
        
            
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

    toView = (id) => {

        if(this.state.idUser == id) {
            this.props.history.push(`/perfil`)
        }
        else{
            this.props.history.push(`/view/${id}`)
        }

    }



    verifyBusca = () => {

        if(this.state.request.length >=1) {
            return(
                <>
                <label className="label-resultados">Exibindo <b>{this.state.resultados}</b> resultado(s)</label>
                <CardBusca view={this.toView} body={this.state.request}/>
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
            action={e =>this.buscar(this.state.busca_content)}
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
