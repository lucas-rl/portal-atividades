package com.crianca.atividades.portal.gateway;

import com.crianca.atividades.portal.gateway.data.AtividadePdfModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdfRepository extends JpaRepository<AtividadePdfModel, Integer> {
}
