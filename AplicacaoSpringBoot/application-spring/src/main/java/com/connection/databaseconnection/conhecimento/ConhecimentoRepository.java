package com.connection.databaseconnection.conhecimento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConhecimentoRepository extends JpaRepository <Conhecimento, Long> {


}

//    @Query(" select uk.nivel, c.conhecimento from ConhecimentoUsuario as uk, Conhecimento as c" +
////            "join uk.conhecimento c")
////    List findConhecimentoByUser();