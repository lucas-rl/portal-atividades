package com.crianca.atividades.portal.gateway;

import com.crianca.atividades.portal.gateway.data.AtividadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadesRepository extends JpaRepository<AtividadeModel, Integer> {

}
