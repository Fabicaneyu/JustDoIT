import React from 'react'
import Navbar from '../components/navbar'
import UsuarioCalls from '../calls/userCalls'
import Cancelar from '../imagens/cancelar.svg'
import Editar from '../imagens/editar.svg'
import Add from '../imagens/add.svg'
import Conhecimentos from '../components/conhecimentos-field'
import Interesses from '../components/interesses-field'
import axios from 'axios'



class Perfil extends React.Component {


    state = {

        nome: '',
        id_user: '',
        photo: '',
        desc_atualize: '',
        desc_default: '',
        description: '',
        know_request: [],
        interest_request: [],
        select_conhecimento: '',
        id_select_conhecimento: '',
        id_select_interesse: '',
        desc_new_know: '',
        desc_new_interest: '',

    }

    constructor() {
        super();
        this.call = new UsuarioCalls();
    }


    componentDidMount() {


        this.load();
        this.reset();
        this.loadConhecimentos();
        this.loadInteresses();

    }


    load = () => {

        const usuario = localStorage.getItem('usuario_atual')
        const usuarioLogado = JSON.parse(usuario)

        this.setState({ nome: usuarioLogado.nome })
        this.setState({ id_user: usuarioLogado.id })
        this.setState({ photo: usuarioLogado.photo })

        axios.get(`http://localhost:8080/user/about?id=${usuarioLogado.id}`)
            .then(response => {
                const data = response.data

                this.setState({ description: data })

                this.setState({ desc_default: data })

                this.format();

            })
            .catch(erro => {
                console.log(erro.data)
            })

    }

    reset = () => {
        this.setState({ know_request: [] })
        this.setState({ interest_request: [] })
    }

    loadConhecimentos = () => {

        const usuario = localStorage.getItem('usuario_atual')
        const usuarioLogado = JSON.parse(usuario)

        axios.get(`http://localhost:8080/conhecimentos/buscar/conhecimentos?id=${usuarioLogado.id}`)
            .then(response => {
                const data = response.data

                this.setState({ know_request: data })

            }).catch(erro => {
                console.log(erro.data)
            })

    }

    loadInteresses = () => {

        const usuario = localStorage.getItem('usuario_atual')
        const usuarioLogado = JSON.parse(usuario)

        axios.get(`http://localhost:8080/conhecimentos/buscar/interesses?id=${usuarioLogado.id}`)
            .then(response => {
                const data = response.data

                this.setState({ interest_request: data })

            }).catch(erro => {
                console.log(erro.data)
            })

    }

    format = () => {


        const data = this.state.description

        let str = data.replace(/(?:\r\n|\r|\n)/g, '<br>');

        this.setState({ description: str })


    }

    editar = () => {
        let descript = this.state.desc_default;
        document.getElementById('text-about').value = descript;
        document.getElementById('div-about').style.display = 'inline';
        document.getElementById('text-about').style.display = 'inline';
        document.getElementById('div-blur').style.filter = 'blur(4px)';

    }

    editarConhecimento = () => {

        document.getElementById('div-about-conhecimento').style.display = 'inline';
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
            .then(response => {
                this.props.history.push('/login')
            }).catch(erro => {
                console.log(erro.response.data)
            })
    }


    atualizar = () => {


        axios.patch("http://localhost:8080/user/about", {
            id: this.state.id_user,
            sobre: this.state.desc_atualize
        })
            .then(response => {
                if (response) {
                    this.load()
                    document.getElementById('div-about').style.display = 'none';
                    document.getElementById('div-blur').style.filter = 'blur(0px)';
                    this.setState({ desc_atualize: '' });
                }
            }).catch(erro => {
                console.log(erro.data)
            })
    }

    cancelar = () => {
        document.getElementById('div-about').style.display = 'none';
        document.getElementById('div-blur').style.filter = 'blur(0px)';
        this.setState({ desc_atualize: '' });
    }

    cancelarConhecimento = () => {
        document.getElementById('div-about-conhecimento').style.display = 'none';
        document.getElementById('div-blur').style.filter = 'blur(0px)';
        this.setState({ desc_atualize: '' });
    }

    editarInteresse = () => {

        document.getElementById('div-about-interesse').style.display = 'inline';
        document.getElementById('div-blur').style.filter = 'blur(4px)';

    }

    cancelarInteresse = () => {
        document.getElementById('div-about-interesse').style.display = 'none';
        document.getElementById('div-blur').style.filter = 'blur(0px)';
        this.setState({ desc_atualize: '' });
    }

