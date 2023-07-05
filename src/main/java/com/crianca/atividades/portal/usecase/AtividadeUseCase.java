package com.crianca.atividades.portal.usecase;

import com.crianca.atividades.portal.controller.data.AtividadeRequest;
import com.crianca.atividades.portal.gateway.AtividadesRepository;
import com.crianca.atividades.portal.gateway.data.AtividadeModel;
import com.crianca.atividades.portal.gateway.data.CategoriaModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtividadeUseCase {
    private AtividadesRepository atividadesRepository;

    public AtividadeUseCase(AtividadesRepository atividadesRepository) {
        this.atividadesRepository = atividadesRepository;
    }

    public List<AtividadeModel> getAtividades(){
        return atividadesRepository.findAll();
    }

    public void saveAtividade(AtividadeRequest request){
        AtividadeModel model = new AtividadeModel();
        model.setNome(request.getNome());
        model.setCategoriaId(request.getCategoria());

        atividadesRepository.save(model);
    }
}
