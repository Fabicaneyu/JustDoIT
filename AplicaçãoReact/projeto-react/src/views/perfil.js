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
        interest_request: []

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


    deletar = (id) => {

        console.log("Funcionou" + id)

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
                                <div className="label-know">Conhecimentos</div>
                                <img onClick={this.editarConhecimento} className="add-know" src={Add} />



                            </div>
                            <Conhecimentos delete={this.deletar} body={this.state.know_request} />
                        </div>
                        <div className="box-perf2">
                            <div className="row">
                                <div className="label-interest">Interesses</div>
                                 <img onClick={this.editarInteresse} className="add-interest" src={Add} />
                            </div>
                            <Interesses delete={this.deletar} body={this.state.interest_request} />
                        </div>
                    </div>
                </div>

                <div id="div-about" className="div-sobre">
                    <label className="label-about">Conte-nos um pouco sobre <b className="blue">você</b></label>
                    <img onClick={this.cancelar} className="exit-about" src={Cancelar} />
                    <textarea onChange={e => this.setState({ desc_atualize: e.target.value })} id="text-about" className="text-sobre" cols="30" rows="5"></textarea>
                    <button onClick={this.atualizar} className="btn-sender-about">Enviar</button>
                </div>


                {/* Modal conhecimento */}
                <div id="div-about-conhecimento" className="div-sobre con">
                    <div className="conhecimento">
                        <label className="label-about "><h3>Conhecimento</h3></label>

                        <img onClick={this.cancelarConhecimento} className="exit-about" src={Cancelar} />
                    </div>
                    <div className="content-conhecimento">
                        <label for="tipoC">Tipo:*</label>
                        <input id="tipoC" className="input-style" type="text"/>
                        
                        <label for="cTipo">Conhecimento:*</label>
                        <input id="cTipo" className="input-style" type="text"/>

                        <div className="text-contentC">
                        Seu nível iniciará com 1 compartilhe este conhecimento com alguém para aumentar seu nível.
                        </div>
                        <textarea id="text-aboutC" className="text-sobreC" cols="30" rows="5"></textarea>
                    </div>
                    <button onClick={this.atualizar} className="btn-sender-about con">Enviar</button>
                </div>


                {/* Modal interesse */}
                <div id="div-about-interesse" className="div-sobre con">
                    <div className="conhecimento">
                        <label className="label-about "><h3>Interesse</h3></label>

                        <img onClick={this.cancelarInteresse} className="exit-about" src={Cancelar} />
                    </div>
                    <div className="content-conhecimento">
                        <label for="tipoC">Tipo:*</label>
                        <input id="tipoC" className="input-style" type="text"/>
                        
                        <label for="cTipo">Conhecimento:*</label>
                        <input id="cTipo" className="input-style" type="text"/>

                        <div className="text-contentC">
                        Seu nível iniciará com 1 compartilhe este conhecimento com alguém para aumentar seu nível.
                        </div>
                        <textarea id="text-aboutC" className="text-sobreC" cols="30" rows="5"></textarea>
                    </div>
                    <button onClick={this.atualizar} className="btn-sender-about con">Enviar</button>
                </div>
            </>
        )

    }

}

export default Perfil