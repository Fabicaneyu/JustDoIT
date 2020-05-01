import React, { useEffect, useState } from 'react';

import api from '../../../../services/api';
import './style.css';

export default function Convidado() {
    const id = localStorage.getItem("codigo");
    const [convidados, setConvidados] = useState([]);

    useEffect(() => {
        api.get(`/convidado/${id}`).then(response => {
            setConvidados(response.data);
            console.log(convidados);


        })
    });

    return (

        <table className="container container-cad-conv" >
            <thead>
                <tr>
                    <th>Nome Convidado</th>
                    <th>RG</th>
                </tr>
            </thead>
            {convidados.map(convidado => (

                <tbody key={convidado.rg}>
                    <tr>
                        <td>{convidado.nomeConvidado}</td>
                        <td>{convidado.rg}</td>
                    </tr>
                </tbody>
            ))}
        </table>



    );
}


