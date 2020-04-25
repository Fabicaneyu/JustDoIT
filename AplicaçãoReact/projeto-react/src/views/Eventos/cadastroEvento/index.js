import React, {useState} from 'react';
import {Link, Redirect} from 'react-router-dom';
import './style.css';
import api from '../../../services/api';
import Navbar from '../../../components/navbar'

export default function CadastroEvento (){
   
    const [nome, setNome] = useState('');
    const [_local, setLocal] = useState('');
    const [_data,setData] = useState('');
    const [horario, setHorario] = useState('');
    
  
async function  handleRegister(e) {
        e.preventDefault();

        const env = { 
            nome,
            _local,
            _data,
            horario,
        };

      const response = await api.post('cadastrarEvento', env); 
      console.log(response);
      alert("Cadastrado com sucesso");

  }

 


  return (
        <>
          <Navbar  className="container"/>
            <div className="container">

                <form onSubmit={handleRegister} className="formContainer">
                    <h1>Cadastro de Evento</h1>
                    <div className="form-row">
                        <div className="col-sm-9">
                            <label className="col-form-label" for="inputDefault">Nome</label>
                            <input name = "nome"  type="text" className="form-control" value ={nome} onChange={e => setNome(e.target.value)} />
                        </div>
                    </div>
                    <div className="form-row ">
                        <div className="col-sm-3">
                            <label className="col-form-label" for="inputDefault">Local</label>
                            <input name = "local" type="text" className="form-control inputForm" value = {_local} onChange={e => setLocal(e.target.value)}/>
                        </div>


                        <div className="col-sm-3">
                            <label className="col-form-label" for="inputDefault">Data</label>
                            <input name = "data" type="date" className="form-control inputForm" value = {_data} onChange={e => setData(e.target.value)} />
                        </div>

                        <div className="col-sm-3">
                            <label className="col-form-label" for="inputDefault">Horário</label>
                            <input name = "horario" type="text" className="form-control  "  value = {horario} onChange={e => setHorario(e.target.value)} />
                                                                                           
                        </div>
                    </div>

                    <button className="botaoCadastro" type="submit" >Cadastrar</button>
                    <button className="botaoLista" >
                        <Link className="a" to="/listarEvento">Lista de eventos</Link></button>
                </form>



            </div >
            </>
        );
  }
