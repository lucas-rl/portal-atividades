package com.crianca.atividades.portal.controller.data;

public class AtividadePdfRequest {
    private Integer id;
    private String arquivo;

    public AtividadePdfRequest(Integer id, String arquivo) {
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
