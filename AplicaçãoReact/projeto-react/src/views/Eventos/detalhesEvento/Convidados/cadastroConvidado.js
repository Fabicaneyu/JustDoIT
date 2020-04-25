import React, { useEffect, useState } from 'react';

import api from '../../../../services/api';
import './style.css';


export default function CadastroConvidado() {
           
            const [nomeConvidado, setNomeConvidado] = useState('');
            const [rg, setRg] = useState('');
            const id = localStorage.getItem("codigo");


          async function handleRegisterConvit(e){
                e.preventDefault();

                const env = {
                    nomeConvidado,
                    rg
                };
                
                const response = await api.post(`/convidado/${id}`, env);
                console.log(response);
                alert("Cadastrado com sucesso");

            }
            return ( 

            <div className="container-cad-conv">

                <form onSubmit={handleRegisterConvit} className="">

                <h1 >Convidados</h1>
                    <div className="form-row">
                        <div className="col-sm-9">
                            <label className="col-form-label" for="inputDefault">Nome</label>
                            <input name="nomeConvidado" type="text" className="form-control" value={nomeConvidado} onChange={e => setNomeConvidado(e.target.value)} />
                        </div>
                    </div>
                    <div className="form-row ">
                        <div className="col-sm-3">
                            <label className="col-form-label" for="inputDefault">Rg</label>
                            <input name="rg" type="text" className="form-control inputForm" placeholder="AA-00.000.000" value={rg} onChange={e => setRg(e.target.value)} />
                        </div>

                    </div>


                    <button className="botaoCadastro" type="submit">Adicionar</button>
                </form>


            </div>
        
    
            );}

