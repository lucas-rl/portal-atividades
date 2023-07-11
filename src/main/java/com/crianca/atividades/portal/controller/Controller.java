package com.crianca.atividades.portal.controller;

import com.crianca.atividades.portal.controller.data.AtividadePdfRequest;
import com.crianca.atividades.portal.controller.data.AtividadeRequest;
import com.crianca.atividades.portal.controller.data.AtividadeResponse;
import com.crianca.atividades.portal.gateway.data.AtividadeModel;
import com.crianca.atividades.portal.gateway.data.CategoriaModel;
import com.crianca.atividades.portal.usecase.ArquivoUseCase;
import com.crianca.atividades.portal.usecase.AtividadeUseCase;
import com.crianca.atividades.portal.usecase.CategoriaUseCase;
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

    private final ArquivoUseCase arquivoUseCase;
    private final AtividadeUseCase atividadeUseCase;
    private final CategoriaUseCase categoriaUseCase;

    public Controller(ArquivoUseCase arquivoUseCase, AtividadeUseCase atividadeUseCase, CategoriaUseCase categoriaUseCase){
        this.arquivoUseCase = arquivoUseCase;
        this.atividadeUseCase = atividadeUseCase;
        this.categoriaUseCase = categoriaUseCase;
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
    ResponseEntity<AtividadeModel> saveAtividade(@RequestBody AtividadeRequest request){
        return new ResponseEntity<AtividadeModel>(atividadeUseCase.saveAtividade(request), HttpStatusCode.valueOf(201));
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

    @GetMapping("/categoria")
    ResponseEntity<List<CategoriaModel>> getCategorias(){
        return ResponseEntity.ok(categoriaUseCase.getCategorias());
    }

    @PostMapping("/categoria")
    ResponseEntity<CategoriaModel> saveCategoria(@RequestBody CategoriaModel model){
        return new ResponseEntity<CategoriaModel>(categoriaUseCase.saveCategoria(model), HttpStatusCode.valueOf(201));
    }


}
