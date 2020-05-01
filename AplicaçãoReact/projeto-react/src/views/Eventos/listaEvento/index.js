import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { FiTrash2 ,FiList} from 'react-icons/fi';
import Navbar from '../../../components/navbar'
import api from '../../../services/api';
import './style.css';


export default function Eventos() {
    const [eventos, setEventos] = useState([]);

    useEffect(() => {
        api.get('/eventos').then(response => {
            setEventos(response.data);

        })
    });


    async function deletarEvento(id) {
        try {
            await api.delete(`/evento/${id}`);
        } catch{
            alert('Erro ao deletar evento, tente novamente.');
        }
    }

    async function detalhesEvento(codigo) {
        try {
            const response = await api.get(`eventos/${codigo}`);

            localStorage.setItem("codigo", codigo);
            console.log(response.data)
        } catch (error) {

        }
    }

    return (
        <>
        <Navbar  className="container"/>
        <div className="container">
            <div>
                <h1>Lista de Eventos</h1>  
                    <Link className="botaoCadEvento" to="/cadastrarEvento">Novo evento</Link>
            </div>
            <table className="container">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Local</th>
                        <th>Data</th>
                        <th>Horario</th>
                        <th>Deletar</th>
                    </tr>
                </thead>


                {eventos.map(evento => (
                    <tbody key={evento.codigo}>

                        <tr>
                            <td>{evento.nome}</td>
                            <td>{evento._local}</td>
                            <td>{evento._data}</td>
                            <td>{evento.horario}</td>
                            <td>
                                <button className="btDelete" onClick={() => deletarEvento(evento.codigo)} type="onsubmit" > <FiTrash2/></button>
                            </td>
                            <td>  <button type="submit" className = "btLista" >
                                <Link to="/detalhesEvento" onClick={() => detalhesEvento(evento.codigo)}><FiList/></Link> </button></td>
                        </tr>
                    </tbody>
                ))}
            </table>
        </div>
        </>
    );
}