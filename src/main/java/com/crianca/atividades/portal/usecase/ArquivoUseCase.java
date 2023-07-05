package com.crianca.atividades.portal.usecase;

import com.crianca.atividades.portal.gateway.PdfRepository;
import com.crianca.atividades.portal.gateway.data.AtividadePdfModel;
import com.crianca.atividades.portal.usecase.data.AtividadePdfInput;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class ArquivoUseCase {
    private PdfRepository pdfRepository;

    public ArquivoUseCase(PdfRepository pdfRepository) {
        this.pdfRepository = pdfRepository;
    }

    public void savePdf(AtividadePdfInput input){
        AtividadePdfModel model = new AtividadePdfModel();
        model.setId(input.getId());
        model.setArquivo(Base64.getDecoder().decode(input.getArquivo()));
        pdfRepository.save(model);
    }

    public String getPdf(Integer id){
        return Base64.getEncoder().encodeToString(pdfRepository.getReferenceById(id).getArquivo());
    }
}
