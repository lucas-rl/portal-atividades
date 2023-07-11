package com.crianca.atividades.portal.usecase;

import com.crianca.atividades.portal.gateway.CategoriasRepository;
import com.crianca.atividades.portal.gateway.data.CategoriaModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaUseCase {
    private CategoriasRepository categoriasRepository;

    public CategoriaUseCase(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    public CategoriasRepository getCategoriasRepository() {
        return categoriasRepository;
    }

    public void setCategoriasRepository(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    public List<CategoriaModel> getCategorias(){
        return categoriasRepository.findAll();
    }

    public CategoriaModel saveCategoria(CategoriaModel model){
        return categoriasRepository.save(model);
    }

}
