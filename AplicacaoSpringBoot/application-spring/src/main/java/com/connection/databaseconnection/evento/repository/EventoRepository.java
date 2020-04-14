package com.connection.databaseconnection.evento.repository;

import com.connection.databaseconnection.evento.models.Evento;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
public interface EventoRepository extends CrudRepository<Evento, String> {

    Evento findByCodigo(long codigo);
}