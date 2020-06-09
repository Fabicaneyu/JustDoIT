import React, { useState } from 'react';

import api from '../../../../services/api';
import '../../css-evento.css';
import {FiX } from 'react-icons/fi';

export default function CadastroConvidado() {

    const [nomeConvidado, setNomeConvidado] = useState('');
    const [rg, setRg] = useState('');
    const id = localStorage.getItem("codigo");
    const [isModalVisible, setIsModalVisible] = useState(false);
function limparCampo(){
    setNomeConvidado("");
    setRg("");
    setIsModalVisible(false);
}
    async function handleRegisterConvit(e) {
        e.preventDefault();

        const env = {
            nomeConvidado,
            rg
        };

        const response = await api.post(`/convidado/${id}`, env);
        limparCampo();
        console.log(response);
        alert("Cadastrado com sucesso");

    }
    return (

        <div className="container-cad-conv">
            
            <button className="button-modal-cad" onClick={() => setIsModalVisible(true)}>Participar</button>
            {isModalVisible ?
                <div className="modal-cad">
                    <div className="container-modal">
                    <FiX className="close" onClick={() => setIsModalVisible(false)}/>
                        <form onSubmit={handleRegisterConvit} className="">

                            <div className="form-row">
                                <div className="col-sm-7">
                                    <label className="label" for="inputDefault">Nome</label>
                                    <input name="nomeConvidado" type="text" className="form-control1" value={nomeConvidado} onChange={e => setNomeConvidado(e.target.value)} />
                                </div>
                                <div className="col-sm-4">
                                    <label className="label" for="inputDefault">Rg</label>
                                    <input name="rg" type="text" className="form-control1" placeholder="AA-00.000.000" value={rg} onChange={e => setRg(e.target.value)} />
                                </div>
                            </div>
                            <div className="button-cad-conv"> <button className="botaoCadastro" type="submit">Adicionar</button></div>
                          
                        </form>
                    </div></div>
                : null}

        </div>


    );
}

