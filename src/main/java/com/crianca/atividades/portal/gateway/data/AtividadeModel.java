package com.crianca.atividades.portal.gateway.data;

import jakarta.persistence.*;

@Entity(name = "atividades")
public class AtividadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] pdf;

    @ManyToOne
    @JoinColumn(name = "categoria", nullable = false)
    private CategoriaModel categoria;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getPdf() {
        return pdf;
    }

    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }

}

