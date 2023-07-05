package com.crianca.atividades.portal.controller;

import com.crianca.atividades.portal.controller.data.AtividadePdfRequest;
import com.crianca.atividades.portal.controller.data.AtividadeRequest;
import com.crianca.atividades.portal.controller.data.AtividadeResponse;
import com.crianca.atividades.portal.gateway.AtividadesRepository;
import com.crianca.atividades.portal.gateway.data.AtividadeModel;
import com.crianca.atividades.portal.usecase.ArquivoUseCase;
import com.crianca.atividades.portal.usecase.AtividadeUseCase;
import com.crianca.atividades.portal.usecase.data.AtividadePdfInput;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/atividades")
@Tag(name = "Atividades")
public class Controller {

    private final AtividadesRepository repository;
    private final ArquivoUseCase arquivoUseCase;
    private final AtividadeUseCase atividadeUseCase;

    public Controller(AtividadesRepository repository, ArquivoUseCase arquivoUseCase, AtividadeUseCase atividadeUseCase){
        this.repository = repository;
        this.arquivoUseCase = arquivoUseCase;
        this.atividadeUseCase = atividadeUseCase;
    }

    @GetMapping
    ResponseEntity<List<AtividadeResponse>> getAtividades(){
        List<AtividadeModel> atividades = atividadeUseCase.getAtividades();

        List<AtividadeResponse> response = atividades.stream()
                .map(atividade -> new AtividadeResponse(atividade.getId(), atividade.getNome(), atividade.getCategoria().getNome()))
                .toList();

        return ResponseEntity.ok(response);
    }

    @PostMapping
    ResponseEntity saveAtividade(@RequestBody AtividadeRequest request){
        atividadeUseCase.saveAtividade(request);
        return new ResponseEntity(HttpStatusCode.valueOf(201));

    }

    @PostMapping("/pdf")
    ResponseEntity savePdfAtividade(@RequestBody AtividadePdfRequest request){
        AtividadePdfInput input = new AtividadePdfInput(request.getId(), request.getArquivo());
        arquivoUseCase.savePdf(input);
        return new ResponseEntity(HttpStatusCode.valueOf(201));
    }

    @GetMapping("/pdf/{id}")
    ResponseEntity<String> getAtivdadePdf(@PathVariable Integer id){
        String arquivo = arquivoUseCase.getPdf(id);
        return ResponseEntity.ok(arquivo);
    }

}
