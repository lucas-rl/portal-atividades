package com.crianca.atividades.portal.usecase;

import com.crianca.atividades.portal.gateway.AtividadesRepository;
import com.crianca.atividades.portal.gateway.data.AtividadeModel;
import com.crianca.atividades.portal.usecase.data.AtividadePdfInput;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class ArquivoUseCase {
    private AtividadesRepository atividadesRepository;

    public ArquivoUseCase(AtividadesRepository atividadesRepository) {
        this.atividadesRepository = atividadesRepository;
    }

    public void savePdf(AtividadePdfInput input){
        AtividadeModel model = atividadesRepository.getReferenceById(input.getId());
        model.setPdf(Base64.getDecoder().decode(input.getArquivo()));
        atividadesRepository.save(model);
    }

    public String getPdf(Integer id){
        return Base64.getEncoder().encodeToString(atividadesRepository.getReferenceById(id).getPdf());
    }
}
