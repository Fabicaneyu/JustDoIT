import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { FiCornerDownLeft} from 'react-icons/fi';
import api from '../../../services/api';
import './style.css';

export default function DetalhesEvento() {
    const [eventoDeta, setEventoDet] = useState([]);
    const id = localStorage.getItem("codigo");

    useEffect(() => {
        api.get(`eventos/${id}`).then(response => {
            setEventoDet(response.data);

        })
    });
    return (
        <div className="container">
            <div> <h1>Detalhe do Evento</h1> <Link className="botaoVoltar" to="/listarEvento"><FiCornerDownLeft/></Link></div>
            <table className="container">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Local</th>
                        <th>Data</th>
                        <th>Horario</th>

                    </tr>
                </thead>

                <tbody key={eventoDeta.codigo}>

                    <tr>
                        <td>{eventoDeta.nome}</td>
                        <td>{eventoDeta.local}</td>
                        <td>{eventoDeta.data}</td>
                        <td>{eventoDeta.horario}</td>
 </tr>
                </tbody>
            </table>
           
        </div>
    );
  
}