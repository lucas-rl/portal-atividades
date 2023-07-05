package com.crianca.atividades.portal.gateway;

import com.crianca.atividades.portal.gateway.data.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends JpaRepository<CategoriaModel, Integer> {
}