    addConhecimento = () => {

        axios.post('http://localhost:8080/conhecimentos/adicionar/conhecimento',
        {
            descricao_user: this.state.desc_new_know,
            nivel: 1,
            usuario: {
                id:this.state.id_user
            },
            conhecimento : {
                id_conhecimento: this.state.id_select_conhecimento
            }        
        }).then(response =>{
            console.log(response.data)
            window.location.reload();
            console.log(this.state.id_select_conhecimento)
        }).catch(erro => {
            console.log(erro.data)
        })
   
        }

        addInteresse = () => {

            axios.post('http://localhost:8080/conhecimentos/adicionar/interesse',
            {
                descricao_interesse: this.state.desc_new_interest,
                usuario: {
                    id:this.state.id_user
                },
                conhecimento : {
                    id_conhecimento: this.state.id_select_interesse
                }        
            }).then(response =>{
                console.log(response.data)
                window.location.reload();
                console.log(this.state.id_select_conhecimento)
            }).catch(erro => {
                console.log(erro.data)
            })
       
            }


    select = () => {
        if (this.state.select_conhecimento == 'PROGRAMACAO') {
            return(
                <>
                <option value="">Selecione</option> 
                <option value="1">Java</option> 
                <option value="3">Python</option> 
                <option value="21">JavaScript</option> 
                <option value="25">PHP</option> 
                <option value="26">C++</option> 
                <option value="28">TypeScript</option> 
                <option value="29">Ruby</option> 
                <option value="24">C#</option>  
                <option value="30">Swift</option>                   
                </>
            )
        }
        if (this.state.select_conhecimento == 'DADOS') {
            return(
                <>
                <option value="">Selecione</option>
                <option value="12">MySQL</option> 
                <option value="13">SQL Server</option> 
                <option value="14">PostgreSQL</option> 
                <option value="15">MongoDB</option> 
                <option value="16">IBM DB 2</option>  
                <option value="17">Elastic</option>  
                <option value="18">H2 DB</option>        
                <option value="19">AWS</option>  
                <option value="20">Redis</option>                 
                </>
            )
        }
        if (this.state.select_conhecimento == 'TESTES') {
            return(
                <>
                <option value="">Selecione</option>
                <option value="5">Postman</option> 
                <option value="41">Watir</option> 
                <option value="42">Cucumber</option> 
                <option value="43">Micro Focus</option>                 
                </>
            )
        }
        if (this.state.select_conhecimento == 'DESIGN') {
            return(
                <>
                <option value="">Selecione</option>
                <option value="31">Figma</option> 
                <option value="32">Adobe Photoshop</option> 
                <option value="33">Sketch</option>    
                <option value="33">Inkscape</option>               
                </>
            )
        }
        if (this.state.select_conhecimento == 'INFRAESTRUTURA') {
            return(
                <>
                <option value="">Selecione</option>
                <option value="38">Cisco/Redes</option> 
                <option value="39">Aruba/Redes</option> 
                <option value="36">Linux</option> 
                <option value="35">Windows</option>
                <option value="36">MacOS</option>                                     
                </>
            )
        }
        if (this.state.select_conhecimento == 'SEGURANCA') {
            return(
                <>
                <option value="">Selecione</option>
                <option value="22">Firewall</option> 
                <option value="23">Proxy</option> 
                <option value="24">PenTest</option>                                 
                </>
            )
        }
        if (this.state.select_conhecimento == 'GESTAO') {
            return(
                <>
                <option value="">Selecione</option>
                <option value="44">Trello</option> 
                <option value="45">Evernote</option> 
                <option value="46">Wrike</option>                                 
                <option value="47">Gotomeeting</option> 
                </>
            )
        }       
    }



