package com.connection.databaseconnection.convidado;


import com.connection.databaseconnection.evento.Evento;
import org.springframework.data.repository.CrudRepository;

public interface ConvidadoRepository extends CrudRepository<Convidado,String> {
    Iterable<Convidado> findByEvento(Evento evento);
    Convidado findByRg(String rg);

}