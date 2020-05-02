import React, { useState } from 'react';
import { Link, Redirect } from 'react-router-dom';
import '../css-evento.css';
import api from '../../../services/api';
import Navbar from '../../../components/navbar';
import UserInfo from '../../../components/info-user-bar';

export default function CadastroEvento() {

    const [nome, setNome] = useState('');
    const [_local, setLocal] = useState('');
    const [_data, setData] = useState('');
    const [horario, setHorario] = useState('');
    const [descricao, setDescricao] = useState('');

    async function handleRegister(e) {
        e.preventDefault();

        const env = {
            nome,
            _local,
            _data,
            horario,
            descricao,
        };

        const response = await api.post('cadastrarEvento', env);
        console.log(response);
        alert("Cadastrado com sucesso");

    }




    return (

        <> <Navbar className="container" />
        <div className="body">
           
            <div className="menu-lateral">lalalal</div>
            <div className=" container">
                <div className="box-body">
                    <form onSubmit={handleRegister} className="formContainer">
                        <h1 className="titulo-cad">Novo Evento</h1>
                        <div className="form-row">
                            <div className="col-sm-10">
                                <label className="label" for="inputDefault">Nome</label>
                                <input name="nome" type="text" className="form-control1" value={nome} onChange={e => setNome(e.target.value)} />
                            </div>
                        </div>
                        <div className="form-row ">
                            <div className="col-sm-4">
                                <label className="label" for="inputDefault">Local</label>
                                <input name="local" type="text" className="form-control1 " value={_local} onChange={e => setLocal(e.target.value)} />
                            </div>


                            <div className="col-sm-3">
                                <label className="label" for="inputDefault">Data</label>
                                <input name="data" type="date" className="form-control1 " value={_data} onChange={e => setData(e.target.value)} />
                            </div>

                            <div className="col-sm-3">
                                <label className="label" for="inputDefault">Horário</label>
                                <input name="horario" type="time" className="form-control1  " value={horario} onChange={e => setHorario(e.target.value)} />

                            </div>
                            <div className="col-sm-10">
                                <label className="label" for="inputDefault">Descrição</label>
                                <textarea name="descricao" type="text" className="form-control-textarear" value={descricao} onChange={e => setDescricao(e.target.value)} />

                            </div>
                        </div>
                        <div className="buttonCad">
                            <button className="botaoCadastro" type="submit" >Cadastrar</button>
                            <button className="botaoLista" >
                                <Link className="a" to="/listarEvento">Lista de eventos</Link></button>
                        </div></form>

                </div>   </div >
                </div>
        </>
    );
}