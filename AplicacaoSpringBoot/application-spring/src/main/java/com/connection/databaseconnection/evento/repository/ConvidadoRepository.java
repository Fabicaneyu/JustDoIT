package com.connection.databaseconnection.evento.repository;

import com.connection.databaseconnection.evento.models.Convidado;
import com.connection.databaseconnection.evento.models.Evento;
import org.springframework.data.repository.CrudRepository;



public interface ConvidadoRepository extends CrudRepository<Convidado,String> {
    Iterable<Convidado> findByEvento(Evento evento);
    Convidado findByRg(String rg);

}