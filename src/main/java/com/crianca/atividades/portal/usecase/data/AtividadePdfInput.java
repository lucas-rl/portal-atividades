package com.crianca.atividades.portal.usecase.data;

public class AtividadePdfInput {
    private Integer id;
    private String arquivo;

    public AtividadePdfInput(Integer id, String arquivo) {
        this.id = id;
        this.arquivo = arquivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }
}