    render() {

        return (
            <>
                <div id="div-blur" className="blur">
                    <Navbar executeSair={this.sair} executePerfil={this.toPerfil} executeHome={this.toHome} className="container" />
                    <div className="back-img"></div>
                    <div className="circle-perf">
                        <img className="img-perfil" src={this.state.photo} />
                    </div>
                    <div className="container-fluid">
                        <div className="user-space">

                            <span className="about">Sobre</span>
                            <img onClick={this.editar} className="btn-edit" src={Editar} />
                            <br></br><br></br>
                            <div id="span-desc" dangerouslySetInnerHTML={{ __html: this.state.description }} className="descript-user"></div>

                        </div>

                        <div className="box-perf1">
                            <div className="row">
                                <div className="div-know">

                                <label className="label-know">Conhecimentos</label>
                                <img onClick={this.editarConhecimento} className="add-know" src={Add} />

                                </div>
                               

                            </div>
                            <Conhecimentos delete={this.deletar} body={this.state.know_request} />
                        </div>
                        <div className="box-perf2">
                            <div className="row">
                                <div className="div-interest">

                                <label className="label-interest">Interesses</label>
                                <img onClick={this.editarInteresse} className="add-interest" src={Add} />

                                </div>
                                 
                            </div>
                            <Interesses delete={this.deletar} body={this.state.interest_request} />
                        </div>
                    </div>
                </div>

                <div id="div-about" className="div-sobre-user">
                    <label className="label-about">Conte-nos um pouco sobre <b className="blue">você</b></label>
                    <img onClick={this.cancelar} className="exit-about" src={Cancelar} />
                    <textarea onChange={e => this.setState({ desc_atualize: e.target.value })} id="text-about" className="text-sobre" cols="30" rows="5"></textarea>
                    <button onClick={this.atualizar} className="btn-sender-about-user">Enviar</button>
                </div>


                {/* Modal conhecimento */}
                <div id="div-about-conhecimento" className="div-sobre con">
            
                    <div className="conhecimento">
                        
                    
                        <label className="label-about "><h3>Conhecimento</h3></label>
                        <img onClick={this.cancelarConhecimento} className="exit-about" src={Cancelar} />
                        
                        
                    </div>
                    <div className="content-conhecimento">
                        <label for="tipoC">Tipo:*</label>
                        <select onChange={e => this.setState({select_conhecimento: e.target.value })} className="input-style"  name="Selecione">
                        <option value="">Selecione</option>
                        <option value="PROGRAMACAO">Programação</option>
                        <option value="INFRAESTRUTURA">Infraestrutura</option>
                        <option value="DADOS">Dados</option>   
                        <option value="DESIGN">Design</option> 
                        <option value="TESTES">Testes</option> 
                        <option value="SEGURANCA">Segurança</option> 
                        <option value="GESTAO">Gestão</option>                      
                        </select>                      
                        
                        <label for="cTipo">Conhecimento:*</label>
                        <select onChange={e => this.setState({id_select_conhecimento: e.target.value })} className="input-style"  name="Selecione">
                            {this.select()}
                        </select>

                        <div className="text-contentC">
                        Seu nível iniciará com <b className="one-level">1</b> compartilhe este conhecimento com alguém para aumentar seu nível.
                        </div>
                        <label for="cTipo">Descrição:</label>                        
                        <textarea onChange={e => this.setState({desc_new_know: e.target.value})} id="text-aboutC" className="text-sobreC" cols="30" rows="5"></textarea>
                        <button onClick={this.addConhecimento} className="btn-sender-about">Enviar</button>
                    </div>
                    
                </div>


                {/* Modal interesse */}
                <div id="div-about-interesse" className="div-sobre con">
                    <div className="conhecimento">
                        <label className="label-about "><h3>Interesse</h3></label>
                        <img onClick={this.cancelarInteresse} className="exit-about" src={Cancelar} />
                    </div>
                    <div className="content-conhecimento">
                        <label for="tipoC">Tipo:*</label>
                        <select onChange={e => this.setState({select_conhecimento: e.target.value })} className="input-style"  name="Selecione">
                        <option value="">Selecione</option>
                        <option value="PROGRAMACAO">Programação</option>
                        <option value="INFRAESTRUTURA">Infraestrutura</option>
                        <option value="DADOS">Dados</option>   
                        <option value="DESIGN">Design</option> 
                        <option value="TESTES">Testes</option> 
                        <option value="SEGURANCA">Segurança</option> 
                        <option value="GESTAO">Gestão</option>                      
                        </select>  
                        
                        <label for="cTipo">Conhecimento:*</label>
                        <select onChange={e => this.setState({id_select_interesse: e.target.value })} className="input-style"  name="Selecione">
                            {this.select()}
                        </select>

                        <div className="text-contentC">
                        Seus interesses ficarão disponíveis no seu perfil, abaixo você pode contar um pouco sobre o que
                        você gostaria de aprender.  
                        </div>
                        <label for="cTipo">Descrição:</label> 
                        <textarea onChange={e => this.setState({desc_new_interest: e.target.value})} id="text-aboutC" className="text-sobreC" cols="30" rows="5"></textarea>
                        <button onClick={this.addInteresse} className="btn-sender-about">Enviar</button>
                    </div>
                    
                </div>
            </>
        )

    }

}

export default Perfil