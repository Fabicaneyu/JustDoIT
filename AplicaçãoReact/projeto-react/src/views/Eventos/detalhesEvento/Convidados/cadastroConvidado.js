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
    const [idUsuarioLogado, setIdUsuarioLogado] = useState(usuarioLogado.id);

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
       
        
       console.log(idUsuarioLogado);
       const response = await api.post(`/convidado/${id}/${idUsuarioLogado}`,)
       .then( response => {
        alert("Cadastrado com sucesso");
       }).catch( error => {
        alert("Você é o administrador deste Evento");
       })
       limparCampos();
    
        
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

