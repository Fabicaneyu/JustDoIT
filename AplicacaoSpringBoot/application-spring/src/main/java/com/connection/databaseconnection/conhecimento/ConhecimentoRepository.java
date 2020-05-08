package com.connection.databaseconnection.conhecimento;

import com.connection.databaseconnection.conhecimento.types.TipoConhecimento;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConhecimentoRepository extends JpaRepository <Conhecimento, Long> {

    @Query(" select c from Conhecimento c where c.conhecimento like " + "%" + ":param" + "%")
    List findByKnow(@Param("param") String conhecimento);

    List<Conhecimento> findByTipo(TipoConhecimento tipo);
}

