package com.connection.databaseconnection.associative.conhecimento;

import com.connection.databaseconnection.conhecimento.Conhecimento;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConhecimentoUsuarioRepository extends JpaRepository<ConhecimentoUsuario, Long> {

    @Query(" select c from ConhecimentoUsuario c left join fetch c.conhecimento uk" +
            "left join fetch c.usuario u where u.id = :param ")
    List<ConhecimentoUsuario>  findConhecimentoById( @Param("param") Long id);

    @Query(" select c from ConhecimentoUsuario c left join fetch c.usuario u" +
            "left join fetch c.conhecimento uk where uk.id_conhecimento = :param ")
    List<ConhecimentoUsuario> findByIdKnowId(@Param("param")long id_conhecimento);


}
