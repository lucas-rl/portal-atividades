package com.crianca.atividades.portal.controller.data;

public class AtividadeRequest {
    private String nome;
    private Integer categoria;

    public AtividadeRequest(String nome, Integer categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }
}
