import React, { useState } from 'react';

import api from '../../../../services/api';
import '../../css-evento.css';
import { FiX } from 'react-icons/fi';

export default function CadastroConvidado() {
    const id = localStorage.getItem("codigo");
    const usuario = localStorage.getItem('usuario_atual');
    const usuarioLogado = JSON.parse(usuario);

    const [nomeConvidado, setNomeConvidado] = useState('');
    const [email, setEmail] = useState('');
    const [isModalVisible, setIsModalVisible] = useState(false);
    const [idUsuarioLogado, setIdUsuarioLogado] = useState('');

    function limparCampos() {
        setEmail("");
        setNomeConvidado("");

    }
    async function handleRegisterConvit(e) {
        e.preventDefault();

        const env = {
            nomeConvidado,
            email
        };
        setIdUsuarioLogado(usuarioLogado.id);
        console.log(idUsuarioLogado);
       /// const response = await api.post(`/convidado/${id}`, idUsuarioLogado);
       // limparCampos();
    
        alert("Cadastrado com sucesso");
    }
    return (
        <div className="container-cad-conv">
            <button
                className="button-modal-cad"
                type="submit"
                onClick={handleRegisterConvit}>
                Participar
            </button>
        </div>


    );
}

