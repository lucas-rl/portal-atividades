package com.crianca.atividades.portal.gateway;

import com.crianca.atividades.portal.gateway.data.AtividadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtividadesRepository extends JpaRepository<AtividadeModel, Integer> {

    @Query("select id, nome, categoria from atividades")
    List<AtividadeModel> getAll();

}
