import React, { useEffect, useState } from 'react';

import api from '../../../services/api';
import './style.css';
import { Component } from 'react';

class BuscarConvidados extends Component {
    render() {
        return () => {
            const id = localStorage.getItem("codigo");
            const [convidados, setConvidados] = useState([]);

            useEffect(() => {
                api.get(`convidados/${id}`).then(response => {
                    setConvidados(response.data);


                })
            });
            <table className="container">
                <thead>
                    <tr>
                        <th>Nome Convidado</th>
                        <th>RG</th>
                    </tr>
                </thead>
                {convidados.map(convidado => (

                    <tbody key={convidado.rg}>
                        <tr>
                            <td>{convidado.nome}</td>
                            <td>{convidado.rg}</td>
                        </tr>
                    </tbody>
                ))}
            </table>

        }
    }
}

class CadastrarConvidado extends Component() {
    render() {
        return () => {
            const [nome, setNome] = useState('');
            const [rg, setRg] = useState('');
            const id = localStorage.getItem("codigo");


            function handleRegisterConvit(e){
                e.preventDefault();

                const env = {
                    nome,
                    rg
                };

                const response = await api.post(id, env);
                console.log(response);
                alert("Cadastrado com sucesso");

            }

            <div className="container">

                <form onSubmit={handleRegisterConvit} className="formContainer">


                    <div className="form-row">
                        <div className="col-sm-9">
                            <label className="col-form-label" for="inputDefault">Nome</label>
                            <input name="nome" type="text" className="form-control" value={nome} onChange={e => setNome(e.target.value)} />
                        </div>
                    </div>
                    <div className="form-row ">
                        <div className="col-sm-3">
                            <label className="col-form-label" for="inputDefault">Rg</label>
                            <input name="rg" type="text" className="form-control inputForm" placeholder="AA-00.000.000" value={rg} onChange={e => setRg(e.target.value)} />
                        </div>

                    </div>


                    <button type="submit">Adicionar</button>
                </form>


            </div>
        }
    }
}




